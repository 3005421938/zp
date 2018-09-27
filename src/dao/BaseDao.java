package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tools.Singleton;

public class BaseDao
{
	
	static {
		String jdbcPath = Singleton.getInstance().getProperty("jdbcPath");
		try {
			Class.forName(jdbcPath);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动记载异常："+e);
		}
	}
	
	protected Connection getConnection() {
		String dbPath = Singleton.getInstance().getProperty("dbPath");
		String dbName = Singleton.getInstance().getProperty("dbName");
		String dbPass = Singleton.getInstance().getProperty("dbPass");
		Connection con = null;
			try {
				con = DriverManager.getConnection(dbPath,dbName,dbPass);
			} catch (SQLException e) {
				System.err.println("数据源加载异常"+e.getMessage());
				e.printStackTrace();
			}
		return con;
	}
	
	
	protected void getCloseAll(Connection con,Statement st,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("结果集关闭异常"+e.getMessage());
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("适配器关闭异常"+e.getMessage());
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("数据源关闭异常"+e.getMessage());
			}
		}
	}
	
	
	protected ResultSet executeQuery(Connection con,PreparedStatement ps,ResultSet rs,String sql,Object...params) {
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("查询时获取数据源失败！"+e1);
		}
		if(params.length>0 && params!=null) {
			for (int i = 0; i < params.length; i++) {
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					System.err.println("占位符赋值失败！："+e);
				}
			}
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("执行查询失败："+e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}
	
	
	protected int executeUpdate(Connection con,PreparedStatement ps,String sql,Object...params) {
		int count = 0 ;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("查询时获取数据源失败！"+e1);
		}
		if(params.length>0 && params!=null) {
			for (int i = 0; i < params.length; i++) {
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					System.err.println("占位符赋值失败！："+e);
				}
			}
		}
		try {
			count = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("执行查询失败："+e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
	
}

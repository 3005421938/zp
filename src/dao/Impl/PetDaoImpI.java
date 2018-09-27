package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;






import dao.BaseDao;
import dao.PetDao;
import entity.Pet;

public class PetDaoImpI extends BaseDao implements PetDao
{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<Pet> findAllPet()
	{
		con = getConnection();
		List<Pet> list = new ArrayList<Pet>();
		String sql = "select * from pet";
		try {
			rs = executeQuery(con,ps,rs,sql);
			while (rs.next()) {
				Pet pet = new Pet();
				pet.setPetId(rs.getInt(1));
				pet.setPetName(rs.getString(2));
				pet.setPetBreed(rs.getString(3));
				pet.setPetSex(rs.getString(4));
				pet.setBirthday(rs.getString(5));
				pet.setDesc(rs.getString(6));
				list.add(pet);
			}
		} catch (Exception e) {
			System.err.println("获取宠物列表失败："+e);
			e.printStackTrace();
		}finally {
			super.getCloseAll(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Pet> findByBreed(String breed)
	{
		con = getConnection();
		List<Pet> list = new ArrayList<Pet>();
		String sql = "select * from pet where petBreed = ?";
		try {
			rs = executeQuery(con,ps,rs,sql, breed);
			while (rs.next()) {
				Pet pet = new Pet();
				pet.setPetId(rs.getInt(1));
				pet.setPetName(rs.getString(2));
				pet.setPetBreed(rs.getString(3));
				pet.setPetSex(rs.getString(4));
				pet.setBirthday(rs.getString(5));
				pet.setDesc(rs.getString(6));
				list.add(pet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("根据品种查询失败："+e);
		}finally {
			super.getCloseAll(con, ps, rs);
		}
		return list;
	}

	@Override
	public int addPet(Pet pet)
	{
		con = getConnection();
		String sql = "INSERT INTO pet(`petName`,petBreed,petSex,birthday,`desc`) VALUES(?,?,?,?,?)";
		int count = 0;
		try {
			count = executeUpdate(con,ps,sql, pet.getPetName(),pet.getPetBreed(),pet.getPetSex(),pet.getBirthday(),pet.getDesc());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getCloseAll(con, ps, null);
		}
		return count;
	}

	@Override
	public Pet findByName(String name)
	{
		con = getConnection();
		String sql = "select * from pet where petName = ?";
		Pet pet = null;
		try {
			rs = executeQuery(con,ps,rs,sql, name);
			while (rs.next()) {
				pet = new Pet();
				pet.setPetId(rs.getInt(1));
				pet.setPetName(rs.getString(2));
				pet.setPetBreed(rs.getString(3));
				pet.setPetSex(rs.getString(4));
				pet.setBirthday(rs.getString(5));
				pet.setDesc(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("根据品种名称失败："+e);
		}finally {
			super.getCloseAll(con, ps, rs);
		}
		return pet;
	}

}

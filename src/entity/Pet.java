package entity;

import java.io.Serializable;

public class Pet implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	private int petId;			
	private String petName;	
	private String petBreed;
	private String petSex;
	private String birthday;
	private String desc;
	
	public int getPetId()
	{
		return petId;
	}
	public void setPetId(int petId)
	{
		this.petId = petId;
	}
	public String getPetName()
	{
		return petName;
	}
	public void setPetName(String petName)
	{
		this.petName = petName;
	}
	public String getPetBreed()
	{
		return petBreed;
	}
	public void setPetBreed(String petBreed)
	{
		this.petBreed = petBreed;
	}
	public String getPetSex()
	{
		return petSex;
	}
	public void setPetSex(String petSex)
	{
		this.petSex = petSex;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
}

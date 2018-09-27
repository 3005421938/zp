package service;

import java.util.List;

import entity.Pet;

public interface PetService
{
	/**
	 * 查询所有宠物的方法
	 * @return 宠物列表
	 */
	List<Pet> getFindAllPets();
	
	/**
	 * 根据品种查询所有宠物
	 * @param breed 品种
	 * @return 宠物列表
	 */
	List<Pet> getFindBybreed(String breed);
	
	/**
	 * 添加宠物的方法
	 * @param pet 宠物实体
	 * @return 受影响行数
	 */
	int getAddPet(Pet pet);

	
	
	boolean getPetName(String name);
	
	
}

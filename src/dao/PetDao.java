package dao;

import java.util.List;

import entity.Pet;

public interface PetDao
{
	/**
	 * 查询所有宠物的方法
	 * @return 宠物列表
	 */
	List<Pet> findAllPet();
	
	/**
	 * 根据品种查询所有宠物
	 * @param breed 品种
	 * @return 宠物列表
	 */
	List<Pet> findByBreed(String breed);
	
	/**
	 * 添加宠物的方法
	 * @param pet 宠物实体
	 * @return 受影响行数
	 */
	int addPet(Pet pet);
	
	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	Pet findByName(String name);
}

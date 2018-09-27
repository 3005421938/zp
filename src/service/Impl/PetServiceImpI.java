package service.Impl;

import java.util.List;

import dao.PetDao;
import dao.Impl.PetDaoImpI;
import service.PetService;
import entity.Pet;

public class PetServiceImpI implements PetService
{
	private	PetDao pet = new PetDaoImpI();
	
	@Override
	public List<Pet> getFindAllPets()
	{
		List<Pet> list = null;
		try {
			list = pet.findAllPet();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Pet> getFindBybreed(String breed)
	{
		List<Pet> list = null;
		try {
			list = pet.findByBreed(breed);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return list;
	}

	@Override
	public int getAddPet(Pet pet)
	{
		int count = 0;
		try {
			count = this.pet.addPet(pet);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return count;
	}

	@Override
	public boolean getPetName(String name)
	{
		boolean flag;
		Pet pet1 = pet.findByName(name);
		if(pet1 == null) {
			flag = false;
		}else {
			flag = true;
		}
		return flag;
	}
	
	/*public static void main(String[] args)
	{
		System.out.println(new PetServiceImpI().getPetName("豆大大"));
	}*/
}

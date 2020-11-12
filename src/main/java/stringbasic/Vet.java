package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    private boolean areEquals(Pet pet, Pet anotherPet){
        return pet.getRegNumber().equals(anotherPet.getRegNumber());
    }

    public void add(Pet pet){
      for (Pet search : pets){
          if(areEquals(search,pet)){
              return;
          }
      }
      pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }
}

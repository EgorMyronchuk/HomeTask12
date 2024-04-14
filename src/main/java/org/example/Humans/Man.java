package org.example.Humans;

import org.example.Pets.Pet;

import java.util.Map;

public final class Man extends Human{

    public Man(String name, String surname, long birthDate) {
        super(name , surname , birthDate);
    }

    public Man(String name, String surname, long birthDate, int iq) {
        super(name , surname , birthDate , iq);
    }
    public Man(String name , String surname , String birthDate , int iq){super(name,surname,birthDate,iq);}

    public Man(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name , surname , year , iq , schedule);
    }
    @Override
    public void greetPet() {
        for (Pet pets : getFamily().getPet()) System.out.printf("О привіт друже , як в тебе справи  %s \n", pets.getNickname());
    }
    public void repairCar (){
        System.out.println("Мені потрібно полагодити автомобіль");
    }
}

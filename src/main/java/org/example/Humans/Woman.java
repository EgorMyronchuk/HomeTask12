package org.example.Humans;

import org.example.Pets.Pet;

import java.io.Serializable;
import java.util.Map;

public final class Woman extends Human implements Serializable {
    public Woman(String name, String surname, long birthDate) {
        super(name , surname , birthDate);
    }
    public Woman(String name , String surname , String birthDate , int iq){super(name,surname,birthDate,iq);}
    public Woman(String name, String surname, long birthDate, int iq) {
        super(name , surname , birthDate , iq);
    }

    public Woman(String name, String surname, int year, int iq, Map<String,String> schedule) {
        super(name , surname , year , iq , schedule);
    }
    @Override
    public void greetPet() {
        for (Pet pets : getFamily().getPet()) System.out.printf("Іди сюди чудо моє ,як ти  %s \n", pets.getNickname());
    }
    public void makeup (){
        System.out.println("Почекай мені треба зробити makeup");
    }

}

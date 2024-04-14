package org.example.Pets;

public class Dog extends Pet implements Fouling {

    public Dog( String nickname) {
        super(  nickname);
        this.setSpecies(Species.Dog);
    }
    public Dog( String nickname, int age, int trickLevel, String habits) {
        super( nickname , age , trickLevel , habits);
        this.setSpecies(Species.Dog);
    }
    @Override
    public void respond() {

    }
    @Override
    public void foul (){
        System.out.println("Потрібно добре замести сліди розірваного взуття");
    }
}

package org.example.Pets;

public class DomesticCat extends Pet implements Fouling {

    public DomesticCat( String nickname) {
        super(nickname);
        this.setSpecies(Species.DomesticCat);
    }

    public DomesticCat( String nickname, int age, int trickLevel, String habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DomesticCat);
    }

    @Override
    public void foul() {

    }

    @Override
    public void respond() {

    }
}

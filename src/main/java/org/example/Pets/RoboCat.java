package org.example.Pets;

public class RoboCat extends Pet{
    private Species species = Species.RoboCat;
    public RoboCat( String nickname) {
        super( nickname);
        this.setSpecies(Species.RoboCat);
    }

    public RoboCat( String nickname, int age, int trickLevel, String habits) {
        super( nickname, age, trickLevel, habits);
        this.setSpecies(Species.RoboCat);
    }

    @Override
    public void respond() {

    }
}

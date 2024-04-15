package org.example.Pets;

import java.io.Serializable;

public class RoboCat extends Pet implements Serializable {
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

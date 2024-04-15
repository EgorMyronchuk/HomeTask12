package org.example.Pets;

import java.io.Serializable;

public class Fish extends Pet implements Serializable {

    public Fish( String nickname) {
        super(nickname);
        this.setSpecies(Species.Fish);
    }

    public Fish( String nickname, int age, int trickLevel, String habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.Fish);
    }

    @Override
    public void respond() {

    }
}

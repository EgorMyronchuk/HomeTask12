package org.example.Pets;



import org.example.Humans.Family;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    private Species species ;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits = new HashSet<>();

    private Family family;

    {this.species = Species.UNKNOWN;}

    public Pet( String nickname) {
        this.nickname = nickname;
    }

    public Pet( String nickname, int age, int trickLevel, String habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits.add(habits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Objects.equals(family, pet.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel, family);
        result = 31 * result + habits.hashCode();
        return result;
    }

    // Геттеры
    public Species getSpecies() {
        return species;
    }

    public Family getFamily() {
        return family;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    // Сеттеры
    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я ї'м!");
    }

    public abstract void respond();

    @Override
    public String toString() {
        return   species.name() + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits.toString() +
                '}';
    }

    @Override
    protected void finalize() {
        System.out.println(this);
    }
}
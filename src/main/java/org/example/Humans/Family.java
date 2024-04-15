package org.example.Humans;


import org.example.Pets.Pet;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    Woman mother;
    Man father;
    List<Human> children = new ArrayList<>();
    Set<Pet> pet = new HashSet<>();

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Family(Woman mother, Man father, Set<Pet> pet, List<Human> children) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        this.pet = pet;
        for (Pet pets : pet) {
            pets.setFamily(this);
        }
        this.children = children;
        for (Human childrens : children) {
            childrens.setFamily(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.equals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + children.hashCode();
        return result;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public void setPet(Pet pet) {
        this.pet.add(pet);
    }

    public Woman getMother() {
        return mother;
    }

    public Man getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.size()) {
            children.remove(index);
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human human) {
        return children.remove(human);
    }


    public int countFamily() {
        if (!pet.isEmpty()) {
            return 2 + pet.size() + children.size();
        }
        return 2 + children.size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "\nmother=" + mother +
                ",\nfather=" + father +
                ",\nchildren=" + children.toString() +
                ",\npet=" + pet +
                '}';
    }

    public String prettyFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("Family{");
        builder.append("mother: ").append(mother.prettyFormat()).append(",\n");
        builder.append("father: ").append(father.prettyFormat()).append(",\n");
        builder.append("children: \n");
        for (Human child : children) {
            if (child instanceof Man) {
                builder.append("\tboy: ").append(child).append("\n");
            } else if (child instanceof Woman) {
                builder.append("\tgirl: ").append(child).append("\n");
            }
        }
        builder.append("pets: ").append(pet);
        builder.append("}");
        return builder.toString();
    }


    @Override
    protected void finalize() {
        System.out.println(this);
    }

}
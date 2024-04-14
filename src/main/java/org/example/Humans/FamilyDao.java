package org.example.Humans;

import org.example.Pets.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyDao {
 //   getAllFamilies  getFamilyByIndex deleteFamily deleteFamily saveFamily

    public List<Family> getAllFamilies ();
    public Family getFamilyByIndex (int familyIndex);
    public  boolean deleteFamily (int familyIndex);
    public boolean deleteFamily (Family family);
    public void saveFamily (Family family);
    public void displayAllFamilies ();
    public List<Family> getFamiliesBiggerThan (int numberOfMember);
    public List<Family> getFamiliesLessThan (int numberOfMember);
    public int countFamiliesWithMemberNumber (int numberOfMember);
    public void createNewFamily (Woman mother , Man father); // У мене консруктор Family розраховує на обьект типу Woman,Man.
                                                             // якщо я тут зроблю тип Human можуть бути помилки
    public Family bornChild (Family family, String maleName , String femaleName);
    public Family adoptChild (Family family , Human child) ;
    public void deleteAllChildrenOlderThen (int olderThenAge);
    public int count ();
    public Family getFamilyById(int familyIndex);
    public Set<Pet> getPets (int numberOfPets);
    public void addPet (int familyIndex , Pet pet);
    //public void loadData ();
    public void loadDataBaseFromFile();












}

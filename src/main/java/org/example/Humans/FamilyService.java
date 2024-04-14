package org.example.Humans;

import org.example.Pets.Pet;

import java.util.List;
import java.util.Set;

public class FamilyService {
    private final FamilyDao familyDao;
    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }
    public List<Family> getAllFamilies (){
        return familyDao.getAllFamilies();
    }
    public void displayAllFamilies(){
        familyDao.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int numberOfMember){
       return familyDao.getFamiliesBiggerThan(numberOfMember);
    }
    public List<Family> getFamiliesLessThan(int numberOfMember){
       return familyDao.getFamiliesLessThan(numberOfMember);
    }
    public int countFamiliesWithMemberNumber(int numberOfMember){
        return familyDao.countFamiliesWithMemberNumber(numberOfMember);
    }
    public void createNewFamily(Woman mother, Man father){
        familyDao.createNewFamily(mother,father);
    }
    public Family getFamilyByIndex (int familyIndex) {
        return familyDao.getFamilyById(familyIndex);
    }
    public Family bornChild(Family family, String maleName, String femaleName){
        return familyDao.bornChild(family,maleName,femaleName);
    }
    public Family adoptChild(Family family, Human child){
        return familyDao.adoptChild(family,child);
    }
    public void deleteAllChildrenOlderThen(int olderThenAge){
        familyDao.deleteAllChildrenOlderThen(olderThenAge);
    }
    public int count(){
        return familyDao.count();
    }
    public Family getFamilyById(int familyIndex){
        return familyDao.getFamilyById(familyIndex);
    }
    public Set<Pet> getPets(int familyIndex){
        return familyDao.getPets(familyIndex);
    }
    public void addPet(int familyIndex, Pet pet){
        familyDao.addPet(familyIndex,pet);
    }
    public void deleteFamilyByIndex (int familyIndex){
        familyDao.deleteFamily(familyIndex);
    }
}

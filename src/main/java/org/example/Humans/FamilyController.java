package org.example.Humans;

import org.example.Pets.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int numberOfMembers) {
       return familyService.getFamiliesBiggerThan(numberOfMembers);
    }

    public List<Family> getFamiliesLessThan(int numberOfMembers) {
       return familyService.getFamiliesLessThan(numberOfMembers);
    }

    public int countFamiliesWithMemberNumber(int numberOfMembers) {
        return familyService.countFamiliesWithMemberNumber(numberOfMembers);
    }

    public void createNewFamily(Woman mother, Man father) {
            familyService.createNewFamily(mother, father);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        if(family.countFamily() == 4){
           throw new FamilyOverflowException();
        }
        else {
            return familyService.bornChild(family, maleName, femaleName);
        }
    }

    public Family adoptChild(Family family, Human child) {
        if(family.countFamily() >= 4){
            throw new FamilyOverflowException();

        }
        else {
            return familyService.adoptChild(family, child);
        }

    }

    public void deleteAllChildrenOlderThan(int olderThanAge) {
        familyService.deleteAllChildrenOlderThen(olderThanAge);
    }
    public Family getFamilyByIndex (int familyIndex){
        return familyService.getFamilyByIndex(familyIndex);
    }
    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int familyIndex) {
        return familyService.getFamilyById(familyIndex);
    }

    public Set<Pet> getPets(int familyIndex) {
         return familyService.getPets(familyIndex);
    }

    public void addPet(int familyIndex, Pet pet) {
        familyService.addPet(familyIndex, pet);
    }
    public void deleteFamilyByIndex (int familyIndex){
        familyService.deleteFamilyByIndex(familyIndex);
    }
    public void loadDataBaseFromFile() {familyService.loadDataBaseFromFile();}
    public void loadListToDB (List<Family> families){familyService.loadListToDB(families);}
    public void saveDataBaseToFile() {familyService.saveDataBaseToFile();}
}

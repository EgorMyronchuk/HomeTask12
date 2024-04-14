package org.example.Humans;

import org.example.Pets.Pet;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao{
    private final List<Family> dataBase = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return dataBase;
    }

    @Override
    public Family getFamilyByIndex(int familyIndex) {
        if(dataBase.get(familyIndex) != null){
            dataBase.remove(dataBase.get(familyIndex));
            return dataBase.get(familyIndex);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int familyIndex) {
        if (familyIndex >= 0 && familyIndex < dataBase.size()) {
            saveDataBaseToFile();
            dataBase.remove(familyIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        saveDataBaseToFile();
        return dataBase.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if(dataBase.contains(family)){
            dataBase.set(dataBase.indexOf(family) ,family);
        }
        else {
            dataBase.add(family);
        }
        saveDataBaseToFile();
    }

    @Override
    public void displayAllFamilies() {
        System.out.println(dataBase.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n")));
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int numberOfMember) {
       return dataBase.stream()
                .filter(x -> x.countFamily() > numberOfMember)
                .collect(Collectors.toList());
    }

    @Override
    public List<Family> getFamiliesLessThan(int numberOfMember) {
        return dataBase.stream()
                .filter(x -> x.countFamily() < numberOfMember)
                .collect(Collectors.toList());
    }

    @Override
    public int countFamiliesWithMemberNumber(int numberOfMember) {
        return dataBase.stream()
                .filter(x -> x.countFamily() == numberOfMember)
                .mapToInt(x -> 1)
                .sum();
    }

    @Override
    public void createNewFamily(Woman mother, Man father) {
        Family familyResult = new Family(mother,father);
        saveFamily(familyResult);
    }

    @Override
    public Family bornChild(Family family, String maleName, String femaleName) {
        Random random = new Random();
        Human children ;
        if( random.nextDouble() > 0.5){
            children = new Man(maleName , family.getFather().getSurname() , 0 );
        }
        else {
            children = new Woman(femaleName , family.getFather().getSurname() , 0 );
        }
        family.setChildren(children);
        saveFamily(family);
        return family;
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        family.setChildren(child);
        saveFamily(family);
        return family;
    }

    @Override
    public void deleteAllChildrenOlderThen(int olderThenAge) {
        getAllFamilies().forEach(family -> {
            family.getChildren()
                    .removeIf(child -> {
                        LocalDate currentDate = LocalDate.now();
                        LocalDate birthDate = Instant.ofEpochMilli(child.getYear()).atZone(ZoneId.systemDefault()).toLocalDate();
                        Period period = Period.between(birthDate, currentDate);
                        int age = period.getYears();
                        return age > olderThenAge;
                    });
            saveFamily(family);
        });
    }
    @Override
    public int count() {
        return dataBase.size();
    }

    @Override
    public Family getFamilyById(int familyIndex) {
        return dataBase.get(familyIndex);
    }

    @Override
    public Set<Pet> getPets(int familyIndex) {

        if ( dataBase.get(familyIndex).getPet().isEmpty()){
            return null;
        }
        else {
               return dataBase.get(familyIndex).getPet();
        }
    }

    @Override
    public void addPet(int familyIndex, Pet pet) {
        dataBase.get(familyIndex).setPet(pet);
    }
    private void saveDataBaseToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("File.txt"))) {
            oos.writeObject(dataBase); // Сериализуем коллекцию в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadDataBaseFromFile() {
        File file = new File("File.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("File.txt"))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    List<?> loadedData = (List<?>) obj;
                    for (Object item : loadedData) {
                        if (item instanceof Family) {
                            dataBase.add((Family) item);
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Не правильно задані файли або файл пустий");
            }
        }
    }
}

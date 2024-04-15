package org.example;


import org.example.Humans.*;
import org.example.Pets.Dog;
import org.example.Pets.DomesticCat;
import org.example.Pets.Pet;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyDao Dao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(Dao);
        FamilyController familyController = new FamilyController(familyService);
        String input;
        while (true) {
            System.out.println(getMenuText());
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершена.");
                break;
            }
            try {
                int number = Integer.parseInt(input);
                switch (number) {
                    case 1: {
                        Woman wom1 = new Woman("Lena", "Kyky", "22/10/2004", 15);
                        Man man = new Man("Anton", "Brazilia", "22/10/2004", 12);
                        Man child1 = new Man("Egor", "Borishpol", "11/11/2003", 22);
                        Woman child2 = new Woman("fds", "dsads", "11/11/2002", 22);
                        familyController.createNewFamily(wom1, man);
                        familyController.getFamilyById(0).addChild(child1);
                        Man father2 = new Man("Evgen", "Brazilia", "01/10/2004", 12);
                        Woman mother2 = new Woman("Lena", "Kyky", "02/10/2004", 15);
                        familyController.createNewFamily(mother2, father2);
                    }
                    break;
                    case 2: {
                        List<Family> families = Dao.getAllFamilies();
                        IntStream.range(0, families.size())
                                .forEach(index -> {
                                    Family family = families.get(index);
                                    System.out.println((index + 1) + ". " + family.prettyFormat());
                                });
                    }
                    break;
                    case 3: {
                        System.out.println("Ведіть кількість людей:");
                        List<Family> biggerList = familyController.getFamiliesBiggerThan(Integer.parseInt(scanner.nextLine().trim()));
                        biggerList.forEach(x -> System.out.println(x.prettyFormat()));
                    }
                    break;
                    case 4: {
                        System.out.println("Ведіть кількість людей:");
                        List<Family> lessList = familyController.getFamiliesLessThan(Integer.parseInt(scanner.nextLine().trim()));
                        lessList.forEach(x -> System.out.println(x.prettyFormat()));
                    }
                    break;
                    case 5: {
                        System.out.println("Ведіть кількість людей:");
                        int numberOfFamilies = familyController.countFamiliesWithMemberNumber(Integer.parseInt(scanner.nextLine().trim()));
                        System.out.printf("Кількість сімей заданою кількістью людей :%d", numberOfFamilies);
                    }
                    break;
                    case 6:
                        System.out.println("Потрібно ввести дані для створення сім'ї");
                        Woman mother = (Woman) createPerson("матері");
                        Man father = (Man) createPerson("батька");
                        familyController.createNewFamily(mother, father);
                        break;
                    case 7:
                        System.out.println("Сім'ю за яким індексом ви хочите видалити ?");
                        familyController.deleteFamilyByIndex(Integer.parseInt(scanner.nextLine().trim()) - 1);
                        break;
                    case 8:
                        StringBuilder build = new StringBuilder();
                        build.append("   - 1. Народити дитину\n");
                        build.append("   - 2. Усиновити дитину\n");
                        build.append("   - 3. Повернутися до головного меню\n");
                        System.out.println(build.toString());
                        switch (Integer.parseInt(scanner.nextLine().trim())) {
                            case 1:{
                                System.out.println("Який номер сім'ї ми будемо редагувати ?");
                                int numberOfFamily = Integer.parseInt(scanner.nextLine().trim()) - 1;
                                System.out.println("Яке ім'я дати хлопчику");
                                String maleName = scanner.nextLine().trim();
                                System.out.println("Яке дівчинці");
                                String femaleName = scanner.nextLine().trim();
                                familyController.bornChild(familyController.getFamilyById(numberOfFamily),maleName,femaleName);}
                                break;
                            case 2:{
                                System.out.println("Який номер сім'ї ми будемо редагувати ?");
                                int numberOfFamily = Integer.parseInt(scanner.nextLine().trim()) - 1;
                                System.out.println("Ви бажаєте всиновити дівчинку чи хлопчика?");
                                String sex = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

                                if(sex.equals("дівчинку")){
                                    Woman mother1 = (Woman) createPerson("дівчинки");
                                    familyController.adoptChild(familyController.getFamilyByIndex(numberOfFamily),mother1);
                                }
                                else {
                                    Man father1 = (Man) createPerson("хлопчика");
                                    familyController.adoptChild(familyController.getFamilyByIndex(numberOfFamily),father1);
                                }
                                break;
                            }
                            case 3:
                                continue;

                        }
                        break;
                    case 9:{
                        System.out.println("Старше якого віку ви хочите видалити дітей?");
                        familyController.deleteAllChildrenOlderThan(Integer.parseInt(scanner.nextLine().trim()));
                        break;
                    }
                    case 10:{
                        familyController.saveDataBaseToFile();
                        break;
                    }
                    case 11:{
                        familyController.loadDataBaseFromFile();
                        break;
                    }
                    case 12:  // Не зовсім зрозумів цей пункт і чи потрібно його сюди додавати . Я зрозумів це так :
                    {
                        System.out.println("Заповнюємо лист сімей щоб його додати");
                        List<Family> temp = new ArrayList<>();
                        boolean exit = true;
                        while (true){
                            System.out.println("Ви хочите додати сім'ю у списко (Так/Ні)");
                            if (scanner.nextLine().trim().toLowerCase().charAt(0) == 'т'){
                                Woman motherForLoad = (Woman) createPerson("матері");
                                Man fatherForLoad = (Man) createPerson("батька");
                                Family fam = new Family(motherForLoad , fatherForLoad);
                                temp.add(fam);
                            }
                            else {
                                break;
                            }
                        }
                        familyController.loadListToDB(temp);
                    }
                }



            } catch (NumberFormatException e) {
                System.out.println("Ведене число не є значинням або 'exit'. Спробуйте ще раз.");
            } catch (FamilyOverflowException e) {
                System.out.println("Ви досягли максимального розміру сім'ї");
            }
            catch (DateTimeParseException e) {
                System.out.println("Ошибка при разборе даты. Убедитесь, что вы ввели дату в корректном формате dd/MM/yyyy.");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Ви задали не правильний номер сім'ї");
            }
            System.out.println("\n");
            System.out.println("\n");
        }
        scanner.close();
    }

    public static String getMenuText() {
        StringBuilder menu = new StringBuilder();

        menu.append("- 1. Заповнити тестовими даними\n");
        menu.append("- 2. Відобразити весь список сімей\n");
        menu.append("- 3. Відобразити список сімей, де кількість людей більша за задану\n");
        menu.append("- 4. Відобразити список сімей, де кількість людей менша за задану\n");
        menu.append("- 5. Підрахувати кількість сімей, де кількість членів дорівнює\n");
        menu.append("- 6. Створити нову родину\n");
        menu.append("- 7. Видалити сім'ю за індексом сім'ї у загальному списку\n");
        menu.append("- 8. Редагувати сім'ю за індексом сім'ї у загальному списку\n");
        menu.append("- 9. Видалити всіх дітей старше віку\n");
        menu.append("- 10.Завантажити файли на комп'ютер\n");
        menu.append("- 11.Завантажити раніше збережені дані\n");
        menu.append("- 12.Додати лист у нашу базу даних\n");

        return menu.toString();
    }

    private static Human createPerson(String role) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ім'я " + role);
        String name = scanner.nextLine().trim();
        System.out.println("Прізвище " + role);
        String surname = scanner.nextLine().trim();
        System.out.println("Рік народження " + role + " У вигляді чотирьох чисел");
        String yearsOfBirth = scanner.nextLine().trim();
        System.out.println("Місяць народження " + role + " У вигляді двох чисел");
        String monthOfBirth = scanner.nextLine().trim();
        System.out.println("День народження " + role + " У вигляді двох чисел");
        String dayOfBirth = scanner.nextLine().trim();
        System.out.println("IQ " + role);
        int iq = Integer.parseInt(scanner.nextLine().trim());

        StringBuilder builder = new StringBuilder();
        builder.append(dayOfBirth).append("/").append(monthOfBirth).append("/").append(yearsOfBirth);

        if (role.equals("матері") || role.charAt(0) == 'Д') {
            return new Woman(name, surname, builder.toString(), iq);
        }
        else {
            return new Man(name, surname, builder.toString(), iq);
        }
    }
}


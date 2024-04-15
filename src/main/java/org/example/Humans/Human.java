package org.example.Humans;



import org.example.Pets.Pet;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<String,String> schedule = new HashMap<String,String>();

    public String getFormattedBirthDate() {
        // Преобразование long в объект LocalDate
        LocalDate date = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Форматирование даты в строку
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(outputFormatter);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname)  && Objects.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate, iq, family);
        result = 31 * schedule.hashCode();
        return result;
    }

    public Human() {
    }

    public Human(String name, String surname, long year) {
        this.name = name;
        this.surname = surname;
        this.birthDate = year;
    }

    public Human(String name, String surname, long year, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = year;
        this.iq = iq;

    }

    public Human(String name, String surname, long year, int iq, Map<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = year;
        this.iq = iq;
        this.schedule = schedule;
    }
    // Конструктор для усиновлених дітей
    public Human (String name , String surname , String birthDate , int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDate, formatter);
        this.birthDate = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getYear() {
        return birthDate;
    }

    public int getIq() {
        return iq;
    }

    public Family getFamily() {
        return family;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(long birthDate) {
        this.birthDate = birthDate;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setSchedule(Map<String,String> schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        for (Pet petInd : family.pet)  System.out.printf("Привіт, %s \n", petInd.getNickname());
    }
    public void describeAge(){
        LocalDate currentDate = LocalDate.now();

        Instant instant = Instant.ofEpochMilli(birthDate);
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(localDate, currentDate);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.printf("Вік: %d років, %d місяців, %d днів\n", years, months, days);
    }

    public void describePet() {
        for (Pet petInd : family.pet) {
            if (petInd.getTrickLevel() > 50) {
                System.out.printf("У мене є %s, їй %d років, він дуже хитрий", petInd.getSpecies(), petInd.getAge());
            } else {
                System.out.printf("У мене є %s, їй %d років, він майже не хитрий", petInd.getSpecies(), petInd.getAge());
            }
        }
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", BirthDay=" + getFormattedBirthDate() +
                ", iq=" + iq +
                ", schedule=" + schedule.toString() +
                '}';
    }
    public String prettyFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append("name='").append(name).append("\'");
        builder.append(", surname='").append(surname).append("\'");
        builder.append(", BirthDay=").append(getFormattedBirthDate());
        builder.append( ", iq=").append(iq);
        builder.append(", schedule=").append(schedule.toString()).append("}");
        return builder.toString();
    }
    @Override
    protected void finalize() {
        System.out.println(this);
    }
}

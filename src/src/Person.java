package src;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name,String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name,String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return (this.age.isEmpty()) ? false : true;
    }

    public boolean hasAddress() {
        return (this.address == null) ? false : true;
    }

    public String getName() { return this.name;}
    public String getSurname() { return this.surname; }
    public OptionalInt getAge() { return this.age; }
    public String getAddress() { return this.address; }

    public void happyBirthday() {
        if (this.age.isPresent())
            this.age = OptionalInt.of(this.age.getAsInt()+1);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        return child.setSurname(this.surname).setAddress(this.address).setAge(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{ Имя: " + this.name + " Фамилия: " + this.surname);

        if (this.hasAddress()) res.append(" Адрес: " + this.address);
        else res.append(" Адрес не задан ");

        if (this.hasAge()) res.append(" Возраст: "+ this.age.getAsInt());
        else res.append(" Возраст не задан ");

        res.append("}");
        return res.toString();
    }
}

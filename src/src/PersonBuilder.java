package src;

import java.util.OptionalInt;

public class PersonBuilder {
    private String currentName;
    private String currentSurname;
    private OptionalInt currentAge = OptionalInt.empty();
    private String currentAdress;

    public PersonBuilder setName(String name) {
        currentName = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        currentSurname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        currentAge = OptionalInt.of(age);
        return this;
    }
    public PersonBuilder setAddress(String address) {
        currentAdress = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person res = null;
        if ((currentSurname == null)||(currentName == null))throw new IllegalStateException("Can't create person without name/last name");
        if (currentAge.isPresent()) {
            if (currentAge.getAsInt() <0) throw new IllegalArgumentException("Age value is out of range");
            res = new Person(currentName,currentSurname,currentAge);
        }
        else res = new Person (currentName,currentSurname);
        if (currentAdress != null) res.setAddress(currentAdress);
        return res;
    }

}

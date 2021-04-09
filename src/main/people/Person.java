package main.people;

import main.utils.Validator;

import java.util.Objects;

public abstract class Person {
    protected String name;
    protected String phoneNumber;

    public Person(String name, String phoneNumber) {
        if(Validator.isValidString(name)) {
            this.name = name;
        }
        else{
            this.name = "Petar";
        }

        if(Validator.isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else{
            this.phoneNumber = "0885112233";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}

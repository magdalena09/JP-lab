package lab2;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String first_name, String last_name) throws PersonException {
        setFirstName(first_name);
        setLastName(last_name);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) throws PersonException {
        if ((first_name == null) || first_name.equals(""))
            throw new PersonException("Pole <Imię> musi być wypełnione.");
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) throws PersonException {
        if ((last_name == null) || last_name.equals(""))
            throw new PersonException("Pole <Nazwisko> musi być wypełnione.");
        this.lastName = last_name;
    }

    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(int birth_year) throws PersonException {
        if ((birth_year!=0) && (birth_year < 1900 || birth_year > 2030))
            throw new PersonException("Rok urodzenia musi być w przedziale [1900 - 2030].");
        this.birthYear = birth_year;
    }

    public void setBirthYear(String birth_year) throws PersonException {
        if (birth_year == null || birth_year.equals("")){  // pusty łańcuch znaków oznacza rok niezdefiniowany
            setBirthYear(0);
            return;
        }
        try {
            setBirthYear(Integer.parseInt(birth_year));
        } catch (NumberFormatException e) {
            throw new PersonException("Rok urodzenia musi być liczbą całkowitą.");
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Person o) {
        return this.lastName.compareTo(o.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

class PersonException extends Exception {

    private static final long serialVersionUID = 1L;

    public PersonException(String message) {
        super(message);
    }
}


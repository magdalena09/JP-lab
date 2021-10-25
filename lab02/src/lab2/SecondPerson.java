package lab2;

public class SecondPerson implements Comparable<SecondPerson>{
    private String firstName;
    private String lastName;
    private int birthYear;

    public SecondPerson(String first_name, String last_name) throws SecondPersonException {
        setFirstName(first_name);
        setLastName(last_name);
    }

    public void setFirstName(String first_name) throws SecondPersonException {
        if ((first_name == null) || first_name.equals(""))
            throw new SecondPersonException("Pole <Imię> musi być wypełnione.");
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) throws SecondPersonException {
        if ((last_name == null) || last_name.equals(""))
            throw new SecondPersonException("Pole <Nazwisko> musi być wypełnione.");
        this.lastName = last_name;
    }

    public void setBirthYear(int birth_year) throws SecondPersonException {
        if ((birth_year!=0) && (birth_year < 1900 || birth_year > 2030))
            throw new SecondPersonException("Rok urodzenia musi być w przedziale [1900 - 2030].");
        this.birthYear = birth_year;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(SecondPerson o) {
        return this.lastName.compareTo(o.lastName);
    }
}
class SecondPersonException extends Exception {

    private static final long serialVersionUID = 1L;

    public SecondPersonException(String message) {
        super(message);
    }
}
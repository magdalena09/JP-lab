package lab2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    private static final UserDialog userDialog = new UserDialog();

    public static Person person;
    public static SecondPerson secondPerson;

    public static Set<Person> treeSetPerson = new TreeSet<>();          //posortowane dane - w tym przypadku alfabetycznie po nazwisku
    public static Set<Person> hashSetPerson = new HashSet<>();          //nieuporządkowane dane
    public static List<Person> arrayListPerson = new ArrayList<>();
    public static List<Person> linkedListPerson = new LinkedList<>();
    public static Map<String,Person> hashMapPerson = new HashMap<>();   //nieuporządkowane dane
    public static Map<String,Person> treeMapPerson = new TreeMap<>();   //posortowane dane - alfabetycznie
//analogicznie
    public static Set<SecondPerson> treeSetSecondPerson = new TreeSet<>();
    public static Set<SecondPerson> hashSetSecondPerson = new HashSet<>();
    public static List<SecondPerson> arrayListSecondPerson = new ArrayList<>();
    public static List<SecondPerson> linkedListSecondPerson = new LinkedList<>();
    public static Map<String,SecondPerson> hashMapSecondPerson = new HashMap<>();
    public static Map<String,SecondPerson> treeMapSecondPerson = new TreeMap<>();

    private static final String MENU =
            "    M E N U   G Ł Ó W N E  \n" +
                    "1 - Podaj dane nowej osoby \n" +
                    "2 - Usuń dane osoby        \n" +
                    "3 - Wypisz wszystkie osoby \n" +
                    "0 - Zakończ program        \n";

    public void menu(){
        try{
            switch(userDialog.enterInt(MENU)){
                case 1:
                    person = createNewPerson();
                    secondPerson = createNewSecondPerson();
                    System.out.println("Dodano osobę.");
                    menu();
                    break;
                case 2:
                    deletePerson(person);
                    deleteSecondPerson(secondPerson);
                    System.out.println("Usunięto osobę.");
                    menu();
                    break;
                case 3:
                    System.out.println("Zawartość struktur:");
                    show();
                    menu();
                    break;
                case 0:
                    System.out.println("Koniec");
                    System.exit(0);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static Person createNewPerson(){
        String firstName = userDialog.enterString("Podaj imię: ");
        String lastName = userDialog.enterString("Podaj nazwisko: ");
        String birthYear = userDialog.enterString("Podaj rok ur.: ");
        Person person;
        try {
            person = new Person(firstName, lastName);
            person.setBirthYear(birthYear);
            treeSetPerson.add(person);   //zbiory nie dodadzą powtórzonych obiektów, elementy muszą być unikalne - wymagana implementacja hashCode() oraz equals()
            hashSetPerson.add(person);
            arrayListPerson.add(person);
            linkedListPerson.add(person);
            hashMapPerson.put(person.getLastName(),person); //dodanie tego samego klucza powoduje zastąpienie poprzedniej wartości nową
            treeMapPerson.put(person.getLastName(),person);
        } catch (PersonException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return person;
    }

    static SecondPerson createNewSecondPerson(){
        SecondPerson secondPerson;
        try {
            secondPerson = new SecondPerson(person.getFirstName(), person.getLastName());
            secondPerson.setBirthYear(person.getBirthYear());
            treeSetSecondPerson.add(secondPerson);
            hashSetSecondPerson.add(secondPerson);
            arrayListSecondPerson.add(secondPerson);
            linkedListSecondPerson.add(secondPerson);
            hashMapSecondPerson.put(secondPerson.getLastName(),secondPerson);
            treeMapSecondPerson.put(secondPerson.getLastName(),secondPerson);
        } catch (SecondPersonException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return secondPerson;
    }

    static void deletePerson(Person person){  // usuwanie ostatnio wpisanego elementu
        treeSetPerson.remove(person);
        hashSetPerson.remove(person);
        arrayListPerson.remove(person); //usuwa pierwsze wystąpienie
        linkedListPerson.remove(person);//usuwa pierwsze wystąpienie
        hashMapPerson.remove(person.getLastName());
        treeMapPerson.remove(person.getLastName());
    }

    static void deleteSecondPerson(SecondPerson secondPerson){
        treeSetSecondPerson.remove(secondPerson);
        hashSetSecondPerson.remove(secondPerson);
        arrayListSecondPerson.remove(secondPerson);
        linkedListSecondPerson.remove(secondPerson);
        hashMapSecondPerson.remove(secondPerson.getLastName());
        treeMapSecondPerson.remove(secondPerson.getLastName());
    }

    static void show(){    // wypisanie elementow
        System.out.println("KLASA PERSON");
        System.out.println("Zaimplementowane metody hashCode() oraz equals()");
        System.out.print("TreeSet: ");
        for (Person i : treeSetPerson){
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("HashSet: ");
        for (Person i : hashSetPerson){
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("Array List: ");
        System.out.print(arrayListPerson);

        System.out.println();
        System.out.print("Linked List: ");
        System.out.print(linkedListPerson);

        System.out.println();
        System.out.print("Hash Map: ");
        for (Person i : hashMapPerson.values()){  //po zawartościach, keySet() po kluczach
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("Tree Map: ");
        for (Person i : treeMapPerson.values()){
            System.out.print(i + ", ");
        }

        System.out.println("\n\nKLASA SECONDPERSON");
        System.out.println("Brak metod hashCode() oraz equals()");
        System.out.print("TreeSet: ");
        for (SecondPerson i : treeSetSecondPerson){
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("HashSet: ");
        for (SecondPerson i : hashSetSecondPerson){
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("Array List: ");
        System.out.print(arrayListSecondPerson);

        System.out.println();
        System.out.print("Linked List: ");
        System.out.print(linkedListSecondPerson);

        System.out.println();
        System.out.print("Hash Map: ");
        for (SecondPerson i : hashMapSecondPerson.values()){
            System.out.print(i + ", ");
        }System.out.println();

        System.out.print("Tree Map: ");
        for (SecondPerson i : treeMapSecondPerson.values()){
            System.out.print(i + ", ");
        }System.out.println();
    }
}

package Domain;

import java.util.Iterator;

/**
 * Created by Martin on 5/27/2014.
 */
public class Application {
    public static void main(String[] args){
        PersonContainer personContainer = new PersonContainer();
        Iterator<Person> personIterator = personContainer.getPersons();

        System.out.println("Hallo und Willkommen");
        while (personIterator.hasNext()) {
            personIterator.next().printPerson();
        }
    }
}

package Domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 5/27/2014.
 */
public class PersonContainer {
    List<Person> persons = new ArrayList<Person>();
    public PersonContainer(){
        Person identPerson = new Person("Martin", "Schwarzmaier");
        identPerson.
        persons.add(new Person("Martin", "Schwarzmaier"));
        persons.add(new Person("Ulla", "Wege"));
        persons.add(new Person("Florian", "Pircher"));
    }
    public Iterator<Person> getPersons(){
        return persons.iterator();
    }
}

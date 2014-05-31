package Repository;

import Domain.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Martin on 5/31/2014.
 */
public class PersonRepository {
    private HashMap<String, Person> people = new HashMap<String, Person>();

    public void addPerson(String id, Person person){
        people.put(id, person);
    }
    public PersonRepository(){

    }
}

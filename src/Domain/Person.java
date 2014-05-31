package Domain;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 5/27/2014.
 */
public class Person {
    private static int ids=0;
    String firstName;
    String lastName;

    public int getId() {
        return id;
    }

    int id;

    Identifier root;
    public Person(String first, String last){
        firstName = first;
        lastName = last;
        id = Person.createID();
        root = new Identifier("root", "rootIdent");
    }
    private static int createID(){
        ids++;
        return ids;
    }
    public void printPerson(){
        System.out.println("Vorname: "+firstName + "||" + "Nachname: " + lastName + "||" + "ID: " + getId());
    }
    public Identifier getIdentifierByScope(List<String> scope){
        Iterator<String> scopeIterator = scope.iterator();
        Identifier returnIdentifier = root;
        while (scopeIterator.hasNext()){
            returnIdentifier = returnIdentifier.getIdentifierByName(scopeIterator.next());
        }
        return returnIdentifier;
    }
    public Identifier getRoot() {
        return root;
    }

}



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
        System.out.println("Vorname: "+firstName + "||" + "Nachname: " + lastName + "||" + "ID" + id);
    }
    public void addIdentifier(List<String> identList, String value){
        if (identList.size() == 1){
            this.root.addChild(new Identifier(identList.get(1), value));
        }
        if(identList.size() > 1){
            Identifier tempIdent = root;
            Iterator<String> identIterator = identList.iterator();
            while(identIterator.hasNext()){
                tempIdent = tempIdent.getChild(identIterator);
            }
        }

    }
}



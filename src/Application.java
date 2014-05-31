import Domain.Identifier;
import Domain.Person;
import Domain.PersonContainer;
import Repository.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 5/27/2014.
 */
public class Application {
    public static void main(String[] args){
        PersonContainer personContainer = new PersonContainer();
        Iterator<Person> personIterator = personContainer.getPersons();
        HashMap<String, Person> identifierHashMap = new HashMap<String, Person>();

        PersonRepository people = new PersonRepository();


        System.out.println("Hallo und Willkommen");
        while (personIterator.hasNext()) {
            personIterator.next().printPerson();
        }
        System.out.println();
        List<String> testList = Arrays.asList("ID1","P1","Pheno","Test");
        List<String> testList2 = Arrays.asList("Blubs");
        List<String> testList3 = Arrays.asList("Blubs", "P2");

        Identifier root = null;
        personIterator = personContainer.getPersons();
        String lastIdentifier = null;
        for(int i=0; i<3; i++){
            System.out.println("next person");
            Person tempPerson = personIterator.next();
            root = tempPerson.getRoot();
            List<String> returnedNames = root.addChild(testList);
            Iterator<String> namesIterator = returnedNames.iterator();
            while(namesIterator.hasNext()){
                String tmpIdentifier = namesIterator.next();
                identifierHashMap.put(tmpIdentifier, tempPerson);
                lastIdentifier = tmpIdentifier;
            }
        }

        Identifier.printIdentifierTree(root);

        //Lookup Test Begin
        List<String> scope = Arrays.asList("ID1");
        String inputIdentifier = lastIdentifier;
        System.out.println("Test Letzter hinzugefügter Identifier: " + lastIdentifier);
        Person lookedUpPerson = identifierHashMap.get(lastIdentifier);
        Identifier lookedUpIdentifier = lookedUpPerson.getIdentifierByScope(scope);
        System.out.println("Gefundener High Level Identifier");
        System.out.println("Name: "+ lookedUpIdentifier.getName()+" Wert: "+lookedUpIdentifier.getValue());
        //End





    }
}

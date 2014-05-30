import Domain.Identifier;
import Domain.Person;
import Domain.PersonContainer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        System.out.println();
        List<String> testList = Arrays.asList("ID1","P1","Pheno","Test");
        List<String> testList2 = Arrays.asList("Blubs");

        Identifier root = personContainer.getPersons().next().getRoot();

        root.addChild(testList);
        root.addChild(testList2);
        Identifier.printIdentifierTree(root);
    }
}

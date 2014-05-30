package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Martin on 5/27/2014.
 */
public class Identifier {
    private String name;
    private String value;
    private List<Identifier> children = new ArrayList<Identifier>();
    private Identifier parent = null;

    public Identifier(String name, String value) {
        this.name = name;
        this.value = value;
    }
    //Braucht Unterstützung für Algorithmen
    public void addChild(List<String> nameList) {
        List<Identifier> tempIdentifierList = children;
        Iterator<String> tempStringIterator = nameList.iterator();
        Identifier currentIdentifier = this;
        String currentName = null;
        boolean setFlag = false;
        while(tempStringIterator.hasNext()){
            setFlag = false;
            currentName = tempStringIterator.next();
            Iterator<Identifier> tempIdentifierIterator = tempIdentifierList.iterator();
            while(tempIdentifierIterator.hasNext()){
                Identifier checkedIdentifier = tempIdentifierIterator.next();
                if(currentName == checkedIdentifier.getName()){
                    tempIdentifierList = checkedIdentifier.children;
                    setFlag = true;
                    break;
                }
            }
            if (setFlag == false){
                Identifier createdChild = new Identifier(currentName, RandomStringUtils.random(8));
                createdChild.setParent(currentIdentifier);
                currentIdentifier.children.add(createdChild);
                System.out.println(createdChild.parent.getName());
                tempIdentifierList = createdChild.children;
                currentIdentifier = createdChild;
            }
        }

    }

    /**
     * Prints a Tree structure of the provided Identifier with all its sub identifiers
     *
     * @param inputIdentifier
     */
    public static void printIdentifierTree(Identifier inputIdentifier) {
        System.out.println("Name: " + inputIdentifier.name + " Value: " + inputIdentifier.value);
        Iterator<Identifier> tempIdentifierIterator = inputIdentifier.children.iterator();
        while (tempIdentifierIterator.hasNext()) {
            Identifier currentIdentifier = tempIdentifierIterator.next();
            //Find level of Identifier
            int counter = 0;
            Identifier countIdentifier = currentIdentifier;
            while(countIdentifier.parent != null){
                counter++;
                countIdentifier = countIdentifier.parent;
            }
            for(int i=0; i<counter; i++)
                System.out.print("+");
            printIdentifierTree(currentIdentifier);
        }

    }

    public void setParent(Identifier parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public List<Identifier> getIdentifiers() {
        return children;
    }

    public String getValue() {
        return value;
    }
}

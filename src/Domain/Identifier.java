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
        Identifier currentIdentifier = null;
        String currentName = null;
        boolean setFlag = false;
        for(int i=0; i<nameList.size()-1; i++){
            setFlag = false;
            currentName = tempStringIterator.next();
            Iterator<Identifier> tempIdentifierIterator = tempIdentifierList.iterator();
            while(tempIdentifierIterator.hasNext()){
                currentIdentifier = tempIdentifierIterator.next();
                if(currentName == currentIdentifier.name){
                    tempIdentifierList = currentIdentifier.children;
                    setFlag = true;
                    break;
                }
            }
            if (setFlag == false){
            currentIdentifier.children.add(new Identifier(currentName, RandomStringUtils.random(8)));
            }
        }
        if(setFlag == true)
        currentIdentifier.children.add(new Identifier(currentName, RandomStringUtils.random(8));
    }

    public static Identifier getChild(Identifier inputIdentifier, String name) {
        Iterator<Identifier> tempIterator = inputIdentifier.getIdentifiers().iterator();
        while (tempIterator.hasNext()) {
            if (tempIterator.next().getName {

            }
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
}

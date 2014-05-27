package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void addChild(List<String> nameList, String value) {
        List<Identifier> tempIdentifierList = children;
        Iterator<String> tempStringIterator = nameList.iterator();
        Identifier currentIdentifier = null;
        for(int i=0; i<nameList.size()-1; i++){
            String currentName = tempStringIterator.next();
            Iterator<Identifier> tempIdentifierIterator = tempIdentifierList.iterator();
            while(tempIdentifierIterator.hasNext()){
                currentIdentifier = tempIdentifierIterator.next();
                if(currentName == currentIdentifier.name){
                     tempIdentifierIterator = currentIdentifier.children.iterator();
                    break;
                }
            //Hier logging "Einfügen fehlgeschlagen!"
            }
            currentIdentifier.children.add(new Identifier(currentName, value);
        }
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

package Domain;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Martin on 5/27/2014.
 */
public class Token {
    String id;
    Calendar validUntil;
    String owner;       //Can later be used for further authentification
    List<String> scope;

    public Token(String id, Calendar valid, String owner, List<String> scope){
        this.id = id;
        this.validUntil = valid;
        this.owner = owner;
        this.scope = scope;
    }
}

package incomplete;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author java ee
 */
@Entity
@Table(name="ITEM")
public class Item implements Serializable {
    
    
    //ALLLL THIS IS WRONG IF THIS BEAN IS ABOUT GENERATING A QUOTE THEN ALL YOU NEED IS PICK UP ZIP, DROP OFF ZIP, WEIGHT, CLASS, SIZE ... 
    /**
     * IF THIS is an Item entity then it should not concern itself with pickup days origin etc... its only a description of the item, weight etc... 
     * also it does not become persistent until a bol is generated or rather a pick up button is clicked
     */
    
    
    
}

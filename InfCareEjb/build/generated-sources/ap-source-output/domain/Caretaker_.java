package domain;

import domain.TimeReference;
import domain.Visit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-04-26T16:48:55")
@StaticMetamodel(Caretaker.class)
public class Caretaker_ { 

    public static volatile ListAttribute<Caretaker, Visit> visits;
    public static volatile SingularAttribute<Caretaker, String> firstName;
    public static volatile SingularAttribute<Caretaker, String> lastName;
    public static volatile SingularAttribute<Caretaker, String> password;
    public static volatile SingularAttribute<Caretaker, Long> id;
    public static volatile ListAttribute<Caretaker, TimeReference> timeReference;
    public static volatile SingularAttribute<Caretaker, String> email;
    public static volatile SingularAttribute<Caretaker, String> username;

}
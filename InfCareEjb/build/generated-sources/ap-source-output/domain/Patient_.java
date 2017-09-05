package domain;

import domain.Address;
import domain.TimeReference;
import domain.Visit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-04-26T16:48:55")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile ListAttribute<Patient, Visit> visits;
    public static volatile SingularAttribute<Patient, String> firstName;
    public static volatile SingularAttribute<Patient, String> lastName;
    public static volatile SingularAttribute<Patient, String> password;
    public static volatile SingularAttribute<Patient, Address> address;
    public static volatile SingularAttribute<Patient, Long> id;
    public static volatile ListAttribute<Patient, TimeReference> timeReference;
    public static volatile SingularAttribute<Patient, String> email;
    public static volatile SingularAttribute<Patient, String> username;

}
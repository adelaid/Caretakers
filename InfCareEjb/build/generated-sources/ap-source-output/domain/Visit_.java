package domain;

import domain.Caretaker;
import domain.Patient;
import domain.TimeReference;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-04-26T16:48:55")
@StaticMetamodel(Visit.class)
public class Visit_ { 

    public static volatile SingularAttribute<Visit, Caretaker> caretaker;
    public static volatile SingularAttribute<Visit, Patient> patient;
    public static volatile SingularAttribute<Visit, Integer> grade;
    public static volatile SingularAttribute<Visit, Integer> match;
    public static volatile SingularAttribute<Visit, Long> id;
    public static volatile SingularAttribute<Visit, LocalDateTime> vDate;
    public static volatile SingularAttribute<Visit, String> confirmed;
    public static volatile SingularAttribute<Visit, TimeReference> tr;

}
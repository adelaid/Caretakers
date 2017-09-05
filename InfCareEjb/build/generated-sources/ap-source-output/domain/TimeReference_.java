package domain;

import domain.Caretaker;
import domain.Patient;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-04-26T16:48:55")
@StaticMetamodel(TimeReference.class)
public class TimeReference_ { 

    public static volatile SingularAttribute<TimeReference, Caretaker> ct;
    public static volatile SingularAttribute<TimeReference, Patient> patient;
    public static volatile SingularAttribute<TimeReference, LocalDateTime> startTime;
    public static volatile SingularAttribute<TimeReference, Long> id;
    public static volatile SingularAttribute<TimeReference, LocalDateTime> endTime;

}
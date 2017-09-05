package domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-04-26T16:48:55")
@StaticMetamodel(PatientNeed.class)
public class PatientNeed_ { 

    public static volatile SingularAttribute<PatientNeed, Long> needId;
    public static volatile SingularAttribute<PatientNeed, Long> patientId;
    public static volatile SingularAttribute<PatientNeed, Long> timerefId;
    public static volatile SingularAttribute<PatientNeed, Integer> minPeriod;
    public static volatile SingularAttribute<PatientNeed, String> description;
    public static volatile SingularAttribute<PatientNeed, LocalDateTime> lastVisit;
    public static volatile SingularAttribute<PatientNeed, Integer> maxPeriod;
    public static volatile SingularAttribute<PatientNeed, LocalDateTime> ldNow;

}
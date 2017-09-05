/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Ada
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
//        DateTimeFormatter formatterX
//                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
//        LocalDateTime lastVisitd = LocalDateTime.parse(locDateTime, formatterX);
//        
//         if (lastVisit.equals("1111-11-11 00:00:00")){}
        
    	return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
       
    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
    }
}

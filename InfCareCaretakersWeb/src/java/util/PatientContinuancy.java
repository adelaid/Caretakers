/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javafx.util.converter.LocalDateTimeStringConverter;
import ws.Patient;
import ws.TimeReference;

/**
 *
 * @author Ada
 */
public class PatientContinuancy implements Comparator<PatientContinuancy>  {
    Patient p;
    TimeReference tr;

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public TimeReference getTr() {
        return tr;
    }

    public void setTr(TimeReference tr) {
        this.tr = tr;
    }

    public PatientContinuancy(Patient p, TimeReference tr) {
        this.p = p;
        this.tr = tr;
    }

    public PatientContinuancy() {
    }
    
    

    @Override
    public int compare(PatientContinuancy o1, PatientContinuancy o2) {
        
        return Long.compare(o1.getP().getId(), o2.getP().getId());
//        TimeReference tr1=o1.getTr();
//        TimeReference tr2=o2.getTr();
//        
//        LocalDate ld1= getlDate(tr1.getStartTime());
//        LocalDate ld2=getlDate(tr2.getStartTime());
//        
//        LocalTime lt1=getlTime(tr1.getStartTime());
//        LocalTime lt2=getlTime(tr2.getStartTime());
//       ld1.compareTo(ld2);
//       lt1.compareTo(lt2);
//       LocalDateTime ldt1=LocalDateTime.of(ld1, lt1);
//       LocalDateTime ldt2=LocalDateTime.of(ld2, lt2);
//       return ldt1.compareTo(ldt2);
      //  return String.compare(o1.getTr().getStartTime(), o2.getTr().getStartTime());
    }
    
     public String seconds(String str) {
        // String timpul="";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();
        for (Character ch : chars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        Set<Character> keys = map.keySet();
        Character c = ':';
        if (map.get(c) == 1) {
            str = str + ":00";
        }
        //      System.out.println("timpp "+ str);
        return str;

    }
    public LocalTime getlTime(String t) {
        String tt = seconds(t);
        String[] parts = tt.split("T");

        String timpul = parts[1];

        //find how many times : is in the string
        // timpul=seconds(t);
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        char[] chars = t.toCharArray();
//        for (Character ch : chars) {
//            if (map.containsKey(ch)) {
//                map.put(ch, map.get(ch) + 1);
//            } else {
//                map.put(ch, 1);
//            }
//        }
//        Set<Character> keys = map.keySet();
//        Character c = ':';
//        if (map.get(c) == 1) {
//            timpul = timpul + ":00";
//        }
//        for (Character ch : keys) {
//            if (map.get(ch) > 1) {
//                System.out.println("Char " + ch + " " + map.get(ch));
//            }
//        }
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(timpul, timeFormatter);
        //      System.out.println("timpul "+ timpul);
        return localTime;
        // System.out.println("timp " + localTime);

    }

    public LocalDate getlDate(String t) {
        String[] parts = t.split("T");
        String data = parts[0];
        DateTimeFormatter formatterX
                = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
        LocalDate localDate = LocalDate.parse(data, formatterX);
        return localDate;
    }
    
}

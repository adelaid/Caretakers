/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Ada
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

public class LocalDateAdapter extends XmlAdapter<String, LocalDateTime>{

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
       return v.toString();
    }
// 
//@Override
//public LocalDate unmarshal(String inputDate) throws Exception {
//return LocalDate.parse(inputDate);
//}
// 
//@Override
//public String marshal(LocalDate inputDate) throws Exception {
//return inputDate.toString();
//}
 
}

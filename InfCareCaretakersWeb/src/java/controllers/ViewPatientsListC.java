/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import util.PatientContinuancy;
import util.PatientGrade;
import util.PatientMatch;
import util.PatientUrgency;
import ws.Caretaker;
import ws.CaretakerWS_Service;
import ws.Need;
import ws.NeedWS_Service;
import ws.Patient;
import ws.PatientNeed;

import ws.PatientWS_Service;
import ws.TimeReference;
import ws.TimeReferenceWS_Service;
import ws.Visit;
import ws.VisitWS_Service;

/**
 *
 * @author Ada
 */
@WebServlet(name = "ViewPatientsListC", urlPatterns = {"/ViewPatientsListC"})
public class ViewPatientsListC extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TimeReferenceWS/TimeReferenceWS.wsdl")
    private TimeReferenceWS_Service service_4;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VisitWS/VisitWS.wsdl")
    private VisitWS_Service service_3;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/NeedWS/NeedWS.wsdl")
    private NeedWS_Service service_2;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CaretakerWS/CaretakerWS.wsdl")
    private CaretakerWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PatientWS/PatientWS.wsdl")
    private PatientWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param t
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public double gradeAvg(ArrayList<Integer> a){
    int s=a.size(); //2
    double avg=0;
    for(int i=0;i<a.size();i++){
     //   System.out.println("aaa " + a.get(i));
    avg+=a.get(i);// 0+5
    if(i==a.size()-1){
        avg=avg/s;
    }
    }
    return avg;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Caretaker ct = (Caretaker) request.getSession().getAttribute("user");
        List<TimeReference> patientsSch = getAllPatientsSchedule();
        List<TimeReference> caretakersSch = getAllCaretakersSchedule();
        Map<TimeReference, List<Caretaker>> hm = new HashMap<TimeReference, List<Caretaker>>();
        List<TimeReference> patients2Sc = new ArrayList<TimeReference>();
        List<ws.PatientNeed> pn = new ArrayList<ws.PatientNeed>();
        List<ws.PatientNeed> pn2 = new ArrayList<ws.PatientNeed>();
        List<Long> arr = new ArrayList<Long>();
        for (TimeReference tr : patientsSch) {
            LocalDate localDate = getlDate(tr.getStartTime());
            LocalTime localTime = getlTime(tr.getStartTime());
            LocalTime endTime = getlTime(tr.getEndTime());
            
            for (TimeReference tr2 : caretakersSch) {
                LocalDate localDateC = getlDate(tr2.getStartTime());
                LocalTime localTimeC = getlTime(tr2.getStartTime());
                LocalTime endTimeC = getlTime(tr2.getEndTime());   
                
                if (localDate.isEqual(localDateC)) {
                    if (localTime.equals(localTimeC) || localTime.isAfter(localTimeC)) {
                        if (endTime.equals(endTimeC) || endTime.isBefore(endTimeC)) {
                            List<Caretaker> cts = new ArrayList<Caretaker>();
                            cts.add(tr2.getCt());
                            System.out.println("caretakers " + tr2.getCt().getUsername());
                            System.out.println("pacient " + tr.getPatient().getUsername());
                            patients2Sc.add(tr);
                            tr.setStartTime(seconds(tr.getStartTime()));
                            tr.setEndTime(seconds(tr.getEndTime()));                       
                            arr.add(tr2.getCt().getId());
                            arr.add(tr.getId());
                            hm.put(tr, cts);                     
                        }
                    }
                }
            }
        }
        request.getSession().setAttribute("sch", hm);
        request.getSession().setAttribute("arr", arr);
        List<Visit> visits = getAllVisits();
        request.getSession().setAttribute("visits", visits);
        ArrayList<Long> arr2 = new ArrayList<Long>();

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) { // id caretkaer
                if (arr.get(i).equals(ct.getId())) { //daca id caretaker din arr = caretaker logat
                    arr2.add(arr.get(i));
                    arr2.add(arr.get(i + 1));
                    for (Visit v : visits) {
                        if ((v.getTr().getId().equals(arr.get(i + 1)) && v.getConfirmed().equals("YES")) || (v.getTr().getId().equals(arr.get(i + 1)) && v.getConfirmed().equals("NO") &&  v.getCaretaker().getId().equals(ct.getId())) ) { //daca e deja vizita setata sa scoata din arr?
//                            if( v.getConfirmed().equals("YES")){
//                                System.out.println("YEEEEES");
//                            }
                     //       if()){}
                            
                            ListIterator li = arr2.listIterator();
                            for (int j = 0; j < arr2.size(); j++) {
                                System.out.println("26aaa " + arr.get(i + 1));
                                if (li.next().equals(arr.get(i + 1))) {
                                    //  System.out.println("li " + li.previous());

                                    li.previous();
                                    li.previous();
                                    li.remove();
                                    li.next();
                                    li.remove();
                                }
                            }

//                            arr2.remove(arr.get(i));
//                            arr2.remove(arr.get(i + 1));
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < arr.size(); i++) {
//            if (i % 2 == 0) {
//                // System.out.println("id caretaker "+arr.get(i));
//                //    System.out.println("caretaker acum "+ct.getId());
//                if (arr.get(i).equals(ct.getId())) {
//                    //  System.out.println("rahata");
//                    for (TimeReference t : patientsSch) {
//                        if (arr.get(i + 1).equals(t.getId())) {
//                            //  visits = getVisitsByPatient(t.getPatient().getUsername());
//                            if (visits.size() == 0) {
//                                arr2.add(ct.getId());
//                                arr2.add(t.getId());
//                                System.out.println("Caretaker2 " + ct.getUsername() + " Pacient: " + t.getPatient().getUsername() + "timerefid " + t.getId());
//                            } else {
//                                for (Visit v : visits) {
//                                    if (v.getPatient().getId().equals(t.getPatient().getId())) {
//                                        System.out.println("visit " + v.getId());
//                                        System.out.println("tr id " + t.getId());
//                                     //   if (!v.getTr().getId().equals(t.getId())) {
//                                     if(!t.getId().equals(v.getTr().getId())){
//                                            // System.out.println("hrffffffffffffffffffffffffffffffff");
//                                            arr2.add(ct.getId());
//                                            arr2.add(t.getId());
//                                            System.out.println("Caretaker3 " + ct.getUsername() + " Pacient: " + t.getPatient().getUsername() + "timerefid " + t.getId());
//                                        }
//                                    } else {
//                                        //if(t.getId().equals(v)){}
//                                        arr2.add(ct.getId());
//                                        arr2.add(t.getId());
//                                        System.out.println("Caretaker4 " + ct.getUsername() + " Pacient: " + t.getPatient().getUsername() + "timerefid " + t.getId());
//
//                                    }
//                                }
//                            }
//
//                        }
//                    }
//                    // System.out.println("Pacientu " + );
//                }
//            }
//        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("arr " + arr.get(i));
        }
ArrayList<Double> gr=new ArrayList<>();
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println("arr2 " + arr2.get(i)); //arr2.size/2 = cati pacienti sunt
            if (i % 2 == 0) {
                TimeReference tr = getTimeRef(arr2.get(i + 1));
                //  int j=i+1;

              //  System.out.println(tr.getPatient().getUsername());
                List<Visit> vs = getVisitsByPatient(tr.getPatient().getUsername());
                ArrayList<Integer> grades=new ArrayList<>();
                int j=0;
                for (Visit v : vs) { //adauga grade uri din vizite
                   // System.out.println("ha");
                   
                    if(v.getCaretaker().getUsername().equals(ct.getUsername())){
                        j++;
                       
                     //    System.out.println("ha2");
                        System.out.println("grade " + v.getGrade());
                        
                        grades.add(v.getGrade());
                        
                     
                }}
                
                System.out.println("avg "+gradeAvg(grades));
                
                gr.add(gradeAvg(grades));
                // PatientGrade pg=new PatientGrade(gr.);
            }

        }
        ArrayList<PatientGrade> ptg= new ArrayList<PatientGrade>();
        
        for(int i=0;i<gr.size();i++){
             PatientGrade pg=new PatientGrade(gr.get(i),arr2.get(i+i+1));
             ptg.add(pg);
        System.out.println("Patient Grade " + pg.getGrade() + " " + pg.getTr());
        }
//        for(int j=0;j<arr2.size();j++){
//            if(j%2==0){
//      //  for(int i=0;i<gr.size();i++){
//            PatientGrade pg=new PatientGrade(gr.get(j),arr2.get(j+1));
//            ptg.add(pg);
//            
//           // System.out.println("Patient Grade " + pg.getGrade() + " " + pg.getTr());
////        System.out.println("gr" +gr.get(i));
////        if(i!=gr.size()-1){
////        if(gr.get(i)<gr.get(i+1)){
////            
////        }}
//        }
//            else{
//            PatientGrade pg=new PatientGrade(gr.get(j),arr2.get(j+2));
//            }
//        
//        }
       // }
       
       
        Collections.sort(ptg, new Comparator<PatientGrade>() {  
            @Override
            public int compare(PatientGrade o1, PatientGrade o2) {
                System.out.println("hh" + o1.getGrade() + "xx" + o2.getGrade());
                System.out.println("prrr " + Double.compare(o1.getGrade(),o2.getGrade()));
               return Double.compare(o1.getGrade(),o2.getGrade());
            }
        }); 
        List<PatientNeed> pns = getAllPatientNeed();
        ArrayList<PatientMatch> ptm=new ArrayList<PatientMatch> ();
        
        
        for(PatientGrade p : ptg){
        
            System.out.println("grade " + p.getGrade() + "id " + p.getTr());
            Patient pt=getTimeRef(p.getTr()).getPatient();
         
            PatientMatch pm =new PatientMatch();
            pm.setP(pt);
            pm.setMatchG(pm.giveP(p.getGrade()));
        
            pm.setTr(getTimeRef(p.getTr()));
              System.out.println("pmGrade " + pm.getMatchG() + "tr "+pm.getTr().getId());
     
          
          ptm.add(pm);
        }
//  PatientUrgency pu = new PatientUrgency();
              //     pm.setMatchU(0);
        
           for(PatientNeed pr: pns){   
            for(PatientMatch pmm : ptm){
                if(pr.getTimerefId().equals(pmm.getTr().getId())){
          
            LocalDate ldt;
            System.out.println("aa " + pr.getLdNow());
            if(pr.getLastVisit()==null || pr.getLastVisit().equals(null)){
        
            ldt=getlDate(pr.getLdNow());
                System.out.println("");
            }else{
            ldt = getlDate(pr.getLastVisit());
                System.out.println(pr.getTimerefId());
            System.out.println("pr get last visit " + pr.getLastVisit());
                System.out.println("max " + pr.getMaxPeriod());
            }
              PatientUrgency pu = new PatientUrgency();
              pu.setLastVisit(ldt);
              pu.setMaxP( pr.getMaxPeriod());
              pu.setNowDate(LocalDate.now());
              System.out.println("pu " +pmm.givePforUrgency(pu));
             pmm.setMatchU( pmm.givePforUrgency(pu));
             pmm.setMatch(pmm.getMatchG()+pmm.getMatchU());
             
             //pmm.getTr();
       
  }        }
           
           }
        
//        for(PatientMatch pm : ptm){
//        pm.getTr().get
//        }
        
       
    //    List<PatientNeed> pns = getAllPatientNeed();
//        for(PatientNeed p: pns){
//           // LocalDate ldt=getlDate(p.getLastVisit());
//         LocalDate ldt;
//            System.out.println("aa " + p.getLdNow());
//            if(p.getLastVisit()==null || p.getLastVisit().equals(null)){
//           // ldt=LocalDate.now();
//            ldt=getlDate(p.getLdNow());
//            }else{
//            ldt = getlDate(p.getLastVisit());
//            }
//              PatientUrgency pu = new PatientUrgency();
//              pu.setLastVisit(ldt);
//              pu.setMaxP( p.getMaxPeriod());
//              pu.setNowDate(LocalDate.now());
//             
//             PatientMatch pm= new PatientMatch();
//           TimeReference tr=getTimeRef( p.getTimerefId());
//           pm.setTr(tr);
//           pm.setP(tr.getPatient());
//            pm.setMatchU( pm.givePforUrgency(pu));
//            System.out.println("pm " + pm.getMatchU() + "tr "+pm.getTr().getId());
//            ptm.add(pm);
//        }
//         for(PatientMatch pp: ptm){
//          System.out.println(" inainte de comp PatientMatch " + pp.getP().getUsername() + "match de " + pp.getMatch() + "time ref " + pp.getTr().getId());     
//     }
//        Collections.sort(ptm, new Comparator<PatientMatch>() {  
// 
//     
//
//            @Override
//            public int compare(PatientMatch o1, PatientMatch o2) {
////                System.out.println("hh" + o1.getGrade() + "xx" + o2.getGrade());
////                System.out.println("prrr " + Double.compare(o1.getGrade(),o2.getGrade()));
//               return Long.compare(o1.getTr().getId(),o2.getTr().getId());
//            }
//        }); 
        
//         for(PatientMatch pp: ptm){
//            System.out.println("PatientMatch " + pp.getP().getUsername() + "match de " + pp.getMatch() + "time ref " + pp.getTr().getId());
//       //ListIterator li =ptm.listIterator();
//       //li.next();
//        // System.out.println(li.);
//       if(pp.equals()){
//           System.out.println("a");
//       }
//            
//        }

//List<PatientMatch> ptmFinal=new ArrayList<PatientMatch>();
//for(int i=0;i<ptm.size();i++){
//    if(i!=ptm.size()-1){
//if(ptm.get(i).getTr().getId().equals(ptm.get(i+1).getTr().getId())){
//    System.out.println("ma ta");
//    PatientMatch pm=new PatientMatch();
//    double match = ptm.get(i).getMatchU()+ptm.get(i+1).getMatchU();
//    pm.setMatchU(match);
//    pm.setP(ptm.get(i).getP());
//    pm.setTr(ptm.get(i).getTr());
//    ptmFinal.add(pm);
//    System.out.println("!!!PatientMatch " + pm.getP().getUsername() + "match urgency de " + pm.getMatchU() + "time ref " + pm.getTr().getId()); 
//}
// 
//    
//    }
//}
//
// Collections.sort(ptm, new Comparator<PatientMatch>() {  
// 
//     
//
//            @Override
//            public int compare(PatientMatch o1, PatientMatch o2) {
////                System.out.println("hh" + o1.getGrade() + "xx" + o2.getGrade());
////                System.out.println("prrr " + Double.compare(o1.getGrade(),o2.getGrade()));
//               return Long.compare(o1.getTr().getPatient().getId(),o2.getTr().getPatient().getId());
//            }
//        }); 
// 
// for(int i=0;i<ptm.size();i++){
//    if(i!=ptm.size()-1){
//if(ptm.get(i).getTr().getPatient().getId().equals(ptm.get(i+1).getTr().getPatient().getId())){
//    System.out.println(ptm.get(i).getP().getId());
//    double mm =ptm.get(i).getMatchG()+ptm.get(i+1).getMatchG();
//    System.out.println("gradeee " + mm + "pacient " + ptm.get(i).getP().getId() + "tr " + ptm.get(i).getTr().getId());
//   // double mm2 =ptm.get(i).getMatchU()+ptm.get(i+1).getMatchU();
//  //  System.out.println("urgencyyyy" + mm2);
////    PatientMatch pm=new PatientMatch();
////    double match = ptm.get(i).getMatch()+ptm.get(i+1).getMatch();
////    pm.setMatch(match);
////    pm.setP(ptm.get(i).getP());
////    pm.setTr(ptm.get(i).getTr());
////    ptmFinal.add(pm);
//  //  System.out.println("!!!PatientMatch " + pm.getP().getUsername() + "match de " + pm.getMatch() + "time ref " + pm.getTr().getId()); 
//}
// 
//    
//    }
//}


//         Collections.sort(ptm, new Comparator<PatientContinuancy>() {  
// 
//     
//
//            @Override
//            public int compare(PatientContinuancy o1, PatientContinuancy o2) {
//                System.out.println("hh" + o1.getGrade() + "xx" + o2.getGrade());
//                System.out.println("prrr " + Double.compare(o1.getGrade(),o2.getGrade()));
//               return Double.compare(o1.getGrade(),o2.getGrade());
//            }
//        }); 

ArrayList<PatientContinuancy> pc = new ArrayList<PatientContinuancy>();
     for(PatientMatch pp: ptm){
         PatientContinuancy pcc =new PatientContinuancy();
         pcc.setP(pp.getTr().getPatient());
         pcc.setTr(pp.getTr());
         pc.add(pcc);
          System.out.println("PatientMatch " + pp.getP().getUsername() 
                  + "match urgency de de " + pp.getMatchU() + 
                  "match grade de" +pp.getMatchG()+ "time ref " + pp.getTr().getId()
                  + "match total " + pp.getMatch() + "%");     }      
              Collections.sort(pc, new Comparator<PatientContinuancy>() {      
            @Override
            public int compare(PatientContinuancy o1, PatientContinuancy o2) { //date & time sorting
 return Long.compare(o1.getP().getId(), o2.getP().getId());
            }  }); 
              for(PatientContinuancy pcr: pc){
                  System.out.println("Patient Continuancy " + pcr.getTr().getId() );}            
                   for(int i=0;i< pc.size();i++){
                    if (i!= pc.size()-1) {             
              for(int j=i+1;j<=pc.size()-1;j++){                  
              if(pc.get(i).getP().getId().equals(pc.get(j).getP().getId())){
                  if(pc.get(i).getTr().getEndTime().equals(pc.get(j).getTr().getStartTime() ) || 
                          pc.get(i).getTr().getStartTime().equals(pc.get(j).getTr().getEndTime() ) ){
                   System.out.println("i ul " +pc.get(i).getTr().getId()+"j ul "+ pc.get(j).getTr().getId());
                   for(PatientMatch pm :ptm){
                   if(pm.getTr().getId().equals(pc.get(i).getTr().getId()) || 
                           pm.getTr().getId().equals(pc.get(j).getTr().getId())){
                   pm.setMatchC(20);
                   pm.setMatch(pm.getMatch()+pm.getMatchC());
                   }}}}}}}
                   for(PatientMatch pp: ptm){
         PatientContinuancy pcc =new PatientContinuancy();
         pcc.setP(pp.getTr().getPatient());
         pcc.setTr(pp.getTr());
         pc.add(pcc);
                   }
                   
                   
                   
                   Collections.sort(ptm, new Comparator<PatientMatch>() {  
 
     

            @Override
            public int compare(PatientMatch o1, PatientMatch o2) {
              
               return Double.compare(o1.getMatch(),o2.getMatch());
            }
        }); 
                   Collections.reverse(ptm);
                            for(PatientMatch pp: ptm){
                            
                            System.out.println("PatientMatch " + pp.getP().getUsername() + "match urgency de de " + pp.getMatchU() + "match grade de" +pp.getMatchG()+"match continuancy de "+ pp.getMatchC()+ "time ref " + pp.getTr().getId() + "match total " + pp.getMatch() + "%");     
     }
                       
                   
              
            //   ArrayList<PatientContinuancy> pcfinal=new ArrayList<PatientContinuancy>();
//              for(int i=0;i< pc.size();i++){
//               if (i!= pc.size()-1) {
//                //     int j=1;
//                for(int j=i+1;j<pc.size()-i;j++){
//                    
//                 if(pc.get(i).getP().getId().equals(pc.get(j).getP().getId())){
//                    // j++;
//                     System.out.println("i ul " +pc.get(i).getTr().getId()+"j ul "+ pc.get(j).getTr().getId());
//                      ArrayList<PatientContinuancy> pc1=new ArrayList<PatientContinuancy>(); //array doar cu time patient continuancy al pacientului x
//                   PatientContinuancy pcc=new PatientContinuancy(pc.get(i).getP(),pc.get(i).getTr());
//                   PatientContinuancy pcc2=new PatientContinuancy(pc.get(j).getP(),pc.get(j).getTr());
//                  pc1.add(pcc);
//                  pc1.add(pcc2);
//                  
//                   Collections.sort(pc1, new Comparator<PatientContinuancy>() {  
// 
//     
//
//            @Override
//            public int compare(PatientContinuancy o1, PatientContinuancy o2) { //sortare dupa data si timp
//TimeReference tr1=o1.getTr();
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
//    return ldt1.compareTo(ldt2);
// //return Long.compare(o1.getP().getId(), o2.getP().getId());
//            }
//        }); 
//                   for(PatientContinuancy ppp: pc1){
//                   pcfinal.add(ppp);
//                   }
//                  
//                  
//                      //  pc1.add(pc.get(i).)
//                     }
//                
//                    
//            //  if(pc.get(i).getP().getId().equals(pc.get(i+1).getP().getId())){ //daca p1=p2
//                  //if(pc.get(i).getP().getId().equals(pc.get(i-1).getP().getId())){
//                   
//                  // }
//                 
//                
//                   
//                   
//                   
//                   TimeReference tr1=pc.get(i).getTr();
//        TimeReference tr2=pc.get(i+1).getTr();
//        
////        LocalDate ld1= getlDate(tr1.getStartTime());
////        LocalDate ld2=getlDate(tr2.getStartTime());
////        
////        LocalTime lt1=getlTime(tr1.getStartTime());
////        LocalTime lt2=getlTime(tr2.getStartTime());
////       ld1.compareTo(ld2);
////       lt1.compareTo(lt2);
////       LocalDateTime ldt1=LocalDateTime.of(ld1, lt1);
////       LocalDateTime ldt2=LocalDateTime.of(ld2, lt2);
//                  if(tr1.getEndTime().equals(tr2.getStartTime()) || tr1.getStartTime().equals(tr2.getEndTime())){
//                      System.out.println("pttttttttt" + tr1.getEndTime());
//                  }
//              }
//              }
//              }
     
//     for(PatientContinuancy pcr: pcfinal){
//     System.out.println("Pc final "+pcr.getTr().getId() );
//     }
              
              
      // PatientGrade pg;
        request.getSession().setAttribute("ptm",ptm);
        request.getSession().setAttribute("arr2", arr2);
        request.getSession().setAttribute("gr",gr);

        //getVisitsByPatient(username);
//for(int i=0;i<arr.size();i++){
//    System.out.println(arr.get(i));
//}
//        
//        for (TimeReference name : hm.keySet()) { //o data 1 singur tr crina
//
//            String key = name.getPatient().getFirstName();
//                System.out.println("key "+ key);          
//            List<Caretaker> cts = hm.get(name);
//            for (Caretaker p : cts) {
//                System.out.println("ap 0 " +p.getFirstName());
//                String value = p.getFirstName();
//                //   name.setPatient(p);
//                System.out.println(key + " value " + value);
//            }
//
//        }
//List<Caretaker> cts = hm.get("Angy");
//
//        for (Caretaker ctt : cts) {
//            for (TimeReference name : hm.keySet()) {
//                String value=ctt.getFirstName();
//                String key=name.getPatient().getFirstName();
//                System.out.println(key+value);
//            }
//        }
//        for (TimeReference tr : hm.keySet()) {
//
//            List<Patient> patients = hm.get(tr);
//            for (Patient p : patients) {
//                //   System.out.println("username "+p.getUsername());
//                //   System.out.println("ha "+ tr.getPatient().getTimeReference().get(0).getStartTime());
//            }
//        }
//        List<TimeReference> patientsSch2 = new ArrayList<TimeReference>();
//        for (TimeReference tr : patientsSch) {
//
//            tr.setStartTime(seconds(tr.getStartTime()));
//            //     System.out.println("starttime "+seconds(tr.getStartTime()));
//            tr.setEndTime(seconds(tr.getEndTime()));
//
//            patientsSch2.add(tr);
//
//        }
        //   request.getSession().setAttribute("pts", patients2Sc);
        //    System.out.println("pt2" + patientsSch2.get(3).getStartTime());
        //  request.getSession().setAttribute("schedule", patientsSch2);
//PatientNeed
//        for (TimeReference tr : hm.keySet()) {
//            List<Caretaker> cts = hm.get(tr);
//            for (Caretaker p : cts) {
//                if (p.getUsername().equals(ct.getUsername())) {
//                    System.out.println("alo " + tr.getPatient().getFirstName());
//                }
//            }
//        }
        request.getSession().setAttribute("patientsSch", patientsSch);
        pn = getAllPatientNeed();
        for (ws.PatientNeed nn : pn2) {
            System.out.println("desc " + nn.getDescription());
        }
        List<Need> needs = getAllNeeds();
        request.getSession().setAttribute("nd", needs);
        request.getSession().setAttribute("pn", pn);
        request.getSession().setAttribute("i", 0);
        request.getRequestDispatcher("ViewAssignedPatientsJSP.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<ws.TimeReference> getAllPatientsSchedule() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.PatientWS port = service.getPatientWSPort();
        return port.getAllPatientsSchedule();
    }

    private java.util.List<ws.TimeReference> getAllCaretakersSchedule() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CaretakerWS port = service_1.getCaretakerWSPort();
        return port.getAllCaretakersSchedule();
    }

    private java.util.List<ws.PatientNeed> getAllPatientNeed() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.NeedWS port = service_2.getNeedWSPort();
        return port.getAllPatientNeed();
    }

    private java.util.List<ws.Need> getAllNeeds() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.PatientWS port = service.getPatientWSPort();
        return port.getAllNeeds();
    }

    private java.util.List<ws.Visit> getVisitsByPatient(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service_3.getVisitWSPort();
        return port.getVisitsByPatient(username);
    }

    private java.util.List<ws.Visit> getAllVisits() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service_3.getVisitWSPort();
        return port.getAllVisits();
    }

    private TimeReference getTimeRef(long trId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.TimeReferenceWS port = service_4.getTimeReferenceWSPort();
        return port.getTimeRef(trId);
    }

    private void setVisit(long ctkId, long patientId, java.lang.String dateV, java.lang.Long timeRefId, int matchtot) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CaretakerWS port = service_1.getCaretakerWSPort();
        port.setVisit(ctkId, patientId, dateV, timeRefId, matchtot);
    }

   

}

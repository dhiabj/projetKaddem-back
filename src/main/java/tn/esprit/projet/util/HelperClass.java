package tn.esprit.projet.util;

import java.time.LocalDate;
import java.time.Period;

public class HelperClass {
    public static int getDate(LocalDate now, LocalDate param){
        //LocalDate now = LocalDate.now();
        Period p = Period.between(now,param) ;

        int days= p.getDays() ;
        return days;
    }
}

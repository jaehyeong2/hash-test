package jjafact.hash.global.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTime {

    public static LocalDateTime convertLocalDateTime(String date){
        if(date == null){
            return null;
        }
      return  LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_DATE), LocalTime.MIN);
    }
}

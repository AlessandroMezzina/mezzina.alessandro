package com.example;

public class AlarmClock {
    public String alarm(int weekDay, boolean vacation){
        if(weekDay<0 || weekDay>6) return "Questo giorno non esiste";
        if(!vacation) {
            if(weekDay>0 && weekDay<6) return "7:00";
            else return "10:00";
        }
        else{
            if(weekDay>0 && weekDay<6) return "10:00";
            else return "off";
        }
    }

    public static void main(String[] args) {
        AlarmClock alarmClock=new AlarmClock(); //Necessario l'utilizzo di un oggetto AlarmClock perché il metodo alarm non é statico
        System.out.println(alarmClock.alarm(0, false));
    }
}

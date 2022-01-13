package com.example;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;
 
public class AlarmClockTest {
    @Test
    void testAlarmOnWeekDayNoVacation() {
        AlarmClock alarmClock = new AlarmClock();
        assertEquals("7:00", alarmClock.alarm(1, false));
        assertEquals("7:00", alarmClock.alarm(2, false));
        assertEquals("7:00", alarmClock.alarm(3, false));
        assertEquals("7:00", alarmClock.alarm(4, false));
        assertEquals("7:00", alarmClock.alarm(5, false));
    }
 
    @Test
    void testAlarmOnWeekDayVacation() {
        AlarmClock alarmClock = new AlarmClock();
        assertEquals("10:00", alarmClock.alarm(1, true));
        assertEquals("10:00", alarmClock.alarm(2, true));
        assertEquals("10:00", alarmClock.alarm(3, true));
        assertEquals("10:00", alarmClock.alarm(4, true));
        assertEquals("10:00", alarmClock.alarm(5, true));
    }
 
    @Test
    void testAlarmOnWeekendNoVacation() {
        AlarmClock alarmClock = new AlarmClock();
        assertEquals("10:00", alarmClock.alarm(0, false));
        assertEquals("10:00", alarmClock.alarm(6, false));
    }
 
    @Test
    void testAlarmOnWeekendVacation() {
        AlarmClock alarmClock = new AlarmClock();
        assertEquals("off", alarmClock.alarm(0, true));
        assertEquals("off", alarmClock.alarm(6, true));
    }
}
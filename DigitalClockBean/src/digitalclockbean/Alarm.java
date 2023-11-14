/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package digitalclockbean;

import java.io.Serializable;

/**
 * Clase que permite definir la hora de una alarma, si esta activa o no y el
 * mensaje asociado
 *
 * @author Juan Carlos Vilarrubia
 */
public class Alarm implements Serializable {

    /**
     * Hora de la alarma 0-24
     */
    private int hour;
    /**
     * Minutos de la alarma 0-60
     */
    private int minute;
    /**
     * Estado de la alarmtra, true si está activa
     */
    private boolean active;
    private String message;

    public Alarm(int hour, int minute, boolean active, String message) {
        this.hour = hour;
        this.minute = minute;
        this.active = active;
        this.message = message;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

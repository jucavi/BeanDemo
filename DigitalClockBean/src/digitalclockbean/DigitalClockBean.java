/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package digitalclockbean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author kaos
 */
public class DigitalClockBean extends JLabel implements ActionListener, Serializable {
 
    /**
     * Formato para representar la hora
     */
    private enum TimeStringFormat {
        H12("HH:mm:ss"),
        H24("HH:mm:ss a");

        public final String label;

        private TimeStringFormat(String label) {
            this.label = label;
        }
    }

    private Alarm alarm;
    private boolean format24 = false;
    private Timer timer;
    private LocalDateTime currentDate;
    private AlarmListener listener;
    private PropertyChangeSupport propertySupport;
    
    public DigitalClockBean() {
        propertySupport = new PropertyChangeSupport(this);
        
        timer = new Timer(1000, this);
        timer.start();
        setText();
    }
    
    @Override
    public void setText(String text) {
        super.setText(text);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setText();
        
        if (checkTime()) {
            JOptionPane.showMessageDialog(null, "Alarma lanzada");
            if (listener != null) {
                listener.launcAlarm(new AlarmEvent(this));
            } else {
                System.out.println("Implement Listener");
            }
        }
    }

    /**
     * Muestra la hora actual en el texto del componente, teniendo
     * en cuenta si le muestra en formato 12H o 24H
     *
     * @param curentDate fecha y hora actuales
     */
    private void setText() {
        
        currentDate = LocalDateTime.now();
        DateTimeFormatter dtf;

        if (format24) {
            dtf = DateTimeFormatter.ofPattern(TimeStringFormat.H24.label);
        } else {
            dtf = DateTimeFormatter.ofPattern(TimeStringFormat.H12.label);
        }

        setText(dtf.format(currentDate).toUpperCase());
        repaint();
    }
    
    /**
     * Comprueba si la fecha y la hora pasadas como parámetro coinciden con la
     * almacenada en la alarma
     *
     * @param currentDate fecha y hora
     * @return {@code true} si la {@code currentDate == Alarm#getDateTime}
     */
    private boolean checkTime() {
        
        if (alarm == null) return false;
        
        boolean sameHour = currentDate.getHour() == alarm.getHour();
        boolean sameMinute = currentDate.getMinute() == alarm.getMinute();

        return sameHour && sameMinute && currentDate.getSecond() == 0;
    }
    
    public AlarmListener getListener() {
        return listener;
    }

    public void setListener(AlarmListener listener) {
        this.listener = listener;
    }
    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        // Alarm oldvalue = this.alarm;
        this.alarm = alarm;
        //propertySupport.firePropertyChange("alarm", oldValue, alarm);
    }

    public boolean isFormat24() {
        return format24;
    }

    public void setFormat24(boolean format24) {
        this.format24 = format24;
    }
    
    public void addAlarmListener(AlarmListener listener) {
        this.listener = listener;
    }
    
    public void removeAlarmListener(AlarmListener listener) {
        this.listener = null;
    }
    
}

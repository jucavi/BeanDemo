/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalclockbean;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

/**
 *
 * @author Juan Carlos Vilarrubia
 */
public class AlarmPropertyEditorSupport extends PropertyEditorSupport {

    private final AlarmPanel alarmPanel = new AlarmPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return alarmPanel;
    }

    @Override
    public String getJavaInitializationString() {

        int hour = alarmPanel.getSelectedValue().getHour();
        int minute = alarmPanel.getSelectedValue().getMinute();
        boolean active = alarmPanel.getSelectedValue().isActive();
        String message = alarmPanel.getSelectedValue().getMessage();

        return "new digitalclockbean.Alarm("
                + hour + ", "
                + minute + ", "
                + active 
                + ", \"" + message + "\")";
    }

    @Override
    public Object getValue() {
        return alarmPanel.getSelectedValue();
    }
}

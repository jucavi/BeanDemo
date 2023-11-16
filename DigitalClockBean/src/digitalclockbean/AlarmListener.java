/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package digitalclockbean;

import java.io.Serializable;
import java.util.EventListener;

/**
 *
 * @author kaos
 */
public interface AlarmListener extends EventListener, Serializable {

    public void launchAlarm(AlarmEvent event);

}

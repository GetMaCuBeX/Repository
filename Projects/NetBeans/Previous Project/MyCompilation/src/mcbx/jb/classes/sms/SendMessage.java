/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcbx.jb.classes.sms;

/**
 *
 * @author Administrator
 */
// SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class SendMessage {

    int modemGateway = 0;
    int commport = 6;

    public void doIt() throws Exception {
        OutboundNotification outboundNotification = new OutboundNotification();
        SerialModemGateway gateway = new SerialModemGateway("modem.com5", "COM4", 9600, "Nokia", "5130c-2");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        gateway.setSmscNumber("+639306663689");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        // Send a message synchronously.
        OutboundMessage msg = new OutboundMessage("09302428560", "test");
        Service.getInstance().sendMessage(msg);
        System.out.println(msg);
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        System.in.read();
        Service.getInstance().stopService();
    }

    public void doIt(String recipient, String message, String commPort) throws Exception {
        modemGateway++;
        OutboundNotification outboundNotification = new OutboundNotification();
        SerialModemGateway gateway = new SerialModemGateway("modem.com", commPort, 9600, "Nokia", "5130c-2");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        gateway.setSmscNumber("+639306663689");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        // Send a message synchronously.
        OutboundMessage msg = new OutboundMessage(recipient, message);
        Service.getInstance().sendMessage(msg);
        Service.getInstance().stopService();
        System.out.println(msg);
        //System.out.println("Now Sleeping - Hit <enter> to terminate.");
        //System.in.read();
        
        System.out.println("SYSTEM STOP");
    }


    public class OutboundNotification implements IOutboundMessageNotification {

        public void process(AGateway gateway, OutboundMessage msg) {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }

    public static void main(String args[]) {
        SendMessage app = new SendMessage();
        try {
            app.doIt();
        } catch (Exception e) {
        }
    }
}
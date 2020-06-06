package atj.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class AsynchMessageReader implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            try{
                System.out.println("Received: '%s '%n " + ((TextMessage) message).getText());
            } catch (JMSException e){
                e.printStackTrace();
            }
        }
    }
}

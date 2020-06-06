package atj.mq;

import com.sun.messaging.jms.JMSException;

public class Main {

    public static void main(String[] args) throws javax.jms.JMSException {
        try (Consumer consumer = new Consumer("localhost:7676/jms", "ATJQueue")) {
            String msg = null;
            while ((msg = consumer.receiveQueueMessage()) != null) {
                System.out.println("Received: " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

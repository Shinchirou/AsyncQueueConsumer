package atj.mq;

import com.sun.messaging.jms.JMSException;

import javax.jms.TextMessage;

public class Main {

    public static void main(String[] args) throws javax.jms.JMSException {
        try (Consumer consumer = new Consumer("localhost:7676/jms", "ATJQueue")) {
            consumer.browseQueue();
            consumer.getJmsConsumer().setMessageListener(new AsynchMessageReader());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

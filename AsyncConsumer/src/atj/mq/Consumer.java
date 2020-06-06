package atj.mq;

import com.sun.messaging.ConnectionConfiguration;

import javax.jms.*;

public class Consumer implements AutoCloseable {
    private ConnectionFactory connectionFactory;
    private JMSContext jmsContext;
    private JMSConsumer jmsConsumer;
    private Queue queue;

    Consumer(String url, String queueName) throws JMSException {
        connectionFactory = new com.sun.messaging.ConnectionFactory();
        jmsContext = connectionFactory.createContext();

        ((com.sun.messaging.ConnectionFactory) connectionFactory).setProperty(ConnectionConfiguration.imqAddressList, url);
        queue = new com.sun.messaging.Queue(queueName);
        jmsConsumer = jmsContext.createConsumer(queue);
    }

    public String receiveQueueMessage() throws JMSException {
        Message msg = (Message) jmsConsumer.receive(10);
        if (msg instanceof TextMessage) {
            return ((TextMessage) msg).getText();
        }
        return null;
    }

    public
    JMSConsumer getJmsConsumer() {
        return jmsConsumer;
    }

    @Override
    public void close() throws Exception {
        if (jmsConsumer != null) {
            jmsConsumer.close();
        }
        if (jmsContext != null) {
            jmsContext.close();
        }
    }
}

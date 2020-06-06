package atj.mq;

import com.sun.messaging.ConnectionConfiguration;

import javax.jms.*;

public class Subscriber implements AutoCloseable {


    private ConnectionFactory connectionFactory;
    private JMSContext jmsContext;
    private JMSConsumer jmsConsumer;
    private Topic topic;

    Subscriber(String url, String topicName) throws JMSException {
        connectionFactory = new com.sun.messaging.ConnectionFactory();
        jmsContext = connectionFactory.createContext();
        ((com.sun.messaging.ConnectionFactory) connectionFactory)
                .setProperty(ConnectionConfiguration.imqAddressList, url);
        topic = new com.sun.messaging.Topic(topicName);
        jmsConsumer = jmsContext.createConsumer(topic);
    }

    public String receiveTopicMessage() throws JMSException {
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
        if (jmsContext != null) {
            jmsContext.close();
        }
    }
}
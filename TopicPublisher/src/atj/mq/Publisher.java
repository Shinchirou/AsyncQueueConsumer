package atj.mq;

import javax.jms.*;

public class Publisher implements AutoCloseable{

    private ConnectionFactory connectionFactory;
    private JMSContext jmsContext;
    private JMSProducer jmsProducer;
    private Topic topic;

    Publisher(){
        connectionFactory = new com.sun.messaging.ConnectionFactory();
        jmsContext = connectionFactory.createContext();
        jmsProducer = jmsContext.createProducer();
    }

    public void assignTopic(String topicName) throws JMSException{
        topic = new com.sun.messaging.Topic(topicName);
    }

    public void publish(String msg){
        jmsProducer.send(topic, msg);
    }

    @Override
    public void close() throws Exception {
    if (jmsContext != null) { jmsContext.close(); }
    }
}

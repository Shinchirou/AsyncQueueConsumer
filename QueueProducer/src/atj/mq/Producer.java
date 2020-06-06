package atj.mq;


import com.sun.messaging.ConnectionConfiguration;

import javax.jms.*;

public class Producer implements AutoCloseable{

    private JMSContext jmsContext;
    private JMSProducer jmsProducer;
    private Queue queue;

    Producer(String url, String queueName) throws JMSException{
        ConnectionFactory connectionFactory = new com.sun.messaging.QueueConnectionFactory();


        jmsContext = connectionFactory.createContext();
        ((com.sun.messaging.QueueConnectionFactory) connectionFactory).setProperty(ConnectionConfiguration.imqAddressList, url);
        jmsProducer = jmsContext.createProducer();
        queue = new com.sun.messaging.Queue(queueName);
    }
    public void sendQueueMessage(String msg) { jmsProducer.send(queue, msg);}

    @Override
    public void close() throws Exception {
    if(jmsContext != null) {
        jmsContext.close();
    }
    }
}

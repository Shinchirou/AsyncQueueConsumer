package atj.mq;

import javax.jms.JMSException;

public class Main {

    public static void main(String[] args) {
        try(Subscriber subscriber = new Subscriber("localhost:7676/jms", "ATJTopic")){
            subscriber.getJmsConsumer().setMessageListener(new AsynchMessageReader());
            for(int i = 0; i <30; i++){
                System.out.println("Subskrybent wykonuje zadanie");
                Thread.sleep(1000);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

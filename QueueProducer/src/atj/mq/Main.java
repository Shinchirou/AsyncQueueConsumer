package atj.mq;

public class Main {

    public static void main(String[] args) {
        try (Producer producer = new Producer("localhost:7676/jms", "ATJQueue")){
            producer.sendQueueMessage("Hello");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

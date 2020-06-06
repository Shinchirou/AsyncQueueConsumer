package atj.mq;

public class Main {


    public static void main(String[] args) {
        try(Publisher publisher = new Publisher()){

            publisher.assignTopic("ATJPersistentTopic");
            publisher.publish("hello");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

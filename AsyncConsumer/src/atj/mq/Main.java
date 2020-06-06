package atj.mq;

public class Main {

    public static void main(String[] args) throws Exception {
        try (Consumer consumer = new Consumer("localhost:7676/jms", "ATJQueue")) {

            consumer.getJmsConsumer().setMessageListener(new AsynchMessageReader());
            for (int i = 0; i < 30; ++i) {
                System.out.println("Konsument wykonuje zadanie");
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

package abstractFactoryExample;

public class LinuxButton implements Button {

    @Override
    public void paint(){
        System.out.println("[Linux Button]");
    }
}

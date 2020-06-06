package abstractFactoryExample;

public class LinuxCheckbox implements Checkbox{

    @Override
    public void paint(){
        System.out.println("(Y) LinuxCheckbox");
    }
}

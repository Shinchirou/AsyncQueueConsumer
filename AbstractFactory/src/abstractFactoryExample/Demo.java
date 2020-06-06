package abstractFactoryExample;

public class Demo {

    private static GUIApplication configureApplication(){
        GUIApplication guiApplication;
        GUIFactory guiFactory;
        String osName = System.getProperty("os.name");
        System.out.println(System.getProperty("os.name"));

        if(osName.contains("linux")){
            guiFactory = new LinuxFactory();
            guiApplication = new GUIApplication(guiFactory);
        } else{
            guiFactory = new WindowsFactory();
            guiApplication = new GUIApplication(guiFactory);
        }
        return guiApplication;
    }

    public static void main(String[] args) {

        GUIApplication app = configureApplication();

        app.paint();

    }
}

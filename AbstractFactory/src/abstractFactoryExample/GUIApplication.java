package abstractFactoryExample;

public class GUIApplication {

Button button;
Checkbox checkbox;

    public GUIApplication(GUIFactory guiFactory){
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }


}

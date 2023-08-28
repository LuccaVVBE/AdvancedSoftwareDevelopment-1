
import domein.IController;
import domein.HeartController;
import gui.IGuiController;
import gui.GuiHeartController;

public class HeartTestDrive {

    public static void main(String... args) {
        IController domeinController = new HeartController();
        IGuiController guiController = new GuiHeartController(domeinController);
    }
}

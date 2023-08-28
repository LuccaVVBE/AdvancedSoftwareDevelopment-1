
import gui.GuiBeatController;
import gui.IGuiController;
import domein.BeatController;
import domein.IController;

public class DJTestDrive {

    public static void main(String... args) {
        IController domeinController = new BeatController();
        IGuiController guiController = new GuiBeatController(domeinController);
    }

}

package gui;

import domein.IController;

public class GuiHeartController implements IGuiController {

    private final DJView view;

    public GuiHeartController(IController domeinController) {
        view = new DJView(this, domeinController);
        view.createView();
        view.createControls();
        view.setVisible(false);
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}

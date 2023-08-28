package gui;

import domein.IController;

public class GuiBeatController implements IGuiController {

    private final DJView view;

    public GuiBeatController(IController domeinController) {
        view = new DJView(this, domeinController);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void start() {
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }
}

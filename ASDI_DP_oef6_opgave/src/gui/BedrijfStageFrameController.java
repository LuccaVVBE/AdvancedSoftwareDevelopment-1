package gui;

import domein.DomeinController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import domein.*;
import static domein.Soort.*;
import javafx.scene.layout.*;

public class BedrijfStageFrameController extends HBox {

    private final DomeinController domeinController;

    private final FormPanelController formPanel;
    private final DetailPanelController detailPanel;

    public BedrijfStageFrameController(DomeinController domeinController) {

        this.domeinController = domeinController;

        formPanel = new FormPanelController(domeinController);
        detailPanel = new DetailPanelController(domeinController);
        
        //TODO STAGE
        //TODO BEDRIJF
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BedrijfStageFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        getChildren().addAll(formPanel, detailPanel);
        domeinController.addObserver(STAGE,detailPanel);
        domeinController.addObserver(BEDRIJF, detailPanel);
    }

}

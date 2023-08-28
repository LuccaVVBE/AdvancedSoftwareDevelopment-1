package gui;

import java.io.IOException;
import java.util.Collection;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import domein.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class DetailPanelController extends AnchorPane implements Observer {

    @FXML
    private TextField txtStageId;

    @FXML
    private TextField txtBedrijfId;

    private final DomeinController domeinController;

    public DetailPanelController(DomeinController domeinController) {

        this.domeinController = domeinController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Voor JUnit
    public String getStageId() {
        return txtStageId.getText();
    }

    public String getBedrijfId() {
        return txtBedrijfId.getText();
    }

	@Override
	public void update(Soort soort) {
		// TODO Auto-generated method stub
		switch(soort) {
		case STAGE -> txtStageId.setText(domeinController.getStageId());
		case BEDRIJF -> txtBedrijfId.setText(domeinController.getBedrijfId());
		}
		
	}

}

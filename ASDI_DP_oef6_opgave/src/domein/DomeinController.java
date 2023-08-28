package domein;

import gui.DetailPanelController;

public class DomeinController //FACADE
{
    private ObservableString observableBedrijfId;
    private ObservableString observableStageId;

    public DomeinController() {
        observableStageId = new ObservableString(Soort.STAGE);
        observableBedrijfId = new ObservableString(Soort.BEDRIJF);
    }

    public String getBedrijfId() {
        return observableBedrijfId.getTheString();
    }

    public String getStageId() {
        return observableStageId.getTheString();
    }

    public void setBedrijfId(String bedrijfId) {
        observableBedrijfId.setTheString(bedrijfId);
    }

    public void setStageId(String stageId) {
        observableStageId.setTheString(stageId);
    }

	public void addObserver(Soort soort, Observer obs) {
		// TODO Auto-generated method stub
		switch(soort) {
		case STAGE -> observableStageId.addObserver(obs);
		case BEDRIJF -> observableBedrijfId.addObserver(obs);
		}
		
	}
}

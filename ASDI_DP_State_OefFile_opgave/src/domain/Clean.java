package domain;

public class Clean extends FileState {

	public boolean edit() {
		//edit van document 
		fileEditor.toState(new Dirty(fileEditor));
		return true;
	}

	public Clean(FileEditor fileEditor) {
		super(fileEditor);
	}
}

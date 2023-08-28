package domain;

public class Dirty extends FileState {

	public boolean save() {
		fileEditor.toState(new Clean(fileEditor));
		return true;
	}

	public Dirty(FileEditor fileEditor) {
		super(fileEditor);
	}
}

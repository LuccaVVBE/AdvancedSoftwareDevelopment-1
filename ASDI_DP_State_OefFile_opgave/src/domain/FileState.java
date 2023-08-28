package domain;

abstract class FileState {

	protected FileEditor fileEditor;

	public boolean save() {
		return false;
	}

	public boolean edit() {
		return false;
	}

	public FileState(FileEditor fileEditor) {
		this.fileEditor = fileEditor;
	}
}

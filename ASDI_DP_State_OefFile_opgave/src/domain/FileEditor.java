package domain;

import java.io.File;
import java.io.*;

public class FileEditor {

    private final File file;

    private FileState current;

	public FileEditor(File file) {
        this.file = file;
        toState(new Clean(this));
    }

	public boolean save() {
		return current.save();
	}

	public boolean edit() {
		return current.edit();
	}

	protected void toState(FileState state) {
		current = state;
	}

}

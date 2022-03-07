package fileProcess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class CopyFile {
	public static void copy(File source, File target) {
		Path s = Paths.get(source.getAbsolutePath());
		Path t = Paths.get(target.getAbsolutePath());
		try {
			Files.copy(s, t, REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

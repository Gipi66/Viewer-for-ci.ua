package editor;

import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Editor {
	String path;
	DataInputStream in;
	String text;
	URI file;

	private Editor() {

	}

	public Editor(String path) {
		this.path = path;

		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readFile() throws IOException {
		Charset charset = Charset.forName("US-ASCII");
//		 file = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
		 Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(System.out::println);
	}

}

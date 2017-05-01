package editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	private Utils() {

	}

	public static ArrayList<String> read(String fileName) throws FileNotFoundException {
		// Этот спец. объект для построения строки
		StringBuilder sb = new StringBuilder();
		ArrayList<String> as = new ArrayList<String>();

		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getName());
		}

		try {
			// Объект для чтения файла в буфер
			// BufferedReader in = new BufferedReader(new
			// FileReader(file.getAbsoluteFile()));
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
			try {
				// В цикле построчно считываем файл
				String s;
				while ((s = in.readLine()) != null) {
					as.add(s+"\n");
				}
			} finally {
				// Также не забываем закрыть файл
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// Возвращаем полученный текст с файла
		return as;
	}
	public static ArrayList<String> getDataByRegular(String string, String regular) {
		ArrayList<String> results = new ArrayList<String>();
		Pattern pattern;

		pattern = Pattern.compile(regular);
		Matcher result = pattern.matcher(string);
		while (result.find()) {
			results.add(result.group(0));
		}
		/*
		 * Если коллекция пуста вызвать исключение
		 */
		if (results.isEmpty()) {
			throw new IllegalStateException(
					String.format(" Метод getDataByRegular ничего не нашел.\nАргументы: %s, %s", string, regular));
		}
		return results;

	}
}

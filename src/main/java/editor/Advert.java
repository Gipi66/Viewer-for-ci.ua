package editor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advert {
	private String text;
	private ArrayList<String> phoneList = new ArrayList<>();

	public Advert(String text) {
		this.text = text;
		getPhone();
	}

	public void getPhone() {
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(text.replace("-", ""));
		while (matcher.find()) {
			phoneList.add(matcher.group(0));
		}
	}

	public ArrayList<String> getPhones() {
		return phoneList;
	}

	public String getText() {
		return text;
	}

	public String toString() {
		return String.format("text: %s\nphone: %s\n", text, phoneList);
	}

	public static void main(String[] args) {
		ArrayList<String> text = null;
		try {
			text = Utils
					.read("C:\\Users\\Sergey\\Pictures\\11\\2017.04.28_1_chast\\Hoz\\Clients_Hoz_2017.04.28_14.01.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Advert adv = new Advert(text.get(3));
		System.out.println(adv.getPhones().toString());
	}
}

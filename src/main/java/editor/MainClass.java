package editor;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

//import com.github.hmdev.info.ImageInfo; 
//import com.github.hmdev.util.FileNameComparator; 
//import com.github.hmdev.util.LogAppender; 
import com.github.junrar.Archive;
import com.github.junrar.VolumeManager;
import com.github.junrar.exception.RarException;
import com.github.junrar.impl.FileVolumeManager;
import com.github.junrar.rarfile.FileHeader;

public class MainClass {
	private static String regularForPhone = "\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}";

	public static void main(String[] args) {
		String filename = "C:\\Users\\Sergey\\Downloads\\2017.04.28_1_chast.rar";
		File f = new File(filename);
		Archive a = null;
		try {
			a = new Archive(new FileVolumeManager(f));
		} catch (RarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (a != null) {
			a.getMainHeader().print();
			FileHeader fh = a.nextFileHeader();
			while (fh != null) {
				
					try {
						File out = new File("C:\\test\\" + fh.getFileNameString());
						if (fh.isDirectory()) {
							out.mkdirs();
							continue;
						}
						System.out.println(out.getAbsolutePath());
						FileOutputStream os = new FileOutputStream(out);
						a.extractFile(fh, os);
						os.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RarException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fh = a.nextFileHeader();
				
			}
		}
	}

	public static void main2(String[] args) throws RarException, IOException {
		File srcFile = new File("C:\\Users\\Sergey\\Downloads\\2017.04.28_1_chast.rar");
		Archive archive = null;

		try {
			archive = new Archive(srcFile);
		} catch (RarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (FileHeader fileHeader : archive.getFileHeaders()) {
			if (!fileHeader.isDirectory()) {
				System.out.println(fileHeader.getFileNameW().toString());
				System.out.println(fileHeader.getFileNameString());

				// byte[] data = fileHeader.getSubData();
				String s = null;
				InputStream is = null;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				archive.extractFile(fileHeader, baos);
				baos.close();
				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(baos,"windows-1251"));
				// String theString = IOUtils.toString(baos, "windows-1251");

				is = new ByteArrayInputStream(baos.toByteArray());
				// String result = IOUtils.toString(is, StandardCharsets.UTF_8);

				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(new
				// FileInputStream(fileName),"windows-1251"));

			}
		}

	}

	public static void main1(String[] args) {
		ArrayList<String> text = null;
		try {
			text = Utils
					.read("C:\\Users\\Sergey\\Pictures\\11\\2017.04.28_1_chast\\Hoz\\Clients_Hoz_2017.04.28_14.01.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Advert adv = new Advert(text.get(3));
	}
}

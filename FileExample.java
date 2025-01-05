package ch18.sec11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) {

		
		try {
			File dir1 = new File("C:/Temp/images");
			File file1 = new File("C:/Temp/file1.txt");
			File file2 = new File("C:/Temp/file2.txt");
			File file3 = new File("C:/Temp/file3.txt");
			
			if(dir1.exists() == false) {
				dir1.mkdirs();
			}
			if(file1.exists() == false) {
				file1.createNewFile();
			}
			if(file2.exists() == false) {
				file2.createNewFile();
			}
			if(file3.exists() == false) {
				file3.createNewFile();
			}
			
			File dir2 = new File("C:/Temp");
			File[] contents = dir2.listFiles();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
			for(File file : contents) {
				System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
				if(file.isDirectory()) {
					System.out.printf("%-10s%-20s\n", "<DIR>", file.getName());
				} else {
					System.out.printf("%-10s%-20s\n", file.length(), file.getName());
				}

			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("추가된 부분");

	}

}

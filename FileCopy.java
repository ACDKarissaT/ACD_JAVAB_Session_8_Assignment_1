package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
	public static void main(String[] args) {
		File fr = new File("read.txt");
		File fw = new File("copy.txt");
		Scanner br = null;
		BufferedWriter bw = null;
		try {
			if (!fr.exists()) return;
			br = new Scanner(new FileReader(fr));
			if (!fw.exists()) {
				fw.createNewFile();
			} 
			bw = new BufferedWriter(new FileWriter(fw));
			System.out.println("Copying file...");
			while(br.hasNext()) {
				bw.write(br.nextLine());
				bw.newLine();
			}
			System.out.println("Copy complete.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Closing files...");
			br.close();
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

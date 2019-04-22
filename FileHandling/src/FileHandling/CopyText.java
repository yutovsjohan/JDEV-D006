package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {
	public static void main(String[] args) {
		String filename1 = "E://test.txt";
		String filename2 = "E://copy.txt";
		try {
			FileReader fr = new FileReader(filename1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(filename2);
			BufferedWriter bw = new BufferedWriter(fw);

			String chuoi = br.readLine();
			
			while(chuoi!=null) {
				bw.write(chuoi+"\r\n");
				chuoi=br.readLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

package FileHandling;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class GhiFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		String fname = "E://test.txt";
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int n=3;
			for (int i = 0; i < n; i++) {
				System.out.println("Nhap du lieu lan "+(i+1));
				String chuoi = sc.next() + "\r\n";
				
				byte []mangbyte = chuoi.getBytes();
				bos.write(mangbyte);
				bos.flush();
			}
			fos.close();
			bos.close();
			System.out.println("Da ghi file");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

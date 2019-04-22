package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImage {

	public static void main(String[] args) {
		String fname1 = "E://relax//pic//seraphimon_f1.jpg";
		String fname2 = "E://seraphimon.jpg";
		try {
			FileInputStream fis = new FileInputStream(fname1);
			FileOutputStream fos = new FileOutputStream(fname2);
			int c;
			do {
				c=fis.read();
				fos.write(c);
			}while(c!=-1);
			
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

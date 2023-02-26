package hw32_compare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Compare {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Wrong numbers of arguments");
			return;
		}
		System.out.println("File1 = " + args[0]);
		System.out.println("File2 = " + args[1]);

		try (FileInputStream fin1 = new FileInputStream(args[0]); FileInputStream fin2 = new FileInputStream(args[1])) {

			if (fin1.available() != fin2.available()) {
				System.out.println("Different Files!");
				return;
			}
			int file1 = fin1.read();
			int file2 = fin2.read();

			while (file1 != -1) {
				if (file1 != file2) {
					System.out.println("Different Files!");
					return;
				}
				file1 = fin1.read();
				file2 = fin2.read();
			}
			System.out.println("These files are the same");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

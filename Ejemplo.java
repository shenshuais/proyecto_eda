import java.io.*;
import java.util.Scanner;
public class Ejemplo{
	public static void main(String args[]){
		try{
		/*	FileOutputStream fos = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeInt(20000);
			fos.close();
			dos.close();
		*/
			File f = new File("Ejemplo.txt");
			Scanner sc = new Scanner(f).useDelimiter(",");
			System.out.println(sc.nextFloat());
			System.out.println(sc.nextFloat());
			sc.close();
		}catch(Exception e){}
	}
}	


package leer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leer {

    
    public static void main(String[] args) {
        double num;
        String coma;
        File f= new File("Real.text");
        try(Scanner entrada= new Scanner(f)){
            while(entrada.hasNext()){
                
                num=entrada.nextDouble();
                coma=entrada.next();
                System.out.print(num+"");
                System.out.println(coma+"");
            }
        }catch(FileNotFoundException e){
            
        }catch(Exception e){
            
        }
    }
    
}

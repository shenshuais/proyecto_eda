
package ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class Ficheros {

    public static void main(String[] args){
        Random num= new Random();
        try {
            FileWriter fw=new FileWriter("Real.text", true);
            for(int i=0;i<1000;i++){
                int x=(int)(num.nextDouble()*10001);
                double y=(double)x/100;
                fw.write(y+" ,\t");
                
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
        
        
        
    
    
}

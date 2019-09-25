/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Patch
 */
public class ProyectoTista {

    public static void main(String[] args) {
        Random num= new Random();
        try {
            FileWriter fw=new FileWriter("Prueba.text", true);
            for(int i=0;i<1000;i++){
                int x=(int)(num.nextDouble()*10001);
                double y=(double)x/100;
                fw.write(y+",");
                
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoTista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Polifase pf = new Polifase();
        pf.mainPoliphase();
    }
    
}

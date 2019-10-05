/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Patch
 */
public class ProyectoTista {
    public static void main(String[] args){ 
        boolean b=true;
        do{
            JOptionPane.showMessageDialog(null, "Bienvenido, ordenamiento externo");
            String archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo([nombre].txt)");
            String [] metodos={ "Polifase","Mezcla equilibrada","Radix","Salir"};
            String [] orden={"Ascendente","Descendente","Salir"};
            String option;
                option=(String)JOptionPane.showInputDialog(null,"Selecciona un método", "Elegir",JOptionPane.QUESTION_MESSAGE,null,metodos,metodos[0]);
                switch(option){
                    case "Polifase":
                    
                        break;
                    case "Mezcla equilibrada": 
                    
                        break;
                    case "Radix":
                        String subOption;
                        Radix rx;
                        subOption=(String)JOptionPane.showInputDialog(null,"Selecciona un secuencia de ordenamiento ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,orden,orden[0]);
                        switch(subOption){
                            case "Ascendente":
                                rx=new Radix(archivo,true);
                                rx.mainRadix();
                            
                                break;
                            case "Descendente":
                                rx=new Radix(archivo,false);
                                rx.mainRadix();
                            case "Salir":
                                JOptionPane.showMessageDialog(null,"Adios!");
                                b=false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Error");
                            break;
                    }
                    break;		
                case "Salir": 
                    JOptionPane.showMessageDialog(null,"Adios!");
                    b=false;
                    break;
		default:
                    JOptionPane.showMessageDialog(null,"Error");
                    break;
		}
        }while(b);
    }
    public static void crearArchivoAleatorio(){
        Random num= new Random();
        int counter=0;
        try {
            FileWriter fw=new FileWriter(new File("Prueba1000.txt"), true);
            for(int i=0;i<1000;i++){
                int x=(int)(num.nextDouble()*10001);
                double y=(double)x/100;
                fw.write(y+",");
                counter++;
            }
            System.out.println(counter);
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProyectoTista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

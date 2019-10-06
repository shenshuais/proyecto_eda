
package proyectotista;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JOptionPane;

public class ProyectoTista {
    public static void main(String[] args){ 
        boolean b=false;
        JOptionPane.showMessageDialog(null, "          BIENVENIDOS\nORDENAMIENTO EXTERNO\n");
        do{
            File f=null;
            String archivo;
            do{
                archivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo  ([nombre].txt)");
                f=new File(archivo);
            }while(!f.exists());
            String [] metodos={ "Polifase","Mezcla equilibrada","Radix"};
            String [] orden={"Ascendente","Descendente"};
            String [] repetir={"¿Otro archivo?", "Salir"};
            String option;
            
                option=(String)JOptionPane.showInputDialog(null,"Selecciona un método", "Elegir",JOptionPane.QUESTION_MESSAGE,null,metodos,metodos[0]);
                switch(option){
                    case "Polifase":
                        break;
                    case "Mezcla equilibrada": 
                    
                        break;
                    case "Radix":
                        String subOption;
                        Distribucion rx;
                            subOption=(String)JOptionPane.showInputDialog(null,"Selecciona una secuencia de ordenamiento ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,orden,orden[0]);
                            switch(subOption){
                                case "Ascendente":
                                    rx=new Distribucion(archivo,true);
                                    rx.mainDistribucion();
                                    break;
                                case "Descendente":
                                    rx=new Distribucion(archivo,false);
                                    rx.mainDistribucion();
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null,"Error");
                                    break;
                            }
                            subOption=(String)JOptionPane.showInputDialog(null,"Selecciona ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,repetir,repetir[0]);
                            switch(subOption){
                                case "¿Otro archivo?":
                                    b=true;
                                    break;
                                case "Salir":
                                    b=false;
                                    JOptionPane.showMessageDialog(null,"Adios!");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null,"Error");
                                    break;
                            }
                        break;		
                    default:
                        JOptionPane.showMessageDialog(null,"Error");
                        break;
		}
            
        }while(b);
    }  
    
}

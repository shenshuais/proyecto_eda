
package proyectotista;
import java.io.File;
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
                        String subOption;
                        Polifase ps;
                            subOption=(String)JOptionPane.showInputDialog(null,"Selecciona una secuencia de ordenamiento ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,orden,orden[0]);
                            switch(subOption){
                                case "Ascendente":
                                    ps=new Polifase(archivo,true);
                                    ps.mainPoliphase();
                                    break;
                                case "Descendente":
                                    ps=new Polifase(archivo,true);
                                    ps.mainPoliphase();
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
                    case "Mezcla equilibrada": 
                            String subOption1;
                            MezclaEquilibrada mz;
                            subOption1=(String)JOptionPane.showInputDialog(null,"Selecciona una secuencia de ordenamiento ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,orden,orden[0]);
                            switch(subOption1){
                                case "Ascendente":
                                    mz=new MezclaEquilibrada(archivo,true);
                                    mz.mainMezcla();
                                    break;
                                case "Descendente":
                                    mz=new MezclaEquilibrada(archivo,true);
                                    mz.mainMezcla();
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
                    case "Radix":
                        String subOption2;
                        Distribucion rx;
                            subOption2=(String)JOptionPane.showInputDialog(null,"Selecciona una secuencia de ordenamiento ", "Elegir",JOptionPane.QUESTION_MESSAGE,null,orden,orden[0]);
                            switch(subOption2){
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

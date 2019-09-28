
package proyectotista;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Radix {
    File q0=new File("q0.txt");
    File q1=new File("q1.txt");
    File q2=new File("q2.txt");
    File q3=new File("q3.txt");
    File q4=new File("q4.txt");
    File q5=new File("q5.txt");
    File q6=new File("q6.txt");
    File q7=new File("q7.txt");
    File q8=new File("q8.txt");
    File q9=new File("q9.txt");
    File og;
    public Radix(File f){
        og=f;
    }
    public void particion(int cifra) throws IOException{
        int aux;
        float num;
        Scanner sc=new Scanner(og).useDelimiter(",");
        FileWriter fw0=new FileWriter(q0, true);
        FileWriter fw1=new FileWriter(q1, true);
        FileWriter fw2=new FileWriter(q2, true);
        FileWriter fw3=new FileWriter(q3, true);
        FileWriter fw4=new FileWriter(q4, true);
        FileWriter fw5=new FileWriter(q5, true);
        FileWriter fw6=new FileWriter(q6, true);
        FileWriter fw7=new FileWriter(q7, true);
        FileWriter fw8=new FileWriter(q8, true);
        FileWriter fw9=new FileWriter(q9, true);
        while(sc.hasNext()){
            num=sc.nextFloat();
            aux=cifra(num, cifra);
            switch(aux){
                case 0:
                    fw0.write(num+",");
                    //if(!sc.hasNext()){
                     //   fw0.write(num+",");
                    //}
                    break;
                case 1:
                    fw1.write(num+",");
                    
                    break;
                case 2:
                    fw2.write(num+",");
                    
                    break;
                case 3:
                    fw3.write(num+",");
                    
                    break;
                case 4:
                    fw4.write(num+",");
                   
                    break;
                case 5:
                    fw5.write(num+",");
                    
                    break;
                case 6:
                    fw6.write(num+",");
                    
                    break;
                case 7:
                    fw7.write(num+",");
                    
                    break;
                case 8:
                    fw8.write(num+",");
                    break;
                case 9:
                    fw9.write(num+",");
                    break;
                default:
                    break;
                }
        }
        fw0.close();
        fw1.close();
        fw2.close();
        fw3.close();
        fw4.close();
        fw5.close();
        fw6.close();
        fw7.close();
        fw8.close();
        fw9.close();
        borrar(og);
        
    }
    public void vaciaColas() throws IOException{
        Scanner sc0=new Scanner(q0).useDelimiter(",");
        Scanner sc1=new Scanner(q1).useDelimiter(",");
        Scanner sc2=new Scanner(q2).useDelimiter(",");
        Scanner sc3=new Scanner(q3).useDelimiter(",");
        Scanner sc4=new Scanner(q4).useDelimiter(",");
        Scanner sc5=new Scanner(q5).useDelimiter(",");
        Scanner sc6=new Scanner(q6).useDelimiter(",");
        Scanner sc7=new Scanner(q7).useDelimiter(",");
        Scanner sc8=new Scanner(q8).useDelimiter(",");
        Scanner sc9=new Scanner(q9).useDelimiter(",");
        FileWriter fw=new FileWriter(og, true);
        escribir(sc0, fw);
        escribir(sc1, fw);
        escribir(sc2, fw);
        escribir(sc3, fw);
        escribir(sc4, fw);
        escribir(sc5, fw);
        escribir(sc6, fw);
        escribir(sc7, fw);
        escribir(sc8, fw);
        escribir(sc9, fw);
        sc0.close();
        sc1.close();
        sc2.close();
        sc3.close();
        sc4.close();
        sc5.close();
        sc6.close();
        sc7.close();
        sc8.close();
        sc9.close();
        fw.close();
        borrar(q0);
        borrar(q1);
        borrar(q2);
        borrar(q3);
        borrar(q4);
        borrar(q5);
        borrar(q6);
        borrar(q7);
        borrar(q8);
        borrar(q9);
        
    }
    public void escribir(Scanner sc, FileWriter fw) throws IOException{
        float aux;
        while(sc.hasNext()){
            aux=sc.nextFloat();
            fw.write(aux+",");
        }
    }
    public void borrar(File f) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();
    }
    public int cifra(float num, int cifra){
        int x=(int)((num*1000)/10);
        int i = (int)((x)/(Math.pow(10, (cifra-1))));
        int j=i%10;
        //System.out.println(i);
        return j;
    }
    public void mainRadix(){
        
        try {
            for(int i=1;i<5;i++){
                particion(i);
                vaciaColas(); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Radix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


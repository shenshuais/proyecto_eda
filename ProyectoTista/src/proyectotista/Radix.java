package proyectotista;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Radix{
    File[] f=new File[10];
    File og=null;
    String directorio;
    boolean orden;
    int it=0;
    public Radix(String fileName, boolean OpOrden){
        og= new File(fileName);
        String path = og.getAbsolutePath();
        directorio = path.substring(0,path.length()-4) + "_Iteraciones";
        new File(directorio).mkdirs();
        orden=OpOrden;
        for(int i=0;i<10;i++){
            f[i]=new File("q"+i);
        }
        
        
    }
    public void particion(int cifra) throws IOException{
        int aux;
        float num;
        Scanner sc=new Scanner(og).useDelimiter(",");
        FileWriter[] fw=new FileWriter[10];
        for(int i=0; i<10; i++){
            fw[i]=new FileWriter(f[i], true);
        }
        while(sc.hasNext()){
            num=sc.nextFloat();
            aux=cifra(num, cifra);
            switch(aux){
                case 0:
                    fw[0].write(num+",");
                    break;
                case 1:
                    fw[1].write(num+",");
                    
                    break;
                case 2:
                    fw[2].write(num+",");
                    
                    break;
                case 3:
                    fw[3].write(num+",");
                    
                    break;
                case 4:
                    fw[4].write(num+",");
                   
                    break;
                case 5:
                    fw[5].write(num+",");
                    
                    break;
                case 6:
                    fw[6].write(num+",");
                    
                    break;
                case 7:
                    fw[7].write(num+",");
                    
                    break;
                case 8:
                    fw[8].write(num+",");
                    break;
                case 9:
                    fw[9].write(num+",");
                    break;
                default:
                    break;
                }
        }
        for(int i=0; i<10; i++){
            fw[i].close();
        }
        borrar(og);
        
    }
    public void vaciaColas() throws IOException{
        Scanner[] sc= new Scanner[10];
        for(int i=0; i<10; i++){
            sc[i]=new Scanner(f[i]).useDelimiter(",");
        }
        System.out.println("Iteración "+(++it)+(" [ "));
        FileWriter iter = new FileWriter(new File("/"+directorio+"/Iteracion_"+(it)+"Radix_"+og.getName()));
        FileWriter fw=new FileWriter(og, true);
        if(orden){
            for(int i=0; i<10; i++){
            escribir(sc[i], fw, iter);
            sc[i].close();
            }
        }else{
            for(int i=9; i>=0; i--){
            escribir(sc[i], fw, iter);
            sc[i].close();
            }
        }
        iter.close();
        System.out.println(" ]");
        fw.close();
        for(int i=0; i<10; i++){
            borrar(f[i]);
        }    
    }
    
    public void escribir(Scanner sc, FileWriter fw, FileWriter iter) throws IOException{
        float aux;
        while(sc.hasNext()){
            aux=sc.nextFloat();
            fw.write(aux+",");
            iter.write(aux+",");
            System.out.print(aux+",");
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
        return j;
    }
    public int mayor(File f) throws FileNotFoundException{
        int cifras=0;
        Scanner sc=new Scanner(f).useDelimiter(",");
        float mayor=sc.nextFloat();
        float aux;
        while(sc.hasNext()){
            aux=sc.nextFloat();
            if(aux>mayor){
                mayor=aux;
            }
        }
        sc.close();  
        int x=(int)((mayor*1000)/10);
        while(x!=0){
            x=x/10;
            cifras=cifras+1;
        }
        return cifras;
        
    }
    public void mainRadix(){
        try {
            System.out.println("Iteraciones de Radix para "+og.getName());
            int mayor=mayor(og)+1;
            for(int i=1;i<mayor;i++){
                particion(i);
                vaciaColas(); 
            }
            for(int i=0; i<10; i++){
                f[i].delete();
            }
            System.out.println("La salida quedó en el archivo original, pero se ha renombrado");
            og.renameTo(new File("Salida_"+og.getName()));
        } catch (IOException ex) {
            Logger.getLogger(Radix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


package proyectotista;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Polifase {
    private final int BLOCKSIZE = 100;
    private int it=0;
    File original = null;
    File f1 = new File("Auxiliar1.txt");
    File f2 = new File("Auxiliar2.txt");
    File f3 = new File("Auxiliar3.txt");
    String directorio = null;
    int tamanoDeEntrada;
    boolean orden;
    
    public Polifase(String fileName, Boolean orden){
        original = new File(fileName);
        String  path = original.getAbsolutePath(); 
        directorio = path.substring(0, path.length()-4) + "_Iteraciones"; 
        new File(directorio).mkdirs();
        this.orden = orden;
    }
    
    private void divideAndSort() throws IOException{
        ArrayList<Float> block = new ArrayList<>(BLOCKSIZE);
        boolean writeFile = true;
        Scanner sc = new Scanner(original).useDelimiter(",");
        int i;
        while(sc.hasNext()){
            for(i = 0; i <100 && sc.hasNext(); i++){
                block.add(sc.nextFloat());
            }
            Float[] blockArr = new Float[block.size()];
            blockArr = block.toArray(blockArr);
            sort(blockArr, 0, blockArr.length-1);
            System.out.println("Iteración "+(++it)+Arrays.toString(blockArr));
            if(writeFile){
                writeFiles(blockArr, f1);
                writeFiles(blockArr, new File("/"+directorio+"/Iteracion"+it+"_Polifase_"+original.getName()));
                writeFile = false;
            }else{
                writeFiles(blockArr, f2);
                writeFiles(blockArr, new File("/"+directorio+"/Iteracion"+it+"_Polifase_"+original.getName()));
                writeFile = true;
            }
            block.clear();
        }
        borrar(original);
    }
    
    private void writeFiles(Float[] block, File f1) throws IOException{
        FileWriter fw = new FileWriter(f1, true);
        for (int j = 0; j < block.length; j++) {
            fw.write(block[j] + ",");
        }
        fw.close();
    }
    
    private void merge(Scanner sc1, Scanner sc2, FileWriter fw, FileWriter fw2, int mergeSize) throws IOException{
        boolean b1=true;
        float aux1=sc1.nextFloat();
        float aux2=sc2.nextFloat();
        
        while(sc1.hasNext() || sc2.hasNext()){
            if(b1){
                System.out.print("Iteración "+(++it)+"[");
                FileWriter fiter = new FileWriter((new File("/"+directorio+"/Iteracion"+it+"_Polifase_"+original.getName())), true);
                int counterSc1=0;
                int counterSc2=0;
                while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
                    if((aux1<=aux2 && orden) || (aux1>=aux2 && !orden)){
                        fw.write(aux1+",");
                        fiter.write(aux1+",");
                        counterSc1++;
                        System.out.print(aux1+",");
                        aux1=sc1.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux1+",");
                            fiter.write(aux1+",");
                            System.out.print(aux1+",");
                        }
                    }else{
                        fw.write(aux2+",");
                        fiter.write(aux2+",");
                        System.out.print(aux2+",");
                        counterSc2++;
                        aux2=sc2.nextFloat();
                        if(!sc2.hasNext()){
                            fw.write(aux2+",");
                            fiter.write(aux2+",");
                            System.out.print(aux2+",");
                        }
                    }    
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw.write(aux2+",");
                    fiter.write(aux2+",");
                    System.out.print(aux2+",");
                    counterSc2++;
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext()){
                        fw.write(aux2+",");
                        fiter.write(aux2+",");
                        System.out.print(aux2+",");
                    }
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw.write(aux1+",");
                    fiter.write(aux1+",");
                    counterSc1++;
                    System.out.print(aux1+",");
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext()){
                        fw.write(aux1+",");
                        fiter.write(aux1+",");
                        System.out.print(aux1+",");
                    }
                }
                b1=false;
                System.out.println("]");
                fiter.close();
                
            }else{
                System.out.print("Iteración "+(++it)+"[");
                FileWriter fiter = new FileWriter((new File("/"+directorio+"/Iteracion"+it+"_Polifase_"+original.getName())), true);
                int counterSc1=0;
                int counterSc2=0;
                while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
                    if((aux1<=aux2 && orden) || (aux1>=aux2 && !orden)){
                        fw2.write(aux1+",");
                        fiter.write(aux1+",");
                        counterSc1++;
                        System.out.print(aux1+",");
                        aux1=sc1.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux1+",");
                            fiter.write(aux1+",");
                            System.out.print(aux1+",");                
                        }
                    }else{
                        fw2.write(aux2+",");
                        fiter.write(aux2+",");
                        counterSc2++;
                        System.out.print(aux2+",");
                        aux2=sc2.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux2+",");
                            fiter.write(aux2+",");
                            System.out.print(aux2+",");
                        }
                    }   
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw2.write(aux2+",");
                    fiter.write(aux2+",");
                    counterSc2++;
                    System.out.print(aux2+",");
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext()){
                        fw2.write(aux2+",");
                        fiter.write(aux2+",");
                        System.out.print(aux2+",");
                    }
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw2.write(aux1+",");
                    fiter.write(aux1+",");
                    System.out.print(aux1+",");
                    counterSc1++;
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext()){
                        fw2.write(aux1+",");
                        fiter.write(aux1+",");
                        System.out.print(aux1+",");
                    }
                }
                b1=true;
                System.out.println("]");
                fiter.close();
            } 
        }
            
    }
    
    private void borrar(File f) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();
    }
    
    private int tamanoDeEntrada() throws FileNotFoundException{
        Scanner sc=new Scanner(original).useDelimiter(",");
        int counter=0;
        while(sc.hasNext()){
            sc.nextFloat();
            counter++;
        }
        return counter;
    }
     
    private boolean mergeIntoFiles(){
        boolean b1=true;
        try{
            int mergeSize=BLOCKSIZE;
            while(mergeSize < tamanoDeEntrada){
                if(b1){
                    Scanner sc1=new Scanner(f1).useDelimiter(",");
                    Scanner sc2=new Scanner(f2).useDelimiter(",");
                    FileWriter fw=new FileWriter(f3, true);
                    FileWriter fw2=new FileWriter(original, true);
                    merge(sc1, sc2, fw, fw2, mergeSize);
                    sc1.close();
                    sc2.close();
                    fw.close();
                    fw2.close();
                    borrar(f1);
                    borrar(f2);
                    b1=false;
                }else{
                    Scanner sc3=new Scanner(f3).useDelimiter(",");
                    Scanner sc4=new Scanner(original).useDelimiter(",");
                    FileWriter fw3=new FileWriter(f1, true);
                    FileWriter fw4=new FileWriter(f2, true);
                    merge(sc3, sc4, fw3, fw4, mergeSize);
                    sc3.close();
                    sc4.close();
                    fw3.close();
                    fw4.close();
                    borrar(f3);
                    borrar(original);
                    b1=true;
                }
                mergeSize=mergeSize*2;
            }
        }catch(IOException ex){
            System.out.println("Error");
        }
        return !b1;
    }
        
 
    public void mainPoliphase(){
        try{
            System.out.println("Iteraciones de Polifase para "+original.getName());
            tamanoDeEntrada = tamanoDeEntrada();
            divideAndSort();
            boolean numArch = mergeIntoFiles();
            original.delete();
            f2.delete();
            if(numArch){
                
                f3.renameTo(new File("Salida_"+original.getName()));
                System.out.println("La salida quedó en el archivo auxiliar 3, pero se ha renombrado.");
                f1.delete();
            }else{
                f3.delete();
                System.out.println("La salida quedó en el archivo auxiliar 1, pero se ha renombrado.");
               
                f1.renameTo(new File("Salida"+original.getName()));
            }
            System.out.println("Las iteraciones están en una carpeta con el mismo nombre del archivo original.");
        }catch(IOException ex){
            System.out.println("Error");
        }
    }
    
    int partition(Float arr[], int low, int high){
        float pivot = arr[high];
        int i = (low-1);
        for(int j=low; j<high; j++){
            if((arr[j] <= pivot&& orden)||(arr[j] >= pivot&& !orden)){
                i++;
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        float temp = arr[i+1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i +1;
    }
    
    void sort(Float arr[], int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
 
    
    
}

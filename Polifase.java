package proyecto;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Patch
 */
public class Polifase {
    private final int BLOCKSIZE = 100;
    private int blocksNumber=0;
    File original = null;
    File f1 = new File("Auxiliar1.txt");
    File f2 = new File("Auxiliar2.txt");
    File f3 = new File("Auxiliar3.txt");
    float aux1, aux2;
    
    public Polifase(String fileName){
        original = new File(fileName);
    }
    
    public void phase1() throws IOException{
        ArrayList<Float> block = new ArrayList<>(BLOCKSIZE);
        boolean writeFile = true;
        Scanner sc = new Scanner(original).useDelimiter(",");
        int i;
        while(sc.hasNext()){
            for(i = 0; i <100 && sc.hasNext(); i++){
                block.add(sc.nextFloat());
            }
            Float[] blockArr = new Float[block.size()];
            System.out.println(block);
            blockArr = block.toArray(blockArr);
            
            if(writeFile){
                writeFiles(blockArr, f1);
                writeFile = false;
            }else{
                writeFiles(blockArr, f2);
                writeFile = true;
            }
            blocksNumber++;
            block.clear();
        }
        System.out.println(blocksNumber);
        borrar(original);
    }
    
    public void writeFiles(Float[] block, File f1) throws IOException{
        FileWriter fw = new FileWriter(f1, true);
        Quicksort q = new Quicksort();
        q.sort(block, 0, block.length-1);
        for (int j = 0; j < block.length; j++) {
            fw.write(block[j] + ",");
        }
        fw.close();
    }
    
    public void merge(Scanner sc1, Scanner sc2, FileWriter fw, FileWriter fw2, int mergeSize) throws IOException{
        boolean b1=true;
        float aux1=sc1.nextFloat();
        float aux2=sc2.nextFloat();
        while(sc1.hasNext() || sc2.hasNext()){
            if(b1==true){
                int counterSc1=0;
                int counterSc2=0;
                while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
                    if(aux1<=aux2){
                        fw.write(aux1+",");
                        counterSc1++;
                        System.out.print(aux1+",");
                        aux1=sc1.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux1+",");
                            System.out.print(aux1+",");
                        }
                    }else{
                        fw.write(aux2+",");
                        System.out.print(aux2+",");
                        counterSc2++;
                        aux2=sc2.nextFloat();
                        if(!sc2.hasNext()){
                            fw.write(aux2+",");
                            System.out.print(aux2+",");
                        }
                    }   
                    
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw.write(aux2+",");
                    System.out.print(aux2+",");
                    counterSc2++;
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext()){
                        fw.write(aux2+",");
                        System.out.print(aux2+",");
                    }
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw.write(aux1+",");
                    counterSc1++;
                    System.out.print(aux1+",");
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext()){
                        fw.write(aux1+",");
                        System.out.print(aux1+",");
                    }
                }
                b1=false;
                System.out.println();
            }else{
                int counterSc1=0;
                int counterSc2=0;
                while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
                    if(aux1<=aux2){
                        fw2.write(aux1+",");
                        counterSc1++;
                        System.out.println(aux1+",");
                        aux1=sc1.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux1+",");
                            System.out.print(aux1+",");                
                        }
                    }else{
                        fw2.write(aux2+",");
                        counterSc2++;
                        System.out.print(aux2+",");
                        aux2=sc2.nextFloat();
                        if(!sc1.hasNext()){
                            fw.write(aux2+",");
                            System.out.print(aux2+",");
                        }
                    }   
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw2.write(aux2+",");
                    counterSc2++;
                    System.out.print(aux2+",");
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext()){
                        fw2.write(aux2+",");
                        System.out.print(aux2+",");
                    }
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw2.write(aux1+",");
                    System.out.print(aux1+",");
                    counterSc1++;
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext()){
                        fw2.write(aux1+",");
                        System.out.print(aux1+",");
                    }
                }
                b1=true;
                System.out.println();
            } 
        }
            
    }
    public void borrar(File f) throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();
    }
     public int tamanoDeEntrada(File f) throws FileNotFoundException{
        Scanner sc=new Scanner(f).useDelimiter(",");
        int counter=0;
        float d=0.0f;
        while(sc.hasNext()){
            d=sc.nextFloat();
            counter++;
        }
        return counter;
    }
    public void cicloDeMerge(int tamano){
        try{
            int tamanoDeEntrada=tamano;
            boolean b1=true;
            int mergeSize=BLOCKSIZE;
            System.out.println(tamanoDeEntrada);
            while(mergeSize<tamanoDeEntrada){
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
    }
 
    public void mainPoliphase(){
        try{
            int tamano=tamanoDeEntrada(original);
            phase1();
            cicloDeMerge(tamano);
        }catch(IOException ex){
            System.out.println("Error");
        }
    }
    
    
}

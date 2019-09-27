<<<<<<< HEAD
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Patch
 */
public class Polifase {
    private final int BLOCKSIZE = 100;
    File f1 = new File("Auxiliar1.txt");
    File f2 = new File("Auxiliar2.txt");
    File f3 = new File("Auxiliar3.txt");
    File og;
    public Polifase(File f){
        og=f;
    }
   
    public void phase1(File fileName) throws IOException{
        float block[] = new float[BLOCKSIZE];
        boolean writeFile = true;
        Scanner sc = new Scanner((fileName)).useDelimiter(",");
        while(sc.hasNext()){
            int i;
            for(i = 0; i <100 && sc.hasNext(); i++){
                block[i] = sc.nextFloat();
                if (block[i]==0)
                    break;
            }
            if(i == 99){
                if(writeFile){
                    writeFiles(block, f1);
                    writeFile = false;
                }else{
                    writeFiles(block, f2);
                    writeFile = true;
            }
            }else{
                if(writeFile){
                    writeFiles(java.util.Arrays.copyOf(block, i), f1);
                    writeFile = false;
                }else{
                    writeFiles(java.util.Arrays.copyOf(block, i), f2);
                    writeFile = true;
                }
            }
        }
        borrar(og);
    }
    public void writeFiles(float[] block, File f1) throws IOException{
        FileWriter fw = new FileWriter(f1, true);
        System.out.println(java.util.Arrays.toString(block));
        Quicksort qk= new Quicksort();
        qk.sort(block, 0, block.length-1);
        for(int j = 0; j < block.length; j++){
            fw.write(block[j]+",");
        }
        fw.close();
        for(int i=0;i<block.length;i++){
            block[i]=0;
        }
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
                        aux1=sc1.nextFloat();
                    }else{
                        fw.write(aux2+",");
                        
                        counterSc2++;
                        aux2=sc2.nextFloat();
                    }   
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw.write(aux2+",");
                    
                    counterSc2++;
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext())
                        fw.write(aux2+",");
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw.write(aux1+",");
                    counterSc1++;
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext())
                        fw.write(aux1+",");

                }
                b1=false;
            }else{
                int counterSc1=0;
                int counterSc2=0;
                while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
                    if(aux1<=aux2){
                        fw2.write(aux1+",");
                        counterSc1++;
                        aux1=sc1.nextFloat();
                    }else{
                        fw2.write(aux2+",");
                        counterSc2++;
                        aux2=sc2.nextFloat();
                    }   
                }

                while(counterSc2<mergeSize && sc2.hasNext()){
                    fw2.write(aux2+",");
                    counterSc2++;
                    aux2=sc2.nextFloat();
                    if(!sc2.hasNext())
                        fw2.write(aux2+",");
                }

                while(counterSc1<mergeSize && sc1.hasNext()){
                    fw2.write(aux1+",");
                    
                    counterSc1++;
                    aux1=sc1.nextFloat();
                    if(!sc1.hasNext())
                        fw2.write(aux1+",");

                }
                b1=true;
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
                if(b1==true){
                    Scanner sc1=new Scanner(f1).useDelimiter(",");
                    Scanner sc2=new Scanner(f2).useDelimiter(",");
                    FileWriter fw=new FileWriter(f3, true);
                    FileWriter fw2=new FileWriter(og, true);
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
                    Scanner sc4=new Scanner(og).useDelimiter(",");
                    FileWriter fw3=new FileWriter(f1, true);
                    FileWriter fw4=new FileWriter(f2, true);
                    merge(sc3, sc4, fw3, fw4, mergeSize);
                    sc3.close();
                    sc4.close();
                    fw3.close();
                    fw4.close();
                    borrar(f3);
                    borrar(og);
                    b1=true;
                }
                mergeSize=mergeSize*2;
            }
        }catch(IOException ex){
            System.out.println("Error");
        }
    }
    public void mainPoliphase() throws IOException{
            int tamano=tamanoDeEntrada(og);
            phase1(og);
            cicloDeMerge(tamano);
    }
}
>>>>>>> f811390682ff26f761aafc38d40ebe140d4f1a61

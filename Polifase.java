/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Patch
 */
public class Polifase {
    private final int BLOCKSIZE = 100;
    //private float block[] = new float[BLOCKSIZE];
    File f1 = new File("Auxiliar1.txt");
    File f2 = new File("Auxiliar2.txt");
    File f3 = new File("Auxiliar3.txt");
    File og = new File("Prueba.txt");
    
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
                
            System.out.println(Arrays.toString(block));
/*            if(writeFile){
                writeFiles(true);
                writeFile = false;
            }else{
                writeFiles(false);
                writeFile = true;
            }
*/
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter(og));
        bw.write("");
        bw.close();
    }
    
    public void writeFiles(float[] block, File f1) throws IOException{
        FileWriter fw = new FileWriter(f1, true);
        //FileWriter fw2 = new FileWriter(f2, true);
        //if(auxFile == true){
        Quicksort qk= new Quicksort();
        qk.sort(block, 0, block.length-1);
        for(int j = 0; j < block.length; j++){
            fw.write(block[j]+",");
        }
            //    }else{
              //      for(int j = 0; j < 100; j++){
                //        fw2.write(block[j]+",");
                  //  }
                //}
        fw.close();
        //fw2.close();
        for(int i=0;i<block.length;i++){
            block[i]=0;
        }
    }
    
    public void merge() throws IOException{
        int counterSc1=0;
        int counterSc2=0;
        Scanner sc1=new Scanner(new File("Auxiliar1.txt")).useDelimiter(",");
        Scanner sc2=new Scanner(new File("Auxiliar2.txt")).useDelimiter(",");
        FileWriter fw= new FileWriter("Prueba.txt", true);
        FileWriter fw2= new FileWriter("Auxiliar3.txt", true);
        float aux1=sc1.nextFloat();
        float aux2=sc2.nextFloat();
        while((counterSc1<100) && (counterSc2<100) && sc1.hasNext() && sc2.hasNext()){
            if(aux1<=aux2){
                fw.write(aux1+",");
                aux1=sc1.nextFloat();
                counterSc1++;
            }else{
                fw.write(aux2+",");
                aux2=sc2.nextFloat();
                counterSc2++;
            }   
        }
        while(counterSc1==100 && counterSc2<100 && sc2.hasNext()){
            fw.write(aux2+",");
            aux2=sc2.nextFloat();
            counterSc2++;
        }
        while(counterSc2==100 && counterSc1<100 && sc1.hasNext()){
            fw.write(aux1+",");
            aux1=sc1.nextFloat();
            counterSc1++;
        }
        counterSc1=0;
        counterSc2=0;
        while(counterSc1<100 && counterSc2<100 && sc1.hasNext() && sc2.hasNext()){
            if(aux1<=aux2){
                fw2.write(aux1+",");
                aux1=sc1.nextFloat();
                counterSc1++;
            }else{
                fw2.write(aux2+",");
                aux2=sc2.nextFloat();
                counterSc2++;
            }   
        }
        while(counterSc1==100 && counterSc2<100 && sc2.hasNext()){
            fw2.write(aux2+",");
            aux2=sc2.nextFloat();
            counterSc2++;
        }
        while(counterSc2==100 && counterSc1<100 && sc1.hasNext()){
            fw2.write(aux1+",");
            aux1=sc1.nextFloat();
            counterSc1++;
        }
        fw.close();
        fw2.close();
        
    }
    public int merge2(Scanner sc1, Scanner sc2, FileWriter fw, int mergeSize) throws IOException{
        int counter=0;
        int counterSc1=0;
        int counterSc2=0;
        float aux1 = 0 , aux2 = 0;
        if(sc1.hasNext())
            aux1=sc1.nextFloat();
        
        if(sc2.hasNext())
            aux2=sc2.nextFloat();
            
        while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
            if(aux1<=aux2){
                fw.write(aux1+",");
                counter++;
                counterSc1++;
                aux1=sc1.nextFloat();
            }else{
                fw.write(aux2+",");
                counter++;
                counterSc2++;
                aux2=sc2.nextFloat();
            }   
        }
        
        while(counterSc2<mergeSize && sc2.hasNext()){
            fw.write(aux2+",");
            counter++;
            counterSc2++;
            aux2=sc2.nextFloat();
            if(!sc2.hasNext())
                fw.write(aux2+",");
        }
        
        while(counterSc1<mergeSize && sc1.hasNext()){
            fw.write(aux1+",");
            counter++;
            counterSc1++;
            aux1=sc1.nextFloat();
            if(!sc1.hasNext())
                fw.write(aux1+",");
            
        }
        
        System.out.println(aux1);
        System.out.println(aux2);
        System.out.println("Valor de contador"+counter);
        return 1;
    }
    /*    else if(sc1.hasNext() && !sc2.hasNext()){
            float aux1 = sc1.nextFloat();
            while(sc1.hasNext() && counterSc1<mergeSize){
                fw.write(aux1+",");
                aux1=sc1.nextFloat();
                counterSc1++;
            }
            return 1;
        }
        else if(sc2.hasNext() && !sc1.hasNext()){
            float aux2 = sc2.nextFloat();
            while(sc1.hasNext() && counterSc2<mergeSize){
                fw.write(aux2+",");
                aux2=sc2.nextFloat();
                counterSc2++;
            }
            return 1;
        }
        return -1;
        */
 

    public void mainPoliphase(){
        /*
        try {
            FileWriter fw=new FileWriter(og, true);
            for(int i=0;i<300;i++){
                fw.write((i+1)+",");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        try{
            //phase1(og);
            
            Scanner sc1=new Scanner(new File("Auxiliar1.txt")).useDelimiter(",");
            Scanner sc2=new Scanner(new File("Auxiliar2.txt")).useDelimiter(",");
            FileWriter fw=new FileWriter(f3, true);
            FileWriter fw2=new FileWriter(og, true);
            
            merge2(sc1, sc2, fw, 100);
            merge2(sc1, sc2, fw2, 100);
            fw.close();
            fw2.close();
            sc1.close();
            sc2.close();
        }catch(IOException ex){
            System.out.println("Error");
        }

    }
}

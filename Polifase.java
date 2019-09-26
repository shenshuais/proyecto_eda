/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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
    
    public void phase1(String fileName) throws IOException{
        float block[] = new float[BLOCKSIZE];
        boolean writeFile = true;
        Scanner sc = new Scanner(new File(fileName)).useDelimiter(",");
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
    }
    
    public void writeFiles(float[] block, File f1) throws IOException{
        FileWriter fw = new FileWriter(f1, true);
        //FileWriter fw2 = new FileWriter(f2, true);
        //if(auxFile == true){
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
    
    
    public void mainPoliphase(){
        try{
            phase1("/Users/Patch/NetBeansProjects/ProyectoTista/Prueba.txt");
        }catch(IOException ex){
            System.out.println("Error");
        }
    }
}

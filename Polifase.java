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
/**
 *
 * @author Patch
 */
public class Polifase {
    private final int BLOCKSIZE = 100;
    private float block[] = new float[BLOCKSIZE];
    File f1 = new File("Auxiliar1");
    File f2 = new File("Auxiliar2");
    File f3 = new File("Auxiliar3");
    public void phase1(String fileName) throws IOException{
            boolean auxFile = false;
            Scanner sc = new Scanner(new File(fileName)).useDelimiter(",");
            while(sc.hasNext()){
                for(int i = 0; i <100; i++){
                    block[i] = sc.nextFloat();
                }
                //Quicksort
                if(auxFile == false){
                    FileWriter fw = new FileWriter(f1, true);
                    for(int j = 0; j < 100; j++){
                        fw.write(block[j]+",");
                    }
                    auxFile = true;
                }else{
                    FileWriter fw = new FileWriter(f2, true);
                    for(int j = 0; j < 100; j++){
                        fw.write(block[j]+",");
                    }
                    auxFile = false;
                }
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

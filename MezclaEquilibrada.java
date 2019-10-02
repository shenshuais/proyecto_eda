/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patch
 */
public class MezclaEquilibrada {
    File f1 = new File("Auxiliar1.txt");
    File f2 = new File("Auxiliar2.txt");
    File f3 = new File("Auxiliar3.txt");
    
    public void divide(String fileName) throws IOException{
        float previous = 0, current = 0;
        int file = 1, i = 1;
        FileWriter fw = new FileWriter(f1, true);
        FileWriter fw2 = new FileWriter(f2, true);
        Scanner sc = new Scanner(new File(fileName)).useDelimiter(",");
        String carpeta = "Iteraciones_Mezcla_Div";
        new File(carpeta).mkdirs();
        File og = new File(fileName);
        System.out.println("División:");
        System.out.println("Bloque: " + i);
        while(sc.hasNext()){
            previous = current;
            current = sc.nextFloat();
            
            if(previous == 0){
                previous = current;
            }
            
            if(previous > current){
                if(file == 1){
                    i++;
                    System.out.println();
                    System.out.println("Bloque: " + i);
                    file = 2;
                }
                else{
                    i++;
                    System.out.println();
                    System.out.println("Bloque: " + i);
                    file = 1;
                }
            }
            
            if(file == 1){
                fw.write(current + ",");
            }else{
                fw2.write(current + ",");
            }
            System.out.print(current);
            
        writeFiles(new File("/"+carpeta+"/IteracionDivision"+i), current);    
        }
        sc.close();
        fw.close();
        fw2.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write("");
        bw.close();
        System.out.println();
    }
    
    public void writeFiles(File fileName, float num) throws IOException{
        FileWriter fw = new FileWriter(fileName.getName(), true);
        fw.write(num + ",");
        fw.close();
    }
    
    public void merge(String fileName, String fileName2, String fileName3, String fileName4, int j) throws IOException{
        float previous = 0, current = 0;
        float previous2 = 0, current2 = 0;
        int file = 1, i = 1;
        FileWriter fw = new FileWriter(fileName, true);
        FileWriter fw2 = new FileWriter(fileName2, true);
        Scanner sc = new Scanner(new File(fileName3)).useDelimiter(",");
        Scanner sc2 = new Scanner(new File(fileName4)).useDelimiter(",");
        String carpeta = "Iteraciones_Mezcla_Merge";
        new File(carpeta).mkdirs();
        if(sc.hasNext())
            current = sc.nextFloat();
        if(sc2.hasNext())
            current2 = sc2.nextFloat();
        File iter = new File("/"+carpeta+"/Iteracion_Mezcla_"+ j);
        while(sc.hasNext() || sc2.hasNext()){
            previous = current;
            previous2 = current2;
            System.out.println("Bloque: " + i);
            while((previous <= current) && (previous2 <= current2) && sc.hasNext() && sc2.hasNext()){
                if(current <= current2){
                    if(file == 1){
                        fw.write(current + ",");
                    }else{
                        fw2.write(current + ",");
                    }
                    writeFiles(iter, current);
                    System.out.print(current + ",");
                    previous = current;
                    current = sc.nextFloat();
                }else{
                    if(file==1){
                        fw.write(current2 + ",");
                    }else{
                        fw2.write(current2 + ",");
                    }
                    writeFiles(iter, current2);
                    System.out.print(current2 + ",");
                    previous2 = current2;
                    current2 = sc2.nextFloat();
                }
            }
            
            while((previous <= current) && sc.hasNext()){
                if(file == 1){
                    fw.write(current + ",");
                }else{
                    fw2.write(current + ",");
                }
                writeFiles(iter, current);
                System.out.print(current + ",");
                previous = current;
                current = sc.nextFloat();
            }
            
            while((previous2 <= current2) && sc2.hasNext()){
                if(file == 1){
                    fw.write(current2 + ",");
                }else{
                    fw2.write(current2 + ",");
                }
                writeFiles(iter, current2);
                System.out.print(current2 + ",");
                previous2 = current2;
                current2 = sc2.nextFloat();
            }
            if(file == 1){
                file = 2;
            }else{
                file = 1;
            }
            System.out.println();
            i++;
        }
        if(file == 1){
            if(current2 <= current){
                if(current2 != 0)
                    fw2.write(current2 + ",");
                if(current != 0)
                    fw2.write(current + ",");
            }else{
                if(current != 0)
                    fw2.write(current + ",");
                if(current2 != 0)
                    fw2.write(current2 + ",");
            }
        }else{
            if(current2 <= current){
                if(current2 != 0)
                    fw.write(current2 + ",");
                if(current != 0)
                    fw.write(current + ",");
            }else{
                if(current != 0)
                    fw.write(current + ",");
                if(current2 != 0)
                    fw.write(current2 + ",");
            }
        }
        writeFiles(iter, current);
        writeFiles(iter, current2);
        i++;
        sc.close();
        sc2.close();
        fw.close();
        BufferedWriter bw=new BufferedWriter(new FileWriter(fileName3));
        bw.write("");
        bw.close();
        fw2.close();
        BufferedWriter bw2=new BufferedWriter(new FileWriter(fileName4));
        bw2.write("");
        bw2.close();
    }
    
    public int tamanoDeEntrada(String f) throws FileNotFoundException{
        Scanner sc=new Scanner(new File(f)).useDelimiter(",");
        int counter=0;
        float d=0.0f;
        while(sc.hasNext()){
            d=sc.nextFloat();
            counter++;
        }
        return counter;
    }
    
    public void mainMezcla(){
        Scanner name = new Scanner(System.in);
        int i = 0, tam;
        String fileName;
        MezclaEquilibrada prueba = new MezclaEquilibrada();
        System.out.println("Escribe el nombre del archivo a ordenar:");
        try {
            fileName = name.next();
            tam = tamanoDeEntrada(fileName);
            System.out.println("Iteración: " + (i + 1));
            prueba.divide(fileName);
            System.out.println("Mezcla");
            while(tamanoDeEntrada("Auxiliar1.txt") != tam){
                System.out.println("Iteración: " + (i + 1));
                if(i % 2 == 0){
                    prueba.merge(fileName, "Auxiliar3.txt", "Auxiliar1.txt", "Auxiliar2.txt", i);
                }else{
                    prueba.merge("Auxiliar1.txt","Auxiliar2.txt", fileName, "Auxiliar3.txt", i);
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(MezclaEquilibrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        name.close();
    }
}

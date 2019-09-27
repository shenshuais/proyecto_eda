public int merge2(Scanner sc1, Scanner sc2, File f1, int mergeSize) throws IOException{
        int counter=0;
        int counterSc1=0;
        int counterSc2=0;
        FileWriter fw=new FileWriter(f1, true);
        float aux1=sc1.nextFloat();
        float aux2=sc2.nextFloat();
        while((counterSc1<mergeSize) && (counterSc2<mergeSize) && sc1.hasNext() && sc2.hasNext()){
            if(aux1<=aux2){
                fw.write(aux1+",");
                counter++;
                aux1=sc1.nextFloat();
                counterSc1++;
            }else{
                fw.write(aux2+",");
                counter++;
                aux2=sc2.nextFloat();
                counterSc2++;
            }   
        }
        while(counterSc1==mergeSize && counterSc2<mergeSize && sc2.hasNext()){
            fw.write(aux2+",");
            counter++;
            aux2=sc2.nextFloat();
            counterSc2++;
        }
        while(counterSc2==mergeSize && counterSc1<mergeSize && sc1.hasNext()){
            fw.write(aux1+",");
            counter++;
            aux1=sc1.nextFloat();
            counterSc1++;
        }
        System.out.println("Valor de contador"+counter);
        fw.close();
        sc1.close();
        sc2.close();
        return 1;
    }

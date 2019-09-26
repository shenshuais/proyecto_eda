/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotista;

/**
 *
 * @author Patch
 */
public class Quicksort {
    int partition(float arr[], int low, int high){
        float pivot = arr[high];
        int i = (low-1);
        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
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
    
    void sort(float arr[], int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

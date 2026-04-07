import java.util.Scanner;
public class quickSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = nextInt();
        System.out.println("Enter the elements of the array:");
        int arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        quickSort(arr,0,n-1);
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
    }
    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    static int partition(int[] arr,  int low,int high){
        int pivot = arr[low];
        int i = low+1;
        int j = high;
        while(i<=j){
            while(i<=j && arr[i]<=pivot) i++; // Move i to the right until an element greater than pivot is found
            while(arr[j]>pivot) j--; // Move j to the left until an element less than or equal to pivot is found 
            //inshort greater elements are on the left and smaller elements are on the right
            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    static void swap(int[] arr,int i, int j){
        int temp = aarr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
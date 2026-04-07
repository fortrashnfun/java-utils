import java.util.*;
public class mergeSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        mergeSort(arr,0,n-1);
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    static void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(i<=mid && j<= high){
            if(arr[i]<arr[j]) temp.add(arr[i++]);
            else temp.add(arr[j++]);
        }
        while(i<=mid) temp.add(arr[i++]);
        while(j<=high) temp.add(arr[j++]);

        for(int k=0;k<temp.size();k++) arr[low+k] = temp.get(k);
    }
}

import java.util.Random;
import java.util.Scanner;

class Assignment{
    static void quickSort(int [] arr,int low,int high){
        if(low<high){
            int pivot = partition(arr,low,high);

            quickSort(arr, low, pivot-1);

            quickSort(arr, pivot+1, high);

        }
    }

    static int partition(int [] arr,int low,int high){
        int pivot = arr[high];

        int i = low - 1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static int binarySearch(int num,int[] arr){
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int middleIndex;

        while(startIndex<=endIndex){

            middleIndex = startIndex + (endIndex - startIndex)/2;

            if(num==arr[middleIndex]) return middleIndex;

            else if(num<arr[middleIndex]) endIndex = middleIndex - 1;

            else if(num>arr[middleIndex]) startIndex = middleIndex + 1;
            
        }
        return -1;
    }

    static void printN(int n,int [] arr){
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++){
            if(arr[i] > n) {
                System.out.print(arr[i] + " ");
                break;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand =new Random();

        int [] rand_int1= new int[5000];
        for(int i=0;i<5000;i++){
            rand_int1[i] = rand.nextInt(5000);
        }
        quickSort(rand_int1, 0, 4999);

        System.out.println("Enter number you would like to search");
        int n = sc.nextInt();

        printN(n,rand_int1);

        int index = binarySearch(n, rand_int1);

        if(index != -1) System.out.println("The element is found at index = " + index);
        else System.out.println("Element Not Found");
        
        sc.close();
    }
}
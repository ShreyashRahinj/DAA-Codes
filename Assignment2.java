
public class Assignment2 {
    static int lomutopartition(int[] nums,int low,int high){
        int pivot = nums[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }

    static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int pivot = lomutopartition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }

    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int hoarepartition(int[] nums,int low,int high){
        int pivot = nums[low];
        int i = low-1;
        int j = high+1;

        while(true){
            do{
                i++;
            } while(nums[i]<pivot);

            do{
                j--;
            } while(nums[j]>pivot);

            if(i>=j){
                return j;
            }
            swap(nums, i, j);
        }
    }

    static void hoarequickSort(int[] nums,int low,int high){
        if(low<high){
            int pivot = hoarepartition(nums, low, high);
            quickSort(nums, low, pivot);
            quickSort(nums, pivot+1, high);
        }
    }

    static void mergeSort(int[] nums,int l,int r){
        if(l<r){
            int m = l + (r-l)/2;

            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);

            merge(nums,l,m,r);
        }
    }

    static void merge(int[] nums,int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L1 = new int[n1];
        int[] L2 = new int[n2];

        for(int i=0;i<n1;i++){
            L1[i] = nums[l+i];
        }
        for(int j=0;j<n2;j++){
            L2[j] = nums[m+1+j];
        }

        int i=0,j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(L1[i]<L2[j]){
                nums[k] = L1[i];
                i++;
                k++;
            }
            else{
                nums[k] = L2[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            nums[k] = L1[i];
                i++;
                k++;
        }
        while(j<n2){
            nums[k] = L2[j];
                j++;
                k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        
        long before = System.nanoTime();

        mergeSort(nums, 0, nums.length-1);
        
        long after = System.nanoTime();
        
        System.out.println("Merge Sort "+ (after - before));

        int[] nums1 = {1,2,3,4,5,6,7,8,9,10};

        before = System.nanoTime();
        
        quickSort(nums1, 0, nums1.length-1);

        after = System.nanoTime();

        System.out.println("Quick Sort "+ (after - before));
        for(int i:nums1){
            System.out.print(i+" ");
        }
    }
}

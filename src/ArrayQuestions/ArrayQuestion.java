// Program for checking Minimum Average Subarray, Count increasing SubArrays

    import java.io.*;
    import java.util.*;

    class ArrayQuestion {
      public static void main(String[] args) 
      {

        String orig = "sracecars";
        System.out.println(isPalindrome(orig));
        
        int[] arr =   {1, 4,3};
        countIncreasingSubArr(arr);
        
        int[] arr2 = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;
        MinAvgSubArray(arr2, k);

        // Given an array A[] and a number x, check for pair in A[] with sum as x
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A,  n);
      }

      public static boolean isPalindrome(String orig){
          return orig.equals(new StringBuilder(orig).reverse().toString());
      }
      
      public static void countIncreasingSubArr(int[] arr){
        int cnt = 0;
        int len = 1; 
      
        for (int p = 0 ; p < arr.length-1 ; p++){
          
          if (arr[p+1] > arr[p]){ 
            len++;
          }
          
          else{
            cnt += ((len*(len-1))/2);
            len = 1;
          }
             
        }
        
        if(len > 1 )
          cnt += ((len*(len-1))/2);
        
        System.out.println(cnt);
        
      } 
      
      public static void countIncreasingSubArr2(int[] arr){
        int count = 0;  
        for(int i = 0 ; i < arr.length ; i++){      
             for(int j = i+1 ; j < arr.length ; j++){
               if (arr[j] > arr[j-1])
                 count++;
             }
            }
      System.out.println("total increasing subArraays:" + count);
      }
      
     public static void MinAvgSubArray(int[] arra, int len) {
       int minSum = 0;
       int li = 0;
       int currentSum = 0;
       
       for (int i = 0; i < len ; i++){
         currentSum += arra[i];
       }
       
       minSum = currentSum;

       for (int j = len; j < arra.length ; j++ ){
          currentSum += arra[j] - arra[j - len]     ;
         
         if(currentSum < minSum){
           minSum = currentSum; 
           li = (j-len+1);
         }
       }
     System.out.println(" min average for subArray with subArrayLength:" + len + " is betwwen: "+ li + " " + (li+len-1));   
     }

// Given an array A[] and a number x, check for pair in A[] with sum as x
  static void printpairs(int arr[],int sum)
  {
    
    // Declares and initializes the whole array as false
    boolean[] binmap = new boolean[MAX];
   
    for (int i=0; i<arr.length; ++i)
    {
        int temp = sum-arr[i];
   
        // checking for condition
        if (temp>=0 && binmap[temp])
        {
        System.out.println("Pair with given sum " +sum + " is (" + arr[i] +", "+temp+")");
        }
              binmap[arr[i]] = true;
    }
  }

}

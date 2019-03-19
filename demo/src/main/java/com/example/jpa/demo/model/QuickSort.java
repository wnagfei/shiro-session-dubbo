package com.example.jpa.demo.model;



public class QuickSort {
  public static void main(String[] args) {
    //快速排序
      QuickSort quickSort = new QuickSort();
      Integer[] test = new Integer[]{6,1,2,7,9,3,4,5,10,8};
      quickSort.sort(test);

  }
  //快速排序
  //对两面同时排序
  public void sort(Integer[] array){
      splitArray(array,1,array.length-1);
  }
  //分一为二
    public Integer[] splitArray(Integer[] array, int start, int end){
      Integer pivot;
    if (start<end)
    {
        while (end == array.length - 1){

         }
    }
    }
}

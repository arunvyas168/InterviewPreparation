package com.company;

public class Main {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        String str1 = "ABCD";
        String str2 = "CDAB";
        boolean isRotation = areRotations(str1,str2);
        System.out.println("isRotation value for "+str1+" and "+str2+ " is: "+ isRotation);
        String input = "ABC";
        //printCombinationSpace(input);
        int[]array = {1,2,3,4,5,6,7};
        Node root =construct_BST(array);
        printInOrder(root);
        System.out.println();
        int[] array2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(array2);
        for (int i :array2){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] arr3 = {0, 1, 0, 1, 1, 1};
        sort01(arr3);
        for (int i :arr3){
            System.out.print(i+" ");
        }
        System.out.println();

    }

    /**
     * Problem:1    A Program to check if strings are rotations of each other or not
     * http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other-or-not/
     */

    public static boolean areRotations(String str1, String str2){
        String temp = str1+str1;
        if (str1.length()!= str2.length()){
            return false;
        } else if(temp.contains(str2)){  //contains returns boolean or indexOf return index of substring
            return true;
        }else {
            return false;
        }
    }




    /**
     * Problem:2    Print all possible strings that can be made by placing spaces
     * Input:  str[] = "ABC"
     *  Output: ABC
     *          AB C
     *          A BC
     *          A B C
     */

    /*
        WRONG not working
     */
    public static void  printCombinationSpace(String input){
        printCombinationSpace_util(input," ", 0);
    }
    private static void printCombinationSpace_util(String str, String prefix, int pos){
        if (pos>str.length()){
            return;
        }
        int i=0;
        String temp = "";
        for (;i<pos;i++){
            temp = temp+str.charAt(i);
        }
        temp = temp+" ";
        for (;i<str.length();i++){
            temp = temp+str.charAt(i);
        }
        System.out.println(temp);
        printCombinationSpace_util(str,prefix,pos+1);
    }


    /**
     *
     *  Problem:3   Sorted Array to Balanced BST
     */
    public static Node construct_BST(int[]array){
        return construct_BST_util(array,0,array.length-1);
    }
    public static Node construct_BST_util(int[] array,int start, int end){
        if (end<start){
            return null;
        }
        int mid = start+ (end-start)/2;
        Node root = new Node(array[mid]);
        root.left = construct_BST_util(array,start,mid-1);
        root.right = construct_BST_util(array,mid+1,end);
        return root;
    }
    public static void printInOrder(Node root){
        if (root==null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }


    /**
     *  Problem:4   Sort an array of 0s, 1s and 2s
     */
    public static void sort012(int[] array) {
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while (mid <= end){
            if (array[mid] == 0){
                int temp = array[start];
                array[start] = array[mid];
                array[mid] = temp;
                mid++;
                start++;
            }
            else if(array[mid]==1){
                mid++;
            }
            else if(array[mid]==2){
                int temp = array[end];
                array[end] = array[mid];
                array[mid] = temp;
                end--;
            }
        }
    }
    /**
     *  Problem:4.2:  Segregate 0s and 1s in an array
     */
    public static void sort01(int[] array){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            while((array[start]==0)&&(start<end)){
                start++;
            }
            while ((array[end]==1)&&(start<end)){
                end--;
            }
            if (start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
    }

}

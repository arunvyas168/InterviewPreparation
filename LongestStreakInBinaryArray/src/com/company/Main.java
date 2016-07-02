package com.company;

public class Main {

    public static void main(String[] args) {
        //Problem-1:
        int[] input1 = {1,1,0,0,1,1,1,0,1,1};
        int k = 1;
        System.out.println(LongestStreakKFlip(input1,k));

        //Problem-2:
        int[] input2 = {1,1,0,0,1,0,1,1,1,0,0,0,0};
        System.out.println(IndexToFlipLongestStreak(input2));
        int[] input3 = {1,1,0,0,1,0,1,1,1,0,1,1,1};
        System.out.println(IndexToFlipLongestStreak(input3));

    }


/*  Problem-1:

    Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s.
        E.x  array is {1,1,0,0,1,1,1,0,1,1}
        k = 1 (which means we can flip ‘k’ one 0 to 1)
        Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)
*/
    //SLIDING WINDOW Concept
    public static int LongestStreakKFlip(int[] array, int k){
        int leftWin = 0;
        int rightWin = 0;
        int bestWinWidth = -1;
        int numZero = 0;
        while (rightWin<array.length){
            if(numZero<=k){
                if (array[rightWin]==0){
                    numZero++;
                }
                rightWin++;
            }
            if(numZero>k){
                if (array[leftWin]==0){
                    numZero--;
                }
                leftWin++;
            }
            if((rightWin-leftWin)>bestWinWidth){
                bestWinWidth = (rightWin-leftWin);
            }
        }
        return bestWinWidth;
    }


/*  Problem-2:

    Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
    Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. Expected time complexity is O(n) and auxiliary space is O(1).
        Input:
           arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
        Output:
          Index 9 ( Assuming array index starts from 0, replacing 0 with 1 at index 9)

        Input:
           arr[] =  {1, 1, 1, 1, 0}
        Output:
          Index 4
*/

    public static int IndexToFlipLongestStreak(int[] array){
        int left = 0;
        int bestLeft=0;
        int current = 0;
        int numZero = 0;
        int totalCount = -1;

        while (current<array.length){
            if(numZero<=1){
                if(array[current]==0){
                    numZero++;
                }
                current++;
            }

            if(numZero>1){
                if (array[left] == 0){
                    numZero--;
                }
                left++;
            }

            if(totalCount<current-left){
                totalCount = current-left;
                bestLeft = left;
            }
        }

        for (int i=bestLeft;i<bestLeft+totalCount;i++){
            if (array[i] == 0){
                return i;
            }
        }

        return 0;
    }

}

package test;

import java.util.stream.IntStream;

public class TestForIncDec {
    public static void main(String[] args) {
        int[] array = {12, 5, 7, 14, 5, 21, 1};

        int[] evenElement = getEvenElement(array);

        //printing the even elements
        for (int i : evenElement) {
            System.out.println(i + " ");
        }

        //now checking the condition whether it is increasing, decreasing or none.
        String checkResult = checkArray(evenElement);
        System.out.println("The result is :  " + checkResult);

    }


    public static String checkArray(int[] array) {
        // this condition needs or not we have to verify.
        // this conditions needs to be exits to check whether the array have at least 2 elements for comparison.
        if (array.length < 2) {
            return "none";
        }

        boolean increasedFlag = true;
        boolean decreasedFlag = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                increasedFlag = false;
            } else if (array[i] > array[i - 1]) {
                decreasedFlag = false;
            }
        }

        if (increasedFlag) {
            return "increasing";
        } else if (decreasedFlag) {
            return "decreasing";
        } else {
            return "none";
        }
    }
    //method to get even elements from the array.
    public static int[] getEvenElement(int[] array) {
        return IntStream.range(0, (array.length + 1) / 2).map(i -> array[i * 2]).toArray();
    }
}

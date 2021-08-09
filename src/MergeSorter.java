
import static java.lang.Double.compare;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dikshyanta Mulmi, Saurav Kandel, Sudhoj Kunwar, Solomon Biswokarma
 */
public class MergeSorter {

    public static Double[] mergeSort(Double[] rate) {
        //the code below splits the array into smallest uniit and merges them in ascending order
        if (rate.length <= 1) {
            return rate;
        }
        int midpoint = rate.length / 2;
        Double[] left = new Double[midpoint];
        Double[] right = new Double[rate.length - left.length];
        for (int i = 0; i < midpoint; i++) {
            left[i] = rate[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = rate[midpoint + j];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        Double[] result = merge(left, right);
        return result;
    }

    public static Double[] merge(Double[] left, Double[] right) {
        //the code below merges elements in an array in ascending order
        Double[] result = new Double[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    public static String[] mergeSort(String[] list) {
        //the code below splits the array into smallest uniit and merges them in ascending order
        if (list.length <= 1) {
            return list;
        }
        int mid = list.length / 2;
        String[] left = new String[mid];
        String[] right = new String[list.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = list[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = list[mid + j];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        String[] result = merge(left, right);
        return result;

    }

    public static String[] merge(String[] left, String[] right) {
        //the code below merges elements in an array in ascending order
        String[] result = new String[left.length + right.length];
        int resultPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer].compareTo(right[rightPointer]) < 0) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }


    public static Object[][] mergeSort(Object[][] list, int index) {
        //the code below splits the array into smallest uniit and merges them in ascending order
        if (list.length <= 1) {
            return list;
        }
        int mid = list.length / 2;
        Object[][] left = new Object[mid][list[0].length];
        Object[][] right = new Object[list.length - mid][list[0].length];
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[0].length; j++) {
                left[i][j] = list[i][j];
            }

        }
        for (int j = 0; j < right.length; j++) {
            for (int k = 0; k < right[0].length; k++) {
                right[j][k] = list[mid + j][k];
            }

        }
        left = mergeSort(left, index);
        right = mergeSort(right, index);
        Object[][] result = merge(left, right, index);
        return result;

    }

    public static Object[][] merge(Object[][] left, Object[][] right, int index) {
        //the code below merges elements in an array in ascending order
        Object[][] result = new Object[left.length + right.length][left[0].length];
        int resultPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        boolean condition;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                String leftValue = left[leftPointer][index].toString();
                String rightValue = right[rightPointer][index].toString();
                if (index == 5) {
                    condition = compare(Double.valueOf(leftValue), Double.valueOf(rightValue)) < 0;
                } else {
                    condition = leftValue.compareTo(rightValue) < 0;
                }
                if (condition) {
                    for (int i = 0; i < left[0].length; i++) {
                        result[resultPointer][i] = left[leftPointer][i];
                    }
                    resultPointer++;
                    leftPointer++;
                } else {
                    for (int i = 0; i < right[0].length; i++) {
                        result[resultPointer][i] = right[rightPointer][i];
                    }
                    resultPointer++;
                    rightPointer++;
                }
            } else if (leftPointer < left.length) {
                for (int i = 0; i < left[0].length; i++) {
                    result[resultPointer][i] = left[leftPointer][i];
                }
                resultPointer++;
                leftPointer++;
            } else {
                for (int i = 0; i < right[0].length; i++) {
                    result[resultPointer][i] = right[rightPointer][i];
                }
                resultPointer++;
                rightPointer++;
            }
        }
        return result;
    }
}

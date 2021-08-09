
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
public class BinarySearch {

    public static int binarySearch(Object[][] list, int column, String search) {
        /*the code below takes a sorted double array and 
        return the index of serached value if found else returns -1*/
        int left = 0;
        int right = list.length - 1;
        int index = -1;
        int condition;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (column == 5) {
                condition = compare(Double.valueOf(search), Double.valueOf(list[mid][column].toString()));
            } else {
                condition = search.compareTo(list[mid][column].toString());
            }
            if (condition < 0) {
                right = mid - 1;
            } else if (condition > 0) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
}

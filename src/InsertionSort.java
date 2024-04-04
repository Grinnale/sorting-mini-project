import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Alexander Maret
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for(int i = 1; i < values.length; i++) {
      int point = i - 1;
      T temp = values[i];
      while (point >= 0 && order.compare(values[point], temp) > 0) {
        point--;
      }
      int point2 = i - 1;
      while (point < point2) {
        values[point2 + 1] = values[point2];
        point2--;
      }
      values[point + 1] = temp;
    }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Alexander Maret
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    T[] extra = Arrays.copyOf(values, values.length);
    values = mergesort(values, extra, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  public <T> T[] mergesort(T[] values, T[] extra, Comparator<? super T> order, int lb, int ub){
    if(ub - lb > 1){
      values = mergesort(values, extra, order, lb, ub - (ub-lb)/2);
      extra = Arrays.copyOf(values, values.length);
      values = mergesort(values, extra, order, ub - (ub-lb)/2, ub);
      extra = Arrays.copyOf(values, values.length);

      int l = lb;
      int r = ub - (ub-lb)/2;
      int i = lb;
      while(l < ub - (ub-lb)/2 && r < ub){
        if(order.compare(extra[l], extra[r]) <= 0){
          values[i] = extra[l];
          l++;
          i++;
        }
        else{
          values[i] = extra[r];
          r++;
          i++;
        }
      }
      while(l < ub - (ub-lb)/2){
        values[i] = extra[l];
        l++;
        i++;
      }
      while(r < ub){
        values[i] = extra[r];
        r++;
        i++;
      }
    }
    return values;
  }

} // class MergeSort

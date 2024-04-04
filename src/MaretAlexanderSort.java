import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort if subarray has length at least 3. Otherwise, sort using insertion sort.
 * I wasn't trying to make the fastest sort, but I was curious if this was an improvement on mergeSort. I don't think it is.
 * @author Alexander Maret
 */
public class MaretAlexanderSort implements Sorter {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MaretAlexanderSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MaretAlexanderSort() {
  } // MaretAlexanderSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    T[] extra = Arrays.copyOf(values, values.length);
    values = amsort(values, extra, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  public <T> T[] amsort(T[] values, T[] extra, Comparator<? super T> order, int lb, int ub){
    if(ub - lb > 2){
      values = amsort(values, extra, order, lb, ub - (ub-lb)/2);
      extra = Arrays.copyOf(values, values.length);
      values = amsort(values, extra, order, ub - (ub-lb)/2, ub);
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
    else if(ub - lb == 2){
      if(order.compare(extra[lb], extra[lb + 1]) > 0){
        values[lb] = extra[lb + 1];
        values[lb + 1] = extra[lb];
      }
    }
    return values;
  }
}

import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Alexander Maret
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values.length > 1) {
      partition(values, order);
    }
  } //  sort(T[], Comparator<? super T>)

  /**
   * Partition an array.
   */
  public <T> void partition(T[] values, Comparator<? super T> order) {
    partition(values, order, 0, values.length);
  } // partition(T[], Comparator<? super T>)

  // +----------------------+----------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using
   * the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order,
      int lb, int ub) {
    // STUB
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int sm = lb;
    int lg = ub;
    T pivot = arr[lb];
    sm++;
    while(sm < lg){
      if(order.compare(arr[sm], pivot) <= 0){
        sm++;
      }
      else{
        lg--;
        T temp = arr[sm];
        arr[sm] = arr[lg];
        arr[lg] = temp;
      }
    }
    for(int i = lb; i < sm - 1; i++){
      arr[i] = arr[i+1];
    }
    arr[sm - 1] = pivot;

    int pivotLoc = sm - 1;
    while(pivotLoc - lb > 1) {
      pivotLoc = partition(arr, order, lb, pivotLoc);
    }

    pivotLoc = sm - 1;
    while(ub - (pivotLoc + 1) > 1) {
      pivotLoc = partition(arr, order, pivotLoc + 1, ub);
    }

    return sm - 1;
  } // partition(T[], Comparator<? super T>, lb, ub)
} // class Quicksort

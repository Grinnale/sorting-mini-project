import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Alexander Maret
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void emptyTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // emptyTest

  @Test
  public void mistakeAtBeginningTest() {
    String[] original = { "calpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = { "bravo", "calpha", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // mistakeAtBeginningTest

  @Test
  public void mistakeAtEndTest() {
    String[] original = { "alpha", "bravo", "charlie", "gdelta", "foxtrot" };
    String[] expected = { "alpha", "bravo", "charlie", "foxtrot", "gdelta"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // mistakeAtEndTest

  @Test
  public void beginningAndEndSwapTest() {
    String[] original = { "delta", "bravo", "charlie", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // beginningAndEndSwapTest

  @Test
  public void oneValueTest() {
    String[] original = { "alpha" };
    String[] expected = { "alpha" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // oneValueTest

} // class SortTester

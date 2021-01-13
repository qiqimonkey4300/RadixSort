public class Radix {
  public static int nth(int n, int col) {
    int x = (int)(n / Math.pow(10, col)) % 10;
    return Math.abs(x);
  }

  public static int length(int n) {
    String x = String.valueOf(n);
    if (x.charAt(0) == '-') return x.length() - 1;
    return x.length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }
}

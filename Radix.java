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

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    int lsd = 0;
    for (int i = 0; i < data.size(); i++) {
      if (length(data.get(i)) > lsd) lsd = length(data.get(i));
    }
    for (int i = 0; i < lsd; i++) {
      while (data.size() != 0) {
        int digit = nth(data.get(0), i);
        buckets[digit].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] positiveBuckets = new SortableLinkedList[10];
    SortableLinkedList[] negativeBuckets = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      positiveBuckets[i] = new SortableLinkedList();
      negativeBuckets[i] = new SortableLinkedList();
    }
    int lsd = 0;
    for (int i = 0; i < data.size(); i++) {
      if (length(data.get(i)) > lsd) lsd = length(data.get(i));
    }
    for (int i = 0; i < lsd; i++) {
      while (data.size() != 0) {
        int digit = nth(data.get(0), i);
        if (data.get(0) < 0) negativeBuckets[9 - Math.abs(digit)].add(data.get(0));
        else positiveBuckets[digit].add(data.get(0));
        data.remove(0);
      }
      merge(data, negativeBuckets);
      merge(data, positiveBuckets);
    }
  }

}

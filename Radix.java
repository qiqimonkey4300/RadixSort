public class Radix {
  public static int nth(int n, int col) {
    return (int)(n / Math.pow(10, col)) % 10;
  }

  public static int length(int n) {
    if (n == 0) return 1;
    else return (int)(Math.log10(Math.abs(n))+1);
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
    int lsd = 1;
    for (int i = 0; i < lsd; i++) {
      while (data.size() != 0) {
        int x = data.remove(0);
        int digit = nth(x, i);
        buckets[digit].add(x);
        if (i == 0 && length(x) > lsd) lsd = length(x);
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
    int lsd = 1;
    for (int i = 0; i < lsd; i++) {
      while (data.size() != 0) {
        int x = data.remove(0);
        int digit = nth(x, i);
        if (x < 0) negativeBuckets[9 - Math.abs(digit)].add(x);
        else positiveBuckets[digit].add(x);
        if (i == 0 && length(x) > lsd) lsd = length(x);
      }
      merge(data, negativeBuckets);
      merge(data, positiveBuckets);
    }
  }

}

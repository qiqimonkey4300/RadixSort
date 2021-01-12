public class Radix {
  public static void main(String[] args) {
    System.out.println(nth(123, 1));
    System.out.println(nth(-123, 1));
    System.out.println(nth(123, 2));
    System.out.println(nth(-123, 2));
    System.out.println(length(0));
    System.out.println(length(15));
    System.out.println(length(-10));
    System.out.println(length(5112));
  }

  public static int nth(int n, int col) {
    int x = (int)(n / Math.pow(10, col)) % 10;
    return Math.abs(x);
  }

  public static int length(int n) {
    String x = String.valueOf(n);
    if (x.charAt(0) == '-') return x.length() - 1;
    return x.length();
  }

  //public static void merge(MyLinkedList original,MyLinkedList[]buckets) { }
}

public class Radix {
  public static void main(String[] args) {
    System.out.println(nth(123, 1));
    System.out.println(nth(-123, 1));
    System.out.println(nth(123, 2));
    System.out.println(nth(-123, 2));
  }

  public static int nth(int n, int col) {
    int x = (int)(n / Math.pow(10, col)) % 10;
    return Math.abs(x);
  }

  //public static int length(int n) { }

  //public static void merge(MyLinkedList original,MyLinkedList[]buckets) { }
}

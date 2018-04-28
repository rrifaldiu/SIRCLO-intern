package jampasir;

import java.util.Scanner;

public class JamPasir {
  
  /** create the upper part of an hour glass.
   * @param n height of the hour glass
   * @param isEmpty true if the upper part is empty
   */
  public static void createUpperHourGlass(int n, boolean isEmpty) {
    // create top of hour glass
    for (int i = 0; i < 2 * n + 1; ++i) {
      System.out.print('*');
    }
    System.out.println();
    
    // create fill of upper hour glass
    for  (int i = 0; i < n - 1; ++i) {
      // print space
      for (int j = 0; j <= i; ++j) {
        System.out.print(' ');
      }
      // print hour glass border
      System.out.print('*');
      // print hour glass fill
      for (int j = 2 * (n - i) - 3; j > 0; -- j) {
        if (isEmpty) {
          System.out.print(' ');
        } else {
          System.out.print('*');
        }
      }
      // print hour glass border
      System.out.println('*');
    }
  }
  
  /** create the middle part of an hour glass.
   * @param n height of the hour glass
   */
  public static void createMiddleHourGlass(int n) {
    for (int i = 0; i < n; ++i) {
      System.out.print(' ');
    }
    System.out.println('*');
  }
  
  /** create the lower part of an hour glass.
   * @param n height of the hour glass
   * @param isEmpty true if the lower part is empty
   */
  public static void createLowerHourGlass(int n, boolean isEmpty) {
    // create fill of lower hour glass
    for  (int i = 0; i < n - 1; ++i) {
      // print space
      for (int j = 0; j < n - i - 1; ++j) {
        System.out.print(' ');
      }
      // print hour glass border
      System.out.print('*');
      // print hour glass fill
      for (int j = 0; j < 2 * i + 1; ++ j) {
        if (isEmpty) {
          System.out.print(' ');
        } else {
          System.out.print('*');
        }
      }
      // print hour glass border
      System.out.println('*');
    }
    
    // create bottom of hour glass
    for (int i = 0; i < 2 * n + 1; ++i) {
      System.out.print('*');
    }
    System.out.println();
  }
  
  /** Create an hour glass.
   * @param n height of an hour glass
   * @param isEmpty true if the bottom part of the hour glass is empty
   */
  public static void createHourGlass(int n, boolean isEmpty) {
    if (isEmpty) {
      createUpperHourGlass(n, false);
      createMiddleHourGlass(n);
      createLowerHourGlass(n, true);
    } else {
      createUpperHourGlass(n, true);
      createMiddleHourGlass(n);
      createLowerHourGlass(n, false);
    }
  }

  /** main program.
   * @param args input string
   */
  public static void main(String[] args) {
    // read input
    // assumption : input is always correct
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    String inputStr = s.nextLine();
    inputStr = s.nextLine();
    s.close();
    
    // print hour glass
    boolean isEmpty = inputStr.equalsIgnoreCase("KOSONG");
    createHourGlass(n, isEmpty);
  }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tester class for PathUtils
 */
public class PathUtilsTester {

  /**
   * Plain constructor
   */
  public PathUtilsTester() {
  }

  /**
   * Main class used for running tester methods
   */
  public static void main(String[] args) {
    System.out.println("testCountPathsNoPath(): " + testCountPathsNoPath());
    System.out.println("testCountPathsOnePath(): " + testCountPathsOnePath());
    System.out.println("testCountPathsRecursive(): " + testCountPathsRecursive());
    System.out.println("testFindAllPathsNoPath(): " + testFindAllPathsNoPath());
    System.out.println("testFindAllPathsOnePath(): " + testFindAllPathsOnePath());
    System.out.println("testFindAllPathsRecursive(): " + testFindAllPathsRecursive());
  }

  /**
   * Tests the case of countPaths() when there are no valid Paths. 
   * For example, when the start position is Intersection(1, 1) and 
   * the ending position is Intersection(0, 1), there should be no valid Paths, 
   * so countPaths() should return 0.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsNoPath() {
    try {
      Intersection i1 = new Intersection(2, 1);
      Intersection i2 = new Intersection(0, 0);
      if (PathUtils.countPaths(i1, i2) != 0) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }

  }
  
  /**
   * Tests the case of countPaths() when there are no valid Paths. 
   * For example, when the start position is Intersection(1, 1) and 
   * the ending position is Intersection(1, 2), there should be a single Path, 
   * so countPaths() should return 1.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsOnePath() {
    try {
      Intersection i1 = new Intersection(1, 1);
      Intersection i2 = new Intersection(1, 2);
      ArrayList<Path> paths = new ArrayList<>();

      if (PathUtils.countPaths(i1, i2) != 1) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the case of countPaths() when there are multiple possible paths. 
   * For example, when the start position is Intersection(0, 0) and 
   * the ending position is Intersection(1, 2), there should be three possible Paths, 
   * so countPaths() should return 3.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsRecursive() {
    try {
      Intersection i1 = new Intersection(0, 1);
      Intersection i2 = new Intersection(3, 2);
      ArrayList<Path> paths = new ArrayList<>();

      if (PathUtils.countPaths(i1, i2) != 4) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the case of findAllPaths() when there are no valid Paths. 
   * For example, when the start position is Intersection(1, 1) and
   * the ending position is Intersection(0, 1), there should be no valid Paths, 
   * so findAllPaths() should return an empty ArrayList.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsNoPath() {
    try {
      Intersection i1 = new Intersection(1, 1);
      Intersection i2 = new Intersection(0, 1);
      ArrayList<Path> paths = new ArrayList<>();

      if (!(PathUtils.findAllPaths(i1, i2).equals(paths))) {
        return false;
      }

      return true;
    } catch (Exception e) {
      return false;
    }
  } 

  /**
   * Tests the case of findAllPaths() when there is a single valid Path. 
   * For example, when the start position is Intersection(1, 1) and the ending position 
   * is Intersection(1, 2), there should be a single Path. 
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsOnePath() {
    try {
      Intersection i1 = new Intersection(1, 1);
      Intersection i2 = new Intersection(1, 2);
      if (!(PathUtils.findAllPaths(i1, i2).toString().equals("[(1,1)->(1,2)]"))) {
        return false;
      }

      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  /**
   * Tests the case of findAllPaths() when there are multiple possible paths. 
   * For example, when the start position is Intersection(0, 0) 
   * and the ending position is Intersection(1, 2), there should be three possible Paths.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsRecursive() {
    try {
      Intersection i1 = new Intersection(0, 1);
      Intersection i2 = new Intersection(3, 2);

      if (!(PathUtils.findAllPaths(i1, i2).toString()
          .equals("[(0,1)->(1,1)->(2,1)->(3,1)->(3,2), " + "(0,1)->(1,1)->(2,1)->(2,2)->(3,2), "
              + "(0,1)->(1,1)->(1,2)->(2,2)->(3,2), " + "(0,1)->(0,2)->(1,2)->(2,2)->(3,2)]"))) {
        return false;
      }
      return true;

    } catch (Exception e) {
      return false;
    }
  }
  

}

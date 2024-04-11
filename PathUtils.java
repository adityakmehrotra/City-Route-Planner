import java.util.ArrayList;

/**
 * Utility methods for planning a trip through a grid of city intersections
 */

public class PathUtils {
  
  /**
   * Plain constructor
   */
  public PathUtils() {
  }

  /**
   * Finds the number of valid Paths between the given start and end Intersections. 
   * If it is not possible to get from the start to the end intersection by moving up 
   * or right, then 0 should be returned. For example, if start is Intersection(0, 0) 
   * and end is Intersection(2, 1), this method should return 3. If start is 
   * Intersection(1, 0) and end is Intersection(0, 0), this method should return 0. 
   * MUST be implemented recursively. If you wish, you can use a call to a private 
   * static helper method which is recursive.
   * 
   * @param start - Intersection to start at
   * @param end - Intersection to end at
   * @return the number of valid Paths which start and end at the given Intersections
   */
  public static int countPaths(Intersection start, Intersection end) {
    //BASE CASES
    //Checks if path is valid, as it can only move north and east
    if (end.getX() < start.getX() || end.getY() < start.getY()) {
      return 0;
    }
    
    //Checks if start is same as end
    if (start.equals(end)) {
      return 1;
    }

    //RECURSIVE CASE
    //Calls countPaths recursively with x + 1, y + 1
    return countPaths(start.goNorth(), end) + countPaths(start.goEast(), end);
  }

  /**
   * Finds all valid Paths between the given start and end Intersections. 
   * If it is not possible to get from the start to the end intersection by 
   * moving up or right, then an empty ArrayList should be returned.
   * For example, if start is Intersection(0, 0) and end is Intersection(2, 1), 
   * this method should return an ArrayList consisting of the following Paths:
   * (0,0)->(1,0)->(2,0)->(2,1)
   * (0,0)->(1,0)->(1,1)->(2,1)
   * (0,0)->(0,1)->(1,1)->(2,1)
   * If start is Intersection(1, 0) and end is Intersection(0, 0), this method should 
   * return an empty ArrayList. MUST be implemented recursively. If you wish, 
   * you can use a call to a private static helper method which is recursive.
   * 
   * @param start - Intersection to start at
   * @param end - Intersection to end at
   * @return an ArrayList containing all valid Paths which start and end at the given Intersections
   */
  public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
    //BASE CASES
    ArrayList<Path> paths = new ArrayList<Path>();
    
    //Checks if path is valid, as it can only move north and east
    Path path = new Path();
    if(end.getX() < start.getX() || end.getY() < start.getY()) {
      return paths;
    }
    
    //Checks if start is same as end
    if(start.equals(end)) {
      path.addTail(end);
      paths.add(path);
      return paths;
    }
    
    //RECURSIVE CASES
    //Checks x values and calls method recursively, with the x value changed + 1
    if(start.getX() < end.getX()) {
      ArrayList<Path> temp = findAllPaths(start.goEast(), end);
      for(int i = 0; i < temp.size(); i++) {
        temp.get(i).addHead(start);
        paths.add(temp.get(i));
      }
    }
    
    //Checks y values and calls method recursively, with the y value changed + 1
    if(start.getY() < end.getY()) {
      ArrayList<Path> temp = findAllPaths(start.goNorth(), end);
      for(int i = 0; i < temp.size(); i++) {
        temp.get(i).addHead(start);
        paths.add(temp.get(i));
      }
    }
    return paths;
  }
  
}

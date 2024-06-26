import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class represents a valid path through a grid of city intersections surrounded by streets. 
 * That is, one which only moves either one step directly east, or one step directly north at 
 * each step, meaning that only northeast paths from one intersection point to another are allowed. 
 * A list of intersection elements creates the path.
 */
public class Path {

  private ArrayList<Intersection> intersections; // List of Intersections followed in this Path

  /**
   * Initializes this Path to start as empty
   */
  public Path() {
    intersections = new ArrayList<>();
  }

  /**
   * Returns the number of Intersections in this Path
   * 
   * @return the number of Intersections in this Path
   */
  public int length() {
    return intersections.size();
  }

  /**
   * Returns the first Intersection in this Path, if it is not empty. 
   * Otherwise, throws a NoSuchElementException.
   * 
   * @return the first Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getHead() throws NoSuchElementException {
    if (intersections.isEmpty() == true) {
      throw new NoSuchElementException("Path is Empty");
    }
    return intersections.get(0);
  }

  /**
   * Returns the last Intersection in this Path, if it is not empty. 
   * Otherwise, throws a NoSuchElementException.
   * 
   * @return the last Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getTail() throws NoSuchElementException {
    if (intersections.isEmpty() == true) {
      throw new NoSuchElementException("Path is Empty");
    }
    return intersections.get(intersections.size() - 1);
  }

  /**
   * Adds the given Intersection to the end of this Path if it is a valid addition. 
   * A Intersection is a valid addition if the current Path is empty, or the Intersection 
   * to add is one step directly east, or one step directly north of the current tail 
   * Intersection in this Path. Should throw an IllegalArgumentException if the given 
   * Intersection is not a valid addition.
   * 
   * @param toAdd - Intersection to add to the end of this Path
   * @return IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addTail(Intersection toAdd) throws IllegalArgumentException {
    if (intersections.isEmpty()) {
      intersections.add(toAdd);
    } else if (getTail().getX() == (toAdd.getX() + 1) && getTail().getY() == toAdd.getY()) {
      intersections.add(toAdd);
    } else if (getTail().getX() == toAdd.getX() && getTail().getY() == (toAdd.getY() + 1)) {
      intersections.add(toAdd);
    } else {
      throw new IllegalArgumentException(" A Intersection is a valid addition if the current Path "
          + "is empty, or the Intersection to add is one step directly east, "
          + "or one step directly north of the current tail Intersection in this Path.");
    }
  }

  /**
   * Adds the given Intersection to the front of this Path if it is a valid addition. 
   * A Intersection is a valid addition if the current Path is empty, or the Intersection 
   * to add is one step directly west, or one step directly south of the current head 
   * Intersection in this Path. Should throw an * IllegalArgumentException if the given 
   * Intersection is not a valid addition.
   * 
   * @param toAdd - Intersection to add to the beginning of this Path
   * @throws IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addHead(Intersection toAdd) throws IllegalArgumentException {
    if (intersections.isEmpty()) {
      intersections.add(0, toAdd);
    } else if (getHead().getX() == (toAdd.getX() + 1) && getHead().getY() == toAdd.getY()) {
      intersections.add(0, toAdd);
    } else if (getHead().getX() == toAdd.getX() && getHead().getY() == (toAdd.getY() + 1)) {
      intersections.add(0, toAdd);
    } else {
      throw new IllegalArgumentException(" A Intersection is a valid addition if the current Path "
          + "is empty, or the Intersection to add is one step directly west, "
          + "or one step directly south of the current tail Intersection in this Path.");
    }

  }

  /**
   * Returns a String representing the coordinates taken in this Path. An empty Path 
   * should return the String "Empty", while a non-empty Path should return the 
   * coordinates of the Intersections it visits separated by a "->". 
   * For example:(0,0)->(1,0)->(1,1)->(1,2)
   * 
   * @return a String representing the coordinates followed by this Path
   */
  @Override
  public String toString() {
    String result = "";
    if (intersections.isEmpty()) {
      return "Empty";
    }

    for (Intersection i : intersections) {
      if (intersections.indexOf(i) == intersections.size() - 1) {
        result = result.concat(i.toString());
      } else {
        result = result.concat(i.toString() + "->");
      }
    }
    return result;
  }

}

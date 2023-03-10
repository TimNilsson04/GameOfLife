package Model;
import View.*;

import java.util.Arrays;

public class Model {
    int width;
    int height;
    int neigbhours;

    Point[] points = {new Point(7, 7), new Point(7, 8), new Point(7, 6), new Point(8, 7), new Point(8, 8), new Point(10, 8), new Point(11, 8), new Point(3,1), new Point(4,1), new Point(3,2), new Point(4,2)};

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
        int die = 0;

        for (int i = 0; i < points.length; i++) {
            if (getNeighbour(points, points[i]) < 2 || getNeighbour(points, points[i]) > 3) {
                die++;

            }
        }
        int[] dying = new int[die];
        int deaths = 0;
        int removed = 0;

        for (int i = 0; i < points.length; i++) {

          //  System.out.println(points[i] + " has " + getNeighbour(points, points[i]) + " neigbhours");

            if (getNeighbour(points, points[i]) < 2 || getNeighbour(points, points[i]) > 3) {
                dying[deaths] = i;
                deaths++;
            }
        }
      //  System.out.println(Arrays.toString(dying));


        for (int i = 0; i < dying.length; i++) {
            // kill it
            Arrays.toString(points);
            // Remove the element
            points = removeTheElement(points, dying[i]-removed);
            removed++;
        }
        System.out.println(neigbhours);

       // if (neigbhours == 3){
         //   points.add(new Point(x, y))
       // }
        // add new points: points.add(new Point(x, y));

    }


    public int getNeighbour(Point[] points, Point point){
        int neigbhour = -1;


            for (int i = 0; i < points.length; i++){

                if(point.getX() - points[i].getX() <= 1 && point.getX() - points[i].getX() >= -1 && point.getY() - points[i].getY() <= 1 && point.getY() - points[i].getY() >= -1 ) {
                    neigbhour++;
                }
            }
        return neigbhour;
        }

    public int revive(Point[] points, int width, int height){
        int neigbhours = 0;
        int x;
        int y;


        for (int i = 0; i < points.length; i++) {

            for (int p = 1; p < height; p++) {
                y = p;
                x = 1;

                for (int o = 2; o < width; o++) {
                    if (x - points[i].getX() <= 1 && x - points[i].getX() >= -1 && y - points[i].getY() <= 1 && y - points[i].getY() >= -1) {
                        neigbhours++;
                    }
                    x = o;

                }
            }

        }

        return neigbhours;
    }



   /* public int checkNeigbhours(Point[] points, int width, int height){
            int neigbhours = 0;
            int x;
            int y;

            for (int i = 0; i<points.length; i++) {

                for (int p = 1; p < height; p++) {
                    y = p;
                    x = 1;

                    for (int o = 2; o < width; o++) {
                        if (x - points[i].getX() <= 1 && x - points[i].getX() >= -1 && y - points[i].getY() <= 1 && y - points[i].getY() >= -1) {
                            neigbhours++;
                        }
                        x = o;
                    }
                }

            }

            return neigbhours;
        }
*/


    public Point[] getPoints() {
        return points;
    }

    public Shape[] getShapes() {
        points = getPoints();
        return (Shape[])points;
    }

    public Point[] removeTheElement(Point[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        Point[] anotherArray = new Point[arr.length - 1];

        // Copy the elements from starting till index
        // from original array to the other array
        System.arraycopy(arr, 0, anotherArray, 0, index);

        // Copy the elements from index + 1 till end
        // from original array to the other array
        System.arraycopy(arr, index + 1,
                anotherArray, index,
                arr.length - index - 1);

        // return the resultant array
        return anotherArray;
    }
}

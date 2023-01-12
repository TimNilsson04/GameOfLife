package Model;
import View.*;

public class Model {
        int width;
        int height;


    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update(Point[] points) {
            for (int i = 0; i < points.length; i++){
              int neigbhour =  getNeighbour(points);

            }


    }

    public int checkNeigbhours(Point[] points, int width, int height){
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


        public int getNeighbour(Point[] points){
        int neigbhour = -1;

        for (int x = 0; x < points.length; x++){
            for (int i = 0; i < points.length; i++){

                if(points[x].getX() - points[i].getX() <= 1 && points[x].getX() - points[i].getX() >= -1 && points[x].getY() - points[i].getY() <= 1 && points[x].getY() - points[i].getY() >= -1 ) {
                    neigbhour++;
                }
            }
            System.out.println("pixel " + (x+1) + " has " + neigbhour +" neigbhours");

            if (neigbhour < 2 || neigbhour > 3){
                // kill it
            }
            neigbhour = -1;
        }
        return neigbhour;
        }

    public Point[] getPoints() {
        Point[] points = {new Point(5,5), new Point(5,6), new Point(6,7)};
        return points;
    }

    public Shape[] getShapes() {
        Point[] points = {new Point(5,5), new Point(5,6), new Point(6,7)};
        return (Shape[])points;
    }

}

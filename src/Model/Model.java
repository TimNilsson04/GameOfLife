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
                checkNeigbhours(points, width, height);
            }
    }

    public int checkNeigbhours(Point[] points, int width, int height){
            int neigbhours = 0;
            int x;
            int y;

            for (int i = 0; i < height; i++) {
                y = i;
                x = 1;
                for (int o = 0; o < width; o++) {

                    if (x - points[i].getX() <= 1 && x - points[i].getX() >= 1 && y - points[i].getY() <= 1 && y - points[i].getY() >= 1) {
                        neigbhours++;
                    }
                }
            }
        return neigbhours;
    }

    public Point[] getPoints() {
        Point[] points = {new Point(5,5), new Point(5,6), new Point(4,7), new Point(6,7)};
        return points;
    }

    public Shape[] getShapes() {
        Point[] points = {new Point(5,5), new Point(5,6), new Point(4,7), new Point(6,7)};
        return (Shape[])points;
    }
}

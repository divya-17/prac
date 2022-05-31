package heaps;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

Given an array of coordinates, find k closest point from the origin.

PS: Given two coordinates (x1,y1) and (x2,y2), distance between them is calculated as:
sqrt(sq(x2-x1) + sq(y2-y1))

 */
public class kClosestPoint {

    private static List<Coordinate> coordinateList = new ArrayList<>();
    private static PriorityQueue maxHeap = new PriorityQueue(new CoordinateComparator());

    private static int k = 2;
    private static List<Coordinate> closestCoordinates = new ArrayList<>();


    public static void main(String[] args) {

        int  coordinatesArr [][] = new int[][] {{1,3},{-2,2},{5,8},{0,1}};

        Coordinate c1 = new Coordinate(1,3);
        c1.setDistanceFromOrigin();
        coordinateList.add(c1);

        Coordinate c2 = new Coordinate(-2,2);
        c2.setDistanceFromOrigin();
        coordinateList.add(c2);

        Coordinate c3 = new Coordinate(5,8);
        c3.setDistanceFromOrigin();
        coordinateList.add(c3);

        Coordinate c4 = new Coordinate(0,1);
        c4.setDistanceFromOrigin();
        coordinateList.add(c4);


       for(Coordinate c: coordinateList){

           maxHeap.add(c);
           if(maxHeap.size() > k){
               maxHeap.poll();
           }
       }

       while (!maxHeap.isEmpty()){
           closestCoordinates.add((Coordinate) maxHeap.poll());
       }


        System.out.println("Closest points from origin are:  "+closestCoordinates);
    }
}
class Coordinate{

    int x;
    int y;
    double distanceFromOrigin;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDistanceFromOrigin(){

        distanceFromOrigin =  Math.sqrt(x*x+y*y);
    }

    public double getDistanceFromOrigin(){

        return distanceFromOrigin;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class CoordinateComparator implements Comparator<Coordinate> {


    @Override
    public int compare(Coordinate o1, Coordinate o2) {

        if(o1.getDistanceFromOrigin() > o2.getDistanceFromOrigin()){
            return -1;
        }
        else if(o1.getDistanceFromOrigin() < o2.getDistanceFromOrigin()){
            return 1;
        }
        return 0;
    }


}

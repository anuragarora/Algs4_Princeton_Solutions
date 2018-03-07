import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BruteCollinearPoints {
    private Deque<LineSegment> mSegments;
    
    // Finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        mSegments = new Deque<>();
        if (points == null) {
            throw new IllegalArgumentException("points array cannot be null");
        }
        
        checkForDuplicatePoints(points);
        
        // Using natural sort provided by Point's compareTo method
        Arrays.sort(points);
        
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])
                            && points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])) {
                            // *** How to check if point already exists in line segment *** //
                            mSegments.addLast(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }
    }
    
    // The number of line segments
    public int numberOfSegments() {
        return mSegments.size();
    }
    
    // The line segments
    public LineSegment[] segments() {
        int size = numberOfSegments();
        LineSegment[] lineSegment = new LineSegment[size];
        
        for(int index = 0; index < size; index++) {
            lineSegment[index] = mSegments.removeFirst();
        }
        return lineSegment;
    }
    
    // Remove duplicate points
    public void checkForDuplicatePoints(Point[] points) {
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if ((i != j && points[i].compareTo(points[j]) == 0) || 
                    points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        
        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
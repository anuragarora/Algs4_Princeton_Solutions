import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private Deque<LineSegment> mSegments;
    
    // Finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        mSegments = new Deque<>();
        if (points == null) {
            throw new IllegalArgumentException("points array cannot be null");
        }
        
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("point cannot be null");
            }
            for (int j = i + 1; j < points.length; j++) {
                if (points[j] == null || points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
                for (int k = j + 1; k < points.length; k++) {
                    if (points[k] == null || points[j].compareTo(points[k]) == 0) {
                        throw new IllegalArgumentException();
                    }
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[l] == null || points[k].compareTo(points[l]) == 0) {
                            throw new IllegalArgumentException();
                        }
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
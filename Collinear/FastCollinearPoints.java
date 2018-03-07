import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class FastCollinearPoints {
    private Deque<LineSegment> mLineSegments;
    
    // Finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        mLineSegments = new Deque<LineSegment>();
        if (points == null) {
            throw new IllegalArgumentException("Points array cannot be null");
        }

        // Sorting the array
        Point[] sorted = Arrays.copyOf(points, points.length);
        Arrays.sort(sorted);
        
        int i = 0;
        while (i < points.length) {
            // Origin point
            //Point origin = points[i];
            Arrays.sort(sorted, points[i].slopeOrder());
            
            int j = 1;
            double slopeToMatch = points[i].slopeTo(sorted[j]);
            while (j < sorted.length && points[i].slopeTo(sorted[j]) == slopeToMatch) {
                j++;
            }
            
            if ((j - i) >= 4) {
                System.out.println("Adding segment from point" + points[i] + "to" + points[j-1] + "\n");
                mLineSegments.addLast(new LineSegment(points[i], points[j-1]));
                i = j;
            }
            i++;
        }
        // Check collinearity via checking slopes of adjacent points
        /*int i = 0;
        while (i < points.length) {
            // Origin point
            Point origin = points[i];
            
            // Creating a new array which
            //Point[] sorted = Arrays.copyOf(points, points.length);
            //Arrays.sort(sorted, origin.slopeOrder());
            
            int j = 1;
            double slopeToMatch = origin.slopeTo(sorted[j]);
            while (j < sorted.length && origin.slopeTo(sorted[j]) == slopeToMatch) {
                j++;
            }
            
            if ((j - i) >= 4) {
                System.out.println("Adding segment from point" + origin + "to" + points[j-1] + "\n");
                mLineSegments.addLast(new LineSegment(points[i], points[j-1]));
            }
            
            i++;
        }*/
    }
    
    // The number of line segments
    public int numberOfSegments() {
        return mLineSegments.size();
    }
    
    // The line segments
    public LineSegment[] segments() {
        int size = numberOfSegments();
        LineSegment[] lineSegments = new LineSegment[size];
        for (int index = 0; index < size; index++) {
            lineSegments[index] = mLineSegments.removeFirst();
        }
        return lineSegments;
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
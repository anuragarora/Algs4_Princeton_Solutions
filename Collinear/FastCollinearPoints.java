import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private Deque<LineSegment> mLineSegments;
    
    // Finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        mLineSegments = new Deque<LineSegment>();
        if (points == null) {
            throw new IllegalArgumentException("Points array cannot be null");
        }
        
        // Sorting all the points
        Merge.sort(points);

        // Check collinearity via checking slopes of adjacent points
        for (int i = 0; i < (points.length-3); i++) {
            if (points[i].slopeTo(points[i + 1]) == points[i].slopeTo(points[i + 2])
                    && points[i].slopeTo(points[i + 1]) == points[i].slopeTo(points[i + 3])) {
                // How to make sure the same line segment is not getting entered twice
                System.out.println("Adding segment from point" + points[i] + "to" + points[i + 3] + "\n");
                
                mLineSegments.addLast(new LineSegment(points[i], points[i + 3]));
                i = i + 3;
            }
        }
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
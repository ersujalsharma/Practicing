package Programs.Development;

public class Point {
    private double x;
    private double y;
    public Point() {
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance(){
        return Math.sqrt((x*x)+(y*y));
    }
    public double distance(Point p){
        return Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public static void main(String[] args) {
        Point p1 = new Point(2,3);
        System.out.println(p1.distance());
        Point p2 = new Point(5,6);
        System.out.println(p1.distance(p2));
    }
}

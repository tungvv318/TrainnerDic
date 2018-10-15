public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {}

    public Triangle(Point p1, Point p2, Point p3) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(String color, boolean filled, Point p1, Point p2, Point p3) {
        super(color, filled);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public int getAre() {
        return Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY()));
    }

    public double getPerimeter() {
        return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()))
                + Math.sqrt((p1.getX() - p3.getX()) * (p1.getX() - p3.getX()) + (p1.getY() - p3.getY()) * (p1.getY() - p3.getY()))
                + Math.sqrt((p2.getX() - p3.getX()) * (p2.getX() - p3.getX()) + (p2.getY() - p3.getY()) * (p2.getY() - p3.getY()));
    }

    public void move(int x, int y) {
        p1.setX(p1.getX() + x);
        p1.setY(p1.getY() + y);
        p2.setX(p2.getX() + x);
        p2.setY(p2.getY() + y);
        p3.setX(p3.getX() + x);
        p3.setY(p3.getY() + y);
    }
}

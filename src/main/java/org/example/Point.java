package ua.opnu;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Реалізація інтерфейсу Movable у самому класі
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.println("Точка переміщена у координати (" + x + ", " + y + ")");
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p = new Point(2.5, 4.7);
        System.out.println(p);
        p.moveTo(10.2, 12.8);
        System.out.println("Нова позиція: " + p);
    }
}

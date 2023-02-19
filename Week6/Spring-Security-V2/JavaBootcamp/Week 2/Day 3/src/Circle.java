public class Circle extends Shape{
    private double radius = 1.0;

    public Circle(){
        super();
        radius = 1.0;
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return 3.14*Math.pow(radius,2);
    }
    public double getPerimeter(){
        return 2*3.14*radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius="+
                radius + ", which is a subclass of " +
                super.toString();
    }
}

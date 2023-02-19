public class Main {
    public static void main(String[] args) {

        Circle c = new Circle(3);
        System.out.println(c.toString());
        System.out.println("The area of a circle with a radius=" + c.getRadius() + " is " + c.getArea());
        System.out.println("The perimeter of a circle with a radius=" + c.getRadius() + " is " + c.getPerimeter() + "\n");


        Rectangle r = new Rectangle("red", false,3,5);
        System.out.println(r.toString());
        System.out.println("The area of a rectangle with a width=" + r.getWidth() + " and length=" + r.getLength() +  " is " + r.getArea());
        System.out.println("The perimeter of a rectangle with a width=" + r.getWidth() + " and length=" + r.getLength() +  " is " + r.getPerimeter() + "\n");


        Square s = new Square(3);
        System.out.println(s.toString());
        System.out.println("The area of a square with a side=" + s.getSide() + " is " + s.getArea());
        System.out.println("The perimeter of a circle with a side=" + s.getSide() + " is " + s.getPerimeter() + "\n");
    }
}
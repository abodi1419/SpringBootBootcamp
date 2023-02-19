package Movable;

public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0,0,1,1);
        System.out.println(point.toString());

        point.moveUp();
        System.out.println(point.toString());

        point.moveDown();
        System.out.println(point.toString());

        point.moveRight();
        System.out.println(point.toString());

        point.moveLeft();
        System.out.println(point.toString());
    }
}

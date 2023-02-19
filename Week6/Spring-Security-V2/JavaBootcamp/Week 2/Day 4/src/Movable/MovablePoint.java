package Movable;

public class MovablePoint implements Movable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        System.out.println("Point has moved up!");
        y+=ySpeed;
    }

    @Override
    public void moveDown() {
        System.out.println("Point has moved down!");
        y-=ySpeed;
    }

    @Override
    public void moveLeft() {
        System.out.println("Point has moved left!");
        x-=xSpeed;
    }

    @Override
    public void moveRight() {
        System.out.println("Point has moved right!");
        x+=xSpeed;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Square extends Rectangle{

    public Square(){
        super();
    }
    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide(){
        return super.getWidth();
    }
    public void setSide(double width){
        super.setWidth(width);
    }
    public String toString() {
        return "A Square with side="+
                getSide() + ", which is a subclass of " +
                super.toString();
    }

}

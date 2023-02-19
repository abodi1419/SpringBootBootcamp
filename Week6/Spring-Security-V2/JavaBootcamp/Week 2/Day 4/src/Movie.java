public class Movie extends Product{
    private String director;

    public Movie(){
        super();
        director="";
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //15% discount
    public double getDiscount() {
        double discount = super.getPrice() - (super.getPrice()*0.15);
        setPrice(discount);
        return discount;
    }

}

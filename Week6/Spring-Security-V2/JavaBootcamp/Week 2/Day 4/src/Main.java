public class Main {
    public static void main(String[] args) {

        Book book = new Book("Harry Potter", 150, "J. K. Rowling");

        Movie movie = new Movie("The Godfather", 80, "Francis Coppola");

        System.out.println("Book Information:\n" +
                "Name: " + book.getName() +
                "\nPrice: " + book.getPrice() +
                "\nAuthor: "+ book.getAuthor());
        System.out.println("The Book's price after discount: " + book.getDiscount() + "\n");


        System.out.println("Movie Information:\n" +
                "Name: " + movie.getName() +
                "\nPrice: " + movie.getPrice() +
                "\nDirector: "+ movie.getDirector());
        System.out.println("The Movie's price after discount: " + movie.getDiscount() + "\n");



    }
}
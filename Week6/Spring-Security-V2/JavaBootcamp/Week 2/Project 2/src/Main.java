public class Main {
    public static void main(String[] args) {

        Train train = new Train("1",60,9,"00:00");
        Car car = new Car("2", 140, 35, "20:00", 2, 30);

        train.display();
        System.out.println();
        car.display();

    }
}
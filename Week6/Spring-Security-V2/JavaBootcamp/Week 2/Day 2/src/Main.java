public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account("1","abdulaziz",12000);
        Account acc2 = new Account("2", "faisal");

        System.out.println("information of the first account:\n" +
                "id: " + acc1.getId() +
                "\nname: " + acc1.getName() +
                "\nbalance: " + acc1.getBalance());


        System.out.println("information of the Second account:\n" +
                "id: " + acc2.getId() +
                "\nname: " + acc2.getName() +
                "\nbalance: " + acc2.getBalance());


        System.out.println("The new balance after withdrawing 1000 from the first account: " + acc1.credit(1000));

        System.out.println("The new balance after depositing 1500 to the second account: "+ acc2.debit(1500));

        System.out.println("The new balance for the first account after transferring 2000 to the second account: "+ acc1.transferTo(acc2,2000));





    }
}
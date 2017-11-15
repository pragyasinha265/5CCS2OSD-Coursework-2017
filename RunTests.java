public class RunTests {

    public static void main(String[] args) {

        Bond bond = new Bond("HSBC", 100, 5, 10, 1);
        System.out.println("Payout is " + bond.getPayout());
        System.out.println("Value is " + bond.getValue());
        System.out.println("Macaulay duration is " + bond.getMD());


    }


}

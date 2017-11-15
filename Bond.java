import java.util.Date;

public class Bond {


    //name of bond
    private String name;

    //initial amount invested in bond
    private double price;

    //how many years the bond is for
    private int term;

    //percentage of investment paid to investor at regular intervals
    private double coupon;

    //payments per year
    private int freq;

    //bought on
    private Date purchaseDate;



    //total payout of bond not including inflation
    private double payout;

    //sum of discounted payments
    private double value;

    //
    private double internalRateOfReturn;

    //amount of time until the value paid initially is returned
    private double macaulayDuration;



    //constructor
    public Bond(String name, double price, int term, double coupon, int freq) {
        this.name = name;
        this.price = price;
        this.term = term;
        this.coupon = coupon;
        this.freq = freq;
        purchaseDate = new Date();
        calcPayout();                   //assigns result of computation to field
        calcValue();                    //assigns result of computation to field
        calcIRR();                      //assigns result of computation to field
        calcMD();                       //assigns result of computation to field
    }



    //calculates the total amount of money returned by the bond and assigns to field
    public void calcPayout() {
        payout = ((freq*term))*(coupon/100)*price + price;
    }

    //calculates the sum of discounted payments taking into account inflation
    public void calcValue() {

        double total = 0;

        //for each year
        for(int i = 1; i <= term; i++){
            //for each payment
            for(int j = 0; j < freq; j++) {
                double paymenti = (coupon/100)*price;
                //if last payment
                if(i == term && j == freq-1) {
                    double finalPayment = paymenti + price;
                    total+= finalPayment/Math.pow((1+0.05), i);
                }
                else {
                    total += paymenti/Math.pow((1+0.05),i);
                }
            }
        }

        value = total;
    }

    //calculate internal rate of return
    public void calcIRR() {

    }

    //calculate macaulay duration
    public void calcMD() {

        double totalAdjustedPayements = 0;
        double pv = 0;

        //for each year
        for(int i = 1; i <= term; i++){
            //for each payment
            for(int j = 0; j < freq; j++) {
                double paymenti = (coupon/100)*price;
                //if last payment
                if(i == term && j == freq-1) {
                    double finalPayment = paymenti + price;

                    totalAdjustedPayements += finalPayment/Math.pow((1+0.05), i);
                    pv += (finalPayment/Math.pow((1+0.05), i))*i;
                }
                else {
                    totalAdjustedPayements += paymenti/Math.pow((1+0.05),i);
                    pv += (paymenti/Math.pow((1+0.05),i))*i;
                }
            }
        }

        macaulayDuration = pv/totalAdjustedPayements;
    }



    public int getDuration() {return term;}

    public double getPayout() {return payout;}

    public double getValue() {return value;}

    public double getIRR() {return internalRateOfReturn;}

    public double getMD() {return macaulayDuration;}




}

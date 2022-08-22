import uwcse.io.Input;
import java.text.DecimalFormat;

/**
 * Simulating a purchase in Canada paid in US dollars
 *
 * @author <Sergio Satyabrata>
 */


public class CanadianGiftShop {
    // Constants
    /** Exchange rate 1 US dollar = RATE Canadian dollar */
    public final double RATE = 1.16;

    /** Price of a jar of maple syrup in Canadian dollars before taxes */
    public final double JAR_PRICE = 5.95;

    /**
     * Price of photograph of the city of Victoria in Canadian dollars before
     * taxes
     */
    public final double PHOTO_PRICE = 7.65;

    /** Price of a beaver hat in Canadian dollars before taxes */
    public final double HAT_PRICE = 16.35;

    /** Maximum allowed number of purchased items for each item */
    public final int MAX_ITEM = 100;

    /** Tax rate */
    public final double TAX_RATE = 1.093;

    // set total amount in Canadian dollar
    public double Total;
    // set charge in Canadian dollar
    public double Change;

    // instance variables
    // number of purchased jars of maple syrup
    private int jarAmount;

    // number of purchased photographs of the city of Victoria
    private int photoAmount;

    // number of purchased beaver hats
    private int hatAmount;

    // 2 digits after the decimal point for doubles
    private DecimalFormat twoDigits = new DecimalFormat("0.00");

    public double payUS, costCA;

    private Input in = new Input();

    /**
     * Takes and processes the order from the customer
     */
    public void takeAndProcessOrder()
    {
        // Here is a possible series of steps: call some other (private)
        // methods to do each step.

        // Display the items and their prices
        System.out.println(" Welcome To The Shop ");
        System.out.println("----------------------");
        System.out.println("Here are our prices for our popular products (in CAD)"
                + "\n Jar of Maple Syrup: $5.95 \n Photograph of Victoria: $7.65 \n Beaver Hat: $16.35\nThe prices above does not include tax.\n The tax rate is 9.30% \n"
                + "Our exchange rate is 1 US dollar = 1.28 Canadian dollars");

        itemList();
        // Customer inputs their order
        input();

        Total = (jarAmount * JAR_PRICE + photoAmount * PHOTO_PRICE + hatAmount * HAT_PRICE) * (TAX_RATE);

        itemList();
        // Converting their input to USD

        payUS = in.readDouble("If you are paying in USD, we will automatically convert USD to CAD for you!" + "\n Please enter amount in USD: ");

        // Give the change back in CAD

        changeinCAD(payUS,costCA);

    }

    // Some ideas for some private methods
    // You don't have to use exactly these same methods.

    /**
     * Computing their orders
     */
    private void itemList()
    {
        System.out.println("Your total is CAD" + twoDigits.format(Total) + " (tax included)");

    }

    /**
     * Gets the customer's order Precondition: none Postcondition: jarNumber,
     * photoNumber and hatNumber are initialized to a value between 0 and
     * MAX_ITEM
     */
    private void input()
    {
        jarAmount = in.readInt("How many jar(s) of maple syrup would you like to purchase: ");
        jarAmount = inputCorrecter(jarAmount);
        photoAmount = in.readInt("How many photograph(s) of Victoria would you like to purchase: ");
        photoAmount = inputCorrecter(photoAmount);
        hatAmount = in.readInt("How many beaver hat(s) would you like to purchase: ");
        hatAmount = inputCorrecter(hatAmount);
    }
    //
    private int inputCorrecter(int n)
    {
        if (n > MAX_ITEM)
        {
            System.out.println("Apologies, but we do not have that many in stock. We have a maximum of 100. ");
            return 0;
        }

        else if (n < 0)
        {
            System.out.println("The amount you have inputed: " + hatAmount + " is invalid!");
            return 0;
        }

        else if (n < 0)
        {
            System.out.println("The amount you have inputed: " + photoAmount + " is invalid!");
            return 0;
        }

        else if (n < 0)
        {
            System.out.println("The amount you have inputed: " + jarAmount + " is invalid!");
            return 0;
        }

        else
        {
            return n;
        }
    }

    /**
     * Given a purchase in canadian dollars and a payment in US dollars,
     * displays the change amount in canadian dollars and cents
     *
     * @param payUS
     *            payment in US dollars
     * @param costCA
     *            purchase amount in Canadia dollars
     */
    private void changeinCAD(double payUS,double costCA)
    {
        costCA = payUS * RATE;
        Change = costCA - Total;
        // change into cents
        int InCent = (int)(Double.valueOf(twoDigits.format(Change)).doubleValue() * 100);

        if (Change < 0)
        {
            System.out.println("Apologies, but the amount you entered is not enough. ");
            System.out.println("If you would like to try again, please re-enter everything again. ");
            System.exit(0);

        }
        else
        {
            System.out.println("You entered USD" + payUS + ", which converts to CAD" + twoDigits.format(costCA));
            System.out.println("Your change is CAD" + twoDigits.format(Change));

            int cash20 = InCent / 2000;
            int cash10 = InCent % 2000 / 1000;
            int cash5 = InCent % 1000 / 500;
            int cash1 = InCent % 1000 % 500 / 100;
            int coin25 = InCent % 1000 % 500 / 100;
            int coin10 = InCent % 1000 % 500 % 100 / 10;
            int coin5 = InCent % 1000 % 500 % 100 % 25 % 10 / 5;
            int coin1 = InCent % 1000 % 500 % 100 % 25 % 10 % 5 /1;

            if (cash20> 1)
            {
                System.out.println(cash20 + " $20 bills.");
            }
            else if(cash20 == 1)
            {
                System.out.println(cash20 + " $20 bill.");
            }

            if (cash10> 1)
            {
                System.out.println(cash10 + " $10 bills.");
            }
            else if(cash10 == 1)
            {
                System.out.println(cash10 + " $10 bill.");
            }

            if (cash5> 1)
            {
                System.out.println(cash5 + " $5 bills.");
            }
            else if(cash5 == 1)
            {
                System.out.println(cash5 + " $5 bill.");
            }

            if (cash1> 1)
            {
                System.out.println(cash1 + " $1 bills.");
            }
            else if(cash1 == 1)
            {
                System.out.println(cash1 + " $1 bill.");
            }
            if (coin25> 1)
            {
                System.out.println(coin25 + " $25C cents.");
            }
            else if(coin25 == 1)
            {
                System.out.println(coin25 + " $25C cent.");
            }

            if (coin10> 1)
            {
                System.out.println(coin10 + " $10C cents.");
            }
            else if(coin10 == 1)
            {
                System.out.println(coin10 + " $10C cent.");
            }

            if (coin5> 1)
            {
                System.out.println(coin5 + " $5C cents.");
            }
            else if(coin5 == 1)
            {
                System.out.println(coin5 + " $5C cent.");
            }

            if (coin1> 1)
            {
                System.out.println(coin1 + " $1C cents.");
            }
            else if(coin1 == 1)
            {
                System.out.println(coin1 + " $1C cent.");
            }

            System.out.println("------------------------------------------------------");
            System.out.println("Thank you so much for your purchases, have a nice day!");
            System.exit(0);
        }
    }

    /**
     * Entry point of the program
     */
    public static void main(String[] args)
    {
        new CanadianGiftShop().takeAndProcessOrder();
    }

}

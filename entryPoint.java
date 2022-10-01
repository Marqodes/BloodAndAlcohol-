import java.util.Scanner;
/*
 * We should have a person class and a drink class, future updatesA
 * Maybe we save the drinks in an array
 */

 // is this working 9:58pm
 // test at 10:03
public class entryPoint
{
    static float totalOzComsumed = 0.0F;
    static int numberOfDrinks = 0;

 
    static Person user = new Person();
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String userInput;

        do 
        {
            printIntroScreen();
            userInput = in.nextLine();

            switch(userInput.charAt(0))
            {
                case 't':
                    trackScreen();
                    break;
                case 'c':
                    System.out.println("Under Construction....");
                    break;
                case 's':
                    // This will clear the screen
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println(user);
                    System.out.println("-------------------------------------");
                    break;

            }
            
        } while(userInput.charAt(0) !=  'q');
    }

    public static void printIntroScreen()
    {
        System.out.println("Welcome To hDai");
        System.out.println("(t) Track");
        System.out.println("(c) Calculate");
        System.out.println("(s) Summary");
        System.out.println("(q) quit");
        System.out.print("Enter choice: ");
    }

    public static void trackScreen()
    {
        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);

        float tempOz = 0.0f;
        float tempAlc = 0.0f;

        // every time this method is called it will add one to this variable

        System.out.println("\tTracking Screen");

        System.out.print("- Enter Fluid Volume: ");
        tempOz = in.nextFloat();

        System.out.print("- Enter Alcohol %:  ");
        tempAlc = in.nextFloat();

        Beverage currentBeverage = new Beverage(tempAlc, tempOz);
        user.beverageList.add(currentBeverage);
        user.increaseDrinkCount();

        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // print confirmation
        System.out.println("Drink #" + user.getDrinkCount() + " has been loged Vol: " + currentBeverage.getFluidOz() + " Alc: " + currentBeverage.getAlcholPercentage());
        System.out.println("------------------------------------------------");
    }


}
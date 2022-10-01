import java.util.Scanner;


/*
 * We should have a person class and a drink class, future updatesA
 * Maybe we save the drinks in an array
 */
public class entryPoint
{
    static float totalOzComsumed = 0.0F;
    static int numberOfDrinks = 0;

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
            }
            
        } while(userInput.charAt(0) !=  'q');
    }

 // This is the intro page
    public static void printIntroScreen()
    {
        System.out.println("Welcome To hDai");
        System.out.println("(t) Track");
        System.out.println("(c) Calculate");
        System.out.println("(q) quit");
        System.out.print("Enter choice: ");
    }
// This is the track option screen 
    public static void trackScreen()
    {
        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);

        float tempOz = 0.0f;
        float tempAlc = 0.0f;

        // every time this method is called it will add one to this variable
        numberOfDrinks++;

        System.out.println("\tTracking Screen");

        System.out.print("- Enter Fluid Volume: ");
        tempOz = in.nextFloat();

        System.out.print("- Enter Alcohol %:  ");
        tempAlc = in.nextFloat();

        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // print confirmation
        System.out.println("Drink #" + numberOfDrinks + " has been loged Vol: " + tempOz + " Alc: " + tempAlc);
        System.out.println("------------------------------------------------");
    }
}

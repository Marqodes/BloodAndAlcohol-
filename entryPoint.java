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
        System.out.println("\t---------------");

        /*
         * input validation for input of oz
         * keeps looping until user enters a number and its between 1 and 128
         */
        do
        {
            System.out.print("- Enter Fluid Volume: ");
            // this is like saying "while in.hasNextFloat != true"
            while(!in.hasNextFloat())
            {
                System.out.println("Please enter a valid number between 1 and 128!");
                System.out.print("- Enter Fluid Volume: ");
                in.next();
            }

            tempOz = in.nextFloat();
            if(tempOz <= 0 || tempOz > 128)
            {
                if(tempOz <= 0)
                {
                    System.out.println("**Come-on! It is not possible to drink that little...**");
                    System.out.println("Please enter a valid number between 1 and 128!");
                }
                else
                {
                    System.out.println("**You need help! You drink over a gallon in one sitting??**");
                    System.out.println("Please enter a valid number between 1 and 128!");
                }
            }

        }while(tempOz <= 0 || tempOz > 128);


        /*
         * input validation for input of %
         * keeps looping until user enters a number and its between 1 and 100
         */
        do
        {
            System.out.print("- Enter Alcohol %:  ");
            // this is like saying "while in.hasNextFloat != true"
            while(!in.hasNextFloat())
            {
                System.out.println("Please enter a valid number between 1 and 100!");
                System.out.print("- Enter Alcohol: ");
                in.next();
            }

            tempAlc = in.nextFloat();
            if(tempAlc <= 0 || tempAlc > 100)
            {
                if(tempAlc <= 0)
                {
                    System.out.println("**You're drinking water...**");
                    System.out.println("Please enter a valid number between 1 and 100!");
                }
                else
                {
                    System.out.println("**You must be drunk! No-way its over 100%!**");
                    System.out.println("Please enter a valid number between 1 and 100!");
                }
            }

        }while(tempAlc <= 0 || tempAlc > 100);

        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // print confirmation
        System.out.println("Drink #" + numberOfDrinks + " has been loged Vol: " + tempOz + " Alc: " + tempAlc);
        System.out.println("------------------------------------------------");
    }
}
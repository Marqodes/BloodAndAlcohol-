/* 
	- MQv 0.5.0		Added trackScreen w/ input validation
	- MMv 0.6.0		Added calcScreen w/ new variables including current time
    - MMv 0.6.1     Changed age input, main menu, trackScreen() print confirmation
    - MMv 0.6.2     Changed name to first name only and gender to remove comma as valid input

    - MQv 0.6.3     now the fluid oz and alc% print every line when you press enter
*/

import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * We should have a person class and a drink class, future updatesA
 * Maybe we save the drinks in an array
 * Height input needed
 * Log with naming convention
 * History
 * Back feature
 * Enter only crashes program at intro screen
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
                case 't': case 'T':
                    trackScreen();
                    break;
                case 'c': case 'C':
                    calcScreen();
                    break;
            }

        } while(userInput.charAt(0) !=  'q' && userInput.charAt(0) !=  'Q');
    }

	// ::INTRO
    public static void printIntroScreen()
    {
        System.out.println("Welcome To hDai");
        System.out.println("(t) Track");
        System.out.println("(c) Calculate");
        System.out.println("(q) quit");
        System.out.print("Enter choice: ");
    }

	// ::TRACKSCREEN 
    public static void trackScreen()
    {
        // This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);

		// Current time with pm am
	    Date currentDate = new Date();
	    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

        float tempOz = 0.0f;
        float tempAlc = 0.0f;

        // every time this method is called it will add one to this variable
        numberOfDrinks++;

        System.out.println("\tTracking Screen");
        System.out.println("\t---------------");


		// ::FLUID VOLUME
        do
        {
            System.out.print("- Enter Fluid Volume(oz): ");
            String fluidS = in.nextLine();

            while(!fluidS.matches("[0-9]+"))
            {
                System.out.print("- Enter Fluid Volume(oz): ");
                fluidS = in.nextLine();
            }

            float tempO = Float.parseFloat(fluidS);
            if(tempO <= 0 || tempO > 128)
            {
                if(tempO <= 0)
                {
                    System.out.println("Please enter a valid number between 1 and 128!");
                }
                else
                {
                    System.out.println("Please enter a valid number between 1 and 128!");
                }

            }
            tempOz = tempO;
        }while( tempOz <= 0 || tempOz > 128);

		// ::ALCOHOL %
        do
        {
            
            System.out.print("- Enter Alcohol %:  ");
            String percentS = in.nextLine();

            while(!percentS.matches("[0-9]+"))
            {
                System.out.print("- Enter Alcohol %:  ");
                percentS = in.nextLine();
            }

            float tempA = Float.parseFloat(percentS);
            if(tempA <= 0 || tempA > 100)
            {
                if(tempAlc <= 0)
                {
                    System.out.println("Please enter a valid number between 1 and 100!");
                }
                else
                {
                    System.out.println("Please enter a valid number between 1 and 100!");
                }
            }
            tempAlc = tempA;
        }while(tempAlc <= 0 || tempAlc > 100);

        // Clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // printScreen() confirmation
        System.out.println("Drink #" + numberOfDrinks + " has been logged." + "\n\tVol: "  + tempOz +  "\n\tAlc: " + tempAlc + "\n\tTime: " + timeFormat.format(currentDate));
        System.out.println("------------------------------------------------");
    }

	// ::CALCSCREEN
    public static void calcScreen()
    {

		// This will clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);

		Date currentDate = new Date();
	    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

        int userAge = 0; 
        int userWeight = 0;
        float tempOz = 0.0f;
        float tempAlc = 0.0f;

        numberOfDrinks++;

        System.out.println("\tTracking Screen");
        System.out.println("\t---------------");

        //userName - checks for A-Z, a-z input only
		// ::NAME
        System.out.println("- Enter your first name: ");
        String userName = in.nextLine();
        
            while(!userName.matches("[a-zA-Z]+")) //TALK ABOUT THIS
            {
                System.out.println("Please enter your first name only with no spaces.");
                userName = in.nextLine();
            }

        //userGender - checks for M,m,F,f user input only
		// ::GENDER
        System.out.println("- Enter your gender (M or F): ");
        String userGender = in.nextLine();
            while(!userGender.matches("[MmFf]+")) //NO COMMA
            {
                System.out.println("Please enter M or F!");
                userGender = in.nextLine();    
            }

        // ::AGE
        do
        {
            System.out.print("- Enter your age: ");
            // this is like saying "while in.hasNextInt != true"
            while(!in.hasNextInt())
            {
                System.out.println("Please enter a valid number between 21 and 110!");
                System.out.print("- Enter your age: ");
                in.next();
            }

            userAge = in.nextInt();
            if(userAge < 21 || userAge > 110)
            {
                if(userAge < 21)
                {
                    System.out.println("SORRY, YOU MUST BE 21 OR OLDER.");
                    System.exit(0);                    
                    //System.out.println("Please enter a valid age between 21 and 110!");
                }
                else
                {
                    System.out.println("-_-");
                    //System.out.println("Please enter a valid number between 21 and 110!");
                }
            }

        }while(userAge < 21 || userAge > 110);  

		// ::WEIGHT
        do
        {
            System.out.print("- Enter your weight: ");
            // this is like saying "while in.hasNextInt != true"
            while(!in.hasNextInt())
            {
                System.out.println("Please enter a valid number between 80 and 400!");
                System.out.print("- Enter your weight: ");
                in.next();
            }

            userWeight = in.nextInt();

            if(userWeight < 80 || userWeight > 400)
            {
                System.out.println("Please enter a valid number between 80 and 400!");
            }

        }while(userWeight < 80 || userWeight > 400);    

		// ::FLUID VOLUME
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

		// ::ALCOHOL %
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
        System.out.println("Drink #" + numberOfDrinks + " has been logged." + "\n\tVol: "  + tempOz +  "\n\tAlc: " + tempAlc + "\n\tTime: " + timeFormat.format(currentDate) );
        System.out.println("------------------------------------------------");
        System.out.println( "Estimated BAC for " + userName + " is: TBA");
        System.out.println("------------------------------------------------");
    }

}
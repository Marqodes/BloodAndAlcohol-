import java.util.Scanner;

public class InputVal 
{
    /*
     ** readFloat()
     * 0 = fluid    Range: 0.1-128.0
     * 1 = alc      Range: 0.1-100.0
     * 2 = weight   Range: 80.0-400.0
     * 
     ** readInteger()
     * 3 = age      Range: 21-100
     * 4 = feet     Range: 2-8
     * 5 = inches   Range: 0-11
     * 
     ** readName()
     * name         Allowed: [A-Za-z] no spaces
     * 
     ** readGender()
     * gender       Allowed: [M|m|F|f] only one character
     * 
     */

    final static String FLUID_ERROR  = "\t*Please enter a valid number between 0.1-128.0*\n";
    final static String FLUID_MSG = "- Enter Fluid Volume(oz): ";

    final static String ALCOHOL_ERROR  = "\t*Please enter a valid number between 0.1-100.0*\n";
    final static String ALCOHOL_MSG = "- Enter ABV(%): ";

    final static String WEIGHT_ERROR  = "\t*Please enter a valid number between 80.0-400.0*\n";
    final static String WEIGHT_MSG = "- Enter your Weight(lbs): ";

    final static String AGE_ERROR  = "\t*Please enter a valid number between 21-100*\n";
    final static String AGE_MSG = "- Enter your Age: ";

    final static String FEET_ERROR  = "\t*Please enter a valid number between 2-8.*\n";
    final static String FEET_MSG = "- Enter your Height(ft): ";

    final static String INCH_ERROR  = "\t*Please enter a valid number between 0-11.*\n";
    final static String INCH_MSG = "- Enter your Height(in): ";

    final static String NAME_ERROR  = "\t*Please enter your first name only with no spaces.*\n";
    final static String NAME_MSG = "- Enter your First Name: ";

    final static String GENDER_ERROR  = "\t*Please enter M or F!*\n";
    final static String GENDER_MSG = "- Enter your gender (M or F): ";

    

    public static Scanner in = new Scanner(System.in);



    public static float readFloat(int f, float low, float high)
    {
        float num = 0.0F;
        String input;
        boolean valid = false;
        String promptMsg = "";
        String errorMsg = "";

        switch(f)
        {
            case 0:
                promptMsg = FLUID_MSG;
                errorMsg = FLUID_ERROR;
                break;
            case 1:
                promptMsg = ALCOHOL_MSG;
                errorMsg = ALCOHOL_ERROR;
                break;   
            case 2:
                promptMsg = WEIGHT_MSG;
                errorMsg = WEIGHT_ERROR;
                break;  
        }

        while(valid == false)
        {
            System.out.print(promptMsg);
            input = in.nextLine();

            try
            {
                num = Float.parseFloat(input);
                if(num >= low && num <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println(errorMsg);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println(errorMsg);
            }
        }

        return num;
    }

    public static int readInteger(int f, int low, int high)
    {
        int num = 0;
        String input;
        boolean valid = false;
        String promptMsg = "";
        String errorMsg = "";

        switch(f)
        {
            case 3:
                promptMsg = AGE_MSG;
                errorMsg = AGE_ERROR;
                break;
            case 4:
                promptMsg = FEET_MSG;
                errorMsg = FEET_ERROR;
                break;    
            case 5:
                promptMsg = INCH_MSG;
                errorMsg = INCH_ERROR;
                break;    
        }

        while(valid == false)
        {
            System.out.print(promptMsg);
            input = in.nextLine();

            try
            {
                num = Integer.parseInt(input);
                if(num >= low && num <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println(errorMsg);
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println(errorMsg);
            }
        }

        return num;
    }

    public static void readName()
    {
        String promptMsg = NAME_MSG;
        String errorMsg = NAME_ERROR;

        System.out.print(promptMsg);
        String input = in.nextLine();
        while(!input.matches("[a-zA-Z]+"))
        {
            System.out.println(errorMsg);
            System.out.print(promptMsg);
            input = in.nextLine();
        }
    }

    public static void readGender()
    {
        String promptMsg = GENDER_MSG;
        String errorMsg = GENDER_ERROR;

        System.out.print(promptMsg);
        String input = in.nextLine();
        while(!input.matches("[M|m|F|f]+"))
        {
            System.out.println(errorMsg);
            System.out.print(promptMsg);
            input = in.nextLine();
        }
    }






}

/* 
	- MQv 0.5.0		Added trackScreen w/ input validation
	- MMv 0.6.0		Added calcScreen w/ new variables including current time
    - MMv 0.6.1     Changed age input, main menu, trackScreen() print confirmation
    - MMv 0.6.2     Changed name to first name only and gender to remove comma as valid input
    - MQv 0.6.3     now the fluid oz and alc% print every line when you press enter
    - MQv 0.6.4     Fixed the regex to allow decimals
    - MMv 0.7.0     added height to calcScreen(), main menu crashing when no input returned fixed,
                    cleaned up console with lots of flushes, timer for when logged, added timer to nearest quarter
*/
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
 /*
 * We should have a person class and a drink class, future updatesA
 * Maybe we save the drinks in an array
 * Log with naming convention
 * History
 * Back feature
 */

 // new branch
public class entryPoint
{
    static int numberOfDrinks = 0;
//main
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String userInput;
        boolean x = false;
        do
        {
            printIntroScreen();
            userInput = in.nextLine(); 
            switch (userInput.toUpperCase()) {
                case "T": 
                    trackScreen();                   
                    break;      
                case "C":       
                    calcScreen();
                    break;
                case "Q":
                    System.exit(0);
            }                    
        }while(x==false);         
    }
//printIntroScreen
    public static void printIntroScreen()
    {
        flushScreen(); 
        System.out.println("\tWelcome To hDai\n");
        System.out.println("(t) Track");
        System.out.println("(c) Calculate");
        System.out.println("(q) quit");
        System.out.print("\nEnter choice: ");
    }
//flushScreen
    public static void flushScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
//getNearestHourQuarter
    public static LocalTime getNearestHourQuarter(LocalTime datetime) 
    {
        int minutes = datetime.getMinute();
        int mod = minutes % 15;
        LocalTime newDatetime;
        if (mod < 8) 
        {
            newDatetime = datetime.minusMinutes(mod);
        }
        else 
        {
            newDatetime = datetime.plusMinutes(15 - mod);
        }
        newDatetime = newDatetime.truncatedTo(ChronoUnit.MINUTES);
        return newDatetime; 
    }
//trackScreen 
    public static void trackScreen()
    {
        flushScreen();
        Scanner in = new Scanner(System.in);
        //variables
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a"); 
        LocalTime lt = getNearestHourQuarter(LocalTime.now());
        float fluidRange = 0.0f;
        float alcRange = 0.0f;
        numberOfDrinks++;
		// ::FLUID VOLUME
        flushScreen();	
		do
        {
            
			System.out.print("- Enter Fluid Volume(oz): ");
			String stringFluid = in.nextLine();
			
				while(!stringFluid.matches("[0-9]*.?[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 0.1-128.*\n");
					System.out.print("- Enter Fluid Volume(oz): ");
					stringFluid = in.nextLine();
				}
			float userFluid=Float.parseFloat(stringFluid); 					
                if(userFluid < 0.1 || userFluid > 128)
                {
                    if(userFluid <= 0)
                    {
                        flushScreen();
                        System.out.println("\t**Come-on! It is not possible to drink that little...**");
                        System.out.println("\t*Please enter a valid number between 0.1 and 128!*\n");
                    }
                    else
                    {
                        flushScreen();
                        System.out.println("\t**You need help! You drink over a gallon in one sitting??**");
                        System.out.println("\t*Please enter a valid number between 0.1 and 128!*\n");
                    }                                                 
                }		              
			fluidRange = userFluid;
        }while(fluidRange < 0.1 || fluidRange > 128);  
		// ::ALCOHOL%
        flushScreen();	
		do
        { 
			System.out.print("- Enter ABV(%): ");
			String stringAlc = in.nextLine();
			
				while(!stringAlc.matches("[0-9]*.?[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 0.1-100.*\n");
					System.out.print("- Enter ABV(%): ");
					stringAlc = in.nextLine();
				}
			float userAlc=Float.parseFloat(stringAlc); 						
                if(userAlc < 0.1 || userAlc > 100)
                {
                    if(userAlc < 0.1)
                    {
                        flushScreen();
                        System.out.println("\t**You're drinking water...**");
                        System.out.println("\t*Please enter a valid number between 0.1-100.*\n");  
                    }
                    else
                    {
                        flushScreen(); 
                        System.out.println("\t**You must be drunk! No-way its over 100%!**");
                        System.out.println("\t*Please enter a valid number between 0.1-100.*\n");                                                   
                    }                                                 
                }		                
			alcRange = userAlc;
        }while(alcRange < 0.1 || alcRange > 100);
        //::trackScreen PRINT
        flushScreen(); 
        System.out.println("Drink #" + numberOfDrinks + " has been logged." + "\n\tVol: "  + fluidRange + "oz." +  "\n\tAlc: " + alcRange + "%" + "\n\tTime: " + dtf.format(lt) );
        System.out.println("------------------------------------------------\n"); 
        try 
        {
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
//calcScreen
    public static void calcScreen()
    {
        flushScreen();         
        //variables
        Scanner in = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a"); 
        LocalTime lt = getNearestHourQuarter(LocalTime.now());
        int feetRange = 0;
		int inchesRange = 0;
        int weightRange = 0;
        int ageRange = 0;
        float fluidRange = 0.0f;
        float alcRange = 0.0f;
        numberOfDrinks++;    
		// ::NAME
        System.out.print("- Enter your first name: ");
        String userName = in.nextLine();      
            while(!userName.matches("[a-zA-Z]+"))
            {
                flushScreen();
                 
                System.out.println("\t*Please enter your first name only with no spaces.*\n");
                System.out.print("- Enter your first name: ");
                userName = in.nextLine();
            }
		// ::GENDER
        flushScreen();        
        System.out.print("- Enter your gender (M or F): ");
        String userGender = in.nextLine();
            while(!userGender.matches("[MmFf]+")) 
            {
                flushScreen();
                 
                System.out.println("\t*Please enter M or F!*\n");
                System.out.print("- Enter your gender (M or F): ");
                userGender = in.nextLine();    
            }
        // ::AGE 
        flushScreen();             
		do
        {
            
			System.out.print("- Enter your Age: ");
			String stringAge = in.nextLine();
			
				while(!stringAge.matches("[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 21-110.*\n");
					System.out.print("- Enter your Age: ");
					stringAge = in.nextLine();
				}
			int userAge=Integer.parseInt(stringAge); 						
			    if(userAge < 21 || userAge > 110)
                {
                    if(userAge < 21)
                    {
                        flushScreen();
                        
                        System.out.println("\t*SORRY, YOU MUST BE 21 OR OLDER.*\n");                                                   
                    }
                    if(userAge > 110)
                    {       
                        flushScreen();
                        
                        System.out.println("\t*Please enter a valid number between 21-110.*\n");                                                    
                    }
                }		                  
			ageRange = userAge;
        }while(ageRange < 21 || ageRange > 110);  
        // ::HEIGHT	
        flushScreen();         
		do
        {           
			System.out.print("- Enter your Height(ft): ");
			String stringFeet = in.nextLine();			
				while(!stringFeet.matches("[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 2-8.*\n");
					System.out.print("- Enter your Height(ft): ");
					stringFeet = in.nextLine();
				}
			int userFeet=Integer.parseInt(stringFeet); 						
                if(userFeet < 2 || userFeet > 8)
                {
                    flushScreen();
                    
                    System.out.println("\t*Please enter a valid number between 2-8.*\n");                                                   
                }		           
			feetRange = userFeet;
        }while(feetRange < 2 || feetRange > 8);  
		flushScreen();          
		do
        {
            
			System.out.print("- Enter your Height(in): ");
			String stringInches = in.nextLine();
			
				while(!stringInches.matches("[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 0-11.*\n");
					System.out.print("- Enter your Height(in): ");
					stringInches = in.nextLine();
				}
			int userInches=Integer.parseInt(stringInches); 
						
                if(userInches < 0.1 || userInches > 11)
                {
                    flushScreen();
                    
                    System.out.println("\t*Please enter a valid number between 0-11.*\n");                                                   
                }		                  
			inchesRange = userInches;
        }while(inchesRange < 0.1 || inchesRange > 11); 
		// ::WEIGHT
        flushScreen();           
		do
        {           
			System.out.print("- Enter your Weight(lbs): ");
			String stringWeight = in.nextLine();
			
				while(!stringWeight.matches("[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 80-400.*\n");
					System.out.print("- Enter your Weight(lbs): ");
					stringWeight = in.nextLine();
				}
			int userWeight=Integer.parseInt(stringWeight); 						
                if(userWeight < 80 || userWeight > 400)
                {
                    flushScreen();
                    
                    System.out.println("\t*Please enter a valid number between 80-400.*\n");                                                   
                }		               
			weightRange = userWeight;
        }while(weightRange < 80 || weightRange > 400);   
		// ::FLUID VOLUME
        flushScreen();	
		do
        {
            
			System.out.print("- Enter Fluid Volume(oz): ");
			String stringFluid = in.nextLine();
			
				while(!stringFluid.matches("[0-9]*.?[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 0.1-128.*\n");
					System.out.print("- Enter Fluid Volume(oz): ");
					stringFluid = in.nextLine();
				}
			float userFluid=Float.parseFloat(stringFluid); 					
                if(userFluid < 0.1 || userFluid > 128)
                {
                    if(userFluid <= 0)
                    {
                        flushScreen();
                        System.out.println("\t**Come-on! It is not possible to drink that little...**");
                        System.out.println("\t*Please enter a valid number between 0.1 and 128!*\n");
                    }
                    else
                    {
                        flushScreen();
                        System.out.println("\t**You need help! You drink over a gallon in one sitting??**");
                        System.out.println("\t*Please enter a valid number between 0.1 and 128!*\n");
                    }                                                 
                }		              
			fluidRange = userFluid;
        }while(fluidRange < 0.1 || fluidRange > 128);  
		// ::ALCOHOL%
        flushScreen();	
		do
        { 
			System.out.print("- Enter ABV(%): ");
			String stringAlc = in.nextLine();
			
				while(!stringAlc.matches("[0-9]*.?[0-9]+")) 
				{
                    flushScreen();
                     
                    System.out.println("\t*Please enter a valid number between 0.1-100.*\n");
					System.out.print("- Enter ABV(%): ");
					stringAlc = in.nextLine();
				}
			float userAlc=Float.parseFloat(stringAlc); 						
                if(userAlc < 0.1 || userAlc > 100)
                {
                    if(userAlc < 0.1)
                    {
                        flushScreen();
                        System.out.println("\t**You're drinking water...**");
                        System.out.println("\t*Please enter a valid number between 0.1-100.*\n");  
                    }
                    else
                    {
                        flushScreen(); 
                        System.out.println("\t**You must be drunk! No-way its over 100%!**");
                        System.out.println("\t*Please enter a valid number between 0.1-100.*\n");                                                   
                    }                                                 
                }		                
			alcRange = userAlc;
        }while(alcRange < 0.1 || alcRange > 100);   
        //calcScreen PRINT
        flushScreen();  
        System.out.println("Drink #" + numberOfDrinks + " has been logged." + "\n\tVol: "  + fluidRange + "oz." +  "\n\tAlc: " + alcRange + "%" + "\n\tTime: " + dtf.format(lt) );
        System.out.println("------------------------------------------------");
        System.out.println( "Estimated BAC for " + userName + " is: TBA");
        System.out.println("------------------------------------------------\n");
        try 
        {
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
}
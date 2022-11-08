import java.util.Scanner;

public class EntryPoint 
{
    public static void main(String[] args)
    {

        TrackScreenManager ts = new TrackScreenManager();
        ts.doWork();
        
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
    
}

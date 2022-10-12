import java.util.*;
public class Person 
{
    private String name;
    private int age;
    private int weight;
    private int[] height = new int[2];
    private char gender;
    private int drinkCount = 0;
    private float bloodAlcPercent;
    private ArrayList<Beverage> beverageList = new ArrayList<>();


    /*
     * These are all the setter methods for our instance variables
     */



    public void setName()
    {

    }
    public void setAge()
    {

    }
    public void setWeight()
    {

    }
    public void setHeight()
    {

    }
    public void setGender()
    {

    }
    public void increaseDrinkCounter()
    {
        drinkCount++;
    }



    /*
     * These are all the getter methods for our instance varables
     */
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public int getWeight()
    {
        return weight;
    }
    public int[] getHeight()
    {
        return height;
    }
    public char getGender()
    {
        return gender;
    }
    public int getDrinkCount()
    {
        return drinkCount;
    }
    public float getBloodAlcPercent()
    {
        //TODO: add the blood alchool function
        return bloodAlcPercent;
    }



}

import java.util.*;
public class Person 
{
    private String name;
    private int age;
    private float weight;
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
        name = InputVal.readName();
    }
    public void setAge()
    {
        age = InputVal.readInteger(3, 21, 100);
    }
    public void setWeight()
    {
        weight = InputVal.readFloat(2, 80, 400);
    }
    public void setHeight()
    {
        // height[0] = feet | height[1] = inches
        height[0] = InputVal.readInteger(4, 2, 8);
        height[1] = InputVal.readInteger(5, 0, 11);
    }
    public void setGender()
    {
        gender = InputVal.readGender();
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
    public float getWeight()
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

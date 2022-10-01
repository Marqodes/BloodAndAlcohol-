import java.util.ArrayList;

public class Person 
{
    private int drinkCount;
    ArrayList<Beverage> beverageList = new ArrayList<>();




    public void increaseDrinkCount()
    {
        drinkCount++;
    }
    public int getDrinkCount()
    {
        return drinkCount;
    }

    // get total Oz but only if list has at least one drink
    public float getTotalOz()
    {
        if(beverageList.size() < 1)
        {
            return 0;
        }
        else
        {
            float totalOz = 0;
            for(int i = 0; i < beverageList.size(); i++)
            {
                totalOz += beverageList.get(i).getFluidOz();
            }
            
            return totalOz;
        }

    }

    public float getAvgPercentage()
    {
        if(beverageList.size() < 1)
        {
            return 0;
        }
        else
        {
            float sum = 0;
            for(int i = 0; i < beverageList.size(); i++)
            {
                sum += beverageList.get(i).getAlcholPercentage();
            }
            return sum / beverageList.size();
        }
    }
    


    @Override
    public String toString()
    {
        return "Number of drinks: " + drinkCount + " Number of Oz: " + getTotalOz() + " Avg. Alcohol %: " + getAvgPercentage();
    }

    


    
}

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Beverage 
{
    private float alcoholPercentage;
    private float fluidOz; 
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
    private LocalTime time;


    public Beverage(float alcoholPercentage, float fluidOz)
    {
        this.alcoholPercentage = alcoholPercentage;
        this.fluidOz = fluidOz;
        this.time = LocalTime.now();
    }

    public float getAlcholPercentage()
    {
        return alcoholPercentage;
    }
    public float getFluidOz()
    {
        return fluidOz;
    }

    public String getTime()
    {
        return dtf.format(time);

    }
    
}

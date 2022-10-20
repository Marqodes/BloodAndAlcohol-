import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Beverage 
{
    private float fluidOz;
    private float alcPercent;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
    private LocalTime time;

    public Beverage(float alcPercent, float fluidOz)
    {
        this.alcPercent = alcPercent;
        this.fluidOz = fluidOz;
        this.time = LocalTime.now();
    }

    public float getAlcPercent()
    {
        return alcPercent;
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

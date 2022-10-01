public class Beverage 
{
    private float alcoholPercentage;
    private float fluidOz; 

    public Beverage(float alcoholPercentage, float fluidOz)
    {
        this.alcoholPercentage = alcoholPercentage;
        this.fluidOz = fluidOz;
    }

    public float getAlcholPercentage()
    {
        return alcoholPercentage;
    }
    public float getFluidOz()
    {
        return fluidOz;
    }
    
}

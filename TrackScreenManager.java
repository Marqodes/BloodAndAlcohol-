public class TrackScreenManager 
{
    private static int classCounter;
    private Person user;
    private boolean firstTime;




    public TrackScreenManager()
    {
        // every time they make an instance of this class, counter++
        if(classCounter == 0)
        {
            firstTime = true;
        }
        else
        {
            firstTime = false;
        }
        classCounter++;
    }

    public void doWork()
    {
        
        if(firstTime)
        {
            user = new Person();
            user.setName();
            user.setAge();
            user.setWeight();
            user.setHeight();
            user.setGender();
        }
    }




    
}

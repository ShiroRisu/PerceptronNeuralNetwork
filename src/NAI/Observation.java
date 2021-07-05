package NAI;

import java.util.ArrayList;

public class Observation
{
    String language;
    ArrayList<Double> al;
    public Observation(String language,ArrayList<Double> al)
    {
        this.language=language;
        this.al=al;
        this.al.add(-1.0);
    }
}

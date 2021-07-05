package NAI;

import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    public ArrayList<Observation> readData(String path) throws IOException
    {
        ArrayList<Observation> ObservationList=new ArrayList<Observation>();
        ArrayList<Double> ValuesList=new ArrayList<Double>();
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(path));
        String line;
        String[] list;

        line = reader.readLine();

        while ((line = reader.readLine()) != null)
        {
            list = line.split(";");
            for(int i=0;i< list.length-1;i++)
            {
                ValuesList.add(Double.parseDouble(list[i]));
            }

            ObservationList.add(new Observation(list[list.length-1],ValuesList));
            ValuesList=new ArrayList<>();
        }
        reader.close();
        return ObservationList;
    }
}

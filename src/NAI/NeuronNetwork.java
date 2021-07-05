package NAI;

import java.util.ArrayList;
import java.util.HashMap;

public class NeuronNetwork
{
    ArrayList<Perceptron> perceptronList;
    ArrayList<Observation> testList;
    int k;
    HashMap<String, Integer>hm=new HashMap<>();

    public NeuronNetwork(ArrayList<Perceptron> perceptronList,ArrayList<Observation> testList,int k)
    {
        this.perceptronList=perceptronList;
        this.testList=testList;
        this.k=k;
        for (int i = 0; i < perceptronList.size(); i++)
        {
            hm.put(perceptronList.get(i).language,i);
        }
    }

    public void train()
    {
        for (Perceptron p:perceptronList)
        {
            p.trein(k);
        }

    }

    public void validate()
    {
        //train();
        double accuaracy=0;
        double counter=0;
        double max=0,validateOutput=0;
        String output;

        int languageCounter[][]=new int[perceptronList.size()][perceptronList.size()];


        for (int i = 0; i < testList.size(); i++)
        {
            max=-2;
            output="";
            for (int j = 0; j < perceptronList.size(); j++)
            {
                validateOutput=perceptronList.get(j).validate(testList.get(i).al);
                if(validateOutput>max)
                {
                    max=validateOutput;
                    output=perceptronList.get(j).language;
                }
            }
            System.out.println("Język prawidłowy: "+testList.get(i).language+", język wykryty: "+output);// ,max:"+max);
            languageCounter[hm.get(testList.get(i).language)][hm.get(output)]++;
            if(testList.get(i).language.equals(output))
                counter++;
        }
        accuaracy=counter/testList.size();
        System.out.println("Dokładność: "+accuaracy*100+"%");

        System.out.print("zaklasyfikowane jako: ");
        for (Perceptron p :perceptronList)
        {
            System.out.print(p.language+"|");
        }
        System.out.println();
        for (int i = 0; i < perceptronList.size(); i++)
        {
            System.out.print("                   "+perceptronList.get(i).language+"|");
            for (int j = 0; j < languageCounter.length; j++)
            {
                System.out.print(languageCounter[i][j]+"|");
            }
            System.out.println();
        }
    }
}

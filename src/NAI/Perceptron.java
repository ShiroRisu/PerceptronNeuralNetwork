package NAI;

import java.util.ArrayList;
import java.util.Arrays;

public class Perceptron
{
    ArrayList<Observation> inputsTrein;
    String language;
    double[]weights;
    double threshold;
    double alpha;
    int output;

    Perceptron(ArrayList<Observation> inputsTrein,double alpha,String language)
    {
        this.language=language;
        this.threshold=1;
        this.weights=new double[inputsTrein.get(0).al.size()];
        Arrays.fill(this.weights,-1);
        this.inputsTrein=inputsTrein;
        this.alpha=alpha;
    }
    public double validate(ArrayList<Double> vector)
    {
        double net=0;

        for (int i = 0; i < weights.length; i++)
        {
            net=net+(weights[i]*vector.get(i));
        }
        if(net>1)
            return 1;
        else if(net<-1)
            return -1;
        else
            return net;
    }

    public void trein(int k)
    {

        int d;

        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < inputsTrein.size(); j++)
            {
                if(this.language.equals(inputsTrein.get(j).language))
                    d=1;
                else
                    d=-1;
                double lenght=0;
                for (int l = 0; l < weights.length; l++)
                {
                    weights[l]=weights[l]+(d-validate(inputsTrein.get(j).al))*alpha*inputsTrein.get(j).al.get(l);
                    lenght+=Math.pow(weights[l],2);
                }
                lenght=Math.sqrt(lenght);
                for (int l = 0; l < weights.length; l++)
                {
                    weights[l]=(weights[l]/lenght)*10;
                }
            }
        }

        System.out.println("Próg: "+weights[weights.length-1]+"\nWagi: ");

        for (int i = 0; i < weights.length-1; i++)
        {
            System.out.print(weights[i]+" ");
        }
        System.out.println();
    }
}

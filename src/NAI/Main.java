
package NAI;

        import java.io.IOException;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        /*
        arrgs[0]-test.csv
        args[1]-trein.csv
        args[2]-alpha
        args[3]-k
         */

        double alpha=Double.parseDouble(args[2]);
        int k=Integer.parseInt(args[3]);

        ArrayList<Observation> testList;
        FileHandler fh=new FileHandler();
        testList=fh.readData(args[0]);

        ArrayList<Observation> treinList;
        treinList=fh.readData(args[1]);

        HashSet<String> hs=new HashSet<String>();

        for (Observation observation : treinList) {
            hs.add(observation.language);
        }
        ArrayList<Perceptron> perceptronList=new ArrayList<Perceptron>();


        for (String s:hs)
        {
            perceptronList.add(new Perceptron(treinList,alpha,s));
        }

        NeuronNetwork neuronNetwork=new NeuronNetwork(perceptronList,testList,k);
        neuronNetwork.train();
        neuronNetwork.validate();

    }
}

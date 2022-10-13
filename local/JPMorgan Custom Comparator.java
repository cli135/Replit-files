import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Value implements Comparable<Value> {
    public Integer decimal;
    public Integer numOnesInBinary;
    public Value(int decimal) {
        this.decimal = decimal;
        
        // bit shifting to count the
        // number of ones in binary
        this.numOnesInBinary = 0;
        int d = decimal;
        while (d > 0) {
            // bitwise and
            // to check one's place
            // for a one
            numOnesInBinary += (d & 1);
            d >>= 1; // bitshifting over (rightwards)
        }
    }
    public int compareTo(Value other) {
        int check = this.numOnesInBinary.compareTo(other.numOnesInBinary);
        if (check != 0) {
            return check; 
        }
        else {
            return this.decimal.compareTo(other.decimal);
        }
    }
}

class Result {

    /*
     * Complete the 'rearrange' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY elements as parameter.
     */

    public static List<Integer> rearrange(List<Integer> elements) {
        // Write your code here
        Value[] test = new Value[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            test[i] = new Value(elements.get(i));
        }
        
        Arrays.sort(test);
        
        List<Integer> ret = new ArrayList<>();
        
        for (Value v : test) {
            ret.add(v.decimal);
        }
        
        return ret;
        
        
        

    }
    
    

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int elementsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> elements = IntStream.range(0, elementsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rearrange(elements);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

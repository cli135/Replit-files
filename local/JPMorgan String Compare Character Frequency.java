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


class Result {

    /*
     * Complete the 'areAlmostEquivalent' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY s
     *  2. STRING_ARRAY t
     */

    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
    // Write your code here
    List<String> ret = new ArrayList<>();
    for (int i = 0; i < s.size(); i++) {
        if (checkAlmostEquivalent(s.get(i), t.get(i))) {
            ret.add("YES");
        }
        else {
            ret.add("NO");
        }
    }
    return ret;

    }
    
    public static boolean checkAlmostEquivalent(String a, String b) {
        if (a.length() != b.length()) {
            return false; // end early
        }
        int[] charFrequencyA = new int[256];
        int[] charFrequencyB = new int[256];
        for (int i = 0; i < a.length(); i++) {
            charFrequencyA[a.charAt(i)]++;
            charFrequencyB[b.charAt(i)]++;
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // 3.9 means 4 but allowing for roundoff error
            if (Math.abs(charFrequencyA[ch] - charFrequencyB[ch]) > 3.9) {
                return false;
            }
            
        }
        
        return true;
        
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int tCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> t = IntStream.range(0, tCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.areAlmostEquivalent(s, t);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

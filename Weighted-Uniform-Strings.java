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
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> result = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();

        int check = 1;

        for (int i = 0; i < s.length(); ++i) {
            check = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                check++;
                i++;
            }

            for (int j = 1; j <= check; ++j) {
                weights.add((s.charAt(i) - 'a' + 1) * j);
            }
        }

        for (int query : queries) {
            result.add(weights.contains(query) ? "Yes" : "No");
        }

        return result;
    }
    
    
    public static List<String> weightedUniformStrings2(String s, List<Integer> queries) {
        List<String> result = new ArrayList<>();
        TreeMap<Integer, Boolean> mp = new TreeMap<>();

        int check = 1;

        for (int i = 0; i < s.length(); ++i) {
            check = 1;

            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                check++;
                i++;
            }

            for (int j = 1; j <= check; ++j) {
                mp.put((s.charAt(i) - 'a' + 1) * j, true);
            }
        }

        for (int query : queries) {
            result.add(mp.containsKey(query) ? "Yes" : "No");
        }

        return result;
    }    
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

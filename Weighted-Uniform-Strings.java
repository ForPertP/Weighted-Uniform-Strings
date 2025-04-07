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
  public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    
  }
d
    public static List<String> weightedUniformStrings(String s, List<Integer> queries)
    {
        List<String> result = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();

        int check = 1;

        for (int i = 0; i < s.length(); ++i)
        {
            check = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == s.cahrAt(i))
            {
                check++;
                i++;
            }

            for (int j = 1; j <= check; ++j)
            {
                weights.add((s.charAt(i) - 'a' + 1) * j);
            }
        }

        foreach (int query : queries)
        {
            result.add(weights.contains(query) ? "Yes" : "No");
        }

        return result;
    }      

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


    public static List<String> weightedUniformStrings2(Sstring s, List<Integer> queries)
    {
        List<String> result = new ArrayList<>();
        Map<int, bool> mp = new TreeMap<>();

        int check = 1;

        for (int i = 0; i < s.length(); ++i)
        {
            check = 1;

            while (i + 1 < s.length() && s.charAt( i + 1) == s.charAt(i))
            {
                check++;
                i++;
            }

            for (int j = 1; j <= check; ++j)
            {
                mp[(scharAt(i) - 'a' + 1) * j] = true;
            }
        }

        foreach (int query : queries)
        {
            result.add(mp.containsKey(query) ? "Yes" : "No");
        }

        return result;
    }
  
}

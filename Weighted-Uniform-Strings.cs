using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<string> weightedUniformStrings(string s, List<int> queries)
    {
        List<string> result = new List<string>();
        HashSet<int> weights = new HashSet<int>();

        int check = 1;

        for (int i = 0; i < s.Length; ++i)
        {
            check = 1;
            while (i + 1 < s.Length && s[i + 1] == s[i])
            {
                check++;
                i++;
            }

            for (int j = 1; j <= check; ++j)
            {
                weights.Add((s[i] - 'a' + 1) * j);
            }
        }

        foreach (int query in queries)
        {
            result.Add(weights.Contains(query) ? "Yes" : "No");
        }

        return result;
    }    

    public static List<string> weightedUniformStrings(string s, List<int> queries)
    {
        List<string> result = new List<string>();
        HashSet<int> weights = new HashSet<int>();
        
        int check = 1;
        
        for (int i = 0; i < s.Length; ++i)            
        {
            check = 1;
            while (i + 1 < s.Length && s[i + 1] == s[i])    
            {
                check++;
                i++;
            }
            
            for (int j = 1; j <= check; ++j)
            {
                weights.Add((s[i] - 'a' + 1) * j);
            }
        }
        
        foreach (int query in queries)
        {
            result.Add(weights.Contains(query) ? "Yes" : "No");
        }
        
        return result;
    }
}

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'weightedUniformStrings' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER_ARRAY queries
 */
 
vector<string> weightedUniformStrings(string s, vector<int> queries)
{
    vector<string> result;
    unordered_set<int> weights;
    
    int check = 1;
    
    for (int i = 0; i < s.size(); ++i)
    {
        check = 1;
        while (i + 1 < s.size() && s[i + 1] == s[i])
        {
            check++;
            i++;
        }
        
        for (int j = 1; j <= check; ++j)
        {
            weights.insert((s[i] - 'a' + 1) * j);
        }
    }
    
    for (int query : queries)
    {
        result.emplace_back(weights.count(query) ? "Yes" : "No");
    }
    
    return result;
}


vector<string> weightedUniformStrings2(string s, vector<int> queries)
{
    vector<string> result;
    map<int, bool> mp;
    
    int check = 1;
    
    for (int i = 0; i < s.size(); ++i)
    {
        check = 1;
        
        while (i + 1 < s.size() && s[i + 1] == s[i])
        {
            check++;
            i++;
        }
        
        for (int j = 1; j <= check; ++j)
        {
            mp[(s[i] - 'a' + 1) * j] = true;
        }
    }
    
    for (int query : queries)
    {
        result.emplace_back(mp.find(query) != mp.end() ? "Yes" : "No");
    }
    
    return result;
}


int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string queries_count_temp;
    getline(cin, queries_count_temp);

    int queries_count = stoi(ltrim(rtrim(queries_count_temp)));

    vector<int> queries(queries_count);

    for (int i = 0; i < queries_count; i++) {
        string queries_item_temp;
        getline(cin, queries_item_temp);

        int queries_item = stoi(ltrim(rtrim(queries_item_temp)));

        queries[i] = queries_item;
    }

    vector<string> result = weightedUniformStrings(s, queries);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str)
{
    string s(str);
    s.erase(
        s.begin(), find_if(s.begin(), s.end(), [](unsigned char ch) { return !isspace(ch); })
    );
    return s;
}

string rtrim(const string &str)
{
    string s(str);
    s.erase(
        find_if(s.rbegin(), s.rend(), [](unsigned char ch) { return !isspace(ch); }).base(), s.end()
    );
    return s;
}

std::vector<string> split(const string &str) {
    vector<string> tokens;
    string_view str_view(str);

    size_t start = 0;
    size_t end = 0;

    while ((end = str_view.find(' ', start)) != string_view::npos) {
        if (end > start) {
            tokens.emplace_back(str_view.substr(start, end - start));
        }
        start = end + 1;
    }

    if (start < str_view.size()) {
        tokens.emplace_back(str_view.substr(start));
    }

    return tokens;
}

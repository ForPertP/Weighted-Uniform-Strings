vector<string> weightedUniformStrings(string s, vector<int> queries)
{
    vector<string> result;
    std::map<int, bool> mp;
    int check = 1;
    
    for (int i = 0; i < s.size(); ++i)
    {
        if (i+1 != s.size() && s[i+1] == s[i])
        {
            check++;
        }
        else
        {
            check = 1;
        }
            
        mp[(s[i]-96) * check] = true;
    }
    
    for (int i = 0; i < queries.size(); ++i)
    {
        if (mp[queries[i]] == true)
        {
            result.emplace_back("Yes");
        }
        else
        {
            result.emplace_back("No");
        }
    }
    
    return result;
}

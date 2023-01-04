//Sliding window O(N) solution
class Solution {
    public int numberOfSubstrings(String s) {
        int[] track = new int[3]; //also we can use 3 variables for counting (a, b, c)
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;

            while (track[0] > 0 && track[1] > 0 && track[2] > 0) {
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}

//Simple Java Solution
class Solution {
    public int numberOfSubstrings(String s)
    {
        int[] letters = new int[3];
        int ans =0;
        int start =0;
        
        for(int i=0; i<s.length();i++)
        {
            letters[s.charAt(i) - 'a']++;
            
            while(letters[1] > 0 && letters[2] > 0 && letters[0] > 0)
            {
                ans = ans + s.length()-i;
                letters[s.charAt(start++) - 'a']--;
            }
        }
        return ans;
    }
}


//just maintain three pointers to hold most recent indices of a,b and c . 
//then the number of substrings at any index 
//lets say with char c is the most closest index to left from where a and b are found +1 for the new substring .
class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        
        //char[] str = s.toCharArray();
  
        // Stores recent index of the characters 
        int a_index = -1; 
        int b_index = -1; 
        int c_index = -1; 
        int n = s.length();
        for (int i = 0; i < n; i++)  
        { 
  
            // If character is a update a's index 
            // and the variable ans 
            if (s.charAt(i) == 'a')  
            { 
                a_index = i;
                if(b_index!=-1 && c_index!=-1){
                    
                    ans = ans + Math.min(b_index,c_index) +1;
                }
                
            }  
            // If character is b update b's index 
            // and the variable ans 
            else if (s.charAt(i) == 'b') 
            { 
                b_index = i;
                if(a_index!=-1 && c_index!=-1){
                    ans = ans + Math.min(a_index,c_index) +1;
                }
                
            }  
            // If character is c update c's index 
            // and the variable ans 
            else 
            { 
                c_index = i;
                if(b_index!=-1 && a_index!=-1){
                    ans = ans + Math.min(a_index,b_index) +1;    
                }
                
            } 
        } 
        return(ans);
    }
}

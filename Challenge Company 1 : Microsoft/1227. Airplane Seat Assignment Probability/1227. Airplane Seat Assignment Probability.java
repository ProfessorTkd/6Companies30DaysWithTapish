/*  
The idea for dp solution is that:
When n=1, answer will be 1.
When n=2, answer will be 0.5.
For other n, answer will be equal to (1/n) + ((n-2)/n)(answer of previous n). 
For eg for n=3, answer will be
(1/3) + (1/3)(0.5) = 0.5.
 */ 
 
 //dp solution
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
            return 1;
        double[] str = new double[n];
        str[0] = 1.0;
        str[1] = 0.5;
        for(int i=2;i<str.length;i++){
            double d = (1/(1.0*n)) + ((n-2)/(1.0*n))*(str[i-1]);
            str[i] = d;
        }
        return str[n-1];
    }
}

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
        return 1.00000;
        return 0.50000;
    }
}

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
            return 1;
        
        return 0.5d;
        
    }
}

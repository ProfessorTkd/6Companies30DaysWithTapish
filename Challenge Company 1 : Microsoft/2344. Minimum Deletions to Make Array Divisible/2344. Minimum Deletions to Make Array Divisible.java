/*
Explanation:
"divides all the elements of numsDivide"
equals to
"divides gcd of all the elements of numsDivide"
where gcd is the greatest common divisor.

So the first step, find out the gcd of numsDivide,
then sort input nums A,
and find out the smallest element A[i] in A divides gcd.

We need to remove all elements smaller than A[i].
If no such A[i], return -1 

Complexity:
Time O(nlogn + m + gcd), where gcd = log(max(numsDivide)
Space O(1)
*/



class Solution {
    public int minOperations(int[] A, int[] numsDivide) {
        int g = numsDivide[0], tmp;
        for (int a : numsDivide) {
            while (a > 0) { // g = gcd(g, a)
                tmp = g % a;
                g = a;
                a = tmp;
            }
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] <= g; ++i)
            if (g % A[i] == 0)
                return i;
        return -1;
    }
    }
    


class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = findGCD(numsDivide);
        Arrays.sort(nums);
        // smallest to largest
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0)
                return i;
        }
        return -1;
    }

    private int findGCD(int[] numsDivide){
        int gcd = numsDivide[0];

        for (int i=1;i<numsDivide.length;i++){
            int num = numsDivide[i];
            while (num > 0) {
                int tmp = gcd % num;
                gcd = num;
                num = tmp;
            }
        }
        return gcd;
    }
}

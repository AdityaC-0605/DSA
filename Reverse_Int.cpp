class Solution {
    public:
        int reverse(int x) {
           long long int x1=abs(x);
        long long int ans=0;
        while(x1>0){
            long long int temp=x1%10;
            ans=ans*10+temp;
            x1/=10;
        }
        if(ans>-pow(2,31) && ans<pow(2,31)-1){if(x<0){return (-1)*ans;}else{return ans;}}
        return 0; 
        }
    };
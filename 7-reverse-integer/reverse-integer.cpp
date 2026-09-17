class Solution {
public:
    int reverse(int x) {
        int reverse = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
// if tens place is alr bigger than tens place of int max then its overflow. if reverse number is = intmax/10 then the last digit that can be added cannot be more than 7. same logic for intmin.
            if(INT_MAX/10 < reverse || INT_MAX/10 == reverse && pop > 7) return 0;
            if(INT_MIN /10 > reverse || INT_MIN/ 10 == reverse && pop < -8) return 0;
            reverse *= 10;
            reverse += pop;
        }
        return reverse;
    }
};
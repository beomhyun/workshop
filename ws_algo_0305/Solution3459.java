import java.util.Scanner;
 
public class Solution3459 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            long a = sc.nextLong();
            String n = "1001";
            if(a == 1)System.out.println("#"+test_case+" Bob");
            else {
                while(Long.valueOf(n, 2) < a) {
                    n = "10"+n;
                }
                String aa = n.substring(0, 1) + n.substring(2, n.length());
                if(Long.valueOf(aa, 2) < a) {
                    System.out.println("#"+test_case+" Bob");
                }
                else System.out.println("#"+test_case+" Alice");
            }
        }
        sc.close();
    }
 
}
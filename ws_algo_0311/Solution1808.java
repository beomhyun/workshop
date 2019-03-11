import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1808 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test = 1; test <= T; test++) {
			boolean[] canusenum = new boolean[10];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 10; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					canusenum[i] =true;
				}
			}
			StringBuilder num = new StringBuilder(br.readLine());
			ArrayList<Integer> res = new ArrayList<>();
			while(num.length()>=0) {
				boolean check =false;
				for (int i = 0; i < num.length(); i++) {
					if(!canusenum[num.toString().charAt(i)-'0']) {
						check = true;
					}
				}
				if(!check) {
					System.out.println("#"+test+" "+(num.length()+1));
					break;
				}
					else {
						for (int j = 0; j < canusenum.length; j++) {
						if(canusenum[j]&& j!=0) {
							if(num.length()==0) {
								System.out.println("#"+test+" -1");
								break;
							}
							if(num.length()>=1 && Integer.parseInt(num.toString())%j==0) {
								StringBuilder tmp = new StringBuilder(Integer.parseInt(num.toString())/j);
								boolean c = false;
								for (int i = 0; i < num.length(); i++) {
									if(tmp.length()>0 && !canusenum[tmp.toString().charAt(i)-'0']) {
										c = true;
									}
								}
								if(!c) {
									num=tmp;
								}
							}
						}
					}
				}
			}
			
		}
	}
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Myzzu {

	static Queue<Integer> que1 = new LinkedList<>();
	static Queue<Integer> que2 = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startcandy =20;
		int nowcandy = startcandy;
		int[] People = new int[100];
		int index =1;
		int result = 0;
		while(nowcandy>0) {
			sc.nextLine();
			//큐 2개를 한세트로 !
			que1.add(++(People[index]));
			que2.add(index);
			System.out.println("큐에 있는사람 : "+index);
			
			nowcandy -= que1.poll();
			result = que2.poll();
			System.out.println(result +"가 " +People[result]+"개 가져갔습니다." );
			System.out.println(startcandy-nowcandy+"개 나눠줬습니다.");

			que2.add(result);
			que1.add(++(People[result]));
			index++;
		}
		System.out.println("마지막 마이쮸 가져간 사람 : " + result);
	}
	
}
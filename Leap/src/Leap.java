import java.util.Scanner;

/*閏年は4で割り切れる
 *ただし100で割り切れる場合は閏年ではない
 *ただし400で割り切れる場合は閏年である
 */

public class Leap {
	public static void main(String[] args) {
	System.out.println("入力された年が閏年がどうか調べます");
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	int year = Integer.parseInt(scanner.nextLine());

		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
		//4で割り切れ、なおかつ(&&)100で割り切れないが(||)400で割り切れる閏年
		System.out.println(year + "年は閏年です");
		} else {
		System.out.println(year + "年は閏年ではありません");
		}
	}
}
import java.util.Scanner;

public class CofeeShop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//		String[][] menus = {
//				{"아메리카노", "2800"}, {"바닐라라떼", "3400"}, {"에스프레소", "2300"},
//				{"오렌지주스", "2400"}, {"쿨라임피지오","3800"}}; 
//		};
		String[] menus = {"종료", "아메리카노", "바닐라라떼", "에스프레소", "오렌지주스", "쿨라임피지오"}; 
		int[] menu_price = {0, 2800, 3400, 2300, 2400, 3800};
		
		System.out.println("Dohee Cafe에 오신 것을 환영합니다 :) \n 현재 가진 돈을 입력하세요:");
		int my_money = sc.nextInt();
		int[] select_menu = new int[100000];
		int cnt = 0;
		
		while (my_money > 0) {
			System.out.println("----- Dohee Cafe Menu -----");
			for(int i=0; i<menus.length; i++) {
//				System.out.printf(i + ". " + menus[i] + ":"+Integer.toString(menu_price[i])+"\n");
				System.out.printf(i + ". " + menus[i] + ":"+menu_price[i]+"\n");
			}
			System.out.println("-----\n메뉴를 선택하세요.(번호로 입력)\n-----");
			int temp = sc.nextInt();
			if (temp == 0) {
				break;
			} else if (my_money-menu_price[temp] >= 0) {
				if (temp != 0) {
					select_menu[cnt] = temp;
					my_money -= menu_price[temp];
					cnt += 1;
					System.out.println(menus[temp]+"(을)를 주문하셨습니다.");
					System.out.println("남은 잔액은 "+my_money+"원입니다.");
				}
			} else {
				System.out.println("잔액이 부족합니다. 잔액을 투입하시거나 다른 메뉴를 선택해주세요.");
				boolean flag = true;
				while (flag) {
				System.out.println("0. 잔액 투입\n1. 다른 메뉴 선택");
				int additional_select = sc.nextInt();
					switch (additional_select) {
					case 0:
						System.out.println("추가로 투입할 잔액의 액수를 입력하세요.: ");
						int additional_money = sc.nextInt();
						my_money += additional_money;
						System.out.println("현재 잔액은 "+my_money+"원입니다.");
						flag = false;
						break;
					case 1:
						System.out.println("다른 메뉴를 선택하시겠어요?");
						flag = false;
						break;
					default:
						System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요.");
						break;
					}
				}
			}			
		}
		if (my_money == 0) {
			System.out.println("잔액을 모두 소진하셨습니다.");
		}
		System.out.println("주문을 종료합니다.\n주문한 음료는 다음과 같습니다.");
		System.out.println("----------");
		int sum_price = 0;
		for (int i=0; i<cnt; i++) {
			System.out.println(menus[select_menu[i]]+"("+menu_price[select_menu[i]]+"원)");
			sum_price += menu_price[select_menu[i]];
		}
		System.out.println("----------");
		System.out.println("총 주문 금액: "+sum_price);
		System.out.println("거스름돈: "+my_money);
		System.out.println("----------");
	}
}

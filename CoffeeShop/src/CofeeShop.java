import java.util.Scanner;

public class CofeeShop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//		String[][] menus = {
//				{"�Ƹ޸�ī��", "2800"}, {"�ٴҶ��", "3400"}, {"����������", "2300"},
//				{"�������ֽ�", "2400"}, {"�����������","3800"}}; 
//		};
		String[] menus = {"����", "�Ƹ޸�ī��", "�ٴҶ��", "����������", "�������ֽ�", "�����������"}; 
		int[] menu_price = {0, 2800, 3400, 2300, 2400, 3800};
		
		System.out.println("Dohee Cafe�� ���� ���� ȯ���մϴ� :) \n ���� ���� ���� �Է��ϼ���:");
		int my_money = sc.nextInt();
		int[] select_menu = new int[100000];
		int cnt = 0;
		
		while (my_money > 0) {
			System.out.println("----- Dohee Cafe Menu -----");
			for(int i=0; i<menus.length; i++) {
//				System.out.printf(i + ". " + menus[i] + ":"+Integer.toString(menu_price[i])+"\n");
				System.out.printf(i + ". " + menus[i] + ":"+menu_price[i]+"\n");
			}
			System.out.println("-----\n�޴��� �����ϼ���.(��ȣ�� �Է�)\n-----");
			int temp = sc.nextInt();
			if (temp == 0) {
				break;
			} else if (my_money-menu_price[temp] >= 0) {
				if (temp != 0) {
					select_menu[cnt] = temp;
					my_money -= menu_price[temp];
					cnt += 1;
					System.out.println(menus[temp]+"(��)�� �ֹ��ϼ̽��ϴ�.");
					System.out.println("���� �ܾ��� "+my_money+"���Դϴ�.");
				}
			} else {
				System.out.println("�ܾ��� �����մϴ�. �ܾ��� �����Ͻðų� �ٸ� �޴��� �������ּ���.");
				boolean flag = true;
				while (flag) {
				System.out.println("0. �ܾ� ����\n1. �ٸ� �޴� ����");
				int additional_select = sc.nextInt();
					switch (additional_select) {
					case 0:
						System.out.println("�߰��� ������ �ܾ��� �׼��� �Է��ϼ���.: ");
						int additional_money = sc.nextInt();
						my_money += additional_money;
						System.out.println("���� �ܾ��� "+my_money+"���Դϴ�.");
						flag = false;
						break;
					case 1:
						System.out.println("�ٸ� �޴��� �����Ͻðھ��?");
						flag = false;
						break;
					default:
						System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �������ּ���.");
						break;
					}
				}
			}			
		}
		if (my_money == 0) {
			System.out.println("�ܾ��� ��� �����ϼ̽��ϴ�.");
		}
		System.out.println("�ֹ��� �����մϴ�.\n�ֹ��� ����� ������ �����ϴ�.");
		System.out.println("----------");
		int sum_price = 0;
		for (int i=0; i<cnt; i++) {
			System.out.println(menus[select_menu[i]]+"("+menu_price[select_menu[i]]+"��)");
			sum_price += menu_price[select_menu[i]];
		}
		System.out.println("----------");
		System.out.println("�� �ֹ� �ݾ�: "+sum_price);
		System.out.println("�Ž�����: "+my_money);
		System.out.println("----------");
	}
}

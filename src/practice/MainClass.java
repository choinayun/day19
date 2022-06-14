package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		DBClass db = new DBClass();
		Scanner input = new Scanner(System.in);
		
		int num, birth, result = 0;
		String name, hobby;
		
		Info info = new Info();
		
		while(true) {
			
			System.out.println("1. ���");
			System.out.println("2. ��ȸ");
			System.out.println("3. ��� ��� ��ȸ");
			System.out.println("4. ����");
			num = input.nextInt();
			
			switch(num) {
				case 1 : 
					System.out.println("�̸� �Է�");
					name = input.next();
					System.out.println("���� �Է�");
					birth = input.nextInt();
					System.out.println("��� �Է�");
					hobby = input.next();
					
					info.setName(name);
					info.setBirth(birth);
					info.setHobby(hobby);
					
					result = db.insert(info);
					
					if(result == 1) {
						System.out.println("��� ����");
					}else {
						System.out.println("��� ����");
					}
					break;
					
				case 2 : 
					System.out.println("�˻��� �̸� �Է�");
					name = input.next();
					
					info = db.selectOne(name);
					
					if(info == null) {
						System.out.println("������ �����ϴ�.");
					}else {
						System.out.println("�̸� : " + info.getName());
						System.out.println("���� : " + info.getBirth());
						System.out.println("��� : " + info.getHobby());
					}
					
					break;
				
				case 3 :
					
				
					
					break;
				
				case 4 : 
					System.exit(0);
					break;
			
			}
		}
	}
}

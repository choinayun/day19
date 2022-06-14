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
			
			System.out.println("1. 등록");
			System.out.println("2. 조회");
			System.out.println("3. 모든 목록 조회");
			System.out.println("4. 종료");
			num = input.nextInt();
			
			switch(num) {
				case 1 : 
					System.out.println("이름 입력");
					name = input.next();
					System.out.println("생일 입력");
					birth = input.nextInt();
					System.out.println("취미 입력");
					hobby = input.next();
					
					info.setName(name);
					info.setBirth(birth);
					info.setHobby(hobby);
					
					result = db.insert(info);
					
					if(result == 1) {
						System.out.println("등록 성공");
					}else {
						System.out.println("등록 실패");
					}
					break;
					
				case 2 : 
					System.out.println("검색할 이름 입력");
					name = input.next();
					
					info = db.selectOne(name);
					
					if(info == null) {
						System.out.println("정보가 없습니다.");
					}else {
						System.out.println("이름 : " + info.getName());
						System.out.println("생일 : " + info.getBirth());
						System.out.println("취미 : " + info.getHobby());
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

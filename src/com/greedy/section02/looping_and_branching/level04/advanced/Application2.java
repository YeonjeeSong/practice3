package com.greedy.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application2 {

	public static void main(String[] args) {
		
		/* 받은 금액을 입력 받고, 상품 가격을 입력 받아 거스름돈을 계산하는 프로그램을 작성하세요
		 * 
		 * 단, 거스름돈은 대한민국 화폐 단위 별 필요 수량이 출력되도록 작성하고,
		 * 지폐외 동전을 구분하여 단위를 표기하세요
		 * 
		 * -- 입력 예시 --
		 * 받으신 금액을 입력하세요 : 100000
		 * 상품 가격을 입력하세요 : 22340
		 * 
		 * -- 출력 예시 --
		 * ============================
		 * 50000원권 지폐 1장
		 * 10000원권 지폐 2장
		 * 5000원권 지폐 1장
		 * 1000원권 지폐 2장
		 * 500원권 동전 1개
		 * 100원권 동전 1개
		 * 50원권 동전 1개
		 * 10원권 동전 1개
		 * ============================
		 * 거스름돈 : 77660원
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("받으신 금액을 입력하세요 : ");
		int sum = sc.nextInt();
		
		System.out.print("상품 가격을 입력하세요 : ");
		int price = sc.nextInt();
		
		System.out.println("=========================");
		
		/* recipe - mod 사용 */
		int change = sum - price;	// 거스름돈
		int currency = 50000;		// 50000원으로 초기화 -> 위에서부터 나눠 가면서 잔돈 갯수를 맞춘다.
		int mok = 0;				// 몫
		int nmg = 0;				// 나머지
		int sw = 0;					// switch 사용. /5와 /2 번갈아 해주며 동전 세기
		int temp = change;
		
		while(true) {
			mok = temp / currency;
			nmg = temp % currency;
			
			if(mok == 0 && nmg == 0) {	// 몫이랑 나머지가 0이면 거스름돈 0원
				break;
			}
			
			if(mok != 0) {
				if(currency > 500) {	// 지폐와 동전 분리
					System.out.println(currency + "원권 지폐 " + mok + "장");
				} else {
					System.out.println(currency + "원권 동전 " + mok + "개");
				}
			}
			
			/* 동전 세기
			 * 500, 100, 50, 10원 이므로 5와 2로 나눈다.
			 * 스위치가 켜져 있으면 5로 나누고, 꺼져 있으면 2로 나눈다. */
			if(sw == 0) {
				sw = 1;
				currency /= 5;
			} else {
				sw = 0;
				currency /= 2;
			}
			
			temp = nmg;
		}
		
		System.out.println("=========================");
		System.out.println("거스름돈 : " + change + "원");
	}

}

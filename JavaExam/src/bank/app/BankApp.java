package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private static Scanner sc = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	public static void main(String[] args) {
		
		boolean run = true;
		while (run) {
			System.out.println("----------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("----------------------------");
			System.out.print("선택 >");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			if (selectNo ==1) {
				createAccount();
			} else if(selectNo ==2){
				accountList();
			} else if(selectNo ==3){
				deposit();
			} else if(selectNo ==4){
				withdraw();
			} else if(selectNo ==5){
				run = false;
			}
	
		}
		
		System.out.println("프로그램 종료");
		
	} // end of main
	private static void createAccount() {
		
		System.out.println("--------계좌생성--------");
		System.out.print("계좌번호 : ");
		String ano = sc.nextLine();
		System.out.print("계좌주 : ");
		String owner = sc.nextLine();
		System.out.print("초기 입금액 : ");
		String balance = sc.nextLine();
		System.out.println("계좌가 생성되었습니다.");
		int balance1 = Integer.parseInt(balance);
		accounts.add(new Account(ano, owner, balance1));
	}
	private static void accountList() {
		System.out.println("--------계좌목록--------");
		for(Account a : accounts) {
			System.out.println(a.getAno() +" "+ a.getOwner() +" "+ a.getBalance());
		}
	}
	private static void deposit() {
		System.out.println("--------예금--------");
		System.out.print("계좌번호 : ");
		String ano = sc.nextLine();
		System.out.print("예금액 : ");
		String money = sc.nextLine();
		int money1 = Integer.parseInt(money);
		Account a = findAccount(ano);
		
		money1 += a.getBalance();
		a.setBalance(money1);
		System.out.println("결과 : 예금이 성공되었습니다.");
	}
	private static void withdraw() {
		System.out.println("--------출금--------");
		System.out.print("계좌번호 : ");
		String ano = sc.nextLine();
		System.out.print("출금액 : ");
		String money = sc.nextLine();
		int money1 = Integer.parseInt(money);
		
		Account b = findAccount(ano);
		
		money1 = b.getBalance()-money1;
		b.setBalance(money1);
		System.out.println("결과 : 출금이 성공되었습니다.");
	}
	private static Account findAccount(String ano) {
		try {
		for(Account a : accounts) {
			if(a.getAno().equals(ano)) {
		return a;
		} 
	} }catch (NullPointerException e){
		System.out.println("계좌가 없습니다.");
	}
		return null;
	}
}

package concurrency.deadlock;

import java.util.Random;

class Account {
	private int balance = 10000;

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account fromAcc, Account toAcc, int amount) {
		fromAcc.withdraw(amount);
		toAcc.deposit(amount);
	}
}

class Runner {
	private Account account1 = new Account();
	private Account account2 = new Account();

	public void firstThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			Account.transfer(account1, account2, random.nextInt(100));
		}
	}

	public void secondThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			Account.transfer(account2, account1, random.nextInt(100));
		}
	}

	public void finished() {
		System.out.println("Account1 balance: " + account1.getBalance());
		System.out.println("Account2 balance: " + account2.getBalance());
		System.out.println("Total balance: " + (account2.getBalance() + account1.getBalance()));
	}
}

public class App {
	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();
		Thread t1 = new Thread(() -> {
			try {
				runner.firstThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				runner.secondThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		runner.finished();
	}
}

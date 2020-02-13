package concurrency.deadlock.caveofprogramming;

class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public static void transfer(Account to, Account from, int amount) {
		from.withdraw(amount);
		to.deposit(amount);
	}
}

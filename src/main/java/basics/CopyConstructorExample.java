package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyConstructorExample {
	String name;
	List<Integer> listNumbers;

	public CopyConstructorExample() {
		listNumbers = new ArrayList<>();
	}

	public CopyConstructorExample(CopyConstructorExample copyConstructorExample) {
		this.listNumbers = copyConstructorExample.listNumbers;
		this.name = copyConstructorExample.name;
	}

	public static void main(String[] args) {
		CopyConstructorExample copyConstructorExample = new CopyConstructorExample();
		copyConstructorExample.name = "Hare Krsna";
		copyConstructorExample.listNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

		CopyConstructorExample copyConstructorExample2 = new CopyConstructorExample(copyConstructorExample);
		System.out.println("Before modification");
		System.out.println("copyConstrutor1 with name " + copyConstructorExample.name);
		display(copyConstructorExample.listNumbers);
		System.out.println("\ncopyConstrutor2 with name " + copyConstructorExample2.name);
		display(copyConstructorExample2.listNumbers);
		System.out.println("\n");
		copyConstructorExample.listNumbers.remove(0);
		copyConstructorExample.name = "renamed";

		System.out.println("After modification");
		System.out.println("copyConstrutor1 with name " + copyConstructorExample.name);
		display(copyConstructorExample.listNumbers);
		System.out.println("\ncopyConstrutor2 with name " + copyConstructorExample2.name);
		display(copyConstructorExample2.listNumbers);
	}

	static void display(List<Integer> listNumbers) {
		for (int x : listNumbers) {
			System.out.print(x + ", ");
		}
	}
}

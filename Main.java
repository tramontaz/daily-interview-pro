import entity.LinList;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("enter a first number digit by digit");
		int x = sc.nextInt();	
		
		System.out.println("enter a second number digit by digit");
		int y = sc.nextInt();	

		var first = numToLinList(x);
		var second = numToLinList(y);

		var result = addTwoNumbers(first, second);

		System.out.printf("First: %s. Second: %s%nResult: %s%n", first.toString(), second.toString(), result.toString());

	}

	private static LinList<Integer> numToLinList(int num) {
		int n = num % 10;
		num = num / 10;


		LinList<Integer> head = new LinList<>(n);
		LinList<Integer> result = head;

		while(num > 0) {
			n = num % 10;
			num = num / 10;
			result.setNext(new LinList<Integer>(n));
			result = result.getNext();
		}
		return head;

	}

	private static LinList<Integer> addTwoNumbers(LinList<Integer> first, LinList<Integer> second) {
		int buffer = 0;
		
		var head = new LinList<Integer>();
		var result = head;

		while(first != null && second != null) {
			//add two digits
			buffer += first.getValue() + second.getValue();
			result.setValue(buffer % 10);
			buffer = buffer / 10;
			
			//jump on the next nodes
			first = first.getNext();
			second = second.getNext();
			
			if(first!=null || second != null) {
				result.setNext(new LinList<Integer>());
				result = result.getNext();
			}
			
		}

		// check if first number was longer than second
		while(first != null) {
			buffer = buffer + first.getValue();
			result.setValue(buffer % 10);
			buffer = buffer / 10;
		
			//jump on the next nodes
			first = first.getNext();
			
			if(first!=null) {
				result.setNext(new LinList<Integer>());
				result = result.getNext();
			}
		}

		// check if second number was longer than first
		while(second != null) {
			buffer = buffer + second.getValue();
			result.setValue(buffer % 10);
			buffer = buffer / 10;
			
			//jump on the next nodes
			second = second.getNext();
			
			if(second != null) {
				result.setNext(new LinList<Integer>());
				result = result.getNext();
			}
		
		}

		// if buffer is not empty add it
		if(buffer > 0) {
			result.setNext(new LinList<Integer>(buffer));
		}

		return head;
	}
}

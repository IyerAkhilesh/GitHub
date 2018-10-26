import java.util.Scanner;
public class Modulo{
	public static void main(String[] args) {
		System.out.println("Enter the dividend: ");
		Scanner scanner = new Scanner(System.in);
		int dividend = scanner.nextInt();
		System.out.println("Enter the modulus: ");
		int modulus = scanner.nextInt();

		System.out.println("The remainder of "+dividend+"/"+modulus+" is: "+(dividend%modulus));
	}
}
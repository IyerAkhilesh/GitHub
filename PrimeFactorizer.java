import java.util.Scanner;
import java.math.BigInteger;
public class PrimeFactorizer {
    public static void main(String[] args) {
        System.out.print("Enter a positive number: ");
        Scanner scanner = new Scanner (System.in);
        BigInteger number = new BigInteger("987654321064644897123456789");
        BigInteger staticNumber = number;
        System.out.println("Number: "+number);
        BigInteger incrementar = new BigInteger("1");
        BigInteger bigZero = new BigInteger("0");
        BigInteger count = new BigInteger("0");
        BigInteger i = new BigInteger("2");
        // System.out.println(System.nanoTime()+"");
        long startTime = System.nanoTime();
        for (; staticNumber.compareTo(i) > 0; i = i.add(incrementar)) {
            count= new BigInteger("0");
            while (number.mod(i).compareTo(bigZero) == 0) {
                number =  number.divide(i);
                count = count.add(incrementar);
            }
            if (count.compareTo(bigZero) == 0) 
                continue;
            // System.out.println("Number "+number);
            // System.out.println("i: "+i);  
            System.out.println("Time taken: "+(System.nanoTime() - startTime)/100);
            System.out.println(i+"\nComparison of number and i: "+number.compareTo(i));
        }
    }
}
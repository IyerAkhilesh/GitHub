import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class SchnorrImplementation_Sender{
	ServerSocket serverSocket;
	Socket socket, socket1;
	BufferedReader reader;
	PrintStream writer;
	int g = 17, na;
	final static int sa = 11;
	public SchnorrImplementation_Sender(){
		try{
			serverSocket = new ServerSocket(6763);
			System.out.println("Alice started");
			socket = serverSocket.accept();
			System.out.println("Connected to Bob via TCP");
			socket1 = new Socket("localhost", 6764);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());
		}catch(Exception e){e.printStackTrace();}
	}

	private void send(){
		try{
			Scanner systemInput = new Scanner(System.in);
			System.out.println("Enter the random prime number Na:");
			na = systemInput.nextInt();
			double a = Math.pow(g, na);
			
			writer.flush();
			writer.println(a);

			int nb = receive();
			double r = na + nb*sa;
			System.out.println("\n"+r+" will be sent");

			writer.flush();
			writer.println(r);
		}catch (Exception e) {e.printStackTrace();}
	}

	private int receive() throws Exception{
		return Integer.parseInt(reader.readLine());
	}
	public static void main(String[] args) {
		SchnorrImplementation_Sender alice = new SchnorrImplementation_Sender();
		System.out.println("Welcome to Alice's Schnorr universe!");
		alice.send();
	}
}
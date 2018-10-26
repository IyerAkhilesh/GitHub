import java.net.ServerSocket;
import java.net.Socket;	
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SchnorrImplementation_Receiver{
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader reader;
	PrintStream writer;
	int nb;
	Scanner systemInput;
	public SchnorrImplementation_Receiver(){
		try{
			nb = 0;
			socket = new Socket("localhost", 6763);
			serverSocket = new ServerSocket(6764);
			System.out.println("Connected to Alice via TCP");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());
		}catch(Exception e){e.printStackTrace();}
	}

	String temp = "";
	double pa = Math.pow(17,11), g = 17.00 , r, a;

	void receive(){
		try{
			if(temp.length() == 0){
				a = Double.parseDouble(reader.readLine());
				temp = a+"";
				System.out.println("Received number : "+a);
			}
			else{
				r = Double.parseDouble(reader.readLine());
				temp = "finis!";
				System.out.println("\nReceived response: "+r);
			}
		}catch(Exception e){e.printStackTrace();}
	}

	boolean checkForTruth(){
		System.out.println("exp(g,r) = "+Math.pow(g,r)+"\nAnd a*exp(Pa, Nb) = "+a*Math.pow(pa,nb));
		if(Math.pow(g, r) == a*Math.pow(pa, nb))
			return true;
	return false;
	}
	
	void send(){
		try{
			System.out.println("Enter the random prime Nb: ");
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
			nb = Integer.parseInt(inputReader.readLine());

			writer.flush();
			writer.println(nb);
		}catch(Exception e){e.printStackTrace();}
	}
	public static void main(String[] args) {
		SchnorrImplementation_Receiver bob = new SchnorrImplementation_Receiver();
		System.out.println("Welcome to Bob's Schnorr Universe!");
		bob.receive();
		bob.send();
		bob.receive();
		if(bob.checkForTruth()){
			System.out.println("The signature is authentic and legitimate!");
		}
		else{
			System.out.println("The signature is NOT authentic and legitimate!");
		}
	}
}
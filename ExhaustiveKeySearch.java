import java.util.HashMap;
public class ExhaustiveKeySearch{

	void findPlainText(String cipherText){
		int decryptionKey = 0;
		HashMap<Integer, String> plainTextMessage = new HashMap<Integer, String>();
		for(int keyCounter = 1; keyCounter < 26; keyCounter++){
			String tempPlainText = "";
			for(int positionCounter = 0; positionCounter < cipherText.length(); positionCounter++){
				if(cipherText.charAt(positionCounter) + keyCounter > 90)
					tempPlainText += (char)(cipherText.charAt(positionCounter) + keyCounter - 26)+"";
				
				else
					tempPlainText += (char)(cipherText.charAt(positionCounter) + keyCounter )+"";
				// System.out.println(tempPlainText);
			}
			plainTextMessage.put(keyCounter, tempPlainText);
			tempPlainText = "";
		}

		for(int i = 1; i <= plainTextMessage.size(); i++)
			System.out.println(plainTextMessage.get(i)+"\t"+i+"\n");
	}

	public static void main(String[] args) {
		ExhaustiveKeySearch searchObject = new ExhaustiveKeySearch();
		System.out.println("All possible plaintext messages are: ");
		searchObject.findPlainText("FIREXV");
	}
}
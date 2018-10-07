import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean open = true;
		try {
			
			Socket sender = new Socket("localhost",8008);
			if(sender.isConnected()) {
				System.out.println("Connected");
			}
			Scanner userInput = new Scanner(System.in);
			BufferedReader message = new BufferedReader(new InputStreamReader(sender.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(sender.getOutputStream()));
			String str = userInput.nextLine();
			String close = ".";
			while(!str.equals(close)) {
				//String str = userInput.nextLine();
				out.println(str);
				//out.write(str);
				out.flush();
				
			}
			System.out.println(message.readLine());
			message.close();
			out.close();
			sender.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

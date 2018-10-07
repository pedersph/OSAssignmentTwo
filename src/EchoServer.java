import java.io.*;
import java.net.*;

public class EchoServer {

	public static void main(String[] args) {
		boolean open = true;
		try {
			ServerSocket listener = new ServerSocket(8008);
			
			
			while(open) {
				Socket incoming = listener.accept();
				BufferedReader userMessage = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				PrintWriter serverMessage = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));
				
				
				
				String message;
				while((message = userMessage.readLine()) != null){
					System.out.println(message);
					serverMessage.println(message);
				}
				userMessage.close();
				serverMessage.close();
				incoming.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		}
		

	}

}

import java.io.*;
import java.net.*;

public class EchoServer {

	public static void main(String[] args) {
		boolean open = true;
		try {
			ServerSocket socket = new ServerSocket(9000);
			
			while(open) {
				Socket request = socket.accept();
				
				BufferedReader message = new BufferedReader(new InputStreamReader(request.getInputStream()));
				PrintWriter echo = new PrintWriter(new OutputStreamWriter(request.getOutputStream()));
				while(open) {
					String mess = message.readLine();
					if(mess.length() <= 0) {
						break;		
					}else {
						System.out.println("Server: "+mess);
					}
				}
				request.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}

}

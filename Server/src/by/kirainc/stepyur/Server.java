package by.kirainc.stepyur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	static ServerSocket ss;
	static Socket soc;
	static BufferedReader in;
	static BufferedWriter out;
	
	
	public static void main(String[] args) {
		
		try {
			try {
				ss = new ServerSocket(0007, 50);
				
				System.out.println("Я родился!");
				soc = ss.accept();
				//здесь блокируется
				
				System.out.println("Я родился!");
				
				try {
					in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					out = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
					
					String s = "";
					while( s.equals("0") == false) {
						s = in.readLine();
						System.out.println("Вы ввели: " + s);
						out.write("Вы ввели: " + s + "\n");
						out.flush();
					}
				} finally {
					soc.close();
					
					in.close();
					out.close();
				}
			} finally {
				System.out.println("Сервер наелся и спит :3");
				ss.close();
			}
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
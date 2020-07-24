package by.kirainc.stepyur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	static BufferedReader reader;
	static Socket soc;
	static BufferedReader in;
	static BufferedWriter out;
	
	
	public static void main(String[] args) {
		
		try {
			try {
				String s = "";
				soc = new Socket("localhost", 0007);
				reader = new BufferedReader(new InputStreamReader(System.in));
				in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
				while (s.equals("0") == false) {
					System.out.println("Вы что-то хотели сказать? Скажите: ");
					s = reader.readLine();
					out.write(s + "\n");
					out.flush();
					String serverWord = in.readLine();
					System.out.println(serverWord);
				}
				
			} finally {
				System.out.println("Клиент наелся и спит :0");
				soc.close();
				in.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
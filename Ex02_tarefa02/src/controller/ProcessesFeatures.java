package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessesFeatures {
	
	public ProcessesFeatures(){
		super();
	}
	
	// Retorna apenas o primeiro char do OS
	public char char_os() {
		String os = System.getProperty("os.name");
		return (os.charAt(0));
	}
	
	// Método que mostrará os processos ativos
	public void show_processes(char os) {
		String command = "";
		
		// Se for Windows
		if (os == 'W') {
			command = "TASKLIST";
			try {
				Process p = Runtime.getRuntime().exec(command);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Se for Linux
		if (os == 'L') {
			command = "ps";
			try {
				Process p = Runtime.getRuntime().exec(command);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Método que receberá o SO e o PID e finalizará o processo de acordo com seu PID
	public void kill_pid(char os, int pid_number) {
		String command = "";
		
		// No Windows
		if (os == 'W') {
			command = "tskill " + pid_number;
		}
		// No linux
		if (os == 'L') {
			command = "kill " + pid_number;
		}
		
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("O processo de PID " + pid_number + " foi finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Método que receberá o SO e o nome do processo e o finalizará
	public void kill_name(char os, String process_name) {
		String command = "";
		
		// No Windows
		if (os == 'W') {
			command = "tskill " + process_name;
		}
		// Para Linux
		if (os == 'L') {
			command = "killall " + process_name;
		}
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("O processo de nome " + process_name + " foi finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

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
	}

}

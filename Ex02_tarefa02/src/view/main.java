package view;

import java.util.Scanner;

import controller.ProcessesFeatures;

public class main {

	public static void main(String[] args) {
		ProcessesFeatures proc_feat = new ProcessesFeatures();
		
		// Pega a primeira letra do SO (se L então linux, se W então windows)
		char os = proc_feat.char_os();
		
	    // Para receber as entradas
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		// Começa o laço com as opções para o usuário
		while (option != 99) {
			
			System.out.println(
					"Escolha abaixo a opção desejada: \n"
					+ "1 - Ver os processos ativos\n"
					+ "2 - Mate um processo de acordo com o PID que inserir \n"
					+ "3 - Mate um processo de acordo com o nome que inserir \n"
					+ "99 - Finaliza programa");
			
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				proc_feat.show_processes(os);;
				break;
			
			case 2:
				System.out.println("Fazendo...");
				break;
			
			case 3:
				System.out.println("Fazendo...");
				break;
			
			case 99:
				System.out.println("Fazendo...");
				break;
				
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
		
		scan.close();

		
	}

}

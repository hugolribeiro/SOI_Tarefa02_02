package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

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
				int pid_number = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o número do PID: "));
				proc_feat.kill_pid(os, pid_number);
				break;
			
			case 3:
				String process_name = JOptionPane.showInputDialog("Digite aqui o nome do processo: ");
				proc_feat.kill_name(os, process_name);
				break;
			
			case 99:
				System.out.println("Finalizando o programa...");
				break;
				
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
		
		scan.close();

		
	}

}

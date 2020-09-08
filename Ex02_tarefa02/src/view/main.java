package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.ProcessesFeatures;

public class main {

	public static void main(String[] args) {
		
		ProcessesFeatures proc_feat = new ProcessesFeatures();
		
		// Pega a primeira letra do SO (se L ent�o linux, se W ent�o windows)
		char os = proc_feat.char_os();
		
	    // Para receber as entradas
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		// Come�a o la�o com as op��es para o usu�rio
		while (option != 99) {
			
			System.out.println(
					"Escolha abaixo a op��o desejada: \n"
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
				int pid_number = Integer.parseInt(JOptionPane.showInputDialog("Digite aqui o n�mero do PID: "));
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
				System.out.println("Op��o Inv�lida");
				break;
			}
		}
		
		scan.close();

		
	}

}

package application;


import java.util.Scanner;

import entities.Report;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao, opcaoElevador, cont = 0;
		Report report = new Report();
		report.carregarJson();
		
		do {
			System.out.println("Menu: ");
			System.out.println("1 - Para ver o andar menos utilizado pelos usuarios;");
			System.out.println("2 - Para ver o elevador mais frequentado;");
			System.out.println("3 - Para ver o turno de maior fluxo e o elevador mais utilizado neste turno;");
			System.out.println("4 - Para ver o elevador menos frequentado;");
			System.out.println("5 - Para ver o turno de menor fluxo e o elevador menos utilizado neste turno;");
			System.out.println("6 - Para ver o turno mais frequentado e seu conjunto de utilizacao dos elevadores;");
			System.out.println("7 - Para ver o percentual de uso dos elevadores;");
			System.out.println("0 - Para sair.");
			System.out.println();
			System.out.print("Escolha a opcao desejada: ");
			opcao = sc.nextInt();
			do {
				if (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4 || opcao == 5 || opcao == 6 || opcao == 7||opcao == 0) {
						cont++;
				} else {
					System.out.println("Opcao invalida, digite novamente: ");
					opcao = sc.nextInt();
				}
					
			} while (cont == 0);
			
			
			switch (opcao) {
			case 1:
				System.out.println();
				System.out.println("Andar menos utilizado pelos usuarios: " + report.andarMenosUtilizado());
				System.out.println();
				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				System.out.println();
				break;
			case 2: 
				System.out.println();
				System.out.println("Elevador mais frequentado: " + report.elevadorMaisFrequentado());
				System.out.println();
				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				break;
			case 3:
				System.out.println();
				System.out.println("Turno de maior fluxo e o elevador mais utilizado neste turno: " + report.periodoMaiorFluxoElevadorMaisFrequentado());
				System.out.println();

				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				break;
			case 4:
				System.out.println();
				System.out.println("Elevador menos frequentado: " + report.elevadorMenosFrequentado());;
				System.out.println();
				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				break;
			case 5:
				System.out.println();
				System.out.println("Turno de menor fluxo e o elevador menos utilizado neste turno: " + report.periodoMenorFluxoElevadorMenosFrequentado());
				System.out.println();
				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				break;
			case 6: 
				System.out.println();
				System.out.println("Turno mais frequentado e seu conjunto de utilizacao dos elevadores durante o turno: " + report.periodoMaiorUtilizacaoConjuntoElevadores());
				System.out.println();
				sc.nextLine();
				System.out.println("Aperte enter para retornar para o menu."); 
				sc.nextLine();
				break;
			case 7:
				System.out.println();
				System.out.println("Escolha o elevador desejado: ");
				System.out.println("1 - Para elevador A;");
				System.out.println("2 - Para elevador B;");
				System.out.println("3 - Para elevador C;");
				System.out.println("4 - Para elevador D;");
				System.out.println("5 - Para elevador E;");
				opcaoElevador = sc.nextInt();
				if (opcaoElevador == 1) {
					System.out.println();
					System.out.printf("Percentual de uso Elevador A: %.2f%%\n", report.percentualDeUsoElevadorA());
					System.out.println();
					sc.nextLine();
					System.out.println("Aperte enter para retornar para o menu."); 
					sc.nextLine();
				} else if (opcaoElevador == 2) {
					System.out.println();
					System.out.printf("Percentual de uso Elevador B: %.2f%%\n", report.percentualDeUsoElevadorB());
					System.out.println();
					sc.nextLine();
					System.out.println("Aperte enter para retornar para o menu."); 
					sc.nextLine();
				} else if (opcaoElevador == 3) {
					System.out.println();
					System.out.printf("Percentual de uso Elevador C: %.2f%%\n", report.percentualDeUsoElevadorC());
					System.out.println();
					sc.nextLine();
					System.out.println("Aperte enter para retornar para o menu."); 
					sc.nextLine();
				} else if (opcaoElevador == 4) {
					System.out.println();
					System.out.printf("Percentual de uso Elevador D: %.2f%%\n", report.percentualDeUsoElevadorD());
					System.out.println();
					sc.nextLine();
					System.out.println("Aperte enter para retornar para o menu."); 
					sc.nextLine();
				} else if (opcaoElevador == 5) {
					System.out.println();
					System.out.printf("Percentual de uso Elevador E: %.2f%%\n", report.percentualDeUsoElevadorE());
					System.out.println();
					sc.nextLine();
					System.out.println("Aperte enter para retornar para o menu."); 
					sc.nextLine();
				}
				break;
			case 0:
				opcao = 0;
			}
			
		} while (opcao != 0);
		
		System.out.println();
		System.out.println("Programa finalizado!");
		
		sc.close();
	
	}

}

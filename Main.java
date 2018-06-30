package escalonador;

import escalonador.GerenciadorProcessos;
import escalonador.Processo;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o quantum: ");
        Integer quantum      = Integer.parseInt(scanner.nextLine());

        System.out.println("Informe o nome do processo: ");
        String nomeProcesso  = scanner.nextLine();

        System.out.println("Informe a carga de trabalho: ");
        String cargaTrabalho = scanner.nextLine();

        Random random = new Random();
        Integer PID = random.nextInt(30);

        Processo processo = new Processo(nomeProcesso, PID, cargaTrabalho);

        GerenciadorProcessos gerenciadorProcessos = new GerenciadorProcessos();
        gerenciadorProcessos.setProcesso(processo);
        gerenciadorProcessos.setQuantum(quantum);

        GerenciadorProcessos gp = new GerenciadorProcessos();
        
//        Estamos executando a primeira letra do trabalho como o pronto, porém ela é o executando.
//        Verificar para montarTela antes começar a executar.
        
        for (int i = 0; i < cargaTrabalho.length() + 1 ; i++) {
        	try {
				gp.montaTela(PID, cargaTrabalho, i, cargaTrabalho.substring(i, cargaTrabalho.length()));
			} catch (Exception e) {
				e.printStackTrace();
			}
        	gp.executaProcesso(cargaTrabalho);
        }

    }


}
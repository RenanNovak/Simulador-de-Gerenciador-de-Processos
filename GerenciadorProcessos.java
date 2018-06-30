package escalonador;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class GerenciadorProcessos {

    private Processo processo;
    public String cargaTrabalhoRetorno = "naoquebra";
    private int quantum;
    private int totalCiclos;
    public String pidPronto;
    public String pidEsperando;
    public String pidExecucao;

    public Processo getProcesso() {
        return processo;
    }
    
    public void montaTela(int PID, String inteiroTela, int loop, String cargaTrabalhoTela) {
    	String estado = determinaEstado(inteiroTela, loop, cargaTrabalhoTela);
    	String proxEstado = proxEstado(inteiroTela, loop, cargaTrabalhoTela);
    	valoraPID(PID, loop, cargaTrabalhoTela);
    	System.out.println(" ========================================================");
    	System.out.println(" |Gerenciador de Processos ");
    	System.out.println(" ========================================================");
    	System.out.println(" |Contador de ciclo de execução:  ");
    	System.out.println(" |Processos na fila de pronto  (1) :  " + pidPronto);
    	System.out.println(" |Processo em execução   : ");
    	System.out.println(" |     Tempo restante    :  ");
    	System.out.println(" |     Carga de trabalho : " + pidEsperando);
    	System.out.println(" |Processos esperando    : ");
    	System.out.println(" |     Carga de trabalho : " + pidExecucao);
    	System.out.println(" |Processos finalizados  :");
    	System.out.println(" ========================================================");
    	System.out.println(" Processo 12 word Estado Atual : " + estado);
    	System.out.println(" Carga de trabalho: " + cargaTrabalhoTela);
    	System.out.println(" Próxima ação: " + proxEstado );
    	System.out.println(" ");

        Console c = System.console();
        Scanner scan = new Scanner(System.in);
//        c.readLine();
        scan.next();
        
    }
    
    public void valoraPID(int pid, int volta, String carga) {
    	if (volta == 0) {
    		pidPronto = "" + pid;
    		pidEsperando = "";
    		pidExecucao = "";
		} else if ((carga.substring(0,1).equals("A")) || (carga.substring(0,1).equals("B"))) {
			pidPronto = "";
    		pidEsperando = "" + pid;
    		pidExecucao = "";
		} else if ((carga.substring(0,1).equals("C")) || (carga.substring(0,1).equals("D"))) {
			pidPronto = "";
    		pidEsperando = "";
    		pidExecucao = "" + pid;
		}
		
	}

	private String proxEstado(String inteiro, int volta, String trabalho) {  

		if (volta != inteiro.length()) {
			if (volta + 1 == inteiro.length()){
				return "Terminado";
			} else if (volta == 0) {
				return "Selecionar um processo para executar";
			} else if ((trabalho.substring(0,1).equals("A")) || (trabalho.substring(0,1).equals("B"))) {
				return "ciclo de execução de CPU";
			} else if ((trabalho.substring(0,1).equals("C")) || (trabalho.substring(0,1).equals("D"))) {
				return "ciclo de E/S";
			}  else {
				return "";
			}
		}
		return "O processo será excluído";
	}

	public String determinaEstado(String inteiro, int volta, String trabalho) {
		if (volta == 0) {
			return "Pronto";
		} else if (volta == inteiro.length()){
			return "Terminado";
		} else if ((trabalho.substring(0, 1).equals("A")) || (trabalho.substring(0, 1).equals("B"))) {
			return "Executando";
		} else if ((trabalho.substring(0, 1).equals("C")) || (trabalho.substring(0, 1).equals("D"))) {
			return "Esperando";
		}  else {
			return "";
		}
		
	}

	public String executaProcesso(String cargaTrabalhoProcesso) {
    	
    	if (cargaTrabalhoProcesso.substring(0, 1) == "A") {
    		
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1) == "B") {
    		
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1) == "C") {
    		
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1) == "D") {
    		
    	}
    	else {
    		return cargaTrabalhoProcesso;
    	}
    	
    	cargaTrabalhoProcesso = cargaTrabalhoProcesso.substring(1, cargaTrabalhoProcesso.length());
    	cargaTrabalhoRetorno = cargaTrabalhoProcesso.substring(1, cargaTrabalhoProcesso.length());
		return cargaTrabalhoProcesso;
    	
    }
    

    public String verificaRetorno() {
    	return cargaTrabalhoRetorno;
    }
    
    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getTotalCiclos() {
        return totalCiclos;
    }

    public void setTotalCiclos(int totalCiclos) {
        this.totalCiclos = totalCiclos;
    }

}
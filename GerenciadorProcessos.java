package escalonador;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class GerenciadorProcessos {

    private Processo processo;
    public String cargaTrabalhoRetorno = "naoquebra";
    public int carga = 0;
    private int quantum;
    private int totalCiclos;
    public String pidPronto;
    public String pidEsperando;
    public String pidExecucao;

    public Processo getProcesso() {
        return processo;
    }
    
    public void montaTela(String nomeProcesso, int PID, String inteiroTela, int loop, String cargaTrabalhoTela) {
    	String estado = determinaEstado(inteiroTela, loop, cargaTrabalhoTela);
    	String proxEstado = proxEstado(inteiroTela, loop, cargaTrabalhoTela);
    	valoraPID(PID, loop, cargaTrabalhoTela);
    	int proces;
    	if (pidPronto != ""){
    		proces = 1;
    	}else {
    		proces = 0;
    	}
    	System.out.println(" ========================================================");
    	System.out.println(" |Gerenciador de Processos ");
    	System.out.println(" ========================================================");
    	System.out.println(" |Contador de ciclo de execução: ");
    	System.out.println(" |Processos na fila de pronto  ("+proces+") :  " + pidPronto);
    	System.out.println(" |Processo em execução   : " + pidEsperando);
    	System.out.println(" |     Tempo restante    :  ");
    	System.out.println(" |     Carga de trabalho : " );
    	System.out.println(" |Processos esperando    : " + pidExecucao);
    	System.out.println(" |     Carga de trabalho : " );
    	System.out.println(" |Processos finalizados  :");
    	System.out.println(" ========================================================");
    	System.out.println(" Processo "+nomeProcesso+" Estado Atual : " + estado);
    	System.out.println(" Carga de trabalho: " + cargaTrabalhoTela);
    	System.out.println(" Próxima ação: " + proxEstado );
    	System.out.println(" ");

//        Console c = System.console();
//        Scanner scan = new Scanner(System.in);
////        c.readLine();
//        scan.next();
        
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
			if (volta  == inteiro.length()){
				return "Terminado";
			} else if (volta == 0) {
				return "Selecionar um processo para executar";
			} else if ((trabalho.substring(1,2).equals("A")) || (trabalho.substring(1,2).equals("B"))) {
				return "ciclo de execução de CPU";
			} else if ((trabalho.substring(1,2).equals("C")) || (trabalho.substring(1,2).equals("D"))) {
				return "ciclo de E/S";
			}  else {
				return "";
			}
		}
		return "O processo será excluído";
	}

	public String determinaEstado(String inteiro, int volta, String trabalho) {
//		volta=volta+1;
		if (volta == 0) {
			return "Pronto";
		} else if (volta == inteiro.length()+1){
			return "Terminado";
		} else if ((trabalho.substring(0, 1).equals("A")) || (trabalho.substring(0, 1).equals("B"))) {
			return "Executando";
		} else if ((trabalho.substring(0, 1).equals("C")) || (trabalho.substring(0, 1).equals("D"))) {
			return "Esperando";
		}  else {
			return "";
		}
		
	}
// contador estilo função, pode ser a qualquer momento
	
	public String executaProcesso(String cargaTrabalhoProcesso, int volta) {
    	
    	if (cargaTrabalhoProcesso.substring(0, 1).equals("A")) {
    		//carga = carga +1;
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1).equals( "B")) {
    		//carga = carga+2;
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1).equals("C")) {
    		//carga = carga+1;
    	}
    	else if(cargaTrabalhoProcesso.substring(0, 1).equals("D")) {
    		//carga = carga + 2;
    	}
    	else {
    		return cargaTrabalhoProcesso;
    	}
    	if (volta != 0) {
    		cargaTrabalhoProcesso = cargaTrabalhoProcesso.substring(1, cargaTrabalhoProcesso.length());
    		cargaTrabalhoRetorno = cargaTrabalhoProcesso.substring(1, cargaTrabalhoProcesso.length());
    	}
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
        return carga;
    }
}

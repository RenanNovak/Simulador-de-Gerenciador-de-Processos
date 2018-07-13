package escalonador;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class GerenciadorProcessos {

    private Processo processo;
    public String cargaTrabalhoRetorno = "naoquebra";
    public int carga = 0;
    public int quantumCount;
    public String pidPronto;
    public String pidEsperando;
    public String pidExecucao;
    public String pidFinalizado;

    public Processo getProcesso() {
        return processo;
    }
    
    public void montaTela(String nomeProcesso, int PID, int quantum, String inteiroTela, int loop, String cargaTrabalhoTela) {
    	String estado = determinaEstado(inteiroTela, loop, cargaTrabalhoTela);
    	String proxEstado = proxEstado(inteiroTela, loop, cargaTrabalhoTela);
    	int ciclo = contaCiclos(loop, cargaTrabalhoTela);
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
    	System.out.println(" |Contador de ciclo de execução: " + ciclo);
    	System.out.println(" |Processos na fila de pronto  ("+proces+") :  " + pidPronto);
    	System.out.println(" |Processo em execução   : " + pidEsperando);
    	System.out.println(" |     Tempo restante    :  " + (quantum - getQuantum())  );
    	System.out.println(" |     Carga de trabalho : " + verificaCargaExecutando(estado, cargaTrabalhoTela));
    	System.out.println(" |Processos esperando    : " + pidExecucao);
    	System.out.println(" |     Carga de trabalho : " + verificaCargaEsperando(estado, cargaTrabalhoTela));
    	System.out.println(" |Processos finalizados  :" + pidFinalizado);
    	System.out.println(" ========================================================");
    	System.out.println(" Processo "+nomeProcesso+" Estado Atual : " + estado);
    	System.out.println(" Carga de trabalho: " + cargaTrabalhoTela);
    	System.out.println(" Próxima ação: " + proxEstado );
    	System.out.println(" ");

        
    }
    
    private String verificaCargaEsperando(String estado, String cargaTrabalhoTela) {
		String retorno = "";
    	if (estado.equals("Esperando")) {
			retorno=cargaTrabalhoTela;
		} 
		return retorno;
	}
    private String verificaCargaExecutando(String estado, String cargaTrabalhoTela) {
		String retorno = "";
    	if (estado.equals("Executando")) {
			retorno=cargaTrabalhoTela;
		} 
		return retorno;
	}

	private int contaCiclos(int loop, String cargaTrabalhoTela) {
    	if (loop != 0) {
    		if (cargaTrabalhoTela.substring(0, 1).equals("A")) {
    			carga = carga +1;
    			quantumCount = quantumCount + 1;
    		}
    		else if(cargaTrabalhoTela.substring(0, 1).equals( "B")) {
    			carga = carga+2;
    			quantumCount = quantumCount + 1;
    		}
    		else if(cargaTrabalhoTela.substring(0, 1).equals("C")) {
    			carga = carga+1;
    			quantumCount = quantumCount + 1;
    		}
    		else if(cargaTrabalhoTela.substring(0, 1).equals("D")) {
    			carga = carga + 2;
    			quantumCount = quantumCount + 1;
    		}
    		
    	}
		return carga;
	}

	public void valoraPID(int pid, int volta, String carga) {
    	if (volta == 0) {
    		pidPronto = "" + pid;
    		pidEsperando = "";
    		pidExecucao = "";
    		pidFinalizado = "";
		} else if ((carga.substring(0,1).equals("A")) || (carga.substring(0,1).equals("B"))) {
			pidPronto = "";
    		pidEsperando = "" + pid;
    		pidExecucao = "";
    		pidFinalizado = "";
		} else if ((carga.substring(0,1).equals("C")) || (carga.substring(0,1).equals("D"))) {
			pidPronto = "";
    		pidEsperando = "";
    		pidExecucao = "" + pid;
    		pidFinalizado = "";
		} else if (carga.substring(0,1).equals(" ")) {
			pidPronto = "";
    		pidEsperando = "";
    		pidExecucao = "";
    		pidFinalizado = "" + pid;
		}
		
	}

	private String proxEstado(String inteiro, int volta, String trabalho) {  
		
		if (inteiro.length() == 3 && volta != 1) {
			return "O processo sera excluído";
		}
		else {
			if (trabalho.length() <= 2) {
				return "O processo sera excluído";
			}else {
				if (volta == 0) {
					return "Selecionar um processo para executar";
				} else if ((trabalho.substring(1,2).equals("A")) || (trabalho.substring(1,2).equals("B"))) {
					return "ciclo de execução de CPU";
				} else if ((trabalho.substring(1,2).equals("C")) || (trabalho.substring(1,2).equals("D"))) {
					return "ciclo de E/S";
				}  else {
					return "";
				}
			}
			
		}
	}

	public String determinaEstado(String inteiro, int volta, String trabalho) {
		if (volta == 0) {
			return "Pronto";
		} else if (trabalho.substring(0, 1).equals(" ")){
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
    public Integer getQuantum() {
    	return quantumCount;
    }
    public void setQuantum(int novoValor) {
    	quantumCount = novoValor;
    }


    public int getTotalCiclos(String carga) {
    	int ciclos = 0;
        while (!carga.equals("")) {
        	if (carga.substring(0, 1).equals("A")) {
        		ciclos = ciclos +1;
        	}
        	else if(carga.substring(0, 1).equals( "B")) {
        		ciclos = ciclos+2;
        	}
        	else if(carga.substring(0, 1).equals("C")) {
        		ciclos = ciclos+1;
        	}
        	else if(carga.substring(0, 1).equals("D")) {
        		ciclos = ciclos + 2;
        	}
        	
        	carga= carga.substring(1, carga.length());
        }
    	return ciclos;
    }
}

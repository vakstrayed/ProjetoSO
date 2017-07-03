package PrioridadeEstatica_2;

import java.util.ArrayList;

import Util.Arquivo;
import Util.Processo;
import Util.ProcessoSaida;

public class MainPrioridadeEstatica {

	private static MainPrioridadeEstatica instance = null;
	private ArrayList<ProcessoSaida> tblProcessosConcluidos = new ArrayList<>();
	private ArrayList<Processo> tblProntos = Arquivo.getInstance().getListProcessos();
	private float ThroughPut = 0;
	private int timeSlice = 2;

	private MainPrioridadeEstatica() {
	}

	public static MainPrioridadeEstatica getInstance() {

		/**
		 * Singleton
		 */

		if (instance == null) {
			instance = new MainPrioridadeEstatica();
		}
		return instance;
	}

	public void PrioridadeEstatica() {

		this.executar();
		this.ThroughPUT();

		Arquivo.getInstance().arquivoSaida("");
		Arquivo.getInstance().arquivoSaida("Prioridade Estática 2");
		Arquivo.getInstance().arquivoSaida("ThroughPut: " + this.getPrioEstaticThroughPUT());
		for (ProcessoSaida processoSaida : tblProcessosConcluidos) {
			Arquivo.getInstance().arquivoSaida(processoSaida.toString());
		}

	}

	/**
	 * conta o tempo de pronto para todos os processos no array
	 * 
	 * @param x
	 */
	public void pronto(int x) {

		for (int i = 0; i < tblProntos.size(); i++) {
			tblProntos.get(i).setTempoPronto(x);
			// System.out.println("i:"+i+","+
			// Prontos.get(i).getTempoPronto().toString());
		}

	}

	public void executar() {
		
		System.out.println("entrou executando");

		boolean tblExecutarVazia = true;
		boolean fimTblProntos = false;
		boolean executandoProcesso = true;
		Processo processo = new Processo();
		Processo p = new Processo();
		int PC = 0;
		int aux = 0;
		
		this.pronto(PC); // conta pronto no array de prontos

		while (fimTblProntos == false) {
			// siginifica que tem que pegar processo da tabela de pronto
			if (tblExecutarVazia) {

				// enquanto tbl de prontos não estiver vazio
				if (!tblProntos.isEmpty()) {

					// procurando processo com maior prioridade
					p = tblProntos.stream()
							.max((p1, p2) -> Integer.compare(p1.getPrioridade(), p2.getPrioridade())).get();
					
					processo = new Processo(p.getID(), p.getTempoChegada(),
							p.getTempoComputacao(), p.getTemposIO(),
							p.getPrioridade(), p.getPeriodo(), p.getDeadline());
					processo.setBloqPoint(p.getBloqPoint());
					processo.setDeadline(p.getDeadline());
					processo.setTPRONT(p.getTempoPronto());
					if(p.TempoEstadoBloqueado() == -1){
						processo.setTBLOQ(p.getTemposIO().size());
					}else{
						processo.setTBLOQ(p.TempoEstadoBloqueado());
					}

					// removendo da tabela de prontos
					for (int i = 0; i < tblProntos.size(); i++) {

						if (tblProntos.get(i).getID() == processo.getID())
							tblProntos.remove(i);
					}

					tblExecutarVazia = false;
					executandoProcesso = true;

				} else { // fim da execução
					fimTblProntos = true;
				}

			}
			if (!tblExecutarVazia) { // fluxo seguinte
				timeSlice = 2;
				while (executandoProcesso) {

					// executando...
					if ((processo.containsTempoIO(PC) == false) && (processo.getTempoComputacao() > 0)
							&& (timeSlice > 0)) {
						
						aux = processo.getTempoComputacao();
						aux--;
						processo.setTempoComputacao(aux); // decrementa tempo
															// de computação

						PC++; // conta PC
						this.pronto(PC); // conta pronto no array de prontos
						timeSlice--;

					} else if (processo.containsTempoIO(PC) && (processo.getTempoComputacao() > 0) && (timeSlice > 0)) { // chamada
						// i.o

						processo.setBloqPoint(PC); // o tempo em PC cujo foi
													// encontrado
						// o bloqueio no processo
						bloqueado(processo); // passa pra bloqueado
						executandoProcesso = false; // faz sair do loop de
													// execução
						tblExecutarVazia = true; // faz solicitar novo processo
													// a fila de
						// pronto

					} else if ((timeSlice == 0) && (processo.getTempoComputacao() > 0)) { // oia
																							// aq
																							// esse
																							// carai
																							// feito
																							// alipio

						executandoProcesso = false; // faz sair do loop de
						// execução
						tblExecutarVazia = true; // faz solicitar novo processo
													// a fila de
						// pronto
						tblProntos.add(processo);

					} else if (processo.getTempoComputacao() == 0) { // acaba
																		// tempo
																		// de
						// computação

						processo.setStopPoint(PC); // tempo em que foi concluido
						encerrado(processo); // constrói o processo final e
												// finaliza o
						// processo
						executandoProcesso = false; // faz sair do loop de
													// execução
						tblExecutarVazia = true; // faz solicitar novo processo
													// a fila de
						// pronto

					}

				}

			}

		} // fim do while

	}

	public void encerrado(Processo p) {

		int tPRONTO = p.getTempoPronto().size(); // tempo total no estado pronto
		int tIO = p.TempoEstadoBloqueado(); // tempo total IO - bloqueado
		int tRESPOSTA = p.getStopPoint(); // tempo em que o PC finaliza o
											// processo
		int ID = p.getID(); // ID do processo

		ProcessoSaida pSAIDA = new ProcessoSaida(ID, tRESPOSTA, tIO, tPRONTO);

		this.tblProcessosConcluidos.add(pSAIDA);
		System.out.println("encerrou " + pSAIDA.getID());

	}

	public void bloqueado(Processo b) {

		int num = b.getBloqPoint(); // pega o ponto de parada do pc
		ArrayList<Integer> temposIO = b.getTemposIO(); // pega os tempos de i/o
		boolean key = true;

		while (key == true) {
			if (key == true && temposIO.contains(num)) { // enquanto contém o
															// valor no array
															// este valor é
															// removido
				temposIO.remove(num);
				num++;
			} else {
				key = false;
			}

		}

		b.setTemposIO(temposIO); // seta o array de temposIO no processo
		this.tblProntos.add(b); // manda o processo para o final da fila de
								// prontos

	}

	public void ThroughPUT() {

		/**
		 * Calcula o Throughput de PropriedadeEstatica Soma dos tempos de
		 * conclusão de cada processo dividido pelo número de processos
		 * concluídos!!!!
		 */

		int aux1 = 0;
		int aux2 = 0;

		for (ProcessoSaida p : this.tblProcessosConcluidos) {
			aux1 = aux1 + p.getTempoResposta();
		}
		aux2 = this.tblProcessosConcluidos.size();

		this.ThroughPut = aux1 / aux2;

	}

	public float getPrioEstaticThroughPUT() {

		return this.ThroughPut;

	}

}

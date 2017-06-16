package FIFO;

import java.util.ArrayList;

import Util.Arquivo;
import Util.Processo;
import Util.ProcessoSaida;

public class MainFIFO {

	private ArrayList<ProcessoSaida> ProcessosConcluidos = new ArrayList<>();
	private int contadorTotal = 0;

	public void FIFO() {

		ArrayList<Processo> Processos = new ArrayList<>();
		Processos = Arquivo.getInstance().getListProcessos();

		for (byte x = 0; x < Processos.size(); x++) {

			processar(Processos.get(x));

		}

	}

	public void processar(Processo processoAtual) {

		ProcessoSaida pSaida = new ProcessoSaida();

		int IDprocesso = processoAtual.getID();
		int tempoComp = processoAtual.getTempoComputacao();

		ArrayList<Integer> temposIO = processoAtual.getTemposIO();
		// Estados: 0 - bloqueado ; 1 - pronto ; 2 - executando
		byte Estado = 1;

		int contadorTComp = 0;
		int contadorIO = 0;

		int contadorPronto = 0;

		while (contadorTComp != tempoComp) {

			if (temposIO.contains(contadorTComp)) {

				Estado = 0;
				contadorIO++;
				contadorTComp--;

			} else if ((Estado == 0) && ((temposIO.contains(contadorTComp)) == false)) {

				Estado = 1;
				contadorPronto++;

			} else {

				Estado = 2;
				contadorTComp++;
				contadorTotal++;
			}

		}

		pSaida = new ProcessoSaida(IDprocesso, contadorTotal, contadorIO, contadorPronto);

		ProcessosConcluidos.add(pSaida);

	}

}

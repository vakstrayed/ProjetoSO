package Util;

public class ProcessoSaida {

	private int ID;
	private int TempoResposta;
	private int TempoTotalIO;
	private int TempoPronto;

	public ProcessoSaida() {

	}

	public ProcessoSaida(int iD, int tempoResposta, int tempoTotalIO, int tempoPronto) {
		ID = iD;
		TempoResposta = tempoResposta;
		TempoTotalIO = tempoTotalIO;
		TempoPronto = tempoPronto;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTempoResposta() {
		return TempoResposta;
	}

	public void setTempoResposta(int tempoResposta) {
		TempoResposta = tempoResposta;
	}

	public int getTempoTotalIO() {
		return TempoTotalIO;
	}

	public void setTempoTotalIO(int tempoTotalIO) {
		TempoTotalIO = tempoTotalIO;
	}

	public int getTempoPronto() {
		return TempoPronto;
	}

	public void setTempoPronto(int tempoPronto) {
		TempoPronto = tempoPronto;
	}

	@Override
	public String toString() {
		return "ID: " + ID + ", Tempo Resposta: " + TempoResposta + ", Tempo Total IO: " + TempoTotalIO
				+ ", Tempo Estado Pronto: " + TempoPronto;
	}

}

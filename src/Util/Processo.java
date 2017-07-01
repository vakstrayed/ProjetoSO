package Util;

import java.util.ArrayList;

public class Processo {

	/**
	 * Classe básica Processo Representando os campos passados nos requisitos do
	 * projeto
	 */

	// variáveis base do processo
	private int ID;
	private int TempoChegada;
	private int TempoComputacao;
	private ArrayList<Integer> TemposIO;
	private int Prioridade;
	private int Periodo;
	private int Deadline;
	
	//variáveis extras
	private ArrayList<Integer> TempoPronto; //tempos no estado pronto
	private int StopPoint; //tempo de finalização do processo no pc
	private int BloqPoint; //tempo de bloqueio do processo no pc

	public Processo() {

	}

	public Processo(int iD, int tempoChegada, int tempoComputacao, ArrayList<Integer> temposIO, int prioridade,
			int periodo, int deadline) {
		ID = iD;
		TempoChegada = tempoChegada;
		TempoComputacao = tempoComputacao;
		TemposIO = temposIO;
		Prioridade = prioridade;
		Periodo = periodo;
		Deadline = deadline;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTempoChegada() {
		return TempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		TempoChegada = tempoChegada;
	}

	public int getTempoComputacao() {
		return TempoComputacao;
	}

	public void setTempoComputacao(int tempoComputacao) {
		TempoComputacao = tempoComputacao;
	}

	public ArrayList<Integer> getTemposIO() {
		return TemposIO;
	}
	
	public boolean containsTempoIO(int x){
		return this.TemposIO.contains(x);
	}

	public void setTemposIO(ArrayList<Integer> temposIO) {
		TemposIO = temposIO;
	}

	public int getPrioridade() {
		return Prioridade;
	}

	public void setPrioridade(int prioridade) {
		Prioridade = prioridade;
	}

	public int getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}

	public int getDeadline() {
		return Deadline;
	}

	public void setDeadline(int deadline) {
		Deadline = deadline;
	}

	public int getTempoPronto() {
		return TempoPronto.size();
	}

	public void setTempoPronto(int i) {
		this.TempoPronto.add(i);
	}

	public int getStopPoint() {
		return StopPoint;
	}

	public void setStopPoint(int stopPoint) {
		StopPoint = stopPoint;
	}

	public int getBloqPoint() {
		return BloqPoint;
	}

	public void setBloqPoint(int bloqPoint) {
		BloqPoint = bloqPoint;
	}
	
	public int TempoEstadoPronto(){
		return TempoPronto.size();
	}
	
	public int TempoEstadoBloqueado(){
		return TemposIO.size();
	}

}

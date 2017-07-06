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
	private int TempoComputacaoNoPeriodo;
	private ArrayList<Integer> TemposIO = new ArrayList<>();
	private int Prioridade;
	private int Periodo;
	private int Deadline;

	// variáveis extras
	private ArrayList<Integer> TempoPronto = new ArrayList<>(); // tempos no
																// estado pronto
	private int StopPoint; // tempo de finalização do processo no pc
	private int BloqPoint; // tempo de bloqueio do processo no pc
	private int TBLOQ = -1; // tempo estado bloqueado

	public Processo() {

	}

	public Processo(int iD, int tempoChegada, int tempoComputacao, ArrayList<Integer> temposIO, int prioridade,
			int periodo, int deadline) {
		ID = iD;
		TempoChegada = tempoChegada;
		TempoComputacao = tempoComputacao;
		TempoComputacaoNoPeriodo = tempoComputacao;
		TemposIO = temposIO;
		Prioridade = prioridade;
		Periodo = periodo;
		Deadline = deadline;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public int getTempoChegada() {
		return this.TempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		this.TempoChegada = tempoChegada;
	}

	public int getTempoComputacao() {
		return this.TempoComputacao;
	}

	public void setTempoComputacao(int tempoComputacao) {
		this.TempoComputacao = tempoComputacao;
	}

	public int getTempoComputacaoNoPeriodo() {
		return this.TempoComputacaoNoPeriodo;
	}

	public void setTempoComputacaoNoPeriodo(int TempoComputacaoNoPeriodo) {
		this.TempoComputacaoNoPeriodo = TempoComputacaoNoPeriodo;
	}

	public ArrayList<Integer> getTemposIO() {
		return this.TemposIO;
	}

	public boolean containsTempoIO(int x) {
		return this.TemposIO.contains(x);
	}

	public void setTemposIO(ArrayList<Integer> temposIO) {
		this.TemposIO = temposIO;
	}

	public int getPrioridade() {
		return this.Prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.Prioridade = prioridade;
	}

	public int getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(int periodo) {
		this.Periodo = periodo;
	}

	public int getDeadline() {
		return this.Deadline;
	}

	public void setDeadline(int deadline) {
		this.Deadline = deadline;
	}

	public ArrayList<Integer> getTempoPronto() {
		return this.TempoPronto;
	}

	public void setTempoPronto(int i) {
		this.TempoPronto.add(i);
	}

	public void setTPRONT(ArrayList<Integer> p) {
		this.TempoPronto = p;
	}

	public int getStopPoint() {
		return this.StopPoint;
	}

	public void setStopPoint(int stopPoint) {
		this.StopPoint = stopPoint;
	}

	public int getBloqPoint() {
		return this.BloqPoint;
	}

	public void setBloqPoint(int bloqPoint) {
		this.BloqPoint = bloqPoint;
	}

	public int TempoEstadoPronto() {
		return this.TempoPronto.size();
	}

	public void setTBLOQ(int x) {
		this.TBLOQ = x;
	}

	public int TempoEstadoBloqueado() {
		return this.TBLOQ;
	}

}

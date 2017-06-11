package Util;

import java.util.ArrayList;

public class Processo {
	
	private int ID;
	private int TempoChegada;
	private int TempoComputacao;
	private ArrayList<Integer> TemposIO;
	private int Prioridade;
	private int Periodo;
	private int Deadline;
	
	public Processo(){
		
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
	
	
	

}

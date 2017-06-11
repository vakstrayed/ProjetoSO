package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Arquivo {

	private static Arquivo instance = null;
	private BufferedWriter escritor = null;
	private ArrayList<String> instrucoes = new ArrayList<String>();

	private Arquivo() {
	}

	public static Arquivo getInstance() {
		if (instance == null) {
			instance = new Arquivo();
		}
		return instance;
	}

	public ArrayList<String> getInstrucoes() {
		return this.instrucoes;
	}

	public void lerArquivo() {

		BufferedReader leitor = null;

		try {

			leitor = new BufferedReader(new FileReader("entrada.txt"));

			String linha = "";

			while ((linha = leitor.readLine()) != null) {
				if (linha.length() > 0)
					instrucoes.add(linha);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				leitor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Processo> getListProcessos() {

		String element = null;
		ArrayList<Processo> ListaProcessos = new ArrayList<>();
		Processo genericProcesso = new Processo();
		int tempoChegada = 0, tempoComputacao = 0, prioridade = 0, periodo = 0, deadline = 0;
		ArrayList<Integer> temposIO = null;
		List<String> list = null;
		String AuxIO = null;

		lerArquivo();

		for (byte k = 0; k < instrucoes.size(); k++) {
			element = instrucoes.get(k);
			String Alt1[] = element.split(Pattern.quote(" "));

			for (byte j = 0; j < Alt1.length; j++) {

				switch (j) {

				case 0:

					tempoChegada = Integer.valueOf(Alt1[j]);

					break;
				case 1:

					tempoComputacao = Integer.valueOf(Alt1[j]);

					break;
				case 2:

					AuxIO = Alt1[j];
					list = Arrays.asList(AuxIO.substring(1, AuxIO.length() - 1).split(";"));

					for (byte i = 0; i < list.size(); i++) {
						temposIO.add(Integer.parseInt(list.get(i)));
					}

					break;
				case 3:

					prioridade = Integer.valueOf(Alt1[j]);

					break;
				case 4:

					periodo = Integer.valueOf(Alt1[j]);

					break;
				case 5:

					deadline = Integer.valueOf(Alt1[j]);

					break;

				}

			}

			genericProcesso = new Processo(k, tempoChegada, tempoComputacao, temposIO, prioridade, periodo, deadline);
			ListaProcessos.add(genericProcesso);

			list = null;
			temposIO = null;

		}

		return ListaProcessos;

	}

	public void arquivoSaida(String instrucao, String registradores) {

		try {
			if (new File("saida.txt").exists() == false) {

				new File("saida.txt").createNewFile();

			}

			escritor = new BufferedWriter(new FileWriter("saida.txt"));

			escritor.append("\r\n" + instrucao + "\r\n");
			escritor.append(registradores + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

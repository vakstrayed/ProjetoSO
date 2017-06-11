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

		/**
		 * Singleton
		 */

		if (instance == null) {
			instance = new Arquivo();
		}
		return instance;
	}

	public ArrayList<String> getInstrucoes() {

		/**
		 * Retorna o array de instrucoes
		 */

		return this.instrucoes;
	}

	public void lerArquivo() {

		/**
		 * Método responsável por ler o arquivo e salvar as linhas referentes ao
		 * processo em um array chamado instrucoes
		 */

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

		/**
		 * Método responsável por traduzir o array de instrucoes em um array do
		 * tipo Processo
		 */

		// Variáveis básicas necessárias para ajudar no auxílio da tradução
		String element = null;
		ArrayList<Processo> ListaProcessos = new ArrayList<>();
		Processo genericProcesso = new Processo();
		int tempoChegada = 0, tempoComputacao = 0, prioridade = 0, periodo = 0, deadline = 0;
		ArrayList<Integer> temposIO = null;
		List<String> list = null;
		String AuxIO = null;

		// chamada do método lerArquivo() para preencher o array instrucoes com
		// o que for lido do arquivo
		lerArquivo();

		// para as intruções lidas do arquivo, faça:
		for (byte k = 0; k < instrucoes.size(); k++) {

			// element recebe a instrução apontada por k
			// Alt1 se transforma em um vetor da partição de element, usando " "
			// como ponto de partição
			element = instrucoes.get(k);
			String Alt1[] = element.split(Pattern.quote(" "));
			
			//verifica se contém 6 elementos dentro do vetor, se não retorna null
			if (Alt1.length == 6) {
				
				//para cada elemento do vetor faça
				for (byte j = 0; j < Alt1.length; j++) {

					switch (j) {

					case 0:

						tempoChegada = Integer.valueOf(Alt1[j]);

						break;
					case 1:

						tempoComputacao = Integer.valueOf(Alt1[j]);

						break;
					case 2:
						
						//AuxIO recebe o elemento para auxiliar no tratamento do mesmo
						AuxIO = Alt1[j];
						//verifica se a quantidade de caracteres é maior que dois (apenas a existencia dos colchetes) 
						if (AuxIO.length() > 2) {
							//list recebe array string da partição dos elementos por ";"
							list = Arrays.asList(AuxIO.substring(1, AuxIO.length() - 1).split(";"));
						
							//converter os elementos da lista em um array de inteiros
							for (byte i = 0; i < list.size(); i++) {
								temposIO.add(Integer.parseInt(list.get(i)));
							}
						} else {
							temposIO = null;
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
				
				//associa os campos tratados em um processo genérico
				genericProcesso = new Processo(k, tempoChegada, tempoComputacao, temposIO, prioridade, periodo,
						deadline);
				//adiciona o processo generico a lista de processos
				ListaProcessos.add(genericProcesso);
				
				//reseta algumas informações
				list = null;
				temposIO = null;
				
			}else{
				return null;
			}
		}
		
		//retorna a lista de processos 
		return ListaProcessos;

	}

	public void arquivoSaida(String instrucao, String registradores) {
		
		/**
		 * Método responsável por escrever os dados no arquivo de saída
		 */

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

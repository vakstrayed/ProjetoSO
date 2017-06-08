package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

	private static Arquivo instance = null;
	private BufferedWriter escritor = null;

	private Arquivo() {
		try {
			escritor = new BufferedWriter(new FileWriter("saida.txt"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static Arquivo getInstance() {
		if (instance == null) {
			instance = new Arquivo();
		}
		return instance;
	}

	public ArrayList<String> lerArquivo() {

		ArrayList<String> instrucoes = new ArrayList<String>();
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
		return instrucoes;

	}

	public void arquivoSaida(String instrucao, String registradores) {

		try {
			if (new File("saida.txt").exists() == false) {

				new File("saida.txt").createNewFile();

			}

			escritor.append("\r\n" + instrucao + "\r\n");
			escritor.append(registradores + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void arquivoSaidaExclusivo(String instrucao, String hilo, String registradores) {

		try {
			if (new File("saida.txt").exists() == false) {

				new File("saida.txt").createNewFile();

			}

			escritor.append("\r\n" + instrucao + "\r\n");
			escritor.append(hilo + "\r\n");
			escritor.append(registradores + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void arquivoToDaTaMemo(String instrucao, String memo, String registradores) {

		try {
			if (new File("saida.txt").exists() == false) {

				new File("saida.txt").createNewFile();

			}

			escritor.append("\r\n" + instrucao + "\r\n");
			escritor.append("Memoria de dados: " + memo + "\r\n");
			escritor.append(registradores + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

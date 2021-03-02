package model;

/**
 * Classe para exibir data para controle dos livros da biblioteca
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Data {

	// criando construtor vazio
	public Data() {
	}

	// declarando os atributos
	private int dia;
	private int mes;
	private int ano;

	// Métodos getters e setters;
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	// método toString() para exibir a Data
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}
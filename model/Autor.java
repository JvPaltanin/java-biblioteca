package model;

/**
 * Classe autor para armazenar os autores e facilitar na pesquisa
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Autor {

	// criando construtor vazio
	public Autor() {
	}

	// declarando atributos
	private int codigo;
	private String nome;
	private String nacionalidade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

}
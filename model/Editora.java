package model;

/**
 * Classe para configurar atributos da Editora, construtor vazio e métodos
 * getters e setters
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Editora {

	// criando construtor vazio
	public Editora() {
	}

	// declarando atributos
	private int codigo;
	private String nome;
	private String pais;

	// gerando métodos getters e setters
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
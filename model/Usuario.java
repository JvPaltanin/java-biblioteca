package model;

/**
 * Classe usuario para armazenar os atributos, cosntrutor vazio e m�todos
 * getters e setters
 * 
 * @author Jo�o Victor
 * @since 18/02/2021
 */
public class Usuario {

	// gerando construtor vazio
	public Usuario() {
	}

	// declarando os atributos
	private int codigo;
	private String nome;
	private Data dataNascimento;
	private String telefone;
	private String email;

	// criando m�todos getters e setters para os atributos da classe
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

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
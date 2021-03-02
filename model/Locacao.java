package model;

/**
 * Classe para configurar atributos da locação do livro, construtor vazio e
 * métodos getters e setters
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Locacao {

	// construtor vazio da classe
	public Locacao() {
	}

	// declarando atributos
	private int codigo;
	private Data dataLocacao;
	private Data dataDevolucao;
	private Livro livros[];
	private Usuario usuario;
	private boolean ativo;

	// gerando métodos getters e setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Data getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Data dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Data getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Livro[] getLivros() {
		return livros;
	}

	public void setLivros(Livro livros[]) {
		this.livros = livros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
package model;

/**
 * Classe para configurar atributos do Livro, construtor vazio e métodos getters
 * e setters
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Livro {

	// gerando construtor vazio
	public Livro() {
	}

	// declarando atributos
	private int codigo;
	private String titulo;
	private Editora editora;
	private Autor autor;
	private int anoPublicacao;
	private boolean disponivel;

	// gerando métodos getters e setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
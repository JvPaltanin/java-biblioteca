package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe biblioteca que armazena o menu e seus m�todos com funcionalidades
 * 
 * @author Jo�o Victor
 * @since 18/02/2021
 */
public class Biblioteca {

	// vetor para armazenar os livros cadastrados
	private Livro livros[];

	// vetor para armazenar os usuarios
	private Usuario usuarios[];

	// vetor para armazenar as loca��es
	private Locacao locacoes[];

	// variavel auxiliar para definir a quantidade de Livros da biblioteca
	private int quantidadeLivros = 0;

	// variavel auxiliar para definir a quantidade de Usu�rios da biblioteca
	private int quantidadeUsuarios = 0;

	// variavel auxiliar para definir a quantidade de Loca��es da biblioteca
	private int quantidadeLocacoes = 0;

	// M�todo construtor da classe
	public Biblioteca() {
		processar();
	}

	// M�todo principal do programa
	public void processar() {

		// capturando do usu�rio o tamanho da biblioteca
		do {
			quantidadeLivros = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Livros da Biblioteca"));
		} while (quantidadeLivros <= 0);

		// capturando do usu�rio a quantidade de usu�rios para cadastrar
		do {
			quantidadeUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Usu�rios"));
		} while (quantidadeUsuarios <= 0);

		// capturando do usu�rio a quantidade de usu�rios para cadastrar
		do {
			quantidadeLocacoes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Loca��es"));
		} while (quantidadeLocacoes <= 0);

		// definindo o tamanho da biblioteca
		livros = new Livro[quantidadeLivros];

		// setando o tamanho do vetor de usu�rios
		usuarios = new Usuario[quantidadeUsuarios];

		// setando o tamanho do vetor de loca��es
		locacoes = new Locacao[quantidadeLocacoes];

		// processamento de looping do programa
		while (true) {
			// chamando o m�todo do menu
			escolhaUsuario();
		}
	}

	// M�todo para capturar do usu�rio a op��o
	public void escolhaUsuario() {
		String menu = "Informe a op��o desejada:\n\n" + "OP��O 1: Cadastrar Livro\n" + "OP��O 2: Cadastrar usu�rio\n"
				+ "OP��O 3: Efetuar loca��o de livros\n" + "OP��O 4: Efetuar devolu��o de livros\n"
				+ "OP��O 5: Listar todos os livros cadastrados\n" + "OP��O 6: Listar todos os usu�rios cadastrados\n"
				+ "OP��O 7: Pesquisar livros por editora\n" + "OP��O 8: Pesquisar livros por autor\n"
				+ "OP��O 9: Pesquisar loca��es por data\n" + "OP��O 10: Sair do sistema\n";

		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// M�todo para sele��o das op��es do programa
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarLivro();
			break;

		case 2:
			cadastrarUsuario();
			break;

		case 3:
			locacaoLivro();
			break;

		case 4:
			devolucaoLivro();
			break;

		case 5:
			listarLivros();
			break;

		case 6:
			listarUsuarios();
			break;

		case 7:
			pesquisaPorEditora();
			break;
		case 8:
			pesquisaPorAutor();
			break;

		case 9:
			pesquisaLocacoesPorData();
			break;

		case 10:
			sairDoSistema();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Cadastro de Livro", 0);// erro
			break;
		}
	}

	// M�todo para efetuar o cadastro de um novo livro na biblioteca
	public void cadastrarLivro() {

		// vari�vel auxiliar para verificar se gravou o livro
		boolean gravado = false;

		// la�o para verificar espa�o na biblioteca
		for (int i = 0; i < livros.length; i++) {// inicio do for
			if (livros[i] == null) {
				livros[i] = criarLivro();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usu�rio
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Livro salvo com sucesso!", "Cadastro de Livro", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o cadastro - Biblioteca cheia!",
					"Cadastro de Livro", 2);
		}

	} // fim do m�todo

	// M�todo para colocar um livro para cadastro na biblioteca
	public Livro criarLivro() {
		Autor autor = new Autor();
		Editora editora = new Editora();
		Livro livro = new Livro();

		// recebendo do usuario o c�digo do livro para cadastro
		livro.setCodigo(
				Integer.parseInt(JOptionPane.showInputDialog("Informe o C�DIGO do LIVRO que deseja cadastrar")));

		// recebendo do usu�rio o t�tulo do livro para cadastro
		livro.setTitulo(JOptionPane.showInputDialog("Informe o T�TULO do livro"));

		// recebendo do usuario o autor do livro e a nacionalidade
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o C�DIGO da AUTOR")));
		autor.setNome(JOptionPane.showInputDialog("Informe o AUTOR do livro"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a NACIONALIDADE do autor"));

		// recebendo do usuario a editora e o pa�s da editora
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o C�DIGO da EDITORA")));
		editora.setNome(JOptionPane.showInputDialog("Informe a EDITORA do livro"));
		editora.setPais(JOptionPane.showInputDialog("Informe  o PA�S da editora"));

		// recebendo do usu�rio o ano da publica��o do livro
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano da publica��o do livro")));

		// atribuindo o autor do livro ao livro
		livro.setAutor(autor);

		// atribuindo a editora ao livro
		livro.setEditora(editora);

		// setando o livro como dispon�vel no momento do cadastro
		livro.setDisponivel(true);

		return livro;
	} // fim do m�todo

	public void cadastrarUsuario() {

		// vari�vel auxiliar para verificar se gravou o usu�rio
		boolean gravado = false;

		// la�o para verificar espa�o
		for (int i = 0; i < usuarios.length; i++) {// inicio do for
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usuario
		if (gravado == true) {
			JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso!", "Cadastro de Usu�rio", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel realizar o cadastro - Capacidade de usu�rios excedida!", "Cadastro de Usu�rio",
					2);
		}
	} // fim do m�todo

	// M�todo para criar um usu�rio para ser cadastrado na biblioteca
	public Usuario criarUsuario() {
		// instanciando os objetos
		Usuario usuario = new Usuario();
		Data dataNascimento = new Data();

		// recebendo o c�digo do usu�rio
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo do usu�rio")));

		// recebendo do usu�rio o nome de usu�rio do cliente
		usuario.setNome(JOptionPane.showInputDialog("Informe NOME do cliente"));

		// recebendo do usu�rio a data de nascimento do cliente e atribuindo a um array
		String dataQuebrada[] = JOptionPane.showInputDialog("Informe a Data de NASCIMENTO do usu�rio").split("/");
		dataNascimento.setDia(Integer.parseInt(dataQuebrada[0]));
		dataNascimento.setMes(Integer.parseInt(dataQuebrada[1]));
		dataNascimento.setAno(Integer.parseInt(dataQuebrada[2]));

		// atribuindo os valores de data para o objeto usuario
		usuario.setDataNascimento(dataNascimento);

		// recebendo do usu�rio o telefone do cliente
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o TELEFONE do cliente"));

		// recebendo do usu�rio o email do cliente
		usuario.setEmail(JOptionPane.showInputDialog("Informe o EMAIL do cliente"));
		return usuario;
	}

	public void locacaoLivro() {
		// variavel para vereficar se gravou o locacao
		boolean locado = false;

		// variavel para vereficar se existem livros disponiveis para loca��o
		boolean semLivrosDisponiveis = true;

		// variavel para vereficar se existem usu�rios cadastrados
		boolean usuariosCadastrados = true;

		// vari�vel para verificar se o cadastro est� cheio
		boolean cheio = true;

		// La�o para vereficar espa�o no vetor
		for (int i = 0; i < locacoes.length; i++) { // inicio for principal
			if (locacoes[i] == null) { // inicio if
				// indica que tem espa�o dispon�vel para fazer loca��o
				cheio = false;

				// verifica se existem usuarios cadastrados
				for (int k = 0; k < usuarios.length; k++) {
					if (usuarios[k] != null) {
						// indica que possui usu�rios cadastrados no sistema
						usuariosCadastrados = false;
						break;
					}
				}
				if (usuariosCadastrados) {
					break;
				}
				for (int j = 0; j < livros.length; j++) { // inicio for (verifica se tem algum livro dispon�vel para
															// loca��o)
					if ((livros[j] != null) && (livros[j].isDisponivel())) {
						// indica que tem livros disponiveis
						semLivrosDisponiveis = false;
						// chama m�todo para criar uma loca��o
						locacoes[i] = criarLocacao();
						// atualiza como locado
						locado = true;
						break;
					}
				} // fim for (verifica se tem livros disponiveis para loca��o)
				break;
			} // fim if
		} // fim for principal

		// Exibindo o resultado para o usu�rio
		if (cheio) {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel realizar a loca��o - Limite de m�ximo de loca��es atingido!", "Loca��o de Livros",
					2);
		} else if (locado) {
			JOptionPane.showMessageDialog(null, "Loca��o gravada com sucesso!", "Loca��o de livros", 1);
		} else if (usuariosCadastrados) {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel realizar a loca��o - Nenhum usu�rio cadastrado no sistema!", "Loca��o de Livros",
					2);
		} else if (semLivrosDisponiveis) {
			JOptionPane.showMessageDialog(null,
					"N�o foi poss�vel realizar a loca��o - Nenhum livro dispon�vel para loca��o!", "Loca��o de Livros",
					2);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a loca��o - Biblioteca cheia!",
					"Loca��o de Livros", 2);
		}
	} // fim do m�todo

	// m�todo para locar livros
	public Locacao criarLocacao() {
		// instanciando o objeto data para data de devolu��o
		Data dataDevolucao = new Data();

		// objeto para receber a loca��o
		Locacao locacao = new Locacao();

		// vari�vel para receber data atual e atribuir a data de loca��o
		Data data = new Data();

		// recebendo a data atual
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		LocalDateTime now = LocalDateTime.now();

		// separando a data em dia m�s e ano
		String dataQuebrada[] = (dtf.format(now).split("/"));

		// setando da data da loca��o
		data.setDia(Integer.parseInt(dataQuebrada[0]));
		data.setMes(Integer.parseInt(dataQuebrada[1]));
		data.setAno(Integer.parseInt(dataQuebrada[2]));
		locacao.setDataLocacao(data);

		// recebendo dados da loca��o do usu�rio
		locacao.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da Loca��o")));

		// listando e selecionando usu�rio
		Usuario usuario = new Usuario();
		int codigoUsuario = -1;

		String mensagem = "";

		for (int i = 0; i < usuarios.length; i++) { // inicio do for
			if (usuarios[i] != null) {
				mensagem += "C�digo " + (i + 1) + " - " + usuarios[i].getNome() + "\n";
			}
		} // fim do for

		// la�o de repeti��o para aceitar somente usu�rios v�lidos
		do {
			codigoUsuario = Integer
					.parseInt(JOptionPane.showInputDialog("Inf�rme o c�digo do usu�rio desejado:\n" + mensagem)) - 1;
			// verifica se o c�digo informado � valido ou n�o
			if ((codigoUsuario < 0) || (codigoUsuario >= usuarios.length) || (usuarios[codigoUsuario] == null)) {
				JOptionPane.showMessageDialog(null, "C�digo inv�lido!\nInforme um novo c�digo", "C�digo invalido", 2);
			}
		} while ((codigoUsuario < 0) || (codigoUsuario >= usuarios.length) || (usuarios[codigoUsuario] == null));
		usuario = usuarios[codigoUsuario];

		/// atribuindo o usuario a loca��o
		usuario = usuarios[codigoUsuario];

		// criando variavel para contar livros disponiveis
		int livrosDisponiveis = 0;

		// Contando livros dispon�veis para locar
		for (int j = 0; j < livros.length; j++) { // inicio do for
			if ((livros[j] != null) && (livros[j].isDisponivel())) {
				livrosDisponiveis++;
			}
		} // fim do for

		// vari�vel para perguntar quantos livros ser�o locados
		int quantidadeLocados = 0;
		do {
			quantidadeLocados = Integer.parseInt(JOptionPane
					.showInputDialog("Quantos livros voc� deseja locar? (M�ximo: " + livrosDisponiveis + ")"));
		} while ((quantidadeLocados > livrosDisponiveis) || (quantidadeLocados <= 0));

		// cria uma listar de livros para salvar os livros locados
		Livro livrosLocados[] = new Livro[quantidadeLocados];

		// la�o para realizar loca��o
		for (int i = 0; i < livrosLocados.length; i++) {

			// Atualizando a mensagem com os livros disponiveis para locar
			mensagem = "";

			// variaveis auxiliares para adicionar o c�digo real do livro
			int cont = 0;
			int aux[];
			aux = new int[livrosDisponiveis];

			for (int j = 0; j < livros.length; j++) { // inicio do for

				if ((livros[j] != null) && (livros[j].isDisponivel())) {
					aux[cont] = j;
					mensagem += "C�digo " + (cont + 1) + " - " + livros[aux[cont]].getTitulo() + "\n";
					cont++;
				}
			} // fim do for

			// solicita do usu�rio os livro desejado
			int codigoLivro = -1;
			do {
				codigoLivro = Integer
						.parseInt(JOptionPane.showInputDialog("Informe o c�digo do livro desejado:\n" + mensagem)) - 1;
				if ((codigoLivro < 0) || (codigoLivro >= livrosDisponiveis) || (livros[codigoLivro] == null)) {
					JOptionPane.showMessageDialog(null, "C�digo inv�lido!\nInforme um novo c�digo", "C�digo invalido",
							2);
				}
			} while ((codigoLivro < 0) || (codigoLivro >= livrosDisponiveis) || (livros[codigoLivro] == null));

			livrosLocados[i] = livros[(aux[codigoLivro])];

			// informa que o livro n�o est� mais disponivel para loca��o
			livros[aux[codigoLivro]].setDisponivel(false);
		}

		// recebendo e quebrando a data da devolu��o (aceitando apenas data ap�s o dia
		// de loca��o)
		do {
			dataQuebrada = JOptionPane.showInputDialog("Informe a data da devolu��o").split("/");
			if (((Integer.parseInt(dataQuebrada[2]) == data.getAno())
					&& (Integer.parseInt(dataQuebrada[1]) == data.getMes())
					&& (Integer.parseInt(dataQuebrada[0]) > data.getDia()))
					|| ((Integer.parseInt(dataQuebrada[2]) > data.getAno())
							|| (Integer.parseInt(dataQuebrada[2]) == data.getAno()
									&& (Integer.parseInt(dataQuebrada[1]) > data.getMes())))) {
				dataDevolucao.setDia(Integer.parseInt(dataQuebrada[0]));
				dataDevolucao.setMes(Integer.parseInt(dataQuebrada[1]));
				dataDevolucao.setAno(Integer.parseInt(dataQuebrada[2]));
			} else {
				JOptionPane.showMessageDialog(null, "Data inv�lida!\nInforme uma data superior a data atual",
						"Data inv�lida", 2);
			}

		} while (!(((Integer.parseInt(dataQuebrada[2]) == data.getAno())
				&& (Integer.parseInt(dataQuebrada[1]) == data.getMes())
				&& (Integer.parseInt(dataQuebrada[0]) > data.getDia()))
				|| ((Integer.parseInt(dataQuebrada[2]) > data.getAno())
						|| (Integer.parseInt(dataQuebrada[2]) == data.getAno()
								&& (Integer.parseInt(dataQuebrada[1]) > data.getMes())))));

		// atribuindo valores na loca��o
		locacao.setLivros(livrosLocados);
		locacao.setUsuario(usuario);
		locacao.setAtivo(true);

		return locacao;

	} // fim do m�todo

	// m�todo para devolu��o de livros locados
	public void devolucaoLivro() {
		// vari�vel para receber o c�digo da loca��o
		int codigoLocacao;

		// vari�vel auxiliar para exibir as loca��es ativas para o usu�rio
		String mensagem = "";

		// vari�veis auxiliares para adicionar o c�digo real do livro
		int cont = 0;
		int locacoesAtivas = 0;
		int aux[];

		// Conta quantas loca��es ativas existem
		for (int i = 0; i < locacoes.length; i++) { // inicio do for
			if ((locacoes[i] != null) && locacoes[i].isAtivo()) {
				locacoesAtivas++;
			}
		}
		aux = new int[locacoesAtivas];

		for (int i = 0; i < locacoes.length; i++) { // inicio do for
			if ((locacoes[i] != null) && locacoes[i].isAtivo()) {
				aux[cont] = i;
				mensagem += "C�digo " + (cont + 1) + " - " + locacoes[i].getUsuario().getNome() + " - "
						+ locacoes[i].getDataLocacao() + "\n";
				cont++;
			}
		} // fim do for

		if (mensagem != "") {
			// recebendo c�digo de qual loca��o deseja fazer devolu��o
			do {
				codigoLocacao = (Integer
						.parseInt(JOptionPane.showInputDialog("Informe o c�digo da loca��o desejada:\n" + mensagem)))
						- 1;
			} while ((codigoLocacao < 0) || (codigoLocacao >= locacoes.length) || (locacoes[codigoLocacao] == null));

			Livro auxLivros[] = new Livro[locacoes[aux[codigoLocacao]].getLivros().length];

			auxLivros = locacoes[aux[codigoLocacao]].getLivros();

			for (int i = 0; i < auxLivros.length; i++) {
				for (int j = 0; j < livros.length; j++) {
					if (auxLivros[i] == livros[j]) {
						livros[j].setDisponivel(true);
					}
				}
			}

			locacoes[aux[codigoLocacao]].setAtivo(false);

			JOptionPane.showMessageDialog(null, "Devolu��o efetuada com sucesso!", "Loca��o de Livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel efetuar a devolu��o - Nenhuma loca��o ativa!",
					"Loca��o de Livros", 2);
		}
	}

	// M�todo para listar os livros cadastrados da biblioteca
	public void listarLivros() {

		// vari�vel auxiliar para verificar se existe livro
		boolean existe = false;

		// variavel auxiliar para exibir os livros para o usuario
		String mensagem = "";

		// varrendo a biblioteca para verificar se existe livros cadastrados
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += (i + 1) + " - " + livros[i].getTitulo() + "\n";
				existe = true;
			}
		} // fim do for

		// exibindo resultado da pesquisa caso n�o exista
		if (existe) {
			// exibindo os livros da biblioteca para o usu�rio
			JOptionPane.showMessageDialog(null, mensagem, "Lista de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o possui livros cadastrados", "Lista de livros", 2);
		}

	} // fim do m�todo

	public void listarUsuarios() {
		// vari�vel auxiliar para verificar se existe usu�rio
		boolean existe = false;

		// variavel auxiliar para exibir os clientes para o usuario
		String mensagem = "";

		// varrendo os usu�rios para verificar se existe clientes cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - " + usuarios[i].getNome() + "\n";
				existe = true;
			}
		} // fim do for

		// exibindo resultado da pesquisa caso n�o exista
		if (existe) {
			// exibindo os livros da biblioteca para o usuario
			JOptionPane.showMessageDialog(null, mensagem, "Lista de Usu�rios", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o possui usu�rios cadastrados", "Lista de Usu�rios", 2);
		}

	} // fim do m�todo

	// M�todo para retornar se tem algum livro cadastrado
	public boolean temLivro() {
		// Vari�vel auxiliar para verificar se existe algum livro cadastrado
		boolean temLivro = false;

		// Varrendo o estoque para verificar se existe usu�rios cadastrados
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				temLivro = true;
			}
		}
		return temLivro;
	}

	// M�todo para retornar todos os livros por editora escolhida
	public void pesquisaPorEditora() {
		// vari�vel auxiliar para verificar se tem livros cadastrados
		boolean temLivro = temLivro();

		if (temLivro) {

			// recebendo do usuario qual editora a ser pesquisada
			String editora = JOptionPane.showInputDialog("Informe a EDITORA para pesquisa");

			// variavel auxiliar para exibir a mensagem do resultado pesquisado
			String mensagem = "Pesquisa por Editora:\n\n";

			// variavel auxiliar para verificar se existe a editora cadastrada
			boolean existe = false;

			// varrendo o vetor e verificando o carro cadastrado
			for (int i = 0; i < livros.length; i++) {
				if (livros[i] != null && livros[i].getEditora().getNome().equals(editora)) {
					mensagem += mensagem(livros[i]);
					existe = true;
				}
			} // fim do for

			// exibindo o resultado da pesquisa para o usuario
			if (existe) {
				JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por editora", 1);
			} else {
				JOptionPane.showMessageDialog(null, "Editora n�o existe em nossos registros", "Pesquisa por editora",
						2);
			}

		} else {
			// Erro caso nenhum livro esteja cadastrado
			JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!", "Pesquisa por editora", 2);
		}
	} // fim do m�todo

	// M�todo para retornar todos os livros por autor escolhido
	public void pesquisaPorAutor() {
		// Vari�vel auxiliar para verificar se existem livros cadastrados
		boolean temLivro = temLivro();

		if (temLivro) {

			// recebendo do usu�rio qual autor a ser pesquisado
			String autor = JOptionPane.showInputDialog("Informe o AUTOR para pesquisa");

			// variavel auxiliar para exibir a mensagem do resultado pesquisado
			String mensagem = "Pesquisa por Autor:\n\n";

			// variavel auxiliar para verificar se existe o autor cadastrado
			boolean existe = false;

			// varrendo o vetor e verificando os livros cadastrados
			for (int i = 0; i < livros.length; i++) {
				if (livros[i] != null && livros[i].getAutor().getNome().equals(autor)) {
					mensagem += mensagem(livros[i]);
					existe = true;
				}
			} // fim do for

			// exibindo o resultado da pesquisa para o usuario
			if (existe) {
				JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por Autor", 1);
			} else {
				JOptionPane.showMessageDialog(null, "Autor inexistente nos registros", "Pesquisa por Autor", 2);
			}
		} else {
			// Erro caso nenhum livro esteja cadastrado
			JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!", "Pesquisa por Autor", 2);
		}
	} // fim do m�todo

	public boolean temLocacao() {
		// Vari�vel auxiliar para verificar se existe algum livro cadastrado
		boolean temLocacao = false;

		// Varrendo o estoque para verificar se existe usu�rios cadastrados
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				temLocacao = true;
			}
		}
		return temLocacao;
	}

	// M�todo para retornar todos as loca��es de uma data escolhida
	public void pesquisaLocacoesPorData() {

		// Vari�vel auxiliar para checar se existem loca��es
		boolean temLocacao = temLocacao();

		if (temLocacao) {
			// recebendo e quebrando a data da loca��o
			String dataQuebrada[] = JOptionPane.showInputDialog("Informe a data da loca��o").split("/");

			// vari�vel auxiliar para verificar se existem loca��es na data buscada
			boolean existe = false;

			// vari�vel para exibir a mensagem do resultado pesquisado
			String mensagem = "Pesquisa loca��o por data: " + dataQuebrada[0] + "/" + dataQuebrada[1] + "/"
					+ dataQuebrada[2] + "\n\n";

			// varrendo o vetor e vereficando as editoras
			for (int i = 0; i < locacoes.length; i++) { // inicio do for
				if ((locacoes[i] != null)
						&& (locacoes[i].getDataLocacao().getDia() == Integer.parseInt(dataQuebrada[0]))) {
					mensagem += "Loca��o: " + locacoes[i].getCodigo() + "\nData: "
							+ locacoes[i].getDataLocacao().toString() + "\nUsu�rio: "
							+ locacoes[i].getUsuario().getNome() + "\n\n";
					existe = true;
				}
			} // fim do for

			// Exibindo o resultado da consulta
			if (existe) {
				JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por Loca��o", 1);
			} else {
				JOptionPane.showMessageDialog(null, "N�o possui nenhuma loca��o na data pesquisada",
						"Pesquisa por Loca��o", 2);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma loca��o foi realizada!", "Pesquisa por loca��o", 2);
		}
	} // fim do m�todo

	// M�todo para montar mensagem para o usu�rio
	public String mensagem(Livro livro) {
		// variavel auxiliar para retonar a mensagem formatada
		String msg = "\n";

		// montando a mensagem de retorno para o usuario
		msg += "C�digo: " + livro.getCodigo() + "\n";
		msg += "T�tulo: " + livro.getTitulo() + "\n";
		msg += "Editora: " + livro.getEditora().getNome() + "\n";
		msg += "Autor: " + livro.getAutor().getNome() + "\n";
		msg += "Ano da publica��o: " + livro.getAnoPublicacao() + "\n";

		// retornando a vari�vel formatada
		return msg;
	} // fim do m�todo

	// M�todo para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	} // fim do m�todo

}
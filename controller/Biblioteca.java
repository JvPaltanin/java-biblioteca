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
 * Classe biblioteca que armazena o menu e seus métodos com funcionalidades
 * 
 * @author João Victor
 * @since 18/02/2021
 */
public class Biblioteca {

	// vetor para armazenar os livros cadastrados
	private Livro livros[];

	// vetor para armazenar os usuarios
	private Usuario usuarios[];

	// vetor para armazenar as locações
	private Locacao locacoes[];

	// variavel auxiliar para definir a quantidade de Livros da biblioteca
	private int quantidadeLivros = 0;

	// variavel auxiliar para definir a quantidade de Usuários da biblioteca
	private int quantidadeUsuarios = 0;

	// variavel auxiliar para definir a quantidade de Locações da biblioteca
	private int quantidadeLocacoes = 0;

	// Método construtor da classe
	public Biblioteca() {
		processar();
	}

	// Método principal do programa
	public void processar() {

		// capturando do usuário o tamanho da biblioteca
		do {
			quantidadeLivros = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Livros da Biblioteca"));
		} while (quantidadeLivros <= 0);

		// capturando do usuário a quantidade de usuários para cadastrar
		do {
			quantidadeUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Usuários"));
		} while (quantidadeUsuarios <= 0);

		// capturando do usuário a quantidade de usuários para cadastrar
		do {
			quantidadeLocacoes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Locações"));
		} while (quantidadeLocacoes <= 0);

		// definindo o tamanho da biblioteca
		livros = new Livro[quantidadeLivros];

		// setando o tamanho do vetor de usuários
		usuarios = new Usuario[quantidadeUsuarios];

		// setando o tamanho do vetor de locações
		locacoes = new Locacao[quantidadeLocacoes];

		// processamento de looping do programa
		while (true) {
			// chamando o método do menu
			escolhaUsuario();
		}
	}

	// Método para capturar do usuário a opção
	public void escolhaUsuario() {
		String menu = "Informe a opção desejada:\n\n" + "OPÇÃO 1: Cadastrar Livro\n" + "OPÇÃO 2: Cadastrar usuário\n"
				+ "OPÇÃO 3: Efetuar locação de livros\n" + "OPÇÃO 4: Efetuar devolução de livros\n"
				+ "OPÇÃO 5: Listar todos os livros cadastrados\n" + "OPÇÃO 6: Listar todos os usuários cadastrados\n"
				+ "OPÇÃO 7: Pesquisar livros por editora\n" + "OPÇÃO 8: Pesquisar livros por autor\n"
				+ "OPÇÃO 9: Pesquisar locações por data\n" + "OPÇÃO 10: Sair do sistema\n";

		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// Método para seleção das opções do programa
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
			JOptionPane.showMessageDialog(null, "Opção inválida!", "Cadastro de Livro", 0);// erro
			break;
		}
	}

	// Método para efetuar o cadastro de um novo livro na biblioteca
	public void cadastrarLivro() {

		// variável auxiliar para verificar se gravou o livro
		boolean gravado = false;

		// laço para verificar espaço na biblioteca
		for (int i = 0; i < livros.length; i++) {// inicio do for
			if (livros[i] == null) {
				livros[i] = criarLivro();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usuário
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Livro salvo com sucesso!", "Cadastro de Livro", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro - Biblioteca cheia!",
					"Cadastro de Livro", 2);
		}

	} // fim do método

	// Método para colocar um livro para cadastro na biblioteca
	public Livro criarLivro() {
		Autor autor = new Autor();
		Editora editora = new Editora();
		Livro livro = new Livro();

		// recebendo do usuario o código do livro para cadastro
		livro.setCodigo(
				Integer.parseInt(JOptionPane.showInputDialog("Informe o CÓDIGO do LIVRO que deseja cadastrar")));

		// recebendo do usuário o título do livro para cadastro
		livro.setTitulo(JOptionPane.showInputDialog("Informe o TÍTULO do livro"));

		// recebendo do usuario o autor do livro e a nacionalidade
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o CÓDIGO da AUTOR")));
		autor.setNome(JOptionPane.showInputDialog("Informe o AUTOR do livro"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a NACIONALIDADE do autor"));

		// recebendo do usuario a editora e o país da editora
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o CÓDIGO da EDITORA")));
		editora.setNome(JOptionPane.showInputDialog("Informe a EDITORA do livro"));
		editora.setPais(JOptionPane.showInputDialog("Informe  o PAÍS da editora"));

		// recebendo do usuário o ano da publicação do livro
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano da publicação do livro")));

		// atribuindo o autor do livro ao livro
		livro.setAutor(autor);

		// atribuindo a editora ao livro
		livro.setEditora(editora);

		// setando o livro como disponível no momento do cadastro
		livro.setDisponivel(true);

		return livro;
	} // fim do método

	public void cadastrarUsuario() {

		// variável auxiliar para verificar se gravou o usuário
		boolean gravado = false;

		// laço para verificar espaço
		for (int i = 0; i < usuarios.length; i++) {// inicio do for
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usuario
		if (gravado == true) {
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro de Usuário", 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar o cadastro - Capacidade de usuários excedida!", "Cadastro de Usuário",
					2);
		}
	} // fim do método

	// Método para criar um usuário para ser cadastrado na biblioteca
	public Usuario criarUsuario() {
		// instanciando os objetos
		Usuario usuario = new Usuario();
		Data dataNascimento = new Data();

		// recebendo o código do usuário
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do usuário")));

		// recebendo do usuário o nome de usuário do cliente
		usuario.setNome(JOptionPane.showInputDialog("Informe NOME do cliente"));

		// recebendo do usuário a data de nascimento do cliente e atribuindo a um array
		String dataQuebrada[] = JOptionPane.showInputDialog("Informe a Data de NASCIMENTO do usuário").split("/");
		dataNascimento.setDia(Integer.parseInt(dataQuebrada[0]));
		dataNascimento.setMes(Integer.parseInt(dataQuebrada[1]));
		dataNascimento.setAno(Integer.parseInt(dataQuebrada[2]));

		// atribuindo os valores de data para o objeto usuario
		usuario.setDataNascimento(dataNascimento);

		// recebendo do usuário o telefone do cliente
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o TELEFONE do cliente"));

		// recebendo do usuário o email do cliente
		usuario.setEmail(JOptionPane.showInputDialog("Informe o EMAIL do cliente"));
		return usuario;
	}

	public void locacaoLivro() {
		// variavel para vereficar se gravou o locacao
		boolean locado = false;

		// variavel para vereficar se existem livros disponiveis para locação
		boolean semLivrosDisponiveis = true;

		// variavel para vereficar se existem usuários cadastrados
		boolean usuariosCadastrados = true;

		// variável para verificar se o cadastro está cheio
		boolean cheio = true;

		// Laço para vereficar espaço no vetor
		for (int i = 0; i < locacoes.length; i++) { // inicio for principal
			if (locacoes[i] == null) { // inicio if
				// indica que tem espaço disponível para fazer locação
				cheio = false;

				// verifica se existem usuarios cadastrados
				for (int k = 0; k < usuarios.length; k++) {
					if (usuarios[k] != null) {
						// indica que possui usuários cadastrados no sistema
						usuariosCadastrados = false;
						break;
					}
				}
				if (usuariosCadastrados) {
					break;
				}
				for (int j = 0; j < livros.length; j++) { // inicio for (verifica se tem algum livro disponível para
															// locação)
					if ((livros[j] != null) && (livros[j].isDisponivel())) {
						// indica que tem livros disponiveis
						semLivrosDisponiveis = false;
						// chama método para criar uma locação
						locacoes[i] = criarLocacao();
						// atualiza como locado
						locado = true;
						break;
					}
				} // fim for (verifica se tem livros disponiveis para locação)
				break;
			} // fim if
		} // fim for principal

		// Exibindo o resultado para o usuário
		if (cheio) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar a locação - Limite de máximo de locações atingido!", "Locação de Livros",
					2);
		} else if (locado) {
			JOptionPane.showMessageDialog(null, "Locação gravada com sucesso!", "Locação de livros", 1);
		} else if (usuariosCadastrados) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar a locação - Nenhum usuário cadastrado no sistema!", "Locação de Livros",
					2);
		} else if (semLivrosDisponiveis) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar a locação - Nenhum livro disponível para locação!", "Locação de Livros",
					2);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação - Biblioteca cheia!",
					"Locação de Livros", 2);
		}
	} // fim do método

	// método para locar livros
	public Locacao criarLocacao() {
		// instanciando o objeto data para data de devolução
		Data dataDevolucao = new Data();

		// objeto para receber a locação
		Locacao locacao = new Locacao();

		// variável para receber data atual e atribuir a data de locação
		Data data = new Data();

		// recebendo a data atual
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		LocalDateTime now = LocalDateTime.now();

		// separando a data em dia mês e ano
		String dataQuebrada[] = (dtf.format(now).split("/"));

		// setando da data da locação
		data.setDia(Integer.parseInt(dataQuebrada[0]));
		data.setMes(Integer.parseInt(dataQuebrada[1]));
		data.setAno(Integer.parseInt(dataQuebrada[2]));
		locacao.setDataLocacao(data);

		// recebendo dados da locação do usuário
		locacao.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código da Locação")));

		// listando e selecionando usuário
		Usuario usuario = new Usuario();
		int codigoUsuario = -1;

		String mensagem = "";

		for (int i = 0; i < usuarios.length; i++) { // inicio do for
			if (usuarios[i] != null) {
				mensagem += "Código " + (i + 1) + " - " + usuarios[i].getNome() + "\n";
			}
		} // fim do for

		// laço de repetição para aceitar somente usuários válidos
		do {
			codigoUsuario = Integer
					.parseInt(JOptionPane.showInputDialog("Infórme o código do usuário desejado:\n" + mensagem)) - 1;
			// verifica se o código informado é valido ou não
			if ((codigoUsuario < 0) || (codigoUsuario >= usuarios.length) || (usuarios[codigoUsuario] == null)) {
				JOptionPane.showMessageDialog(null, "Código inválido!\nInforme um novo código", "Código invalido", 2);
			}
		} while ((codigoUsuario < 0) || (codigoUsuario >= usuarios.length) || (usuarios[codigoUsuario] == null));
		usuario = usuarios[codigoUsuario];

		/// atribuindo o usuario a locação
		usuario = usuarios[codigoUsuario];

		// criando variavel para contar livros disponiveis
		int livrosDisponiveis = 0;

		// Contando livros disponíveis para locar
		for (int j = 0; j < livros.length; j++) { // inicio do for
			if ((livros[j] != null) && (livros[j].isDisponivel())) {
				livrosDisponiveis++;
			}
		} // fim do for

		// variável para perguntar quantos livros serão locados
		int quantidadeLocados = 0;
		do {
			quantidadeLocados = Integer.parseInt(JOptionPane
					.showInputDialog("Quantos livros você deseja locar? (Máximo: " + livrosDisponiveis + ")"));
		} while ((quantidadeLocados > livrosDisponiveis) || (quantidadeLocados <= 0));

		// cria uma listar de livros para salvar os livros locados
		Livro livrosLocados[] = new Livro[quantidadeLocados];

		// laço para realizar locação
		for (int i = 0; i < livrosLocados.length; i++) {

			// Atualizando a mensagem com os livros disponiveis para locar
			mensagem = "";

			// variaveis auxiliares para adicionar o código real do livro
			int cont = 0;
			int aux[];
			aux = new int[livrosDisponiveis];

			for (int j = 0; j < livros.length; j++) { // inicio do for

				if ((livros[j] != null) && (livros[j].isDisponivel())) {
					aux[cont] = j;
					mensagem += "Código " + (cont + 1) + " - " + livros[aux[cont]].getTitulo() + "\n";
					cont++;
				}
			} // fim do for

			// solicita do usuário os livro desejado
			int codigoLivro = -1;
			do {
				codigoLivro = Integer
						.parseInt(JOptionPane.showInputDialog("Informe o código do livro desejado:\n" + mensagem)) - 1;
				if ((codigoLivro < 0) || (codigoLivro >= livrosDisponiveis) || (livros[codigoLivro] == null)) {
					JOptionPane.showMessageDialog(null, "Código inválido!\nInforme um novo código", "Código invalido",
							2);
				}
			} while ((codigoLivro < 0) || (codigoLivro >= livrosDisponiveis) || (livros[codigoLivro] == null));

			livrosLocados[i] = livros[(aux[codigoLivro])];

			// informa que o livro não está mais disponivel para locação
			livros[aux[codigoLivro]].setDisponivel(false);
		}

		// recebendo e quebrando a data da devolução (aceitando apenas data após o dia
		// de locação)
		do {
			dataQuebrada = JOptionPane.showInputDialog("Informe a data da devolução").split("/");
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
				JOptionPane.showMessageDialog(null, "Data inválida!\nInforme uma data superior a data atual",
						"Data inválida", 2);
			}

		} while (!(((Integer.parseInt(dataQuebrada[2]) == data.getAno())
				&& (Integer.parseInt(dataQuebrada[1]) == data.getMes())
				&& (Integer.parseInt(dataQuebrada[0]) > data.getDia()))
				|| ((Integer.parseInt(dataQuebrada[2]) > data.getAno())
						|| (Integer.parseInt(dataQuebrada[2]) == data.getAno()
								&& (Integer.parseInt(dataQuebrada[1]) > data.getMes())))));

		// atribuindo valores na locação
		locacao.setLivros(livrosLocados);
		locacao.setUsuario(usuario);
		locacao.setAtivo(true);

		return locacao;

	} // fim do método

	// método para devolução de livros locados
	public void devolucaoLivro() {
		// variável para receber o código da locação
		int codigoLocacao;

		// variável auxiliar para exibir as locações ativas para o usuário
		String mensagem = "";

		// variáveis auxiliares para adicionar o código real do livro
		int cont = 0;
		int locacoesAtivas = 0;
		int aux[];

		// Conta quantas locações ativas existem
		for (int i = 0; i < locacoes.length; i++) { // inicio do for
			if ((locacoes[i] != null) && locacoes[i].isAtivo()) {
				locacoesAtivas++;
			}
		}
		aux = new int[locacoesAtivas];

		for (int i = 0; i < locacoes.length; i++) { // inicio do for
			if ((locacoes[i] != null) && locacoes[i].isAtivo()) {
				aux[cont] = i;
				mensagem += "Código " + (cont + 1) + " - " + locacoes[i].getUsuario().getNome() + " - "
						+ locacoes[i].getDataLocacao() + "\n";
				cont++;
			}
		} // fim do for

		if (mensagem != "") {
			// recebendo código de qual locação deseja fazer devolução
			do {
				codigoLocacao = (Integer
						.parseInt(JOptionPane.showInputDialog("Informe o código da locação desejada:\n" + mensagem)))
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

			JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso!", "Locação de Livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar a devolução - Nenhuma locação ativa!",
					"Locação de Livros", 2);
		}
	}

	// Método para listar os livros cadastrados da biblioteca
	public void listarLivros() {

		// variável auxiliar para verificar se existe livro
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

		// exibindo resultado da pesquisa caso não exista
		if (existe) {
			// exibindo os livros da biblioteca para o usuário
			JOptionPane.showMessageDialog(null, mensagem, "Lista de livros", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não possui livros cadastrados", "Lista de livros", 2);
		}

	} // fim do método

	public void listarUsuarios() {
		// variável auxiliar para verificar se existe usuário
		boolean existe = false;

		// variavel auxiliar para exibir os clientes para o usuario
		String mensagem = "";

		// varrendo os usuários para verificar se existe clientes cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - " + usuarios[i].getNome() + "\n";
				existe = true;
			}
		} // fim do for

		// exibindo resultado da pesquisa caso não exista
		if (existe) {
			// exibindo os livros da biblioteca para o usuario
			JOptionPane.showMessageDialog(null, mensagem, "Lista de Usuários", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não possui usuários cadastrados", "Lista de Usuários", 2);
		}

	} // fim do método

	// Método para retornar se tem algum livro cadastrado
	public boolean temLivro() {
		// Variável auxiliar para verificar se existe algum livro cadastrado
		boolean temLivro = false;

		// Varrendo o estoque para verificar se existe usuários cadastrados
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				temLivro = true;
			}
		}
		return temLivro;
	}

	// Método para retornar todos os livros por editora escolhida
	public void pesquisaPorEditora() {
		// variável auxiliar para verificar se tem livros cadastrados
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
				JOptionPane.showMessageDialog(null, "Editora não existe em nossos registros", "Pesquisa por editora",
						2);
			}

		} else {
			// Erro caso nenhum livro esteja cadastrado
			JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!", "Pesquisa por editora", 2);
		}
	} // fim do método

	// Método para retornar todos os livros por autor escolhido
	public void pesquisaPorAutor() {
		// Variável auxiliar para verificar se existem livros cadastrados
		boolean temLivro = temLivro();

		if (temLivro) {

			// recebendo do usuário qual autor a ser pesquisado
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
	} // fim do método

	public boolean temLocacao() {
		// Variável auxiliar para verificar se existe algum livro cadastrado
		boolean temLocacao = false;

		// Varrendo o estoque para verificar se existe usuários cadastrados
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				temLocacao = true;
			}
		}
		return temLocacao;
	}

	// Método para retornar todos as locações de uma data escolhida
	public void pesquisaLocacoesPorData() {

		// Variável auxiliar para checar se existem locações
		boolean temLocacao = temLocacao();

		if (temLocacao) {
			// recebendo e quebrando a data da locação
			String dataQuebrada[] = JOptionPane.showInputDialog("Informe a data da locação").split("/");

			// variável auxiliar para verificar se existem locações na data buscada
			boolean existe = false;

			// variável para exibir a mensagem do resultado pesquisado
			String mensagem = "Pesquisa locação por data: " + dataQuebrada[0] + "/" + dataQuebrada[1] + "/"
					+ dataQuebrada[2] + "\n\n";

			// varrendo o vetor e vereficando as editoras
			for (int i = 0; i < locacoes.length; i++) { // inicio do for
				if ((locacoes[i] != null)
						&& (locacoes[i].getDataLocacao().getDia() == Integer.parseInt(dataQuebrada[0]))) {
					mensagem += "Locação: " + locacoes[i].getCodigo() + "\nData: "
							+ locacoes[i].getDataLocacao().toString() + "\nUsuário: "
							+ locacoes[i].getUsuario().getNome() + "\n\n";
					existe = true;
				}
			} // fim do for

			// Exibindo o resultado da consulta
			if (existe) {
				JOptionPane.showMessageDialog(null, mensagem, "Pesquisa por Locação", 1);
			} else {
				JOptionPane.showMessageDialog(null, "Não possui nenhuma locação na data pesquisada",
						"Pesquisa por Locação", 2);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma locação foi realizada!", "Pesquisa por locação", 2);
		}
	} // fim do método

	// Método para montar mensagem para o usuário
	public String mensagem(Livro livro) {
		// variavel auxiliar para retonar a mensagem formatada
		String msg = "\n";

		// montando a mensagem de retorno para o usuario
		msg += "Código: " + livro.getCodigo() + "\n";
		msg += "Título: " + livro.getTitulo() + "\n";
		msg += "Editora: " + livro.getEditora().getNome() + "\n";
		msg += "Autor: " + livro.getAutor().getNome() + "\n";
		msg += "Ano da publicação: " + livro.getAnoPublicacao() + "\n";

		// retornando a variável formatada
		return msg;
	} // fim do método

	// Método para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	} // fim do método

}
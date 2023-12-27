package Visao;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Dominio.Animais;
import Dominio.Doentes;
import Dominio.Gestantes;
import Dominio.Usuario;
import Persistencia.AnimaisDAO;
import Persistencia.DoentesDAO;
import Persistencia.GestantesDAO;
import Persistencia.UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ControleBemcaprino implements Initializable {

	@FXML
	private TableColumn<Animais, String> generoColunaAnimal;

	@FXML
	private TableColumn<Animais, Integer> idColunaAnimal;

	@FXML
	private TableColumn<Animais, Double> pesoColunaAnimal;

	@FXML
	private TableColumn<Animais, String> racaColunaAnimal;

	@FXML
	private TableView<Animais> tabelaAnimal;

	@FXML
	private TableColumn<Doentes, String> descricao;

	@FXML
	private TableColumn<Doentes, String> doenca;

	@FXML
	private TableColumn<Doentes, String> tratamento;

	@FXML
	private TableView<Doentes> tabelaDoente;

	@FXML
	private TableColumn<Animais, Integer> idDoente;
	
	@FXML 
	private TableView <Gestantes> TabelaGestantes;
	
	@FXML
	private TableColumn <Gestantes, Integer> idGestante;
	
	@FXML
	private TableColumn <Gestantes, String> tipoGestante;
	
	@FXML
	private TableColumn <Gestantes, String> DataGestante;
	
	@FXML
	private TableColumn <Gestantes, String> TempoGestante;
	

	@FXML
	private Button botaoBucarUsu;

	@FXML
	private Button botaoBuscaCadastroAni;

	@FXML
	private MenuItem botaoCadsAnimal;

	@FXML
	private MenuItem botaoCadsAnimal11;

	@FXML
	private MenuItem botaoCadsAnimalDoente;

	@FXML
	private MenuItem botaoCadsRelatorio;

	@FXML
	private Button botaoCadstAnimal;

	@FXML
	private Button botaoCadstAnimalGestacao;
	
	@FXML
	private Button botaoBuscarIdGestante;
	
	@FXML
	private Button botaoVoltarListGest;

	@FXML
	private Button botaoCadstDoente;

	@FXML
	private Button botaoBuscarIdDoente;

	@FXML
	private Button botaoEntraAD;

	@FXML
	private Button botaoEntraGest;
	
	@FXML
	private MenuItem botaoSairGestante;

	@FXML
	private Button botaoEntraLA;
	
	@FXML
	private AnchorPane telaCdAnimalGestant;
	
	@FXML
    private MenuItem botaoCadsAnimalGest;
	
	@FXML
	private MenuItem botaoRelatorGestan;

	@FXML
	private MenuButton botaoMenu;

	@FXML
	private MenuButton botaoMenu11;

	@FXML
	private MenuButton botaoMenuDoente;

	@FXML
	private Label mensagemDoentes;
	
	@FXML
	private Label mensagemGestantes;

	@FXML
	private MenuItem botaoSair;

	@FXML
	private MenuItem botaoSair11;
	
	@FXML
    private MenuItem ExcluirAlterarDoentes;

	@FXML
	private MenuItem relatorioDoentes;

	@FXML
	private Button botaoSairDash;

	@FXML
	private MenuItem botaoSairDoente;

	@FXML
	private Button botaoVoltarDoente;

	@FXML
	private Button botaoVoltarL;

	@FXML
	private Button botaoVoltarListA;

	@FXML
	private Button botaoVoltarListA11;

	@FXML
	private Button btCad;

	@FXML
	private Button btCadastreSe;

	@FXML
	private Button btLogin;

	@FXML
	private AnchorPane dashBord;

	@FXML
	private Label mensagem;

	@FXML
	private Label mensagemAnimal;

	@FXML
	private Label mensagmeC;
	
    @FXML
    private TextField DescrEADoentes;

    @FXML
    private TextField DoencaEADoentes;

    @FXML
    private MenuItem botaoExcluirAlterarDoentes;
    
    @FXML
    private AnchorPane TelaExcluireAlterarDoentes;

    @FXML
    private TextField TratEADoentes;
    
    @FXML
    private Button btExcluirDoentes;
    
    @FXML
    private Button botaoVoltarEADoente;
    
    @FXML
    private TextField idEADoente;
    
    @FXML
    private Label mensagemAlterarExcluirDoentes;


    @FXML
    private Button botaoAlterarDoente;

	@FXML
	private AnchorPane telaCadastro;

	@FXML
	private AnchorPane telaCdAnimal;

	@FXML
	private AnchorPane telaCdAnimal11;

	@FXML
	private AnchorPane telaCdAnimalDoente;

	@FXML
	private AnchorPane telaListaAnimail;

	@FXML
	private AnchorPane telaListaAnimailDoent;

	@FXML
	private AnchorPane telaListaAnimailGestan;
	
	@FXML
	private AnchorPane TelaExcluireAlterarGestantes;

	@FXML
    private TextField DataEAGestantes;
	
    @FXML
    private TextField TempoEAGestantes;

    @FXML
    private TextField TipoEAGestantes;
    
    @FXML
    private Button botaoAlterarGestantes;
    
    @FXML
    private Button botaoVoltarEAGestantes;
    
    @FXML
    private Button btExcluirGestantes;
    
    @FXML
    private TextField idEAGestante;
    
    @FXML
    private Label mensagemAlterarExcluirGestantes;

	@FXML
	private AnchorPane telaLogin;

	@FXML
	private TextField textoDescrDoente;

	@FXML
	private TextField textoDoencaDoente;

	@FXML
	private TextField textoEmailC;

	@FXML
	private AnchorPane TelaExcluireAlterar;

	@FXML
	private MenuItem botaoExcluir;
	
	@FXML
	private MenuItem botaoExcluirAlterarGestantes;

	@FXML
	private TextField textoEmailL;

	@FXML
	private TextField textoGeneroAnimal;


	@FXML
	private TextField textoGravidadeDoente;

	@FXML
	private TextField textoIDAnimal;

	@FXML
	private TextField textoIDAnimalDoente;
	
	@FXML
	private TextField textoIDAnimalGestante;
	
	@FXML
	private TextField textoTempoAnimalGestant;
	
	@FXML
	private TextField textoDataAnimalGestant;
	
	@FXML
	private TextField textoTipoAnimalGestant;
	
	@FXML
	private Button voltarAlteraExcluir;

	@FXML
	private Button btExcluir;

	@FXML
	private TextField textoNomeC;

	@FXML
	private TextField textoPesoAnimal;

	@FXML
	private TextField textoPesoAnimal11;

	@FXML
	private TextField textoRacaAnimal;

	@FXML
	private TextField textoRacaAnimal111;

	@FXML
	private PasswordField textoSenhaC;

	@FXML
	private PasswordField textoSenhaL;

	@FXML
	private TextField racEA;

    @FXML
    private Label mensagemAlterarExcluir;
    
	@FXML
	private TextField idEA;

	@FXML
	private TextField generoEA;

	@FXML
	private TextField pesoEA;

	@FXML
	private Button btAlterar;

	@FXML
	private TextField textoTratamentoDoente;

	Usuario password;
	UsuarioDAO uDAO = new UsuarioDAO();

	Animais a;
	AnimaisDAO aDAO = new AnimaisDAO();

	Doentes d;
	DoentesDAO dDAO = new DoentesDAO();
	
	Gestantes g;
	GestantesDAO gDAO = new GestantesDAO(); 
	

	String query = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Animais animal = null;

	int op = 0;

	private ObservableList<Animais> animais = FXCollections.observableArrayList();
	private ObservableList<Doentes> doente = FXCollections.observableArrayList();
	private ObservableList<Gestantes> gestante = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		configurarTabela();
		configurarTabelaDoente();
		configurarTabelaGestante();
		loadData();
		loadDataDoente();
		loadDataGestante();
	}

	private void configurarTabela() {
		idColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("IdAnimal"));
		racaColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("racaAnimal"));
		pesoColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("pesoAnimal"));
		generoColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("generoAnimal"));
	}
	
	private void configurarTabelaDoente() {
		idDoente.setCellValueFactory(new PropertyValueFactory<>("IdAnimal"));
		doenca.setCellValueFactory(new PropertyValueFactory<>("NomeDoenca"));
		tratamento.setCellValueFactory(new PropertyValueFactory<>("Tratamento"));
		descricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
	}
	private void configurarTabelaGestante() {
		idGestante.setCellValueFactory(new PropertyValueFactory<>("IdAnimal"));
		tipoGestante.setCellValueFactory(new PropertyValueFactory<>("TipoGestacao"));
		DataGestante.setCellValueFactory(new PropertyValueFactory<>("DataInicio"));
		TempoGestante.setCellValueFactory(new PropertyValueFactory<>("TempoGestacao"));
		
	}

	@FXML
	public void btCadsRelatorio(ActionEvent evente) throws IOException {
		loadData();
	}
	
	@FXML
	public void btCadsRelatorioDoente(ActionEvent evente) throws IOException{
		loadDataDoente();
	}
	
	@FXML
    public void btRelatorioGestan (ActionEvent evente) {
		loadDataGestante();
	}

	private void loadData() {

		animais.clear();

		ArrayList<Animais> dadosDoBanco = aDAO.RELATORIO();

		animais.addAll(dadosDoBanco);

		tabelaAnimal.setItems(animais);

		tabelaAnimal.refresh();
	}
	
	private void loadDataDoente() {

		doente.clear();
		
		ArrayList<Doentes> dadosDoBanco = dDAO.RELATORIODoentes();
		
		for (Doentes doente : dadosDoBanco ) {
			System.out.println(doente.getIdAnimal());
		}
		doente.addAll(dadosDoBanco);
		

		tabelaDoente.setItems(doente);
		
		tabelaDoente.refresh();
	}
	private void loadDataGestante() {
		gestante.clear();
		
		ArrayList<Gestantes> dadosDoBanco = gDAO.RELATORIO();
		gestante.addAll(dadosDoBanco);
		
		TabelaGestantes.setItems(gestante);
		
		TabelaGestantes.refresh();
		
	}


	@FXML
	public void btALterarHelp() {
	    AnimaisDAO alterarAnimal = new AnimaisDAO();
	    Animais animal = new Animais();

	    String idTexto = idEA.getText().trim();
	    if (!idTexto.isEmpty()) {
	        animal.setIdAnimal(Integer.parseInt(idTexto));
	    }

	    String raca = racEA.getText().trim();
	    String pesoTexto = pesoEA.getText().trim();
	    String genero = generoEA.getText().trim();

	    if (genero.length() > 5) {
	        mensagemAlterarExcluir.setText("Coloque Macho ou Femea");
	        return;
	    }
	    
	    if (!(genero.equalsIgnoreCase("macho") || genero.equalsIgnoreCase("femea"))) {
	        mensagemAlterarExcluir.setText("Gênero deve ser 'Macho' ou 'Fêmea'.");
	        return;
	    }

	    
	    if (!isNumeric(pesoTexto)) {
	        mensagemAlterarExcluir.setText("Coloque um numero no campo Peso");
	        return;
	    }

	    if (!isNumericInteger(idTexto)) {
	        mensagemAlterarExcluir.setText("Coloque um numero no campo ID");
	        return;
	    }

	    Double peso = !pesoTexto.isEmpty() ? Double.parseDouble(pesoTexto) : null;

	    if (raca.isEmpty()) {
	        mensagemAlterarExcluir.setText("Campo 'Raça' deve ser preenchido.");
	    } else if (peso == null) {
	        mensagemAlterarExcluir.setText("Campo 'Peso' deve ser preenchido ");
	    } else if (genero.isEmpty()) {
	        mensagemAlterarExcluir.setText("Gênero' deve ser preenchido.");
	    } else {
	        try {
	            animal.setRacaAnimal(raca);
	            animal.setPesoAnimal(peso);
	            animal.setGeneroAnimal(genero);

	            alterarAnimal.alterar(animal);

	        } catch (NumberFormatException e) {
	            mensagemAlterarExcluir.setText("Erro de formato no peso: " + e.getMessage());
	        } catch (Exception e) {
	            mensagemAlterarExcluir.setText("Erro ao realizar a alteração: " + e.getMessage());
	            e.printStackTrace();
	        }

	        op = 2;
	        configurarTela();

	        TelaExcluireAlterar.setVisible(false);
	    }
	}


	private boolean isNumeric(String str) {
	    return str.matches("\\d+(\\.\\d+)?");
	}
	
	private boolean isNumericInteger(String str) {
	    return str.matches("\\d+"); 
	}

	@FXML
	public void btCadasSe(ActionEvent evente) throws IOException {
		telaLogin.setVisible(false);
		telaCadastro.setVisible(true);
		btCad.setDisable(true);
		op = 0;
		configurarTela();
	}

	@FXML
	public void btExcluirEAlterar(ActionEvent evente) throws IOException {
		op = 2 ;
		configurarTela();
		TelaExcluireAlterar.setVisible(true);
		
	}

	@FXML
	public void excluir(ActionEvent evente) throws IOException {
		AnimaisDAO animalDAO = new AnimaisDAO();
		String conteudo = idEA.getText();

		try {
			int idAnimal = Integer.parseInt(conteudo);
			animalDAO.excluir(idAnimal);
			TelaExcluireAlterar.setVisible(false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		TelaExcluireAlterar.setVisible(false);
	}

	@FXML
	public void btEntra(ActionEvent evente) throws IOException {
		String email = textoEmailL.getText();
		String senha = textoSenhaL.getText();

		if (!email.isEmpty() && !senha.isEmpty()) {
			UsuarioDAO uDAO = new UsuarioDAO(); 
			Usuario usuario = uDAO.buscarCadastro(email, senha);
			if (usuario != null) {
				dashBord.setVisible(true);
				telaLogin.setVisible(false);
			} else {
				System.out.println("Usuário não encontrado. Verifique suas credenciais.");
			}
		} else {
			System.out.println("Por favor, preencha ambos os campos.");
		}
	}

	
	@FXML
	public void btBuscUsu(ActionEvent evente) throws IOException {
	    String email = textoEmailC.getText();
	    String emailEncontrado = uDAO.buscarEmail(email);

	    if (emailEncontrado == null) {
	        btCad.setDisable(false);
	        botaoBucarUsu.setDisable(true);
	            mensagmeC.setText("Usuário Não cadastrado!!");
	    } else {
	        btCad.setDisable(true);
	        botaoBucarUsu.setDisable(false);
	            mensagmeC.setText("Usuário já cadastrado!!");
	    }
	}

	
	@FXML
	public void btBusIdAnimal(ActionEvent evente) throws IOException {
		try {
			int id = Integer.parseInt(textoIDAnimal.getText());
			Integer idencontrado = aDAO.buscarAnimal(id);

			if (idencontrado == null) {
				botaoBuscaCadastroAni.setDisable(false);
				mensagemAnimal.setText("Animal Não cadastrado !!");
				botaoCadstAnimal.setDisable(false);
			} else {
				mensagemAnimal.setText("Animal já cadastrado !!");
				botaoCadstAnimal.setDisable(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void btCadastarC(ActionEvent evente) throws IOException {

		String nome = textoNomeC.getText();
		String senha = textoSenhaC.getText();
		String email = textoEmailC.getText();

		if (nome.isEmpty() || senha.isEmpty() || email.isEmpty()) {
			mensagmeC.setText("Campos (nome,senha e e-mail) são obrigatórios!");
			return;
		}

		op = 1;
		configurarTela();

		Usuario usuario = new Usuario();
		usuario.setNomeCompleto(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		switch (op) {
		case 1:
			uDAO.inclusao(usuario);
			telaCadastro.setVisible(false);
			telaLogin.setVisible(true);
			break;
		}
		configurarTela();
	}

	@FXML
	public void btCdAnimal(ActionEvent evente) throws IOException {
		int id = (Integer.parseInt(textoIDAnimal.getText()));
		String Raca = textoRacaAnimal.getText();
		double Peso = Double.parseDouble(textoPesoAnimal.getText());
		String Genero = textoGeneroAnimal.getText();

		if (Raca.isEmpty() | Genero.isEmpty()) {
			mensagmeC.setText("os Campos são obrigatórios!");
			return;
		}

		op = 1;
		configurarTela();

		Animais animal = new Animais();
		animal.setIdAnimal(id);
		animal.setRacaAnimal(Raca);
		animal.setPesoAnimal(Peso);
		animal.setGeneroAnimal(Genero);

		switch (op) {
		case 1:
			aDAO.incluir(animal);
			telaCdAnimal.setVisible(false);
			telaListaAnimail.setVisible(true);
			break;
		}
		configurarTela();
	}

	@FXML
	public void btBuscarIDDoente(ActionEvent event) {
		try {
			int id = Integer.parseInt(textoIDAnimalDoente.getText());
			Integer idencontrado = aDAO.buscarAnimal(id);
			
			op = 3;
			configurarTela();

			if (idencontrado != null) {
				botaoBuscarIdDoente.setDisable(false);
				botaoCadstDoente.setDisable(false);
			} else {
				mensagemDoentes.setText("Animal Não Cadastrado !!");
				botaoCadstDoente.setDisable(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
    void btBuscarIDGestante(ActionEvent event) {
		try {
			int id = Integer.parseInt(textoIDAnimalGestante.getText());
			Integer idencontrado = aDAO.buscarAnimal(id);
		
			op = 3;
			configurarTela();

			if (idencontrado != null) {
				botaoBuscarIdGestante.setDisable(false);
				botaoCadstAnimalGestacao.setDisable(false);
			} else {
				mensagemGestantes.setText("Animal Não Cadastrado !!");
				botaoCadstAnimalGestacao.setDisable(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@FXML
	public void btAniDoente(ActionEvent evente) throws IOException {
		telaListaAnimailDoent.setVisible(true);
		dashBord.setVisible(false);
	}

	@FXML
	public void btAniGestante(ActionEvent evente) throws IOException {
		telaListaAnimailGestan.setVisible(true);
		dashBord.setVisible(false);
	}

	@FXML
	public void btListAni(ActionEvent evente) throws IOException {
		telaListaAnimail.setVisible(true);
		dashBord.setVisible(false);
	}

	@FXML
    void btexcluirDoentes(ActionEvent event) {
		DoentesDAO doenteDAO = new DoentesDAO();
		String conteudo = idEADoente.getText();
		String nomeDoenca = DoencaEADoentes.getText();
		
		try {
			if (conteudo.isEmpty() || nomeDoenca.isEmpty()) {
				mensagemAlterarExcluirDoentes.setText("Digite o ID e a Doença, são obrigatórios!");
				return;
			}
			
			int idAnimal = Integer.parseInt(conteudo);
			DoentesDAO.excluir(idAnimal, nomeDoenca);
			TelaExcluireAlterarDoentes.setVisible(false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		TelaExcluireAlterarDoentes.setVisible(false);

    }
	@FXML
	void voltaRelatorioDoentes(ActionEvent event) {
		telaListaAnimailDoent.setVisible(true);
		TelaExcluireAlterarDoentes.setVisible(false);

	}
	@FXML
	void btALterarDoente(ActionEvent event) {
	    DoentesDAO alterarDoente = new DoentesDAO();
	    Doentes doente = new Doentes();
	    
	    String idTexto = idEADoente.getText().trim();
	    if (!idTexto.isEmpty() && isNumericInteger(idTexto)) {
	        doente.setIdAnimal(Integer.parseInt(idTexto));
	    } else {
	        mensagemAlterarExcluirDoentes.setText("Coloque um número válido no campo 'ID'.");
	        return;
	    }

	    String doenca = DoencaEADoentes.getText().trim();
	    String trat = TratEADoentes.getText().trim();
	    String descr = DescrEADoentes.getText().trim();
	    
	    try {
	        if (doenca.isEmpty()) {
	            mensagemAlterarExcluirDoentes.setText("Campo 'Doença' deve ser preenchido.");
	            return;
	        } else if (trat.isEmpty()) {
	            mensagemAlterarExcluirDoentes.setText("Campo 'Tratamento' deve ser preenchido.");
	            return;
	        } else if (descr.isEmpty()) {
	            mensagemAlterarExcluirDoentes.setText("Campo 'Descrição' deve ser preenchido.");
	            return;
	        }

	        doente.setNomeDoenca(doenca);
	        doente.setTratamento(trat);
	        doente.setDescricao(descr);

	        alterarDoente.alterar(doente);
	        op = 4;
	        configurarTela();
	        TelaExcluireAlterarDoentes.setVisible(false);
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	    }
	}
    
	@FXML
	public void btCadsAnimal(ActionEvent event) throws IOException {
		telaListaAnimail.setVisible(false);
		telaCdAnimal.setVisible(true);
		botaoCadstAnimal.setDisable(true);
		op = 1;
		configurarTela();
	}

	@FXML
	public void btSairListAni(ActionEvent event) throws IOException {
		telaListaAnimail.setVisible(false);
		dashBord.setVisible(true);
	}

	@FXML
	public void btVoltarLogin(ActionEvent event) {
	    try {
	        telaLogin.setVisible(true);
	        telaCadastro.setVisible(false);
	        botaoBucarUsu.setDisable(false);
	        op = 1;
	        configurarTela();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}


	@FXML
	void btSairDBoard(ActionEvent event) throws IOException {
		telaLogin.setVisible(true);
		dashBord.setVisible(false);
		op = 1 ;
		configurarTela();
	}

	@FXML
	public void btVoltListA(ActionEvent evente) throws IOException {
		telaCdAnimal.setVisible(false);
		telaListaAnimail.setVisible(true);
	}

	@FXML
	void btVoltListaDoentes(ActionEvent event) {
		telaCdAnimalDoente.setVisible(false);
		telaListaAnimailDoent.setVisible(true);

	}

	@FXML
	void btCdAnimalGestacao(ActionEvent event) {
		int id = (Integer.parseInt(textoIDAnimalGestante.getText()));
		String tipo = textoTipoAnimalGestant.getText();
		String tempo = textoTempoAnimalGestant.getText();
		String data = textoDataAnimalGestant.getText();

		if (tipo.isEmpty() | data.isEmpty()) {
			mensagmeC.setText("os Campos são obrigatórios!");
			return;
		}

		op = 1;
		configurarTela();

		Gestantes gestante = new Gestantes();
		gestante.setIdAnimal(id);
		gestante.setTipoGestacao(tipo);
		gestante.setTempoGestacao(tempo);
		gestante.setDataInicio(data);

		switch (op) {
		case 1:
			gDAO.INCLUSAO(gestante);
			System.out.println(gestante.getIdAnimal() );
			telaCdAnimalGestant.setVisible(false);
			telaListaAnimailGestan.setVisible(true);
			break;
		}
		configurarTela();
	}
		
	
	@FXML
	public void btCadsAnimalDoente(ActionEvent evente) {
		telaListaAnimailDoent.setVisible(false);
		telaCdAnimalDoente.setVisible(true);
		botaoCadstDoente.setDisable(true);
		op = 1;
		configurarTela();
	}

	@FXML
	public void btSairListAniDoente(ActionEvent evente) {
		telaListaAnimailDoent.setVisible(false);
		dashBord.setVisible(true);
	}
	
	@FXML
	public void btSairListGestantes (ActionEvent evente) {
		telaListaAnimailGestan.setVisible(false);
		dashBord.setVisible(true);
	}
	
	@FXML
	public void btExcluirAlterarDoente(ActionEvent evente) throws IOException {
		op = 4 ;
		configurarTela();
		TelaExcluireAlterarDoentes.setVisible(true);
	}
	@FXML
	void btExcluirAlterarGestantes(ActionEvent evente) throws IOException {
		op = 5 ;
		configurarTela();
		TelaExcluireAlterarGestantes.setVisible(true);
		
	}

	@FXML
	public void btCdDoente(ActionEvent evente) {
		int id = (Integer.parseInt(textoIDAnimalDoente.getText()));
		String doenca = textoDoencaDoente.getText();
		String descricao = textoDescrDoente.getText();
		String  tratamento = textoTratamentoDoente.getText();

		if (doenca.isEmpty() | descricao.isEmpty() | tratamento.isEmpty()) {
			mensagmeC.setText("os Campos são obrigatórios!");
			return;
		}

		op = 1;
		configurarTela();

		Doentes doente = new Doentes();
		doente.setIdAnimal(id);
		doente.setNomeDoenca(doenca);
		doente.setDescricao(descricao);
		doente.setTratamento(tratamento);

		switch (op) {
		case 1:
			dDAO.INCLUSAO(doente);
			System.out.println(doente.getIdAnimal() );
			telaCdAnimalDoente.setVisible(false);
			telaListaAnimailDoent.setVisible(true);
			break;
		}
		configurarTela();
	}
	
	@FXML
    public void btCadsAnimalGest (ActionEvent evente) {
		telaListaAnimailGestan.setVisible(false);
		telaCdAnimalGestant.setVisible(true);
		botaoCadstAnimalGestacao.setDisable(true);
		op = 1;
		configurarTela(); 
	}

	
	@FXML
    void btALterarGestantes(ActionEvent event) {
		 GestantesDAO alterarGestante = new GestantesDAO();
		    Gestantes gestante = new Gestantes();

		    String idTexto = idEAGestante.getText().trim();
		    if (!idTexto.isEmpty() && isNumericInteger(idTexto)) {
		        gestante.setIdAnimal(Integer.parseInt(idTexto));
		    } else {
		        mensagemAlterarExcluirGestantes.setText("Coloque um número válido no campo 'ID'.");
		        return;
		    }

		    String tipo = TipoEAGestantes.getText().trim();
		    String data = DataEAGestantes.getText().trim();
		    String tempo = TempoEAGestantes.getText().trim();

		    try {
		        if (tipo.isEmpty()) {
		            mensagemAlterarExcluirGestantes.setText("Campo 'Tipo Gestacao' deve ser preenchido.");
		            return;
		        } else if (data.isEmpty()) {
		            mensagemAlterarExcluirGestantes.setText("Campo 'Data Inicio' deve ser preenchido.");
		            return;
		        } else if (tempo.isEmpty()) {
		            mensagemAlterarExcluirGestantes.setText("Campo 'Tempo Gestação' deve ser preenchido.");
		            return; 
		        }

		        gestante.setTipoGestacao(tipo);
		        gestante.setDataInicio(data);
		        gestante.setTempoGestacao(tempo);

		        alterarGestante.alterar(gestante);
		        
		        op = 4;
		        configurarTela();
		        TelaExcluireAlterarGestantes.setVisible(false);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		    }
		}
	    
		
	@FXML
	void btexcluirGestantes(ActionEvent event) {
		GestantesDAO gestanteDAO = new GestantesDAO();
		String conteudo = idEAGestante.getText();
		String tipoGestacao = TipoEAGestantes.getText();
		
		try {
			if (conteudo.isEmpty() || tipoGestacao.isEmpty()) {
				mensagemAlterarExcluirDoentes.setText("Digite o ID e a Doença, são obrigatórios!");
				return;
			}
			
			int idAnimal = Integer.parseInt(conteudo);
			GestantesDAO.excluir(idAnimal, tipoGestacao);
			TelaExcluireAlterarGestantes.setVisible(false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		TelaExcluireAlterarDoentes.setVisible(false);

    }
		
	@FXML
	void voltaRelatorioGestantes(ActionEvent event) {
		telaListaAnimailGestan.setVisible(true);
		TelaExcluireAlterarGestantes.setVisible(false);
	}
    
	@FXML
    public void voltaRelatorioAnimal(ActionEvent evente) {
		telaListaAnimail.setVisible(true);
		TelaExcluireAlterar.setVisible(false);
    }
	@FXML
    public void btVoltListGestantes (ActionEvent evente) {
		telaListaAnimailGestan.setVisible(true);
		telaCdAnimalGestant.setVisible(false);
	}

	private void configurarTela() {
	    switch (op) {
	        case 0:
	            textoNomeC.setText("");
	            textoEmailC.setText("");
	            textoSenhaC.setText("");
	            mensagmeC.setText("");
	            break;
	        case 1:
	            textoEmailL.setText("");
	            textoSenhaL.setText("");
	            textoIDAnimal.setText("");
	            textoRacaAnimal.setText("");
	            textoPesoAnimal.setText("");
	            textoGeneroAnimal.setText("");
	            mensagemAnimal.setText("");
	            textoIDAnimalDoente.setText("");
	            textoDescrDoente.setText("");
	            textoTratamentoDoente.setText("");
	            textoDoencaDoente.setText("");
	            mensagemDoentes.setText("");
	            textoIDAnimalGestante.setText("");
	            textoTempoAnimalGestant.setText("");
	            textoDataAnimalGestant.setText("");
	            textoTipoAnimalGestant.setText("");
	            mensagemGestantes.setText("");
	            break;
	        case 2:
	            idEA.setText("");
	            racEA.setText("");
	            pesoEA.setText("");
	            generoEA.setText("");
	            break;
	        case 3:
	        	mensagemDoentes.setText("");
	        	mensagemGestantes.setText("");
	        	break;
	        case 4:
	        	 idEADoente.setText("");
		         DoencaEADoentes.setText("");
		         TratEADoentes.setText("");
		         DescrEADoentes.setText("");
		         mensagemAlterarExcluirDoentes.setText("");
	        	break;
	        case 5:
	        	 idEAGestante.setText("");
		          TipoEAGestantes.setText("");
		          DataEAGestantes.setText("");
		          TempoEAGestantes.setText("");
	        	break;
	    }
	}
}
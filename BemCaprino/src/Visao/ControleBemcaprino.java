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
import Dominio.Usuario;
import Persistencia.AnimaisDAO;
import Persistencia.DoentesDAO;
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
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;

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
	private Button botaoCadstDoente;

	@FXML
	private Button botaoBuscarIdDoente;

	@FXML
	private Button botaoEntraAD;

	@FXML
	private Button botaoEntraGest;

	@FXML
	private Button botaoEntraLA;

	@FXML
	private MenuButton botaoMenu;

	@FXML
	private MenuButton botaoMenu11;

	@FXML
	private MenuButton botaoMenuDoente;

	@FXML
	private Label mensagemDoentes;

	@FXML
	private MenuItem botaoSair;

	@FXML
	private MenuItem botaoSair11;

	@FXML
	private MenuItem botaoSair12;

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
	private TextField textoEmailL;

	@FXML
	private TextField textoGeneroAnimal;

	@FXML
	private TextField textoGeneroAnimal11;

	@FXML
	private TextField textoGravidadeDoente;

	@FXML
	private TextField textoIDAnimal;

	@FXML
	private TextField textoIDAnimal11;

	@FXML
	private TextField textoIDAnimalDoente;
	
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

	String query = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Animais animal = null;

	int op = 0;

	private ObservableList<Animais> animais = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		configurarTabela();
		loadData();
	}

	private void configurarTabela() {
		idColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
		racaColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("racaAnimal"));
		pesoColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("pesoAnimal"));
		generoColunaAnimal.setCellValueFactory(new PropertyValueFactory<>("generoAnimal"));
	}

	@FXML
	public void btCadsRelatorio(ActionEvent evente) throws IOException {
		loadData();
	}

	private void loadData() {

		animais.clear();

		ArrayList<Animais> dadosDoBanco = aDAO.RELATORIO();

		animais.addAll(dadosDoBanco);

		tabelaAnimal.setItems(animais);

		tabelaAnimal.refresh();
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






//

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
			Usuario password = uDAO.buscarCadastro(email, senha);
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
				botaoBuscarIdDoente.setDisable(false);
				mensagemDoentes.setText("Animal Não cadastrado !!");
				botaoCadstAnimal.setDisable(false);
			} else {
				mensagemDoentes.setText("Animal já cadastrado !!");
				botaoCadstDoente.setDisable(true);
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
	void btBuscarIDDoente(ActionEvent event) {
		try {
			int id = Integer.parseInt(textoIDAnimal.getText());
			Integer idencontrado = aDAO.buscarAnimal(id);

			if (idencontrado == null) {
				btCad.setDisable(false);
				botaoBucarUsu.setDisable(true);
				mensagemAnimal.setText("Animal Não cadastrado !!");
				botaoCadstAnimal.setDisable(false);
			} else {
				mensagemDoentes.setText("Animal já cadastrado !!");
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
	public void btCadAnimal(ActionEvent evente) throws IOException {

	}

	@FXML
	public void btCadsAnimal(ActionEvent event) throws IOException {
		telaListaAnimail.setVisible(false);
		telaCdAnimal.setVisible(true);
		botaoCadstAnimal.setDisable(true);
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

	}

	@FXML
	void btCadsAnimalDoente(ActionEvent event) {
		telaListaAnimailDoent.setVisible(false);
		telaCdAnimalDoente.setVisible(true);
		botaoCadstDoente.setDisable(true);
	}

	@FXML
	void btCadsRelatorioDoente(ActionEvent event) {

	}

	@FXML
	void btSairListAniDoente(ActionEvent event) {
		telaListaAnimailDoent.setVisible(false);
		dashBord.setVisible(true);
	}

	@FXML
	void btCdDoente(ActionEvent event) {
		
	}
	
	@FXML
    void voltaRelatorioAnimal(ActionEvent event) {
		telaListaAnimail.setVisible(true);
		TelaExcluireAlterar.setVisible(false);
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
	            break;
	        case 2:
	            idEA.setText("");
	            racEA.setText("");
	            pesoEA.setText("");
	            generoEA.setText("");
	            break;
	    }
	}
}
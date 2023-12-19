package Visao;

import java.io.IOException;

import Dominio.Animal;
import Dominio.Usuario;
import Persistencia.AnimalDAO;
import Persistencia.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControleBemcaprino {


	 @FXML
	    private Button botaoEntraAD;

	    @FXML
	    private Button botaoEntraGest;
	    
	    @FXML
	    private Button botaoBuscaCadastroAni;

	    @FXML
	    private Button botaoEntraLA;

	    @FXML
	    private MenuButton botaoMenu;
	    
	    @FXML
	    private MenuItem botaoCadsAnimal;
	    
	    @FXML
	    private MenuItem botaoSair;

	    @FXML
	    private Button btCad;
	    
	    @FXML
	    private Button botaoCadstAnimal;

	    @FXML
	    private Button btCadastreSe;

	    @FXML
	    private Button btLogin;
	    
	    @FXML
	    private Button botaoVoltarListA;
	    
	    @FXML
	    private Button botaoSairDash;
	    
	    @FXML
	    private Button botaoVoltarL;
	    
	    @FXML
	    private Button botaoBucarUsu;

	    @FXML
	    private AnchorPane dashBord;

	    @FXML
	    private AnchorPane telaCadastro;

	    @FXML
	    private AnchorPane telaListaAnimail;

	    @FXML
	    private AnchorPane telaLogin;
	    
	    @FXML
	    private AnchorPane telaCdAnimal;

	    @FXML
	    private TextField textoEmailC;
	    
	    @FXML
	    private TextField textoGeneroAnimal;

	    @FXML
	    private TextField textoIDAnimal;
	    
	    @FXML
	    private TextField textoPesoAnimal;

	    @FXML
	    private TextField textoRacaAnimal;

	    @FXML
	    private TextField textoEmailL;

	    @FXML
	    private TextField textoNomeC;

	    @FXML
	    private PasswordField textoSenhaC;

	    @FXML
	    private PasswordField textoSenhaL;
	    
	    @FXML
	    private Label mensagem;
	    
	    @FXML
	    private Label mensagemAnimal;
	    
	    @FXML
	    private Label mensagmeC;

	    Usuario password ;
    	UsuarioDAO uDAO = new UsuarioDAO();
    	
    	Animal a ;
    	AnimalDAO aDAO = new AnimalDAO();
    	
    	int op = 0 ;
 

    @FXML
    public void btCadasSe(ActionEvent evente) throws IOException{
    	telaLogin.setVisible(false);
    	telaCadastro.setVisible(true);
    	btCad.setDisable(true);
    	op = 0 ;
    	configurarTela();
    }
    
    @FXML
    public void btEntra(ActionEvent evente) throws IOException {
        String email = textoEmailL.getText();
        String senha = textoSenhaL.getText();

        if (!email.isEmpty() && !senha.isEmpty()) {
            Usuario password = uDAO.buscarCadastro(email, senha);

            if (password == null) {
                mensagem.setText("Usuário não cadastrado!");
            } else {
                mensagem.setText("Usuário localizado");
                telaLogin.setVisible(false);
                dashBord.setVisible(true);
            }
        }
    }
    
    @FXML
    public void btBuscUsu(ActionEvent evente) throws IOException{
    	String email = textoEmailC.getText();
        String emailEncontrado = uDAO.buscarEmail(email);

        if (emailEncontrado == null) {
            btCad.setDisable(false);
            botaoBucarUsu.setDisable(true);
            mensagmeC.setText("Usuario Não cadastrado !!");
        } else {
            btCad.setDisable(true);
            botaoBucarUsu.setDisable(false);
            mensagmeC.setText("Usuario ja cadastrado !!");
        }
    }
    
    @FXML
    public void btBusIdAnimal(ActionEvent evente) throws IOException {
        try {
            int id = Integer.parseInt(textoIDAnimal.getText());
            Integer idencontrado = aDAO.buscarAnimal(id);

            if (idencontrado == null) {
                btCad.setDisable(false);
                botaoBucarUsu.setDisable(true);
                mensagemAnimal.setText("Animal Não cadastrado !!");
                botaoCadstAnimal.setDisable(false);
            } else {
                mensagemAnimal.setText("Animal já cadastrado !!");
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
        
        op = 1 ;
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
    public void btCdAnimal(ActionEvent evente) throws IOException{
    	int id = (Integer.parseInt(textoIDAnimal.getText()));
        String Raca = textoRacaAnimal.getText();
        double Peso = Double.parseDouble(textoPesoAnimal.getText());
        String Genero = textoGeneroAnimal.getText();

        if (Raca.isEmpty() | Genero.isEmpty()) {
        	mensagmeC.setText("os Campos são obrigatórios!");
            return; 
        }
        
        op = 1 ;
        configurarTela();
        
        Animal animal = new Animal();
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
    public void btAniDoente(ActionEvent evente) throws IOException{

    }

    @FXML
    public void btAniGestante(ActionEvent evente) throws IOException{

    }
    
    @FXML
    public void btListAni(ActionEvent evente) throws IOException{
    	telaListaAnimail.setVisible(true);
    	dashBord.setVisible(false);
    }   

    @FXML
    public void btCadAnimal(ActionEvent evente) throws IOException{

    }
    
    @FXML
    public void btCadsAnimal(ActionEvent event) throws IOException{
    	telaListaAnimail.setVisible(false);
    	telaCdAnimal.setVisible(true);
    	botaoCadstAnimal.setDisable(true);
    }
    
    @FXML
    public void btSairListAni(ActionEvent event) throws IOException{
    	telaListaAnimail.setVisible(false);
    	dashBord.setVisible(true);
    }
    
    @FXML
    public void btVoltarLogin(ActionEvent evente) throws IOException{
    	telaLogin.setVisible(true);
    	telaCadastro.setVisible(false);
    	op = 1 ;
    	configurarTela();
    }
    
    @FXML
    void btSairDBoard(ActionEvent event) throws IOException{
    	telaLogin.setVisible(true);
    	dashBord.setVisible(false);
    }
    

    @FXML
    public void btVoltListA(ActionEvent evente) throws IOException{
    	telaCdAnimal.setVisible(false);
    	telaListaAnimail.setVisible(true);
    }
    
    
    private void configurarTela() {
    	switch(op) {
	    	case 0: 
	    		textoNomeC.setText(""); 
	    		textoEmailC.setText(""); 
	    		textoSenhaC.setText(""); 
	    		mensagmeC.setText("");
	            break;
	    	case 1:
	    		textoEmailL.setText(""); 
	    		textoSenhaL.setText(""); 
	    		mensagmeC.setText("");
	    		mensagem.setText("");
	    		textoIDAnimal.setText("");
	    		textoRacaAnimal.setText("");
	    		textoPesoAnimal.setText("");
	    		textoGeneroAnimal.setText("");
	    		mensagemAnimal.setText("");
	    		break;
	    	case 2: 
	    		break;
	    		
    	}
    }
}


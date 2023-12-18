package Visao;

import java.io.IOException;

import Dominio.Usuario;
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
	    private Button btCadastreSe;

	    @FXML
	    private Button btLogin;
	    
	    @FXML
	    private Button botaoVoltarL;

	    @FXML
	    private AnchorPane dashBord;

	    @FXML
	    private AnchorPane telaCadastro;

	    @FXML
	    private AnchorPane telaListaAnimail;

	    @FXML
	    private AnchorPane telaLogin;

	    @FXML
	    private TextField textoEmailC;

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
	    private Label mensagmeC;

	    Usuario password ;
    	UsuarioDAO uDAO = new UsuarioDAO();
    	int op = 0 ;
 

    @FXML
    public void btCadasSe(ActionEvent evente) throws IOException{
    	telaLogin.setVisible(false);
    	telaCadastro.setVisible(true);
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




//TÁ FUNCIONADO SÓ NÃO PODE DEIXA O USUARIO CLICAR QUANDO OS CAMPOS ESTIVER VAZIO ...
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
    }

    
    private void configurarTela() {
    	switch(op) {
	    	case 0: 
	    		textoNomeC.setText(""); 
	    		textoEmailC.setText(""); 
	    		textoSenhaC.setText(""); 
	            break;
	    	case 1:
	    		textoEmailL.setText(""); 
	    		textoSenhaL.setText(""); 
	    		mensagmeC.setText("");
	    		mensagem.setText("");
	    		break;
	    	case 2: 
	    		mensagmeC.setText("");
	    		break;
	    		
    	}
    }
}
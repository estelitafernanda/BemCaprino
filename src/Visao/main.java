package Visao;

import Aplicacao.Animal;
import Aplicacao.Gestantes;
import Aplicacao.Doencas;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		  Scanner teclado = new Scanner(System.in);
	        ArrayList <Animal> animais = new ArrayList<>();

	        int idade = 0 , op;
	        double peso = 0.0;
	        String raca = " ", genero = "", tipos = " " , 
	        		nome , tratamento , descricao , dataDes , gravidade;
	        
	        do {
	        	 System.out.println("Menu:");
	             System.out.println("1. Cadastrar Animal");
	             System.out.println("2. Cadastrar Gestante");
	             System.out.println("3. Cadastrar Doente");
	             System.out.println("4. Relatório de Doentes");
	             System.out.println("5. Sair");
	             System.out.println("Escolha uma opção:");
	             op = teclado.nextInt ();
	          switch (op) {  		 
	          case 1 :
	        	System.out.println("Idade:");
		        idade = teclado.nextInt();
		        System.out.println("Peso:");
		        peso = teclado.nextDouble();
		        teclado.nextLine(); 
		
		        System.out.println("Sexo:");
		        genero = teclado.nextLine();
		        System.out.println("Raça:");
		        raca = teclado.nextLine();
		        System.out.println("Tipo Sanguíneo:");
		        tipos = teclado.nextLine();
		
		        Animal animal = new Animal(idade, peso, genero, raca, tipos);
		        animais.add(animal);
		       
		        break ;
	          case 2 :    	
	        	  System.out.println("");
	        	  break;
	          case 3 : 
	        	  System.out.println("Nome da Doença:");
	        	  nome = teclado.nextLine();
	        	  teclado.nextLine();
	        	  System.out.println("Tratamento:");
	        	  tratamento = teclado.nextLine();
	        	  System.out.println("Descrição:");
	        	  descricao = teclado.nextLine();
	        	  System.out.println("Gravidade:");
	        	  gravidade = teclado.nextLine();
	        	  System.out.println("Data do Descobrimento:");
	        	  dataDes = teclado.nextLine();

	        	  Doencas doenca = new Doencas(idade, peso, genero, raca, tipos, nome, tratamento, descricao, gravidade, dataDes);
	        	  animais.add(doenca);
	        	  break;
	          case 4: 
	        	  System.out.println("Relatório de Doentes:");
	        	    for (Animal a : animais) {
	        	        if (a instanceof Doencas) {
	        	            Doencas doencas = (Doencas) a;
	        	            System.out.println("Nome da Doença: " + doencas.getNome());
	        	            System.out.println("Idade: " + doencas.getIdadeAnimal());
	        	            System.out.println("Peso: " + doencas.getPesoAnimal());
	        	            System.out.println("Sexo: " + doencas.getGenero());
	        	            System.out.println("Raça: " + doencas.getRaca());
	        	            System.out.println("Tipo Sanguíneo: " + doencas.getTipoS());
	        	            System.out.println("Tratamento: " + doencas.getTratamento());
	        	            System.out.println("Descrição: " + doencas.getDescricao());
	        	            System.out.println("Gravidade: " + doencas.getGravidade());
	        	            System.out.println("Data do Descobrimento: " + doencas.getDataDes());
	        	            System.out.println("------------------------");
	        	        }
	        	    }
	        	  
	        	  break; 
	         }
	        } while (op != 2);
	  
	    }


}

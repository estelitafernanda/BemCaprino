package visao;
import dominio.Animais;
import dominio.Curral;
import dominio.Doentes;
import dominio.Gestantes;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import java.util.List; 
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		
		ArrayList <Animais> animal = new ArrayList <>(); 
		ArrayList <Curral> currais = new ArrayList <>(); 

		int op = 0; 
	
		
		
		do {
			System.out.println("Menu");
			System.out.println("1 - Cadastro Animais");
			System.out.println("2 - Cadastro Animal Gestante");
			System.out.println("3 - Cadastro Animal Doente");
			System.out.println("4 - Cadastro de Currais");
			System.out.println("5 - Adicionar Animal no Curral");
			System.out.println("6 - Alterar Animal");
			System.out.println("7 - Alterar Gestante");
			System.out.println("8 - Alterar Doente");
			System.out.println("9 - Alterar Curral");
			System.out.println("10 - Excluir Animais");
			System.out.println("11 - Excluir Gestante");
			System.out.println("12 - Excluir Doente ");
			System.out.println("13 - Remover Animal do Curral");
			System.out.println("14 - Excluir Curral");
			System.out.println("15 - Total de Animais");
			System.out.println("16 - Total de Animais Gestantes");
			System.out.println("17 - Total de Animais Doentes");
			System.out.println("18 - Total de Animais no Curral");
			System.out.println("19 - Total de Currais");
			System.out.println("20 - Sair");
			
			System.out.println("Digite o número da sua escolha:"); 
			op = teclado.nextInt();
			teclado.nextLine(); 
			
			switch (op) {
			
				case 1:
					cadastrarAnimal(animal, teclado);
					break;
				case 2:
					cadastrarGestantes(animal, teclado);
					break;
				case 3:
					cadastrarDoentes(animal, teclado);
					break;
				case 4:
					cadastrarCurral (currais, teclado);
					break;
				case 5: 
					adicionarAnimalAoCurral(animal, new ArrayList<>(), teclado);
					break;
				case 6: 
					AlterarAnimais(animal, teclado);
					break;
				case 7:
					AlterarDoentes(animal, teclado);
					break;
				case 8:
					AlterarGestantes(animal, teclado); 
					break;
				case 9:
					AlterarCurral(currais, teclado);
					break; 
				case 10:
					ExcluirAnimais(animal, new ArrayList<>(), new ArrayList<>(), teclado); 
					break;
				case 11:
					ExcluirGestantes(animal, new ArrayList<>(), teclado); 
					break;
				case 12:
					ExcluirDoentes(animal, new ArrayList<>(), teclado); 
					break;
				case 13:
					removerAnimalDoCurral(animal, new ArrayList<>(), teclado);
					break; 
				case 14:
					ExcluirCurral (currais,  teclado);
					break;
				case 15:
					 TotalAnimais(animal, teclado);
					break;
				case 16:
					TotalGestantes(animal, teclado);
					break;
				case 17:
					TotalDoentes(animal, teclado); 
					break; 
				case 18:
					TotalAnimaisNoCurral(animal, currais, teclado);
					break; 
				case 19:
					TotalCurrais(currais, teclado);
					break; 
				case 20:
					System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
			}
			
		}while(op != 20);
	}
	private static void cadastrarAnimal(ArrayList<Animais> animal, Scanner teclado) {
        System.out.println("Cadastro de Animais");
 
        System.out.print("Digite o Id do Animal: ");
        int IdAnimal = teclado.nextInt();
        teclado.nextLine();
        
        if (animal.stream().anyMatch(a -> a.getIdAnimal() == IdAnimal)) {
            System.out.println("Já existe um animal com esse ID. Cadastro cancelado.");
            return;
        }

        System.out.print("Digite a Raça do Animal: ");
        String RacaAnimal = teclado.nextLine();

        System.out.println("Digite a Idade do Animal: ");
        int IdadeAnimal = teclado.nextInt(); 
        teclado.nextLine();
        
        System.out.println("Digite o Peso do Animal ");
        float PesoAnimal = teclado.nextFloat();
        teclado.nextLine();
        
        System.out.println("Digite o Tipo Sanguineo do Animal:");
        String TipoSanguineo = teclado.nextLine();
        
        System.out.println("Digite o Genero do Animal: ");
        String GeneroAnimal = teclado.nextLine();
        

        Animais novoAnimal = new Animais(IdAnimal, RacaAnimal, IdadeAnimal, PesoAnimal, TipoSanguineo, GeneroAnimal);
        animal.add(novoAnimal);

        System.out.println("Animal cadastrado com sucesso!");
    }
	private static void cadastrarGestantes(ArrayList<Animais> animal, Scanner teclado) {
	    System.out.println("Cadastro de Animal Gestante");

	    System.out.print("Digite o Id do Animal: ");
	    int idAnimal = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idAnimal)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalEncontrado = animalExistente.get();

	       
	        if (animalEncontrado.getGeneroAnimal().equalsIgnoreCase("F") || animalEncontrado.getGeneroAnimal().equalsIgnoreCase("Femêa")) {
	            System.out.print("Digite o número da sequência de gestação: ");
	            int seqGestacao = teclado.nextInt();
	            teclado.nextLine();

	            System.out.print("Digite o tipo de gestação: ");
	            String tipoGestacao = teclado.nextLine();

	            System.out.print("Digite a data de início da gestação: ");
	            String dataInicio = teclado.nextLine();

	            System.out.print("Digite o tempo de gestação em dias: ");
	            int tempoGestacao = teclado.nextInt();
	            teclado.nextLine();

	            Gestantes novaGestante = new Gestantes(
	                    animalEncontrado.getIdAnimal(),
	                    animalEncontrado.getRacaAnimal(),
	                    animalEncontrado.getIdadeAnimal(),
	                    animalEncontrado.getPesoAnimal(),
	                    animalEncontrado.getTipoSanguineo(),
	                    animalEncontrado.getGeneroAnimal(),
	                    seqGestacao,
	                    tipoGestacao,
	                    dataInicio,
	                    tempoGestacao
	            );

	            animal.add(novaGestante);

	            System.out.println("Animal gestante cadastrado com sucesso!");
	        } else {
	            System.out.println("O animal não é uma fêmea. Não pode ser cadastrado como gestante.");
	        }
	    } else {
	        System.out.println("Nenhum animal encontrado com o ID informado.");
	    }
	}

	private static void cadastrarDoentes(ArrayList<Animais> animal, Scanner teclado) {
        System.out.println("Cadastro de Animal Doente");

        System.out.print("Digite o Id do Animal: ");
        int idAnimal = teclado.nextInt();
        teclado.nextLine();

        Optional<Animais> animalExistente = animal.stream()
                .filter(a -> a.getIdAnimal() == idAnimal)
                .findFirst();

        if (animalExistente.isPresent()) {
            Animais animalEncontrado = animalExistente.get();

            System.out.print("Digite o nome da doença: ");
            String nomeDoenca = teclado.nextLine();

            System.out.print("Digite o tipo da doença: ");
            String tipoDoenca = teclado.nextLine();

            System.out.print("Digite o tratamento: ");
            String tratamento = teclado.nextLine();

            System.out.print("Digite a descrição: ");
            String descricao = teclado.nextLine();

            System.out.print("Digite a data de descobrimento: ");
            String dataDescobrimento = teclado.nextLine();

            System.out.print("Digite a gravidade: ");
            String gravidade = teclado.nextLine();

            Doentes novoDoente = new Doentes(
                    animalEncontrado.getIdAnimal(),
                    animalEncontrado.getRacaAnimal(),
                    animalEncontrado.getIdadeAnimal(),
                    animalEncontrado.getPesoAnimal(),
                    animalEncontrado.getTipoSanguineo(),
                    animalEncontrado.getGeneroAnimal(),
                    nomeDoenca,
                    tipoDoenca,
                    tratamento,
                    descricao,
                    dataDescobrimento,
                    gravidade
            );

            animal.add(novoDoente);

            System.out.println("Animal doente cadastrado com sucesso!");
        } else {
            System.out.println("Nenhum animal encontrado com o ID informado.");
        }
    }
	private static void cadastrarCurral(ArrayList <Curral> currais, Scanner teclado) {
	    System.out.println("Cadastro de Curral");

	    System.out.print("Digite o Id do Curral: ");
	    int idCurral = teclado.nextInt();
	    teclado.nextLine();

	    if (currais.stream().anyMatch(c -> c.getIdCurral() == idCurral)) {
	        System.out.println("Já existe um curral com esse ID. Cadastro cancelado.");
	        return;
	    }

	    System.out.print("Digite o Propósito do Curral: ");
	    String proposito = teclado.nextLine();

	    System.out.print("Digite o Tamanho do Curral: ");
	    float tamanho = teclado.nextFloat();

	    System.out.print("Digite a Capacidade do Curral: ");
	    float capacidade = teclado.nextFloat();

	    Curral novoCurral = new Curral(idCurral, proposito, tamanho, capacidade);
	    currais.add(novoCurral);

	    System.out.println("Curral cadastrado com sucesso!");
	}
	private static void adicionarAnimalAoCurral(ArrayList<Animais> animal, ArrayList<Curral> currais, Scanner teclado) {
	    System.out.println("Lista de Currais Disponíveis:");
	    currais.forEach(curral -> System.out.println("ID do Curral: " + curral.getIdCurral()));

	    if (currais.isEmpty()) {
	        System.out.println("Nenhum curral disponível. Cadastre currais antes de adicionar animais.");
	        return;
	    }

	    System.out.print("Digite o ID do Curral para adicionar o animal: ");
	    int idCurral = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Curral> curralExistente = currais.stream()
	            .filter(c -> c.getIdCurral() == idCurral)
	            .findFirst();

	    if (curralExistente.isPresent()) {
	        System.out.print("Digite o ID do Animal que deseja adicionar ao curral: ");
	        int idAnimal = teclado.nextInt();
	        teclado.nextLine();

	        Optional<Animais> animalParaAdicionar = animal.stream()
	                .filter(a -> a.getIdAnimal() == idAnimal)
	                .findFirst();

	        if (animalParaAdicionar.isPresent()) {
	            Curral curral = curralExistente.get();
	            curral.adicionarAnimal(animalParaAdicionar.get());
	            System.out.println("Animal adicionado ao curral com sucesso!");
	        } else {
	            System.out.println("Nenhum animal encontrado com o ID informado.");
	        }
	    } else {
	        System.out.println("Nenhum curral encontrado com o ID informado.");
	    }
	}
	public static void AlterarAnimais(ArrayList<Animais> animal, Scanner teclado) {
	    System.out.println("Alterar Informações do Animal");

	    System.out.print("Digite o Id do Animal que deseja alterar: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalEncontrado = animalExistente.get();

	        System.out.println("Animal encontrado:");
	        System.out.println("ID: " + animalEncontrado.getIdAnimal());

	        System.out.println("Digite a nova raça do Animal: ");
	        String novaRaca = teclado.nextLine();
	        
	        System.out.println("Digite a nova idade do Animal: ");
	        int novaIdade = teclado.nextInt();
	        
	        System.out.println("Digite a novo peso do Animal: ");
	        float novoPeso = teclado.nextFloat();
	        
	        System.out.println("Digite a novo tipo sanguíneo do Animal: ");
	        String novoTipoS = teclado.nextLine();
	        teclado.nextLine();
	        
	        System.out.println("Digite o Genero do Animal: ");
	        String novoGenero = teclado.nextLine();
	        
	 
	        animalEncontrado.setRacaAnimal(novaRaca);
	        animalEncontrado.setIdadeAnimal(novaIdade);
	        animalEncontrado.setPesoAnimal(novoPeso);
	        animalEncontrado.setTipoSanguineo(novoTipoS);
	        animalEncontrado.setGeneroAnimal(novoGenero);

	        System.out.println("Informações do animal alteradas com sucesso!");
	    } else {
	        System.out.println("Nenhum animal encontrado com o ID informado.");
	    }
	}
	public static void AlterarGestantes(ArrayList<Animais> animal, Scanner teclado) {
	    System.out.println("Alterar Informações do Animal Gestante");

	    System.out.print("Digite o Id do Animal Gestante que deseja alterar: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent() && animalExistente.get() instanceof Gestantes) {
	        Gestantes gestanteEncontrado = (Gestantes) animalExistente.get();

	        System.out.println("Animal gestante encontrado:");
	        System.out.println("ID: " + gestanteEncontrado.getIdAnimal());

	        System.out.print("Digite a nova sequência de gestação: ");
	        int novaSeqGestacao = teclado.nextInt();
	        teclado.nextLine();

	        System.out.print("Digite o novo tipo de gestação: ");
	        String novoTipoGestacao = teclado.nextLine();

	        System.out.print("Digite a nova data de início da gestação: ");
	        String novaDataInicio = teclado.nextLine();

	        System.out.print("Digite o novo tempo de gestação em dias: ");
	        int novoTempoGestacao = teclado.nextInt();
	        teclado.nextLine();

	        gestanteEncontrado.setSeqGestacao(novaSeqGestacao);
	        gestanteEncontrado.setTipoGestacao(novoTipoGestacao);
	        gestanteEncontrado.setDataInicio(novaDataInicio);
	        gestanteEncontrado.setTempoGestacao(novoTempoGestacao);

	        System.out.println("Informações do animal gestante alteradas com sucesso!");
	    } else {
	        System.out.println("Nenhum animal gestante encontrado com o ID informado.");
	    }
	}

	public static void AlterarDoentes(ArrayList<Animais> animal, Scanner teclado) {
	    System.out.println("Alterar Informações do Animal Doente");

	    System.out.print("Digite o Id do Animal Doente que deseja alterar: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent() && animalExistente.get() instanceof Doentes) {
	        Doentes doenteEncontrado = (Doentes) animalExistente.get();

	        System.out.println("Animal doente encontrado:");
	        System.out.println("ID: " + doenteEncontrado.getIdAnimal());

	        System.out.print("Digite o novo nome da doença: ");
	        String novoNomeDoenca = teclado.nextLine();

	        System.out.print("Digite o novo tipo da doença: ");
	        String novoTipoDoenca = teclado.nextLine();

	        System.out.print("Digite o novo tratamento: ");
	        String novoTratamento = teclado.nextLine();

	        System.out.print("Digite a nova descrição: ");
	        String novaDescricao = teclado.nextLine();

	        System.out.print("Digite a nova data de descobrimento: ");
	        String novaDataDescobrimento = teclado.nextLine();

	        System.out.print("Digite a nova gravidade: ");
	        String novaGravidade = teclado.nextLine();

	        doenteEncontrado.setNomeDoenca(novoNomeDoenca);
	        doenteEncontrado.setTipoDoenca(novoTipoDoenca);
	        doenteEncontrado.setTratamento(novoTratamento);
	        doenteEncontrado.setDescricao(novaDescricao);
	        doenteEncontrado.setDataDescobrimento(novaDataDescobrimento);
	        doenteEncontrado.setGravidade(novaGravidade);

	        System.out.println("Informações do animal doente alteradas com sucesso!");
	    } else {
	        System.out.println("Nenhum animal doente encontrado com o ID informado.");
	    }
	}
	private static void AlterarCurral(ArrayList<Curral> currais, Scanner teclado) {
	    System.out.println("Alterar Informações do Curral");

	    System.out.print("Digite o Id do Curral que deseja alterar: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Curral> curralExistente = currais.stream()
	            .filter(c -> c.getIdCurral() == idBusca)
	            .findFirst();

	    if (curralExistente.isPresent()) {
	        Curral curralEncontrado = curralExistente.get();

	        System.out.println("Curral encontrado:");
	        System.out.println("ID: " + curralEncontrado.getIdCurral());

	        System.out.print("Digite o novo propósito do Curral: ");
	        String novoProposito = teclado.nextLine();

	        System.out.print("Digite o novo tamanho do Curral: ");
	        float novoTamanho = teclado.nextFloat();

	        System.out.print("Digite a nova capacidade do Curral: ");
	        float novaCapacidade = teclado.nextFloat();

	        curralEncontrado.setProposito(novoProposito);
	        curralEncontrado.setTamanho(novoTamanho);
	        curralEncontrado.setCapacidade(novaCapacidade);

	        System.out.println("Informações do curral alteradas com sucesso!");
	    } else {
	        System.out.println("Nenhum curral encontrado com o ID informado.");
	    }
	}

	public static void ExcluirAnimais(ArrayList<Animais> animal, ArrayList<Doentes> doentes, ArrayList<Gestantes> gestantes, Scanner teclado) {
	    System.out.println("Excluir Animal");

	    System.out.print("Digite o Id do Animal que deseja excluir: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalExcluir = animalExistente.get();

	       
	        animal.remove(animalExcluir);
	        System.out.println("Animal excluído com sucesso!");

	        if (animalExcluir instanceof Doentes) {
	            Doentes doenteExcluir = (Doentes) animalExcluir;
	            doentes.remove(doenteExcluir);
	            System.out.println("Animal também removido da lista de doentes.");
	        }

	        if (animalExcluir instanceof Gestantes) {
	            Gestantes gestanteExcluir = (Gestantes) animalExcluir;
	            gestantes.remove(gestanteExcluir);
	            System.out.println("Animal também removido da lista de gestantes.");
	        }
	    } else {
	        System.out.println("Nenhum animal encontrado com o ID informado.");
	    }
	}
	public static void ExcluirGestantes(ArrayList<Animais> animal, ArrayList<Gestantes> gestantes, Scanner teclado) {
	    System.out.println("Excluir Animal Gestante");

	    System.out.print("Digite o Id do Animal Gestante que deseja excluir: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a instanceof Gestantes)
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalExcluir = animalExistente.get();

	        animal.remove(animalExcluir);
	        System.out.println("Animal Gestante excluído com sucesso!");

	        Gestantes gestanteExcluir = (Gestantes) animalExcluir;
	        gestantes.remove(gestanteExcluir);
	        System.out.println("Animal Gestante também removido da lista de gestantes.");
	    } else {
	        System.out.println("Nenhum animal gestante encontrado com o ID informado.");
	    }
	}
	public static void ExcluirDoentes(ArrayList<Animais> animal, ArrayList<Doentes> doentes, Scanner teclado) {
	    System.out.println("Excluir Animal Doente");

	    System.out.print("Digite o Id do Animal Doente que deseja excluir: ");
	    int idBusca = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a instanceof Doentes)
	            .filter(a -> a.getIdAnimal() == idBusca)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalExcluir = animalExistente.get();

	        animal.remove(animalExcluir);
	        System.out.println("Animal Doente excluído com sucesso!");

	        Doentes doenteExcluir = (Doentes) animalExcluir;
	        doentes.remove(doenteExcluir);
	        System.out.println("Animal Doente também removido da lista de doentes.");
	    } else {
	        System.out.println("Nenhum animal doente encontrado com o ID informado.");
	    }
	}
	private static void removerAnimalDoCurral(ArrayList<Animais> animal, ArrayList<Curral> currais, Scanner teclado) {
	    System.out.println("Remover Animal de um Curral");

	    System.out.print("Digite o Id do Animal que deseja remover do curral: ");
	    int idAnimal = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Animais> animalExistente = animal.stream()
	            .filter(a -> a.getIdAnimal() == idAnimal)
	            .findFirst();

	    if (animalExistente.isPresent()) {
	        Animais animalParaRemover = animalExistente.get();

	        System.out.print("Digite o Id do Curral para remover o animal: ");
	        int idCurral = teclado.nextInt();
	        teclado.nextLine();

	        Optional<Curral> curralExistente = currais.stream()
	                .filter(c -> c.getIdCurral() == idCurral)
	                .findFirst();

	        if (curralExistente.isPresent()) {
	            Curral curral = curralExistente.get();
	            curral.removerAnimal(animalParaRemover);
	            System.out.println("Animal removido do curral com sucesso!");
	        } else {
	            System.out.println("Nenhum curral encontrado com o ID informado.");
	        }
	    } else {
	        System.out.println("Nenhum animal encontrado com o ID informado.");
	    }
	}
	private static void ExcluirCurral(ArrayList<Curral> currais, Scanner teclado) {
	    System.out.println("Excluir Curral");

	    System.out.print("Digite o Id do Curral que deseja excluir: ");
	    int idCurral = teclado.nextInt();
	    teclado.nextLine();

	    Optional<Curral> curralExistente = currais.stream()
	            .filter(c -> c.getIdCurral() == idCurral)
	            .findFirst();

	    if (curralExistente.isPresent()) {
	        Curral curralParaExcluir = curralExistente.get();
	        currais.remove(curralParaExcluir);
	        System.out.println("Curral excluído com sucesso!");
	    } else {
	        System.out.println("Nenhum curral encontrado com o ID informado.");
	    }
	}
	public static void TotalAnimais(ArrayList <Animais> animal, Scanner teclado) {
		System.out.println("Total de Animais Cadastrados: " + animal.size());
		
		if (animal.size() == 0) {
			return;
		}

        System.out.print("Digite o Id do Animal para buscar: ");
        int idBusca = teclado.nextInt();
        teclado.nextLine();

        Animais animalEncontrado = animal.stream()
                .filter(a -> a.getIdAnimal() == idBusca)
                .findFirst()
                .orElse(null);

        if (animalEncontrado != null) {
            System.out.println("Animal encontrado:");
            System.out.println("ID: " + animalEncontrado.getIdAnimal());
            System.out.println("Raça: " + animalEncontrado.getRacaAnimal());
            System.out.println("Idade: " + animalEncontrado.getIdadeAnimal());
            System.out.println("Peso: " + animalEncontrado.getPesoAnimal());
            System.out.println("Tipo Sanguineo: " + animalEncontrado.getTipoSanguineo());
            System.out.println("Genero: " + animalEncontrado.getGeneroAnimal());
           
        } else {
            System.out.println("Nenhum animal encontrado com o ID informado.");
        }
	}
	public static void TotalGestantes(ArrayList<Animais> animal, Scanner teclado) {
	    long totalGestantes = animal.stream()
	            .filter(a -> a instanceof Gestantes)
	            .count();

	    System.out.println("Total de Animais Gestantes Cadastrados: " + totalGestantes);

	    Gestantes gestanteEncontrada = null; 

	    if (totalGestantes > 0) {
	        System.out.print("Digite o Id do Animal para buscar: ");
	        int idBusca = teclado.nextInt();
	        teclado.nextLine();

	        gestanteEncontrada = animal.stream()
	                .filter(a -> a instanceof Gestantes)
	                .map(a -> (Gestantes) a)
	                .filter(g -> g.getIdAnimal() == idBusca)
	                .findFirst()
	                .orElse(null);
	    }

	    if (gestanteEncontrada != null) {
	        System.out.println("Animal Gestante encontrado:");
	        System.out.println("ID: " + gestanteEncontrada.getIdAnimal());
	        System.out.println("Raça: " + gestanteEncontrada.getRacaAnimal());
	        System.out.println("Idade: " + gestanteEncontrada.getIdadeAnimal());
	        System.out.println("Peso: " + gestanteEncontrada.getPesoAnimal());
	        System.out.println("Tipo Sanguineo: " + gestanteEncontrada.getTipoSanguineo());
	        System.out.println("Genero: " + gestanteEncontrada.getGeneroAnimal());
	        System.out.println("Seq Gestacao: " + gestanteEncontrada.getSeqGestacao());
	        System.out.println("Tipo Gestacao: " + gestanteEncontrada.getTipoGestacao());
	        System.out.println("Data Inicio: " + gestanteEncontrada.getDataInicio());
	        System.out.println("Tempo Gestacao: " + gestanteEncontrada.getTempoGestacao());
	    } else {
	        System.out.println("Nenhum animal gestante encontrado com o ID informado.");
	    }
	}


	public static void TotalDoentes(ArrayList<Animais> animal, Scanner teclado) {
	    long totalDoentes = animal.stream()
	            .filter(a -> a instanceof Doentes)
	            .count();

	    System.out.println("Total de Animais Doentes Cadastrados: " + totalDoentes);

	    if (totalDoentes > 0) {
	        System.out.print("Digite o Id do Animal Doente para buscar: ");
	        int idBusca = teclado.nextInt();
	        teclado.nextLine();

	        Doentes doenteEncontrado = animal.stream()
	                .filter(a -> a instanceof Doentes)
	                .map(a -> (Doentes) a)
	                .filter(d -> d.getIdAnimal() == idBusca)
	                .findFirst()
	                .orElse(null);

	        if (doenteEncontrado != null) {
	            System.out.println("Animal Doente encontrado:");
	            System.out.println("ID: " + doenteEncontrado.getIdAnimal());
	            System.out.println("Raça: " + doenteEncontrado.getRacaAnimal());
	            System.out.println("Idade: " + doenteEncontrado.getIdadeAnimal());
	            System.out.println("Peso: " + doenteEncontrado.getPesoAnimal());
	            System.out.println("Tipo Sanguineo: " + doenteEncontrado.getTipoSanguineo());
	            System.out.println("Genero: " + doenteEncontrado.getGeneroAnimal());
	            System.out.println("Nome Doenca: " + doenteEncontrado.getNomeDoenca());
	            System.out.println("Tipo Doenca: " + doenteEncontrado.getTipoDoenca());
	            System.out.println("Tratamento: " + doenteEncontrado.getTratamento());
	            System.out.println("Descricao: " + doenteEncontrado.getDescricao());
	            System.out.println("Data Descobrimento: " + doenteEncontrado.getDataDescobrimento());
	            System.out.println("Gravidade: " + doenteEncontrado.getGravidade());
	        } else {
	            System.out.println("Nenhum animal doente encontrado com o ID informado.");
	        }
	    }
	}
	public static void TotalAnimaisNoCurral(List<Animais> animais, List<Curral> currais, Scanner teclado) {
	    System.out.println("Total de Animais Cadastrados: " + animais.size());

	    if (animais.size() == 0 || currais.size() == 0) {
	        return;
	    }

	    System.out.print("Digite o Id do Curral para buscar: ");
	    int idCurralBusca = teclado.nextInt();
	    teclado.nextLine();

	    Curral curralEncontrado = currais.stream()
	            .filter(c -> c.getIdCurral() == idCurralBusca)
	            .findFirst()
	            .orElse(null);

	    if (curralEncontrado != null) {
	    	List<Animais> animaisNoCurral = curralEncontrado.getTotalAnimaisNoCurral();
	        System.out.println("Total de Animais no Curral " + idCurralBusca + ": " + animaisNoCurral.size());

	        for (Animais animal : animaisNoCurral) {
	            System.out.println("ID: " + animal.getIdAnimal());
	            System.out.println("Raça: " + animal.getRacaAnimal());
	            System.out.println("Idade: " + animal.getIdadeAnimal());
	            System.out.println("Peso: " + animal.getPesoAnimal());
	            System.out.println("Tipo Sanguineo: " + animal.getTipoSanguineo());
	            System.out.println("Genero: " + animal.getGeneroAnimal());
	            System.out.println("------------------------");
	        }
	    } else {
	        System.out.println("Nenhum curral encontrado com o ID informado.");
	    }
	}
	public static void TotalCurrais(List<Curral> currais, Scanner teclado) {
	    System.out.println("Total de Currais Cadastrados: " + currais.size());

	    if (currais.size() == 0) {
	        return;
	    }

	    System.out.print("Digite o ID do Curral para buscar: ");
	    int idCurralBusca = teclado.nextInt();
	    teclado.nextLine();

	    Curral curralEncontrado = currais.stream()
	            .filter(c -> c.getIdCurral() == idCurralBusca)
	            .findFirst()
	            .orElse(null);

	    if (curralEncontrado != null) {
	        System.out.println("Curral encontrado:");
	        System.out.println("ID do Curral: " + curralEncontrado.getIdCurral());
	        System.out.println("Propósito: " + curralEncontrado.getProposito());
	        System.out.println("Tamanho: " + curralEncontrado.getTamanho());
	        System.out.println("Capacidade: " + curralEncontrado.getCapacidade());
	        System.out.println("------------------------");
	    } else {
	        System.out.println("Nenhum curral encontrado com o ID informado.");
	    }
	}


}
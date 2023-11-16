import java.util.List;
import java.util.Scanner;

class UML_Biblioteca {

	public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        listLivros listaDeLivros = new listLivros();
        listUsuario listaDeUsuario = new listUsuario(null, null);
        
        listaDeLivros.adicionarLivro(new Livro(0, "O Senhor dos Anéis", "J.R.R. Tolkien", true));
        listaDeLivros.adicionarLivro(new Livro(1, "Cem Anos de Solidão", "Gabriel García Márquez", true));
        listaDeLivros.adicionarLivro(new Livro(2, "Dom Quixote", "Miguel de Cervantes", true));
        listaDeLivros.adicionarLivro(new Livro(3, "1984", "George Orwell", true));
        listaDeLivros.adicionarLivro(new Livro(4, "Orgulho e Preconceito", "Jane Austen", true));
        
        listaDeUsuario.adicionarUsuario(new listUsuario("Luis", "26/03/2002"));
        listaDeUsuario.adicionarUsuario(new listUsuario("Beatriz", "17/04/2002"));

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo!");
            System.out.println();
            System.out.println("MENU");
            System.out.println("1 - Consultar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Consultar usuário");
            System.out.println("4 - Cadastrar usuário");
            System.out.println("5 - Registrar emprestimo/devolução");
            System.out.println("6 - Sair");
            System.out.println();
            System.out.print("Informe a opção desejada: ");
            System.out.println();

            int resp = sc.nextInt();
            System.out.println();
            
            if (resp == 1) {
                System.out.println("Livros na biblioteca: ");
                
                List<Livro> livros = listaDeLivros.getListaDeLivros();
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
                
                System.out.println();
            
            } else if (resp == 2) {
                System.out.print("Dados do livro (Índice, Nome, Autor): ");
                int indiceLivro = sc.nextInt();
                String nomeLivro = sc.next();
                String autorLivro = sc.next();

                Livro novoLivro = new Livro(indiceLivro, nomeLivro, autorLivro, true);

                listaDeLivros.adicionarLivro(novoLivro);
                System.out.println();

                System.out.println("Livro cadastrado com sucesso!");
                System.out.println(novoLivro);
                System.out.println();
            
            } else if (resp == 3) {
            	System.out.println("Alunos cadastrados: ");
            	List<listUsuario> alunos = listaDeUsuario.getLista();
            	for (listUsuario aluno : alunos) {
            		System.out.println(aluno);
            	}
            	
            	
            } else if (resp == 4) {
                System.out.println("Dados do aluno (Nome, Data de Nascimento): ");
                String nomeAluno = sc.next();
                String dataNascimento = sc.next();

                listUsuario novoAluno = new listUsuario(nomeAluno, dataNascimento);
                System.out.println();

                System.out.println("Aluno cadastrado com sucesso!");
                System.out.println(novoAluno);

                listaDeUsuario.adicionarUsuario(novoAluno);
                
            	
            } else if (resp == 5) {
              	List<Livro> livros = listaDeLivros.getListaDeLivros();
            		for (int i = 0; i < livros.size(); i++) {
                		Livro livro = livros.get(i);
                		System.out.println("Livro " + (i) + ": " + livro.getTitulo() + " (Status: " + livro.getStatus() + ")");}
            	
            		System.out.println("Informe o índice do livro que deseja emprestar/devolver: ");
            		int indiceLivro = sc.nextInt();
            		System.out.println();
            		
            		if (indiceLivro >= 0 && indiceLivro < livros.size()) {
                        Livro livroSelecionado = livros.get(indiceLivro);
                        System.out.println("Você selecionou o livro: " + livroSelecionado.getTitulo());
                        
        
                        
            			if (livroSelecionado.disponivel == true) {
            				livroSelecionado.setStatus(false);
            			}
            			else {
            				livroSelecionado.setStatus(true);
            			}
                        
            			System.out.println();
            			System.out.println("Status após a alteração de status:");
                        livros = listaDeLivros.getListaDeLivros();
                        for (int i = 0; i < livros.size(); i++) {
                            Livro livro = livros.get(i);
                            System.out.println("Livro " + (i) + ": " + livro.getTitulo() + " (Status: " + livro.getStatus() + ")");
                        }
                        
                    } else {
                        System.out.println("Índice não corresponde a nenhum livro cadastrado!");
                        System.out.println();
                    
            		}                             
                
            } else if (resp == 6) {
                continuar = false; 
            }

            System.out.println();
        }

        System.out.println("Programa encerrado!");
        sc.close();
    }
}
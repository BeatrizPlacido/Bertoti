import java.util.List;
import java.util.Scanner;

class UML_Biblioteca {

	public static void main(String[] args){
    	
        Scanner sc = new Scanner(System.in);
        listLivros listaDeLivros = new listLivros();
        listUsuario listaDeUsuario = new listUsuario();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo!");
            System.out.println("Menu");
            System.out.println("1 - Consultar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Consultar usuário");
            System.out.println("4 - Cadastrar usuário");
            System.out.println("5 - Registrar emprestimo/devolução");
            System.out.println("6 - Sair");
            System.out.print("Informe a opção desejada: ");

            int resp = sc.nextInt();

            if (resp == 1) {
                System.out.println("Livros na biblioteca: ");
                
                listaDeLivros.adicionarLivro(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", true));
                listaDeLivros.adicionarLivro(new Livro(2, "Cem Anos de Solidão", "Gabriel García Márquez", true));
                listaDeLivros.adicionarLivro(new Livro(3, "Dom Quixote", "Miguel de Cervantes", true));
                listaDeLivros.adicionarLivro(new Livro(4, "1984", "George Orwell", true));
                listaDeLivros.adicionarLivro(new Livro(5, "Orgulho e Preconceito", "Jane Austen", true));
                
                List<Livro> livros = listaDeLivros.listarLivros();
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
            
            } else if (resp == 2) {
                System.out.print("Dados do livro (Índice, Nome, Autor): ");
                int indiceLivro = sc.nextInt();
                String nomeLivro = sc.next();
                String autorLivro = sc.next();

                Livro novoLivro = new Livro(indiceLivro, nomeLivro, autorLivro, true);

                listaDeLivros.adicionarLivro(novoLivro);

                System.out.println("Livro cadastrado com sucesso!");
                System.out.println(novoLivro);
            
            } else if (resp == 3) {
            	System.out.println("Alunos cadastrados: ");
            	List<Usuario> alunos = listaDeUsuario.listarUsuario();
            	for (Usuario aluno : alunos) {
            		System.out.println(aluno);
            	}
            	
            	
            } else if (resp == 4) {
                System.out.println("Dados do aluno (Nome, Data de Nascimento): ");
                String nomeAluno = sc.next();
                String dataNascimento = sc.next();

                Usuario novoAluno = new Usuario(nomeAluno, dataNascimento);

                System.out.println("Aluno cadastrado com sucesso!");
                System.out.println(novoAluno);

                listaDeUsuario.adicionarUsuario(novoAluno);
                
            	
            } else if (resp == 5) {
              	List<Livro> livros = listaDeLivros.listarLivros();
            		for (int i = 0; i < livros.size(); i++) {
                		Livro livro = livros.get(i);
                		System.out.println("Livro " + (i) + ": " + livro.getTitulo() + " (Status: " + livro.getStatus() + ")");}
            	
            		System.out.println("Informe o índice do livro que deseja emprestar/devolver: ");
            		int indiceLivro = sc.nextInt();
            		
            		if (indiceLivro >= 0 && indiceLivro < livros.size()) {
                        Livro livroSelecionado = livros.get(indiceLivro);
                        System.out.println("Você selecionou o livro: " + livroSelecionado.getTitulo());
                        
            		
            			if (livroSelecionado.disponivel == true) {
            				livroSelecionado.setStatus(false);
            			}
            			else {
            				livroSelecionado.setStatus(true);
            			}
                        
            			
            			System.out.println("Após a alteração de status:");
                        livros = listaDeLivros.listarLivros();
                        for (int i = 0; i < livros.size(); i++) {
                            Livro livro = livros.get(i);
                            System.out.println("Livro " + (i) + ": " + livro.getTitulo() + " (Status: " + livro.getStatus() + ")");
                        }
                        
                    } else {
                        System.out.println("Índice fora dos limites.");
                    
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
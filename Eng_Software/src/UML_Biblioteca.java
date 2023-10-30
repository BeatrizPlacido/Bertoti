import java.util.List;
import java.util.Scanner;

class UML_Biblioteca {

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        listLivros listaDeLivros = new listLivros();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo!");
            System.out.println("Menu");
            System.out.println("1 - Consultar livro");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Sair");
            System.out.print("Informe a opção desejada: ");

            int resp = sc.nextInt();

            if (resp == 1) {
                System.out.println("Livros na biblioteca: ");
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
            	            	
                
            } else if (resp == 4) {
                continuar = false; 
            }

            System.out.println();
        }

        System.out.println("Programa encerrado!");
        sc.close();
    }
}
import java.util.ArrayList;
import java.util.List;

public class listLivros{
	
    private List<Livro> listaDeLivros;

    public listLivros() {
        listaDeLivros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        listaDeLivros.add(livro);
    }

    public List<Livro> listarLivros() {
        return listaDeLivros;
        
    }   
}
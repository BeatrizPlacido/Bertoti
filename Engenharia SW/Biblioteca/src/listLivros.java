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

	public List<Livro> getListaDeLivros() {
		return listaDeLivros; 
	}

	public void setListaDeLivros(List<Livro> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}
    
}
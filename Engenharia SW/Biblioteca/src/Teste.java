import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void test() {
		 listUsuario listaDeUsuario = new listUsuario("Luis", "26/03/2002");
		 listLivros listaDeLivros = new listLivros();
		
		//Testando métodos: getListaDeLivros e getUsuario
		 assertEquals(listaDeLivros.getListaDeLivros().size(), 0);
		 assertEquals(listaDeUsuario.getUsuario().size(), 0);
		 
		 
		 listaDeLivros.adicionarLivro(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", true));
		 listaDeUsuario.adicionarUsuario(new listUsuario("Luis", "26/03/2002"));
		 
		//Testando métodos: adicionarLivro e adicionarUsuario
	     assertEquals(listaDeUsuario.getUsuario().size(), 1);
	     assertEquals(listaDeLivros.getListaDeLivros().size(), 1);
	}

}

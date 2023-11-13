
public class Livro {
	
	public int indice;
	public String titulo;
	public String autor;
	public Boolean disponivel;
	
	public Livro(int indice, String titulo, String autor, Boolean status) {
		this.indice = indice;
		this.titulo = titulo;
		this.autor = autor;
		this.disponivel = status;
	}

	
	public int getIndice() {
		return indice;
	}

	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public Boolean getStatus() {
		return disponivel;
	}


	public void setStatus(Boolean status) {
		this.disponivel = status;
	}


	public String toString() {
        return "Livro [Índice: " + indice + ", Título: " + titulo + ", Autor: " + autor + ", Status: " + disponivel + "]";
    }
}

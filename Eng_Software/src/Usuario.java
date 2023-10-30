import java.text.SimpleDateFormat;
public class Usuario {

	public String nome;
	public SimpleDateFormat dataNascimento;
	
	public Usuario(String nome, SimpleDateFormat dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SimpleDateFormat getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(SimpleDateFormat dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}

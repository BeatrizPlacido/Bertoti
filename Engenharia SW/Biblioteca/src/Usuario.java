public class Usuario {

	public String nomeAluno;
	public String dataNascimento;
	
	public Usuario(String nomeAluno, String dataNascimento2) {
		this.nomeAluno = nomeAluno;
		this.dataNascimento = dataNascimento2;
	}
	
	public String getNome() {
		return nomeAluno;
	}

	public void setNome(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public void setDataNacimento(String dataNascimento) { 
	    this.dataNascimento = dataNascimento; 
	}
	
	public String toString() {
		return "Aluno [Nome: " + nomeAluno + ", Data de Nascimento: " + dataNascimento + "]";
	}
}


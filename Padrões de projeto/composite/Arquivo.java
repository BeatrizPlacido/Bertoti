public class Arquivo implements Component {
    private String nome;
    private int tamanho;
    
    public Arquivo(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
    
    @Override
    public void mostrarDetalhes() {
        System.out.println("Arquivo: " + nome + " (" + tamanho + " KB)");
    }
    
    @Override
    public int getTamanho() {
        return tamanho;
    }
}

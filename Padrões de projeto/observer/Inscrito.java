public class Inscrito implements Observer {
    private String nome;
    
    public Inscrito(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
    
    public String getNome() {
        return nome;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Pasta implements Component {
    private String nome;
    private List<Component> componentes = new ArrayList<>();
    
    public Pasta(String nome) {
        this.nome = nome;
    }
    
    public void adicionar(Component componente) {
        componentes.add(componente);
    }
    
    public void remover(Component componente) {
        componentes.remove(componente);
    }
    
    @Override
    public void mostrarDetalhes() {
        System.out.println("Pasta: " + nome + " (" + getTamanho() + " KB)");
        for (Component componente : componentes) {
            System.out.print("  ");
            componente.mostrarDetalhes();
        }
    }
    
    @Override
    public int getTamanho() {
        int tamanhoTotal = 0;
        for (Component componente : componentes) {
            tamanhoTotal += componente.getTamanho();
        }
        return tamanhoTotal;
    }
}

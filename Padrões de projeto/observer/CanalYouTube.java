import java.util.ArrayList;
import java.util.List;

public class CanalYouTube {
    private String nomeCanal;
    private List<Observer> inscritos = new ArrayList<>();
    
    public CanalYouTube(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }
    
    public void inscrever(Observer observer) {
        inscritos.add(observer);
        System.out.println("Novo inscrito no canal " + nomeCanal + "!");
    }
    
    public void desinscrever(Observer observer) {
        inscritos.remove(observer);
        System.out.println("Um inscrito saiu do canal " + nomeCanal);
    }
    
    public void publicarVideo(String tituloVideo) {
        System.out.println("\n[" + nomeCanal + "] Novo vídeo publicado: " + tituloVideo);
        notificarInscritos("Novo vídeo disponível: " + tituloVideo);
    }
    
    private void notificarInscritos(String mensagem) {
        for (Observer inscrito : inscritos) {
            inscrito.atualizar(mensagem);
        }
    }
}

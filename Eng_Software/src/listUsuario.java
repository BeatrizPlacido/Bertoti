import java.util.ArrayList;
import java.util.List;

public class listUsuario{
	
    private List<Usuario> listaDeUsuario;

    public listUsuario() {
        listaDeUsuario = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        listaDeUsuario.add(usuario);
    }

    public List<Usuario> listarUsusario() {
        return listaDeUsuario;
        
    }   
}

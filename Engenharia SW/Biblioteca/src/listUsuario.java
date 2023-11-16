import java.util.ArrayList;
import java.util.List;

public class listUsuario{

    private List<listUsuario> listaDeUsuario;

    public listUsuario(String string, String string2) {
        listaDeUsuario = new ArrayList<>();
    }

    public void adicionarUsuario(listUsuario usuario) {
        listaDeUsuario.add(usuario);
    }
  
    
    public List<listUsuario> getUsuario(){
    	return this.listaDeUsuario;
    }
    
	public List<listUsuario> getLista() {
		return listaDeUsuario; 
	}
}
  
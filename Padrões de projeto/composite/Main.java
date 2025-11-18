public class Main {
    public static void main(String[] args) {
        // Criando arquivos
        Arquivo arquivo1 = new Arquivo("documento.txt", 10);
        Arquivo arquivo2 = new Arquivo("foto.jpg", 150);
        Arquivo arquivo3 = new Arquivo("video.mp4", 500);
        Arquivo arquivo4 = new Arquivo("musica.mp3", 50);
        
        // Criando pastas
        Pasta pastaDocumentos = new Pasta("Documentos");
        pastaDocumentos.adicionar(arquivo1);
        
        Pasta pastaFotos = new Pasta("Fotos");
        pastaFotos.adicionar(arquivo2);
        
        Pasta pastaMultimidia = new Pasta("Multimidia");
        pastaMultimidia.adicionar(pastaFotos);
        pastaMultimidia.adicionar(arquivo3);
        pastaMultimidia.adicionar(arquivo4);
        
        // Pasta raiz
        Pasta raiz = new Pasta("Meus Arquivos");
        raiz.adicionar(pastaDocumentos);
        raiz.adicionar(pastaMultimidia);
        
        // Mostrando estrutura completa
        System.out.println("=== PADRÃO COMPOSITE - SISTEMA DE ARQUIVOS ===\n");
        raiz.mostrarDetalhes();
        
        System.out.println("\n=== TAMANHO TOTAL ===");
        System.out.println("Tamanho total da pasta raiz: " + raiz.getTamanho() + " KB");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PADRÃO OBSERVER - SISTEMA DE NOTIFICAÇÕES ===\n");
        
        // Criando canais do YouTube
        CanalYouTube canalTecnologia = new CanalYouTube("TechMaster");
        CanalYouTube canalGames = new CanalYouTube("GamersZone");
        
        // Criando inscritos
        Inscrito inscrito1 = new Inscrito("João");
        Inscrito inscrito2 = new Inscrito("Maria");
        Inscrito inscrito3 = new Inscrito("Pedro");
        
        // Inscrições
        System.out.println("--- INSCRIÇÕES ---");
        canalTecnologia.inscrever(inscrito1);
        canalTecnologia.inscrever(inscrito2);
        
        canalGames.inscrever(inscrito2);
        canalGames.inscrever(inscrito3);
        
        // Publicando vídeos
        canalTecnologia.publicarVideo("Como usar Padrões de Projeto em Java");
        
        canalGames.publicarVideo("Top 10 Jogos de 2024");
        
        // Nova inscrição
        System.out.println("\n--- NOVA INSCRIÇÃO ---");
        canalTecnologia.inscrever(inscrito3);
        
        // Mais publicações
        canalTecnologia.publicarVideo("Tutorial de Spring Boot");
        
        // Desinscrevendo
        System.out.println("\n--- DESINSCRIÇÃO ---");
        canalGames.desinscrever(inscrito2);
        
        canalGames.publicarVideo("Review: Novo Console");
    }
}

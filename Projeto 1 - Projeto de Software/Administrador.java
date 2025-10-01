// Administrador também herda de Usuario
public class Administrador extends Usuario {

    // 1. Construtor
    public Administrador(int id, String nome, String email, String senha) {
        // A única tarefa do construtor é chamar o construtor da classe mãe (Usuario)
        // para inicializar os atributos herdados.
        super(id, nome, email, senha);
    }

    // 2. Métodos específicos da responsabilidade do Administrador
    
    public void cadastrarDrone(Drone novoDrone) {
        // Em um sistema real, este método adicionaria o drone a uma lista ou banco de dados.
        // Aqui, vamos apenas simular a ação com uma mensagem no console.
        System.out.println("O administrador '" + this.getNome() + "' cadastrou um novo drone: " + novoDrone.getModelo() + " (ID: " + novoDrone.getId() + ").");
    }

    public void cadastrarArea(AreaAgricola novaArea) {
        System.out.println("O administrador '" + this.getNome() + "' cadastrou uma nova área: " + novaArea.getLocalizacao() + " (ID: " + novaArea.getId() + ").");
    }
    
    public void cadastrarUsuario(Usuario novoUsuario) {
        // Este método poderia criar tanto novos administradores quanto operadores
        System.out.println("O administrador '" + this.getNome() + "' cadastrou um novo usuário: " + novoUsuario.getNome() + ".");
    }

    // 3. Não há atributos específicos, então não precisamos de Getters/Setters novos.
    //    Todos os getters/setters de Usuario (getNome(), getEmail(), etc.) são herdados automaticamente.
}
// Administrador herda de Usuario
public class Administrador extends Usuario {

    //Construtor
    public Administrador(int id, String nome, String email, String senha) {
        //Chamar o construtor da classe mãe (Usuario) para inicializar os atributos herdados.
        super(id, nome, email, senha);
    }
    
    public void cadastrarDrone(Drone novoDrone) {
        //simular a ação com uma mensagem no console.
        System.out.println("O administrador '" + this.getNome() + "' cadastrou um novo drone: " + novoDrone.getModelo() + " (ID: " + novoDrone.getId() + ").");
    }

    public void cadastrarArea(AreaAgricola novaArea) {
        System.out.println("O administrador '" + this.getNome() + "' cadastrou uma nova área: " + novaArea.getLocalizacao() + " (ID: " + novaArea.getId() + ").");
    }
    
    public void cadastrarUsuario(Usuario novoUsuario) {
        //Cadastra novos usuarios caso necessario
        System.out.println("O administrador '" + this.getNome() + "' cadastrou um novo usuário: " + novoUsuario.getNome() + ".");
    }
}

public abstract class Usuario {

    // 1. Atributos comuns a todos os tipos de usuários
    private int id;
    private String nome;
    private String email;
    private String senha; // Em um sistema real, isso seria um hash seguro

    // 2. Construtor que será chamado pelas classes filhas
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // 3. Métodos comuns a todos os usuários
    public boolean login(String email, String senha) {
        // Lógica de simulação de login
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Login bem-sucedido para o usuário: " + this.nome);
            return true;
        }
        System.out.println("Falha no login: email ou senha incorretos.");
        return false;
    }

    public void logout() {
        System.out.println("Usuário " + this.nome + " deslogado.");
    }

    // 4. Getters e Setters para acesso controlado
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Não é comum ter um getter para a senha, mas o setter é útil
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
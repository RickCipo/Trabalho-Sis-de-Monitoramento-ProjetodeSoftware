import java.util.Date;

/**
 * Representa um Operador de Drone no sistema.
 * Esta classe herda as características comuns de Usuario e adiciona
 * atributos e comportamentos específicos para a operação de drones.
 */
public class OperadorDrone extends Usuario {

    // 1. Atributo específico desta classe
    private String licencaVoo;

    /**
     * Construtor da classe OperadorDrone.
     * @param id O ID do usuário.
     * @param nome O nome do usuário.
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @param licencaVoo A licença de voo específica do operador.
     */
    public OperadorDrone(int id, String nome, String email, String senha, String licencaVoo) {
        // A primeira linha DEVE ser a chamada ao construtor da classe mãe (Usuario)
        // para inicializar os atributos herdados (id, nome, email, senha).
        super(id, nome, email, senha);
        
        // Depois, inicializa os atributos próprios desta classe.
        this.licencaVoo = licencaVoo;
    }

    // 3. Métodos que definem as responsabilidades do Operador de Drone
    
    /**
     * Tenta agendar uma nova missão de voo.
     * Verifica a disponibilidade do drone e, se estiver disponível, cria e retorna a missão.
     * @param dataHora A data e hora desejada para a missão.
     * @param drone O drone que será usado na missão.
     * @param area A área agrícola onde a missão ocorrerá.
     * @return O objeto MissaoVoo se o agendamento for bem-sucedido, ou null caso contrário.
     */
    public MissaoVoo agendarMissaoVoo(Date dataHora, Drone drone, AreaAgricola area) {
        System.out.println("O operador " + getNome() + " está tentando agendar uma missão...");
        
        if (drone.verificarDisponibilidade(dataHora)) {
            // Em um sistema real, o ID da missão seria gerado pelo banco de dados.
            int idMissao = (int) (Math.random() * 10000); 
            
            MissaoVoo novaMissao = new MissaoVoo(idMissao, dataHora, drone, area);
            drone.adicionarMissao(novaMissao);
            
            System.out.println("SUCESSO: Missão " + idMissao + " agendada para o drone '" + drone.getModelo() + "'.");
            return novaMissao;
        } else {
            System.out.println("FALHA: O drone '" + drone.getModelo() + "' não está disponível nesta data.");
            return null;
        }
    }

    /**
     * Simula o cancelamento de uma missão de voo.
     * @param missaoId O ID da missão a ser cancelada.
     */
    public void cancelarMissaoVoo(int missaoId) {
        System.out.println("O operador " + getNome() + " cancelou a missão " + missaoId + ".");
        // Aqui entraria a lógica para encontrar e remover a missão da lista do drone.
    }

    /**
     * Associa os dados coletados a uma missão concluída.
     * @param missao A missão que gerou os dados.
     * @param dados Os dados que foram coletados.
     */
    public void registrarDadosColetados(MissaoVoo missao, DadosColetados dados) {
        missao.setDadosColetados(dados);
        System.out.println("O operador " + getNome() + " registrou os dados para a missão " + missao.getId() + ".");
    }

    // 4. Getter e Setter para o atributo específico desta classe
    public String getLicencaVoo() {
        return licencaVoo;
    }

    public void setLicencaVoo(String licencaVoo) {
        this.licencaVoo = licencaVoo;
    }
}
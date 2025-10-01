import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa um Drone no sistema de monitoramento.
 * Contém informações sobre o drone e gerencia sua agenda de missões.
 */
public class Drone {

    // 1. Atributos privados, como definido no diagrama
    private int id;
    private String modelo;
    private String status;
    
    // Este atributo representa a associação "1 para Muitos" com a classe MissaoVoo
    private List<MissaoVoo> missoesAgendadas;

    /**
     * Construtor para criar um novo objeto Drone.
     * @param id O ID do drone.
     * @param modelo O modelo do drone.
     */
    public Drone(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.status = "Disponível"; // Define um status inicial padrão
        this.missoesAgendadas = new ArrayList<>(); // Inicializa a lista para evitar erros
    }

    // 2. Métodos de Lógica de Negócio
    
    /**
     * Verifica se o drone já tem uma missão agendada para a data e hora especificadas.
     * @param dataDaNovaMissao A data e hora para verificar.
     * @return true se o drone estiver disponível, false caso contrário.
     */
    public boolean verificarDisponibilidade(Date dataDaNovaMissao) {
        for (MissaoVoo missaoExistente : this.missoesAgendadas) {
            if (missaoExistente.getDataHora().equals(dataDaNovaMissao)) {
                return false; // Drone ocupado
            }
        }
        return true; // Drone disponível
    }

    /**
     * Adiciona uma missão à lista de missões agendadas para este drone.
     * @param novaMissao O objeto da nova missão a ser adicionada.
     */
    public void adicionarMissao(MissaoVoo novaMissao) {
        this.missoesAgendadas.add(novaMissao);
    }

    // 3. Getters e Setters para acesso controlado aos atributos
    
    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<MissaoVoo> getMissoesAgendadas() {
        return missoesAgendadas;
    }
}
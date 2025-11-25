package model;
import java.util.Date;

public class OperadorDrone extends Usuario {

    //Atributo específico desta classe
    private String licencaVoo;

    public OperadorDrone(int id, String nome, String email, String senha, String licencaVoo) {
        //Chama a Classe mãe para receber os atributos
        super(id, nome, email, senha);
        
        // Depois, inicializa os atributos próprios desta classe.
        this.licencaVoo = licencaVoo;
    }

    //Métodos que definem as responsabilidades do Operador de Drone

    public MissaoVoo agendarMissaoVoo(Date dataHora, Drone drone, AreaAgricola area) {
        System.out.println("O operador " + getNome() + " está tentando agendar uma missão...");
        
        if (drone.verificarDisponibilidade(dataHora)) {
            //Colocamos um numero aleatório pois o número da missão seria dado pelo banco de dados
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

    //Simula um cancelamento de voo
    public void cancelarMissaoVoo(int missaoId) {
        System.out.println("O operador " + getNome() + " cancelou a missão " + missaoId + ".");
        // Aqui entraria a lógica para encontrar e remover a missão da lista do drone.
    }

    //Regista os dados coletados
    public void registrarDadosColetados(MissaoVoo missao, DadosColetados dados) {
        missao.setDadosColetados(dados);
        System.out.println("O operador " + getNome() + " registrou os dados para a missão " + missao.getId() + ".");
    }

    //Getter e Setter para o atributo específico desta classe
    public String getLicencaVoo() {
        return licencaVoo;
    }

    public void setLicencaVoo(String licencaVoo) {
        this.licencaVoo = licencaVoo;
    }

}

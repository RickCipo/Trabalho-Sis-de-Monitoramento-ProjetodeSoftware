import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO SIMULAÇÃO COMPLETA DO SISTEMA DE DRONES ---");

        // Roteiro Principal:

        // 0. Crie as ferramentas necessárias para o sistema funcionar
        DadosRepositorio repositorio = new DadosRepositorio();

        // 1. Crie um Administrador
        System.out.println("\n[PASSO 1] Um Administrador entra no sistema.");
        Administrador admin = new Administrador(1, "Ana Gerente", "ana.admin@coop.com", "admin123");

        // 2. Use o Administrador para cadastrar os ativos da cooperativa
        System.out.println("\n[PASSO 2] O Administrador cadastra os ativos (Drone e Área).");
        Drone drone1 = new Drone(101, "AgroDrone V2");
        AreaAgricola area1 = new AreaAgricola(501, "Campo de Soja da Serra", "Soja", 150.5f);
        admin.cadastrarDrone(drone1);
        admin.cadastrarArea(area1);

        // 3. Crie um Operador de Drone
        System.out.println("\n[PASSO 3] Um Operador de Drone entra no sistema.");
        OperadorDrone operador = new OperadorDrone(2, "Beto Piloto", "beto.op@coop.com", "op123", "OP-DRN-789");

        // 4. Use o Operador para agendar uma missão, usando os ativos já cadastrados
        System.out.println("\n[PASSO 4] O Operador agenda uma nova missão.");
        Date dataDaMissao = new Date(); // Simula o agendamento para o momento atual
        MissaoVoo missaoAgendada = operador.agendarMissaoVoo(dataDaMissao, drone1, area1);

        // 5. Verifique se a missão foi criada e simule sua execução
        if (missaoAgendada != null) {
            System.out.println("\n[PASSO 5] Simulando a execução da missão agendada...");
            missaoAgendada.iniciarMissao();

            // Aqui você poderia simular uma pausa...

            missaoAgendada.concluirMissao();

            // 6. Crie um pacote de dados simulados para a missão concluída
            System.out.println("\n[PASSO 6] Missão concluída. Gerando dados coletados...");
            DadosColetados dadosDaMissao = new DadosColetados(
                missaoAgendada.getId(), // Usando o mesmo ID da missão para fácil referência
                28.5f, 
                55.8f, 
                "http://imagens.coop/soja_serra_01102025.png"
            );
            
            // 7. Associe os dados coletados à missão
            missaoAgendada.setDadosColetados(dadosDaMissao);
            System.out.println("Dados associados à missão: " + missaoAgendada.getId());
            
            // 8. Use o Repositório para salvar os dados coletados
            System.out.println("\n[PASSO 7] Salvando os dados no repositório...");
            repositorio.salvar(dadosDaMissao);

            // 9. Use o Repositório para buscar os dados e provar que foram salvos
            System.out.println("\n[PASSO 8] Verificando se os dados foram salvos corretamente.");
            repositorio.buscarPorId(missaoAgendada.getId());
            
        } else {
            System.out.println("A simulação não pôde prosseguir pois a missão não foi agendada.");
        }
        
        repositorio.listarTodos();

        System.out.println("\n--- SIMULAÇÃO CONCLUÍDA ---");
    }
}
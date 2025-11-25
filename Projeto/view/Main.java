package view;

import java.util.Date;

import model.*;
import dao.*; // Importa todos os DAOs (Area, Missao, Drone, Dados)

public class Main {

    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE DRONES: FLUXO COMPLETO ---");

        // 1. Instanciar Atores
        Administrador admin = new Administrador(1, "Ana Admin", "ana@coop.com", "123");
        OperadorDrone operador = new OperadorDrone(2, "Beto Op", "beto@coop.com", "123", "LIC-99");

        // 2. Criar Objetos
        // IDs aleatórios para evitar erro de duplicidade nos testes
        int idDrone = (int) (System.currentTimeMillis() % 1000); 
        int idArea = 500 + (int) (System.currentTimeMillis() % 100); 

        Drone drone = new Drone(idDrone, "AgroDrone-" + idDrone);
        AreaAgricola area = new AreaAgricola(idArea, "Fazenda Norte", "Milho", 200f);

        // --- SALVANDO NO BANCO (ORDEM IMPORTA!) ---
        
        // A) Salvar Drone (DAO)
        DroneDAO droneDao = new DroneDAO();
        droneDao.salvar(drone);
        
        // B) Salvar Área (DAO) - NOVIDADE
        AreaAgricolaDAO areaDao = new AreaAgricolaDAO();
        areaDao.salvar(area); // Se não salvar a área, a missão falha

        // 3. Agendar Missão (Lógica Java)
        MissaoVoo missao = operador.agendarMissaoVoo(new Date(), drone, area);

        if (missao != null) {
            // C) Salvar Missão no Banco (DAO) - NOVIDADE
            // É CRUCIAL salvar a missão ANTES de salvar os dados coletados
            MissaoDAO missaoDao = new MissaoDAO();
            missaoDao.salvar(missao);

            // 4. Executar e Coletar
            missao.iniciarMissao();
            missao.concluirMissao();

            DadosColetados dados = new DadosColetados(missao.getId(), 30.5f, 60.2f, "http://img.com/foto.jpg");
            missao.setDadosColetados(dados);

            // D) Salvar Dados Coletados (DAO)
            System.out.println(">>> Salvando dados finais...");
            DadosColetadosDAO dadosDao = new DadosColetadosDAO();
            dadosDao.salvar(dados);
        }
    }
}
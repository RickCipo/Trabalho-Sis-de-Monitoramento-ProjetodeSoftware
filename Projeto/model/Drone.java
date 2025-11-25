package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Drone {

    //Atributos privados, como definido no diagrama
    private int id;
    private String modelo;
    private String status;
    
    //Este atributo representa a associação "1 para Muitos" com a classe MissaoVoo
    private List<MissaoVoo> missoesAgendadas;

    public Drone(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.status = "Disponível"; // Define um status inicial padrão
        this.missoesAgendadas = new ArrayList<>(); // Inicializa a lista para evitar erros
    }

    //Métodos de Lógica de Negócio

    public boolean verificarDisponibilidade(Date dataDaNovaMissao) {
        for (MissaoVoo missaoExistente : this.missoesAgendadas) {
            if (missaoExistente.getDataHora().equals(dataDaNovaMissao)) {
                return false; // Drone ocupado
            }
        }
        return true; // Drone disponível
    }

    public void adicionarMissao(MissaoVoo novaMissao) {
        this.missoesAgendadas.add(novaMissao);
    }

    //Getters e Setters para acesso controlado aos atributos
    
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

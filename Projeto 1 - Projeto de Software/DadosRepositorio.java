//Criamos esse arquivo para organizar mais facilmente o programa, separa as responsabilidades: DadosColetados apenas representa os dados, e DadosRepositorio gerencia como e onde salvá-los.

import java.util.ArrayList;
import java.util.List;

public class DadosRepositorio {

    //Usando uma lista para simular um banco de dados em memória
    private List<DadosColetados> bancoDeDadosSimulado;

    //Construtor que inicializa nosso "banco de dados"
    public DadosRepositorio() {
        this.bancoDeDadosSimulado = new ArrayList<>();
        System.out.println("Repositório de dados inicializado.");
    }

    //Método para salvar os dados (adicionar na lista)
    public void salvar(DadosColetados dados) {
        System.out.println("Salvando dados no repositório...");
        this.bancoDeDadosSimulado.add(dados);
        System.out.println("Dados salvos com sucesso! ID: " + dados.getId());
    }

    //Método para buscar os dados pelo seu ID
    public DadosColetados buscarPorId(int id) {
        System.out.println("Buscando dados com ID: " + id);
        for (DadosColetados dados : this.bancoDeDadosSimulado) {
            if (dados.getId() == id) {
                System.out.println("Dados encontrados: " + dados.toString());
                return dados;
            }
        }
        System.out.println("Dados com ID " + id + " não foram encontrados.");
        return null; // Retorna nulo se não encontrar
    }
    
    // Método extra para listar todos os dados salvos
    public void listarTodos() {
        System.out.println("\n--- Listando todos os dados no repositório ---");
        if (bancoDeDadosSimulado.isEmpty()) {
            System.out.println("Nenhum dado salvo.");
        } else {
            for (DadosColetados dados : bancoDeDadosSimulado) {
                System.out.println(dados.toString());
            }
        }
        System.out.println("---------------------------------------------");
    }

}


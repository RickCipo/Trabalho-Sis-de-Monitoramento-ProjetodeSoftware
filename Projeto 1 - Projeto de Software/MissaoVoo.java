import java.util.Date;

public class MissaoVoo {

    //Atributos privados
    private int id;
    private Date dataHora;
    private String status;
    
    // Atributos que representam as associações com outras classes
    private Drone drone;
    private AreaAgricola area;
    private DadosColetados dadosColetados; // Ligação para os dados que serão gerados

    //Construtor para criar uma nova missão
    public MissaoVoo(int id, Date dataHora, Drone drone, AreaAgricola area) {
        this.id = id;
        this.dataHora = dataHora;
        this.drone = drone;
        this.area = area;
        this.status = "Agendada"; // Toda nova missão começa com o status "Agendada"
        this.dadosColetados = null; // Os dados ainda não existem
    }

    //Métodos de negócio para controlar o ciclo de vida da missão
    public void iniciarMissao() {
        if (this.status.equals("Agendada")) {
            this.status = "Em andamento";
            System.out.println("Missão " + this.id + " iniciada na área " + this.area.getLocalizacao());
        } else {
            System.out.println("Atenção: A missão " + this.id + " não pode ser iniciada, pois seu status é '" + this.status + "'.");
        }
    }

    public void concluirMissao() {
        if (this.status.equals("Em andamento")) {
            this.status = "Concluída";
            System.out.println("Missão " + this.id + " concluída.");
        } else {
            System.out.println("Atenção: A missão " + this.id + " não pode ser concluída, pois seu status é '" + this.status + "'.");
        }
    }

    //Getters e Setters para acesso controlado
    public int getId() {
        return id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public String getStatus() {
        return status;
    }

    public Drone getDrone() {
        return drone;
    }

    public AreaAgricola getArea() {
        return area;
    }

    public DadosColetados getDadosColetados() {
        return dadosColetados;
    }

    // Setter específico para associar os dados após a coleta
    public void setDadosColetados(DadosColetados dadosColetados) {
        this.dadosColetados = dadosColetados;
    }

}

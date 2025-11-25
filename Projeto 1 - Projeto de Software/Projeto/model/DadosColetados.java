package model;

public class DadosColetados {

    //Atributos privados
    private int id;
    private float temperatura;
    private float umidade;
    private String imagemUrl;

    //Construtor para criar o "pacote" de dados
    public DadosColetados(int id, float temperatura, float umidade, String imagemUrl) {
        this.id = id;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.imagemUrl = imagemUrl;
    }

    //Getters e Setters para que outras classes possam ler e modificar os dados
    public int getId() {
        return id;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
    
    //Método toString para facilitar a visualização dos dados
    @Override
    public String toString() {
        return "DadosColetados {" +
                "id=" + id +
                ", temperatura=" + temperatura + "°C" +
                ", umidade=" + umidade + "%" +
                ", imagemUrl='" + imagemUrl + '\'' +
                '}';
    }
}


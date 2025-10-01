public class AreaAgricola {

    // 1. Atributos privados para garantir o encapsulamento
    private int id;
    private String localizacao;
    private String tipoCultivo;
    private float tamanho;

    // 2. Construtor para criar e inicializar um objeto AreaAgricola
    public AreaAgricola(int id, String localizacao, String tipoCultivo, float tamanho) {
        this.id = id;
        this.localizacao = localizacao;
        this.tipoCultivo = tipoCultivo;
        this.tamanho = tamanho;
    }

    // 3. Getters e Setters para acesso controlado aos atributos
    public int getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
}
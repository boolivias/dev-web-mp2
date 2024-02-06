package model;

public class LinhaOnibus {
    public int id;
    public String nome;
    public int lotacao;
    public double gastoPorKm;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getLotacao() {
        return lotacao;
    }
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    public double getGastoPorKm() {
        return gastoPorKm;
    }
    public void setGastoPorKm(double gastoPorKm) {
        this.gastoPorKm = gastoPorKm;
    }
}

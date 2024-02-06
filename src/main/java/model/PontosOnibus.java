package model;

public class PontosOnibus {
    public int id;
    public int linha_id;
    public LinhaOnibus linha;
    public int min_previsao;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLinha_id() {
        return linha_id;
    }
    public void setLinha_id(int linha_id) {
        this.linha_id = linha_id;
    }
    public void setLinha(LinhaOnibus linhaOnibus) {
        this.linha = linhaOnibus;
    }
    public LinhaOnibus getLinha() {
        return linha;
    }
    public int getMin_previsao() {
        return min_previsao;
    }
    public void setMin_previsao(int min_previsao) {
        this.min_previsao = min_previsao;
    }
}

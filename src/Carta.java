
public class Carta {
    private String titulo;
    private String descricao;
    private String tipo;
    private String raridade;
    private String colecao;
    private int poder;
    private int vida;
    private int custoDeMana;

    public Carta(String titulo, String descricao, String tipo, String raridade, String colecao, int poder, int vida, int custoDeMana) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.raridade = raridade;
        this.colecao = colecao;
        this.poder = poder;
        this.vida = vida;
        this.custoDeMana = custoDeMana;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaridade() {
        return raridade;
    }

    public String getColecao() {
        return colecao;
    }

    public int getPoder() {
        return poder;
    }

    public int getVida() {
        return vida;
    }

    public int getCustoDeMana() {
        return custoDeMana;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raridade='" + raridade + '\'' +
                ", colecao='" + colecao + '\'' +
                ", poder=" + poder +
                ", vida=" + vida +
                ", custoDeMana=" + custoDeMana +
                '}';
    }
}
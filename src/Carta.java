import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Carta implements DadosPersistentes, Serializable {
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

    @Override
    public void salvar(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        }
    }
    
    @Override
    public void carregar(String filePath) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Carta carta = (Carta) ois.readObject();
            this.titulo = carta.titulo;
            this.descricao = carta.descricao;
            this.tipo = carta.tipo;
            this.raridade = carta.raridade;
            this.colecao = carta.colecao;
            this.poder = carta.poder;
            this.vida = carta.vida;
            this.custoDeMana = carta.custoDeMana;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
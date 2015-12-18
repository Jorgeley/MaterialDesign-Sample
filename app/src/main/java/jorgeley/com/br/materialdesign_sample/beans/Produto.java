package jorgeley.com.br.materialdesign_sample.beans;

/**
 * Bean Usuario
 */
public class Produto implements Comparable{
    private int id;
    private String nome;
    private double preco;
    private int img;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return this.nome;
    }
    @Override
    public boolean equals(Object o) {
        return (this.id == ((Produto)o).getId());
    }

    @Override
    public int compareTo(Object o) {
        if (this.id < ((Produto)o).getId())
            return -1;
        else if (this.id == ((Produto)o).getId())
            return 0;
        else
            return 1;
    }

}
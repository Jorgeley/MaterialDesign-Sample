package nasuakza.com.br.nasuakz.beans;

/**
 * Bean Usuario
 */
public class Marca implements Comparable{
    private int id;
    private String nome;
    private int logo;

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

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }


    @Override
    public String toString() {
        return this.nome;
    }
    @Override
    public boolean equals(Object o) {
        return (this.id == ((Marca)o).getId());
    }

    @Override
    public int compareTo(Object o) {
        if (this.id < ((Marca)o).getId())
            return -1;
        else if (this.id == ((Marca)o).getId())
            return 0;
        else
            return 1;
    }

}
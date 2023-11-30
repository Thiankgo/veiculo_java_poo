public class Onibus extends Veiculo {
    protected int assentos;

    public Onibus(String nome, String placa, int ano, int assentos) {
        super(nome, placa, ano);
        this.image = "img/bus.png";
        this.assentos = assentos;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }
}

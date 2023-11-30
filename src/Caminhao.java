public class Caminhao extends Veiculo {
    protected int eixos;

    public Caminhao(String nome, String placa, int ano, int eixos) {
        super(nome, placa, ano);
        this.image = "img/truck.png";
        this.eixos = eixos;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }
}

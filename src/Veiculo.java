import java.awt.*;

public class Veiculo {
    protected String nome;
    protected String placa;
    protected  String image = "img/car.png";
    protected int ano;

    public Veiculo(String nome, String placa, int ano) {
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void desenhar(Graphics g) {
        Image imagem = Toolkit.getDefaultToolkit().getImage("img/car.png");
        g.drawImage(imagem, 500, 500, 500, 500, null);
    }
}

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class VeiculoCellRenderer extends JPanel implements ListCellRenderer<Veiculo> {
    private JLabel imagemLabel = new JLabel();
    private JLabel infoLabel = new JLabel();

    public VeiculoCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 50, 20));
        add(imagemLabel, BorderLayout.WEST);
        add(infoLabel, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Veiculo> list, Veiculo value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        imagemLabel.setIcon(new ImageIcon(value.image)); // Substitua com seu método para obter o ícone do veículo
        infoLabel.setText("<html><b>" + "</b><br>Nome: " +
                value.getNome() + "</b><br>Placa: " +
                value.getPlaca() + "<br>Ano: " + value.getAno() + "</html>");

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);

        return this;
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static DefaultListModel<Veiculo> listModel;
    static private JComboBox<String> listaVeiculos;
    static private String currentVehicle;
    static private JTextField nomeText, placaText, anoText;
    static private JLabel assentosLabel, eixosLabel;
    static private JTextField assentosText, eixosText;
    static private JPanel inputPanel;

    public static void main(String[] args) {
        listModel = new DefaultListModel<>();
        JList<Veiculo> veiculoList = new JList<>(listModel);
        veiculoList.setCellRenderer(new VeiculoCellRenderer());

        listaVeiculos = new JComboBox<>(new String[]{"Carro", "Onibus", "Caminhão"});
        listaVeiculos.addActionListener(e -> updateVehicle((String) listaVeiculos.getSelectedItem()));

        nomeText = new JTextField("Gol");
        placaText = new JTextField("BRA2E19");
        anoText = new JTextField("2023");
        assentosText = new JTextField("5");
        eixosText = new JTextField("2");

        JButton addButton = getButton();

        inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.add(new JLabel("Selecione o tipo de veículo:"));
        inputPanel.add(listaVeiculos);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeText);
        inputPanel.add(new JLabel("Placa:"));
        inputPanel.add(placaText);
        inputPanel.add(new JLabel("Ano:"));
        inputPanel.add(anoText);

        assentosText = new JTextField("42");
        assentosLabel = new JLabel("Assentos:");
        inputPanel.add(assentosLabel);
        inputPanel.add(assentosText);
        assentosText.setVisible(false);
        assentosLabel.setVisible(false);

        eixosText = new JTextField("3");
        eixosLabel = new JLabel("Eixos:");
        inputPanel.add(eixosLabel);
        inputPanel.add(eixosText);
        eixosText.setVisible(false);
        eixosLabel.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(veiculoList);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(addButton, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Lista de Veículos");
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton getButton() {
        JButton addButton = new JButton("Adicionar Veículo");
        addButton.setPreferredSize(new Dimension(200, 25));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeText.getText();
                String placa = placaText.getText();
                int ano = Integer.parseInt(anoText.getText());

                if ("Onibus".equals(currentVehicle)) {
                    int assentos = Integer.parseInt(assentosText.getText());
                    Onibus novoOnibus = new Onibus(nome, placa, ano, assentos);
                    listModel.addElement(novoOnibus);
                } else if ("Caminhão".equals(currentVehicle)) {
                    int eixos = Integer.parseInt(eixosText.getText());
                    Caminhao novoCaminhao = new Caminhao(nome, placa, ano, eixos);
                    listModel.addElement(novoCaminhao);
                } else {
                    Veiculo novoVeiculo = new Veiculo(nome, placa, ano);
                    listModel.addElement(novoVeiculo);
                }
            }
        });
        return addButton;
    }

    static private void updateVehicle(String tipoVeiculo) {
        currentVehicle = tipoVeiculo;

        if ("Onibus".equals(tipoVeiculo)) {
            assentosText.setVisible(true);
            assentosLabel.setVisible(true);

            eixosText.setVisible(false);
            eixosLabel.setVisible(false);
        } else if ("Caminhão".equals(tipoVeiculo)) {
            assentosText.setVisible(false);
            assentosLabel.setVisible(false);

            eixosText.setVisible(true);
            eixosLabel.setVisible(true);
        } else {
            assentosText.setVisible(false);
            assentosLabel.setVisible(false);

            eixosText.setVisible(false);
            eixosLabel.setVisible(false);
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    static class VeiculoCellRenderer extends JPanel implements ListCellRenderer<Veiculo> {
        private final JLabel imagemLabel = new JLabel();
        private final JLabel infoLabel = new JLabel();

        public VeiculoCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.LEFT, 50, 20));
            add(imagemLabel, BorderLayout.WEST);
            add(infoLabel, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Veiculo> list, Veiculo value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            imagemLabel.setIcon(new ImageIcon(value.image)); // Substitua com seu método para obter o ícone do veículo

            if (value instanceof Onibus) {
                infoLabel.setText("Nome: " + value.getNome() + "    Placa: " + value.getPlaca() + "    Ano: " + value.getAno()+ "    Assentos: " + ((Onibus) value).getAssentos());
            } else if (value instanceof Caminhao) {
                infoLabel.setText("Nome: " + value.getNome() + "    Placa: " + value.getPlaca() + "    Ano: " + value.getAno()+ "    Eixos: " + ((Caminhao) value).getEixos());
            } else {
                infoLabel.setText("Nome: " + value.getNome() + "    Placa: " + value.getPlaca() + "    Ano: " + value.getAno());
            }

            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);

            return this;
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static DefaultListModel<Veiculo> listModel;

    static private JComboBox<String> listaVeiculos;

    static private String currentVehicle;
    static private JTextField nomeText, placaText, anoText;
    public static void main(String[] args) {
        listModel = new DefaultListModel<>();
        JList<Veiculo> veiculoList = new JList<>(listModel);
        veiculoList.setCellRenderer(new VeiculoCellRenderer());

        listaVeiculos = new JComboBox<>(new String[]{"Carro", "Onibus", "Caminhão"});
        listaVeiculos.setBounds(300, 10, 160, 25);
        listaVeiculos.addActionListener(e -> updateVehicle((String) listaVeiculos.getSelectedItem()));

        JButton addButton = getButton();

        JScrollPane scrollPane = new JScrollPane(veiculoList);
        scrollPane.setBounds(0, 200, 600, 1000);

        JFrame frame = new JFrame("Lista de Veículos");
        frame.setLayout(new BorderLayout());
        frame.add(listaVeiculos);
        frame.add(addButton);
        frame.add(scrollPane);
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    private static JButton getButton() {
        JButton addButton = new JButton("Adicionar Veículo");
        addButton.setBounds(10, 10, 200, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona um novo veículo à lista
                Veiculo novoVeiculo = new Veiculo("Modelo " + (listModel.getSize() + 1),
                        "ABC123" + (listModel.getSize() + 1),
                        2022);
                listModel.addElement(novoVeiculo);
            }
        });
        return addButton;
    }
    static private void updateVehicle(String tipoVeículo) {
        currentVehicle = tipoVeículo;
    }
}
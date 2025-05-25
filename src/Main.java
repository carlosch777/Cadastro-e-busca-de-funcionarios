import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;  // Importa os componentes gráficos do Swing
import java.awt.*;      // Importa as classes necessárias para layout e design
import java.awt.event.ActionEvent; // Importa eventos de ação
import java.awt.event.ActionListener; // Importa o listener para eventos de ação
import java.util.ArrayList; // Importa a classe ArrayList para usar uma lista dinâmica de pessoas

public class Main extends JFrame {
    private JTextField nomeField;
    private JFormattedTextField idField;
    private JComboBox<String> cargoField;
    private JFormattedTextField salarioField;

    private JFormattedTextField bonusField = new JFormattedTextField();
    private JFormattedTextField produtosField = new JFormattedTextField();
    private JFormattedTextField horasField = new JFormattedTextField();
    private JFormattedTextField valorField = new JFormattedTextField();
    private JFormattedTextField comissaoField = new JFormattedTextField();
    private JFormattedTextField vendasField = new JFormattedTextField();

    private JButton cadastrarButton, buscarButton;

    private JPanel painel; // painel principal onde fica tudo
    private ArrayList<Funcionario> listapessoas;
    private JTextArea listapessoasarea;

    public Main() {
        listapessoas = new ArrayList<>();

        setTitle("Cadastrar Funcionário");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        painel = new JPanel();
        painel.setLayout(new GridLayout(0, 2, 5, 5)); // múltiplas linhas, 2 colunas

        nomeField = new JTextField();
        idField = new JFormattedTextField();
        salarioField = new JFormattedTextField();
        cargoField = new JComboBox<>();
        cargoField.addItem("Gerente");
        cargoField.addItem("Vendedor");
        cargoField.addItem("Operador");
        cargoField.addItem("Estágiario");

        cadastrarButton = new JButton("Cadastrar");
        buscarButton = new JButton("Buscar");
        listapessoasarea = new JTextArea(10, 30);
        listapessoasarea.setEditable(false);

        // Adiciona campos fixos
        painel.add(new JLabel("Nome:"));
        painel.add(nomeField);
        painel.add(new JLabel("ID:"));
        painel.add(idField);
        painel.add(new JLabel("Cargo:"));
        painel.add(cargoField);
        painel.add(new JLabel("Salário:"));
        painel.add(salarioField);

        // Espaço para campos extras, vamos adicionar dinamicamente aqui
        // Cria um painel auxiliar para os campos extras
        JPanel extrasPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        painel.add(new JLabel("Extras:"));
        painel.add(extrasPanel);

        painel.add(cadastrarButton);
        painel.add(buscarButton);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(listapessoasarea), BorderLayout.CENTER);

        // Quando cargo mudar, atualiza os campos extras
        cargoField.addActionListener(e -> {
            extrasPanel.removeAll(); // limpa campos extras
            String cargo = (String) cargoField.getSelectedItem();
            if (cargo.equals("Gerente")) {
                extrasPanel.add(new JLabel("Bonus:"));
                extrasPanel.add(bonusField);
            } else if (cargo.equals("Vendedor")) {
                extrasPanel.add(new JLabel("Percentual Comissão:"));
                extrasPanel.add(comissaoField);
                extrasPanel.add(new JLabel("Vendas Mensais R$:"));
                extrasPanel.add(vendasField);
            } else if (cargo.equals("Operador")) {
                extrasPanel.add(new JLabel("Produtos Produzidos:"));
                extrasPanel.add(produtosField);
            } else if (cargo.equals("Estágiario")) {
                extrasPanel.add(new JLabel("Horas Trabalhadas:"));
                extrasPanel.add(horasField);
                extrasPanel.add(new JLabel("Valor da Hora:"));
                extrasPanel.add(valorField);
            }
            extrasPanel.revalidate();
            extrasPanel.repaint();
        });

        // Inicializa os campos extras para o cargo padrão
        cargoField.setSelectedIndex(0);

        cadastrarButton.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                double salario = Double.parseDouble(salarioField.getText());
                String cargo = (String) cargoField.getSelectedItem();
                int id = Integer.parseInt(idField.getText());

                for(Funcionario f : listapessoas) {
                    if (f.id_funcionario == id) {
                        JOptionPane.showMessageDialog(this,"Já existe um funcionário com esse ID");
                        return;
                    }
                }

                if (cargo.equals("Gerente")) {
                    double bonus = Double.parseDouble(bonusField.getText());
                    Gerente ger = new Gerente(nome, salario, cargo, id, bonus);
                    listapessoas.add(ger);
                    exibirFuncionario(ger);
                    nomeField.setText("");
                    salarioField.setText("");
                    bonusField.setText("");
                    idField.setText("");
                } else if (cargo.equals("Vendedor")) {
                    double comissao = Double.parseDouble(comissaoField.getText());
                    double vendas = Double.parseDouble(vendasField.getText());
                    Vendedor vend = new Vendedor(nome, salario, cargo, id, comissao, vendas);
                    listapessoas.add(vend);
                    exibirFuncionario(vend);
                    comissaoField.setText("");
                    vendasField.setText("");
                    nomeField.setText("");
                    salarioField.setText("");
                    idField.setText("");
                } else if (cargo.equals("Operador")) {
                    int produtos = Integer.parseInt(produtosField.getText());
                    Operador op = new Operador(nome, salario, cargo, id, produtos);
                    listapessoas.add(op);
                    exibirFuncionario(op);
                    produtosField.setText("");
                    nomeField.setText("");
                    salarioField.setText("");
                    idField.setText("");
                } else if (cargo.equals("Estágiario")) {
                    int horas = Integer.parseInt(horasField.getText());
                    double valor = Double.parseDouble(valorField.getText());
                    Estagiario est = new Estagiario(nome, salario, cargo, id, horas, valor);
                    listapessoas.add(est);
                    exibirFuncionario(est);
                    horasField.setText("");
                    valorField.setText("");
                    nomeField.setText("");
                    salarioField.setText("");
                    idField.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos numéricos corretamente.");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                for (Funcionario f : listapessoas) {
                    if (f.id_funcionario == id) {
                        JOptionPane.showMessageDialog(null, "Nome: "+f.nome + "\nCargo: " + f.cargo + "\nID: "+f.id_funcionario);
                    }else{
                        JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
                    }
                }
            }
        });

        setVisible(true);
    }

    private void exibirFuncionario(Funcionario f) {
        listapessoasarea.append("Nome: " + f.nome + "\n");
        listapessoasarea.append("ID: " + f.id_funcionario + "\n");
        listapessoasarea.append("Cargo: " + f.cargo + "\n");
        listapessoasarea.append("Salário Base: R$" + f.salario_base + "\n");
        listapessoasarea.append("Salário com INSS: R$" + f.calculoinss() + "\n");
        listapessoasarea.append("Salário Total: R$" + f.calcularSalario() + "\n");
        listapessoasarea.append("------------------------------\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}

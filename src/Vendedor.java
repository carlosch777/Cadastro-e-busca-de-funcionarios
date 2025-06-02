// Declaração da classe 'vendedor' que herda da classe 'funcionario'
public class Vendedor extends Funcionario {

    // Atributos protegidos: percentual da comissão e o total de vendas mensais
    protected double percentual_comissao;
    protected double vendas_mensais;

    // Construtor da classe 'vendedor'
    // Recebe os dados do funcionário (nome, cargo, salário base) e os dados específicos do vendedor

    public Vendedor(String nome, double salario_base, String cargo, int id_funcionario, double comissao, double vendas) {
        super(nome, cargo, salario_base, id_funcionario);
        this.percentual_comissao = comissao;
        this.vendas_mensais = vendas;
    }

    // Sobrescreve o método calcularSalario da classe 'funcionario'
    @Override
    protected double calcularSalario() {
        // Calcula o salário total como salário base + comissão sobre as vendas
        double salarioinss = super.calculoinss();
        double adicional = (vendas_mensais * percentual_comissao / 100);
        return salarioinss + adicional;
    }
}
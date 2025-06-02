// Classe 'operador' que herda de 'funcionario'
public class Operador extends Funcionario {
    // Atributo que representa a quantidade de produtos produzidos pelo operador
    protected int produtos_produzidos;

    // Construtor que inicializa nome, cargo, salário base e a quantidade de produtos produzidos

    public Operador(String nome, double salario_base, String cargo, int id_funcionario, int produtos_produzidos) {
        super(nome, cargo, salario_base, id_funcionario);
        this.produtos_produzidos = produtos_produzidos;
    }

    // Sobrescrita do método calcularSalario
    @Override
    protected double calcularSalario() {
        // Calcula o salário base + bônus por produto produzido (exemplo: R$2 por produto)
        double salarioinss = super.calculoinss();
        int adicional = produtos_produzidos * 2;
        return salarioinss + adicional;
    }
}
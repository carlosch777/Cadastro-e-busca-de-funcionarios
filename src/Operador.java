// Classe 'operador' que herda de 'funcionario'
public class Operador extends Funcionario {
    // Atributo que representa a quantidade de produtos produzidos pelo operador
    protected int produtos_produzidos;

    // Construtor que inicializa nome, cargo, salário base e a quantidade de produtos produzidos

    public Operador(String nome, double salario_base, String cargo, int id_funcionario, int produtos) {
        super(nome, cargo, salario_base, id_funcionario);
    }

    // Sobrescrita do método calcularSalario
    @Override
    protected double calcularSalario() {
        // Calcula o salário base + bônus por produto produzido (exemplo: R$2 por produto)
        return salario_base + produtos_produzidos * 2;
    }
}
// Define a classe 'estagiario', que herda da classe 'funcionario'
public class Estagiario extends Funcionario {

    // Atributo protegido que representa o número de horas trabalhadas pelo estagiário
    protected int horas_trabalhadas;

    // Atributo protegido que representa o valor pago por hora trabalhada
    protected double valor_da_hora;

    public Estagiario(String nome, double salario_base, String cargo, int id_funcionario, int horas, double valor) {
        super(nome, cargo, salario_base, id_funcionario);
    }

    // Sobrescreve o método calcularSalario da superclasse
    @Override
    protected double calcularSalario() {
        // Calcula a soma do salário base com o total ganho pelas horas extras
        salario_base = salario_base + valor_da_hora * horas_trabalhadas;
        return salario_base;
    }
}

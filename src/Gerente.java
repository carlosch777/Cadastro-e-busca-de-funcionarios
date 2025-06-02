// Define a classe 'gerente' que herda da classe 'funcionario'
public class Gerente extends Funcionario {

    // Atributo protegido que representa o bônus do gerente
    protected  double bonus;

    // Construtor da classe 'gerente', que recebe nome, cargo, salário base e bônus
    public Gerente(String nome, double salario_base, String cargo, int id_funcionario, double bonus) {
        super(nome, cargo, salario_base, id_funcionario);
        this.bonus = bonus;
    }
    // Sobrescreve o método calcularSalario da superclasse
    @Override
    protected  double calcularSalario() {
        // Calcula o salário final somando o salário base ao bônus
        double salarioinss = super.calculoinss();
        return salarioinss + bonus;
    }
}

// Declaração da classe pública chamada "funcionario"
public class Funcionario {

    // Atributos da classe: nome (público), cargo e salário base (protegidos)
    public  String nome;
    protected  String cargo;
    protected  double salario_base;
    protected int id_funcionario;

    // Construtor da classe que inicializa os atributos com os valores passados
    public Funcionario(String nome, String cargo, double salario_base, int id_funcionario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario_base = salario_base;
        this.id_funcionario = id_funcionario;
    }

    // Método protegido que calcula o salario de cada funcionario
    protected double calcularSalario() {
        return salario_base;
    }

    // Método protegido que calcula o desconto do INSS com base no salário base
    protected  double calculoinss() {
        double desconto = 0;
        // Faixa de desconto de 7.5% para salários até R$ 1518
        if (salario_base <= 1518) {
            desconto = salario_base * 7.5 / 100;

            // Faixa de desconto de 9% para salários entre R$ 1518,01 e R$ 2793,99
        } else if (salario_base > 1518 && salario_base < 2794) {
            desconto = salario_base * 9 / 100;

            // Faixa de desconto de 12% para salários entre R$ 2794 e R$ 4189,99
        } else if (salario_base > 2794 && salario_base < 4190 ) {
            desconto = salario_base * 12 / 100;

            // Faixa de desconto de 14% para salários entre R$ 4190 e R$ 8156,99
        } else if (salario_base > 4190 && salario_base < 8157) {
            desconto = salario_base * 14 / 100;

            // Desconto fixo de R$ 951 para salários acima de R$ 8157
        } else if (salario_base > 8157) {
            desconto = 951;
        }

        // Retorna o salário com o desconto do INSS já aplicado
        return salario_base - desconto;
    }
}

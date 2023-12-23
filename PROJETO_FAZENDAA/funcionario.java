package PROJETO_FAZENDAA;

public abstract class funcionario{
    private String nome;
    private String CPF;
    private double salario;
    private int idade;
    private double PercentualAdicional;
    private double SaldoAdicional;

    public funcionario(String nome, String CPF, int idade, double adicional){
        this.setNome(nome);;
        this.setCPF(CPF);;
        this.salario = 2500;
        this.setIdade(idade);
        this.setPercentualAdicional(adicional);
    }

    public void setNome(String nome){
        if (nome != null && !nome.trim().isEmpty()){
            this.nome = nome;
        } else{
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public void setCPF(String cpf){
        if (cpf != null){
            this.CPF = cpf;
        } else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void setSalario(double valor){
        if (valor > 0){
            this.salario = valor;
        } else{
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
    }

    public void setIdade(int idade){
        if (idade >= 18){
            this.idade = idade;
        } else{
            throw new IllegalArgumentException("Nescessário ter mais de 18 anos");
        }
    }


    public void setPercentualAdicional(double adicional){
        if (adicional >= 0 && adicional <=1){
            this.PercentualAdicional = adicional;
        } else{
            throw new IllegalArgumentException("Percentual adicional deve ser um valor entre 0 e 1");
        }
    }


    public void setAdicionalTotal(double valor){
        if (valor >= 0){
            this.SaldoAdicional += valor;
        } else{
            throw new IllegalArgumentException("Valor do adicional não pode ser negativo");
        }
    }


    public String getNome(){
        return nome;
    }


    public String getCPF(){
        return CPF;
    }


    public double getSalario(){
        return salario;
    }


    public int getIdade(){
        return idade;
    }


    public double getPercentualAdicional(){
        return this.PercentualAdicional;
    }


    public double getSaldoAdicional(){
        String bonus = String.format("%.2f", this.SaldoAdicional).replace(",", ".");
        return Double.parseDouble(bonus);
    }


    public double calcularSalario(){
        return this.getSalario() + this.getSaldoAdicional();
    }
}
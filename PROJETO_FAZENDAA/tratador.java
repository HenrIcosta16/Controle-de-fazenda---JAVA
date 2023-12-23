package PROJETO_FAZENDAA;

public class tratador extends funcionario{
    public tratador(String nome, String CPF, int idade, double adicional){
        super(nome, CPF, idade, adicional);
    }

    public void alimentarAnimal(fazenda fazenda, gerente gerente, animal animal){
        double valorVenda = animal.alimentar(fazenda);
        
        this.setAdicionalTotal(valorVenda * this.getPercentualAdicional());
        gerente.setAdicionalTotal(valorVenda * gerente.getPercentualAdicional());

        System.out.println("Animal alimentado!");

        if (valorVenda > 0){
            fazenda.gravarVenda(valorVenda, animal.getClass().getSimpleName());
        }
    }
}

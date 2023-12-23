package PROJETO_FAZENDAA;

import java.util.Random;

public class vaca extends animal{
    private double preco_litro;

    vaca(int id, double precoKG, double peso, double abateKG, int idade, double preco_litro){
        super(id, precoKG, peso, abateKG, idade);
        this.setPrecoLeite(preco_litro);
    }


    public void setPrecoLeite(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("O preço do leite não pode ser negativo.");
        }
        this.preco_litro = valor;
    }


    public double getPrecoLeite(){
        return this.preco_litro;
    }


    public int leite(){
        Random rand = new Random();
        int litros = rand.nextInt(31) + 10;
        return litros; 
    }


    @Override
    public double alimentar(fazenda fazenda){
        this.updateKG(10);
        double valorVenda = 0;
        if (this.getKG() >= this.getKGAbate()){
            valorVenda = abate(fazenda);
        }
        return valorVenda;
    }


    @Override
    public void emitirSom(){
        System.out.println("muuuu");
    }
}
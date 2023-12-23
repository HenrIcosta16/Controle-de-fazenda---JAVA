package PROJETO_FAZENDAA;

import java.text.DecimalFormat;

public abstract class animal{
    private double kg;
    private double peso_abate;
    private int identificador;
    private double preco_kg;
    private int idade;
    
    
    animal(int id, double precoKG, double peso, double abateKG, int idade){
        try{
            this.setID(id);
            this.setPrecoKG(precoKG);
            this.setKG(peso);
            this.setPesoAbate(abateKG);
            this.setIdade(idade);
        } catch (IllegalArgumentException e){
            System.err.println("Erro ao criar animal: " + e.getMessage());
        }
    }


    public abstract double alimentar(fazenda fazenda);


    public abstract void emitirSom();


    public void setKG(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }
        this.kg = valor;
    }


    public void setPesoAbate(double pesoAbate){
        if (pesoAbate < 0){
            throw new IllegalArgumentException("O peso de abate não pode ser negativo.");
        }
        this.peso_abate = pesoAbate;
    }


    public void setID(int id){
        if (id < 0){
            throw new IllegalArgumentException("O identificador não pode ser negativo.");
        }
        this.identificador = id;
    }


    public void setPrecoKG(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("O preço por kg não pode ser negativo.");
        }
        this.preco_kg = valor;
    }


    public void setIdade(int valor){
        if (valor < 0){
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        this.idade = valor;
    }


    public double getKG(){
        return this.kg;
    }


    public double getKGAbate(){
        return this.peso_abate;
    }


    public int getID(){
        return this.identificador;
    }


    public int getIdade(){
        return this.idade;
    }


    public double getPrecoKG(){
        return this.preco_kg;
    }


    public void updateKG(double valor){
        this.kg += valor;
    }


    public String converteArroba(){
        DecimalFormat formatadorDecimal = new DecimalFormat("#.##");
        String preco = formatadorDecimal.format(this.getKG()/15);
        return preco;
    }


    public String status(animal animal){
        String especie = animal.getClass().getSimpleName();

        especie = especie.substring(0, 1).toUpperCase() + especie.substring(1).toLowerCase();

	    return especie + " -" + " Identificador: " + this.getID() + ", Idade: " + this.getIdade()
        + ", Peso KG: " + this.getKG() + ", Peso @: " + this.converteArroba()  + ", Preço KG: R$" + this.getPrecoKG()
        + ", Preço venda: R$" + this.precoAnimal();    
    }


    public final void exibirEstado(){
        System.out.println(status(this));
    }


    public double abate(fazenda fazenda){
        try{
            double valorVenda = 0;
            if (this.kg >= this.peso_abate){
                valorVenda = vender(fazenda);
                fazenda.gravarVenda(valorVenda, this.getClass().getSimpleName());
            }
            return valorVenda;
        } catch (Exception e){
            System.err.println("Erro ao realizar o abate: " + e.getMessage());
            return 0;
        }
    }

    public double precoAnimal(){
        try{
            double preco = this.kg * this.preco_kg;
            return preco;
        } catch (Exception e){
            System.err.println("Erro ao calcular o preço do animal: " + e.getMessage());
            return 0;
        }
    }

    public double vender(fazenda fazenda){
        try{
            fazenda.setTotalVendasAnimais(this.precoAnimal());
            fazenda.removerAnimal(this);
            return this.precoAnimal();
        } catch (Exception e){
            System.err.println("Erro ao vender o animal: " + e.getMessage());
            return 0;
        }
    }
}
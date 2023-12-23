package PROJETO_FAZENDAA;

public class porco extends animal{

    porco(int id, double precoKG, double peso, double abateKG, int idade){
        super(id, precoKG, peso, abateKG, idade);
    }

    
    @Override
    public double alimentar(fazenda fazenda){
        this.updateKG(4);
        double valorVenda = 0;
        if (this.getKG() >= this.getKGAbate()){
            valorVenda = abate(fazenda);
        }
        return valorVenda;
    }


    @Override
    public void emitirSom(){
        System.out.println("oinc oinc, iiihhh");
    }

}

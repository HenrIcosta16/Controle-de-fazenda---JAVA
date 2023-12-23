package PROJETO_FAZENDAA;

public class extrator extends funcionario{
    private int litros_leite_extraido;

    public extrator(String nome, String CPF, int idade, double adicional) {
        super(nome, CPF, idade, adicional);
    }

    public void setLeiteExtraido(int valor){
        this.litros_leite_extraido += valor;
    }

    public int getLeiteExtraido(){
        return this.litros_leite_extraido;
    }

    public void extrairLeite(fazenda fazenda, animal animal, gerente gerente){
        try {
            vaca vaca = (vaca) animal;
            int litros = vaca.leite();
            double lucro = litros * vaca.getPrecoLeite();
            System.out.println("Litros de leite extraídos: " + litros);
            
            this.setLeiteExtraido(litros);
            this.setAdicionalTotal(lucro * this.getPercentualAdicional());
            gerente.setAdicionalTotal(lucro * gerente.getPercentualAdicional());
            
            fazenda.setTotalVendasLeite(lucro);
            fazenda.gravarVendaLeite(lucro, litros);
        } catch (ClassCastException e) {
            System.out.println("Apenas vacas podem ser ordenhadas.");
        }
    }
}

package PROJETO_FAZENDAA;

public class teste {
    public static void main(String[] args) {
        fazenda Fazenda = new fazenda("fazenda kikolindo", 150, "rolandia", "pintópolis");
        animal porco1 = new porco(1, 15, 0, 8, 2);
        animal gado1 = new gado(2, 12, 90, 250, 5);
        animal vaca1 = new vaca(3, 11, 100, 300, 4, 5);
        tratador Tratador = new tratador("jacinto pinto", "024.069.024-69", 30, 0.05);
        extrator Extrator = new extrator("chico linguiça", "666.666.666.66", 80, 0.1);
        gerente Gerente = new gerente("jalin rabei", "123.456.789.00", 40, 0.07);

        Fazenda.adicionarAnimal(porco1);
        Fazenda.adicionarAnimal(gado1);
        Fazenda.adicionarAnimal(vaca1);

        Fazenda.adicionarFuncionario(Tratador);
        Fazenda.adicionarFuncionario(Extrator);
        Fazenda.adicionarFuncionario(Gerente);

        System.out.println("TESTE INFO FAZENDA");
        Fazenda.getFazendaInfo();
        System.out.println();

        System.out.println("TESTE ANIMAIS INFO");
        for (animal a : Fazenda.getAnimais()){
            a.exibirEstado();
        }
        System.out.println();

        System.out.println("TESTE FUNCIONARIOS INFO");
        for (funcionario f : Fazenda.getFuncionarios()){
            Fazenda.infoFuncionario(f);
        }
        System.out.println();

        Tratador.setAdicionalTotal(vaca1.vender(Fazenda));
        System.out.println("TESTE ADICIONAL TRATADOR");
        System.out.println(Tratador.getSaldoAdicional());
        System.out.println();


        System.out.println("TESTE ESTADO ANIMAIS");
        for (animal a : Fazenda.getAnimais()){
            a.exibirEstado();
        }
        System.out.println();
        
        System.out.println("TESTE CONTAR ANIMAIS");
        Fazenda.contarAnimais();
        System.out.println();

        System.out.println("TESTE PREÇO 1 ANIMAL");
        System.out.println(Fazenda.calcularPrecoAnimal(vaca1));
        System.out.println();

        System.out.println("TESTE PREÇO TODOS ANIMAIS");
        Fazenda.calcularPrecoTotal();
        System.out.println();

        System.out.println("TESTE ALIMENTAR ANIMAL E VENDA TOTAL");
        Tratador.alimentarAnimal(Fazenda, Gerente, porco1);
        System.out.println(Fazenda.getTotalVendasAnimais());

        System.out.println("TESTE ADICIONAL TRATADOR");
        System.out.println(Tratador.getSaldoAdicional());

        Fazenda.venderAnimal(Tratador, gado1, Gerente);
        System.out.println("TESTE ADICIONAL TRATADOR");
        System.out.println(Tratador.getSaldoAdicional());
        System.out.println(Fazenda.getTotalVendasAnimais());
        System.out.println();
        System.out.println(Gerente.getSaldoAdicional());

        System.out.println("TESTE ALIMENTAR ANIMAL E VENDA TOTAL");
        Tratador.alimentarAnimal(Fazenda, Gerente, porco1);
        System.out.println(Fazenda.getTotalVendasAnimais());

        System.out.println("TESTE ADICIONAL TRATADOR");
        System.out.println(Tratador.getSaldoAdicional());
        System.out.println();
        System.out.println("TESTE ADICIONAL GERENTE");
        System.out.println(Gerente.getSaldoAdicional());
    

        System.out.println("TESTE PERCENTUAL TRATADOR");
        System.out.println(Tratador.getPercentualAdicional());
        System.out.println();

        Fazenda.contarAnimais();
        Fazenda.contarFuncionarios();

        Extrator.extrairLeite(Fazenda, vaca1, Gerente);
        Extrator.extrairLeite(Fazenda, gado1, Gerente);
        System.out.println(Extrator.getSaldoAdicional());
        System.out.println(Extrator.getLeiteExtraido());

        Fazenda.calcularFolhaPagamento();
        Fazenda.calcularSituacaoFinanceira();
    }
}

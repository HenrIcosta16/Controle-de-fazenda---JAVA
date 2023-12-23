package PROJETO_FAZENDAA;

public class TesteFazenda{
    public static void main(String[] args){
        fazenda Fazenda = new fazenda("Fazenda dos Bichos", 150, "Guarabira", "Paraíba");

        animal porco1 = new porco(1, 15, 53, 108, 2);
        animal porco2 = new porco(2, 15, 65.5, 108, 4);
        animal porco3 = new porco(3, 15, 100, 108, 8);

        animal gado1 = new gado(4, 19, 650, 750, 5);
        animal gado2 = new gado(5, 19, 300, 750, 2);
        animal gado3 = new gado(6, 19, 500, 750, 3);
        animal gado4 = new gado(7, 19, 740, 750, 8);

        animal vaca1 = new vaca(8, 15, 720, 800, 4, 5);
        animal vaca2 = new vaca(9, 15, 600, 800, 3, 5);
        animal vaca3 = new vaca(10, 15, 500, 800, 2, 5);

        tratador Tratador = new tratador("Sr. Jones", "564.841.368-26", 35, 0.05);
        extrator Extrator = new extrator("Sr. Pilkington", "666.666.666-66", 30, 0.2);
        gerente Gerente = new gerente("Sr. Frederick", "123.456.789-00", 50, 0.07);


        Fazenda.adicionarAnimal(porco1);
        Fazenda.adicionarAnimal(porco2);
        Fazenda.adicionarAnimal(porco3);
        Fazenda.adicionarAnimal(gado1);
        Fazenda.adicionarAnimal(gado2);
        Fazenda.adicionarAnimal(gado3);
        Fazenda.adicionarAnimal(gado4);
        Fazenda.adicionarAnimal(vaca1);
        Fazenda.adicionarAnimal(vaca2);
        Fazenda.adicionarAnimal(vaca3);

        Fazenda.adicionarFuncionario(Tratador);
        Fazenda.adicionarFuncionario(Extrator);
        Fazenda.adicionarFuncionario(Gerente);


        System.out.println("INFORMAÇÕES DA FAZENDA");
        Fazenda.getFazendaInfo();
        System.out.println();


        System.out.println("CONTAGEM ANIMAIS");
        for (animal a : Fazenda.getAnimais()){
            a.exibirEstado();
        }
        System.out.println();


        System.out.println("INFORMAÇÕES FUNCIONÁRIOS");
        for (funcionario f : Fazenda.getFuncionarios()){
            Fazenda.infoFuncionario(f);
        }
        System.out.println();


        System.out.println("EXTRATOR");
        Extrator.extrairLeite(Fazenda, vaca1, Gerente);
        Extrator.extrairLeite(Fazenda, vaca2, Gerente);
        Extrator.extrairLeite(Fazenda, vaca3, Gerente);
        Extrator.extrairLeite(Fazenda, porco1, Gerente);
        System.out.println("Total de leite extraido: " + Extrator.getLeiteExtraido() + "L");
        System.out.println("SALDO BÔNUS: R$" + Extrator.getSaldoAdicional());
        System.out.println();


        System.out.println("TRATADOR");
        Tratador.alimentarAnimal(Fazenda, Gerente, vaca3);
        System.out.println();


        System.out.println("FAZENDA");
        Fazenda.contarAnimais();
        System.out.println("Preço de um animal: R$" + Fazenda.calcularPrecoAnimal(vaca3));
        Fazenda.calcularPrecoTotal();

        System.out.println();
        Fazenda.venderAnimal(Tratador, vaca3, Gerente);
        Fazenda.venderAnimal(Tratador, gado4, Gerente);
        Fazenda.venderAnimal(Tratador, porco2, Gerente);
        
        System.out.println();
        Fazenda.contarFuncionarios();

        Fazenda.calcularFolhaPagamento();
        Fazenda.gerarRelatorioAnimais();
        Fazenda.calcularSituacaoFinanceira();
    }
}

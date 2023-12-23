package PROJETO_FAZENDAA;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class fazenda{
    private String nome;
    private double dimensaoEmMetrosQuadrados;
    private String cidade;
    private String estado;
    private List<animal> animais;
    private List<funcionario> funcionarios;
    private double totalArrecadadoVendasAnimais;
    private double totalArrecadadoVendasLeite;

    public fazenda(String nome, double dimensaoEmMetrosQuadrados, String cidade, String estado){
        this.nome = nome;
        this.dimensaoEmMetrosQuadrados = dimensaoEmMetrosQuadrados;
        this.cidade = cidade;
        this.estado = estado;
        this.animais = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.totalArrecadadoVendasAnimais = 0;
        this.totalArrecadadoVendasLeite = 0;
    }


    public void adicionarAnimal(animal animal){
        animais.add(animal);
    }


    public void removerAnimal(animal animal){
        animais.remove(animal);
    }


    public void adicionarFuncionario(funcionario funcionario){
        funcionarios.add(funcionario);
    }


    public void removerFuncionario(funcionario funcionario){
        funcionarios.remove(funcionario);
    }


    public void setTotalVendasAnimais(double valor){
        this.totalArrecadadoVendasAnimais += valor;
    }


    public void setTotalVendasLeite(double valor){
        this.totalArrecadadoVendasLeite += valor;
    }


    public List<animal> getAnimais(){
        return this.animais;
    }


    public List<funcionario> getFuncionarios(){
        return this.funcionarios;
    }


    public void infoFuncionario(funcionario funcionario){
        System.out.println("Nome: " + funcionario.getNome() + ", Idade: " + funcionario.getIdade() 
        + ", CPF: " + funcionario.getCPF() + ", Salário: " + funcionario.calcularSalario());
    }

    
    public double getTotalVendasAnimais(){
        return this.totalArrecadadoVendasAnimais;
    }


    public void getFazendaInfo(){
        System.out.println("Nome: " + this.nome + ", Cidade: " + this.cidade + ", Estado: " + this.estado
        + ", Área: " + this.dimensaoEmMetrosQuadrados + "m2");
    }


    public void contarAnimais(){
        int qtd_porco = 0;
        int qtd_gado = 0;
        int qtd_vaca = 0;
        for (animal a : this.getAnimais()){
            if (a instanceof porco){
                qtd_porco++;
            }
            else if (a instanceof gado){
                qtd_gado++;
            }
            else if(a instanceof vaca){
                qtd_vaca++;
            }
        }

        System.out.println("Total animais: " + this.getAnimais().size());
        System.out.println("Porcos: " + qtd_porco);
        System.out.println("Gado: " + qtd_gado);
        System.out.println("Vacas: " + qtd_vaca);
    }

    public void contarFuncionarios(){
        int qtd_tratador = 0;
        int qtd_extrator = 0;
        int qtd_gerente = 0;
        for (funcionario f : this.getFuncionarios()){
            if (f instanceof tratador){
                qtd_tratador++;
            }
            else if (f instanceof extrator){
                qtd_extrator++;
            }
            else if(f instanceof gerente){
                qtd_gerente++;
            }
        }

        System.out.println("Total funcionários: " + this.getFuncionarios().size());
        System.out.println("Tratador: " + qtd_tratador);
        System.out.println("Extrator: " + qtd_extrator);
        System.out.println("Gerente: " + qtd_gerente);
    }


    public double calcularPrecoAnimal(animal animal){
        return animal.precoAnimal();
    }


    public void calcularPrecoTotal(){
        double total = 0;
        for (animal a : animais){
            total += calcularPrecoAnimal(a);
        }
        System.out.println("Somatório de venda de todos os animais: R$" + total);
    }


    public void gravarVenda(double valor, String tipoAnimal){
        String filename = "vendas_animais.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            writer.println("Venda de " + tipoAnimal + " no valor de R$" + valor);
        } catch (IOException e){
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }


    public void venderAnimal(tratador tratador, animal animal, gerente gerente){
        double valorVenda = animal.vender(this);
        tratador.setAdicionalTotal(valorVenda * tratador.getPercentualAdicional());
        gerente.setAdicionalTotal(valorVenda * gerente.getPercentualAdicional());
        gravarVenda(valorVenda, animal.getClass().getSimpleName());

        if (animal instanceof vaca){
            System.out.println(animal.getClass().getSimpleName() + " vendida por R$" + valorVenda);
        }
        else{
            System.out.println(animal.getClass().getSimpleName() + " vendido por R$" + valorVenda);
        }
    }


    public void gravarVendaLeite(double valor, int litros){
        String filename = "vendas_leite.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            writer.println("Venda de " + litros + "L de leite" +  " no valor de R$" + valor);
        } catch (IOException e){
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }


    public void calcularFolhaPagamento(){
        String cabeçalho = "Folha de pagamento gerada no dia " + getDataHora();

        System.out.print("\n" + cabeçalho);
        System.out.println("Relatório também armazenado em arquivo!\n");
        gravarFolhaPagamento(cabeçalho);

        for (funcionario funcionario : funcionarios){
            String f = "Nome: " + funcionario.getNome() + ", Salário: R$" + funcionario.getSalario()
             + ", Bônus: R$" + funcionario.getSaldoAdicional() + ", Total: R$" + funcionario.calcularSalario();
            System.out.println(f);
            gravarFolhaPagamento(f);

        }
        gravarFolhaPagamento("");
    }


    public void gravarFolhaPagamento(String dados){
        String filename = "folha_pagamento.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            writer.println(dados);
        } catch (IOException e){
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }


    public String getDataHora(){
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatador_data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatador_data);

        LocalTime horario = LocalTime.now();
        DateTimeFormatter formatador_hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horarioFormatado = horario.format(formatador_hora);

        return dataFormatada + " às " + horarioFormatado + "\n";
    }
    

    public void calcularSituacaoFinanceira(){
        String dataHora = "Relatório gerado no dia " + getDataHora();
        double despesaFolhaPagamento = 0;
        for (funcionario funcionario : funcionarios){
            despesaFolhaPagamento += funcionario.calcularSalario();
        }

        double lucroOuPrejuizo = (totalArrecadadoVendasAnimais+totalArrecadadoVendasLeite) - despesaFolhaPagamento;

        String resultado = lucroOuPrejuizo >= 0 ? "Lucro" : "Prejuízo";

        System.out.println("\nSituação financeira da fazenda");
        System.out.print(dataHora);
        System.out.println("Relatório também armazenado em arquivo!\n");
        System.out.println("Despesa com folha de pagamento: R$" + despesaFolhaPagamento);
        System.out.println("Receita com vendas de animais: R$" + totalArrecadadoVendasAnimais);
        System.out.println("Receita com vendas de leite: R$" + totalArrecadadoVendasLeite);
        System.out.println("Situação: " + resultado + " de R$" + Math.abs(lucroOuPrejuizo));

        String relatorio = "Situação financeira da fazenda\n" + dataHora + "\nDespesa com folha de pagamento: R$" + despesaFolhaPagamento
        + "\nReceita com vendas de animais: R$" + totalArrecadadoVendasAnimais + "\nReceita com vendas de leite: R$" + totalArrecadadoVendasLeite
        + "\nSituação: " + resultado + " de R$" + Math.abs(lucroOuPrejuizo);

        gravarSituacao(relatorio + "\n");
    }


    public void gravarSituacao(String dados){
        String filename = "situação.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            writer.println(dados);
        } catch (IOException e){
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }


    public void gerarRelatorioAnimais(){
        String filename = "relatorio_animais.txt";
        String cabecalho = "Relatório de animais gerado no dia " + getDataHora();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            
            writer.println(cabecalho);
            System.out.print("\n" + cabecalho);
            System.out.println("Relatório também armazenado em arquivo!\n");

            for (animal a : animais){
                a.exibirEstado();

                writer.println(a.status(a));
            }
            writer.println("");
        } catch (IOException e){
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
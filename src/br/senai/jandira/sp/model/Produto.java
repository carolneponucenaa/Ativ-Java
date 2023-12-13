package br.senai.jandira.sp.model;

import java.util.Scanner;

public class Produto {
    private String produtoNome, fornecedor;
    private double valor;
    private int produtoId = 0;
    private int quantEstoque;

    public void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------- CADASTRO DE PRODUTOS ---------");
        System.out.print("Insira o nome: ");
        this.produtoNome = scanner.nextLine();
        System.out.print("Quantidade em estoque: ");
        this.quantEstoque = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Insira o valor: ");
        this.valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Insira o fornecedor do produto: ");
        this.fornecedor = scanner.nextLine();
        System.out.println("----------- CADASTRADO COM SUCESSO ---------");
    }

    public String getprodutoNome() {
        return produtoNome;
    }

    public void setprodutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getprodutoId() {
        return produtoId;
    }

    public void setprodutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getquantEstoque() {
        return quantEstoque;
    }

    public void setquantEstoquee(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}


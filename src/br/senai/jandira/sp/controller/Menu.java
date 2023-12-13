package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Cliente;
import br.senai.jandira.sp.model.Produto;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while (continuar){
            System.out.println("**************************************************");
            System.out.println("-------- SEJA BEM VINDO AO NOSSO SISTEMA ----------");
            System.out.println("********** Escolha uma opção válida **********");
            System.out.println("1- Listar os clientes");
            System.out.println("2- Cadastrar um cliente");
            System.out.println("3- Excluir um cliente");
            System.out.println("4- Pesquisar um cliente");
            System.out.println("5- Listar os produtos");
            System.out.println("6- Cadastrar um produto");
            System.out.println("7- Quantidade em estoque");
            System.out.println("8- Excluir um produto");
            System.out.println("9- Pesquisar um produto");
            System.out.println("10- Sair");
            System.out.println("**************************************************");

            Scanner scanner = new Scanner(System.in);

            int userOption = scanner.nextInt();
            scanner.nextLine();

            ClienteController clienteController = new ClienteController();
            ProdutoController produtoController = new ProdutoController();

            switch (userOption){
                case 1:
                    clienteController.listaDeCliente();
                    break;
                case 2:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    clienteController.cadastroDeClientes(cliente);
                    break;
                case 3:
                    System.out.print("Para excluir, insira o CPF: ");
                    int excluirCliente = scanner.nextInt();
                    scanner.nextLine();
                    clienteController.excluirCliente(excluirCliente);
                    break;
                case 4:
                    System.out.print("Para pesquisar, insira o CPF: ");
                    int consultar = scanner.nextInt();
                    scanner.nextLine();
                    clienteController.consultaDeClientes(consultar);
                    break;
                case 5:
                    produtoController.listarProduto();
                    break;
                case 6:
                    Produto produto = new Produto();
                    produto.cadastrarProduto();

                    produtoController.cadastrarProduto(produto);
                    break;
                case 7:
                    System.out.print("Insira a quantidade: ");
                    int quantidade = scanner.nextInt();
                    produtoController.quantidadeProduto(quantidade);
                    break;
                case 8:
                    System.out.print("Para deletar, insira o nome: ");
                    String deletarProduto = scanner.nextLine();
                    produtoController.deletarProduto(deletarProduto);
                    break;
                case 9:
                    System.out.print("Para pesquisar, insira o nome:: ");
                    String consulta = scanner.nextLine();
                    produtoController.consultarProduto(consulta);
                    break;
                case 10:
                    continuar = false;
                    break;
            }
        }
    }
}

package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.ConexaoBanco;
import br.senai.jandira.sp.model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    ConexaoBanco conexao =new ConexaoBanco();
    Connection connection = conexao.getConnection();
    public void listarProduto() throws SQLException {
        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM produtos";

        ResultSet resultSet = statement.executeQuery(queryList);
        Produto produto = new Produto();
        while (resultSet.next()){
            produto.getprodutoId();
            produto.setprodutoNome(resultSet.getString("nome"));
            produto.setquantEstoquee(resultSet.getInt("quantidade"));
            produto.setValor(resultSet.getDouble("valor"));
            produto.setFornecedor(resultSet.getString("fornecedor"));

            System.out.println("ID : " + produto.getprodutoId());
            System.out.println("Nome do Produto: " + produto.getprodutoNome());
            System.out.println("Quantidade: " + produto.getquantEstoque());
            System.out.println("Valor: " + produto.getValor());
            System.out.println("Fornecedor: " + produto.getFornecedor());
            System.out.println("/-----------------------------------------------------/");
        }
    }

    public void quantidadeProduto(int quantidade) throws SQLException {
        Statement statement = connection.createStatement();

        String queryUpdate = "UPDATE produtos SET quantidade= " + quantidade;

        statement.executeUpdate(queryUpdate);
        System.out.println("Alterado.");
    }

    public void deletarProduto(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryDelete = "DELETE FROM produtos WHERE nome='" + nome + "'";

        statement.executeUpdate(queryDelete);
        System.out.println("O produto " + nome + "excluído!");
    }

    public void cadastrarProduto(Produto produto) throws SQLException {

        Statement statement = connection.createStatement();
        String queryCadastro = "INSERT INTO produtos (id_produto, nome_produto, quantidade_estoque, valor, fornecedor) values (" +
                produto.getprodutoId() + ",'" + produto.getprodutoNome() + "'," + produto.getquantEstoque() + "," +
                produto.getValor() + ",'" + produto.getFornecedor() + "')";

        statement.executeUpdate(queryCadastro);
        System.out.println("Cadastrado");
    }

    public void consultarProduto(String nome) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM produtos WHERE nome='" + nome + "'";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Produto> listConsulta = new ArrayList<>();

        while (resultSet.next()){
            Produto produto = new Produto ();

            produto.setprodutoId(resultSet.getInt("id_produto"));
            produto.setprodutoNome(resultSet.getString("nome_produto"));
            produto.setquantEstoquee(resultSet.getInt("quantidade_estoque"));
            produto.setValor(resultSet.getDouble("valor"));
            produto.setFornecedor(resultSet.getString("fornecedor"));

            listConsulta.add(produto);
        }

        for (Produto produto : listConsulta) {
            System.out.println(produto.getprodutoId());
            System.out.println(produto.getprodutoNome());
            System.out.println(produto.getquantEstoque());
            System.out.println(produto.getValor());
            System.out.println(produto.getFornecedor());
            System.out.println("/--------------------------------/");
        }
    }
}
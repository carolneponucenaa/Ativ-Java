package br.senai.jandira.sp.controller;

import br.senai.jandira.sp.model.Cliente;
import br.senai.jandira.sp.model.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    ConexaoBanco conexao = new ConexaoBanco();

    Connection connection = conexao.getConnection();

    public void listaDeCliente() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM cliente";
        ResultSet resultSet = statement.executeQuery(queryList);

        Cliente cliente = new Cliente();

        while (resultSet.next()){
            cliente.setClienteId(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            System.out.println("ID: " + cliente.getClienteId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
        }
    }
    public void excluirCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM clientes WHERE cpf=" + cpf;
        statement.executeUpdate(queryDelete);
        System.out.println("O cliente cujo o CPF " + cpf + " foi excluído.");
    }

    public void cadastroDeClientes(Cliente cliente) throws SQLException {
        Statement statement = connection.createStatement();
        String queryCadastro = "INSERT INTO clientes (id_cliente, nome, cpf, email, telefone) values (" +
                cliente.getClienteId() + ",'" + cliente.getNome() + "'," + cliente.getCpf() + ",'" +
                cliente.getEmail() + "'," + cliente.getTelefone() + ")";

        statement.executeUpdate(queryCadastro);
        System.out.println("O cliente foi cadastrado!");
    }

    public void consultaDeClientes(int cpf) throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM clientes WHERE cpf=" + cpf;
        ResultSet resultSet = statement.executeQuery(queryConsulta);
        List<Cliente> listConsulta = new ArrayList<>();

        while (resultSet.next()){
            Cliente cliente = new Cliente();

            cliente.setClienteId(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));
            listConsulta.add(cliente);
        }
        for (Cliente cliente:listConsulta) {
            System.out.println("********** CONSULTA *************");
            System.out.println(cliente.getClienteId());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getTelefone());
            System.out.println("********** CONSULTADO *************");
        }
    }
}


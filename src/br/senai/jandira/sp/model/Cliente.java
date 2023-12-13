package br.senai.jandira.sp.model;

import java.util.Scanner;

public class Cliente {
    private String nome, email;
    private int clienteId = 0;
    private int cpf, telefone;

    public void cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- CADASTRO DE CLIENTES ---------");
        System.out.print("Insira o nome: ");
        this.nome = scanner.nextLine();
        System.out.print("Insira o cpf: ");
        this.cpf = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Insira o email: ");
        this.email = scanner.nextLine();
        System.out.print("Insira o telefone: ");
        this.telefone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("------- CADASTRADO COM SUCESSO ---------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}

package br.com.minhaempresa.service;

import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;

public class DepositoService {

    public double depositar (String nome, String sobrenome, double valor) {

        Cliente cliente = new Cliente(nome, sobrenome);
        Conta conta = new ContaCorrente(cliente);
        conta.depositar(valor);
        return conta.consultarSaldo();
    }

}
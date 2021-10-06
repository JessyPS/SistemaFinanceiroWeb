package br.com.minhaempresa.service;


import br.com.minhaempresa.domain.Cliente;
import br.com.minhaempresa.domain.Conta;
import br.com.minhaempresa.domain.ContaCorrente;
import br.com.minhaempresa.exception.SaldoInsuficienteException;

public class TransferirService {

    public double transferir(String nomeOrigem, String sobrenomeOrigem,String nomeDestino, String sobrenomeDestino, double valor) throws SaldoInsuficienteException {

        Cliente clienteOrigem = new Cliente(nomeOrigem, sobrenomeOrigem);
        Cliente clienteDestino = new Cliente(nomeDestino, sobrenomeDestino);

        Conta contaOrigem = new ContaCorrente(clienteOrigem);
        Conta contaDestino = new ContaCorrente(clienteDestino);

        contaOrigem.transferir(valor, contaDestino);
        return contaOrigem.consultarSaldo();
    }

}

package br.com.minhaempresa.controller;

import br.com.minhaempresa.exception.SaldoInsuficienteException;
import br.com.minhaempresa.service.TransferirService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/transferir")
public class TransferirController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeOrigem = req.getParameter("nomeOrigem");
        String sobrenomeOrigem = req.getParameter("sobrenomeOrigem");

        String nomeDestino = req.getParameter("nomeDestino");
        String sobrenomeDestino = req.getParameter("sobrenomeDestino");

        double valor = Double.valueOf(req.getParameter("valor"));
        double saldoAtual = 100;

        TransferirService transferirService = new TransferirService();
        try {
            saldoAtual = transferirService.transferir(nomeOrigem, sobrenomeOrigem, nomeDestino, sobrenomeDestino, valor);
        } catch (SaldoInsuficienteException e) {
            e.printStackTrace();
        }

        resp.getWriter().println("Transferência realizada com sucesso! " + saldoAtual);

    }
}

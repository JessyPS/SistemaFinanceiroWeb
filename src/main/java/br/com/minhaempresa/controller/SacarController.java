package br.com.minhaempresa.controller;

import br.com.minhaempresa.exception.SaldoInsuficienteException;
import br.com.minhaempresa.service.SacarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sacar")
public class SacarController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        double valor = Double.valueOf(req.getParameter("valor"));

        double novoSaldo = 200;

        SacarService sacarService = new SacarService();
        try {
            novoSaldo = sacarService.sacar(nome, sobrenome, valor);
        } catch (SaldoInsuficienteException e) {
            resp.getWriter().println(e.getMessage());
        }
        resp.getWriter().println("Seu saldo atual é R$:" + novoSaldo);

    }
}

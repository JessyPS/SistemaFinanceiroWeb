package br.com.minhaempresa.controller;

import br.com.minhaempresa.service.ConsultarSaldoService;
import br.com.minhaempresa.service.DepositoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/depositar")
public class DepositoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nome = req.getParameter("nome");
       String sobrenome = req.getParameter("sobrenome");
       double valor = Double.valueOf(req.getParameter("valor"));

       DepositoService depositoService = new DepositoService();
       double saldoAtual = depositoService.depositar(nome, sobrenome, valor);

       resp.getWriter().println("Depósito realizado com sucesso");
       resp.getWriter().println("Saldo atual é: R$ " + valor);

    }
}

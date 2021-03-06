/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.viewpattern.controller;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.businesspattern.entidades.Cliente;
import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorAluguel;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorCliente;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorGame;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/novo")
public class ActionController {

    @RequestMapping(value = "/Jogo", method = RequestMethod.POST)
    public void addGame(Game g, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GerenciadorGame gg = new GerenciadorGame();

        if (gg.salvar(g)) {
            req.setAttribute("result", "Jogo cadastrado com sucesso!");
        } else {
            req.setAttribute("result", "Erro ao cadastrar o jogo!");
        }

        req.getRequestDispatcher("/home/novoJogo").forward(req, res);
    }

    @RequestMapping(value = "/Cliente", method = RequestMethod.POST)
    public void addCliente(Cliente c, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GerenciadorCliente gc = new GerenciadorCliente();
        if (gc.addCliente(c)) {
            req.setAttribute("result", "Cliente cadastrado com sucesso!");
        } else {
            req.setAttribute("result", "Erro ao cadastrar cliente! \n"
                    + "CPF inválido ou já cadastrado!");
        }

        req.getRequestDispatcher("/home/novoCliente").forward(req, res);
    }

    @RequestMapping(value = "/ClienteFast", method = RequestMethod.POST)
    public void addCliente2(HttpServletRequest req, HttpServletResponse resp, Cliente c) throws IOException, ServletException {
        GerenciadorCliente gc = new GerenciadorCliente();
        if (gc.addCliente(c)) {
            req.setAttribute("result", "Cliente cadastrado com sucesso!");
        } else {
            req.setAttribute("result", "Erro ao cadastrar cliente! \n"
                    + "CPF inválido ou já cadastrado!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home/alugar");
        requestDispatcher.forward(req, resp);
    }

    @RequestMapping(value = "/Aluguel", method = RequestMethod.POST)
    public void addAluguel(String cpf_cliente, int id_jogo, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GerenciadorAluguel ga = new GerenciadorAluguel();
        GerenciadorCliente gc = new GerenciadorCliente();
        GerenciadorGame gg = new GerenciadorGame();
        Cliente cliente = gc.findByCPF(cpf_cliente);
        Game game = gg.buscar(id_jogo);
        Aluguel a = new Aluguel(cliente, game, LocalDate.now());
        boolean add = ga.add(a);
        if (add) {
            if (ga.alugar(a)) {
                req.setAttribute("result", "Jogo alugado com sucesso!");
            } else {
                req.setAttribute("result", "Jogo já foi alugado!");
            }
        } else {
            req.setAttribute("result", "Erro ao alugar jogo!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home/alugar");
        requestDispatcher.forward(req, res);
    }

    @RequestMapping(value = "/Observardor", method = RequestMethod.POST)
    public void novoObservador(String cpf_cliente, int id_jogo, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        GerenciadorCliente gc = new GerenciadorCliente();
        GerenciadorGame gg = new GerenciadorGame();
        Cliente cliente = gc.findByCPF(cpf_cliente);
        Game g = gg.buscar(id_jogo);
        if (new GerenciadorAluguel().findByGameAndClient(id_jogo, cliente.getId()) != null) {
            req.setAttribute("result", "Operação não permitida. \nO jogo está locado para esse cliente em questão.");
        } else {
            boolean addObserver = gg.addObserver(g, cliente);
            if (addObserver) {
                req.setAttribute("result", cliente.getNome() + " está agora observando o jogo " + g.getNome());
            } else {
                req.setAttribute("result", "Não foi possível adicionar observador ao jogo!");
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home/observar");
        requestDispatcher.forward(req, res);
    }

}

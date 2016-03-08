/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.viewpattern.controller;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorAluguel;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorCliente;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorGame;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/home")
public class CentralController {

    @RequestMapping("")
    public String home(){
        return "index";
    }
    
    @RequestMapping(value = "/alugar")
    public String rent(HttpServletRequest request){
        GerenciadorCliente gc = new GerenciadorCliente();
        GerenciadorGame gg = new GerenciadorGame();
        request.getSession().setAttribute("Games", gg.disponiveis());
        request.getSession().setAttribute("Clientes", gc.all());
        Aluguel a = new Aluguel();
        GerenciadorAluguel ga = new GerenciadorAluguel();
        request.setAttribute("dia", ga.tipoDeAluguel(a).toString());
        request.setAttribute("dataDevolucaoFormatada", ga.retornaDataFormatada(a));
        return "alugar";
    }
    
    @RequestMapping(value = "/devolver")
    public String returning(HttpServletRequest request){
        GerenciadorGame gg = new GerenciadorGame();
        request.getSession().setAttribute("Games", gg.alugados());
        return "devolver";
    }
    
    @RequestMapping(value = "/observar")
    public String observer(HttpServletRequest request){
        GerenciadorCliente gc = new GerenciadorCliente();
        GerenciadorGame gg = new GerenciadorGame();
        request.getSession().setAttribute("Games", gg.alugados());
        request.getSession().setAttribute("Clientes", gc.all());
        return "observar";
    }
    
    @RequestMapping(value = "/novoJogo")
    public String newGame(){
        return "novoJogo";
    }
    
    @RequestMapping(value = "/novoCliente")
    public String newClient(){
        return "novoCliente";
        
    }
    
    @RequestMapping(value = "/devolvido")
    public void devolver(int id_jogo, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        GerenciadorAluguel ga = new GerenciadorAluguel();
        Aluguel aluguel = ga.findByGameId(id_jogo);
        
        if (ga.atrasado(aluguel)){
            req.setAttribute("multa", ga.calcularMulta(aluguel));
        }
        boolean devolucao = ga.devolver(aluguel);
        if(devolucao){
            req.setAttribute("result", "Jogo devolvido com sucesso!");
        }else{
            req.setAttribute("result", "Não foi possível devolver o jogo!");
        }
        req.getRequestDispatcher("/home/devolver").forward(req, res);
    }
}

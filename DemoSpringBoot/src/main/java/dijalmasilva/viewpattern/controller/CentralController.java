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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
        List<Game> devoGames = gg.toReturn();
        request.getSession().setAttribute("gamesParaDevolucao", devoGames);
        return "devolver";
    }
    
    @RequestMapping(value = "/observar")
    public String observer(HttpServletRequest request){
        GerenciadorCliente gc = new GerenciadorCliente();
        GerenciadorGame gg = new GerenciadorGame();
        request.getSession().setAttribute("games", gg.listarTodos());
        request.getSession().setAttribute("clientes", gc.all());
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
}

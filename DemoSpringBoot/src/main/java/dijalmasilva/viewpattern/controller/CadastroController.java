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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
@RequestMapping("/novo")
public class CadastroController {

    @RequestMapping(value = "/Game", method = RequestMethod.POST)
    public String addGame(Game g, ModelAndView model){
        GerenciadorGame gg = new GerenciadorGame();
        if(gg.salvar(g)){
            model.addObject("result", "Jogo cadastrado com sucesso!");
        }else{
            model.addObject("result", "Erro ao cadastrar o jogo!");
        }
        
        return null;
    }
    
    @RequestMapping(value = "/Cliente", method = RequestMethod.POST)
    public String addCliente(Cliente c, ModelAndView model){
        GerenciadorCliente gc = new GerenciadorCliente();
        if (gc.addCliente(c)){
            model.addObject("result", "Cliente cadastrado com sucesso!");
        }else{
            model.addObject("result", "Erro ao cadastrar cliente!");
        }
        
        return null;
    }
    
    @RequestMapping(value = "/Aluguel", method = RequestMethod.POST)
    public String addAluguel(Aluguel a, ModelAndView model){
        GerenciadorAluguel ga = new GerenciadorAluguel();
        boolean add = ga.add(a);
        if (add){
            model.addObject("result", "Jogo alugado com sucesso!");
            ga.alugar(a);
        }else{
            model.addObject("result", "Erro ao alugar jogo!");
        }
        return null;
    }
}

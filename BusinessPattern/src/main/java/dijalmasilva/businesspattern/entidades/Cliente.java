/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.entidades;

import dijalmasilva.businesspattern.interfaces.Observer;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.br.CPF;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Cliente implements Serializable, Observer<Game>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    @CPF
    private String cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;

    public Cliente() {
    }

    public Cliente(String cpf, String email, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Game object) {
        EmailImpl envio = new EmailImpl();
        envio.sendEmail("O jogo "+object.getNome()+" está disponível!", "Sr(a). "+nome+ " ,venha o mais rápido possível "
                + "para locar o jogo " + object.getNome() + ", pois o mesmo já se encontra disponível." ,this.email);
        System.out.println("Notificando "+ nome);
        System.out.println("O jogo "+object.getNome()+" está disponível! \n"
                + "--------------------------------------------------------------\n");
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cpf=" + cpf + ", email=" + email + ", nome=" + nome + '}';
    }

}

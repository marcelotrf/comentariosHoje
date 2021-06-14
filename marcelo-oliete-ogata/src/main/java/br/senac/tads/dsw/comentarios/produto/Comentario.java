/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import br.senac.tads.dsw.comentarios.produto.Produto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Bigstudios
 */
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column
    private String nome;

    @NotBlank
    @Email(message = "E-mail deve ser válido")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column
    @Size (min=5, max = 500)
    private String comentario;


    @Column
    private LocalDateTime dataHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("Produto_id"), foreignKey = @ForeignKey (name = "Comentario_produto_fk"))
    private Produto produto;
    
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public String dateFormat(LocalDateTime date){
        return dataHorario.format(DATE_FORMAT);
            
    } 

    public Comentario() {
    }

    public Comentario(String nome, String email, String comentario,LocalDateTime dataHorario  ,Produto produto) {
        this.nome = nome;
        this.email = email;
        this.comentario = comentario;
        this.dataHorario = dataHorario ;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", comentario=" + comentario + ", dataHorario=" + dataHorario + ", produto=" + produto + '}';
    }

}

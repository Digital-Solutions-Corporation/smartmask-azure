package com.fiap.ds.smartmask.model;

import com.fiap.ds.smartmask.enums.Genero;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="TB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_USUARIO", allocationSize = 1)
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NM_USUARIO", nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", nullable = false)
    private String email;

    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Column(name = "NR_TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "NR_IDADE", nullable = false)
    private int idade;

    @Column(name = "DS_GENERO", nullable = false)
    private Genero genero;

    @Column(name = "URL_FOTO", nullable = true)
    private String fotoUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mask_id_smartmask")
    private Smartmask mask;

}

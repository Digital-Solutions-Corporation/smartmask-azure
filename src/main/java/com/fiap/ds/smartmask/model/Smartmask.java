package com.fiap.ds.smartmask.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Qualifier
@Table(name="TB_SMARTMASK")
@SequenceGenerator(name = "smartmask", sequenceName = "SQ_SENSOR", allocationSize = 1)
public class Smartmask {

    @Id
    @Column(name = "ID_SMARTMASK", nullable = false)
    @GeneratedValue(generator = "smartmask", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NM_SMARTMASK", nullable = false)
    private String nome;

    @Column(name = "DS_SMARTMASK", nullable = false)
    private String descricao;

    @CreatedDate
    @Column(name = "DT_FABRICACAO", nullable = false)
    private Instant dataFabricacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_id_sensor")
    private Sensor sensor;

}

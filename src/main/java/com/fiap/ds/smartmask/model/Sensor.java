package com.fiap.ds.smartmask.model;

import com.fiap.ds.smartmask.enums.StatusSensor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="TB_SENSOR")
@SequenceGenerator(name = "sensor", sequenceName = "SQ_SENSOR", allocationSize = 1)
public class Sensor {

    @Id
    @Column(name = "ID_SENSOR", nullable = false)
    @GeneratedValue(generator = "sensor", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NM_SENSOR", nullable = false)
    private String nome;

    @Column(name = "DS_SENSOR", nullable = false)
    private String descricao;

    @Column(name = "ST_SENSOR", nullable = false)
    private StatusSensor status;

}

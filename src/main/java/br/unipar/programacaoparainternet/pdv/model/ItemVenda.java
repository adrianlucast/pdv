package br.unipar.programacaoparainternet.pdv.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private BigDecimal valorUnitario;

    @Column
    private BigDecimal valorTotal;

    @Column
    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fk_venda_id")
    private Venda venda;
}

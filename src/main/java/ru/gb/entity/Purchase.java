package ru.gb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "count")
    private int count;

    @Column(name = "sum")
    private int sum;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", product=" + product +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}

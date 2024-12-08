package edu.badpals.intro_hibernate.entities;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARD")
    @SequenceGenerator(name = "SEQ_CARD",initialValue = 1, allocationSize = 1)
    @Column(name = "idcard")
    private Long id;

    @NotNull
    @Column(name = "code")
    private String code;

    @Transient
    private Type type;

    public enum Type {
        FP,
        ESO,
        BAC
    }

    public Card() {
    }

    public Card(String code) {
        this.code = code;
    }

    public Card(String code, Type type) {
        this.code = code;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


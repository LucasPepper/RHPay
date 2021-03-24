package br.edu.ifnmg;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
public class Usuario {
    //@Column(name = "ID", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;

        return id != null && id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return 1098262705;
    }
}
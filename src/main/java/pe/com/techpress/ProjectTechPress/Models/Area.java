package pe.com.techpress.ProjectTechPress.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomarea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomarea() {
        return nomarea;
    }

    public void setNomarea(String nomarea) {
        this.nomarea = nomarea;
    }

    public Area() {
    }

    public Area(Integer id, String nomarea) {
        this.id = id;
        this.nomarea = nomarea;
    }
}

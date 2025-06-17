package pe.com.techpress.ProjectTechPress.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDate fecha_contrato;
    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(LocalDate fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellido, String email, LocalDate fecha_contrato, Area area) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha_contrato = fecha_contrato;
        this.area = area;
    }
}

package pe.com.techpress.ProjectTechPress.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.techpress.ProjectTechPress.Models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

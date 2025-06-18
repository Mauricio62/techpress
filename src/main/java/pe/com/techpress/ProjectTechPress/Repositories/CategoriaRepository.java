package pe.com.techpress.ProjectTechPress.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.techpress.ProjectTechPress.Models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
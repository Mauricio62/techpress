package pe.com.techpress.ProjectTechPress.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.techpress.ProjectTechPress.Models.Area;
import pe.com.techpress.ProjectTechPress.Services.AreaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<Area> listarAreas() {
        return areaService.listarAreas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> obtenerAreaPorId(@PathVariable Integer id) {
        Optional<Area> area = areaService.obtenerAreaPorId(id);
        return area.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Area> crearArea(@RequestBody Area area) {
        Area nuevaArea = areaService.guardarArea(area);
        return ResponseEntity.ok(nuevaArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> actualizarArea(@PathVariable Integer id, @RequestBody Area area) {
        try {
            Area actualizada = areaService.actualizarArea(id, area);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArea(@PathVariable Integer id) {
        try {
            areaService.eliminarArea(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar el área porque tiene uno o más empleados asociados.");
        }
    }
}

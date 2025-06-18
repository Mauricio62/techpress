package pe.com.techpress.ProjectTechPress.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.techpress.ProjectTechPress.Models.Area;
import pe.com.techpress.ProjectTechPress.Repositories.AreaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;


    public List<Area> listarAreas() {
        return areaRepository.findAll();
    }

    public Area guardarArea(Area area) {
        return areaRepository.save(area);
    }

    public Optional<Area> obtenerAreaPorId(Integer id) {
        return areaRepository.findById(id);
    }

    public Area actualizarArea(Integer id, Area nuevaArea) {
        Optional<Area> areaExistente = areaRepository.findById(id);
        if (areaExistente.isPresent()) {
            Area area = areaExistente.get();
            area.setNomarea(nuevaArea.getNomarea());
            return areaRepository.save(area);
        } else {
            throw new RuntimeException("Area no encontrada con ID: " + id);
        }
    }

    public void eliminarArea(Integer id) {
        areaRepository.deleteById(id);
    }
}

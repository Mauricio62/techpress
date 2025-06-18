package pe.com.techpress.ProjectTechPress.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.techpress.ProjectTechPress.Models.Proveedor;
import pe.com.techpress.ProjectTechPress.Repositories.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor nuevoProveedor) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);

        if (proveedorExistente.isPresent()) {
            Proveedor proveedor = proveedorExistente.get();
            proveedor.setNombre(nuevoProveedor.getNombre());
            proveedor.setTelefono(nuevoProveedor.getTelefono());
            proveedor.setEmail(nuevoProveedor.getEmail());
            proveedor.setRuc(nuevoProveedor.getRuc());
            return proveedorRepository.save(proveedor);
        } else {
            throw new RuntimeException("Proveedor no encontrado con ID: " + id);
        }
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}

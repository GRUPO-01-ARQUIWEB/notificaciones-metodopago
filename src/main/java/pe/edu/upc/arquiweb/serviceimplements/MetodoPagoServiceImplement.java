package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.MetodoPagoPopularDTO;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.repositories.ICarritoCompraRepository;
import pe.edu.upc.arquiweb.repositories.IMetodoPagoRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class MetodoPagoServiceImplement implements IMetodoPagoService {

    @Autowired
    private IMetodoPagoRepository mR;

    @Autowired
    private ICarritoCompraRepository cR;

    @Override
    public List<MetodoPago> list() {
        return mR.findAll();
    }

    @Override
    public void insert(MetodoPago m) {
        mR.save(m);
    }

    @Override
    public MetodoPago searchID(int id) {
        return mR.findById(id).orElse(null);
    }

    @Override
    public void update(MetodoPago m) {
        mR.save(m);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public List<MetodoPago> search(String titular) {
        return mR.buscarPorTitular(titular);
    }

    @Override
    public MetodoPagoPopularDTO buscarMetodoPagoMasUsado() {
        List<Object[]> resultados = mR.buscarMetodoPagoMasUsado();
        if (resultados == null || resultados.isEmpty()) {
            return null;
        }

        Object[] data = resultados.get(0);
        return new MetodoPagoPopularDTO(
                ((Number) data[0]).intValue(),  // id
                (String) data[1],              // tipo
                (String) data[2],              // titular
                ((Number) data[3]).longValue(), // totalUsos
                ((Number) data[4]).doubleValue() // porcentaje
        );
    }



}

package pe.edu.upc.arquiweb.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.arquiweb.dtos.DescuentoDTO;
import pe.edu.upc.arquiweb.entities.Descuento;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configurar el mapeo explícito para Descuento -> DescuentoDTO
        modelMapper.addMappings(new PropertyMap<Descuento, DescuentoDTO>() {
            @Override
            protected void configure() {
                map(source.getProducto().getIdProducto(), destination.getIdProducto());
            }
        });

        return modelMapper;
    }
}

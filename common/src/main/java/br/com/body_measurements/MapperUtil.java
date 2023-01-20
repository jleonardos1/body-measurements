package br.com.body_measurements;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class MapperUtil {

    private ModelMapper modelMapper;

    public MapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public <S, T> T mapTo(S source, Class<T> destClass) {
        return modelMapper.map(source, destClass);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
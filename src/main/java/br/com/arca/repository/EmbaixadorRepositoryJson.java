package br.com.arca.repository;

import br.com.arca.model.Embaixador;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmbaixadorRepositoryJson {

    private ObjectMapper mapper = new ObjectMapper();
    private File arquivo = new File("embaixadores.json");


    public EmbaixadorRepositoryJson(){
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public List<Embaixador> carregar(){
        if(!arquivo.exists()){
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(arquivo, new TypeReference<List<Embaixador>>() {});
        } catch (IOException e){
            throw new RuntimeException("Erro ao carregar arquivo JSON", e);
        }
    }

    public void  salvar(List<Embaixador> embaixadores){
        try{
            mapper.writeValue(arquivo, embaixadores);
        } catch (IOException e){
            throw new RuntimeException("Erro ao salvar arquivo JSON", e);
        }
    }
}

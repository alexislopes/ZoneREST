package com.example.demo.repository;

import com.example.demo.model.Usuario;
import com.example.demo.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByNome(String nome);

    List<Usuario> findUsuarioByTipo(String tipo);

}

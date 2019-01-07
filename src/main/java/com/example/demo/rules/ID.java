package com.example.demo.rules;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ID {

    @Autowired
    private static UsuarioServico usuarioServico;

    public static String getUsuarioId(){
        List<Usuario> usuarios = usuarioServico.achaTodosUsuarios();
        return "U0" + usuarios.size();
    }
}

package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepository usuarioRepository;

    ////////////////////////////////////////////// Métodos de Criação e Leitura.

    //Salvar usuário.
    public Usuario salvaUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Acha usuario por ID.
    public Optional<Usuario> achaUsuarioPorId(String id){
       return usuarioRepository.findById(id);
    }

    //Acha todos os usuários.
    public List<Usuario> achaTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    //Acha usuario por nome.
    public Usuario achaUsuarioPorNome(String nome){
        return usuarioRepository.findByNome(nome);
    }

    ////////////////////////////////////////////// Métodos de Deleção e Atualização.

    //Deleta usuário
    public void deletaUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    //Atualiza usuário
    public Usuario atualizaUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}

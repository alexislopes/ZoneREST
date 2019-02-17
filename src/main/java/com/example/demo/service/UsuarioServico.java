package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.rules.Encript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    public Optional<Usuario> achaUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    //Acha todos os usuários.
    public List<Usuario> achaTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    //Acha usuario por nome.
    public Usuario achaUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    //Acha usuario por tipo.
    public List<Usuario> achaUsuarioPorTipo(String tipo) {
        return usuarioRepository.findUsuarioByTipo(tipo);
    }

    public boolean verificaLogin(String username, String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        boolean logado = false;

        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario.getSenha().equals(Encript.criptografar(senha))){
            logado = true;
        }

        return logado;
    }

    ////////////////////////////////////////////// Métodos de Deleção e Atualização.

    //Deleta usuário
    public void deletaUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    //Atualiza usuário
    public Usuario atualizaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Retorna um ID para um usuario.
    public String getUsuarioId(){
        return "U0" + achaTodosUsuarios().size();
    }
}

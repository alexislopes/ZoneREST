package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/usuario")
@Api(value = "Zone API REST Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;

    @ApiOperation(value = "Salva um usuário")
    @PostMapping(value = "salvaUsuario")
    public Usuario salvaUsuario(@RequestBody @Valid Usuario usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return usuarioServico.salvaUsuario(usuario);
    }

    @ApiOperation(value = "Acha um usuário pelo seu ID")
    @GetMapping(value = "achaUsuarioPorId")
    public Optional<Usuario> achaUsuarioPorId(@RequestParam String id){
        return usuarioServico.achaUsuarioPorId(id);
    }

    @ApiOperation(value = "Acha todos usuários registrados")
    @GetMapping(value = "achaTodosUsuarios")
    public List<Usuario> achaTodosUsuarios(){
        return usuarioServico.achaTodosUsuarios();
    }

    @ApiOperation(value = "Deleta um usuário")
    @DeleteMapping(value = "deletaUsuario")
    public void deletaUsuario(@RequestParam String nome){
        Usuario aux = usuarioServico.achaUsuarioPorNome(nome);
        usuarioServico.deletaUsuario(aux);
    }

    @ApiOperation(value = "Atualiza um usuário")
    @PutMapping(value = "atualizaUsuario")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario){
        return usuarioServico.atualizaUsuario(usuario);
    }

    @ApiOperation(value = "Acha um usuário por tipo")
    @GetMapping(value = "achaUsuarioPorTipo")
    public List<Usuario> achaUsuarioPorTipo(String tipo){
        return usuarioServico.achaUsuarioPorTipo(tipo);
    }
}

package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.rules.Encript;
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
        usuario.set_id(usuarioServico.getUsuarioId());
        usuario.setSenha(Encript.criptografar(usuario.getSenha()));
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

    @ApiOperation(value = "Verifica se usuário está cadastrado")
    @GetMapping(value = "login")
    public boolean verificaLogin(@RequestParam String username, @RequestParam String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return usuarioServico.verificaLogin(username, senha);
    }

    @ApiOperation(value = "Retorna usernames de todos usuários")
    @GetMapping(value = "achaTodosUsernames")
    public List<String> achaTodosUsernames(){
        return usuarioServico.achaTodosUsernames();
    }
}

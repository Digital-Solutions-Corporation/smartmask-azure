package com.fiap.ds.smartmask.controller;

import com.fiap.ds.smartmask.model.Usuario;
import com.fiap.ds.smartmask.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/addUsuario")
    @ApiOperation(value = "Criar um usuario.")
    public Usuario addUsuario(@RequestBody Usuario usuario) { return usuarioService.saveUsuario(usuario); }

    @GetMapping("/usuarios")
    @ApiOperation(value = "Listar todos os usuario.")
    public List<Usuario> findAllUsuarios() { return usuarioService.getUsuarios(); }

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Procurar um usuario pelo ID.")
    public Usuario findUsuarioById(@PathVariable int id) { return usuarioService.getUsuarioById(id); }

    @PutMapping("/update")
    @ApiOperation(value = "Atualizar um usuario.")
    public Usuario updateUsuario(@RequestBody Usuario usuario) { return usuarioService.updateUsuario(usuario); }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deletar um usuario pelo ID.")
    public String deleteUsuario(@PathVariable int id) { return usuarioService.deleteUsuario(id); }

}

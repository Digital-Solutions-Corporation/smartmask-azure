package com.fiap.ds.smartmask.service;

import com.fiap.ds.smartmask.model.Usuario;
import com.fiap.ds.smartmask.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public String deleteUsuario(int id) {
        usuarioRepo.deleteById(id);
        return "Usuario removed - " + id;
    }

    public Usuario updateUsuario(Usuario usuario) {
        Usuario existingUsuario = usuarioRepo.findById(usuario.getId()).orElse(usuario);
        existingUsuario.setNome(usuario.getNome());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setGenero(usuario.getGenero());
        existingUsuario.setSenha(usuario.getSenha());
        existingUsuario.setTelefone(usuario.getTelefone());
        existingUsuario.setFotoUrl(usuario.getFotoUrl());
        existingUsuario.setIdade(usuario.getIdade());
        existingUsuario.setMask(usuario.getMask());
        return usuarioRepo.save(existingUsuario);
    }

}

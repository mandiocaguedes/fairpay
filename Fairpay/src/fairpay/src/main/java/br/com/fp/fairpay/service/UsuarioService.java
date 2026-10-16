/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fp.fairpay.service;

/**
 *
 * @author sesi3dib
 */
import br.com.fp.fairpay.dto.UsuarioCreateDTO;
import br.com.fp.fairpay.dto.UsuarioDTO;
import br.com.fp.fairpay.model.Usuario;
import br.com.fp.fairpay.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilizador não encontrado com ID: " + id));
        return converterParaDTO(usuario);
    }

    public UsuarioDTO criar(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setEndereco(dto.getEndereco());
        usuario.setNumero(dto.getNumero());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha()); // Recomendado aplicar BCrypt futuramente

        Usuario salvo = usuarioRepository.save(usuario);
        return converterParaDTO(salvo);
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Utilizador não encontrado para eliminação.");
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setEndereco(usuario.getEndereco());
        dto.setNumero(usuario.getNumero());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fp.fairpay.controller;

/**
 *
 * @author sesi3dib
 */
import br.com.fp.fairpay.model.EmpresaContratante;
import br.com.fp.fairpay.repository.EmpresaContratanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaContratanteController {

    private final EmpresaContratanteRepository empresaRepository;

    public EmpresaContratanteController(EmpresaContratanteRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public List<EmpresaContratante> listarTodas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<EmpresaContratante> listarPorUsuario(@PathVariable Long usuarioId) {
        return empresaRepository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public ResponseEntity<EmpresaContratante> criar(@RequestBody EmpresaContratante empresa) {
        EmpresaContratante novaEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }
}
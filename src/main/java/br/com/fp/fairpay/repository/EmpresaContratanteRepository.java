/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fp.fairpay.repository;

/**
 *
 * @author sesi3dib
 */
import br.com.fp.fairpay.model.EmpresaContratante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpresaContratanteRepository extends JpaRepository<EmpresaContratante, Long> {
    List<EmpresaContratante> findByUsuarioId(Long usuarioId);
}

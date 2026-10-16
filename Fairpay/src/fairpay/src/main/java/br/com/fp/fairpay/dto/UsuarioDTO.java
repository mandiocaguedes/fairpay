/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fp.fairpay.dto;

/**
 *
 * @author sesi3dib
 */
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String numero;
    private String email;
}

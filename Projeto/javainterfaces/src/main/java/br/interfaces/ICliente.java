/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.interfaces;

/**
 *
 * @author utfpr
 */
public interface ICliente {
    public int getCodigo() ;
    public void setCodigo(int codigo) ;
    public String getNome();
    public void setNome(String nome);
    public ICidade getCidade();
    public void setCidade(ICidade cidade);
}

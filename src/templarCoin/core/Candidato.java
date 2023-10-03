/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarCoin.core;

/**
 *
 * @author almei
 */
public class Candidato extends Pessoa{
    
    private String idCandidato;
    
    public Candidato(String nome, int idade, String idCandidato) {
        super(nome, idade);
        this.idCandidato = idCandidato;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }
    
    public String toString(){
	return idCandidato + getNome();
    }
}

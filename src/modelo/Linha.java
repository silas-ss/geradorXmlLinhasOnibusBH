/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author silas
 */

import java.util.ArrayList;

public class Linha {
    
    private int codLinha;
    private String numLinha;
    private String nomeLinha;
    private ArrayList<String> listaHorariosDiaUtil = new ArrayList<String>();
    private ArrayList<String> listaHorariosDiaUtilFerias = new ArrayList<String>();
    private ArrayList<String> listaHorariosDiaUtilAtipico = new ArrayList<String>();
    private ArrayList<String> listaHorariosDomingoFeriado = new ArrayList<String>();
    private ArrayList<String> listaHorariosSabado = new ArrayList<String>();
    private ArrayList<String> listaHorariosSabadoAtipico = new ArrayList<String>();
    
    public Linha(int codLinha, String numLinha, String nomeLinha){
        this.codLinha = codLinha;
        this.numLinha = numLinha;
        this.nomeLinha = nomeLinha;        
    }
    
    public void addHorarioDiaUtil(String horario){
        this.listaHorariosDiaUtil.add(horario);
    }
    
    public void addHorarioDiaUtilFerias(String horario){
        this.listaHorariosDiaUtilFerias.add(horario);
    }
    
    public void addHorarioDiaUtilAtipico(String horario){
        this.listaHorariosDiaUtilAtipico.add(horario);
    }
    
    public void addHorarioDomingoFeriado(String horario){
        this.listaHorariosDomingoFeriado.add(horario);
    }
    
    public void addHorarioSabado(String horario){
        this.listaHorariosSabado.add(horario);
    }
    
    public void addHorarioSabadoAtipico(String horario){
        this.listaHorariosSabadoAtipico.add(horario);
    }

    public int getCodLinha() {
        return codLinha;
    }

    public void setCodLinha(int codLinha) {
        this.codLinha = codLinha;
    }

    public String getNumLinha() {
        return numLinha;
    }

    public void setNumLinha(String numLinha) {
        this.numLinha = numLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public ArrayList<String> getListaHorariosDiaUtil() {
        return listaHorariosDiaUtil;
    }

    public void setListaHorariosDiaUtil(ArrayList<String> listaHorariosDiaUtil) {
        this.listaHorariosDiaUtil = listaHorariosDiaUtil;
    }

    public ArrayList<String> getListaHorariosDiaUtilFerias() {
        return listaHorariosDiaUtilFerias;
    }

    public void setListaHorariosDiaUtilFerias(ArrayList<String> listaHorariosDiaUtilFerias) {
        this.listaHorariosDiaUtilFerias = listaHorariosDiaUtilFerias;
    }

    public ArrayList<String> getListaHorariosDiaUtilAtipico() {
        return listaHorariosDiaUtilAtipico;
    }

    public void setListaHorariosDiaUtilAtipico(ArrayList<String> listaHorariosDiaUtilAtipico) {
        this.listaHorariosDiaUtilAtipico = listaHorariosDiaUtilAtipico;
    }

    public ArrayList<String> getListaHorariosDomingoFeriado() {
        return listaHorariosDomingoFeriado;
    }

    public void setListaHorariosDomingoFeriado(ArrayList<String> listaHorariosDomingoFeriado) {
        this.listaHorariosDomingoFeriado = listaHorariosDomingoFeriado;
    }

    public ArrayList<String> getListaHorariosSabado() {
        return listaHorariosSabado;
    }

    public void setListaHorariosSabado(ArrayList<String> listaHorariosSabado) {
        this.listaHorariosSabado = listaHorariosSabado;
    }

    public ArrayList<String> getListaHorariosSabadoAtipico() {
        return listaHorariosSabadoAtipico;
    }

    public void setListaHorariosSabadoAtipico(ArrayList<String> listaHorariosSabadoAtipico) {
        this.listaHorariosSabadoAtipico = listaHorariosSabadoAtipico;
    }    

    @Override
    public String toString() {
        return "Linha{" + "codLinha=" + codLinha + ", numLinha=" + numLinha + ", nomeLinha=" + nomeLinha + ", listaHorariosDiaUtil=" + listaHorariosDiaUtil + ", listaHorariosDiaUtilFerias=" + listaHorariosDiaUtilFerias + ", listaHorariosDiaUtilAtipico=" + listaHorariosDiaUtilAtipico + ", listaHorariosDomingoFeriado=" + listaHorariosDomingoFeriado + ", listaHorariosSabado=" + listaHorariosSabado + ", listaHorariosSabadoAtipico=" + listaHorariosSabadoAtipico + '}';
    }
}

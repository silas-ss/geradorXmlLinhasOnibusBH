/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorxmlonibus;

/**
 *
 * @author silas
 */

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import modelo.Linha;
import controle.LinhasUtil;

import java.util.ArrayList;

public class GeradorXMLOnibus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("//home//silas//Downloads//quadro_horario_rmbh");
        ArrayList<Linha> arrLinhas = new ArrayList<Linha>();
        LinhasUtil linhasUtil = new LinhasUtil();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready()){
                String tupla = bufferedReader.readLine();
                String[] dadosLinha = tupla.split(";");
               
                
                int codLinha = Integer.parseInt(dadosLinha[0]);
                String numLinha = dadosLinha[4];
                String nomeLinha = dadosLinha[5];
                Linha linha = new Linha(codLinha, numLinha, nomeLinha);
                Boolean linhaAdicionada = linhasUtil.linhaAdicionada(arrLinhas, linha);
                if(!linhaAdicionada){
                    arrLinhas.add(linha);
                    linhaAdicionada = true;
                }
                
                if(linhaAdicionada){
                    Linha l = linhasUtil.pegarLinha(arrLinhas, codLinha);
                    String tipoDia = dadosLinha[1];                    
                    String horario = dadosLinha[3];                                        
                    int tipo = 0;   //1 - Dia util , 2 - Dia util - ferias, 3 - dia util atipico, 4 - domingo/feriado, 5 - sabado, 6 - sabado dia atipico
                    if(tipoDia.equals("DIA ÚTIL")){
                        tipo = 1;
                    }else if(tipoDia.equals("DIA ÚTIL - FERIAS")){
                        tipo = 2;
                    }else if(tipoDia.equals("DIA ÚTIL ATÍPICO")){
                        tipo = 3;
                    }else if(tipoDia.equals("DOMINGO/FERIADO")){
                        tipo = 4;
                    }else if(tipoDia.equals("SÁBADO")){
                        tipo = 5;
                    }else if(tipoDia.equals("SÁBADO DIA ATÍPICO")){
                        tipo = 6;
                    }
                    
                    switch(tipo){
                        case 1:
                            l.addHorarioDiaUtil(horario);                            
                            break;
                        case 2:
                            l.addHorarioDiaUtilFerias(horario);
                            break;
                        case 3:
                            l.addHorarioDiaUtilAtipico(horario);
                            break;
                        case 4:
                            l.addHorarioDomingoFeriado(horario);
                            break;
                        case 5:
                            l.addHorarioSabado(horario);
                            break;
                        case 6:
                            l.addHorarioSabadoAtipico(horario);
                            break;
                    }                  
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        linhasUtil.gerarXml(arrLinhas);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author silas
 */
import java.io.File;
import modelo.Linha;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class LinhasUtil {
    
    public void LinhasUtil(){}
    
    //Função para receber ArrayList, formatar e gerar o arquivo XML
    public void gerarXml(ArrayList<Linha> arrLinhas){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            
            Element raiz = doc.createElement("linhas");
            doc.appendChild(raiz);
            
            for(int i = 0; i < arrLinhas.size(); i++){
                ArrayList<String> listaHorario;
                Linha linha = arrLinhas.get(i);
                Element elementLinha = doc.createElement("linha");
                elementLinha.setAttribute("codLinha", Integer.toString(linha.getCodLinha()));
                elementLinha.setAttribute("numLinha", linha.getNumLinha());
                
                Element elementNomeLinha = doc.createElement("nomeLinha");
                elementNomeLinha.appendChild(doc.createTextNode(linha.getNomeLinha()));
                elementLinha.appendChild(elementNomeLinha);
                
                //Horários de dia útil
                listaHorario = linha.getListaHorariosDiaUtil();
                if(!listaHorario.isEmpty()){                    
                    Element elementHorariosDiaUtil = doc.createElement("horariosDiaUtil");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosDiaUtil.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosDiaUtil);
                }
                
                //Horários dias util - férias
                listaHorario = linha.getListaHorariosDiaUtilFerias();
                if(!listaHorario.isEmpty()){
                    Element elementHorariosDiaUtilFerias = doc.createElement("horariosDiaUtilFerias");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosDiaUtilFerias.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosDiaUtilFerias);
                }
                
                //Horários dias util - atipico
                listaHorario = linha.getListaHorariosDiaUtilAtipico();
                if(!listaHorario.isEmpty()){
                    Element elementHorariosDiaUtilAtipico = doc.createElement("horariosDiaUtilAtipico");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosDiaUtilAtipico.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosDiaUtilAtipico);
                }
                
                //Horarios domingo/feriado
                listaHorario = linha.getListaHorariosDomingoFeriado();
                if(!listaHorario.isEmpty()){
                    Element elementHorariosDomingoFeriado = doc.createElement("horariosDomingoFeriado");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosDomingoFeriado.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosDomingoFeriado);
                }
                
                //Horarios sabado
                listaHorario = linha.getListaHorariosSabado();
                if(!listaHorario.isEmpty()){
                    Element elementHorariosSabado = doc.createElement("horariosSabado");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosSabado.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosSabado);
                }
                
                //Horarios sabado - atipico
                listaHorario = linha.getListaHorariosSabadoAtipico();
                if(!listaHorario.isEmpty()){
                    Element elementHorariosSabadoAtipico = doc.createElement("horarioSabadoAtipico");
                    for(int c = 0; c < listaHorario.size(); c++){
                        Element horario = doc.createElement("horario");
                        horario.appendChild(doc.createTextNode(listaHorario.get(c)));
                        elementHorariosSabadoAtipico.appendChild(horario);
                    }
                    elementLinha.appendChild(elementHorariosSabadoAtipico);
                }
                
                raiz.appendChild(elementLinha);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("//home//silas//Downloads//quadro_horarios.xml"));
            
            transformer.transform(source, result);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
    
    public Boolean linhaAdicionada(ArrayList<Linha> arrList, Linha linha){
        Boolean existe = false;
        for(int i = 0; i < arrList.size(); i++){
            Linha l = arrList.get(i);
            if(l.getCodLinha() == linha.getCodLinha()){
                existe = true;
                break;
            }
        }
        
        return existe;
    }
    
    public Linha pegarLinha(ArrayList<Linha> arrList, int codLinha){
        Linha linha = null;
        
        for(int i = 0; i < arrList.size(); i++){
            Linha l = arrList.get(i);
            if(l.getCodLinha() == codLinha){
                linha = l;
                break;
            }
        }
        return linha;
    }
}

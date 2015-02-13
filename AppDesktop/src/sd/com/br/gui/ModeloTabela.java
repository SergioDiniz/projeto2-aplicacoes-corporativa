/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.com.br.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sergiod
 */
public class ModeloTabela extends AbstractTableModel
{

    private ArrayList linhas = null;
    private String[]  colunas = null;

    public ModeloTabela() {
    }

    public ModeloTabela(ArrayList linhas, String[]  colunas) {
        setLinhas(linhas);
        setColunas(colunas);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
    
    
    
    
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return  colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha =  (Object[]) getLinhas().get(rowIndex);
        return linha[columnIndex];
    }
    
    public String  getColumnName(int numCol){
        return colunas[numCol];
    }
    
    
    
}

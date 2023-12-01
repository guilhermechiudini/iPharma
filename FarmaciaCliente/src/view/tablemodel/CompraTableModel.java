package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Compra;

public class CompraTableModel extends AbstractTableModel {
    private ArrayList<Compra> listaCompras;

    public CompraTableModel(ArrayList<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    // Obtenção da quantidade de elementos da tabela
    @Override
    public int getRowCount() {
        return this.listaCompras.size();
    }
    
    // Obtenção da quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    // Obtenção do valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtendo o objeto da listaCompras
        Compra compra = this.listaCompras.get(rowIndex);
        // Verficando a coluna para retorno
        switch (columnIndex) {
            case 0:
                return compra.getCodigo();
            case 1:
                return compra.getProduto().getNome();
            case 2:
                return compra.getUsuario().getNome();
            case 3:
                return compra.getDataCompraString();
            case 4:
                return compra.getQuantidadeCompra();
            case 5:
                return "R$ " + compra.getPrecoCompraString(compra.getPrecoCompra());
            default:
                return "";
        }
    }
    
    // Obtenção do nome da coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Produto";
            case 2:
                return "Cliente";
            case 3:
                return "Data da Compra";
            case 4:
                return "Quantidade";
            case 5:
                return "Preço";
            default:
                return "Sem título";
        }
    }
    
    // Obtenção da Compra através do elemento selecionado
    public Compra getCompra(int row) {
        Compra compra = this.listaCompras.get(row);
        return compra;
    }
    
}

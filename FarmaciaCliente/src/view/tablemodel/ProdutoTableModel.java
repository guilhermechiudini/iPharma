package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Produto;

public class ProdutoTableModel extends AbstractTableModel {
    private ArrayList<Produto> listaProdutos;

    public ProdutoTableModel(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    // Obtenção da quantidade de elementos da tabela
    @Override
    public int getRowCount() {
        return this.listaProdutos.size();
    }
    
    // Obtenção da quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    // Obtenção do valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtendo o objeto da listaProdutos
        Produto produto = this.listaProdutos.get(rowIndex);
        // Verficando a coluna para retorno
        switch (columnIndex) {
            case 0:
                return produto.getCodigo();
            case 1:
                return produto.getNome();
            case 2:
                return "R$ " + produto.getPrecoString(produto.getPreco());
            case 3:
                return produto.getQuantidade();
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
                return "Nome";
            case 2:
                return "Preço";
            case 3:
                return "Quantidade";
            default:
                return "Sem título";
        }
    }
    
    // Obtenção do Produto através do elemento selecionado
    public Produto getProduto(int row) {
        Produto produto = this.listaProdutos.get(row);
        return produto;
    }
    
}

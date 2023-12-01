package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Cliente;
import modelDominio.Usuario;

public class ClienteTableModel extends AbstractTableModel {
    private ArrayList<Cliente> listaClientes;

    public ClienteTableModel(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    // Obtenção da quantidade de elementos da tabela
    @Override
    public int getRowCount() {
        return this.listaClientes.size();
    }
    
    // Obtenção da quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    // Obtenção do valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtendo o objeto da listaClientes
        Cliente cliente = this.listaClientes.get(rowIndex);
        // Verficando a coluna para retorno
        switch (columnIndex) {
            case 0:
                return cliente.getCodigo();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getCpf();
            case 3:
                return cliente.getEmail();
            case 4:
                return cliente.getTelefone();
            case 5:
                return cliente.getEndereco();
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
                return "CPF";
            case 3:
                return "E-mail";
            case 4:
                return "Telefone";
            case 5:
                return "Endereço";
            default:
                return "Sem título";
        }
    }
    
    // Obtenção do Cliente através do elemento selecionado
    public Cliente getCompra(int row) {
        Cliente cliente = this.listaClientes.get(row);
        return cliente;
    }
}

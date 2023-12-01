package view;

import java.util.ArrayList;
import modelDominio.Cliente;
import modelDominio.Compra;
import modelDominio.Produto;
import modelDominio.Usuario;
import view.tablemodel.ClienteTableModel;
import view.tablemodel.CompraTableModel;

public class TelaMenu extends javax.swing.JFrame {
    private CompraTableModel compraTableModel;
    private ClienteTableModel clienteTableModel;
    
    public TelaMenu() {
        initComponents();
        // Chamando o método que atualiza a tabela
        atualizaTabela();
    }
    
    public void atualizaTabela() {
        // Obtendo a lista de Compra e Usuario
        ArrayList<Compra> listaCompras = FarmaciaCliente.ccont.compraLista();
        ArrayList<Usuario> listaUsuarios = FarmaciaCliente.ccont.usuarioLista();
        // Obtendo a listaClientes
        ArrayList<Cliente> listaClientes = new ArrayList();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            // Obtendo o Usuario da listaUsuarios
            Usuario usuario = listaUsuarios.get(i);
            // Verificando o tipo do Usuario
            if (usuario instanceof Cliente) {
                listaClientes.add((Cliente) usuario);
            }
        }
        // Instanciando a tableModel com a lista
        compraTableModel = new CompraTableModel(listaCompras);
        clienteTableModel = new ClienteTableModel(listaClientes);
        // Definindo o tableModel da tabela
        jTCompras.setModel(compraTableModel);
        jTClientes.setModel(clienteTableModel);
        // Obtendo a listaProdutos
        ArrayList<Produto> listaProdutos = FarmaciaCliente.ccont.produtoLista();
        // Definindo os valores no relatório
        jLValorProdutos.setText(listaProdutos.size() + "");
        jLValorCompras.setText(listaCompras.size() + "");
        jLValorClientes.setText(listaClientes.size() + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLateral = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jLCompras = new javax.swing.JLabel();
        jLProdutos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLValorClientes = new javax.swing.JLabel();
        jLValorProdutos = new javax.swing.JLabel();
        jLValorCompras = new javax.swing.JLabel();
        jPBarraMenu = new javax.swing.JPanel();
        jBCadastroProdutos = new javax.swing.JButton();
        jBVisualizacaoProdutos = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBCadastroClientes = new javax.swing.JButton();
        jPCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompras = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTClientes = new javax.swing.JTable();
        jLVisualizacaoCompras = new javax.swing.JLabel();
        jLVisualizacaoClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iPharma - Tela de Menu");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPLateral.setBackground(new java.awt.Color(33, 31, 104));
        jPLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setText("iPharma");
        jPLateral.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLSubtitulo.setText("SOFTWARE");
        jPLateral.add(jLSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLCompras.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLCompras.setForeground(new java.awt.Color(255, 255, 255));
        jLCompras.setText("COMPRAS:");
        jPLateral.add(jLCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        jLProdutos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLProdutos.setForeground(new java.awt.Color(255, 255, 255));
        jLProdutos.setText("PRODUTOS:");
        jPLateral.add(jLProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTES:");
        jPLateral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPLateral.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 210, 10));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPLateral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 210, 10));

        jLValorClientes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLValorClientes.setForeground(new java.awt.Color(255, 255, 255));
        jLValorClientes.setText("0");
        jPLateral.add(jLValorClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, -1, -1));

        jLValorProdutos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLValorProdutos.setForeground(new java.awt.Color(255, 255, 255));
        jLValorProdutos.setText("0");
        jPLateral.add(jLValorProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        jLValorCompras.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLValorCompras.setForeground(new java.awt.Color(255, 255, 255));
        jLValorCompras.setText("0");
        jPLateral.add(jLValorCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        getContentPane().add(jPLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 290, 600));

        jPBarraMenu.setBackground(new java.awt.Color(249, 249, 249));
        jPBarraMenu.setPreferredSize(new java.awt.Dimension(600, 46));
        jPBarraMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBCadastroProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cadastroProduto.png"))); // NOI18N
        jBCadastroProdutos.setBorder(null);
        jBCadastroProdutos.setBorderPainted(false);
        jBCadastroProdutos.setContentAreaFilled(false);
        jBCadastroProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastroProdutosActionPerformed(evt);
            }
        });
        jPBarraMenu.add(jBCadastroProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 8, -1, -1));

        jBVisualizacaoProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/visualizaçãoProduto.png"))); // NOI18N
        jBVisualizacaoProdutos.setBorder(null);
        jBVisualizacaoProdutos.setBorderPainted(false);
        jBVisualizacaoProdutos.setContentAreaFilled(false);
        jBVisualizacaoProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBVisualizacaoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVisualizacaoProdutosActionPerformed(evt);
            }
        });
        jPBarraMenu.add(jBVisualizacaoProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 8, -1, -1));

        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/sair.png"))); // NOI18N
        jBSair.setBorderPainted(false);
        jBSair.setContentAreaFilled(false);
        jBSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSair.setFocusable(false);
        jBSair.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jBSair.setRequestFocusEnabled(false);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        jPBarraMenu.add(jBSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 4, -1, -1));

        jBCadastroClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/cadastroCliente.png"))); // NOI18N
        jBCadastroClientes.setBorder(null);
        jBCadastroClientes.setBorderPainted(false);
        jBCadastroClientes.setContentAreaFilled(false);
        jBCadastroClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastroClientesActionPerformed(evt);
            }
        });
        jPBarraMenu.add(jBCadastroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        getContentPane().add(jPBarraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 55));

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));
        jPCentral.setPreferredSize(new java.awt.Dimension(740, 520));

        jTCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTCompras.setFocusable(false);
        jTCompras.setGridColor(new java.awt.Color(255, 255, 255));
        jTCompras.setShowGrid(false);
        jTCompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTCompras);

        jTClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTClientes.setFocusable(false);
        jTClientes.setGridColor(new java.awt.Color(255, 255, 255));
        jTClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTClientes);

        jLVisualizacaoCompras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLVisualizacaoCompras.setText("Visualização de Compras");

        jLVisualizacaoClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLVisualizacaoClientes.setText("Visualização de Clientes");

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLVisualizacaoClientes)
                    .addComponent(jLVisualizacaoCompras)
                    .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(158, 158, 158))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLVisualizacaoCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLVisualizacaoClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 740, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        FarmaciaCliente.ccont.fim();
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBVisualizacaoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVisualizacaoProdutosActionPerformed
        TelaVisualizacaoProdutos telaVisualizacaoProdutos = new TelaVisualizacaoProdutos();
        telaVisualizacaoProdutos.setModal(true);
        telaVisualizacaoProdutos.setVisible(true);
        atualizaTabela();
    }//GEN-LAST:event_jBVisualizacaoProdutosActionPerformed

    private void jBCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastroProdutosActionPerformed
        TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos(null);
        telaCadastroProdutos.setModal(true);
        telaCadastroProdutos.setVisible(true);
        atualizaTabela();
    }//GEN-LAST:event_jBCadastroProdutosActionPerformed

    private void jBCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastroClientesActionPerformed
        TelaCadastroClientes telaCadastroClientes = new TelaCadastroClientes();
        telaCadastroClientes.setModal(true);
        telaCadastroClientes.setVisible(true);
        atualizaTabela();
    }//GEN-LAST:event_jBCadastroClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastroClientes;
    private javax.swing.JButton jBCadastroProdutos;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBVisualizacaoProdutos;
    private javax.swing.JLabel jLCompras;
    private javax.swing.JLabel jLProdutos;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLValorClientes;
    private javax.swing.JLabel jLValorCompras;
    private javax.swing.JLabel jLValorProdutos;
    private javax.swing.JLabel jLVisualizacaoClientes;
    private javax.swing.JLabel jLVisualizacaoCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBarraMenu;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JPanel jPLateral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTClientes;
    private javax.swing.JTable jTCompras;
    // End of variables declaration//GEN-END:variables
}

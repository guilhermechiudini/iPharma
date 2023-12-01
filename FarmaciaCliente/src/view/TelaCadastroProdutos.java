package view;

import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelDominio.Cosmetico;
import modelDominio.Medicamento;
import modelDominio.Produto;
import view.util.Imagem;

public class TelaCadastroProdutos extends javax.swing.JDialog {
    // Produto que será utilizado no Alterar
    private Produto produto;
    // Imagem do Produto
    private Imagem imagem = null;

    public TelaCadastroProdutos(Produto produto) {
        initComponents();
        // Instanciando o Produto
        this.produto = produto;
        // Verificação do parâmetro
        if (this.produto == null) {
            // Desabilitando os campos
            desabilitaMedicamento();
            desabilitaCosmetico();
        }
        else {
            // Carregando as informações
            jTFNome.setText(produto.getNome());
            jFTFPreco.setValue(produto.getPreco());
            jTFQuantidade.setText(Integer.toString(produto.getQuantidade()));
            imagem = new Imagem(produto.getImagem());
            // Verificação do tipo do Produto
            if (this.produto instanceof Medicamento) {
                // Desabilitando Cosmetico
                jRBCosmetico.setEnabled(false);
                desabilitaCosmetico();
                // Carregando as informações
                jRBMedicamento.setSelected(true);
                jTFPrincipioAtivo.setText(((Medicamento) produto).getPrincipioAtivo());
                jTFDosagem.setText(((Medicamento) produto).getDosagem());
                jTFLaboratorio.setText(((Medicamento) produto).getLaboratorio());
            }
            else {
                // Desabilitando Medicamento
                jRBMedicamento.setEnabled(false);
                desabilitaMedicamento();
                // Carregando as informações
                jRBCosmetico.setSelected(true);
                jTFMarca.setText(((Cosmetico) produto).getMarca());
                jTFVolume.setText(Float.toString(((Cosmetico) produto).getVolume()));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGTipo = new javax.swing.ButtonGroup();
        jFCImagem = new javax.swing.JFileChooser();
        jPCentral = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLPreco = new javax.swing.JLabel();
        jFTFPreco = new javax.swing.JFormattedTextField();
        jLQuantidade = new javax.swing.JLabel();
        jTFQuantidade = new javax.swing.JTextField();
        jRBMedicamento = new javax.swing.JRadioButton();
        jRBCosmetico = new javax.swing.JRadioButton();
        jLPrincipioAtivo = new javax.swing.JLabel();
        jTFPrincipioAtivo = new javax.swing.JTextField();
        jLDosagem = new javax.swing.JLabel();
        jTFDosagem = new javax.swing.JTextField();
        jLLaboratorio = new javax.swing.JLabel();
        jLMarca = new javax.swing.JLabel();
        jTFMarca = new javax.swing.JTextField();
        jLVolume = new javax.swing.JLabel();
        jTFVolume = new javax.swing.JTextField();
        jBCadastrar = new javax.swing.JButton();
        jTFLaboratorio = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jLSubtitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jBInserirImagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iPharma - Tela de Gerenciamento de Produtos");
        setUndecorated(true);

        jPCentral.setBackground(new java.awt.Color(255, 255, 255));
        jPCentral.setPreferredSize(new java.awt.Dimension(960, 600));

        jLNome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLNome.setForeground(new java.awt.Color(183, 183, 183));
        jLNome.setText("Nome");

        jTFNome.setBackground(new java.awt.Color(237, 237, 237));
        jTFNome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jLPreco.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLPreco.setForeground(new java.awt.Color(183, 183, 183));
        jLPreco.setText("Preço");

        jFTFPreco.setBackground(new java.awt.Color(237, 237, 237));
        jFTFPreco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jFTFPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLQuantidade.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLQuantidade.setForeground(new java.awt.Color(183, 183, 183));
        jLQuantidade.setText("Quantidade");

        jTFQuantidade.setBackground(new java.awt.Color(237, 237, 237));
        jTFQuantidade.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        jRBMedicamento.setBackground(new java.awt.Color(255, 255, 255));
        bGTipo.add(jRBMedicamento);
        jRBMedicamento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jRBMedicamento.setText("Medicamento");
        jRBMedicamento.setFocusable(false);
        jRBMedicamento.setRequestFocusEnabled(false);
        jRBMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMedicamentoActionPerformed(evt);
            }
        });

        jRBCosmetico.setBackground(new java.awt.Color(255, 255, 255));
        bGTipo.add(jRBCosmetico);
        jRBCosmetico.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jRBCosmetico.setText("Cosmético");
        jRBCosmetico.setFocusable(false);
        jRBCosmetico.setRequestFocusEnabled(false);
        jRBCosmetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBCosmeticoActionPerformed(evt);
            }
        });

        jLPrincipioAtivo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLPrincipioAtivo.setForeground(new java.awt.Color(183, 183, 183));
        jLPrincipioAtivo.setText("Princípio ativo");

        jTFPrincipioAtivo.setBackground(new java.awt.Color(237, 237, 237));
        jTFPrincipioAtivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jTFPrincipioAtivo.setDisabledTextColor(new java.awt.Color(183, 183, 183));

        jLDosagem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLDosagem.setForeground(new java.awt.Color(183, 183, 183));
        jLDosagem.setText("Dosagem (mg)");

        jTFDosagem.setBackground(new java.awt.Color(237, 237, 237));
        jTFDosagem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jTFDosagem.setDisabledTextColor(new java.awt.Color(183, 183, 183));

        jLLaboratorio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLLaboratorio.setForeground(new java.awt.Color(183, 183, 183));
        jLLaboratorio.setText("Laboratório");

        jLMarca.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLMarca.setForeground(new java.awt.Color(183, 183, 183));
        jLMarca.setText("Marca");

        jTFMarca.setBackground(new java.awt.Color(237, 237, 237));
        jTFMarca.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jTFMarca.setDisabledTextColor(new java.awt.Color(183, 183, 183));

        jLVolume.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLVolume.setForeground(new java.awt.Color(183, 183, 183));
        jLVolume.setText("Volume (mL)");

        jTFVolume.setBackground(new java.awt.Color(237, 237, 237));
        jTFVolume.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jTFVolume.setDisabledTextColor(new java.awt.Color(183, 183, 183));

        jBCadastrar.setBackground(new java.awt.Color(33, 31, 104));
        jBCadastrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.setBorderPainted(false);
        jBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrar.setRequestFocusEnabled(false);
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jTFLaboratorio.setBackground(new java.awt.Color(237, 237, 237));
        jTFLaboratorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jTFLaboratorio.setDisabledTextColor(new java.awt.Color(183, 183, 183));

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/voltar.png"))); // NOI18N
        jBVoltar.setBorderPainted(false);
        jBVoltar.setContentAreaFilled(false);
        jBVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBVoltar.setFocusable(false);
        jBVoltar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jBVoltar.setRequestFocusEnabled(false);
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLTitulo.setText("Cadastro");
        jLTitulo.setToolTipText("");

        jLSubtitulo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLSubtitulo.setText("Realize o cadastro do produto para sua farmácia.");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(237, 237, 237));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jBInserirImagem.setBackground(new java.awt.Color(33, 31, 104));
        jBInserirImagem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jBInserirImagem.setForeground(new java.awt.Color(255, 255, 255));
        jBInserirImagem.setText("Inserir Imagem");
        jBInserirImagem.setBorder(null);
        jBInserirImagem.setBorderPainted(false);
        jBInserirImagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBInserirImagem.setFocusable(false);
        jBInserirImagem.setRequestFocusEnabled(false);
        jBInserirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCentralLayout = new javax.swing.GroupLayout(jPCentral);
        jPCentral.setLayout(jPCentralLayout);
        jPCentralLayout.setHorizontalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLSubtitulo)
                            .addComponent(jLTitulo)
                            .addComponent(jLPreco)
                            .addComponent(jTFQuantidade)
                            .addComponent(jLQuantidade)
                            .addComponent(jLNome)
                            .addComponent(jTFNome)
                            .addComponent(jFTFPreco)
                            .addComponent(jBInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRBCosmetico)
                            .addComponent(jLVolume)
                            .addComponent(jLMarca)
                            .addComponent(jTFMarca)
                            .addComponent(jTFVolume, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jLPrincipioAtivo)
                            .addComponent(jTFPrincipioAtivo, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jLDosagem)
                            .addComponent(jTFDosagem, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jLLaboratorio)
                            .addComponent(jTFLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jRBMedicamento)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jBVoltar)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPCentralLayout.setVerticalGroup(
            jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCentralLayout.createSequentialGroup()
                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jBVoltar)
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator3))
                    .addGroup(jPCentralLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                                .addComponent(jRBMedicamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCentralLayout.createSequentialGroup()
                                .addComponent(jLPrincipioAtivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPrincipioAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLDosagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLLaboratorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                                        .addComponent(jBInserirImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCentralLayout.createSequentialGroup()
                                        .addComponent(jRBCosmetico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLMarca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLVolume)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPCentralLayout.createSequentialGroup()
                                .addComponent(jLSubtitulo)
                                .addGap(43, 43, 43)
                                .addComponent(jLNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // Validação das informações
        if (!jTFNome.getText().equals("")) {
            if (!jFTFPreco.getText().equals("")) {
                if (!jTFQuantidade.getText().equals("")) {
                    if (jRBMedicamento.isSelected() || jRBCosmetico.isSelected()) {
                        // Obtendo as informações
                        String nome = jTFNome.getText();
                        int quantidade = Integer.parseInt(jTFQuantidade.getText());
                        byte[] imagemProduto = imagem.getImagem();
                        // Obtendo o preço
                        float preco;
                        try {
                            preco = ((Number) jFTFPreco.getValue()).floatValue();
                        }
                        catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                            preco = 0;
                        }
                        // Caso Medicamento estiver selecionado
                        if (jRBMedicamento.isSelected()) {
                            if (!jTFPrincipioAtivo.getText().equals("")) {
                                if (!jTFDosagem.getText().equals("")) {
                                    if (!jTFLaboratorio.getText().equals("")) {
                                        // Obtendo as informações
                                        String principioAtivo = jTFPrincipioAtivo.getText();
                                        String dosagem = jTFDosagem.getText();
                                        String laboratorio = jTFLaboratorio.getText();
                                        // Verificando o objetivo (Inserir ou Alterar)
                                        if (this.produto == null) {
                                            // Criando o objeto da classe Medicamento
                                            Medicamento medicamento = new Medicamento(principioAtivo, dosagem, laboratorio, nome, quantidade, preco, imagemProduto);
                                            // Enviando a solicitação de cadastro de Produto
                                            boolean resultado = FarmaciaCliente.ccont.produtoInserir(medicamento);
                                            // Verificação do resultado
                                            if (resultado == true) {
                                                JOptionPane.showMessageDialog(rootPane, "Medicamento cadastrado com sucesso.");
                                                limpaCampos();
                                            }
                                            else {
                                                JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível cadastrar o medicamento.");
                                            }
                                        }
                                        else {
                                            // Alterando os atributos do Produto
                                            this.produto.setNome(nome);
                                            this.produto.setPreco(preco);
                                            this.produto.setQuantidade(quantidade);
                                            ((Medicamento) this.produto).setPrincipioAtivo(principioAtivo);
                                            ((Medicamento) this.produto).setDosagem(dosagem);
                                            ((Medicamento) this.produto).setLaboratorio(laboratorio);
                                            // Enviando a solicitação de alteração de Produto
                                            boolean resultado = FarmaciaCliente.ccont.produtoAlterar(produto);
                                            // Validação do resultado
                                            if (resultado == true) {
                                                JOptionPane.showMessageDialog(rootPane, "Produto alterado com sucesso.");
                                            }
                                            else {
                                                JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível alterar o produto.");
                                            }
                                            dispose();
                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(rootPane, "Erro: informe o laboratório.");
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(rootPane, "Erro: informe a dosagem.");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(rootPane, "Erro: informe o princípio ativo.");
                            }
                        }
                        // Caso Cosmético estiver selecionado
                        else {
                            if (!jTFMarca.getText().equals("")) {
                                if (!jTFVolume.getText().equals("")) {
                                    // Obtendo as informações
                                    String marca = jTFMarca.getText();
                                    float volume = Float.parseFloat(jTFVolume.getText());
                                    // Verificando o objetivo (Inserir ou Alterar)
                                    if (this.produto == null) {
                                        // Criando o objeto da classe Cosmetico
                                        Cosmetico cosmetico = new Cosmetico(volume, marca, nome, quantidade, preco, imagemProduto);
                                        // Enviando a solicitação de cadastro de Produto
                                        boolean resultado = FarmaciaCliente.ccont.produtoInserir(cosmetico);
                                        // Verificação do resultado
                                        if (resultado == true) {
                                            JOptionPane.showMessageDialog(rootPane, "Cosmético cadastrado com sucesso.");
                                            limpaCampos();
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível cadastrar o cosmético.");
                                        }
                                    }
                                    else {
                                        // Alterando os atributos do Produto
                                        this.produto.setNome(nome);
                                        this.produto.setPreco(preco);
                                        this.produto.setQuantidade(quantidade);
                                        ((Cosmetico) this.produto).setMarca(marca);
                                        ((Cosmetico) this.produto).setVolume(volume);
                                        // Enviando a solicitação de alteração de Produto
                                        boolean resultado = FarmaciaCliente.ccont.produtoAlterar(produto);
                                        // Validação do resultado
                                        if (resultado == true) {
                                            JOptionPane.showMessageDialog(rootPane, "Produto alterado com sucesso.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(rootPane, "Erro: não foi possível alterar o produto.");
                                        }
                                        dispose();
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(rootPane, "Erro: informe o volume.");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(rootPane, "Erro: informe a marca.");
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "Erro: informe o tipo do produto.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: informe a quantidade.");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o preço.");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o nome.");
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jRBMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMedicamentoActionPerformed
        // Habilitando os campos de Medicamento
        habilitaMedicamento();
        // Desabilitando os campos de Cosmético
        desabilitaCosmetico();
    }//GEN-LAST:event_jRBMedicamentoActionPerformed

    private void jRBCosmeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBCosmeticoActionPerformed
        // Habilitando os campos de Cosmético
        habilitaCosmetico();
        // Desabilitando os campos de Medicamento
        desabilitaMedicamento();
    }//GEN-LAST:event_jRBCosmeticoActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBInserirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirImagemActionPerformed
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
       jFCImagem.addChoosableFileFilter(imageFilter);
       if (jFCImagem.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
           imagem = new Imagem(jFCImagem.getSelectedFile());
       }
    }//GEN-LAST:event_jBInserirImagemActionPerformed

    public void limpaCampos() {
        jTFNome.setText("");
        jFTFPreco.setText("");
        jTFQuantidade.setText("");
        bGTipo.clearSelection();
        jTFPrincipioAtivo.setText("");
        jTFDosagem.setText("");
        jTFLaboratorio.setText("");
        jTFMarca.setText("");
        jTFVolume.setText("");
    }
    
    public void desabilitaMedicamento() {
        // Desabilitando os campos
        jTFPrincipioAtivo.setEnabled(false);
        jTFDosagem.setEnabled(false);
        jTFLaboratorio.setEnabled(false);
        jTFPrincipioAtivo.setText("");
        jTFDosagem.setText("");
        jTFLaboratorio.setText("");
        // Alterando as cores
        jTFPrincipioAtivo.setBackground(new Color(248,248,248));
        jTFDosagem.setBackground(new Color(248,248,248));
        jTFLaboratorio.setBackground(new Color(248,248,248));
    }
    
    public void habilitaMedicamento() {
        jTFPrincipioAtivo.setEnabled(true);
        jTFDosagem.setEnabled(true);
        jTFLaboratorio.setEnabled(true);
        // Alterando as cores
        jTFPrincipioAtivo.setBackground(new Color(237,237,237));
        jTFDosagem.setBackground(new Color(237,237,237));
        jTFLaboratorio.setBackground(new Color(237,237,237));
    }
    
    public void desabilitaCosmetico() {
        jTFMarca.setEnabled(false);
        jTFVolume.setEnabled(false);
        jTFMarca.setText("");
        jTFVolume.setText("");
        // Alterando as cores
        jTFMarca.setBackground(new Color(248,248,248));
        jTFVolume.setBackground(new Color(248,248,248));
    }
    
    public void habilitaCosmetico() {
        jTFMarca.setEnabled(true);
        jTFVolume.setEnabled(true);
        // Alterando as cores
        jTFMarca.setBackground(new Color(237,237,237));
        jTFVolume.setBackground(new Color(237,237,237));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGTipo;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBInserirImagem;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JFileChooser jFCImagem;
    private javax.swing.JFormattedTextField jFTFPreco;
    private javax.swing.JLabel jLDosagem;
    private javax.swing.JLabel jLLaboratorio;
    private javax.swing.JLabel jLMarca;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JLabel jLPrincipioAtivo;
    private javax.swing.JLabel jLQuantidade;
    private javax.swing.JLabel jLSubtitulo;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLVolume;
    private javax.swing.JPanel jPCentral;
    private javax.swing.JRadioButton jRBCosmetico;
    private javax.swing.JRadioButton jRBMedicamento;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTFDosagem;
    private javax.swing.JTextField jTFLaboratorio;
    private javax.swing.JTextField jTFMarca;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPrincipioAtivo;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFVolume;
    // End of variables declaration//GEN-END:variables
}

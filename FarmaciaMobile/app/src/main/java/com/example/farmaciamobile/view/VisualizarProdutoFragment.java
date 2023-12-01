package com.example.farmaciamobile.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.controller.ConexaoController;
import com.example.farmaciamobile.databinding.FragmentVisualizarProdutoBinding;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.util.Calendar;

import modelDominio.Compra;
import modelDominio.Cosmetico;
import modelDominio.Medicamento;
import modelDominio.Produto;
import modelDominio.Usuario;

public class VisualizarProdutoFragment extends Fragment {
    FragmentVisualizarProdutoBinding binding;
    InformacoesViewModel informacoesViewModel;
    Usuario usuarioLogado;
    boolean resultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVisualizarProdutoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Obtendo o parâmetro recebido
        Produto produto = VisualizarProdutoFragmentArgs.fromBundle(getArguments()).getProduto();
        // Carregando as informações
        binding.tvVisualizarProdutoNome.setText(produto.getNome());
        binding.tvVisualizarProdutoPreco.setText("R$" + produto.getPrecoString(produto.getPreco()));
        // Carregando imagem
        Bitmap imagem = ByteArrayToBitmap(produto.getImagem());
        binding.ivVisualizarProdutoImagem.setImageBitmap(imagem);
        // Verificando o tipo
        if (produto instanceof Medicamento) {
            binding.tvVisualizarProdutoDescricao.setText(produto.getNome() + " é um Medicamento.");
            binding.tvVisualizarProdutoCampo1.setText("Princípio ativo: ");
            binding.tvVisualizarProdutoDado1.setText(((Medicamento) produto).getPrincipioAtivo());
            binding.tvVisualizarProdutoCampo2.setText("Dosagem: ");
            binding.tvVisualizarProdutoDado2.setText(((Medicamento) produto).getDosagem() + "mg");
            binding.tvVisualizarProdutoCampo3.setText("Laboratório: ");
            binding.tvVisualizarProdutoDado3.setText(((Medicamento) produto).getLaboratorio());
        }
        else {
            binding.tvVisualizarProdutoDescricao.setText(produto.getNome() + " é um Cosmético.");
            binding.tvVisualizarProdutoCampo1.setText("Marca: ");
            binding.tvVisualizarProdutoDado1.setText(((Cosmetico) produto).getMarca());
            binding.tvVisualizarProdutoCampo2.setText("Volume: ");
            binding.tvVisualizarProdutoDado2.setText(((Cosmetico) produto).getVolumeString() + "mL");
        }
        // Carregando a quantidade no contador
        if (produto.getQuantidade() > 0) {
            binding.tvVisualizarProdutoQuantidade.setText("1");
        }
        else {
            binding.tvVisualizarProdutoQuantidade.setText("0");
            desabilitarBotaoComprar();
        }

        // Clique no botão de remover
        binding.bVisualizarProdutoRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo o contador da quantidade
                int contador = Integer.parseInt(binding.tvVisualizarProdutoQuantidade.getText().toString());
                // Removendo uma quantidade
                contador = contador - 1;
                // Validação da remoção
                if (contador > 0) {
                    // Mostrando no contador da quantidade
                    binding.tvVisualizarProdutoQuantidade.setText(contador + "");
                }
            }
        });

        // Clique no botão de adicionar
        binding.bVisualizarProdutoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo o contador da quantidade
                int contador = Integer.parseInt(binding.tvVisualizarProdutoQuantidade.getText().toString());
                // Adicionando uma quantidade
                contador = contador + 1;
                // Validação da adição
                if (contador <= produto.getQuantidade()) {
                    // Mostrando no contador da quantidade
                    binding.tvVisualizarProdutoQuantidade.setText(contador + "");
                }
            }
        });

        // Clique no botão de comprar
        binding.bVisualizarProdutoComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Confirmando a compra

                // Obtendo as informações
                usuarioLogado = informacoesViewModel.getUsuarioLogado();
                Calendar dataAtual = Calendar.getInstance();
                Date dataCompra = new Date(dataAtual.getTimeInMillis());
                int quantidadeCompra = Integer.parseInt(binding.tvVisualizarProdutoQuantidade.getText().toString());
                float precoCompra = (produto.getPreco() * quantidadeCompra);
                // Criando o objeto da classe Compra
                Compra compra = new Compra(produto, usuarioLogado, dataCompra, quantidadeCompra, precoCompra);
                // Thread para realizar a Compra do Produto
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                        resultado = conexaoController.compraInserir(compra);
                        // Sincronizando as Threads
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Tratando o resultado
                                if (resultado == true) {
                                    Navigation.findNavController(view).navigate(VisualizarProdutoFragmentDirections.acaoVisualizarProdutoFragmentComprovanteFragment(compra));
                                }
                                else {
                                    Toast.makeText(getContext(), "Erro: não foi possível realizar a compra.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                thread.start();
            }
        });

        // Clique no botão Voltar
        binding.bVisualizarProdutoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retornando a tela anterior
                Navigation.findNavController(view).navigate(R.id.acao_visualizarProdutoFragment_menuFragment);
            }
        });

    }

    public void desabilitarBotaoComprar() {
        binding.bVisualizarProdutoComprar.setEnabled(false);
        // Obtendo o drawable
        Drawable drawable = getResources().getDrawable(R.drawable.shape_botao_desabilitado);
        binding.bVisualizarProdutoComprar.setBackground(drawable);
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.farmaciamobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.adapter.ProdutoAdapter;
import com.example.farmaciamobile.controller.ConexaoController;
import com.example.farmaciamobile.databinding.FragmentMenuBinding;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.util.ArrayList;

import modelDominio.Produto;

public class MenuFragment extends Fragment {
    FragmentMenuBinding binding;
    InformacoesViewModel informacoesViewModel;
    ProdutoAdapter produtoAdapter;
    ArrayList<Produto> listaProdutos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Thread para obtenção da listaProdutos
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                listaProdutos = conexaoController.produtoLista();
                // Sincronizando as Threads
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (listaProdutos != null) {
                            // Atualizando o catálogo
                            atualizaCatalogo();
                        }
                    }
                });
            }
        });
        thread.start();
        // Atualizando o catálogo conforme o pesquisar
        binding.etMenuPesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.etMenuPesquisar.getText().toString().equals("")) {
                    // Thread para obtenção da listaProdutos
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                            listaProdutos = conexaoController.produtoLista();
                            // Sincronizando as Threads
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (listaProdutos != null) {
                                        // Atualizando o catálogo
                                        atualizaCatalogo();
                                    }
                                }
                            });
                        }
                    });
                    thread.start();
                }
                else {
                    atualizaCatalogo();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void atualizaCatalogo() {
        // Verificação do pesquisar
        if (!binding.etMenuPesquisar.getText().toString().equals("")) {
            // Obtendo o nome do pesquisar
            String nome = binding.etMenuPesquisar.getText().toString();
            // Thread para obtenção da listaProdutos filtrada
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                    listaProdutos = conexaoController.produtoListaNome(nome);
                }
            });
            thread.start();
        }
        // Organização e disposição dos cards na tela de menu
        produtoAdapter = new ProdutoAdapter(listaProdutos, trataCliqueProduto);
        binding.rvMenuCatalogo.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rvMenuCatalogo.setItemAnimator(new DefaultItemAnimator());
        // Definindo o Adapter do RecyclerView
        binding.rvMenuCatalogo.setAdapter(produtoAdapter);
    }

    // Tratamento do clique no produto listado
    ProdutoAdapter.ProdutoOnClickListener trataCliqueProduto = new ProdutoAdapter.ProdutoOnClickListener() {
        @Override
        public void onClickProduto(View view, int position, Produto produto) {
            Navigation.findNavController(view).navigate(MenuFragmentDirections.acaoMenuFragmentVisualizarProdutoFragment(produto));
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
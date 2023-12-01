package com.example.farmaciamobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.databinding.FragmentComprovanteBinding;

import modelDominio.Compra;
import modelDominio.Medicamento;

public class ComprovanteFragment extends Fragment {
    FragmentComprovanteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentComprovanteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo os parâmetros recebidos
        Compra compra = ComprovanteFragmentArgs.fromBundle(getArguments()).getCompra();
        // Carregando as informações
        binding.tvComprovantePreco.setText("R$" + compra.getPrecoCompraString(compra.getPrecoCompra()));
        binding.tvComprovanteDataDado.setText(compra.getDataCompraString());
        binding.tvComprovanteProdutoDado.setText(compra.getProduto().getNome().toString());
        binding.tvComprovanteQuantidadeDado.setText(String.valueOf(compra.getQuantidadeCompra()));
        if (compra.getProduto() instanceof Medicamento) {
            binding.tvComprovanteTipoDado.setText("Medicamento");
        }
        else {
            binding.tvComprovanteTipoDado.setText("Cosmético");
        }
        binding.tvComprovanteClienteDado.setText(compra.getUsuario().getNome().toString());
        binding.tvComprovanteCpfDado.setText(compra.getUsuario().getCpf().toString());
        binding.tvComprovanteEmailDado.setText(compra.getUsuario().getEmail().toString());
        // Clique no botão Voltar
        binding.bComprovanteVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retornando a tela anterior
                Navigation.findNavController(view).navigate(R.id.acao_comprovanteFragment_menuFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
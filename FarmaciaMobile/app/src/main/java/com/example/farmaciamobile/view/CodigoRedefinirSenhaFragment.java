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
import android.widget.Toast;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.controller.ConexaoController;
import com.example.farmaciamobile.databinding.FragmentCodigoRedefinirSenhaBinding;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import modelDominio.Usuario;

public class CodigoRedefinirSenhaFragment extends Fragment {
    FragmentCodigoRedefinirSenhaBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCodigoRedefinirSenhaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Obtendo os parâmetros recebidos
        Usuario usuario = CodigoRedefinirSenhaFragmentArgs.fromBundle(getArguments()).getUsuario();
        String codigoOriginal = CodigoRedefinirSenhaFragmentArgs.fromBundle(getArguments()).getCodigo();

        // Clique no botão Enviar
        binding.bCodigoRedefinirSenhaEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validação da informação
                if (!binding.etCodigoRedefinirSenhaCodigo.getText().toString().equals("")) {
                    // Obtendo a informação
                    String codigo = binding.etCodigoRedefinirSenhaCodigo.getText().toString();
                    // Validação do código
                    if (codigo.equals(codigoOriginal)) {
                        // Chamando a próxima tela
                        Navigation.findNavController(view).navigate(CodigoRedefinirSenhaFragmentDirections.acaoCodigoRedefinirSenhaFragmentNovaSenhaFragment(usuario));
                    }
                    else {
                        Toast.makeText(getContext(), "Código incorreto.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    binding.etCodigoRedefinirSenhaCodigo.setError("Informe o código.");
                    binding.etCodigoRedefinirSenhaCodigo.requestFocus();
                }
            }
        });

        // Clique no botão Voltar
        binding.bCodigoRedefinirSenhaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retornando a tela anterior
                Navigation.findNavController(view).navigateUp();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
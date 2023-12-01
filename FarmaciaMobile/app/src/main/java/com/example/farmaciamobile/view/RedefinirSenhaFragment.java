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
import com.example.farmaciamobile.databinding.FragmentRedefinirSenhaBinding;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import modelDominio.Usuario;

public class RedefinirSenhaFragment extends Fragment {
    FragmentRedefinirSenhaBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRedefinirSenhaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        // Clique no botão de Enviar
        binding.bRedefinirSenhaEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validação das informações
                if (!binding.etRedefinirSenhaEmail.getText().toString().equals("")) {
                    // Obtendo das informações
                    String login = binding.etRedefinirSenhaUsuario.getText().toString();
                    String email = binding.etRedefinirSenhaEmail.getText().toString();
                    // Criando o objeto da classe Usuario
                    Usuario usuario = new Usuario(login, email, null);
                    // Thread para solicitação de validação da existência do Usuario
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                            boolean resultado = conexaoController.usuarioValidar(usuario);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // Tratando o resultado
                                    if (resultado == true) {
                                        // Thread para solicitação de envio de e-mail com código
                                        Thread thread = new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                                String codigo = conexaoController.enviarEmail(email);
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        // Chamando a próxima tela
                                                        Navigation.findNavController(view).navigate(RedefinirSenhaFragmentDirections.acaoRedefinirSenhaFragmentCodigoRedefinirSenhaFragment(usuario, codigo));
                                                    }
                                                });
                                            }
                                        });
                                        thread.start();
                                    }
                                    else {
                                        Toast.makeText(getContext(), "Usuário não cadastrado.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                    thread.start();
                }
                else {
                    binding.etRedefinirSenhaEmail.setError("Informe o e-mail.");
                    binding.etRedefinirSenhaEmail.requestFocus();
                }
            }
        });

        // Clique no botão Voltar
        binding.bRedefinirSenhaVoltar.setOnClickListener(new View.OnClickListener() {
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
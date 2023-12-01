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
import com.example.farmaciamobile.databinding.FragmentNovaSenhaBinding;
import com.example.farmaciamobile.view.util.Hash;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import modelDominio.Usuario;

public class NovaSenhaFragment extends Fragment {
    FragmentNovaSenhaBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNovaSenhaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Obtendo os parâmetros recebidos
        Usuario usuario = NovaSenhaFragmentArgs.fromBundle(getArguments()).getUsuario();

        // Clique no botão de Redefinir Senha
        binding.bNovaSenhaRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validação das informações
                if (!binding.etNovaSenhaSenha.getText().toString().equals("")) {
                    if (!binding.etNovaSenhaConfirmarSenha.getText().toString().equals("")) {
                        // Obtendo as informações
                        String senha = binding.etNovaSenhaSenha.getText().toString();
                        String confirmarSenha = binding.etNovaSenhaConfirmarSenha.getText().toString();
                        // Validação da nova senha
                        if (senha.equals(confirmarSenha)) {
                            // Criptografando a senha
                            try {
                                senha = Hash.encriptar(senha, "MD5");
                            }
                            catch (NoSuchAlgorithmException nsae) {
                                System.out.println("Erro: " + nsae.getMessage());
                            }
                            catch (UnsupportedEncodingException uee) {
                                System.out.println("Erro: " + uee.getMessage());
                            }
                            // Obtendo as informações
                            String login = usuario.getLogin();
                            String email = usuario.getEmail();
                            // Criando o objeto da classe Usuario
                            Usuario usuario = new Usuario(login, email, senha);
                            // Thread para Redefinir Senha
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                    boolean resultado = conexaoController.redefinirSenha(usuario);
                                    // Sincronizando as Threads
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Tratando o resultado
                                            if (resultado == true) {
                                                Navigation.findNavController(view).navigate(R.id.acao_novaSenhaFragment_loginFragment);
                                            }
                                            else {
                                                Toast.makeText(getContext(), "Não foi possível redefinir a senha.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            });
                            thread.start();
                        }
                        else {
                            Toast.makeText(getContext(), "As senhas informadas são diferentes.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        binding.etNovaSenhaConfirmarSenha.setError("Informe a senha novamente.");
                        binding.etNovaSenhaConfirmarSenha.requestFocus();
                    }
                }
                else {
                    binding.etNovaSenhaSenha.setError("Informe a senha.");
                    binding.etNovaSenhaSenha.requestFocus();
                }
            }
        });

        // Clique no botão Voltar
        binding.bNovaSenhaVoltar.setOnClickListener(new View.OnClickListener() {
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
package com.example.farmaciamobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.controller.ConexaoController;
import com.example.farmaciamobile.databinding.FragmentLoginBinding;
import com.example.farmaciamobile.view.util.Hash;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import modelDominio.Usuario;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    InformacoesViewModel informacoesViewModel;
    boolean resultado;
    Usuario usuarioLogado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Thread para criação da conexão com o servidor
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Declarando o controller e chamando o método de criação da conexão
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                resultado = conexaoController.criaConexaoServidor("10.0.2.2", 12345);
                // Sincronizando as threads
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Tratando o resultado
                        if (resultado == true) {
                            Toast.makeText(getContext(), "Conexão estabelecida com sucesso.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getContext(), "Erro: conexão com o servidor não estabelecida.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        thread.start();

        // Clique no botão Entrar
        binding.bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificando se o usuário informou os dados
                if (!binding.etLoginUsuario.getText().toString().equals("")) {
                    if (!binding.etLoginSenha.getText().toString().equals("")) {
                        // Obtendo as informações
                        String usuario = binding.etLoginUsuario.getText().toString();
                        String senha = binding.etLoginSenha.getText().toString();
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
                        // Instanciando o usuário
                        usuarioLogado = new Usuario(usuario, senha);
                        // Criando Thread paras autenticar usuário
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                usuarioLogado = conexaoController.efetuarLogin(usuarioLogado);
                                // Sincronizando as Threads
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Tratando o resultado
                                        if (usuarioLogado != null) {
                                            // Salvando o usuário logado e chamando a próxima tela
                                            informacoesViewModel.inicializaUsuarioLogado(usuarioLogado);
                                            Navigation.findNavController(view).navigate(R.id.acao_loginFragment_menuFragment);
                                        } else {
                                            Toast.makeText(getContext(),"Erro: usuário e/ou senha inválidos.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        });
                        thread.start();
                    }
                    else {
                        binding.etLoginSenha.setError("Informe a senha.");
                        binding.etLoginSenha.requestFocus();
                    }
                }
                else {
                    binding.etLoginUsuario.setError("Informe o usuário.");
                    binding.etLoginUsuario.requestFocus();
                }
            }
        });

        // Clique no botão Redefinir Senha
        binding.bLoginRedefinirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chamando a Tela de Redefinir Senha
                Navigation.findNavController(view).navigate(R.id.acao_loginFragment_redefinirSenhaFragment);
            }
        });

        // Clique no botão Cadastrar-se
        binding.bLoginCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chamando a Tela de Cadastro
                Navigation.findNavController(view).navigate(R.id.acao_loginFragment_cadastrarUsuarioFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Escondendo a toolbar
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

}
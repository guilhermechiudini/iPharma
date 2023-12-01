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

import com.example.farmaciamobile.controller.ConexaoController;
import com.example.farmaciamobile.databinding.FragmentCadastrarUsuarioBinding;
import com.example.farmaciamobile.view.util.CpfMascara;
import com.example.farmaciamobile.view.util.Hash;
import com.example.farmaciamobile.view.util.TelefoneMascara;
import com.example.farmaciamobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import modelDominio.Cliente;
import modelDominio.Usuario;

public class CadastrarUsuarioFragment extends Fragment {
    FragmentCadastrarUsuarioBinding binding;
    InformacoesViewModel informacoesViewModel;
    boolean resultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastrarUsuarioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtendo a instância do viewModel
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        // Carregando a máscara nos EditText
        binding.etCadastrarUsuarioCpf.addTextChangedListener(CpfMascara.insert(binding.etCadastrarUsuarioCpf));
        binding.etCadastrarUsuarioTelefone.addTextChangedListener(TelefoneMascara.insert(binding.etCadastrarUsuarioTelefone));
        // Clique no botão Cadastrar
        binding.bCadastrarUsuarioCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validação das informações
                if (!binding.etCadastrarUsuarioNome.getText().toString().equals("")) {
                    if (!binding.etCadastrarUsuarioCpf.getText().toString().equals("")) {
                        if (!binding.etCadastrarUsuarioEmail.getText().toString().equals("")) {
                            if (!binding.etCadastrarUsuarioTelefone.getText().toString().equals("")) {
                                if (!binding.etCadastrarUsuarioEndereco.getText().toString().equals("")) {
                                    if (!binding.etCadastrarUsuarioLogin.getText().toString().equals("")) {
                                        if (!binding.etCadastrarUsuarioSenha.getText().toString().equals("")) {
                                            // Obtendo as informações
                                            String nome = binding.etCadastrarUsuarioNome.getText().toString();
                                            String cpf = binding.etCadastrarUsuarioCpf.getText().toString();
                                            String email = binding.etCadastrarUsuarioEmail.getText().toString();
                                            String telefone = binding.etCadastrarUsuarioTelefone.getText().toString();
                                            String endereco = binding.etCadastrarUsuarioEndereco.getText().toString();
                                            String login = binding.etCadastrarUsuarioLogin.getText().toString();
                                            String senha = binding.etCadastrarUsuarioSenha.getText().toString();
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
                                            // Criando o objeto da classe Cliente
                                            Usuario usuario = new Cliente(nome, cpf, email, telefone, endereco, login, senha);
                                            // Thread de solicitação de cadastro de Usuario
                                            Thread thread = new Thread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                                    resultado = conexaoController.usuarioInserir(usuario);
                                                    // Sincronizando as Threads
                                                    getActivity().runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            // Validação do resultado
                                                            if (resultado == true) {
                                                                Toast.makeText(getContext(), "Cliente cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                                                                // Voltando para a tela de Login
                                                                Navigation.findNavController(view).navigateUp();
                                                            }
                                                            else {
                                                                Toast.makeText(getContext(), "Não foi possível realizar o cadastro.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                                }
                                            });
                                            thread.start();
                                        }
                                        else {
                                            binding.etCadastrarUsuarioSenha.setError("Informe a senha.");
                                            binding.etCadastrarUsuarioSenha.requestFocus();
                                        }
                                    }
                                    else {
                                        binding.etCadastrarUsuarioLogin.setError("Informe o usuário.");
                                        binding.etCadastrarUsuarioLogin.requestFocus();
                                    }
                                }
                                else {
                                    binding.etCadastrarUsuarioEndereco.setError("Informe o endereço.");
                                    binding.etCadastrarUsuarioEndereco.requestFocus();
                                }
                            }
                            else {
                                binding.etCadastrarUsuarioTelefone.setError("Informe o telefone.");
                                binding.etCadastrarUsuarioTelefone.requestFocus();
                            }
                        }
                        else {
                            binding.etCadastrarUsuarioEmail.setError("Informe o e-mail.");
                            binding.etCadastrarUsuarioEmail.requestFocus();
                        }
                    }
                    else {
                        binding.etCadastrarUsuarioCpf.setError("Informe o CPF.");
                        binding.etCadastrarUsuarioCpf.requestFocus();
                    }
                }
                else {
                    binding.etCadastrarUsuarioNome.setError("Informe o nome.");
                    binding.etCadastrarUsuarioNome.requestFocus();
                }
            }
        });

        // Clique no botão Voltar
        binding.bCadastrarUsuarioVoltar.setOnClickListener(new View.OnClickListener() {
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
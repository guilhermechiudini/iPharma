package com.example.farmaciamobile.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelDominio.Usuario;

public class InformacoesViewModel extends ViewModel {
    //Informações necessárias para o socket
    private MutableLiveData<ObjectInputStream> mIn;
    private MutableLiveData<ObjectOutputStream> mOut;

    //Usuario logado no aplicativo
    private MutableLiveData<Usuario> mUsuarioLogado;

    public void inicializaObjetoSocket(ObjectInputStream in, ObjectOutputStream out) {
        //Instanciando os mutableLiveData
        this.mIn = new MutableLiveData<>();
        this.mOut = new MutableLiveData<>();
        //Definindo os objetos recebidos por parâmetro (postValue por ser assincrono/thread)
        this.mIn.postValue(in);
        this.mOut.postValue(out);
    }

    public void inicializaUsuarioLogado(Usuario usuarioLogado) {
        //Instanciando o mutableLiveData
        this.mUsuarioLogado = new MutableLiveData<>();
        //Definindo o objeto recebido como parâmetro
        this.mUsuarioLogado.postValue(usuarioLogado);
    }

    public ObjectInputStream getInputStream() {
        return this.mIn.getValue();
    }

    public ObjectOutputStream getOutputStream() {
        return this.mOut.getValue();
    }

    public Usuario getUsuarioLogado() {
        return this.mUsuarioLogado.getValue();
    }

}

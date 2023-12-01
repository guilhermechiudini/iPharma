package com.example.farmaciamobile.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmaciamobile.R;
import com.example.farmaciamobile.databinding.ItemListRowBinding;

import java.util.List;

import modelDominio.Medicamento;
import modelDominio.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {
    private List<Produto> listaProdutos;
    private ProdutoOnClickListener produtoOnClickListener;

    public ProdutoAdapter(List<Produto> listaProdutos, ProdutoOnClickListener produtoOnClickListener) {
        this.listaProdutos = listaProdutos;
        this.produtoOnClickListener = produtoOnClickListener;
    }

    @Override
    public ProdutoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListRowBinding itemListRowBinding = ItemListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(itemListRowBinding);
    }

    @Override
    public void onBindViewHolder(final ProdutoAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Produto produto = listaProdutos.get(position);
        // Validação do tipo do Produto
        if (produto instanceof Medicamento) {
            holder.itemListRowBinding.ivProdutoTipo.setImageResource(R.drawable.icon_medicamento);
        }
        else {
            holder.itemListRowBinding.ivProdutoTipo.setImageResource(R.drawable.icon_cosmetico);
        }
        holder.itemListRowBinding.tvProdutoNome.setText(produto.getNome());
        holder.itemListRowBinding.tvProdutoPreco.setText("R$" + produto.getPrecoString(produto.getPreco()));
        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado, deve ser feita a conversão com o String.valueOf() */

        // Tratando o clique no item
        if (produtoOnClickListener != null) {
            holder.itemListRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    produtoOnClickListener.onClickProduto(holder.itemView, position, produto);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public  ItemListRowBinding itemListRowBinding;
        public MyViewHolder(ItemListRowBinding itemListRowBinding) {
            super(itemListRowBinding.getRoot());
            this.itemListRowBinding = itemListRowBinding;
        }
    }

    public interface ProdutoOnClickListener {
        public void onClickProduto(View view, int position, Produto produto);
    }

}

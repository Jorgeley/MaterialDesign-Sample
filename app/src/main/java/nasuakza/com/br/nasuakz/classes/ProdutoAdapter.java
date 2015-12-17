package nasuakza.com.br.nasuakz.classes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nasuakza.com.br.nasuakz.R;
import nasuakza.com.br.nasuakz.beans.Produto;

/**
 * Created by root on 16/12/15.
 */

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MarcaViewHolder>{
    private List<Produto> produtos;

    public ProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public MarcaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_produtos, parent, false);
        MarcaViewHolder mvh = new MarcaViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MarcaViewHolder holder, int position) {
        //holder.nome.setText(this.produtos.get(position).getNome());
        holder.img.setImageResource(produtos.get(position).getImg());
        holder.nome.setText(produtos.get(position).getNome());
        holder.preco.setText(String.valueOf(produtos.get(position).getPreco()));
    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MarcaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nome;
        TextView preco;
        ImageView img;

        MarcaViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardviewProduto);
            nome = (TextView) itemView.findViewById(R.id.nome);
            preco = (TextView) itemView.findViewById(R.id.preco);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

}
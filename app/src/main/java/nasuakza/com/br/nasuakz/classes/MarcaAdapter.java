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
import nasuakza.com.br.nasuakz.beans.Marca;

/**
 * Created by root on 16/12/15.
 */

public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.MarcaViewHolder>{
    private List<Marca> marcas;

    public MarcaAdapter(List<Marca> marcas) {
        this.marcas = marcas;
    }

    @Override
    public MarcaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MarcaViewHolder mvh = new MarcaViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MarcaViewHolder holder, int position) {
        //holder.marca.setText(this.marcas.get(position).getNome());
        holder.logo.setImageResource(marcas.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return this.marcas.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MarcaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView marca;
        ImageView logo;

        MarcaViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            marca = (TextView) itemView.findViewById(R.id.marca);
            logo = (ImageView) itemView.findViewById(R.id.logo);
        }
    }

}
package com.example.fisio_movil;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListaServicios> mData;
    private LayoutInflater mInflater;
    private Context context;

   public ListAdapter(List<ListaServicios> itemList, Context context){
       this.mData = itemList;
       this.mInflater = LayoutInflater.from(context);
       this.context = context;
   }

    @Override
    public int getItemCount(){

        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.lista_servicios, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int POSITION){
        holder.bindData(mData.get(POSITION));
    }

    public void setItems(List<ListaServicios> items)
    {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipoServicio, profesionalServicio, fechaServicio, statusServicio;

        ViewHolder(View itemView){
            super(itemView);
            tipoServicio = itemView.findViewById(R.id.servicioTomado);
            profesionalServicio = itemView.findViewById(R.id.profesionalServicio);
            fechaServicio = itemView.findViewById(R.id.fechaServicio);
            statusServicio = itemView.findViewById(R.id.statusServicio);
        }

        void bindData(final ListaServicios item){
            tipoServicio.setText(item.getTipoServicio());
            profesionalServicio.setText(item.getProfesionalServicio());
            fechaServicio.setText(item.getFechaServicio());
            statusServicio.setText(item.getStatusServicio());
        }
    }

}

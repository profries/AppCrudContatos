        package com.example.iossenac.apprecycleviewcontatos.adapter;

        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.iossenac.apprecycleviewcontatos.R;
        import com.example.iossenac.apprecycleviewcontatos.model.Contato;

        import java.util.List;

        public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder>
        {

            private List<Contato> listaContatos;

            public ContatoAdapter(List<Contato> listaContatos) {
                this.listaContatos = listaContatos;
            }

            @Override
            public ContatoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_contato,parent,false );
                ViewHolder viewHolder = new ViewHolder(view);

                return viewHolder;
            }

            @Override
            public void onBindViewHolder(ContatoAdapter.ViewHolder holder, final int position) {
                    holder.imagePessoa.setImageResource(listaContatos.get(position).getImagemR());
                    holder.textNome.setText(listaContatos.get(position).getNome());
                    holder.textTelefone.setText(listaContatos.get(position).getTelefone());

                    holder.itemView.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                                    Toast.makeText(v.getContext(),
                                        listaContatos.get(position).getNome()+" selecionado",
                                    Toast.LENGTH_SHORT).show();
                                }
                            });

            }

            @Override
            public int getItemCount() {
                return listaContatos.size();
            }


            public static class ViewHolder extends RecyclerView.ViewHolder{
                public ImageView imagePessoa;
                public TextView textNome;
                public TextView textTelefone;
                public ViewHolder(View view) {
                        super(view);
                        this.imagePessoa = view.findViewById(R.id.imagePessoa);
                        this.textNome = view.findViewById(R.id.textNome);
                        this.textTelefone = view.findViewById(R.id.textTelefone);

                }
            }

        }

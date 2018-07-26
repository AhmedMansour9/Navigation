package navigation.navigationdrawer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import navigation.navigationdrawer.Activites.MainActivity;
import navigation.navigationdrawer.R;

/**
 * Created by HP on 26/07/2018.
 */

public class Secondgroub extends RecyclerView.Adapter<Secondgroub.MyViewHolder> {
   public static int selected_position = -1;
    private String [] listname;
    private int [] listimages;
    Context cont;
    public Secondgroub(Context con,String [] list, int [] lists) {
        this.listname = list;
        this.listimages=lists;
        cont=con;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImageFirstgroub;
        private TextView TextFirstGroub;
        public MyViewHolder(View view) {
            super(view);
            ImageFirstgroub = view.findViewById(R.id.imagescondgroub);
            TextFirstGroub=view.findViewById(R.id.TextscondGroub);

        }

    }


    @Override
    public Secondgroub.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemsecondgroub, parent, false);
        return new Secondgroub.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Secondgroub.MyViewHolder holder, final int position) {
        holder.ImageFirstgroub.setImageResource(listimages [position]);

        holder.itemView.setBackgroundColor(selected_position == position ? Color.CYAN : Color.TRANSPARENT);

        holder.TextFirstGroub.setText(listname [position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == RecyclerView.NO_POSITION) return;
                FirstGroub.selected_position=-1;
                MainActivity.adapterfirstgroub.notifyDataSetChanged();

                // Updating old as well as new positions
                notifyItemChanged(selected_position);
                selected_position = position;
                notifyItemChanged(selected_position);

                selectItem(position);
            }
        });

    }
    private void selectItem(int position) {
        switch (position) {
            case 0:
                MainActivity.drawer.closeDrawer(GravityCompat.START);
                Toast.makeText(cont,listname [position], Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(cont,listname [position], Toast.LENGTH_SHORT).show();
                MainActivity.drawer.closeDrawer(GravityCompat.START);
                break;
            case 2:

                Toast.makeText(cont,listname [position], Toast.LENGTH_SHORT).show();
                MainActivity.drawer.closeDrawer(GravityCompat.START);

                break;




        }
        }
    @Override
    public int getItemCount() {
        return listimages.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
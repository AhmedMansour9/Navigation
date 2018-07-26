package navigation.navigationdrawer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import navigation.navigationdrawer.R;

/**
 * Created by HP on 26/07/2018.
 */

public class header extends RecyclerView.Adapter<header.MyViewHolder> {

     ArrayList<String> list=new ArrayList<>();
    public header(ArrayList<String> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.imageViewItemHeader);

        }

    }


    @Override
    public header.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.headeritem, parent, false);
        return new header.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final header.MyViewHolder holder, final int position) {
        holder.image.setImageResource(R.drawable.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
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
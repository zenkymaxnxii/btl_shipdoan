package com.hhqit.shipdoan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMonAn extends RecyclerView.Adapter<AdapterMonAn.ViewHolder> {
    private List<MonAn> monAnList;
    private Context context;
    private String KEY_DOMAIN = "http://shipdoan.tk";

    public AdapterMonAn(List<MonAn> monAnList, Context context) {
        this.monAnList = monAnList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.mon_an,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MonAn monAn = monAnList.get(i);
        Picasso.with(context).load(KEY_DOMAIN+monAn.getImages()).resize(500,450).into(viewHolder.ivImages);
        viewHolder.tvName.setText(monAn.getName());
        viewHolder.tvPrice.setText(conVert(monAn.getPrice()));
    }

    @Override
    public int getItemCount() {
        return monAnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName,tvPrice;
        private ImageView ivImages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivImages = itemView.findViewById(R.id.ivImages);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MonAn i = monAnList.get(getAdapterPosition());
                    Intent it = new Intent(context,DetailActivity.class);
                    it.putExtra("name",i.getName());
                    it.putExtra("id",i.getId());
                    it.putExtra("des",i.getDescription());
                    it.putExtra("img",i.getImages());
                    it.putExtra("price",conVert(i.getPrice()));
                    context.startActivity(it);
                }
            });
        }
    }
    public String conVert(int gia){
        String strGia = "";
        int x = gia;
        int dem = 0;
        if(x==0) dem++;
        while(x>0){
            dem++;
            x=x/10;
        }
        char[] chars = ("" + gia).toCharArray();
        int dem2=0;
        for (int i=dem-1;i>=0;i--){
            if (dem2==3){
                strGia+=".";
                dem2 = 0;
            }
            dem2++;
            strGia+=chars[i];
        }
        String reverse = new StringBuffer(strGia).
                reverse().toString();
        strGia = reverse+" vnđ";
        return strGia;
    }
}

package com.hhqit.shipdoan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMonAn extends Fragment {
    private RecyclerView recyclerView;
    private List<MonAn> monAnList = new ArrayList<>();
    private AdapterMonAn adapterMonAn;
    private int id = 0;
    public static FragmentMonAn newInstanse(int id){
        FragmentMonAn fragmentMonAn = new FragmentMonAn();
        Bundle agrs = new Bundle();
        agrs.putInt("ID",id);
        fragmentMonAn.setArguments(agrs);
        return  fragmentMonAn;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("ID");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mon_an,container,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapterMonAn = new AdapterMonAn(monAnList,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMonAn);
        loadData();
        return view;
    }
    private void loadData() {
        RetrofitBase.getRetrofit().create(RetrofitBase.Api.class)
                .getDataMonAn("quan",id)
                .enqueue(new Callback<ResponseMonAn>() {
                    @Override
                    public void onResponse(Call<ResponseMonAn> call, Response<ResponseMonAn> response) {
                        monAnList.clear();
                        monAnList.addAll(response.body().getMonAnList());
                        adapterMonAn.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<ResponseMonAn> call, Throwable t) {
                        Log.e("Fail",t.getMessage());
                    }
                });
    }
}

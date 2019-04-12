package com.hhqit.shipdoan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MuaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua);
        Intent i = this.getIntent();
        final int id = i.getIntExtra("id", 0);
        findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtHoTen = findViewById(R.id.editName);
                EditText edtDiaChi = findViewById(R.id.editDiaChi);
                EditText edtSDT = findViewById(R.id.editSDT);
                EditText edtSoLuong = findViewById(R.id.editSoLuong);

                final String hoTen = edtHoTen.getText().toString();
                final String diaChi = edtDiaChi.getText().toString();
                final String sdt = edtSDT.getText().toString();
                final String sl = edtSoLuong.getText().toString();
                if (hoTen.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || sl.isEmpty()) {
                    Toast.makeText(MuaActivity.this, "Không được để trống!", Toast.LENGTH_SHORT).show();
                } else {
                    final int soLuong = Integer.parseInt(sl);
                    final ProgressBar progressBar = findViewById(R.id.progressBar);
                    LinearLayout linearLayout = findViewById(R.id.layout1);
                    linearLayout.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    RetrofitBase.getRetrofit().create(RetrofitBase.Api.class)
                            .setDatHang(id, hoTen, diaChi, sdt, soLuong)
                            .enqueue(new Callback<setResponse>() {
                                @Override
                                public void onResponse(Call<setResponse> call, Response<setResponse> response) {
                                    Log.e("set Dat Hang", response.body().getMessage());
                                    if (response.body().isStatus()) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        showAlertDialog();
                                    }
                                }

                                @Override
                                public void onFailure(Call<setResponse> call, Throwable t) {
                                    Log.e("Fail", t.getMessage());
                                }
                            });

                }
            }
        });
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đặt mua hàng");
        builder.setMessage("Bạn đã đặt hàng thành công vui lòng chờ trong ít phút, nhân viên của chúng tôi sẽ liên hệ đến quý khách!");
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent it = new Intent(MuaActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}

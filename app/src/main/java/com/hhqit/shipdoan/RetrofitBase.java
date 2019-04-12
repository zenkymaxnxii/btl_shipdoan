package com.hhqit.shipdoan;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class RetrofitBase {
    private static Retrofit retrofit;
    private static String DOMAIN = "http://shipdoan.tk/";
    private static String BASE_URL = DOMAIN + "/android/api/";

    public static Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public interface Api{
        @GET("get.php?action=get")
        public Call<ResponseMonAn> getDataMonAn(@Query("token") String token,@Query("idDoAn") int idDoAn);

        @POST("set.php")
        @FormUrlEncoded
        public Call<setResponse> setDatHang(@Field("id") int id,@Field("hoTen") String hoTen,@Field("diaChi") String diaChi,@Field("sdt") String sdt,@Field("soLuong") int sl);
    }
}

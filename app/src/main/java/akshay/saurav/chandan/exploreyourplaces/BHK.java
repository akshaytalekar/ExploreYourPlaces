package akshay.saurav.chandan.exploreyourplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


import akshay.saurav.chandan.exploreyourplaces.model.BhkModel;
import akshay.saurav.chandan.exploreyourplaces.services.BhkApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BHK extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager mLayoutManager;

    private List<BhkModel> proDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_h_k);

        rv = findViewById(R.id.recycler);
        mLayoutManager=new LinearLayoutManager(getApplicationContext());
        mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rv.setLayoutManager(mLayoutManager);

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BhkApi.BASE_URL) // Specify your api here
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BhkApi api = retrofit.create(BhkApi.class);

        Call<List<BhkApi>> call = api.getdatabkh();*/

        Call<List<BhkApi>> call = MainActivity.bhkApi.getdatabkh();
        call.enqueue(new Callback<List<BhkApi>>() {
            @Override
            public void onResponse(Call<List<BhkApi>> call, Response<List<BhkApi>> response) {
                List<BhkApi> adslist = response.body();
                adapter=new BHKAdapter(adslist,BHK.this);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BhkApi>> call, Throwable t) {
                Toast.makeText(BHK.this, "Something Went wrong!!!!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}



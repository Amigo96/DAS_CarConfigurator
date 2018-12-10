package mk.ukim.finki.das.carconfigurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationCountries;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.MercedesConfiguratorInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.RetrofitServiceCreator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity_boki extends AppCompatActivity {

    /*private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;*/
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RetrofitServiceCreator creator;
    private List<ConfigurationCountries> list_countries;
    private Button btnCountry1;
    private Button btnCountry2;
    private Button btnCountry3;
    private Map<Button, ConfigurationCountries> simpleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_boki);
        creator = new RetrofitServiceCreator();

       /* mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);*/
        setButtons();
        simpleMap = new HashMap<>();
    }

    private void setButtons(){
        btnCountry1 = findViewById(R.id.btnCountry1);
        btnCountry2 = findViewById(R.id.btnCountry2);
        btnCountry3 = findViewById(R.id.btnCountry3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(simpleMap.isEmpty()) {
            OkHttpClient client = httpClient.build();
            Retrofit retrofit = creator.createService("https://api.mercedes-benz.com/", client);
            MercedesConfiguratorInterface service = retrofit.create(MercedesConfiguratorInterface.class);
            getResultsFromAPICall(service);
        }else{
            setButtons();
        }
    }

    private void getResultsFromAPICall(MercedesConfiguratorInterface service){

        service.countriesGetter("f93bf5c8-7b74-4a9f-9dfb-345c3f7f0dcf").enqueue(new Callback<List<ConfigurationCountries>>() {
            @Override
            public void onResponse(Call<List<ConfigurationCountries>> call, Response<List<ConfigurationCountries>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity_boki.this, "Data is collected", Toast.LENGTH_SHORT).show();
                    Log.i("MainActivity", response.body().get(0).getAllLinks().toString());
                    list_countries = response.body();
                    /*mAdapter = new MyAdapter(fillDataset(list_countries));
                    mRecyclerView.setAdapter(mAdapter);*/
                    setButtons(list_countries);
                }else{
                    Toast.makeText(MainActivity_boki.this, "Error in collecting the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ConfigurationCountries>> call, Throwable t) {
                Toast.makeText(MainActivity_boki.this, "Network fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private String[] fillDataset(List<ConfigurationCountries> list){
//        String[] array = new String[list.size()];
//        for(int i = 0 ; i < list.size() ; i++){
//            array[i] = list.get(i).getCountry();
//        }
//        return array;
//    }

    private void setButtons(List<ConfigurationCountries> list){
        btnCountry1.setText(list.get(0).getCountry());
        btnCountry2.setText(list.get(1).getCountry());
        btnCountry3.setText(list.get(2).getCountry());

        simpleMap.put(btnCountry1, list.get(0));
        simpleMap.put(btnCountry2, list.get(1));
        simpleMap.put(btnCountry3, list.get(2));

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCountry1 = findViewById(R.id.btnCountry1);
        btnCountry2 = findViewById(R.id.btnCountry2);
        btnCountry3 = findViewById(R.id.btnCountry3);
        btnCountry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClassActivity(simpleMap.get(btnCountry1).getCountry(), simpleMap.get(btnCountry1).getAllLinks().getClassesLink());
            }
        });

        btnCountry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClassActivity(simpleMap.get(btnCountry2).getCountry(), simpleMap.get(btnCountry2).getAllLinks().getClassesLink());
            }
        });


        btnCountry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClassActivity(simpleMap.get(btnCountry3).getCountry(), simpleMap.get(btnCountry3).getAllLinks().getClassesLink());
            }
        });

    }

    private void startClassActivity(String country, String link){
        Intent classActivity = new Intent(this, ClassActivity.class);
        classActivity.putExtra("Country", country);
        classActivity.putExtra("Link", link);
        startActivity(classActivity);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleMap.clear();
    }
}

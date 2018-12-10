package mk.ukim.finki.das.carconfigurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationCountries;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses.Model;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ModelActivityRetrofitInterface.MercedesConfigurationModels;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.RetrofitServiceCreator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelActivity extends AppCompatActivity {

    private String country;
    private String class_name;
    private String baseURL;
    private TextView model_activity_text_view;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RetrofitServiceCreator creator;
    private Button btn_model_1;
    private Button btn_model_2;
    private Button btn_model_3;
    private List<Model> model_list;
    private Map<Button, Model> simple_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        //Setting the primary variables (country, class_name, baseURL)
        setPrimaryVariables();
        //Setting the text view
        setTextView();
        //Retrofit
        creator = new RetrofitServiceCreator();
        //Set buttons
        setButtons();
        //Set map
        simple_map = new HashMap<>();
    }

    private void setButtons(){
        btn_model_1 = findViewById(R.id.buttonModel1);
        btn_model_2 = findViewById(R.id.buttonModel2);
        btn_model_3 = findViewById(R.id.buttonModel3);
    }

    private void setTextView(){
        model_activity_text_view = findViewById(R.id.textViewModelActivity);
        model_activity_text_view.setText("Country :     " + country + "\nClass name :       " + class_name);
    }

    private void setPrimaryVariables(){
        Intent class_activtiy_intent = getIntent();
        this.country = class_activtiy_intent.getStringExtra("Country");
        this.class_name = class_activtiy_intent.getStringExtra("Class_name");
        this.baseURL = formatLink(class_activtiy_intent.getStringExtra("Models_link"));
    }

    private String formatLink(String link){
        String[] split_link = link.split("\\?");
        return split_link[0] + "/";
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(simple_map.isEmpty()) {
            OkHttpClient client = httpClient.build();
            Retrofit retrofit = creator.createService(baseURL, client);
            MercedesConfigurationModels service = retrofit.create(MercedesConfigurationModels.class);
            getResultFromAPICall(service);
        }else{
            setButtons();
        }
    }

    private void getResultFromAPICall(MercedesConfigurationModels service){
        service.getModels("f93bf5c8-7b74-4a9f-9dfb-345c3f7f0dcf").enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ModelActivity.this, "Data collected", Toast.LENGTH_SHORT).show();
                    model_list = response.body();
                    Log.i("ModelActivity", response.body().get(0).getModelName());
                    setButtonNames();
                }else{
                    Toast.makeText(ModelActivity.this, "Error in collecting data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(ModelActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i("ModelActivity", call.request().toString());
                Log.i("ModelActivity", t.getLocalizedMessage());
            }
        });
    }

    private void setButtonNames(){
        btn_model_1.setText(model_list.get(0).getModelName());
        btn_model_2.setText(model_list.get(1).getModelName());
        btn_model_3.setText(model_list.get(2).getModelName());

        simple_map.put(btn_model_1, model_list.get(0));
        simple_map.put(btn_model_2, model_list.get(1));
        simple_map.put(btn_model_3, model_list.get(2));
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_model_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model = simple_map.get(btn_model_1);
                startConfigurationActivity(model.getModelName(), class_name, country, model.getModelLinks().getConfigurationLink());
            }
        });

        btn_model_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model = simple_map.get(btn_model_2);
                startConfigurationActivity(model.getModelName(), class_name, country, model.getModelLinks().getConfigurationLink());
            }
        });

        btn_model_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model = simple_map.get(btn_model_3);
                startConfigurationActivity(model.getModelName(), class_name, country, model.getModelLinks().getConfigurationLink());
            }
        });

    }

    private void startConfigurationActivity(String model_name, String class_name, String country, String link){
        Intent intent = new Intent(this, ConfigurationaActivity.class);
        intent.putExtra("Model_name", model_name);
        intent.putExtra("Class_name", class_name);
        intent.putExtra("Country", country);
        intent.putExtra("Link", link);
        startActivity(intent);
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
        simple_map.clear();
    }
}

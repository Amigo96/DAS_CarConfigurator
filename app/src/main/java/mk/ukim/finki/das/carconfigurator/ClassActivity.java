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

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees.ClassLinks;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees.MercedesClasses;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ClassActivityRetrofitClasses.MercedesConfigurationClassesInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.RetrofitServiceCreator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClassActivity extends AppCompatActivity {

    private String country;
    private String baseURL;
    private TextView textViewNameOfActivity;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RetrofitServiceCreator creator;
    private static final String TAG = "ClassActivity";
    private Button btn_class_1;
    private Button btn_class_2;
    private Button btn_class_3;
    private List<MercedesClasses> classes;
    private Map<Button, MercedesClasses> simple_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        //Getting resources from the intent call
        set_primary_data();
        //Setting the text view of the class activity
        set_text_view();
        creator = new RetrofitServiceCreator();
        //Button setting
        set_buttons();
        //Setting the map
        simple_map = new HashMap<>();
    }

    private void set_buttons(){
        btn_class_1 = findViewById(R.id.btnClass1);
        btn_class_2 = findViewById(R.id.btnClass2);
        btn_class_3 = findViewById(R.id.btnClass3);
    }

    private void set_primary_data(){
        Intent intent = getIntent();
        this.country = intent.getStringExtra("Country");
        this.baseURL = formatLink(intent.getStringExtra("Link"));
    }

    private void set_text_view(){
        textViewNameOfActivity = findViewById(R.id.text_view_class_activity);
        textViewNameOfActivity.setText(country);
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
            MercedesConfigurationClassesInterface service = retrofit.create(MercedesConfigurationClassesInterface.class);
            getResultsFromAPICall(service);
        }else{
            set_buttons();
        }
    }

    private void getResultsFromAPICall(MercedesConfigurationClassesInterface service){

        service.getClasses("f93bf5c8-7b74-4a9f-9dfb-345c3f7f0dcf").enqueue(new Callback<List<MercedesClasses>>() {
            @Override
            public void onResponse(Call<List<MercedesClasses>> call, Response<List<MercedesClasses>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ClassActivity.this, "Data is collected", Toast.LENGTH_SHORT).show();
                    classes = response.body();
                    set_btn_text();
                }else{
                    Toast.makeText(ClassActivity.this, "Error in collecting the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MercedesClasses>> call, Throwable t) {
                Toast.makeText(ClassActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i(TAG, call.request().toString());
                Log.i(TAG, t.getLocalizedMessage());
            }
        });

    }

    private void set_btn_text(){
        btn_class_1.setText(classes.get(0).getClassName());
        btn_class_2.setText(classes.get(1).getClassName());
        btn_class_3.setText(classes.get(2).getClassName());

        simple_map.put(btn_class_1, classes.get(0));
        simple_map.put(btn_class_2, classes.get(1));
        simple_map.put(btn_class_3, classes.get(2));
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_class_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModelActivity(simple_map.get(btn_class_1).getClassName(), simple_map.get(btn_class_1).getAllLinks().getModelsLink());
            }
        });

        btn_class_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModelActivity(simple_map.get(btn_class_2).getClassName(), simple_map.get(btn_class_2).getAllLinks().getModelsLink());
            }
        });

        btn_class_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startModelActivity(simple_map.get(btn_class_3).getClassName(), simple_map.get(btn_class_3).getAllLinks().getModelsLink());
            }
        });

    }

    private void startModelActivity(String class_name, String link){
        Intent model_intent = new Intent(this, ModelActivity.class);
        model_intent.putExtra("Country", country);
        model_intent.putExtra("Class_name", class_name);
        model_intent.putExtra("Models_link", link);
        startActivity(model_intent);
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

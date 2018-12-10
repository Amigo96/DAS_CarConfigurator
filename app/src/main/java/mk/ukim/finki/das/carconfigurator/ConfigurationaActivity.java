package mk.ukim.finki.das.carconfigurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.Configuration;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.StringBuilders.BuilderStrings;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ConfigurationActvitiyRetrofitInterface.MercedesCarConfigurationInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.RetrofitServiceCreator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConfigurationaActivity extends AppCompatActivity {

    private String country;
    private String model_name;
    private String class_name;
    private String baseURL;
    private TextView textViewConfigurationActivity;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RetrofitServiceCreator creator;
    private BuilderStrings strings;
    private Configuration configuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurationa);
        //Set primary variables
        setPrimaryVariable();
        //Set text view
        setTextView();
        //set retrofit
        creator = new RetrofitServiceCreator();
        //Strings
        strings = new BuilderStrings();
    }

    private void setPrimaryVariable(){
        Intent model_intent = getIntent();
        country = model_intent.getStringExtra("Country");
        model_name = model_intent.getStringExtra("Model_name");
        class_name = model_intent.getStringExtra("Class_name");
        baseURL = formatLink(model_intent.getStringExtra("Link"));
    }

    private String formatLink(String link){
        String[] split_link = link.split("\\?");
        return split_link[0] + "/";
    }

    private void setTextView(){
        textViewConfigurationActivity = findViewById(R.id.TextViewConfigurationActivity);
        String text = buildText();
        textViewConfigurationActivity.setText(text);
    }

    private String buildText(){
        return new StringBuilder().append("Country: ").append(country)
                .append("\n").append("Class: ").append(class_name)
                .append("\n").append("Model name: ").append(model_name)
                .toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService(baseURL, client);
        MercedesCarConfigurationInterface service = retrofit.create(MercedesCarConfigurationInterface.class);
        getResultsFromAPICall(service);
    }

    private void getResultsFromAPICall(MercedesCarConfigurationInterface service){

        service.getConfiguration("f93bf5c8-7b74-4a9f-9dfb-345c3f7f0dcf").enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ConfigurationaActivity.this, "Data is collected", Toast.LENGTH_SHORT).show();
                    configuration = response.body();
                    setTextViews(configuration);
                }else{
                    Toast.makeText(ConfigurationaActivity.this, "Error in collecting the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
                Toast.makeText(ConfigurationaActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i("ConfigurationaActvitiy", t.getLocalizedMessage());
            }
        });

    }

    private TextView engine_view;
    private TextView fuel;
    private TextView acceleration;
    private TextView topSpeed;
    private TextView enterier;
    private TextView price;

    private void setTextViews(Configuration configuration){
        initTextViews();

        engine_view.setText(strings.engineString(configuration.getTechnicalInformation().getEngine()));
        fuel.setText(strings.fuelString(configuration.getTechnicalInformation().getEngine().getFuel()));
        acceleration.setText(strings.accelerationString(configuration.getTechnicalInformation().getAcceleration()));
        topSpeed.setText(strings.topSpeedString(configuration.getTechnicalInformation().getTopSpeed()));
        enterier.setText(strings.enterierString(configuration.getTechnicalInformation()));
        price.setText(strings.prizeString(configuration.getPrice()));
    }

    private void initTextViews(){
        engine_view = findViewById(R.id.textView1);
        fuel = findViewById(R.id.textView2);
        acceleration = findViewById(R.id.textView3);
        topSpeed = findViewById(R.id.textView4);
        enterier = findViewById(R.id.textView);
        price = findViewById(R.id.textView5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*Button btn = findViewById(R.id.showImage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startImageActivity();
            }
        });*/
    }

   /* private void startImageActivity(){
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("link", configuration.getLinks().getImageLink());
        startActivity(intent);
    }*/
}

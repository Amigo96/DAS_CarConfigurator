package mk.ukim.finki.das.carconfigurator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.das.carconfigurator.ExtraClasses.ClassActivityExtraClasees.MercedesClasses;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationActivityExtraClasses.Configuration;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ConfigurationCountries;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.ModelActivityExtraClasses.Model;
import mk.ukim.finki.das.carconfigurator.ExtraClasses.StringBuilders.BuilderStrings;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ClassActivityRetrofitClasses.MercedesConfigurationClassesInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ConfigurationActvitiyRetrofitInterface.MercedesCarConfigurationInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.MercedesConfiguratorInterface;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.ModelActivityRetrofitInterface.MercedesConfigurationModels;
import mk.ukim.finki.das.carconfigurator.RetrofitModels.RetrofitServiceCreator;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String API_KEY = "27ea6a7d-e247-480c-868b-c1fb8610c97b";

    private List<String> listMarketName = new ArrayList<String>();
    private List<String> listCarClassName = new ArrayList<String>();
    private List<String> listCarModelName = new ArrayList<String>();

    private List<ConfigurationCountries> list_countries;
    private List<MercedesClasses> classes;
    private List<Model> model_list;


    private ConfigurationCountries selectedCountry;
    private MercedesClasses selectedClass;
    private Model selectedModel;
    private String selectedClassId;

    private Spinner marketSpinner ;
    private Spinner carClassSpinner;
    private Spinner carModelSpinner;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private RetrofitServiceCreator creator;

    private TextView engine_view;
    private TextView fuel;
    private TextView acceleration;
    private TextView topSpeed;
    private TextView enterier;
    private TextView price;
    private BuilderStrings strings;
    private Configuration configuration;
    private TextView textViewConfigurationActivity;


    private void very_first_setup(){
        this.listMarketName.add("Click to choose Market - Country");
        strings = new BuilderStrings();
        setupSpinner( marketSpinner, (R.id.market_spinner),  listMarketName);
        setupSpinner( carClassSpinner, (R.id.class_spinner),  listCarClassName);
        setupSpinner( carModelSpinner, (R.id.model_spinner),  listCarModelName);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        very_first_setup();
        creator = new RetrofitServiceCreator();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//    btn_dealer = findViewById(R.id.nav_dealer);

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = creator.createService("https://api.mercedes-benz.com/", client);
        MercedesConfiguratorInterface service = retrofit.create(MercedesConfiguratorInterface.class);
        getResultsFromAPICall(service);


    }

    private void setupSpinner(Spinner spinner, int viewid,  List<String> items){
        spinner = (Spinner) findViewById(viewid);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_configurator) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_news) {

        } else if (id == R.id.nav_dealer) {
                    Intent classActivity = new Intent(this, MainActivity_boki.class);
//        classActivity.putExtra("Country", country);
//        classActivity.putExtra("Link", link);
        startActivity(classActivity);


        } else if (id == R.id.market_spinner) {


        }

//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void startClassActivity(){
//        Intent classActivity = new Intent(this, MainActivity_boki.class);
////        classActivity.putExtra("Country", country);
////        classActivity.putExtra("Link", link);
//        startActivity(classActivity);
//    }

    protected void onStart() {
        super.onStart();
//        OkHttpClient client = httpClient.build();
//        Retrofit retrofit = creator.createService("https://api.mercedes-benz.com/", client);
//        MercedesConfiguratorInterface service = retrofit.create(MercedesConfiguratorInterface.class);
//        getResultsFromAPICall(service);

    }

    private void getResultsFromAPICall(MercedesConfiguratorInterface service){

        service.countriesGetter(this.API_KEY ).enqueue(new Callback<List<ConfigurationCountries>>() {
            @Override
            public void onResponse(Call<List<ConfigurationCountries>> call, Response<List<ConfigurationCountries>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Market data collected", Toast.LENGTH_SHORT).show();
                    Log.i("MainActivity", response.body().get(0).getAllLinks().toString());
                    list_countries = response.body();
                    fillSpinner(list_countries);
                }else{
                    Toast.makeText(MainActivity.this, "Error in collecting Market data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ConfigurationCountries>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getResultsFromAPICallClass(MercedesConfigurationClassesInterface service){

        service.getClasses(this.API_KEY).enqueue(new Callback<List<MercedesClasses>>() {
            @Override
            public void onResponse(Call<List<MercedesClasses>> call, Response<List<MercedesClasses>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Class data collected", Toast.LENGTH_SHORT).show();
                    classes = response.body();
                    fillClassSpinner(classes);
//                    set_btn_text();
                }else{
                    Toast.makeText(MainActivity.this, "Error in collecting the data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MercedesClasses>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i("MRK ", call.request().toString());
                Log.i("MRK TAG", t.getLocalizedMessage());
            }
        });

    }

    private void getResultsFromAPICallCarModel(MercedesConfigurationModels service) {
//                R.string.configurator_api_key
        service.getModels("190", this.API_KEY).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Car Models data collected", Toast.LENGTH_SHORT).show();
                    model_list = response.body();

                    for (Model item : model_list) {
                        String drzavickaIme = item.getModelName().toString();

                        System.out.println(drzavickaIme);
                        listCarModelName.add(drzavickaIme);
                    }
                    fillCarModelSpinner(model_list);
//                            Log.i("ModelActivity" , response.body().get(0).getModelName());
//                            setButtonNames();
                } else {
                    Toast.makeText(MainActivity.this, "Error in CAAR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i("ModelActivity", call.request().toString());
                Log.i("ModelActivity", t.getLocalizedMessage());
            }
        });
    }

    private void getResultsFromAPICallModelDetails(MercedesCarConfigurationInterface service){

        service.getConfiguration(this.API_KEY).enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(Call<Configuration> call, Response<Configuration> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Data CarDetails are collected", Toast.LENGTH_SHORT).show();
                    configuration = response.body();
                    System.out.print(configuration.toString());
                    setTextViews(configuration);
                }else{
                    Toast.makeText(MainActivity.this, "Error in collecting the CarDetails", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network failed", Toast.LENGTH_SHORT).show();
                Log.i("ConfigurationaActvitiy", t.getLocalizedMessage());
            }
        });

    }


    private void fillClassSpinner(List<MercedesClasses> list){
        listCarClassName = new ArrayList<>();
        listCarClassName.add("Choose Car Class");
        for (MercedesClasses item : list) {
            String className = item.getClassName().toString();

            System.out.println(className);
            listCarClassName.add(className);
        }

        this.carClassSpinner = (Spinner) findViewById(R.id.class_spinner);
        ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listCarClassName);
        aAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.carClassSpinner.setAdapter(aAdpt);

        this.carClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String carClass = parent.getItemAtPosition(position).toString();
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "You choose a class: " + carClass, Toast.LENGTH_SHORT).show();

                    MercedesClasses classObject = findClassObject(carClass);
                    selectedClass = classObject;
                    OkHttpClient client = httpClient.build();

//                    Create Car Models!!
                    System.out.println("mrk-> classes ulr : " + classObject.getAllLinks().getModelsLink());
//                    "https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models?bodyId=1" formatClassLink(classObject.getAllLinks().getModelsLink())
//                    https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models/190378_000/configurations/
                    Retrofit retrofit = creator.createService( "https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models/" , client); //"https://api.mercedes-benz.com/configurator/v1/markets/de_DE/classes/"
                    MercedesConfigurationModels service2 = retrofit.create(MercedesConfigurationModels.class);
                    getResultsFromAPICallCarModel(service2);
                    Toast.makeText(MainActivity.this, "Car models data collected  ! : ", Toast.LENGTH_SHORT).show();
//                  Car Models finished !
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//          pass
            }
        });
    }

    private void fillCarModelSpinner(List<Model> list){
        listCarModelName = new ArrayList<>();
        listCarModelName.add("Choose Car model");
        for (Model item : list) {
            String drzavickaIme = item.getModelName().toString();

            System.out.println(drzavickaIme);
            listCarModelName.add(drzavickaIme);
        }

        this.carModelSpinner = (Spinner) findViewById(R.id.model_spinner);
        ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listCarModelName);
        aAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.carModelSpinner.setAdapter(aAdpt);

        this.carModelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String carModel = parent.getItemAtPosition(position).toString();
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "You choose a  car model " + carModel, Toast.LENGTH_SHORT).show();

                    Model modelObject = findModelObject(carModel);
                    selectedModel = modelObject;

                    OkHttpClient client = httpClient.build();

//                    Create Car Models!!
                    System.out.println("mrk-> MOOODEL  ulr : " + modelObject.getModelLinks().getConfigurationLink());
                    System.out.println("mrk-> MOOODEL  URL - 2 : " + modelObject.getModelLinks().getSelfLink());
                    //                    "https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models?bodyId=1 formatModelLink(modelObject.getModelLinks().getConfigurationLink())
//                    https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models/190378_000/configurations/
                    Retrofit retrofit = creator.createService( "https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models/190378_000/configurations/" , client); //"https://api.mercedes-benz.com/configurator/v1/markets/de_DE/classes/"
                    MercedesCarConfigurationInterface service3 = retrofit.create(MercedesCarConfigurationInterface.class);
                    getResultsFromAPICallModelDetails(service3);
//                    Toast.makeText(MainActivity.this, "Ubuta ga u car models ! : ", Toast.LENGTH_SHORT).show();
//                  Car Models finished !
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//          pass
            }
        });
    }

    private void fillSpinner(List<ConfigurationCountries> list){
        ConfigurationCountries theCountry = new ConfigurationCountries();
        for (ConfigurationCountries item : list) {
            String drzavickaIme = item.getCountry().toString();
            theCountry = item;

            System.out.println(drzavickaIme);
            listMarketName.add(drzavickaIme);
        }

        this.marketSpinner = (Spinner) findViewById(R.id.market_spinner);
        ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listMarketName);
        aAdpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.marketSpinner.setAdapter(aAdpt);

        this.marketSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "You choose market: " + country, Toast.LENGTH_SHORT).show();
                    ConfigurationCountries drzavaObjekt = findCountryObject(country);
                    selectedCountry = drzavaObjekt;

                    OkHttpClient client = httpClient.build();

//                    Create Classes!!
                    System.out.println("mrk ! -> url classes " + drzavaObjekt.getAllLinks().getClassesLink() );
                    Retrofit retrofit = creator.createService("https://api.mercedes-benz.com/configurator/v1/markets/de_DE/classes/" , client); //"https://api.mercedes-benz.com/configurator/v1/markets/de_DE/classes/" formatClassLink(drzavaObjekt.getAllLinks().getClassesLink())
                    MercedesConfigurationClassesInterface service = retrofit.create(MercedesConfigurationClassesInterface.class);
                    getResultsFromAPICallClass(service);
                    Toast.makeText(MainActivity.this, "Car class data collected ", Toast.LENGTH_SHORT).show();
//                  Classes finished !

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//          pass
            }
        });
    }

    private ConfigurationCountries findCountryObject(String name){
        ConfigurationCountries tmpCountry = list_countries.get(0);
        for (ConfigurationCountries item : list_countries) {
            String drzavickaIme = item.getCountry().toString();

            if (name.equals(drzavickaIme)){
                tmpCountry = item;
                break;
            }
        }
        return tmpCountry;

    }

    private MercedesClasses findClassObject(String name){
        MercedesClasses tmpCountry = classes.get(0);
        for (MercedesClasses item : classes) {
            String drzavickaIme = item.getClassName().toString();

            if (name.equals(drzavickaIme)){
                tmpCountry = item;
                break;
            }
        }
        return tmpCountry;

    }

    private Model findModelObject(String carModel){
        Model tmpCountry = model_list.get(0);
        for (Model item : model_list) {
            String drzavickaIme = item.getModelName().toString();

            if (carModel.equals(drzavickaIme)){
                tmpCountry = item;
                break;
            }
        }
        return tmpCountry;
    }

    private void setTextView(){
        textViewConfigurationActivity = findViewById(R.id.TextViewConfigurationActivity);
        String text ="Default Configuration - Technical information";
        textViewConfigurationActivity.setText(text);
    }

    private String formatClassLink(String link) {
        String[] split_link = link.split("\\?");
        System.out.println("splitLink = " + split_link[0] + "/");
        return split_link[0] + "/";
    }

    private String formatModelLink(String link) {
        String[] split_link = link.split("\\?");
        System.out.println("splitLink = " + split_link[0] + "/");
        String[] split_link2 = split_link[1].split("\\&");
        String[] split_link3 = split_link[0].split("\\=");
        this.selectedClassId = split_link3[1];

        return split_link[0] + "/";
    }

    private String formatLink(String link){
//        String[] split_link = link.split("\\?");
//        System.out.println("splitLink = " + split_link[0] + "/" );
//        return split_link[0] + "/";
        return "https://api.mercedes-benz.com/configurator/v1/markets/de_DE/models/190379_000/configurations/";
    }

    private void setTextViews(Configuration configuration){
        setTextView();
        initTextViews();
//        engine_view = (TextView) findViewById(R.id.textView1);
//        fuel = (TextView) findViewById(R.id.textView2);
//        acceleration = (TextView) findViewById(R.id.textView3);
//        topSpeed = (TextView) findViewById(R.id.textView4);
//        enterier = (TextView) findViewById(R.id.textView);
//        price = (TextView) findViewById(R.id.textView5);


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


}

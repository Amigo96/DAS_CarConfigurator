package mk.ukim.finki.carconfiguratorfinal.Dealer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.DealerAdapter.Adapter;
import mk.ukim.finki.carconfiguratorfinal.MainActivityService;
import mk.ukim.finki.carconfiguratorfinal.R;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer.Dealer;
import mk.ukim.finki.carconfiguratorfinal.Tasks.Dealer.AsyncResponseDealer;
import mk.ukim.finki.carconfiguratorfinal.Tasks.Dealer.DownloadDealerInformation;

public class DealerActivity extends AppCompatActivity {

    /***
     * This activity is started when clicking on one of the buttons dealer from the menu.
     */

    //Field components
    private Button submitButton;
    private EditText editTextCity;
    private EditText editTextCarModel;

    //Variables
    private String city;
    private String carModel;
    private boolean cityFirstClick;
    private boolean carModelFirstClick;
    private static int clicksCar = 0;
    private static int clicksModel = 0;
    private String api_key;
    private MainActivityService service;
    private Dealer dealerObject;
    private RecyclerView recyclerView;

    //Async Calls
    private DownloadDealerInformation asyncCallDealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);

        setFieldComponents(); //Function that initializes the fields from the activity.
        cityFirstClick = true;
        carModelFirstClick = true;

        api_key = getString(R.string.api_key1_dealer);
        service = new MainActivityService();

        recyclerView = findViewById(R.id.recyclerViewDealer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Connects the fields with the ids from the activity_dealer.xml layout
    private void setFieldComponents(){
        submitButton = findViewById(R.id.btn_submit);
        editTextCity = findViewById(R.id.editTextCity);
        editTextCarModel = findViewById(R.id.editTextCarModel);
    }


    @Override
    protected void onResume() {
        super.onResume();

        editTextCity.setOnClickListener(new View.OnClickListener() { //Handler for the event on click text edit city
            @Override
            public void onClick(View v) {
                //Functionality to clear the written text.
                clicksCar++;
                clicksModel = 0;

                if(cityFirstClick) {
                    editTextCity.setText("");
                    cityFirstClick = false;
                }

                if(clicksCar >= 2){ //If number of clicks on city field are bigger or equal then 2
                    clicksCar = 0;
                    cityFirstClick = true;
                }
            }
        });

        editTextCarModel.setOnClickListener(new View.OnClickListener() { //Handler for even click on car model field
            @Override
            public void onClick(View v) {
                //Functionality to clear the written text
                clicksModel++;
                clicksCar = 0;

                if(carModelFirstClick) {
                    editTextCarModel.setText("");
                    carModelFirstClick = false;
                }

                if(clicksModel >= 2){ //if number of clicks on car model field are bigger or equal then 2
                    carModelFirstClick = true;
                    clicksModel = 0;
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() { //Even handler when button submit is clicked
            @Override
            public void onClick(View v) {
                clicksCar = 0;
                clicksModel = 0;
                callForRetrofit(); //Calling the service for collecting the data
            }
        });

    }

    //Function that starts an async task to collect the data.
    private void callForRetrofit(){
        setVariables();

        //Condition which checks if the user has entered data in the given fields or has not entered any data at all
        if(city.trim().length() > 0 && carModel.trim().length() > 0 && !(city.trim().equals("City")) && !(carModel.trim().equals("Car model")) ){
            List<String> list = new ArrayList<>(); //List for data that is needed as input in the async task
            list.add("https://api.mercedes-benz.com/dealer/v1/"); //base url
            list.add(city); //data from city field
            list.add(carModel); //data from car model field
            list.add("dealers(dealerId,legalName,address)"); //Extra part from the link
            list.add(api_key); //Api key for dealer
            asyncCallDealer = (DownloadDealerInformation)new DownloadDealerInformation(new AsyncResponseDealer() { //Async call
                @Override
                public void processFinish(Dealer dealer) {
                    dealerObject = dealer;
                    displayData(dealer); //Display the collected data
                }
            }, this).execute(service.convertListToArray(list));
        }else{
            Toast.makeText(DealerActivity.this, "The two parameters are required", Toast.LENGTH_SHORT).show(); //Message to the user that he needs to enter to all or some fields.
        }

    }

    //Function that gets the information from the fields where the user can enter text.
    private void setVariables(){
        city = editTextCity.getText().toString();
        carModel = editTextCarModel.getText().toString();
    }

    //displayData is a functionality where all the collected data is past to recycler viewer and as much as info is gathered that many buttons are created
    private void displayData(Dealer dealer){
        Log.i("DealerActivity", "Ready on possition");
        Log.i("DealerActivity", dealer.getDealers().get(0).getDealerID());
        recyclerView.setAdapter(new Adapter(this, dealer.getDealers())); //Sets the adapter and sends the data
    }

}

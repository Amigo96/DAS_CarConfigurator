package mk.ukim.finki.carconfiguratorfinal.Dealer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mk.ukim.finki.carconfiguratorfinal.R;

public class DealerInfoActivity extends AppCompatActivity {

    /**
     * Activity which starts once one of the recycler viewer buttons is clicked.
     * Displays the data for the dealer.
     */

    //View elements
    private TextView textViewInfo;

    //Variables
    private String id;
    private String name;
    private String street;
    private String zipCode;
    private String city;
    private String isoCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_info);
        setVariables(getIntent()); //Sets the variables that are sent to this activity through an Intent
        setView(); //Initializes the view fields
        setTextViewInfo(); //Sets the text in the view fields.
    }

    //setVariables is a function that initializes the variables from this class with the data from the Intent
    private void setVariables(Intent intent){
        id = intent.getStringExtra("ID");
        name = intent.getStringExtra("Name");
        street = intent.getStringExtra("Street");
        zipCode = intent.getStringExtra("ZipCode");
        city = intent.getStringExtra("City");
        isoCode = intent.getStringExtra("ISOCode");
    }

    //setView is a function that initializes the view field
    private void setView(){
        textViewInfo = findViewById(R.id.textViewDealerInfo);
    }

    //setTextViewInfo is a function that creates the text that needs to be displayed in the view field.
    private void setTextViewInfo(){
        StringBuilder stringBuilder = new StringBuilder().append("ID: ").append(id).append("\n")
                .append("Name: ").append(name).append("\n")
                .append("Street: ").append(street).append("\n")
                .append("ZipCode: ").append(zipCode).append("\n")
                .append("City: ").append(city).append("\n")
                .append("Code: ").append(isoCode);
        textViewInfo.setText(stringBuilder.toString());
    }

}

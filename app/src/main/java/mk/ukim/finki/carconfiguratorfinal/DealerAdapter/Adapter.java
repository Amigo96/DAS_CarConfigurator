package mk.ukim.finki.carconfiguratorfinal.DealerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import mk.ukim.finki.carconfiguratorfinal.Dealer.DealerInfoActivity;
import mk.ukim.finki.carconfiguratorfinal.R;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer.DealerInfo;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * Adapter class is used by the DealerActivity class, to display the collected data from the dealer api.
     */

    //Variables
    private Context context;
    private List<DealerInfo> infoDealers;

    //Constructor with 2 input parameters: context and infoDealers
    //context is an object from Context class which references to the DealerActivity class.
    //infoDealers is a list of objects from the DealerInfo class.
    public Adapter(Context context, List<DealerInfo> infoDealers){
        this.context = context;
        this.infoDealers = infoDealers;
    }

    //Method generated from the inheritance of RecyclerView.Adapter<RecyclerView.ViewHolder> which connects the DealerActivity with the recycler viewer xml file and initializes an object from the Item class.
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.custom_recycler_view_dealer, viewGroup, false);
        Item item = new Item(row);
        return item;
    }

    //Method generated from the inheritance of RecyclerView.Adapter<RecyclerView.ViewHolder>, in here all the buttons that are generated get a text and a functionality when clicked
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((Item) viewHolder).btnDealer.setText(infoDealers.get(i).getLegalName() + " " + infoDealers.get(i).getDealerID()); //Set the button text
        ((Item) viewHolder).btnDealer.setOnClickListener(new View.OnClickListener(){ //Handling the even when a button is clicked

            @Override
            public void onClick(View v) {
                DealerInfo info = infoDealers.get(i);
                Intent intent = new Intent(context, DealerInfoActivity.class); //A new intent is created for the DealerInfoActivity class.
                intent.putExtra("ID", info.getDealerID());
                intent.putExtra("Name", info.getLegalName());
                intent.putExtra("Street", info.getAddress().getStreet());
                intent.putExtra("ZipCode", info.getAddress().getZipCode());
                intent.putExtra("City", info.getAddress().getCity());
                intent.putExtra("ISOCode", info.getAddress().getCountryIsoCode());
                context.startActivity(intent); //The DealerInfoActivity is started.
            }

        });

    }

    //Method generated from the inheritance of RecyclerView.Adapter<RecyclerView.ViewHolder> returns the size of elements that are send to the recycler viewer in this case the size of the DealerInfo list
    @Override
    public int getItemCount() {
        return infoDealers.size();
    }

    //Class needed so that recycler viewer can function.
    public class Item extends  RecyclerView.ViewHolder{

        //Variables
        Button btnDealer;

        //Constructor
        public Item(@NonNull View itemView) {
            super(itemView);
            btnDealer = itemView.findViewById(R.id.btnDealer); //Initializing the button.
        }
    }

}

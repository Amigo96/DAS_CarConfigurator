package mk.ukim.finki.carconfiguratorfinal.Gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import mk.ukim.finki.carconfiguratorfinal.R;

public class Gallery extends AppCompatActivity {

    /**
     * The Gallery Activity, in here the pictures from the api are displayed to the user.
     */

    //Variables
    private ImageView engine_image;
    private ImageView paint_image;
    private ImageView rim_image;
    private ImageView trim_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setVariables(); //Initializes the image views

        //With Picasso the images are loaded and displayed to the user
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/2/a1/fd2b0e48122486f1376877fe2c010eaeea9f8.jpg").into(engine_image);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/a/54/568eb2488029f0519ce8023983b2c0f1d19fd.jpg").into(paint_image);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/8/3e/b8527539009d03db7b3d9fc3f4a04f7d56dce.png").into(rim_image);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/5/88/a7dc35acb33c955899273d9dad23931e76a63.jpg").into(trim_image);

    }

    //setVariables is a function that initializes the image views with the layout xml
    private void setVariables(){
        engine_image = findViewById(R.id.imageViewEngine);
        paint_image = findViewById(R.id.imageViewPaint);
        rim_image = findViewById(R.id.imageViewRim);
        trim_image = findViewById(R.id.imageViewTrim);
    }
}

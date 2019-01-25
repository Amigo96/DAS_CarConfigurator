package mk.ukim.finki.das.carconfigurator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Gallery_Screen extends AppCompatActivity {
    ImageView ivImageFromURL;
    ImageView ivImage1FromURL;
    ImageView ivImage2FromURL;
    ImageView ivImage3FromURL;
    String url = "https://api.mercedes-benz.com/image/v1/vehicles/WDD2130331A123456/components?apikey=e6f7f762-5d99-45ab-a8c2-329f2ba6c297";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
       ivImageFromURL=(ImageView)findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/2/a1/fd2b0e48122486f1376877fe2c010eaeea9f8.jpg").into(ivImageFromURL);
        ivImage1FromURL=(ImageView)findViewById(R.id.imageView1);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/a/54/568eb2488029f0519ce8023983b2c0f1d19fd.jpg").into(ivImage1FromURL);
        ivImage2FromURL=(ImageView)findViewById(R.id.imageView2);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/8/3e/b8527539009d03db7b3d9fc3f4a04f7d56dce.png").into(ivImage2FromURL);
        ivImage3FromURL=(ImageView)findViewById(R.id.imageView3);
        Picasso.with(getApplicationContext()).load("https://srs-bbd.i.daimler.com/bbd-images/2983/5/88/a7dc35acb33c955899273d9dad23931e76a63.jpg").into(ivImage3FromURL);
    }
}

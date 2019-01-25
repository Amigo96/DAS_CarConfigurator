package mk.ukim.finki.das.carconfigurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageActivity extends AppCompatActivity {

    private String baseURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        baseURL = formatLink(intent.getStringExtra("link"));
    }

    private String formatLink(String link){
        String[] split_link = link.split("\\?");
        return split_link[0] + "/";
    }
}

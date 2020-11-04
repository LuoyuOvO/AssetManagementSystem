package www.glaway.assetmanagementsystem.activity;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected Typeface tfLight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
    }
}

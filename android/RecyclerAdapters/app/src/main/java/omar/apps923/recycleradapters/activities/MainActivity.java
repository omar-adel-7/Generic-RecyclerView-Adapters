package omar.apps923.recycleradapters.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import omar.apps923.recycleradapters.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
    }

    public void showGenericAdapter(View view) {
        Intent intent=new Intent(this,GenericAdapterActivity.class);
        startActivity(intent);
    }

    public void showNormalAdapter(View view) {
        Intent intent=new Intent(this,NormalAdapterActivity.class);
        startActivity(intent);
    }

    public void showDataBindingAdapter(View view) {

        // show activity has adapter code in it
        // Intent intent=new Intent(this,DatabindingAdapterActivity1.class);

        // show activity has adapter code in adapter class
        Intent intent=new Intent(this,DatabindingAdapterActivity2.class);

        startActivity(intent);
    }
}

package omar.apps923.recycleradapters.activities;

import android.support.v7.app.AppCompatActivity;

import omar.apps923.recycleradapters.helpers.IonWrapper;
import omar.apps923.recycleradapters.helpers.WebServices;



public class BaseActivity extends AppCompatActivity implements IonWrapper.WebServiceInterFace
{

    public WebServices webServices ;

    public void initVars()
    {

         webServices = new WebServices( new IonWrapper(this, this));

    }



    @Override
    public void parseString(String response) {

    }

    @Override
    public void failResponse() {

    }


}

package omar.apps923.recycleradapters.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import omar.apps923.recycleradapters.gui.CustomTextView;
import omar.apps923.recycleradapters.gui.RecyclerViewEmptySupport;
import omar.apps923.recycleradapters.R;
import omar.apps923.recycleradapters.adapters.normal.BooksAdapter;
import omar.apps923.recycleradapters.adapters.normal.CustomRecyclerViewAdapter;
import omar.apps923.recycleradapters.models.Book;


public class NormalAdapterActivity extends BaseActivity implements CustomRecyclerViewAdapter.OnViewHolderClick{

     RecyclerViewEmptySupport rv;
    TextView txtvEmpty;
    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_generic_normal_adapter);

        initVars();

        CustomTextView tvToolBarNormal = (CustomTextView)   findViewById(R.id.tvToolBarNormal);
        tvToolBarNormal.setText(getString(R.string.normaladapter_title));



        rv = (RecyclerViewEmptySupport)findViewById(R.id.rv) ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        adapter =new BooksAdapter(this,this);
        rv.setAdapter(adapter);
        txtvEmpty = (TextView)findViewById(R.id.txtvEmpty) ;
        rv.setEmptyView(txtvEmpty);


        getBooks();


    }
    public void getBooks()
    {

        webServices.getBooks();

    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this,
                ((Book)adapter.getList().get(position)).getTitle()+" clicked"+" at position "+position,Toast.LENGTH_SHORT).show();

    }


    @Override
    public void parseString(String response) {



        try {
            JSONObject jObject = new JSONObject(response);

            String success = jObject.getString("success");

            if (success.equalsIgnoreCase("yes")) {
                adapter.clearData();
                JSONArray jsonArray = jObject.getJSONArray("books");
                Book book=new Book(this,jsonArray);
                adapter.addAll(book.basicModels);

            }
            else
            {
                Toast.makeText(getApplicationContext(),getString(R.string.errorinwebservice),Toast.LENGTH_LONG).show();
             }



        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),getString(R.string.errorinwebservice),Toast.LENGTH_LONG).show();
         }



    }

    @Override
    public void failResponse() {

    }


}

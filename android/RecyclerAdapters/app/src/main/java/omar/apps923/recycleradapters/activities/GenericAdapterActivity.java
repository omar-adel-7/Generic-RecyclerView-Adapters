package omar.apps923.recycleradapters.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import omar.apps923.recycleradapters.gui.CustomTextView;
import omar.apps923.recycleradapters.gui.RecyclerViewEmptySupport;
import omar.apps923.recycleradapters.R;
import omar.apps923.recycleradapters.ViewHolders.BooksVH;
import omar.apps923.recycleradapters.adapters.Generic.GenericRecyclerViewAdapter;
import omar.apps923.recycleradapters.models.Book;


public class GenericAdapterActivity extends BaseActivity   {

     RecyclerViewEmptySupport rv;
    TextView txtvEmpty;
    GenericRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_generic_normal_adapter);

        initVars();

        CustomTextView tvToolBarNormal = (CustomTextView)   findViewById(R.id.tvToolBarNormal);
        tvToolBarNormal.setText(getString(R.string.genericadapter_title));



        rv = (RecyclerViewEmptySupport)findViewById(R.id.rv) ;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        adapter = new GenericRecyclerViewAdapter<>(this, new GenericRecyclerViewAdapter.AdapterDrawData() {
            @Override
            public RecyclerView.ViewHolder getView(ViewGroup parent) {

                return new BooksVH<>(GenericAdapterActivity.this,
                        BooksVH.getView(GenericAdapterActivity.this, parent));
            }

            @Override
            public void bindView(GenericRecyclerViewAdapter genericRecyclerViewAdapter,
                                 RecyclerView.ViewHolder holder, Object item, int position) {
                ((BooksVH) holder).bindData(
                        genericRecyclerViewAdapter.getItem(position), position);
            }
        });

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
    public void parseString(String response) {



        try {
            JSONObject jObject = new JSONObject(response);

            String success = jObject.getString("success");

            if (success.equalsIgnoreCase("yes")) {
                adapter.clearData();
                JSONArray jsonArray = jObject.getJSONArray("books");
                Book book=new Book(this,jsonArray);
                adapter.setAll(book.basicModels);

            }
            else
            {
                Toast.makeText(getApplicationContext(),getString(R.string.errorinwebservice),Toast.LENGTH_LONG).show();
             }



        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),getString(R.string.errorinwebservice),Toast.LENGTH_LONG).show();
            rv.setAdapter(adapter);
        }



    }

    @Override
    public void failResponse() {

    }


}

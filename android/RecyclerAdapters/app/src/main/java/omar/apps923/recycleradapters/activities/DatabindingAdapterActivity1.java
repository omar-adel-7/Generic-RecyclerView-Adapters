package omar.apps923.recycleradapters.activities;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import omar.apps923.recycleradapters.R;
import omar.apps923.recycleradapters.adapters.databinding.RecyclerAdapter;
import omar.apps923.recycleradapters.adapters.databinding.RecyclerCallback;
import omar.apps923.recycleradapters.databinding.ActDatabindingAdapterBinding;
import omar.apps923.recycleradapters.helpers.PicassoHelper;
import omar.apps923.recycleradapters.models.BasicModel;
import omar.apps923.recycleradapters.models.Book;
import omar.apps923.recycleradapters.databinding.RowBookDatabindingBinding;


public class DatabindingAdapterActivity1 extends BaseActivity  implements RecyclerAdapter.OnViewHolderClick{

    private RecyclerAdapter recyclerAdapter;
   ActDatabindingAdapterBinding binding ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.act_databinding_adapter);

        initVars();

        binding.rlToolBar.tvToolBarNormal.setText(getString(R.string.databindingadapter_title));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.rv.setLayoutManager(layoutManager);
         binding.rv.setEmptyView( binding.txtvEmpty);


        recyclerAdapter = new RecyclerAdapter( this,   binding.rv ,new ArrayList<BasicModel>(),
                R.layout.row_book_databinding, new RecyclerCallback() {

            @Override
            public void bindData(View viewHolderView, ViewDataBinding binder, BasicModel model, int position) {

                setRecyclerData((RowBookDatabindingBinding) binder, model,   position);
            }



        },this);

        binding.rv.setAdapter(recyclerAdapter);

        getBooks();

    }


    public void getBooks()
    {

        webServices.getBooks();

    }

    private void setRecyclerData(RowBookDatabindingBinding binder, BasicModel model, int position) {
        final Book itemInfo = (Book) model;
          binder.setItem(itemInfo);
        PicassoHelper.loadImage(DatabindingAdapterActivity1.this,itemInfo.getImage(),binder.imgvImage);

    }



    @Override
    public void onClick(RecyclerView recyclerView, View view, int position, BasicModel model)
    {
        Toast.makeText(this,
                ((Book)model).getTitle()+" clicked"+" at position "+position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void parseString(String response) {

        try {
            JSONObject jObject = new JSONObject(response);

            String success = jObject.getString("success");

            if (success.equalsIgnoreCase("yes")) {
                recyclerAdapter.clearData();
               JSONArray jsonArray = jObject.getJSONArray("books");
                Book book=new Book(this,jsonArray);
                recyclerAdapter.addAll(book.basicModels);

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

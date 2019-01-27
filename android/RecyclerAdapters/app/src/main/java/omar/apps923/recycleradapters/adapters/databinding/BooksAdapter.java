package omar.apps923.recycleradapters.adapters.databinding;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import omar.apps923.recycleradapters.databinding.RowBookDatabindingBinding;
import omar.apps923.recycleradapters.helpers.PicassoHelper;
import omar.apps923.recycleradapters.models.BasicModel;
import omar.apps923.recycleradapters.models.Book;

/**
 * Created by omar on 13/08/2017.
 */

public class BooksAdapter extends  RecyclerAdapter {


    public BooksAdapter(Context context, RecyclerView recyclerView, ArrayList<BasicModel> items, int layoutId, OnViewHolderClick listener) {
        super(context, recyclerView, items, layoutId  ,listener);
        setBindingInterface(   new RecyclerCallback() {
            @Override
            public void bindData(View viewHolderView, ViewDataBinding binder, BasicModel model, int position) {
                setRecyclerData(viewHolderView , (RowBookDatabindingBinding) binder, model,   position);
            }
        });

    }

    public  void setRecyclerData(View viewHolderView, RowBookDatabindingBinding binder, BasicModel model, int position) {

        final Book itemInfo = (Book) model;
        binder.setItem(itemInfo);
        PicassoHelper.loadImage(mContext,itemInfo.getImage(),binder.imgvImage);

     }

}

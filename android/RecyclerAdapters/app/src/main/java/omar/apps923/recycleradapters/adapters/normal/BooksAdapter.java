package omar.apps923.recycleradapters.adapters.normal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import omar.apps923.recycleradapters.gui.CustomTextView;
import omar.apps923.recycleradapters.R;
import omar.apps923.recycleradapters.helpers.PicassoHelper;
import omar.apps923.recycleradapters.models.BasicModel;
import omar.apps923.recycleradapters.models.Book;



public class BooksAdapter extends CustomRecyclerViewAdapter<Book>

{
    public BooksAdapter(Context context, OnViewHolderClick listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_book_generic_normal, viewGroup, false);

        return view;
    }

    @Override
    protected void bindView(BasicModel item, ViewHolder viewHolder, int position) {

        final Book itemInfo = (Book)item;

        ImageView imgvImage = (ImageView) viewHolder.getView(R.id.imgvImage);
        CustomTextView txtvTitle = (CustomTextView) viewHolder.getView(R.id.txtvTitle);
        CustomTextView txtvDesc = (CustomTextView) viewHolder.getView(R.id.txtvDesc);
        txtvTitle.setText(itemInfo.getTitle());
        txtvDesc.setText(itemInfo.getDesc());
        PicassoHelper.loadImage(mContext,itemInfo.getImage(),imgvImage);
    }

    @Override
    public void parseString(String response) {

    }

    @Override
    public void failResponse() {

    }
}

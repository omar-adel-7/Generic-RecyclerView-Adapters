package omar.apps923.recycleradapters.ViewHolders;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import omar.apps923.recycleradapters.gui.CustomTextView;
import omar.apps923.recycleradapters.R;
import omar.apps923.recycleradapters.helpers.PicassoHelper;
import omar.apps923.recycleradapters.models.Book;


/**
 * Created by Net22 on 9/14/2017.
 */

public class BooksVH<T> extends RecyclerView.ViewHolder {


    View itemView;
    int positionClicked;
    Object itemClicked;
    Context context;


    public BooksVH(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
     }

    public void bindData(final Object item, final int position) {

        final Book itemInfo = (Book) item;
        initialize(itemInfo,position);

    }

    public static View getView(Context context, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return layoutInflater.inflate(R.layout.row_book_generic_normal, viewGroup, false);
    }

    private void initialize(final Book book  ,final int position ) {


        LinearLayout row_layout_container = (LinearLayout) itemView.findViewById(R.id.row_layout_container);
        ImageView imgvImage = (ImageView) itemView.findViewById(R.id.imgvImage);
        CustomTextView txtvTitle = (CustomTextView)  itemView.findViewById(R.id.txtvTitle);
        CustomTextView txtvDesc = (CustomTextView) itemView.findViewById(R.id.txtvDesc);
        txtvTitle.setText(book.getTitle());
        txtvDesc.setText(book.getDesc());
        PicassoHelper.loadImage(context,book.getImage(),imgvImage);


        row_layout_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,book.getTitle()+" clicked"+" at position "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

}

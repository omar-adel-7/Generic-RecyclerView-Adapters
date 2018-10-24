package omar.apps923.recycleradapters.helpers;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import omar.apps923.recycleradapters.R;


public class PicassoHelper {

    // SERVICES RETURN FULL PATH
    //.load(BackEndWrapper.imgURL.concat(imgPath))

    public static void loadImageFull(Context context, String imgPath, ImageView iv){
        if(imgPath.equals(""))

            imgPath="error";

        iv.setBackgroundResource(0);

        Picasso.get()
                .load(imgPath)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);

    }


    public static void loadImage(Context context, String imgPath, ImageView iv){
        if(imgPath.equals(""))

            imgPath="error";

         iv.setBackgroundResource(0);

        Picasso.get()
                .load(imgPath)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .resize(150, 150)
                .into(iv);

        //Log.e("imgURL.concat(imgPath)",imgPath);

    }
}

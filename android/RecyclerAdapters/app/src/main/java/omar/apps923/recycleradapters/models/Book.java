package omar.apps923.recycleradapters.models;

import android.content.Context;
import android.databinding.Bindable;
import android.os.Parcel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import omar.apps923.recycleradapters.BR;


    public class Book extends BasicModel

     {

    public int id;
    public String title;
     public String desc;
    public String image;


      @Bindable
    public int getId() {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

   @Bindable
  public String getDesc() {
    return desc;
     }

    public void setDesc(String desc) {
     this.desc = desc;
     notifyPropertyChanged(BR.desc);
    }


    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }





    public Book(Context context , JSONObject jsonObject, boolean isArray)
            throws JSONException {
        super(context,jsonObject);
        this.id = jsonObject.getInt("id");
        this.title = jsonObject.getString("title");
        this.desc = jsonObject.getString("desc");
        this.image = jsonObject.getString("image");

        if(!isArray)
        {
            basicModel=this;
        }


    }

    public Book(Context context , JSONArray jsonArray)
            throws JSONException {
        super(context,jsonArray);

        for (int i = 0; i < jsonArray.length(); i++) {
            try
            {
                basicModels.add(new Book(context,jsonArray.getJSONObject(i),true));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeString(this.image);
    }

    protected Book(Parcel in) {
        super(in);
        this.id = in.readInt();
        this.title = in.readString();
        this.desc = in.readString();
        this.image = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}

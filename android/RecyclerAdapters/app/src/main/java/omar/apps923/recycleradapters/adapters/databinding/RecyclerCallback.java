package omar.apps923.recycleradapters.adapters.databinding;

import android.databinding.ViewDataBinding;
import android.view.View;

import omar.apps923.recycleradapters.models.BasicModel;


/**
 *
 */
public interface RecyclerCallback {
    public void bindData(View viewHolderView,
                         ViewDataBinding binder, BasicModel model, int position);
}

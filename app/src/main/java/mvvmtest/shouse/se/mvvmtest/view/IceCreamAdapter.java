package mvvmtest.shouse.se.mvvmtest.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mvvmtest.shouse.se.mvvmtest.BR;
import mvvmtest.shouse.se.mvvmtest.R;
import mvvmtest.shouse.se.mvvmtest.databinding.IceCreamListItemBinding;
import mvvmtest.shouse.se.mvvmtest.viewmodel.IceCreamViewModel;

/**
 * Created by ani on 2017-04-10.
 */

public class IceCreamAdapter extends RecyclerView.Adapter<IceCreamViewHolder> {


    private Context context;
    private ArrayList<IceCreamViewModel> data;

    public IceCreamAdapter(Context context, ArrayList<IceCreamViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public IceCreamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IceCreamListItemBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.ice_cream_list_item, viewGroup, false);
        return new IceCreamViewHolder(viewDataBinding.getRoot(), viewDataBinding);
    }

    @Override
    public void onBindViewHolder(IceCreamViewHolder customViewHolder, int i) {
        IceCreamListItemBinding viewDataBinding = customViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.viewModel, data.get(i));
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).hashCode();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
class IceCreamViewHolder extends RecyclerView.ViewHolder {

    private IceCreamListItemBinding viewDataBinding;

    IceCreamViewHolder(View itemView, IceCreamListItemBinding viewDataBinding) {
        super(itemView);
        this.viewDataBinding = viewDataBinding;
    }

    public IceCreamListItemBinding getViewDataBinding() {
        return viewDataBinding;
    }
}

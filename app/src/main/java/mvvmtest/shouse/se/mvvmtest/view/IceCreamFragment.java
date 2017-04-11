package mvvmtest.shouse.se.mvvmtest.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import mvvmtest.shouse.se.mvvmtest.BR;
import mvvmtest.shouse.se.mvvmtest.R;
import mvvmtest.shouse.se.mvvmtest.databinding.IceCreamListItemBinding;
import mvvmtest.shouse.se.mvvmtest.model.Gelato;
import mvvmtest.shouse.se.mvvmtest.model.User;
import mvvmtest.shouse.se.mvvmtest.viewmodel.IceCreamViewModel;


public class IceCreamFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<IceCreamViewModel> viewModel;
    private ViewDataBinding binding;

    public IceCreamFragment() {
        // Required empty public constructor
    }

    public static IceCreamFragment newInstance() {
        IceCreamFragment fragment = new IceCreamFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getContext().getSharedPreferences(getContext().getPackageName(), Context.MODE_PRIVATE);
        viewModel = new ArrayList<>();
        String iceCreamStringGson = prefs.getString(getString(R.string.prefs_key_ice_creams), null);
        if(iceCreamStringGson != null){
            ArrayList<Gelato> iceCreams = new Gson().fromJson(iceCreamStringGson, new TypeToken<ArrayList<Gelato>>(){}.getType());
            for (Gelato iceCream: iceCreams){
                viewModel.add(new IceCreamViewModel(iceCream));
            }
        }
        addRandomIceCream();
    }

    private void addRandomIceCream() {
        viewModel.add(new IceCreamViewModel(new Gelato("Strawberry", false)));
        viewModel.add(new IceCreamViewModel(new Gelato("Pear-Cone 2000+", true)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ice_cream_list, container, false);
        View view = binding.getRoot();

        RecyclerView recyclerView = ((RecyclerView) view.findViewById(R.id.iceCreamListView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new IceCreamAdapter(getContext(), viewModel));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

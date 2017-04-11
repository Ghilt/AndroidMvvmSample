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

import mvvmtest.shouse.se.mvvmtest.R;
import mvvmtest.shouse.se.mvvmtest.databinding.FragmentIceCreamListBinding;
import mvvmtest.shouse.se.mvvmtest.model.Gelato;
import mvvmtest.shouse.se.mvvmtest.viewmodel.IceCreamListViewModel;
import mvvmtest.shouse.se.mvvmtest.viewmodel.IceCreamRowViewModel;


public class IceCreamFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<IceCreamRowViewModel> rowViewModels;
    private FragmentIceCreamListBinding binding;
    private IceCreamListViewModel viewModel;

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
        rowViewModels = new ArrayList<>();
        viewModel = new IceCreamListViewModel();
        String iceCreamStringGson = prefs.getString(getString(R.string.prefs_key_ice_creams), null);
        if(iceCreamStringGson != null){
            ArrayList<Gelato> iceCreams = new Gson().fromJson(iceCreamStringGson, new TypeToken<ArrayList<Gelato>>(){}.getType());
            addRandomIceCream(iceCreams); //add test data
            for (Gelato iceCream: iceCreams){
                iceCream.addObserver(viewModel);
                rowViewModels.add(new IceCreamRowViewModel(iceCream));
            }
        } else {
            prefs.edit().putString(getContext().getString(R.string.prefs_key_ice_creams), new Gson().toJson(new ArrayList<Gelato>())).apply();
        }
    }

    private void addRandomIceCream(ArrayList<Gelato> iceCreams) {
        iceCreams.add(new Gelato("Strawberry", false));
        iceCreams.add(new Gelato("Extra bold diamond black sandwhich", true));
        iceCreams.add(new Gelato("Pear-Cone 2000+", true));
        iceCreams.add(new Gelato("Cornetto", false));
        iceCreams.add(new Gelato("Blueberry boston", false));
        iceCreams.add(new Gelato("Extra rubel black sandwhich", true));
        iceCreams.add(new Gelato("Pear-Cone 2000+", true));
        iceCreams.add(new Gelato("Cornetto", false));
        iceCreams.add(new Gelato("Strawberry", false));
        iceCreams.add(new Gelato("Extra bold diamond black sandwhich", true));
        iceCreams.add(new Gelato("Pear-Cone 2000+", true));
        iceCreams.add(new Gelato("Cornetto", false));
        iceCreams.add(new Gelato("Strawberry", false));
        iceCreams.add(new Gelato("Oreo sundae", false));
        iceCreams.add(new Gelato("Pear-Sunset 2000+", true));
        iceCreams.add(new Gelato("Cornetto", true));
        iceCreams.add(new Gelato("Strawberry", false));
        iceCreams.add(new Gelato("Extra bold diamond black sandwhich", true));
        iceCreams.add(new Gelato("Pine-Cone 2000+", false));
        iceCreams.add(new Gelato("Cornetto", false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ice_cream_list, container, false);
        View view = binding.getRoot();
        binding.setViewModel(viewModel);

        RecyclerView recyclerView = ((RecyclerView) view.findViewById(R.id.iceCreamListView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new IceCreamAdapter(getContext(), rowViewModels));
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

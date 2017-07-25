package mvvmtest.shouse.se.mvvmtest.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvmtest.shouse.se.mvvmtest.BR;
import mvvmtest.shouse.se.mvvmtest.R;
import mvvmtest.shouse.se.mvvmtest.databinding.FragmentProfileInfoBinding;
import mvvmtest.shouse.se.mvvmtest.model.User;
import mvvmtest.shouse.se.mvvmtest.viewmodel.ProfileInfoViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileInfoFragment extends Fragment {
    private static final String ARG_PARAM_USER = "param_user";

    private OnFragmentInteractionListener mListener;
    private ProfileInfoViewModel viewModel;
    private FragmentProfileInfoBinding binding;

    public ProfileInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param user Parameter 1.
     * @return A new instance of fragment ProfileInfoFragment.
     */
    public static ProfileInfoFragment newInstance(User user) {
        ProfileInfoFragment fragment = new ProfileInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        User user = null;
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(ARG_PARAM_USER);
        }
        viewModel = new ProfileInfoViewModel(getContext(), user);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_info, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

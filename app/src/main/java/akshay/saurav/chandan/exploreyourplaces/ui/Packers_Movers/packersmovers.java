package akshay.saurav.chandan.exploreyourplaces.ui.Packers_Movers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import akshay.saurav.chandan.exploreyourplaces.R;

public class packersmovers extends Fragment {

    private PackersmoversViewModel mViewModel;

    public static packersmovers newInstance() {
        return new packersmovers();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.packersmovers_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PackersmoversViewModel.class);
        // TODO: Use the ViewModel
    }

}

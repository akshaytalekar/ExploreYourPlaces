package akshay.saurav.chandan.exploreyourplaces.ui.Refer_Earn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import akshay.saurav.chandan.exploreyourplaces.R;

public class referearn extends Fragment {

    private ReferearnViewModel mViewModel;

    public static referearn newInstance() {
        return new referearn();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.referearn_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ReferearnViewModel.class);
        // TODO: Use the ViewModel
    }

}

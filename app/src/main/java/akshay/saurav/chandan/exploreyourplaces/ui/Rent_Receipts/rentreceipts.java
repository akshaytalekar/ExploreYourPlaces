package akshay.saurav.chandan.exploreyourplaces.ui.Rent_Receipts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import akshay.saurav.chandan.exploreyourplaces.R;

public class rentreceipts extends Fragment {

    private RentreceiptsViewModel mViewModel;

    public static rentreceipts newInstance() {
        return new rentreceipts();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rentreceipts_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RentreceiptsViewModel.class);
        // TODO: Use the ViewModel
    }

}

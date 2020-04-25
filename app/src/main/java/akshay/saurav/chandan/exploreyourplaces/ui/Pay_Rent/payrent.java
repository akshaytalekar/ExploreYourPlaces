package akshay.saurav.chandan.exploreyourplaces.ui.Pay_Rent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplaces.R;

public class payrent extends Fragment {

    public static payrent newInstance() {
        return new payrent();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payrent_fragment, container, false);
    }



}

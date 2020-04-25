package akshay.saurav.chandan.exploreyourplaces.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import akshay.saurav.chandan.exploreyourplaces.MainActivity;
import akshay.saurav.chandan.exploreyourplaces.R;
import akshay.saurav.chandan.exploreyourplaces.model.UserTenent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TenRegistrationFragment extends Fragment {

    private EditText nameInput, emailInput, phoneInput, passwordInput;


    public TenRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button regBtn;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tenreg, container, false);
        nameInput = view.findViewById(R.id.tenenteditName);
        emailInput = view.findViewById(R.id.tenenteditEmail);
        phoneInput = view.findViewById(R.id.tenenteditMobile);
        passwordInput = view.findViewById(R.id.tenenteditpassword);
        regBtn = view.findViewById(R.id.tenentSubmit);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                Log.e("reg button", "clicked");
            }
        });
        return view;
    }

    private void registerUser() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (TextUtils.isEmpty(name)){
            MainActivity.appPreference.showToast("Your name is required.");
        } else if (TextUtils.isEmpty(email)){
            MainActivity.appPreference.showToast("Your email is required.");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            MainActivity.appPreference.showToast("Invalid email");
        } else if (TextUtils.isEmpty(password)){
            MainActivity.appPreference.showToast("Password required");
        } else if (password.length() < 6){
            MainActivity.appPreference.showToast("Create a password at least 6 characters long.");
        }
        else {
            Call<UserTenent> userTenentCall = MainActivity.serviceApiT.doRegistration(name, email, phone, password);
            userTenentCall.enqueue(new Callback<UserTenent>() {
                @Override
                public void onResponse(Call<UserTenent> call, Response<UserTenent> response)
                {
                    if (response.body() != null) {
                        switch (response.body().getResponse()) {
                            case "inserted":
                                Log.e("response", response.body().getResponse());
                                nameInput.setText("");
                                emailInput.setText("");
                                phoneInput.setText("");
                                passwordInput.setText("");
                                MainActivity.appPreference.showToast("Registered Successfully");

                                break;
                            case "exists":
                                MainActivity.appPreference.showToast("This email already exists");
                                break;
                            case "error":
                                MainActivity.appPreference.showToast("Oops! something went wrong.");
                                break;
                        }
                    }
                }
                @Override
                public void onFailure(Call<UserTenent> call, Throwable t) {
                }
            });
        }
    }
}

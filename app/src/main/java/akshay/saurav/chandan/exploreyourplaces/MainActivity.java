package akshay.saurav.chandan.exploreyourplaces;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import akshay.saurav.chandan.exploreyourplaces.constants.Constant;
import akshay.saurav.chandan.exploreyourplaces.extras.AppPreference;
import akshay.saurav.chandan.exploreyourplaces.fragment.LandRegistrationFragment;
import akshay.saurav.chandan.exploreyourplaces.fragment.LoginFragment;
import akshay.saurav.chandan.exploreyourplaces.fragment.TenRegistrationFragment;
import akshay.saurav.chandan.exploreyourplaces.services.BhkApi;
import akshay.saurav.chandan.exploreyourplaces.services.MyInterface;
import akshay.saurav.chandan.exploreyourplaces.services.RetrofitClient;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiCRR;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiL;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiMP;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiPP;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiRE;
import akshay.saurav.chandan.exploreyourplaces.services.ServiceApiT;
import akshay.saurav.chandan.exploreyourplaces.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements MyInterface {
    public static AppPreference appPreference;
    public static String c_date;
    FrameLayout container_layout;
    public static ServiceApiL serviceApiL;
    public static ServiceApiT serviceApiT;
    public static ServiceApiCRR serviceApiCRR;
    public static ServiceApiMP serviceApiMP;
    public static ServiceApiPP serviceApiPP;
    public static ServiceApiRE serviceApiRE;
    public static BhkApi bhkApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container_layout = findViewById(R.id.fragment_container);
        appPreference = new AppPreference(this);

        serviceApiL = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiL.class);
        serviceApiT = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiT.class);
        serviceApiCRR = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiCRR.class);
        serviceApiMP = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiMP.class);
        serviceApiPP = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiPP.class);
        serviceApiRE = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiRE.class);
        bhkApi = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(BhkApi.class);


        if (container_layout != null) {
            if (savedInstanceState != null) {
                return;
            }
            //check login status from sharedPreference
            if (appPreference.getLoginStatus()) {
                //when true
                /*getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new ProfileFragment())
                        .commit();*/
                Intent intent=new Intent(getApplicationContext(), Nav_tenant.class);
                startActivity(intent);
            } else {
                // when get false
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new LoginFragment())
                        .commit();
            }
        }
    }

    @Override
    public void register() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new TenRegistrationFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void registerL() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LandRegistrationFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void login(String name, String email, String created_at) {
        appPreference.setDisplayName(name);
        appPreference.setDisplayEmail(email);
        appPreference.setCreDate(created_at);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();

    }

    @Override
    public void logout() {
        appPreference.setLoginStatus(false);
        appPreference.setDisplayName("Name");
        appPreference.setDisplayEmail("Email");
        appPreference.setCreDate("DATE");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment())
                .commit();

    }

}

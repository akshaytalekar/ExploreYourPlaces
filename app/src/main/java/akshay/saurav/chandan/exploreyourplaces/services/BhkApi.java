package akshay.saurav.chandan.exploreyourplaces.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BhkApi {


    String BASE_URL = "http://pherywala.sparsematrix.co.in/exploreyourplace/";
    @GET("BHK.php")
    Call<List<BhkApi>>getdatabkh();

}





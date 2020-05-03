package akshay.saurav.chandan.exploreyourplaces.services;


import akshay.saurav.chandan.exploreyourplaces.model.ReferEarn;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApiRE {
    @GET("referandearn.php")
    Call<ReferEarn> refearn(@Query("name") String name, @Query("phone") String phone, @Query("address") String address);

}

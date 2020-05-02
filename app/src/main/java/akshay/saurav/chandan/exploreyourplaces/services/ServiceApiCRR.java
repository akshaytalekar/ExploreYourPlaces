package akshay.saurav.chandan.exploreyourplaces.services;


import akshay.saurav.chandan.exploreyourplaces.model.RentReceipt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApiCRR {
    @GET("rent.php")
    Call<RentReceipt> generatereceipt(@Query("tenname") String tenname, @Query("ownername") String ownername, @Query("tenphone") String tenphone, @Query("ownerphone") String ownerphone,@Query("rent") String rent);
}







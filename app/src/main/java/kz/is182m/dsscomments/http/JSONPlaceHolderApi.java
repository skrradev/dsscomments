package kz.is182m.dsscomments.http;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {

    @POST("/api/dss")
    public Call<Data> getPercentageOfText(@Body String source);
}

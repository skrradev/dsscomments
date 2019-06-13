package kz.is182m.dsscomments.http;

import java.util.List;

import kz.is182m.dsscomments.twitterApi.TwitterDataItem;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {


    //@Multipart
    @POST("/api/dss/twitter")
    public Call<List<TwitterDataItem>> getPercentageOfText(@Body String  source);
}

package kz.is182m.dsscomments.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;

    public NetworkService setBASE_URL(String BASE_URL) {
        String  url = "http://" + BASE_URL + ":8080";

        this.BASE_URL = url;
        return this;
    }

    private  String BASE_URL = "http://192.168.103.95:8080";

    private Retrofit mRetrofit;



    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
}

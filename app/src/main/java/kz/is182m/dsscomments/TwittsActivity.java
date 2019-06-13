package kz.is182m.dsscomments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import kz.is182m.dsscomments.http.Data;
import kz.is182m.dsscomments.http.NetworkService;
import kz.is182m.dsscomments.twitterApi.TwitterDataItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwittsActivity extends AppCompatActivity {


    public static final String MYLOG = "mylog";

    private List<TwitterDataItem> list = new ArrayList<>();

    private RecyclerView tweetsRecyclerView;

    EditText editText;
    EditText editTextIP;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitts);


        editTextIP = findViewById(R.id.editTextIp);
        editText = findViewById(R.id.editTextQuery);
        button = findViewById(R.id.buttonGoQuery);




        tweetsRecyclerView = findViewById(R.id.RecyclerView);

        //

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                final String textFromInput = editText.getText().toString();
                final String ipAdress = editTextIP.getText().toString();

                NetworkService.getInstance()
                        .setBASE_URL(ipAdress)
                        .getJSONApi()
                        .getPercentageOfText(textFromInput)
                        .enqueue(new Callback<List<TwitterDataItem>>() {

                            @Override
                            public void onResponse(Call<List<TwitterDataItem>> call, Response<List<TwitterDataItem>> response) {
                                List<TwitterDataItem> listOfTweets = response.body();

                                tweetsRecyclerView.setLayoutManager(new LinearLayoutManager(TwittsActivity.this));

                                Context context = getApplicationContext();

                                tweetsRecyclerView.setAdapter(new TwittAdapter(context, listOfTweets));



                            }

                            @Override
                            public void onFailure(Call<List<TwitterDataItem>> call, Throwable t) {
                                Log.d(MYLOG, t.getMessage());
                            }
                        });



            }
        });












    }
}

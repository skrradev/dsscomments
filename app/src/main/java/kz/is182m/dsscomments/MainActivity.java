package kz.is182m.dsscomments;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import kz.is182m.dsscomments.http.Data;
import kz.is182m.dsscomments.http.NetworkService;
import kz.is182m.dsscomments.http.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "mylog";

    Button button;

    TextView textView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText4);

        button = findViewById(R.id.button2);

        textView = findViewById(R.id.textView3);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String textFromInput = editText.getText().toString();

                NetworkService.getInstance()
                        .getJSONApi()
                        .getPercentageOfText(textFromInput)
                        .enqueue(new Callback<Data>() {



                            @Override
                            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                                Data post = response.body();

                                textView.setText(post.toString());
                                Log.v(LOGTAG, post.toString());

                            }

                            @Override
                            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                                Log.v(LOGTAG, t.getMessage());
                            }
                        });
            }
        });








    }
}

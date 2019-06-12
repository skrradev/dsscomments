package kz.is182m.dsscomments;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import kz.is182m.dsscomments.http.Data;
import kz.is182m.dsscomments.http.NetworkService;
import kz.is182m.dsscomments.http.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public static final int[] LIBERTY_COLORS = {
             Color.rgb(153, 0, 0), Color.rgb(9, 203, 35)
    };

    public static final String LOGTAG = "mylog";

    Button button;

    TextView textView;

    EditText editText;

    PieChart pieChart;

    ArrayList<PieEntry> yvalues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        pieChart = findViewById(R.id.pieChart);

        yvalues = new ArrayList<PieEntry>();

        editText = findViewById(R.id.editText4);

        button = findViewById(R.id.button2);

        textView = findViewById(R.id.textView3);


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yvalues.clear();
                pieChart.invalidate();
                pieChart.clear();
            }
        });



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

                                drawChart(post.getNegativePercent(), post.getPositivePercent());

                            }

                            @Override
                            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                                Log.v(LOGTAG, t.getMessage());
                            }
                        });
            }
        });


    }


    private void drawChart(double negativePercent, double postivePercent) {


        yvalues.clear();
        pieChart.invalidate();
        pieChart.clear();

        pieChart.setUsePercentValues(true);

        yvalues.add(new PieEntry((float) negativePercent, "Negative", 0));
        yvalues.add(new PieEntry((float) postivePercent, "Positive", 1));

        PieDataSet dataSet = new PieDataSet(yvalues, getString(R.string.election_results));
        PieData data = new PieData(dataSet);

        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        Description description = new Description();
        description.setText(getString(R.string.pie_chart));
        pieChart.setDescription(description);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(58f);
        pieChart.setHoleRadius(58f);
        dataSet.setColors(LIBERTY_COLORS);

        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);

        pieChart.animateX(1000);

    }




}



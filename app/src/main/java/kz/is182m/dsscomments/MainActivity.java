package kz.is182m.dsscomments;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import kz.is182m.dsscomments.http.Data;
import kz.is182m.dsscomments.http.NetworkService;
import kz.is182m.dsscomments.http.Post;
import kz.is182m.dsscomments.twitterApi.TwitterDataItem;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static kz.is182m.dsscomments.TwittAdapter.*;
import static kz.is182m.dsscomments.TwittAdapter.TWEETS_ORIGINAL_WORDS;
import static kz.is182m.dsscomments.TwittAdapter.TWEETS_POSITIVE;

public class MainActivity extends AppCompatActivity {


    public static List<TwitterDataItem> list = new ArrayList<>();


    public static final int[] LIBERTY_COLORS = {
            Color.RED, Color.GREEN, Color.YELLOW
    };

    public static final String LOGTAG = "mylog";

    Button button;

    //TextView textView;

    EditText editText;

    PieChart pieChart;

    ArrayList<PieEntry> yvalues;

    TableLayout t1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* String negative;
        String positive;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                negative= null;
            } else {
                negative= extras.getString(TWEETS_NEGATIVE);
            }
        } else {
            negative= (String) savedInstanceState.getSerializable(TWEETS_NEGATIVE);
        }*/



        /*String negative = getIntent().getExtras().getString(TWEETS_NEGATIVE);
        String positive = getIntent().getExtras().getString(TWEETS_POSITIVE);
        String neutral = getIntent().getExtras().getString(TWEETS_NEUTRAL);*/
       // List<String> originalWords = (ArrayList<String>) getIntent().getSerializableExtra(TWEETS_ORIGINAL_WORDS);
      //  List<String> normalizedWords = (ArrayList<String>) getIntent().getSerializableExtra(TWEETS_NORMILIZED_WORDS);





         t1 =  findViewById(R.id.main_table);


        TableRow tr_head = new TableRow(this);
        tr_head.setId(10);
        tr_head.setBackgroundColor(Color.GRAY);
        tr_head.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));



        TextView label_date = new TextView(this);
        label_date.setId(20);
        label_date.setText("Original word");
        label_date.setTextColor(Color.WHITE);
        label_date.setPadding(5, 5, 5, 5);
        tr_head.addView(label_date);// add the column to the table row here

        TextView label_weight_kg = new TextView(this);
        label_weight_kg.setId(21);// define id that must be unique
        label_weight_kg.setText("Normalized"); // set the text for the header
        label_weight_kg.setTextColor(Color.WHITE); // set the color
        label_weight_kg.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_weight_kg); // add the column to the table row here


        t1.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));










        pieChart = findViewById(R.id.pieChart);

        yvalues = new ArrayList<PieEntry>();



        drawTable(list.get(0).getOriginalWords(), list.get(0).getNormalizedWords() );

      drawChart(Double.valueOf(list.get(0).getNegativePercent()), Double.valueOf(list.get(0).getPositivePercent()),
              Double.valueOf(list.get(0).getNeutralPercent()));









      /*  button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String textFromInput = editText.getText().toString();

                //RequestBody textFromInputRequestBody = RequestBody.create(MediaType.parse("text/plain"), textFromInput);

                NetworkService.getInstance()
                        .getJSONApi()
                        .getPercentageOfText(textFromInput)
                        .enqueue(new Callback<Data>() {


                            @Override
                            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                                Data post = response.body();

                                if(post!=null) {*//*textView.setText(post.toString());*//*
                                Log.v(LOGTAG, post.toString()); }





                            }

                            @Override
                            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                                Log.v(LOGTAG, t.getMessage());
                            }
                        });
            }
        });*/

    }


    private void drawChart(double negativePercent, double postivePercent, double neutralPercent) {


        yvalues.clear();
        pieChart.invalidate();
        pieChart.clear();

        pieChart.setUsePercentValues(true);

        yvalues.add(new PieEntry((float) negativePercent, "Negative", 0));
        yvalues.add(new PieEntry((float) postivePercent, "Positive", 1));
        yvalues.add(new PieEntry((float) neutralPercent, "Neutral", 2));

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



    private void drawTable (List<String> originalWords, List<String> normalizedWords) {

        Integer count=0;

        for (String word: originalWords){
           // String date = formatdate(cursor.getString(2));// get the first variable
          //  Double weight_kg = roundTwoDecimals(cursor.getDouble(4));// get the second variable
// Create the table row
            TableRow tr = new TableRow(this);
            if(count%2!=0) tr.setBackgroundColor(Color.rgb(239, 242, 240));
            tr.setId(100+count);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

//Create two columns to add as table data
            // Create a TextView to add date
            TextView labelDATE = new TextView(this);
            labelDATE.setId(200+count);
            labelDATE.setText(word);
            labelDATE.setPadding(2, 0, 5, 0);
            labelDATE.setTextColor(Color.BLACK);
            tr.addView(labelDATE);
            TextView labelWEIGHT = new TextView(this);
            labelWEIGHT.setId(200+count);
            labelWEIGHT.setText(normalizedWords.get(count));
            labelWEIGHT.setTextColor(Color.BLACK);
            tr.addView(labelWEIGHT);

// finally add this to the table row
            t1.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }



    }


}



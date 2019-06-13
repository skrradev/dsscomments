package kz.is182m.dsscomments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kz.is182m.dsscomments.twitterApi.TwitterDataItem;

public class TwittAdapter extends RecyclerView.Adapter<TwittAdapter.TweetViewHolder>
{


    public final static String TWEETS_TEXT = "TWEETS_TEXT";
    public final static String TWEETS_USERNAME = "TWEETS_USERNAME";
    public final static String TWEETS_DATE = "TWEETS_DATE";
    public final static String TWEETS_NEGATIVE = "TWEETS_NEG";
    public final static String TWEETS_POSITIVE = "TWEETS_POSITIVE";
    public final static String TWEETS_NEUTRAL = "TWEETS_NEUTRAL";
    public final static String TWEETS_ORIGINAL_WORDS = "TWEETS_ORIGINAL";
    public final static String TWEETS_NORMILIZED_WORDS = "TWEETS_NORMILIZED";












    private Context context;

    public Context getContext() {
        return context;
    }

    public List<TwitterDataItem> getTweetList() {
        return tweetList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setTweetList(List<TwitterDataItem> tweetList) {
        this.tweetList = tweetList;
    }

    public TwittAdapter(Context context, List<TwitterDataItem> tweetList) {
        this.context = context;
        this.tweetList = tweetList;
    }

    private List<TwitterDataItem> tweetList = new ArrayList<>(Arrays.asList(
            new TwitterDataItem("sdsdf", "sdfsdf","sdfsf", 2131, 123),
            new TwitterDataItem("sdsd22f", "sdf2sdf","sdfsf", 21341, 12334),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sdfs2df","sdfsf", 213431, 12333),
            new TwitterDataItem("sd22sdf", "sd22fsdf","sdfsf", 213341, 1233)


            ));




    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.twitt_layout, viewGroup, false);
        return new TweetViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder tweetViewHolder, int i) {
        tweetViewHolder.bind(tweetList.get(i));
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }




    public static class TweetViewHolder extends RecyclerView.ViewHolder {


        private Context context ;

        public TweetViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;


            userName = (TextView)itemView.findViewById(R.id.textViewUsername);
            TweetText = (TextView)itemView.findViewById(R.id.textViewTwit);
            negativeAndPositive = (TextView) itemView.findViewById(R.id.textViewNegativeAndPositive);
            date = (TextView) itemView.findViewById(R.id.textViewDate);
            buttonAnalyze = (Button) itemView.findViewById(R.id.buttonAnalyze);

        }

        public void bind(final TwitterDataItem tweet) {

            userName.setText(tweet.getUserName());
            TweetText.setText(tweet.getText());
            negativeAndPositive.setText(tweet.getNegativePercent()+ " "+tweet.getPositivePercent());
            date.setText(tweet.getDate());
            buttonAnalyze.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);

                    MainActivity.list.add(0, tweet);



            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                  intent.putExtra(TWEETS_NEGATIVE, tweet.getNegativePercent());
//                    intent.putExtra(TWEETS_POSITIVE, tweet.getPositivePercent());
//                    intent.putExtra(TWEETS_NEUTRAL, tweet.getPositivePercent());
//                    //intent.putExtra(TWEETS_ORIGINAL_WORDS, (Serializable) tweet.getOriginalWords());
//                   // intent.putExtra(TWEETS_NORMILIZED_WORDS, (Serializable) tweet.getNormalizedWords());
                    context.startActivity(intent);

                }
            });
        }




        private TextView userName;
        private TextView TweetText;
        private TextView negativeAndPositive;
        private TextView date;
        private Button buttonAnalyze;




        public TweetViewHolder(@NonNull View itemView) {
            super(itemView);



        }
    }






}

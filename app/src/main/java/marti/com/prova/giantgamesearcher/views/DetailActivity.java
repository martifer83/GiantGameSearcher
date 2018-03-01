package marti.com.prova.giantgamesearcher.views;

/**
 * Created by mferrando on 06/02/17.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import marti.com.prova.giantgamesearcher.R;
import marti.com.prova.giantgamesearcher.models.Game;
import marti.com.prova.giantgamesearcher.presenters.DetailsPresenter;
import marti.com.prova.giantgamesearcher.services.GiantService;


public class DetailActivity extends ActionBarActivity {

    @InjectView(R.id.textViewTitle)
    TextView mTextViewTitle;

    @InjectView(R.id.textViewBody)
    TextView mTextViewBody;

    @InjectView(R.id.textViewCompany)
    TextView mTextViewCompany;

    @InjectView(R.id.textViewReleaseDate)
    TextView mTextViewReleaseDate;


    @InjectView(R.id.listViewComments)
    ListView mListViewComments;

    //CommentsAdapter mCommentsAdapter;

    DetailsPresenter mDetailsPresenter;
    GiantService mGiantService;

    protected int mGameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.inject(this);

        mGameId = getIntent().getIntExtra("gameId", 0);

        //ArrayList<Comment> dummyComments = new ArrayList<Comment>();
        //mCommentsAdapter = new CommentsAdapter(this, dummyComments);
        //mListViewComments.setAdapter(mCommentsAdapter);

        mGiantService = new GiantService();
        mDetailsPresenter = new DetailsPresenter(this, mGiantService);
        mDetailsPresenter.loadGame();
    }

    public int getGameId() {

        return mGameId;
    }

    /*public void displayComments(List<Comment> comments) {

        mCommentsAdapter.clear();
        mCommentsAdapter.addAll(comments);
        mCommentsAdapter.notifyDataSetInvalidated();
    }*/

    public void displayGame(Game game) {


        //mGamesAdapter.clear();
        //mGamesAdapter.addAll(list.results);
        //mGamesAdapter.notifyDataSetInvalidated();

        mTextViewTitle.setText(game.name);
        mTextViewBody.setText(game.id);
        mTextViewCompany.setText(game.company);
        mTextViewReleaseDate.setText(game.releaseDate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
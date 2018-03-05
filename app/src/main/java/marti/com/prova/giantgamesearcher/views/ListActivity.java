package marti.com.prova.giantgamesearcher.views;

/**
 * Created by mferrando on 06/02/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import marti.com.prova.giantgamesearcher.R;
import marti.com.prova.giantgamesearcher.adapters.GamesAdapter;
import marti.com.prova.giantgamesearcher.models.Game;
import marti.com.prova.giantgamesearcher.models.GiantList;
import marti.com.prova.giantgamesearcher.presenters.ListPresenter;
import marti.com.prova.giantgamesearcher.presenters.MyListView;
import marti.com.prova.giantgamesearcher.services.GiantService;


public class ListActivity extends AppCompatActivity  implements MyListView{

    @InjectView(R.id.listViewGames)
    ListView mListViewPosts;

    @InjectView(R.id.progress)
    ProgressBar progressBar;

    GamesAdapter mGamesAdapter;

    ListPresenter mListPresenter;
    GiantService mGiantService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.inject(this);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        ArrayList<Game> dummyPosts = new ArrayList<Game>();
        mGamesAdapter = new GamesAdapter(this, dummyPosts);
        mListViewPosts.setAdapter(mGamesAdapter);

        mGiantService = new GiantService();
        mListPresenter = new ListPresenter(this, mGiantService);
        mListPresenter.loadGames("name:Fallout");
        showProgress();
    }

    @OnItemClick(R.id.listViewGames)
    public void onPostSelect(int position) {

        Game g = mGamesAdapter.getItem(position);
        int gameId = g.id;
        String company = g.company;
        String releaseDate = g.releaseDate;
        String name =  g.name;

        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("gameId", gameId);
        detailIntent.putExtra("company", company);
        detailIntent.putExtra("releaseDate", releaseDate);
        detailIntent.putExtra("name", name);
        startActivity(detailIntent);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    public void displayGames(GiantList list) {

        mGamesAdapter.clear();
        mGamesAdapter.addAll(list.results);
        mGamesAdapter.notifyDataSetInvalidated();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}

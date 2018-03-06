package marti.com.prova.giantgamesearcher.adapters;

/**
 * Created by mferrando on 07/02/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import marti.com.prova.giantgamesearcher.R;
import marti.com.prova.giantgamesearcher.models.Game;

public class GameDetailsAdapter extends ArrayAdapter<Game> {

    public GameDetailsAdapter(Context ctx, ArrayList<Game> posts) {

        super(ctx, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Game game = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_detail_item, parent, false);

        DetailViewWrapper view = new DetailViewWrapper();
        ButterKnife.inject(view, convertView);
        view.load(game);

        return convertView;
    }

    class DetailViewWrapper {

        @InjectView(R.id.textViewCommentName)
        protected TextView name;

        @InjectView(R.id.textViewCommentEmail)
        protected TextView email;

        @InjectView(R.id.textViewCommentBody)
        protected TextView body;



        public void load(Game game) {

            name.setText(game.name);
            email.setText(game.company);
            body.setText(game.original_release_date);
            //deck.setText(game.deck);
        }
    }
}
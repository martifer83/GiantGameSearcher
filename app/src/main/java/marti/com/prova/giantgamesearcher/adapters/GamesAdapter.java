package marti.com.prova.giantgamesearcher.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import marti.com.prova.giantgamesearcher.R;
import marti.com.prova.giantgamesearcher.models.Game;

/**
 * Created by mferrando on 06/02/17.
 */
public class GamesAdapter  extends ArrayAdapter<Game> {

    public GamesAdapter(Context ctx, ArrayList<Game> games) {

        super(ctx, 0, games);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Game game = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_game_item, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.textViewItemTitle);
        title.setText(game.name);

        return convertView;
    }
}
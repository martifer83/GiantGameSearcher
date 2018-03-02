package marti.com.prova.giantgamesearcher.presenters;

import marti.com.prova.giantgamesearcher.models.GiantList;

/**
 * Created by mferrando on 02/03/2018.
 */

public interface MyListView {

    void showProgress();

    void hideProgress();

    void displayGames(GiantList games);

}

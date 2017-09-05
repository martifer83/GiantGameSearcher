package marti.com.prova.giantgamesearcher.presenters;


import android.util.Log;

import marti.com.prova.giantgamesearcher.models.GiantList;
import marti.com.prova.giantgamesearcher.services.GiantService;
import marti.com.prova.giantgamesearcher.views.ListActivity;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mferrando on 06/02/17.
 */
public class ListPresenter {

    ListActivity mView;
    GiantService mGiant;

    public ListPresenter(ListActivity view, GiantService giantService) {

        mView = view;
        mGiant = giantService;
    }

    public void loadGames() {

        mGiant.getApi()
                .getGames()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GiantList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ListPresenter", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ListPresenter", "onError");
                    }

                    @Override
                    public void onNext(GiantList list) {
                        Log.d("ListPresenter", "onNext");
                        mView.displayGames(list);
                    }
                });
    }
}

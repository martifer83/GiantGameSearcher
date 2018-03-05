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


    // https://github.com/antoniolg/androidmvp/search?utf8=%E2%9C%93&q=MainView&type=
    MyListView mView;
    //ListActivity mView;
    GiantService mGiant;

    public ListPresenter(MyListView view, GiantService giantService) {

        mView = view;
        mGiant = giantService;
    }

    public void loadGames(String name) {

        mGiant.getApi()
                .getGames("b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa","json",name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GiantList>() {
                    @Override
                    public void onCompleted() {
                        mView.hideProgress();
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

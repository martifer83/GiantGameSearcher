package marti.com.prova.giantgamesearcher.presenters;

/**
 * Created by mferrando on 07/02/17.
 */


import marti.com.prova.giantgamesearcher.models.Game;
import marti.com.prova.giantgamesearcher.services.GiantService;
import marti.com.prova.giantgamesearcher.views.DetailActivity;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DetailsPresenter {

    DetailActivity mView;
    GiantService mGiantService;

    public DetailsPresenter(DetailActivity activity, GiantService giantService) {

        mView = activity;
        mGiantService = giantService;
    }

    public void loadGame() {

        mGiantService.getApi()
                .getGameDetail(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Game>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Game game) {

                       // mView.displayPost(post);
                    }
                });
    }

    /*public void loadComments() {

        mGiantService.getApi()
                .getComments(mView.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Comment> comments) {

                        mView.displayComments(comments);
                    }
                });
    }*/
}
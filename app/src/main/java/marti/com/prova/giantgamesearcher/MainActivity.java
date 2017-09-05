package marti.com.prova.giantgamesearcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {


    private PublishSubject<String> mSearchResultsSubject;
    private Subscription mTextWatchSubscription;
   // private RestClient mRestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);

        /*RestClient.getHNService()
                .loadGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((newStories) -> {
                            ArrayAdapter<String> adapter =
                                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
                            adapter.addAll(newStories);
                            listFragment.setListAdapter(adapter);
                        },
                        e -> e.printStackTrace());

        */


    }

    /*private void createObservables() {
        mSearchResultsSubject = PublishSubject.create();
        mTextWatchSubscription = mSearchResultsSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(new Func1<String, List<String>>() {
                    @Override
                    public List<String> call(String s) {
                        return mRestClient.searchForCity(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> cities) {
                       // handleSearchResults(cities);
                    }
                });
    }*/
}

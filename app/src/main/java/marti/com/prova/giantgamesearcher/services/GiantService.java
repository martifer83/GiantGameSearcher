package marti.com.prova.giantgamesearcher.services;

import marti.com.prova.giantgamesearcher.models.Game;
import marti.com.prova.giantgamesearcher.models.GiantList;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by mferrando on 06/02/17.
 */
public class GiantService {

    //private static final String FORUM_SERVER_URL = "http://jsonplaceholder.typicode.com";
     private static final String GIANT_URL = "https://www.giantbomb.com/api";   //// <string name="giantbomb_api_key">22ecf43dc573a2e400cd5c2e334fbcba6edb8a51</string>
   ///  http://www.giantbomb.com/api/games/?api_key=b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa&format=json&filter=name:Fallout

    //  https://www.giantbomb.com/api/games/?api_key=b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa&format=json&filter=name:Wolfenstein
    private GiantApi mGiantApi;

    public GiantService() {

        //https://hackernoon.com/yet-another-mvp-article-part-3-calling-apis-using-retrofit-23757f4eee05

        /*RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };*/


        // 2.0
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GIANT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
*/
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(GIANT_URL)
                //.setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        //mGiantApi = retrofit.create(GiantApi.class);

        mGiantApi = restAdapter.create(GiantApi.class);
    }

    public GiantApi getApi() {

        return mGiantApi;
    }

    // another example: https://github.com/JakeWharton/retrofit2-rxjava2-adapter/tree/master/src

    // example http://randomdotnext.com/retrofit-rxjava/


    /*
    public interface GithubService {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<Github> getUser(@Path("login") String login);
     }

     */

    public interface GiantApi {
//  .setEndpoint("http://www.giantbomb.com/api/")   // <string name="giantbomb_api_key">22ecf43dc573a2e400cd5c2e334fbcba6edb8a51</string>
        //@GET("/games/?api_key=b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa&format=json&filter=name:Fallout")
        //<GiantGames> getGames();
         //Observable<GiantList> getGames();

        @GET("/games/?api_key=b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa&format=json&filter")
        Observable<GiantList> getGames(@Path("name") String name); //@Path("id") String questionId


        // try this: https://stackoverflow.com/questions/43434073/unable-to-create-call-adapter-for-io-reactivex-observable


        // exemple 2.0
        //@GET("/service/getIpInfo.php") Observable<JsonObject> getIPInfo(@Query("ip") String ip);

        //Call Observable<List<Game>> getTasks(@Query("sort") String order);

        //Observable<HNItem> getItem(@Path("itemId") String itemId);


        @GET("games/?api_key=b1f2d14f1beaca51ed8288a5ca1faaf97753fcfa&format=json&filter=name:Fallout")
        //Call<GiantGames> loadGames(@Query("tagged") String tags);
         Observable<Game> getGameDetail(int id);

        // shown only as example
       /*

        @GET("/posts")
        public Observable<List<Game>> getPosts();

        @GET("/posts/{id}")
        public Observable<Post> getPost(@Path("id") int postId);

        @GET("/comments")
        public Observable<List<Comment>> getComments(@Query("postId") int postId);

        @POST("/posts")
        public Observable<Post>
        postPost(Post post);

        */
    }
}

/*
public interface GiantAPI {
    @retrofit2.http.GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    //Call<GiantGames> loadGames(@Query("tagged") String tags);
    public android.database.Observable<GiantGames> loadGames();


///

String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/questions?order=desc&sort=votes&site=stackoverflow&tagged=android&filter=withbody")
    Call<ListWrapper<Question>> getQuestions();

    @GET("/2.2/questions/{id}/answers?order=desc&sort=votes&site=stackoverflow")
    Call<ListWrapper<Answer>> getAnswersForQuestion(@Path("id") String questionId);



*/
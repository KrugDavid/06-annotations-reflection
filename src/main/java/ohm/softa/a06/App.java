package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import ohm.softa.a06.model.JokeTypeAdapter;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	static Gson gson = new Gson();
	static GsonBuilder gsonBuilder = new GsonBuilder();


	public static void main(String[] args) throws IOException {
		// TODO fetch a random joke and print it to STDOUT
		gsonBuilder.registerTypeAdapter(Joke.class, new JokeTypeAdapter());

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.icndb.com/jokes/").build();

		ICNDBApi icndbApi = retrofit.create(ICNDBApi.class);

		Call<Joke> jokeCall= icndbApi.getRandomJoke();

		System.out.println(gson.toJson(jokeCall.execute()));
	}

}

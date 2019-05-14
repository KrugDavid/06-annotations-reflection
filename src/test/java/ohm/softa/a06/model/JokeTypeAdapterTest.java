package ohm.softa.a06.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokeTypeAdapterTest {

	Joke sollJoke;
	Gson gson = new Gson();
	GsonBuilder gsonBuilder = new GsonBuilder();

	@BeforeEach
	void setup(){
		sollJoke = new Joke();
		sollJoke.setNumber(1);
		sollJoke.setContent("Dani ist blöd");
		sollJoke.setRubrics(new String[]{"Schwachsinn"});
		gsonBuilder.registerTypeAdapter(Joke.class, new JokeTypeAdapter());
	}

	@Test
	void read() {
		String istS = gson.toJson(sollJoke);
		String sollS = "{\"number\":1,\"content\":\"Dani ist blöd\",\"categories\":[\"Schwachsinn\"]}";

		assertTrue(istS.equals(sollS));
	}
}

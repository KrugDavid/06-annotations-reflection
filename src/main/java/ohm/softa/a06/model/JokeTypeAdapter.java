package ohm.softa.a06.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JokeTypeAdapter extends TypeAdapter<Joke> {

	Gson gson;

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {

	}

	@Override
	public Joke read(JsonReader in) throws IOException {

		JokeWrapper jokeWrapper = new JokeWrapper();
		jokeWrapper = gson.fromJson(in, JokeWrapper.class);

		return jokeWrapper.getValue();
	}

	static class JokeWrapper
	{
		String type;
		Joke value;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Joke getValue() {
			return value;
		}

		public void setValue(Joke value) {
			this.value = value;
		}
	}
}

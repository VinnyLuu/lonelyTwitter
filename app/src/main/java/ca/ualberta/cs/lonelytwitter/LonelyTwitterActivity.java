package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		Button clearButton = (Button) findViewById(R.id.clear);

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				tweets.removeAll(tweets);

				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String text = bodyText.getText().toString();
				ImportantTweet newtweet = new ImportantTweet();
				try {
					newtweet.setMessage(text);
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}
				newtweet.setDate(new Date());

				tweets.add(newtweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);

			Gson gson = new Gson();
			// Line below tries to make an instance of the tweet class. make the tweet class not abstract so that it can actually make an instance
			Type listTweetType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweets = gson.fromJson(reader, listTweetType);
			// This reads everything from the Json and puts it into the arraylist of tweets

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void saveInFile() {
		try {
			// FILE OUTPUTSTREAM makes a byte stream
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			// Char stream
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			// Buffer stream
			BufferedWriter writer = new BufferedWriter(osw);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
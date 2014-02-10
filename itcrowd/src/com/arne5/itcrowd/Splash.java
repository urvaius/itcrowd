package com.arne5.itcrowd;

import com.arne5.itcrowd.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle splashbun) {
		// TODO Auto-generated method stub
		super.onCreate(splashbun);

		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.itcrowdtheme);

		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);

		if (music == true)
			ourSong.start();

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(21000);

				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					Intent beginit = new Intent("com.arne5.itcrowd.MAINMENU");
					startActivity(beginit);

				}

			}

		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();

	}

}

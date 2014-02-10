package com.arne5.itcrowd;

import com.arne5.itcrowd.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	Button hook, reboot, milkb, internetb, computeb, infectedb, ramb, lukeb,
			eyeb, bstop;
	MediaPlayer datahook, reboottech, pmilk, pinternet, pcompute, pinfected,
			pram, pluke, peye;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datahook = MediaPlayer.create(this, R.raw.datahook);
		reboottech = MediaPlayer.create(this, R.raw.reboottech);
		pmilk = MediaPlayer.create(this, R.raw.milk);
		pinternet = MediaPlayer.create(this, R.raw.internet);
		pcompute = MediaPlayer.create(this, R.raw.compute);
		pinfected = MediaPlayer.create(this, R.raw.infected);
		pram = MediaPlayer.create(this, R.raw.ram);
		peye = MediaPlayer.create(this, R.raw.eye);
		pluke = MediaPlayer.create(this, R.raw.lukefhtr);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// hide statusbar of Android

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub
		bstop = (Button) findViewById(R.id.bStop);
		hook = (Button) findViewById(R.id.bDataHook);
		reboot = (Button) findViewById(R.id.bReboot);
		milkb = (Button) findViewById(R.id.bMilk);
		internetb = (Button) findViewById(R.id.bInternet);
		computeb = (Button) findViewById(R.id.bCompute);
		infectedb = (Button) findViewById(R.id.bInfected);
		ramb = (Button) findViewById(R.id.bRam);
		lukeb = (Button) findViewById(R.id.bLuke);
		eyeb = (Button) findViewById(R.id.bEye);
		eyeb.setOnClickListener(this);
		lukeb.setOnClickListener(this);
		milkb.setOnClickListener(this);
		hook.setOnClickListener(this);
		reboot.setOnClickListener(this);
		internetb.setOnClickListener(this);
		computeb.setOnClickListener(this);
		ramb.setOnClickListener(this);
		infectedb.setOnClickListener(this);
		bstop.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// on button clicks
		switch (v.getId()) {

		case R.id.bDataHook:

			try {
				datahook.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case R.id.bMilk:
			try {
				pmilk.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case R.id.bRam:
			try {
				pram.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bInternet:
			try {
				pinternet.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bInfected:
			try {
				pinfected.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bCompute:
			try {
				pcompute.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bReboot:
			try {
				
				reboottech.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bLuke:
			try {
				pluke.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bEye:
			try {
				peye.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bStop:

			if (peye.isPlaying()) {
				peye.pause();
				peye.stop();
			}

			else if (pluke.isPlaying()) {
				pluke.pause();
				pluke.stop();
			}

			else if (reboottech.isPlaying()) {
				reboottech.pause();
				reboottech.stop();
			}
			else if (datahook.isPlaying()) {
				datahook.pause();
				datahook.stop();
			}
			else if (pram.isPlaying()) {
				pram.pause();
				pram.stop();
			}
			else if (pmilk.isPlaying()) {
				pmilk.pause();
				pmilk.stop();
			}
			else if (pinternet.isPlaying()) {
				pinternet.pause();
				pinternet.stop();
			}
			else if (pinfected.isPlaying()) {
				pinfected.pause();
				pinfected.stop();
				
			}
			else if (pcompute.isPlaying()) {
				pcompute.pause();
				pcompute.stop();

			}else finish();

			break;

		}

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.AboutUs:
			Intent i = new Intent("com.arne5.itcrowd.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.arne5.itcrowd.PREFS");
			startActivity(p);

			break;
		case R.id.exit:
			finish();
			break;

		}
		return false;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		peye.release();
		pluke.release();
		pram.release();
		pluke.release();
		pinternet.release();
		pinfected.release();
		reboottech.release();
		pcompute.release();
		pmilk.release();
		datahook.release();

	}

}
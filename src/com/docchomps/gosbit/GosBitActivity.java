package com.docchomps.gosbit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GosBitActivity extends Activity {

	int[] my9 = new int[] { Color.argb(245, 51, 181, 229),
			Color.argb(245, 170, 102, 204), Color.argb(245, 153, 204, 0),
			Color.argb(245, 255, 187, 51), Color.argb(245, 255, 68, 68),
			Color.argb(245, 0, 153, 204), Color.argb(245, 153, 51, 204),
			Color.argb(245, 102, 153, 0), Color.argb(245, 255, 136, 0),
			Color.argb(245, 204, 0, 0) };

	int[] my9a = new int[] { Color.argb(145, 51, 181, 229),
			Color.argb(145, 170, 102, 204), Color.argb(145, 153, 204, 0),
			Color.argb(145, 255, 187, 51), Color.argb(145, 255, 68, 68),
			Color.argb(145, 0, 153, 204), Color.argb(145, 153, 51, 204),
			Color.argb(145, 102, 153, 0), Color.argb(145, 255, 136, 0),
			Color.argb(145, 204, 0, 0) };

	@Override
	protected void onResume() {
		super.onResume();

		// XXX
		Log.i("ok",
				"99.9999               ----------------continue----------------");
		xact = this;
		handleResume.sendEmptyMessageDelayed(2, 10);

	}

	@Override
	protected void onPause() {

		super.onPause();
		Log.i("ok",
				"99.9999      -------------------pause---------------------");
		upause = true;
		// hidetips.sendEmptyMessageDelayed(2, 75);

		// if (ipb != null) {
		// ipb.setImageResource(R.drawable.pbo);
		// }

		try {

			// refreshLocation.removeMessages(2);
			recordService.removeMessages(2);
			// recordService.removeMessages(3);
			tapClear.removeMessages(2);
			operationsPunctuation.removeMessages(2);
			smLead.removeMessages(2);

			if (xuri != null) {
				Message m88 = new Message();
				b88.putInt("duration", 120);
				m88.setData(b88);
				m88.what = 3;
				operationsPunctuation.sendMessage(m88);
				Log.i("ok", "requesting closing of " + xuri.toString());
			}

			// boxerhugoff.sendEmptyMessageDelayed(2, 75);

			if (som != null) {
				List<Sensor> hs = som.getSensorList(Sensor.TYPE_ALL);
				for (int h = 0; h < hs.size(); h++) {
					Sensor uk = hs.get(h);
					som.unregisterListener(sor, uk);
					uk = null;
				}
				hs = null;
			}

			// boxerhug.setVisibility(View.INVISIBLE);
			// boxerhugaware = false;
			if (reg != null) {
				reg.unregisterOnSharedPreferenceChangeListener(underDingo);

			}

			if (xuri == null && u8 != null) {
				try {
					u8.stop();
				} catch (IllegalStateException e1) {
					Log.i("ok", "wha e1 " + e1.getMessage());
					// e1.printStackTrace();
				}
				u8.reset();
				u8.release();

				// u8.release();
				u8 = null;
				// pu0 = null;
				// listeningcs = 1;
			}
			if (xuri == null && mvix != null) {
				mvix.lock();
				mvix.release();
				mvix = null;
			}

			for (int i = 0; i < smxb.length; i++) {
				if (smxb[i] != null) {
					smxb[i].recycle();
					smxb[i] = null;
				}
			}

			for (int i = 0; i < bmxb.length; i++) {
				if (bmxb[i] != null) {
					bmxb[i].recycle();
					bmxb[i] = null;
				}
			}
			// Log.i("ok", "xxx");
		} catch (RuntimeException e2) {
			Log.i("ok", "stop error " + e2.getMessage());
		}

	}

	RelativeLayout pbn;
	Context ctx;
	PackageManager pmc;
	ImageView tips;
	int hid = 234298;
	int mwidth = 320;
	int mheight = 320;
	int mmost = 320;
	Activity xact;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pas);

		pbn = (RelativeLayout) findViewById(R.id.pbc);
		pbn.setBackgroundColor(Color.argb(255, 118, 204, 237));

		ctx = getApplicationContext();
		pmc = ctx.getPackageManager();
		Display sd = getWindowManager().getDefaultDisplay();
		// sd.getOrientation();
		mwidth = sd.getWidth();
		mheight = sd.getHeight();
		sd = null;
		mmost = (mwidth > mheight ? mwidth : mheight);
		hid = (int) (System.currentTimeMillis() / 999);
		xact = this;

		if (tips == null) {
			tips = new ImageView(ctx);
			RelativeLayout.LayoutParams dhdx = new RelativeLayout.LayoutParams(
					-1, -1);
			tips.setLayoutParams(dhdx);
			dhdx = null;

			tips.setScaleType(ScaleType.FIT_XY);
			while (findViewById(++hid) != null) {
			}
			tips.setId(hid);
			tips.setBackgroundResource(R.drawable.ebon5);
			tips.setImageResource(R.drawable.dot);
			tips.setVisibility(View.INVISIBLE);
			pbn.addView(tips);
			// pbn =
		}

		{

			if (pss == null) {
				pss = new RelativeLayout(ctx);
				hid = (int) (System.currentTimeMillis() / 999);
				while (findViewById(++hid) != null) {
				}
				pss.setId(hid);
				DisplayMetrics hs = new DisplayMetrics();
				getWindow().getWindowManager().getDefaultDisplay()
						.getMetrics(hs);

				RelativeLayout.LayoutParams r9 = new RelativeLayout.LayoutParams(
						-1, (int) (hs.scaledDensity * 48));

				r9.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
				// r9.setMargins((int) (mwidth * .1f), 0, (int) (mwidth *
				// .1f),
				// (int) (mheight * .1f));
				r9.setMargins(0, 0, 0, (int) (120 - hs.scaledDensity * 48));// (int)
																			// (mheight
																			// *
																			// 0.2f)

				pss.setLayoutParams(r9);
				// pss.setBackgroundResource(R.drawable.progress_bg_holo_dark4);

				pss.setBackgroundColor(my9a[(new Random().nextInt(9))]);

				pss.setVisibility(View.INVISIBLE);
				pbn.addView(pss);
				// pbn.bringChildToFront(sparkEasel);
				pbn.bringChildToFront(tips);// creating pss

				// pss.startAnimation

				// pss.setOnClickListener(new OnClickListener() {
				// public void onClick(View v) {
				// flipOperation.sendEmptyMessageDelayed(5, 75);

				// operationsPunctuation.removeMessages(2);
				// scheduleOperation.removeMessages(ADURATION);

				// pssoff.removeMessages(2);
				// pssoff.sendEmptyMessageDelayed(2, 75);

				// }
				// });
			}

			// pss.setBackgroundResource(R.drawable.nano6);
			// pss.setBackgroundColor(Color.argb(235, 83, 186, 219));
			// pss.setBackgroundColor(Color.argb(235, 176, 216, 57));
			// pss.setBackgroundResource(R.drawable.wcc);
			if (pssi == null) {

				pssi = new ImageView(ctx);
				while (findViewById(++hid) != null) {
				}
				pssi.setId(hid);
				{
					RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
							-1, (int) (mheight * 0.2f));
					t2r.setMargins(60, 0, 60, 0);
					pssi.setLayoutParams(t2r);
				}
				pssi.setScaleType(ScaleType.FIT_XY);
				pssi.setImageResource(R.drawable.progress_secondary_holo_dark4);
				pss.addView(pssi);

			}
			// pss.setBackgroundResource;//
			pssShow.sendEmptyMessageDelayed(2, 75);
		}

		sreq01.sendEmptyMessageDelayed(2, 75);
	}

	long tipscs = 1;
	RelativeLayout boomBoard, sparkEasel, pbrus, alls;
	private Handler sreq01 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading " + msg.what);

			if (tips != null && tips.getVisibility() == View.INVISIBLE
					&& tipscs < System.currentTimeMillis()) {
				tips.setVisibility(View.VISIBLE);
				Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.oomx12);
				tips.startAnimation(a4);
				tipscs = System.currentTimeMillis() + a4.getDuration();
			}

			boomBoard = (RelativeLayout) findViewById(R.id.pbbc5);// ccx
			boomBoard.setVisibility(View.INVISIBLE);
			sparkEasel = (RelativeLayout) findViewById(R.id.pbbcn);

			{
				RelativeLayout.LayoutParams hiu = new RelativeLayout.LayoutParams(
						-1, -1);
				boomBoard.setBackgroundResource(R.drawable.ebin4);
				boomBoard.setLayoutParams(hiu);
			}

			// pba = (RelativeLayout) findViewById(R.id.pbaa);
			pbrus = (RelativeLayout) findViewById(R.id.pbrus);
			alls = (RelativeLayout) findViewById(R.id.alls);

			// 10m point xx
			sreq02.sendEmptyMessageDelayed(msg.what, 75);

		}
	};

	@Override
	protected void onRestoreInstanceState(Bundle i9) {
		super.onRestoreInstanceState(i9);
		Log.i("ok", "----------------restore----------------");
		if (i9.containsKey("recordid") && i9.getInt("recordid", -1) > -1) {
			xuri = Uri.parse("content://" + ctx.getPackageName() + "/moment/"
					+ i9.getInt("recordid", -1));
			Log.i("ok", "restore recordid xuri " + xuri.toString());
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle o9) {
		super.onSaveInstanceState(o9);
		Log.i("ok", "----------------save----------------");
		if (xuri != null) {

			try {
				o9.putInt("recordid",
						Integer.parseInt(xuri.getLastPathSegment()));
			} catch (NumberFormatException e9) {
				Log.i("ok", "xuri last segment not number " + xuri.toString());
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Log.i(G, "oncreataeoptionsmenu good");

		MenuItem o1 = menu.add(1, 1, 0, "History");
		o1.setIcon(R.drawable.ic_menu_archive);
		// MenuItem o2 = menu.add(1, 2, 2, "Bridges");

		if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			MenuItem o3 = menu.add(1, 14, 3, "Photo");
			o3.setIcon(R.drawable.ic_menu_camera);
		}

		{
			MenuItem o3 = menu.add(1, 15, 4, "Import");
			o3.setIcon(R.drawable.ic_menu_attachment);
		}

		{
			MenuItem o3 = menu.add(1, 79, 4, "Purchase");
			o3.setIcon(R.drawable.swarm_store40);
		}

		File filea = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), "data/" + ctx.getPackageName());
		filea.mkdirs();

		if (filea.exists()) {

			// MenuItem o4 = menu.add(1, 4, 3, "Set");
			MenuItem o5 = menu.add(1, 5, 6, "Share");
			// o5.setTitle("Share");
			o5.setIcon(R.drawable.ic_menu_share);

			// MenuItem o6 = menu.add(1, 6, 3, "Total Recall");
			// o6.setTitle("");
			// o6.setIcon(R.drawable.bpn);
		} else {
			// MenuItem o3 = menu.add(1, 3, 3, "Search");
			// o3.setTitle("");
			// o3.setIcon(R.drawable.ic_menu_search);
		}
		// MenuItem o8 = menu.add(1, 8, 3, "Total Recall");
		// o8.setTitle("");
		// o8.setIcon(R.drawable.bpn);

		// up.sendEmptyMessageDelayed(2, 100);
		//
		{
			MenuItem o3 = menu.add(1, 13, 2, "Search");
			o3.setIcon(R.drawable.ic_menu_search);
		}

		{
			MenuItem o5 = menu.add(3, 114, 5, "Games");
		}

		{
			SubMenu l9 = menu.addSubMenu(3, 73, 5, "Settings");
			l9.setIcon(R.drawable.ic_menu_preferences);

			{
				MenuItem o5 = l9.add(3, 113, 5, "Light");
			}

			{
				MenuItem o5 = l9.add(4, 74, 5, "Cloud");
				// SubMenu l9n = menu.addSubMenu(4, 73, 5, "Swarm");
			}
		}

		{

			// MenuItem o3 = menu.add(1, 74, 5, "Swarm");
			// o3.setTitle("");
			// o3.setIcon(R.drawable.swarm_head);

			// SubMenu l9 = o3.getSubMenu();
			// if (l9 == null) {
			// SubMenu l9 = menu.addSubMenu(2, 73, 5, "Swarm");
			{
				// MenuItem o5 = l9.add(1, 74, 5, "Dashboard");
				// o5.setIcon(R.drawable.swarm_head);
			}

			{
				// MenuItem o5 = l9.add(1, 75, 5, "Login");
				// o5.setIcon(R.drawable.swarm_head);
			}

			// {
			// MenuItem o5 = l9.add(1, 76, 5, "Store");
			// o5.setIcon(R.drawable.swarm_head);
			// }

			{
				// MenuItem o5 = l9.add(1, 77, 5, "Leaderboards");
				// o5.setIcon(R.drawable.swarm_head);
			}

			{
				// MenuItem o5 = l9.add(1, 78, 5, "Achievements");
				// o5.setIcon(R.drawable.swarm_head);
			}

		}

		return super.onCreateOptionsMenu(menu);
	}

	String[] importlist = new String[99];
	int importc = 1;

	Handler importContents = new Handler() {
		public void handleMessage(Message msg) {

			Bundle sib = msg.getData();

			Set<String> k9 = sib.keySet();
			Object[] b = k9.toArray();
			Log.i("ok",
					"** IMPORT ** \n** IMPORT ** \n** IMPORT ** \n** IMPORT ** Colu got "
							+ sib.size() + " in " + b.length + " keys");

			{
				// uridata"
				if (sib.containsKey("uri_data")) {
					Uri xu = Uri.parse(sib.getString("uri_data"));

					{
						Bundle nx = new Bundle(sib);
						nx.putInt("drawable", R.drawable.midres9r);
						Message m9 = new Message();
						m9.setData(nx);
						m9.what = -1;
						tabfy.sendMessageDelayed(m9, 75);
					}
					// data.getData()
					// get content via uri

					Log.i("ok",
							"** IMPORT ** Action Imported *.* file may be in bundle TYPE "
									+ getContentResolver().getType(xu) + " ("
									+ xu.toString() + ")");
					// 749

					Cursor k = SqliteWrapper.query(ctx, getContentResolver(),
							xu, new String[] { "*" }, null, null, null);

					if (k != null && k.moveToFirst()) {
						String[] b8 = k.getColumnNames();
						String b9 = "";
						for (int i = 0; i < b8.length; i++) {
							b9 += ", " + b8[i];
							try {
								if (!k.isNull(i)) {
									// b9 += "("
									// + (k.getString(i) != null ? k
									// .getString(i) : "-") + ")"
									// + ",";
									b9 += "(" + k.getString(i) + ") ";
								}

							} catch (ClassCastException hu) {
								Log.i("ok",
										"** IMPORT ** Action columns " + b8[i]
												+ " class exception "
												+ hu.getMessage());
							}
						}
						Log.i("ok", "** IMPORT ** Action columns " + b9);

					}
					if (k != null) {
						k.close();
					}
				}
			}

			for (int n = 0; n < b.length; n++) {
				Object j9;// byte[] j9;
				j9 = sib.get((String) b[n]);
				// j9 = sib.getByteArray((String) b[n]);

				// if (new String((String) b[n]).matches("[0-9]+$")) {
				// Log.i("ok", "Colu data "
				// + (String) b[n]
				// + " "
				// + (j9 != null ? j9.length + " bytes"
				// : "-no data-"));
				if (j9 == null) {
					continue;
				}

				if (j9.getClass().getName().contains("Integer")) {
					int uu9 = sib.getInt((String) b[n]);
					Log.i("ok", "** IMPORT ** Colu row Integer "
							+ (String) b[n] + ": " + uu9);
				} else if (j9.getClass().getName().contains("Long")) {
					long uu9 = sib.getLong((String) b[n]);
					Log.i("ok", "** IMPORT ** Colu row Long " + (String) b[n]
							+ ": " + uu9);
				} else if (j9.getClass().getName().contains("String")) {
					Log.i("ok", "** IMPORT ** Colu row String " + (String) b[n]
							+ ": " + (String) j9);

					if (((String) b[n]).contentEquals("data")) {
						// && new String((String) j9).contains("file:")) {

						// File filea = new File((String) j9);
						// if (filea.exists()) {
						Bundle nx = new Bundle();
						// nx.putString("uri_data", xu.toString());
						nx.putString("data", (String) j9);// Uri.fromFile(filea).toString());
						nx.putInt("drawable", R.drawable.midres9r);
						Message m9 = new Message();
						m9.setData(nx);
						m9.what = -1;
						tabfy.sendMessageDelayed(m9, 175);
						// }
					}
				} else if (j9.getClass().getName().contains("Uri")) {
					Log.i("ok", "** IMPORT ** Colu row Uri " + (String) b[n]
							+ ": " + ((Uri) j9).toString());

				} else if (j9.getClass().getName().contains("Bitmap")) {
					// Bitmap h9 = Bitmap.createBitmap((Bitmap) j9);

					try {
						Bitmap h9 = Bitmap.createScaledBitmap((Bitmap) j9,
								(int) ((mwidth * 0.3) / 1),
								(int) ((mheight * 0.3) / 1), true);

						if (h9 == null) {
							continue;
						}
						Bitmap h8 = Bitmap.createBitmap((int) (mwidth * 0.3),
								(int) (mheight * 0.3), Bitmap.Config.ARGB_8888);
						Canvas h7 = new Canvas(h8);
						h7.drawBitmap(h9, 0, 0, new android.graphics.Paint());
						// (int) (((mwidth * 0.3) / 1 - mwidth) / 2) * -1,
						// (int) (((mheight * 0.3) / 1 - mheight) / 2)
						// * -1, new android.graphics.Paint());

						Log.i("ok", "** IMPORT ** Colu row Bitmap "
								+ (String) b[n] + ": "
								+ j9.getClass().getName());
						// import
						File filea4 = new File(
								Environment
										.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
								""
										+ getApplication().getString(
												R.string.app_name));
						filea4.mkdirs();

						if (reg == null) {
							reg = ctx.getSharedPreferences("Preferences",
									Context.MODE_WORLD_WRITEABLE);
							edt = reg.edit();

						}
						String dn = reg
								.getString("defactoprefacto_i", "import");

						int dnc = (reg.getInt("numerofactodefacto_i" + dn, 0) + 1);
						edt.putInt("numerofactodefacto_i" + dn, dnc);
						edt.commit();
						// FileOutput

						File filea = new File(filea4, dn + "" + dnc + ".png");
						File fileb = new File(filea4, dn + "" + dnc
								+ "_mres.png");
						// midres
						FileOutputStream o9;
						FileOutputStream o9b;
						ByteArrayOutputStream st;
						{
							o9 = new FileOutputStream(filea);
							st = new ByteArrayOutputStream();
							if (st != null) {
								h8.compress(CompressFormat.PNG, 0, st);
								o9.write(st.toByteArray());
							}
							o9.close();
						}

						{
							o9b = new FileOutputStream(fileb);
							st = new ByteArrayOutputStream();
							if (st != null) {
								Bitmap n9 = Bitmap.createScaledBitmap(h8,
										(int) (h8.getWidth()
												* (h8.getWidth() - 72) / 72),
										(int) (h8.getHeight()
												* (h8.getWidth() - 72) / 72),
										true);
								n9.compress(CompressFormat.PNG, 0, st);
								if (n9 != null) {
									o9b.write(st.toByteArray());
								}
							}
							o9b.close();
						}

						if (filea.exists()) {
							animportlist += Uri.fromFile(filea).toString()
									+ ",";
						}

						{
							ImageView i8 = new ImageView(ctx);
							{
								RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
										-1, -1);
								// t2r.weight = 1;
								// t2r.setMargins((int) (mwidth * 0.9f),
								// (int) (mheight * 0.9f), 0, 0);
								// t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,
								// -1);
								// t2r.addRule(RelativeLayout.CENTER_IN_PARENT,
								// -1);
								t2r.setMargins(0, 0, 0, 0);
								i8.setLayoutParams(t2r);
							}
							while (findViewById(++hid) != null) {
							}

							i8.setId(hid);
							i8.setScaleType(ScaleType.FIT_CENTER);
							// i8.setImageBitmap(h8);
							i8.setAlpha(255);

							if (filea.exists()) {
								Bitmap n0 = BitmapFactory.decodeFile(filea
										.getAbsolutePath());
								if (n0 != null) {
									i8.setImageBitmap(n0);
									// i8.setImageURI(Uri.fromFile(fileb));
								} else {
									i8.setImageResource(R.drawable.pokeeo);
								}
							} else {
								i8.setImageResource(R.drawable.pokee);
							}
							pbn.addView(i8, 1);

							Animation o0 = AnimationUtils.loadAnimation(ctx,
									R.anim.oomx12);
							o0.setDuration(1568);
							i8.startAnimation(o0);

							if (filea.exists()) {
								Bundle nx = new Bundle();
								// nx.putString("uri_data", xu.toString());
								nx.putString("data", Uri.fromFile(filea)
										.toString());
								nx.putInt("drawable", R.drawable.midres9r);
								Message m9 = new Message();
								m9.setData(nx);
								m9.what = -1;
								tabfy.sendMessageDelayed(m9, 175);
							}

							// fildash =
							// OnClickL

							// "aheardlist"
							// animportlist += Uri.fromFile(bu) + ",";
						}

					} catch (FileNotFoundException eg3) {
						Log.i("ok",
								"** IMPORT ** wha io decode e 14b "
										+ eg3.getMessage());
						eg3.printStackTrace();
					} catch (IOException eg5) {
						Log.i("ok", "** IMPORT ** wha io decode 15b ");// e.printStackTrace();
					}

				} else {
					Log.i("ok", "** IMPORT ** Colu row appears to be big "
							+ (String) b[n] + ": " + j9.getClass().getName());
				}
			}
		}
	};

	boolean isP(int hn8, int hp9) {
		while (hn8 % hp9 == 0) {
			hn8 -= hn8 * hp9;
		}
		if (hn8 > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i("ok",
				"result received "
						+ requestCode
						+ "/"
						+ resultCode
						+ "/"
						+ (data != null && data.getData() != null ? data
								.getData().toString() : "-no data-")
						+ "/"
						+ (requestCode < importlist.length
								&& importlist[requestCode] != null ? importlist[requestCode]
								: "-unknown-"));

		if (data == null) {
			data = new Intent();
		}
		// I am living my own life. I am always going to perform the best for my
		// life. i live by honor code that could use grinding with loving
		// company.

		if (data.getData() == null && requestCode >= 0
				&& requestCode < importlist.length
				&& importlist[requestCode] != null) {
			File h9 = new File(importlist[requestCode]);
			if (h9.exists()) {
				data.putExtra("data", Uri.fromFile(h9).toString());
			}
		}

		if (data != null) {
			Bundle sibn = data.getExtras();
			if (sibn != null) {
				Log.i("ok",
						"received request results =========================================");
				Bundle sib = new Bundle(sibn);
				sib.putInt("_action", requestCode);
				sib.putInt("_return", resultCode);
				if (data.getData() != null) {
					sib.putString("uri_data", data.getData().toString());
				}

				Message om = new Message();
				om.setData(sib);
				if (resultCode == RESULT_OK) {
					Log.i("ok", "result OK import contents");
					importContents.sendMessageDelayed(om, 75);
				} else {
					Log.i("ok", "result OK import interrupted");
				}
				// setResult(resultCode);
			}
		}

		if (requestCode < 300 && requestCode < importlist.length
				&& requestCode > 0 && importlist[requestCode] != null) {

			// if (data != null && data.getData() != null) {
			// showImage.sendEmptyMessageDelayed(requestCode, 75);
			// }

			// if (requestCode == importc - 1) {
			// if (resultCode == RESULT_OK) {
			// Image captured and saved to fileUri specified in the
			// Intent
			// Toast.makeText(this, "Image saved to:\n" + data.getData(),
			// Toast.LENGTH_LONG).show();
			// } else if (resultCode == RESULT_CANCELED) {
			// User cancelled the image capture
			// } else {
			// Image capture failed, advise user
			// }
			// }

		}
	}

	Handler showImage = new Handler() {
		public void handleMessage(Message msg) {

			int requestCode = msg.what;
			Log.i("ok", "Image saved to " + importlist[requestCode]);
			File bu = new File(importlist[requestCode]);
			if (bu != null && bu.exists()) {
				Log.i("ok", "Image found");
				// new ImageView

				{
					ImageView i8 = new ImageView(ctx);
					{
						RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
								(int) (mwidth), (int) (mheight));
						// t2r.weight = 1;
						// t2r.setMargins((int) (mwidth * 0.9f),
						// (int) (mheight * 0.9f), 0, 0);
						// t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,
						// -1);
						// t2r.addRule(RelativeLayout.CENTER_IN_PARENT,
						// -1);
						t2r.setMargins(0, 0, 0, 0);
						i8.setLayoutParams(t2r);
					}
					while (findViewById(++hid) != null) {
					}
					i8.setId(hid);
					i8.setScaleType(ScaleType.FIT_CENTER);
					i8.setImageURI(Uri.fromFile(bu));
					// fildash =
					// OnClickL
					sparkEasel.addView(i8);

					// "aheardlist"

					animportlist += Uri.fromFile(bu) + ",";
				}

			}
		}
	};

	String animportlist = "";

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (event.getUnicodeChar() > 0) {
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				onSearchRequested();
				return true;
			}
		} else if (keyCode == KeyEvent.KEYCODE_CAMERA
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			File box = newImportFile();
			if (box != null) { // start the image capture Intent
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(box));
				importlist[importc] = box.getAbsolutePath();
				startActivityForResult(intent, importc++);
			}
			return true;
		} else {
			Log.i("ok", "can I use key " + keyCode
					+ "<-hardwared dependent from " + event.getDeviceId());
		}

		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.i("ok", "onmenuitemselected good xxx");
		// onKeyDow
		// playaudio2

		switch (item.getItemId()) {
		// case 8:
		// dingoSparkToggle.sendEmptyMessageDelayed(0, 10);
		// break;
		case 113:

		{
			Bundle nx = new Bundle();
			// nx.putString("uri_data", xu.toString());
			// nx.putString("data", Uri.fromFile(box).toString());
			nx.putString("timer", "light");
			nx.putInt("drawable", R.drawable.cloud);

			// nx.putFloat("scale", 0.5f);
			// nx.putInt("left", 99);
			// nx.putInt("top", mheight - 380);
			Message m9 = new Message();
			m9.setData(nx);
			m9.what = -1;
			tabfy.sendMessageDelayed(m9, 25);
		}
			// run these lines when //tool light

			if (pbn.getKeepScreenOn()) {
				pbn.setKeepScreenOn(false);
				Toast.makeText(ctx, "Computer will Dim", 5899).show();
				edt.remove("keeplit");// .putLong("keeplit",
										// System.currentTimeMillis());
				edt.commit();
			} else {
				Toast.makeText(ctx, "Computer is Lit", 5899).show();
				pbn.setKeepScreenOn(true);
				edt.putLong("keeplit", System.currentTimeMillis());
				edt.commit();
			}
			break;

		case 15:
			Intent i9 = new Intent(Intent.ACTION_GET_CONTENT);

			{
				File filea4 = new File(
						Environment
								.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
						"" + getApplication().getString(R.string.app_name));
				filea4.mkdirs();

				String dn = reg.getString("defactoprefacto_i", "import");
				int dnc = (reg.getInt("numerofactodefacto_i" + dn, 0) + 1);
				edt.putInt("numerofactodefacto_i" + dn, dnc);
				edt.commit();

				// File box;
				// box = new File(filea.getAbsolutePath(), "" + dn + "" + dnc +
				// ".png");
				// while (box.exists()) {
				// box = new File(filea.getAbsolutePath(), "" + dn + "" +
				// (++dnc)
				// + ".png");
				// }

				// start the image capture Intent
				i9.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(filea4));
				// intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
				// importlist[importc] = box.getAbsolutePath();
				i9.setType("*/*");
				startActivityForResult(i9, 402);
			}
			break;
		case 14: {
			// File filea = new
			// File(Environment.getExternalStorageDirectory()
			// .getAbsolutePath(), "data/" + ctx.getPackageName() + "/"
			// + myDay());

			File box = newImportFile();
			if (box != null) { // start the image capture Intent
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(box));
				importlist[importc] = box.getAbsolutePath();
				startActivityForResult(intent, importc++);
			}
			// intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		}
			break;

		case 13:
			onSearchRequested();
			break;
		case 7:
			productiondash.setVisibility(View.INVISIBLE);
			break;

		case 5:// Cursor insert update

			sendone.sendEmptyMessageDelayed(
					2,
					actwin > System.currentTimeMillis() ? (actwin - SystemClock
							.uptimeMillis()) + ADURATION : 10);

			break;

		case 1:
			Intent r4 = new Intent(ctx, ColumnsRows.class);
			r4.putExtra("cu", "content://" + ctx.getPackageName() + "/moment");
			r4.putExtra("c1", "content://" + ctx.getPackageName()
					+ "/moment\naheardlist\nfieldid\n" + ROWID
					+ "\naudio\npres");
			r4.putExtra("c2", "content://" + ctx.getPackageName()
					+ "/moment\nmres\nfieldid\n" + ROWID + "\nimagea");
			r4.putExtra("cl", "atitle,created,lat,lon");
			startActivity(r4);

			// r4.putExtra("c2", "content://" + ctx.getPackageName()
			// + "/moment\naslope\nfieldid\n_id\nimageb");
			// r4.putExtra("c4",
			// "content://com.docchomps.ok/moment\n_id\nfieldid\n_id\nstring");

			break;
		case 2:
			// int sdkVersion = Integer.parseInt(Build.VERSION.SDK);

			// startActivityForResult(new Intent)
			// Log.i("x", "v" + sdkVersion);
			// Toast.makeText(ctx, "v" + sdkVersion, 2300).show();
			// if (sdkVersion < 5) {
			// startActivityForResult(new Intent(Intent.ACTION_PICK,
			// Contacts.CONTENT_URI), 0);

			// } else {
			// startActivityForResult(
			// new Intent(Intent.ACTION_PICK,
			// Uri.parse("content://com.android.contacts/")),
			// 0);

			// }

			Intent r43 = new Intent(ctx, com.docchomps.gosbit.ColumnsRows.class);
			// r43.putExtra("cu", ContactsContract.Data.CONTENT_URI.toString());
			r43.putExtra("c1", "content://" + ctx.getPackageName()
					+ "/contact\nrotation\nfieldc\nemail\nstring");
			startActivity(r43);

			break;
		case 3:
			Cursor ge5 = SqliteWrapper
					.query(ctx,
							getContentResolver(),
							Uri.parse("content://" + ctx.getPackageName()
									+ "/checkin"), new String[] { "_id" },
							null, null, null);

			if (ge5 != null && ge5.moveToFirst()) {
				ge5.close();
			} else {
				// 749

				ContentValues cx = new ContentValues();
				// cx.put("anext", "");
				cx.put("rotation", 5 * 60);
				cx.put("atitle", "Check In");
				SqliteWrapper.insert(
						ctx,
						ctx.getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/checkin"), cx);
				cx = null;
				ContentValues cx4 = new ContentValues();
				cx4.put("atill", datetime(System.currentTimeMillis()
						+ (30 * 60 * 1000)));
				cx4.put("atillset", 1);
				cx4.put("rotation", 5);

				cx4.put("atitle", "Check In");
				SqliteWrapper.insert(
						ctx,
						ctx.getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/checkin"), cx4);
				cx4 = null;
			}

			Intent r42 = new Intent(ctx, com.docchomps.gosbit.ColumnsRows.class);
			r42.putExtra("title", "Settings");
			r42.putExtra("cu", "content://" + ctx.getPackageName() + "/checkin");
			r42.putExtra("c1", "content://" + ctx.getPackageName()
					+ "/checkin\nrotation\nfieldid\n_id\nnumeric");

			startActivity(r42);
			break;
		default:
			// Toast.makeText(mCtx, "us", 540).show();
		}

		return super.onMenuItemSelected(featureId, item);
	}

	File newImportFile() {
		File filea = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"" + getApplication().getString(R.string.app_name));
		filea.mkdirs();

		String dn = reg.getString("defactoprefacto_i", "import");
		int dnc = (reg.getInt("numerofactodefacto_i" + dn, 0) + 1);
		edt.putInt("numerofactodefacto_i" + dn, dnc);
		edt.commit();

		File box = new File(filea.getAbsolutePath(), "" + dn + "" + dnc
				+ ".png");
		while (box.exists()) {
			box = new File(filea.getAbsolutePath(), "" + dn + "" + (++dnc)
					+ ".png");
		}

		return box;

	}

	public Handler sendone = new Handler() {
		public void handleMessage(Message msg) {

			Cursor ge = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://" + ctx.getPackageName() + "/moment"),
					new String[] { ROWID, "mres", "avec", "created",
							"acontent", "atitle", "date(created)", "lat",
							"lon", "adeep", "aheardlist", "animportlist",
							"hres" }, null, null, ROWID + " desc limit 1");
			// aheard
			if (ge != null && ge.moveToFirst()) {
				String cct = ge.getString(4);
				float lat = ge.getFloat(7);
				float lon = ge.getFloat(8);
				float adeep = ge.getInt(9);
				String cca = ge.getString(5);
				String cad = ge.getString(6);
				String aheardlist = ge.getString(10);
				String animportlist = ge.getString(11);
				String hres = ge.getString(12);
				if (aheardlist == null) {
					aheardlist = "";
				}

				String ccf = cca + " " + cad;
				Log.i("ok", ccf + " found " + aheardlist.replaceAll(",", ", ")
						+ " w/ " + animportlist.replaceAll(",", ", "));
				// maps.google.com
				String mss = "";
				if (cct != null && cct.length() > 2) {
					mss += cct + "\n";
				}
				if (reg.getString("geostory", "").length() > 0) {
					mss += "\n" + reg.getString("geostory", "");
				} else if (lat != 0.0 || lon != 0.0) {
					mss += "\n\nGoogle Map: http://maps.google.com/?ll=" + lat
							+ "," + lon + "";
					// mss += "\n" + lat + "," + lon + " " + adeep + "\n";
				}
				mss += "\n\n\n";

				File filea = new File(Environment.getExternalStorageDirectory()
						.getAbsolutePath(), "data/" + ctx.getPackageName()
						+ "/" + myDay());
				filea.mkdirs();
				ArrayList<Uri> uris = new ArrayList<Uri>();

				if (filea.exists()) {
					FileOutputStream o9;
					// File apng = new File(filea.getAbsolutePath(), ccf +
					// ".png");

					// if (ge.getBlob(2) != null) {

					if (hres != null) {
						File apng = new File(hres.replaceFirst("file:..", ""));
						if (apng.exists()) {
							uris.add(Uri.fromFile(apng));
						}
						// try {
						// o9 = new FileOutputStream(apng);
						// o9.write(ge.getBlob(2));
						// o9.close();

						// } catch (FileNotFoundException e) {
						// Log.i("ok", "wha io e 14");// e.printStackTrace();
						// } catch (IOException e) {
						// Log.i("ok", "wha io e 15");// e.printStackTrace();
						// }
					}

					{
						File apng;
						String[] hx = new String(aheardlist + ","
								+ animportlist).split(",");
						for (int c = 0; c < hx.length; c++) {
							if (hx[c].length() > 0) {
								apng = new File(hx[c]);
								Log.i("ok", "send one file " + hx[c] + " "
										+ apng.exists());
								if (apng.exists()) {
									uris.add(Uri.fromFile(apng));
								}
							}
						}
					}

					// aheard.send
					{
						Intent hj = new Intent();
						// hj.setAction("com.docchomps.ok.EMAIL");
						// hj.setClass(ctx, Anumeric.class);
						hj.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
						hj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
								| Intent.FLAG_ACTIVITY_NO_HISTORY);
						// CONN GPS
						hj.setType("text/plain");
						hj.putExtra(Intent.EXTRA_TEXT, mss);

						// hj.putExtra(android.content.Intent.EXTRA_CC,
						// new String[] { "havenskys@gmail.com" });

						hj.putParcelableArrayListExtra(Intent.EXTRA_STREAM,
								uris);
						hj.putExtra(Intent.EXTRA_SUBJECT, cca);
						startActivity(hj);

					}
					ge.close();
				}

			} else {

				if (ge != null) {
					ge.close();
				}
			}
		}
	};

	public String myDay() {
		Date b = new Date();
		String d1 = "."// <-- This '.' will hide these from Galleries, use
						// public spaces for those/app_name/{blob}
				+ (b.getYear() + 1900)
				+ ""
				+ (b.getMonth() < 9 ? "0" + (b.getMonth() + 1)
						: b.getMonth() + 1)
				+ ""
				+ (b.getDate() < 10 ? "0" + (b.getDate()) : b.getDate());
		return d1;
	}

	// boolean redund = true;

	// if (cca != null && cca.length() > 2) {
	// mss += "\n== " + cca + " ==\n";
	// }

	// } else if (ge.getFloat(8) > 0f ||
	// ge.getFloat(8) <
	// 0f) {
	// mss += "" + ge.getFloat(8) + "," +
	// ge.getFloat(9)
	// + "\n";

	// if (gpsla != 1 || gpsla != 1 || gpsld != 1) {

	// }
	// Electric White Presenting";

	// File fileIn = new File(file);
	// Uri u = Uri.fromFile(fileIn);

	// if (redund) {
	// sendfile += apng.getAbsolutePath() + "\n";
	// }
	// hj.putExtra(Intent.EXTRA_STREAM,
	// Uri.parse("file://" +
	// apng.getAbsolutePath()));
	// hj.setType("message/rfc822");

	// http://maps.google.com/?ll=47.620766,-122.325425&spn=0.00392,0.006512

	// "x"

	// hj.putExtra(android.content.Intent.EXTRA_EMAIL,
	// new String[] { "havenskys@gmail.com" });
	// has to be an ArrayList
	// convert from paths to Android friendly
	// Parcelable
	// Uri's
	// for (String file : sendfile.split("\n")) {

	// File fileIn = new File(file);
	// if (fileIn.exists()) {
	// Uri u = Uri.fromFile(fileIn);
	// uris.add(u);
	// }
	// }

	// new
	// Intent(Intent.ACTION_SEND);

	// +
	// ge.getString(7));
	// en

	// startActivity(Intent.createChooser(hj,
	// "Email"));

	int dcelw = 120;
	int dcelh = 120;
	private Handler sreq02 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading b " + msg.what);

			{
				RelativeLayout.LayoutParams dhdx;
				ImageView hj;
				int sx = dcelw;
				int sy = dcelh;
				int wx = 3;
				int wy = 3;
				int wspace = mwidth - 60;
				// sx = wspace/wx
				while (wspace / wx > sx) {
					if (wspace / wx > sx * 2) {
						wx++;
						continue;
					}
					sx++;
				}
				// draw up
				while (sx * wx > wspace) {
					sx--;
				}

				// wy = 1 + (balls.length / wx);
				int hspace = boomBoard.getHeight() - 60;

				while (sy * (wy + 0) > hspace) {
					sy--;
				}
				while (sy * (wy + 0) < hspace) {
					sy++;
				}

				dcelw = sx;
				dcelh = sy;

			}

			sreq03.sendEmptyMessageDelayed(msg.what, 75);

		}
	};

	Handler pssProg = new Handler() {
		boolean ox = false;

		public void handleMessage(Message msg) {
			pssProg.removeMessages(2);
			if (ox) {
				pssi.setImageResource(R.drawable.progress_primary_holo_dark4);
				ox = false;
			} else {
				pssi.setImageResource(R.drawable.progress_secondary_holo_dark4);
				ox = true;
			}
			if (smx == 0) {
				pssoff.sendEmptyMessageDelayed(2, 85);
			} else {
				// Our founding fathers had a revolution and wrote a
				// constitution.
				// Respecting personal liberty.
				pssProg.sendEmptyMessageDelayed(2, 250);
			}

		}
	};

	ImageView pssi;
	Bitmap[] bla = new Bitmap[9];
	Bitmap[] blm = new Bitmap[9];
	// Bitmap bla2;
	android.graphics.Paint[] gppb = new android.graphics.Paint[9];

	int dw = 120;
	int dh = 120;
	private Handler sreq03 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading c " + msg.what);

			if (bla[0] == null) {
				Log.i("ok", "Mark pokes");

				int ni = 1;
				for (int ki = 0; ki < 8; ki++) {

					switch (ki) {
					case 1:
						ni = R.drawable.pokee;
						break;
					case 2:
						ni = R.drawable.pokeeo;
						break;
					case 3:
						ni = R.drawable.pokeeg;
						break;
					case 4:
						ni = R.drawable.pokeec;
						break;
					case 0:
						ni = R.drawable.pokeeb;
						break;
					default:
						ni = R.drawable.pokeeb;
					}

					// if (ni != 1) {
					try {
						bla[ki] = BitmapFactory.decodeResource(getResources(),
								ni);

						if (bla[ki] != null) {
							blm[ki] = Bitmap.createScaledBitmap(bla[ki],
									(int) (bla[ki].getWidth() * scalem),
									(int) (bla[ki].getHeight() * scalem), true);
						}

						gppb[ki] = new android.graphics.Paint();
						// gppb[ki].setColor(bh);
						gppb[ki].setStrokeWidth(1f);

					} catch (NotFoundException ei) {
						Log.w("ok",
								"wha p " + ki + ", " + ni + ", "
										+ ei.getMessage());
					} catch (OutOfMemoryError j9) {
						Log.i("ok", "decode mb9 ");
					}
					// }
				}

				dw = bla[0].getWidth();
				dh = bla[0].getHeight();

			}

			// 10
			sreq04.sendEmptyMessageDelayed(2, 75);

		}
	};

	boolean started = false;
	boolean resume = false;
	boolean upause = false;
	private Handler sreq04 = new Handler() {
		// Animation anhub4;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading d " + msg.what);
			pbn.setOnTouchListener(sparkBoardUI);
			// triDraw.sendEmptyMessageDelayed(2, 200);
			// smartSparkService.sendEmptyMessageDelayed(5, 175);
			// smartSpark.sendEmptyMessageDelayed(2, 75);

			hid = (int) (System.currentTimeMillis() / 999);
			if (mwidth > mheight) {
				hbpathL = new Path();
				hbpathL.addCircle((int) ((mwidth) / 2), (int) ((mheight) / 2),
						(int) ((mheight) / 2) - 40, Path.Direction.CCW);
			} else {
				hbpathL = new Path();
				hbpathL.addCircle((int) ((mwidth) / 2), (int) ((mheight) / 2),
						(int) ((mwidth) / 2) - 40, Path.Direction.CCW);
			}
			// tapcn

			started = true;
			if (resume) {
				Log.i("ok",
						"Running handleResume from sreq 04 ================================");
				handleResume.sendEmptyMessageDelayed(2, 75);
			} else {
				Log.w("ok",
						"Warning handleResume from sreq 04 ================================");
			}

		}
	};

	@Override
	public boolean onSearchRequested() {
		// pauseSomeStuff();

		// upause = true;
		return super.onSearchRequested();
	}

	Handler pssShow = new Handler() {
		public void handleMessage(Message msg) {
			if (pssi == null) {
				Log.w("ok", "pssShow no b");
				return;
			}
			if (pss == null) {
				Log.w("ok", "pssShow no c");
				return;
			}

			pssProg.sendEmptyMessageDelayed(2, 250);
			Animation oh = AnimationUtils.loadAnimation(ctx, R.anim.progon);// oomx8
			// oh.setStartOffset(1880);
			// oh.setStartOffset(1880 * 2);
			oh.setDuration(1880 * 3);
			// pbn.bringChildToFront(pss);
			// pbn.bringChildToFront(tips);

			pss.setVisibility(View.VISIBLE);
			Animation ohb = AnimationUtils.loadAnimation(ctx, R.anim.psson);
			pss.startAnimation(ohb);

			pssi.startAnimation(oh);

			// pssoff.sendEmptyMessageDelayed(2, oh.getDuration());

			psscs = System.currentTimeMillis() + oh.getDuration() - 40;
			pssoff.sendEmptyMessageDelayed(2, 1880 * 5);

		}
	};
	RelativeLayout pss;
	Handler tvhidea = new Handler() {
		public void handleMessage(Message msg) {

			if (!reg.contains("starr")
					|| (reg.getLong("starr", 1) < System.currentTimeMillis() - 30 * 600)) {
				// ideas edeas
				TextView r8 = new TextView(ctx);
				RelativeLayout.LayoutParams r9 = new RelativeLayout.LayoutParams(
						-1, -2);
				r9.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
				r9.setMargins(48, 48, 48, 48);

				hid = (int) (System.currentTimeMillis() / 999);
				while (findViewById(++hid) != null) {
				}
				r8.setId(hid);

				r8.setVisibility(View.VISIBLE);
				// Log.i("ok", "Created tv wha " + hid + " " + r8.getId());
				r8.setLayoutParams(r9);

				r8.setGravity(Gravity.CENTER);
				// .//idealion4);
				r8.setTextColor(my9[3]);
				r8.setShadowLayer(2f, 2, 2, my9a[1]);

				r8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28f);
				// r8.setTextSize(18f);

				if (reg.contains("starr")) {
					// r8.setText("On Air");
					// tvhide.sendEmptyMessageDelayed(r8.getId(), 175);
					// } else {
					File filea = new File(Environment
							.getExternalStorageDirectory().getAbsolutePath(),
							"data/" + ctx.getPackageName());
					filea.mkdirs();

					if (filea.exists()) {
						r8.setText("Speak & Touch");
					} else {
						r8.setText("Touch");
					}
				}

				{

					{
						r8.setText("Something 2 know.\n\n\nThere is a search hotspot below.");

					}

					r8.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							tvhide.removeMessages(v.getId());
							tvhide.sendEmptyMessageDelayed(v.getId(), 75);
						}
					});

				}

				// tvhide.sendEmptyMessageDelayed(r8.getId(), 75);

				// Animation oh = AnimationUtils.loadAnimation(ctx,
				// R.anim.inleft);// oomx8
				// r8.startAnimation(oh);
				// pbn.addView(r8);

				// oh = null;
			}

			// pbn.bringChildToFront(sparkEasel);
			pbn.bringChildToFront(tips);
		}
	};

	Handler pbnImageRemove = new Handler() {
		public void handleMessage(Message msg) {

			Bundle hx = msg.getData();
			int id = hx.getInt("id", 0);
			int anim = hx.getInt("anim", 0);
			int direction = hx.getInt("direction", 0);
			long gofor = hx.getLong("gofor", 5200);

			ImageView i4 = (ImageView) findViewById(id);
			if (i4 != null) {
				Log.i("ok", "Image removal start " + id);
				AnimationSet o0;

				if (anim != 0) {
					o0 = (AnimationSet) AnimationUtils.loadAnimation(ctx, anim);
				} else {
					o0 = new AnimationSet(true);
					{
						Animation a8 = new TranslateAnimation(0, 0, 0, -200);
						a8.setFillAfter(true);
						a8.setDuration(5100);
						a8.setZAdjustment(Animation.ZORDER_BOTTOM);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						o0.addAnimation(a8);
					}

					{
						Animation a8 = new AlphaAnimation(1f, 0f);
						a8.setFillAfter(true);
						a8.setDuration(5100);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						o0.addAnimation(a8);
					}

				}

				o0.setDuration(gofor);
				i4.startAnimation(o0);
				pbnImageRemovey.sendEmptyMessageDelayed(id, gofor);

			}

		}
	};

	Handler pbnImageRemovey = new Handler() {
		public void handleMessage(Message msg) {

			ImageView i4 = (ImageView) findViewById(msg.what);
			if (i4 != null) {
				pbn.removeView(i4);
			}

		}
	};

	Handler pbnImageDim = new Handler() {
		public void handleMessage(Message msg) {
			ImageView i4 = (ImageView) findViewById(msg.what);
			if (i4 != null) {
				i4.setAlpha(150);
			}

		}
	};

	Handler tvhide = new Handler() {
		public void handleMessage(Message msg) {

			TextView ht = (TextView) findViewById(msg.what);

			if (ht != null) {
				if (ht.getVisibility() == View.VISIBLE) {
					// ht.setVisibility(View.VISIBLE);
					ht.setClickable(false);
					ht.setFocusable(false);
					tvhideb.sendEmptyMessageDelayed(msg.what, 25);
				} else {
					ht.setVisibility(View.VISIBLE);
					// tvhideb.sendEmptyMessageDelayed(msg.what, 8320);
				}
				edt.putLong("starr", System.currentTimeMillis());
				edt.commit();

			} else {
				Log.e("ok", "wha bbk " + msg.what);
			}

		}
	};

	Handler tvhideb = new Handler() {
		public void handleMessage(Message msg) {
			TextView ht = (TextView) findViewById(msg.what);
			uberpause.sendEmptyMessageDelayed(2, 75);

			if (ht != null) {
				Animation oh = AnimationUtils
						.loadAnimation(ctx, R.anim.offdown);// oomx8
				ht.startAnimation(oh);
				tvhidec.sendEmptyMessageDelayed(msg.what, oh.getDuration() - 10);

				oh = null;

			} else {
				Log.e("ok", "wha bbmb " + msg.what);
			}
		}
	};
	Handler tvhidec = new Handler() {
		public void handleMessage(Message msg) {
			TextView ht = (TextView) findViewById(msg.what);

			if (ht != null) {
				pbn.removeView(ht);
			} else {
				Log.e("ok", "wha bbm " + msg.what);
			}
		}
	};

	Path hbpathL;
	// int pwt = 1;
	// int pww = 1;
	int smx = 1;
	int smct = 1;
	int smat = 1;
	SharedPreferences reg;
	Editor edt;
	public Handler handleResume = new Handler() {
		public void handleMessage(Message msg) {

			if (!started) {
				resume = true;
				Log.i("ok", "99.9999                  handle Resume when ready");
				return;
			}
			Log.i("ok", "99.9999                  handle Resume");

			resume = false;
			upause = false;

			// pwt = 0;
			// pww = 0;
			// timber = "";
			// smx = 0;
			// smct = 0;
			// smat = 0;

			Display sd = getWindowManager().getDefaultDisplay();
			// sd.getOrientation();
			mwidth = sd.getWidth();
			mheight = sd.getHeight();
			sd = null;
			mmost = (mwidth > mheight ? mwidth : mheight);
			// viewLocation.sendEmptyMessageDelayed(-1, (1880 / 6) * 5);
			// dingoSparkInactive.sendEmptyMessageDelayed(2, (1880 / 6) * 6);

			try {
				pbn.setVisibility(View.VISIBLE);

				// if (mwidth > mheight) {
				// hiu.setMargins(0, 0, 0 + pbook.getWidth(), 0);
				// } else {// cols
				// hiu.setMargins(0, 0, 0, 0 + pbook.getHeight());
				// }

				// if (boomBoard.getVisibility() == View.INVISIBLE) {
				// boomBoard.setVisibility(View.VISIBLE);
				// Animation anhub4 = AnimationUtils.loadAnimation(ctx,
				// R.anim.oomx9);
				// boomBoard.startAnimation(anhub4);
				// }
				// nanoactive = false;

				// anhub4.setStartOffset(880);

				if (tips != null && tips.getVisibility() == View.INVISIBLE
						&& tipscs < System.currentTimeMillis()) {
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.oomx12);
					tips.setVisibility(View.VISIBLE);
					tips.startAnimation(a4);
					tipscs = System.currentTimeMillis() + a4.getDuration();
				}

				{
					reg = ctx.getSharedPreferences("Preferences",
							Context.MODE_WORLD_WRITEABLE);
					edt = reg.edit();
				}
				if (reg.getLong("keeplit", 1) > 1) {
					pbn.setKeepScreenOn(true);
				}

				reg.registerOnSharedPreferenceChangeListener(underDingo);
				recordService.sendEmptyMessageDelayed(2, 275);

				// sensorSurvey.sendEmptyMessageDelayed(2, 375);
				// gpslink.sendEmptyMessageDelayed(2, 475);
				smartSpark.sendEmptyMessageDelayed(2, 75);
				// searchSmart.sendEmptyMessageDelayed(32000, 15880);
				loadSpark.sendEmptyMessageDelayed(2, 575);

				smLead.sendEmptyMessageDelayed(2, 340);

			} catch (RuntimeException e2) {
				Log.i("ok", "audio onpause stop error " + e2.getMessage());
			}

		}
	};

	Handler smLead = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}// upause = true;

			/*
			 * 
			 * if (Swarm.isEnabled()) { if (msleads != null) { //
			 * msleads.getTopScores("", mca); if (cs <
			 * SystemClock.uptimeMillis()) { Log.i("ok",
			 * "REVVING REVVING REVVING"); cs = SystemClock.uptimeMillis() + 120
			 * * 1000;
			 * 
			 * msleads.getPageOfScores(1,
			 * SwarmLeaderboard.LEADERBOARD_DATE_TODAY,
			 * SwarmLeaderboard.LEADERBOARD_SCOPE_ALL, mcas);
			 * 
			 * Random c = new Random();
			 * msleads.submitScore(SystemClock.uptimeMillis()); }
			 * 
			 * } else { SwarmLeaderboard.getLeaderboardById(210, mca); } } else
			 * { Log.i("ok", "RACEWAYS CLOSED"); }
			 * 
			 * //
			 */
			smLead.sendEmptyMessageDelayed(2, 5000);

		}
	};

	Handler loadSpark = new Handler() {

		boolean first = true;

		public void handleMessage(Message msg) {

			if (reg.contains("active_choice")) {

				{
					Cursor bi = SqliteWrapper.query(
							ctx,
							getContentResolver(),
							Uri.parse("content://" + ctx.getPackageName()
									+ "/moment/"
									+ reg.getInt("active_choice", -1)),
							new String[] { "rowid", "hres" }, null, null, null);

					if (bi != null && bi.moveToFirst()) {
						for (int i = 0; i < bi.getCount(); i++) {
							bi.moveToPosition(i);
							if (bi.getString(1) != null) {

								Bundle nx = new Bundle();
								nx.putString("uri_data",
										"content://" + ctx.getPackageName()
												+ "/moment/" + bi.getInt(0));
								// xuri = Uri.parse(nx.getString("uri_data"));
								nx.putString("data", Uri.parse(bi.getString(1))
										.toString());

								nx.putFloat("scale", 2f);
								nx.putBoolean("lay", false);
								nx.putInt("left", (int) (30));
								nx.putInt("top", (int) (mheight / 2));

								// nx.putString("tool", "light");
								nx.putInt("drawable", R.drawable.dot);// .midres9r);//
																		// .silk9);//
																		// midres9o);
								Message m9 = new Message();
								m9.setData(nx);
								m9.what = -1;
								tabfy.sendMessageDelayed(m9, 175 + 375 * i);

							}
						}
					}

					if (bi != null) {
						bi.close();
					}
				}

			}

			if (first) {

				first = false;

				{

					Bundle nx = new Bundle();
					nx.putString("uri_data",
							"content://" + ctx.getPackageName() + "/moment");
					// xuri = Uri.parse(nx.getString("uri_data"));
					// nx.putString("data", Uri.parse(bi.getString(1))
					// .toString());
					// nx.putString("tool", "rows");
					nx.putInt("count", 2);

					nx.putFloat("scale", 1f);
					nx.putBoolean("lay", false);
					nx.putInt("left", (int) (mwidth / 2) - 60);
					nx.putInt("top", (int) 0);

					// nx.putString("tool", "light");
					nx.putInt("drawable", R.drawable.ic_menu_archive);
					Message m9 = new Message();
					m9.setData(nx);
					m9.what = -1;
					tabfy.sendMessageDelayed(m9, 175);

				}

				{
					Bundle nx = new Bundle();
					// nx.putString("uri_data", xu.toString());
					// nx.putString("data", Uri.fromFile(box).toString());
					nx.putString("tool", "recycle");
					nx.putInt("drawable", R.drawable.midres9g);
					nx.putBoolean("lay", true);
					nx.putInt("left", (int) (mwidth / 2));
					nx.putInt("top", 30);

					Message m9 = new Message();
					m9.setData(nx);
					m9.what = -1;
					// tabfy.sendMessageDelayed(m9, 375);
				}

				{
					Bundle nx = new Bundle();
					// nx.putString("uri_data", xu.toString());
					// nx.putString("data", Uri.fromFile(box).toString());
					nx.putString("tool", "house");
					nx.putInt("drawable", R.drawable.bhouse);// .panel_bg_holo_dark);
					nx.putFloat("scale", 0.7f);
					nx.putFloat("extend", 2f);
					nx.putString("uri_data",
							"content://" + ctx.getPackageName() + "/moment");

					nx.putInt("left", (int) (mwidth / 2) - 180);
					nx.putInt("top", (int) (mheight / 2 - 30));
					// nx.putBoolean("lay", false);
					// nx.putFloat("scale", 0.5f);
					// nx.putInt("left", 149);
					// nx.putInt("top", mheight - 309);
					Message m9 = new Message();
					m9.setData(nx);
					m9.what = -1;
					tabfy.sendMessageDelayed(m9, 25);
				}

				{
					Bundle nx = new Bundle();
					// nx.putString("uri_data", xu.toString());
					// nx.putString("data", Uri.fromFile(box).toString());
					nx.putString("prefboolean", "light");
					nx.putString("tool", "light");
					nx.putInt("left", (int) (mwidth / 2) + 80);
					nx.putInt("top", (int) (mheight / 2 - 30));
					nx.putInt("drawable", R.drawable.midres9g);
					Message m9 = new Message();
					m9.setData(nx);
					m9.what = -1;
					// tabfy.sendMessageDelayed(m9, 175);
				}

				{
					Cursor bi = SqliteWrapper.query(
							ctx,
							getContentResolver(),
							Uri.parse("content://" + ctx.getPackageName()
									+ "/moment"), new String[] { "rowid",
									"mres" }, null, null,
							"created desc limit 25");

					if (bi != null && bi.moveToFirst()) {
						for (int i = 0; i < bi.getCount(); i++) {
							bi.moveToPosition(i);
							if (bi.getString(1) != null) {

								Bundle nx = new Bundle();
								nx.putString("uri_data",
										"content://" + ctx.getPackageName()
												+ "/moment/" + bi.getInt(0));
								nx.putString("data", Uri.parse(bi.getString(1))
										.toString());
								// nx.putString("tool", "light");
								nx.putInt("drawable", R.drawable.dot);// gilk9);//
																		// midres9o);

								Message m9 = new Message();
								m9.setData(nx);
								m9.what = i;
								tabfy.sendMessageDelayed(m9, 575 + 375 * i);
							}

						}
					}

					if (bi != null) {
						bi.close();
					}

				}

			}

		}
	};

	Handler searchSmart = new Handler() {
		public void handleMessage(Message msg) {

			Cursor b9;
			b9 = ctx.getContentResolver().query(
					Uri.parse("content://" + ctx.getPackageName() + "/moment"),
					new String[] { "count(*)" }, "1=1", null, null);

			if (b9 != null && b9.moveToFirst() && b9.getInt(0) > 0) {

				Drawable ij = getResources().getDrawable(
						R.drawable.hires_search);
				// R.drawable.ic_menu_search_holo_dark);

				ImageView i9 = new ImageView(ctx);
				{
					RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
							-2, -2);

					if (smx == 0) {
						// t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
						// t2r.addRule(RelativeLayout.ALIGN_PARENT_CENTER, -1);

						int xb0 = (int) ((new Random().nextInt(mwidth)));
						int yb0 = (int) (mheight
								- (int) ((new Random()
										.nextInt((int) (mheight * 0.2f)))) - ij
								.getMinimumHeight());

						if (xb0 < ij.getMinimumWidth()) {
							xb0 = ij.getMinimumWidth();
						}
						if (xb0 > mwidth - ij.getMinimumWidth()) {
							xb0 = mwidth - ij.getMinimumWidth();
						} else if (xb0 > mwidth / 2 - 60
								&& xb0 < mwidth / 2 + 60) {
							xb0 = mwidth / 2;
							yb0 = mheight - ij.getMinimumHeight() - 30;
						}

						if (yb0 > mheight - ij.getMinimumHeight()
								|| yb0 < mheight - (mheight * 0.2f) + 8) {
							yb0 = (int) (mheight - (mheight * 0.2f) + 8);
						}

						t2r.setMargins(xb0, yb0 - ij.getMinimumHeight() / 2, 0,
								0);
					} else {
						t2r.setMargins(
								(int) (sm9[smat][0] - ij.getMinimumWidth() / 2)
										- ij.getMinimumWidth() / 2,
								(int) (sm8[smat][0] - ij.getMinimumHeight() / 2)
										- ij.getMinimumHeight() / 2, 0, 0);
					}
					i9.setLayoutParams(t2r);
				}

				while (findViewById(++hid) != null) {
				}
				i9.setId(hid);
				i9.setScaleType(ScaleType.MATRIX);
				i9.setImageDrawable(ij);
				pbn.addView(i9);

				// Animation oh = AnimationUtils.loadAnimation(ctx,
				// R.anim.searchhot);// oomx8
				// oh.setDuration(msg.what);
				// i9.startAnimation(oh);

				{
					Bundle bx9 = new Bundle();
					bx9.putInt("id", i9.getId());
					bx9.putInt("anim", R.anim.searchhot);
					bx9.putLong("gofor", msg.what);
					Message m9 = new Message();
					m9.setData(bx9);
					pbnImageRemove.sendMessageDelayed(m9, 325);
				}
				// tvhide.sendEmptyMessageDelayed(r8.getId(),
				// 32000);

			}
			if (b9 != null) {
				b9.close();
			}
		}
	};

	/*
	 * public Handler triDraw = new Handler() { public void
	 * handleMessage(Message msg) { triDraw.removeMessages(2); // &&
	 * smartservicecs2 < System.currentTimeMillis() - 800
	 * 
	 * if (smat == 1 && smx > 0) { smartservicecs2 = System.currentTimeMillis();
	 * markService.sendEmptyMessageDelayed(2, 275);
	 * triDraw.sendEmptyMessageDelayed(2, 2200);
	 * 
	 * } else if (!upause) { // if (smat > 2) {
	 * operationsPunctuation.removeMessages(2);
	 * scheduleOperation.sendEmptyMessageDelayed(ADURATION, 275); // }
	 * 
	 * triDraw.sendEmptyMessageDelayed(2, 1200); } else { Log.i("ok",
	 * "99.9999           triDraw service off"); }
	 * 
	 * } };//
	 */

	float[][] sm8 = new float[999 + 1][6];
	int[] smd = new int[999 + 1];
	int[] smki = new int[999 + 1];
	float[][] sm9 = new float[999 + 1][6];
	float[][] sm10 = new float[999 + 1][6];
	float[][] sm11 = new float[999 + 1][6];

	public OnTouchListener sparkBoardUI = new OnTouchListener() {
		// XXX
		// int ki = 1;

		// correct stellar job
		public boolean onTouch(View mv, MotionEvent mb) {

			// if (mb.getAction() == MotionEvent.ACTION_MOVE) {
			// mb.getHistorySize();
			smd[smct] = mb.getPointerCount();

			// if (smd[smct] >= smd.length) {
			// smd[smct] = smd.length - 1;
			// Log.i("ok", "on to " + mb.getPointerCount());
			// }

			if (smd[smct] < smd.length) {
				// if (mb.getPointerCount() < smd.length) {
				// smd[smct] = mb.getPointerCount();

				timber += "," + mb.getEventTime() + "";

				for (smki[smct] = 0; smki[smct] < smd[smct]; smki[smct]++) {
					sm9[smct][smki[smct]] = mb.getX(smki[smct]);
					sm8[smct][smki[smct]] = mb.getY(smki[smct]);
					sm10[smct][smki[smct]] = mb.getOrientation(smki[smct]);
					sm11[smct][smki[smct]] = mb.getPressure(smki[smct]);
					timber += "," + smki[smct] + " " + sm9[smct][smki[smct]]
							+ " " + sm8[smct][smki[smct]] + " " + " "
							+ mb.getOrientation(smki[smct]) + " "
							+ mb.getPressure(smki[smct]);
				}

				if (smct < 15 && mb.getAction() != MotionEvent.ACTION_MOVE) {
					sparkAction.sendEmptyMessageDelayed(mb.getAction(), 25);
					flipOperation.sendEmptyMessageDelayed(4, 375);
				}

				if (smct > 300) {// smct == 899 || smct == 950) {
					if (smat >= smct - 3 || smct > 650) {
						smat = 1;
						smct = 1;
						flashbon = 1;

						try {
							timber2 += timber;
							timber = "";
						} catch (OutOfMemoryError hs9) {
							Log.i("ok", "SUPER TIMBER!");
						}
					}
				}
				smct++;
				smx++;

				// if (mb.getHistorySize() == 0) {

				// } else {
				// MotionEvent.PointerCoords h9p = new
				// MotionEvent.PointerCoords();

				// for (int hk = 0; hk < mb.getHistorySize(); hk++) {
				// mb.getHistoricalPressure(hk);
				// mb.getHistoricalSize(hk);
				// timber += "," + mb.getHistoricalEventTime(hk) + "";

				// for (smki[smct] = 0; smki[smct] < smd[smct]; smki[smct]++) {
				// mb.getHistoricalPointerCoords(smki[smct], hk, h9p);
				// sm9[smct][smki[smct]] = h9p.x;
				// sm8[smct][smki[smct]] = h9p.y;
				// timber += "," + smki[smct] + " " + h9p.x + " "
				// + h9p.y + " " + h9p.orientation + " "
				// + h9p.pressure;
				// }
				// smct++;
				// smx++;
				// }
				// }
				// if (smct < 50) {

				// smct =

				// }
			} else {

				return false;
			}

			return true;
		}
	};
	String timber2 = "";
	// int smmc = 1;
	// int smnt = 1;
	// int sny = 1;
	// int snx = 1;
	// int nxx = 1;
	// int xc = 1;
	// long hugiscs = 1;
	// int kix = 1;

	// if (action != MotionEvent.ACTION_CANCEL) {
	// xc = ;
	// if (xc != MotionEvent.ACTION_UP) {
	// if (mb.getPointerCount() < 9) {

	// } else {
	// Log.i("ok", "on to " + mb.getPointerCount());
	// }
	// smmc++;
	// }

	// for (smnt = 0; smnt < smct; smnt++) {
	// sm8[smnt][0] - ((mheight - 30) / 8) * 3;
	// }

	// scrollBy

	// if (smd[smct - 1] == 1)

	// if (kix != smd[smct]) {
	// kix = smd[smct];

	// // sparkMachine.sendEmptyMessageDelayed(2, 75);

	// }
	// smartSparkService.sendEmptyMessageDelayed(5, 175);

	// markService.sendEmptyMessageDelayed(2, 375);
	/*
	 * productiondash.postInvalidate(); if (smct > sm8.length - (sm8.length /
	 * 5)) { pww = 1; pwt = 1; smct = 1; smat = 1; } //
	 */

	// kix = 1;

	// if (smmc >= 11) {
	// markService.sendEmptyMessageDelayed(2, 275);

	// smmc = 1;
	// scheduleOperation.removeMessages(ADURATION);
	// scheduleOperation.sendEmptyMessageDelayed(ADURATION,
	// 1880);

	// markService.sendEmptyMessageDelayed(2, 175);
	// smartSparkService.sendEmptyMessageDelayed(5, 175);

	// operationsPunctuation.removeMessages(2);
	// smartSparkService.removeMessages(5);
	// smartSparkService.sendEmptyMessageDelayed(5, 175);
	// }

	int ADURATION = 1880 * 2;

	private OnSharedPreferenceChangeListener underDingo = new OnSharedPreferenceChangeListener() {

		public void onSharedPreferenceChanged(SharedPreferences c, String b) {
			Log.i("ok", "99.9999                 Preferences Awareness " + b
					+ " " + upause);
			if (upause) {
				reg.unregisterOnSharedPreferenceChangeListener(underDingo);
				return;
			}

			// if (b.contentEquals("anetwork")) {
			// networkOn.sendEmptyMessageDelayed((int) c.getLong(b, 2), 100);
			// } else if (b.contentEquals("lat")
			// && xmmi.getVisibility() == View.INVISIBLE) {
			// } else {

			// }

		}
	};

	Bitmap gppd5x = null;
	Bitmap gppd5 = null;
	Bitmap gpd, gpdx;
	Canvas gxf, gxfx;
	Bitmap g4d;
	Canvas g4f;
	android.graphics.Paint gp, gpf;
	android.graphics.Paint gppx;
	ImageView productiondash, surfacedash;
	ImageView fildash;
	String timber = "";
	public Handler smartSpark = new Handler() {
		// Bitmap h1 = null;
		// Bitmap xt2 = null;
		// long cs = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok",
					"\n=                         =\n=                         =\n=                         =\n=                         =\n=                         =\n=                         =\n=                         =\n=                         =\n99.9999                  establish sparkMark board "
							+ msg.what
							+ " ===================================\n=\n=\n=\n=                         =");

			smartSpark.removeMessages(2);
			try {// smartSpark.send dhd =

				gppd5 = null;
				gppd5x = null;

				RelativeLayout.LayoutParams dhdx;
				// ImageView hj = null;

				// pwt = 0;
				// pww = 0;
				timber = "";
				timber2 = "";
				smx = 0;
				smct = 0;
				smat = 0;
				flashbon = 0;

				if (gpd == null) {
					gpd = Bitmap.createBitmap(mwidth, mheight,
							Bitmap.Config.ARGB_8888);
					gxf = new Canvas(gpd);
					g4d = Bitmap
							.createBitmap((int) (mwidth * scalem + (mwidth
									* scalem * 0.2f)), (int) (mheight * scalem
									+ (mheight * scalem) / 2 + (mheight
									* scalem * 0.1f)), Bitmap.Config.ARGB_8888);
					g4f = new Canvas(g4d);

					gp = new android.graphics.Paint();
					gp.setAlpha(40);
					gpf = new android.graphics.Paint();
					gpf.setAlpha(120);
					g4f.skew(0.2f, -0.1f);

					// bla[
				} else {
					gxf.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
				}

				if (gpdx == null) {
					gpdx = Bitmap.createBitmap(mwidth, mheight,
							Bitmap.Config.ARGB_8888);
					gxfx = new Canvas(gpdx);
					gppx = new android.graphics.Paint();
					gppx.setColor(Color.argb(100, 10, 20, 55));
					gppx.setStrokeWidth(1f);
				} else {
					gxfx.drawColor(Color.argb(2, 2, 2, 2),
							PorterDuff.Mode.CLEAR);
				}

				if (fildash == null) {
					fildash = new ImageView(ctx);
					dhdx = new RelativeLayout.LayoutParams(-2, -2);
					// dhdx.setMargins(30, 30, 0, 0);
					// fildash.setBackgroundColor(Color.argb(120, 3, 10, 93));

					dhdx.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
					fildash.setLayoutParams(dhdx);
					dhdx = null;
					hid = (int) (System.currentTimeMillis() / 999);
					while (findViewById(++hid) != null) {
					}
					fildash.setId(hid);

					// fildash.setBackgroundResource(R.drawable.colorbk);
					fildash.setBackgroundResource(R.drawable.cloud5);
					fildash.setScaleType(ScaleType.FIT_CENTER);

					// Animation
					// boomBoard

					pbn.addView(fildash);
					// if (tips != null && tips.getVisibility() ==
					// View.INVISIBLE
					// && tipscs < System.currentTimeMillis()) {
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.cloudin);

					a4.setDuration(880);

					// fildash.setVisibility(View.VISIBLE);
					fildash.startAnimation(a4);
					// tipscs = System.currentTimeMillis() + a4.getDuration();
					// }
				} else {
					// fildash.postInvalidate();
					// g4f.drawColor(Color.argb(2, 2, 2, 2),
					// PorterDuff.Mode.CLEAR);
				}
				// nano8.9.png
				fildash.setImageBitmap(g4d);

				{
					productiondash = new ImageView(ctx);

					hid = (int) (System.currentTimeMillis() / 999);
					while (findViewById(++hid) != null) {
					}// productiondash.getId(
					productiondash.setId(hid);
					dhdx = new RelativeLayout.LayoutParams(-1, -1);
					productiondash.setLayoutParams(dhdx);
					dhdx = null;

					productiondash.setScaleType(ScaleType.MATRIX);
					sparkEasel.addView(productiondash);
				}
				productiondash.setImageBitmap(gpd);

				{
					surfacedash = new ImageView(ctx);
					dhdx = new RelativeLayout.LayoutParams(-1, -1);
					surfacedash.setLayoutParams(dhdx);
					dhdx = null;
					while (findViewById(++hid) != null) {
					}
					surfacedash.setId(hid);
					surfacedash.setScaleType(ScaleType.MATRIX);
					surfacedash.setVisibility(View.INVISIBLE);
					sparkEasel.addView(surfacedash, 0);
				}
				surfacedash.setImageBitmap(gpdx);

				// sparksurface.sendEmptyMessageDelayed(2, 2);
				// smartSpark.send xmct = 0

			} catch (NullPointerException em) {
				em.printStackTrace();

			} catch (OutOfMemoryError em) {
				// gpd = null;
				// gxf = null;
				Log.w("ok", "OOM wha " + em.getMessage());
				return;
				// em.printStackTrace();
			} finally {

			}

		}
	};
	Uri xuri;
	Bundle b88;
	Message m88;
	public Handler scheduleOperation = new Handler() {
		public void handleMessage(Message msg) {
			scheduleOperation.removeMessages(msg.what);
			// operationsPunctuation.removeMessages(2);
			// recordService.removeMessages(2);

			if (smx > 25 && xuri == null && actwin < System.currentTimeMillis()) {
				actwin = System.currentTimeMillis() + ADURATION;
				// stocking awareness
				Log.i("ok", "stocking filling UUUUUUUUUUUUUUU " + msg.what);
				// {
				// Animation oh = AnimationUtils
				// .loadAnimation(ctx, R.anim.oom);
				// ipb.startAnimation(oh);
				// ipbcs = System.currentTimeMillis() + oh.getDuration();
				// oh = null;
				// }

				ContentValues cx = new ContentValues();

				// d1
				// String dn = "Boom";

				if (!cx.containsKey("atitle")) {

					// dn.length() > 0 ? Uri.encode(dn)
					// : file.exists() ? dn : dn);

					String dn = reg.getString("defactoprefacto", myDay());
					int dnc = (reg.getInt("numerofactodefacto" + dn, 0) + 1);
					edt.putInt("numerofactodefacto" + dn, dnc);
					cx.put("atitle", dn + "." + +dnc);
					// cx.put(SearchManager.SUGGEST_COLUMN_TEXT_1, dn + "." +
					// +dnc);

					dn = null;
				}

				// cx.put("_id", null);
				// boxerhug.setText(reg.getString("geostory", "comment"));
				xuri = SqliteWrapper.insert(
						ctx,
						ctx.getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/moment"), cx);

				cx = null;

				edt.putString("row", xuri.toString());
				try {
					edt.commit();
				} catch (OutOfMemoryError sf) {
					Log.w("ok", "wha bb");
				}

				b88 = new Bundle();
				b88.putString("row", xuri.toString());
				b88.putInt("duration", 1880);
				m88 = new Message();
				m88.setData(b88);
				m88.what = 2;
			}

			// && xuri != null
			if (xuri != null && b88 != null) {
				Log.i("ok",
						"99.9999            ((((((()))))))         stocking awareness "
								+ (actwin - System.currentTimeMillis() - (msg.what)));

				m88 = new Message();
				m88.setData(b88);
				m88.what = 2;
				// scheduleOperation.removeMessages(msg.what);
				operationsPunctuation.removeMessages(2);
				pssoff.removeMessages(2);

				// flipOperation.sendEmptyMessageDelayed(2, 75);

				operationsPunctuation.sendMessageDelayed(m88, msg.what);
				actwin = System.currentTimeMillis() + msg.what + 100;// ADURATION
				// fildash.postInvalidate();
				// productiondash.postInvalidate();
				// surfacedash.postInvalidate();
				if (pss != null) {
					// if (psscs > System.currentTimeMillis()) {
					pssi.clearAnimation();
					// }
					// duration
					pssProg.sendEmptyMessageDelayed(2, 250);

					// Animation oh = AnimationUtils.loadAnimation(ctx,
					// R.anim.progon);// oomx8
					// oh.setDuration(ADURATION + b88.getInt("duration"));
					// oh.setStartOffset(1880);

					if (pss.getVisibility() == View.INVISIBLE) {
						pss.setVisibility(View.VISIBLE);
						Animation ohb = AnimationUtils.loadAnimation(ctx,
								R.anim.psson);
						pss.startAnimation(ohb);
						// pbn.bringChildToFront(pss);
					}
					// pbn.bringChildToFront(sparkEasel);
					pbn.bringChildToFront(tips);

					// pssi.startAnimation(oh);
					psscs = System.currentTimeMillis() + ADURATION
							+ b88.getInt("duration") - 40;
					pssoff.sendEmptyMessageAtTime(2, psscs + 10);
					// .progress_bg_holo_dark);//
					// .onair);
					// oh = null;

				}

			}

		}
	};
	long psscs = 1;

	// long smartservicecs2 = 1;

	void choiceMove(int left, int top) {
		Message ml = new Message();
		Bundle bl = new Bundle();
		// bl.putInt("tabfy_pc", tabfy_pc);
		bl.putInt("left", (int) left);
		bl.putInt("top", (int) top);
		ml.setData(bl);
		choiceMove.sendMessageDelayed(ml, 25);
	}

	Handler choiceMove = new Handler() {
		ImageView markMm;
		RelativeLayout.LayoutParams markMr = null;
		int markMi = -1;

		// Bundle hx = null;

		public void handleMessage(Message msg) {
			if (ones < 0 || pb[ones] == null) {
				return;
			}
			Bundle hx = msg.getData();

			markMm = (ImageView) findViewById(pb[ones].getInt("tabfy"));
			markMi = ones;
			markMr = (RelativeLayout.LayoutParams) markMm.getLayoutParams();

			if (markMi != ones || markMm == null) {
				markMm = (ImageView) findViewById(pb[ones].getInt("tabfy"));
				markMi = ones;
				markMr = (RelativeLayout.LayoutParams) markMm.getLayoutParams();
			}

			if (markMm != null) {
				pb[ones].putInt("touchx", hx.getInt("left"));
				pb[ones].putInt("touchy", hx.getInt("top"));
				markMr.setMargins(hx.getInt("left"), hx.getInt("top"), 0, 0);
				markMm.setLayoutParams(markMr);
			}

			choiceLit(ones);

		}
	};

	int smww = 1;
	public Handler markService = new Handler() {
		// int b = 1;
		// int ki = 1;
		// double xuu = 0;
		// long buics = 1;
		// long bnics = 1;
		// int pxx = 1;
		// int pyy = 1;
		// int mxx = 1;
		int sh9 = 1;
		int si9 = 1;

		public void handleMessage(Message msg) {

			// Log.i("ok", "99.9999                  markService " + smat + ">/"
			// + lsmat);
			if (smx == 0) {
				// b = 1;
				// pww = 0;
				Log.i("ok", "99.9999               Smart Mark Drawing Cleared "
						+ msg.what + " (" + tapcn + " " + ")");

				pssoff.removeMessages(2);
				pssoff.sendEmptyMessageDelayed(2, 275);
				markService.removeMessages(msg.what);

				// smartSparkService.removeMessages(5);
				// SERVICE
				return;
			}

			if (smat == 0) {
				gpf.setAlpha(150);
				g4f.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
				indr = true;
				if (choiceScan(smat)) {
					indr = false;
				}

			} else if (smct < 5) {// && smat > smct - 2) {

				return;
			}

			int mxx = 0;

			// Boom Boom
			try {

				// if (smww > smct - 4) {// manage to allow ballson
				// increment but
				// no tap image
				// return;
				// }// gp =
				// if (smat == 0) {

				// }

				// Boom Boom

				if (indr && smct < 25) {
					if (choiceScan(smat)) {
						indr = false;
					}
				}

				if (!indr) {
					// smx < 25 && smat < 15 &&

					if (ones > -1 && pb[ones] != null) {
						lones = -2;
						choiceClear.removeMessages(2);

						// && pb[ones].getLong("selected", 1) > System
						// .currentTimeMillis() - 3288) {

						// pb[ones].putLong("selected",
						// System.currentTimeMillis());
						// mxx = 21;
						// smat = smct - 1

						if (smat == 0) {

							{
								Message ml = new Message();
								Bundle bl = new Bundle();
								bl.putInt("tabfy_pc", ones);
								ml.setData(bl);
								ml.what = 2;
								// choiceLit.sendMessageDelayed(ml, 75);
							}

							pb[ones].putFloat("scale", 1f);

							if (pb[ones].getInt("left", -2) == -2) {
								pb[ones].putBoolean("lay", true);
							} else {
								// pb[ones].putBoolean("lay", false);
								// pb[ones].getBoolean("lay", false)
							}
							pb[ones].putInt("left", pb[ones].getInt("touchx"));
							{
								Message m0 = new Message();
								Bundle h6 = new Bundle(pb[ones]);
								m0.setData(h6);
								m0.what = h6.getInt("tabfy");
								tabfy.sendMessageDelayed(m0, 175);
							}
						}

						for (; smat < smct; smat++) {
							// for (smki[smat] = 0; smki[smat] < smd[smat];
							// smki[smat]++) {

							{
								Message ml = new Message();
								Bundle bl = new Bundle();
								// bl.putInt("tabfy_pc", tabfy_pc);
								bl.putInt("left",
										(int) (sm9[smat][0] - pb[ones].getInt(
												"bwidth", 45) / 2));
								bl.putInt("top", (int) (sm8[smat][0] - pb[ones]
										.getInt("bheight", 45) / 2));
								ml.setData(bl);
								choiceMove.sendMessageDelayed(ml,
										25 + 8 * (smat));
							}

							mxx++;

							// markMm.setLayoutParams(markMr);

							// }
						}

						{
							Message ml = new Message();
							Bundle bl = new Bundle();
							bl.putInt("tabfy_pc", ones);
							ml.setData(bl);
							ml.what = 2;
							// choiceLit.sendMessageDelayed(ml, 75);
						}
					}

				} else {

					for (; smat < smct; smat++) {
						for (smki[smat] = 0; smki[smat] < smd[smat]; smki[smat]++) {
							// if (sm8[smat][ki] > ((mheight - 30) / 8) * 3) {
							// int sy = (int) (((sm8[smat][ki] - ((mheight - 30)
							// /
							// 8) * 3) - 60) / supert9h);
							// int snx = (int) ((sm9[smat][ki] - 15) /
							// supert9w);
							// Log.i("ok", "translate press " + snx + "," + sy
							// + " " + ((snx + 1) * (sy + 1)) + "");
							//
							// tapcn = 1;
							// continue;
							// }

							// balls[ballson].drawBitmap(blm[ki],
							// (int) (sm9[smat][ki] / 4 - dw / 4 / 2),
							// (int) (sm8[smat][ki] / 4 - dh / 4 / 2), gp);
							// if (sm9[smat][ki] > mwidth - bla[ki].getWidth() /
							// 2)
							// {
							// sm9[smat][ki] = mwidth - bla[ki].getWidth() / 2;
							// } else if (sm9[smat][ki] < bla[ki].getWidth() /
							// 2) {
							// sm9[smat][ki] = bla[ki].getWidth() / 2;
							// }

							// if (sm8[smat][ki] > mheight -
							// bla[ki].getHeight()) {
							// sm8[smat][ki] = mheight - bla[ki].getHeight();
							// } else if (sm8[smat][ki] < bla[ki].getHeight() /
							// 2) {
							// sm8[smat][ki] = bla[ki].getHeight() / 2;
							// }
							// if (smat < 100) {
							// gpf.setAlpha(50 + smat * 2);
							// }

							gxf.drawBitmap(bla[smki[smat]],
									(int) (sm9[smat][smki[smat]] - dw / 2),
									(int) (sm8[smat][smki[smat]] - dh / 2), gpf);

							// si9 = (int) (dw * scalem + sm9[smat][ki]
							// * (scalem * 0.6f) - dw * scalem / 2);

							si9 = (int) (dw * scalem + sm9[smat][smki[smat]]
									* (scalem * 0.6f) - dw * scalem / 2);

							// (int) (dh * scalem + sm8[smat][ki]
							// * (scalem * 1.5) - dh * scalem / 2)
							// fildash.postInvalidate(si9 - 40, sh9 - 40, si9 +
							// 40,
							// sh9 + 40);

							if (sm8[smat][smki[smat]] > mheight * 0.1f) {
								// gpf =
								sh9 = (int) (dh * scalem
										- sm8[smat][smki[smat]]
										* (scalem * 0.6f) - dh * scalem / 2);

								// if (sh9 > 140) {
								// consider scalem setting
								// Log.i("ok", "set alpha " + sh9 + " ");// -10
								// -110,
								// -138
								// -222

								if (sh9 <= 0 && sh9 > -250) {

									gp.setAlpha((int) (sh9 / -2));
								} else {
									gp.setAlpha(0);
								}

								// int jji = (int) (dw * scalem
								// + sm9[smat][ki] * (scalem * 1.5) - dw
								// * scalem / 2);
								// g4f =
								g4f.drawBitmap(
										blm[smki[smat]],
										si9,
										(int) ((mheight * scalem * 0.5f)
												+ (mheight * scalem) / 2 + sh9 * 0.8f),
										gp);

								// fildash.postInvalidate(si9 - dw,
								// (int) ((mheight * scalem) + sh9) - dh, si9
								// + dw,
								// (int) ((mheight * scalem) + sh9) + dh);

								// }
								// }

								// }

								// fildash =
							}

							sh9 = (int) (dh * scalem + sm8[smat][smki[smat]]
									* (scalem * 0.6f) - dh * scalem / 2);
							g4f.drawBitmap(blm[smki[smat]], si9, sh9, gpf);

							mxx++;
							// smx = 0
							// gxfx.drawPoint(sm9[smat][ki], sm8[smat][ki],
							// gppb[ki]);
							// if (smat > 15 && smat < smct - 3) {
							// gxfx.drawLine((sm9[smat - 1][ki]),
							// (int) (sm8[smat - 1][ki]), (sm9[smat][ki]),
							// (int) (sm8[smat][ki]), gppx);
							// }

						}

						// oalls0x[ballson][smat] = sm9[smat];
						// oalls0y[ballson][smat] = sm8[smat];
						// oalls0d[ballson][smat] = smd[smat];
					}

					// over

					// falls[ballson] = System.currentTimeMillis();
					// if (smct > sm8.length - 30) {
					// pww = 1;
					// pwt = 1;
					// }

					// if (smct > smat) {
					// }
				}

			} catch (RuntimeException eb) {
				Log.i("ok",
						"(recycled bla during stocking stuffing) "
								+ eb.getMessage());
			}

			// upause
			// cb++;
			// if (cb < 15) {
			// markService.sendEmptyMessageDelayed(2, 50);
			// } else {
			// cb = 1;
			if (mxx > 10) {

				markService.sendEmptyMessageDelayed(2, 175);
				return;
			}

			if (mxx > 6) {

				markService.sendEmptyMessageDelayed(2, 275);
				// flashB.sendEmptyMessageDelayed(flashbon, 350);
				// flashbon = smat;

				return;
			}
			markService.removeMessages(2);

			if (mxx >= 3) {
				markService.sendEmptyMessageDelayed(2, 875);
				flashB.sendEmptyMessageDelayed(flashbon, 350);
				flashbon = smat;

				return;
			}

			if ((mxx == 0 || smd[smat] > 1)) {// smd[smat] > 1 ||
				// || smct - 3 > smat

				flipOperation.sendEmptyMessageDelayed(2, 275);

				markService.sendEmptyMessageDelayed(2, 4889);
				// } else if (mxx <= 2) {
				// markService.sendEmptyMessageDelayed(2, 575);
				flashB.sendEmptyMessageDelayed(flashbon, 650);
				flashbon = smat;

			} else {
				markService.sendEmptyMessageDelayed(2, 875);
				flashB.sendEmptyMessageDelayed(flashbon, 650);

			}

		}

		// int cb = 1;
	};
	int flashbon = 1;

	Handler flashB = new Handler() {
		int lsmat = 1;
		int ccn = 1;

		float xlow = 1f;
		float xhigh = 1f;
		float ylow = 1f;
		float yhigh = 1f;
		// int smat = 1;
		int ki = 1;
		int b = 1;

		int myat = 1;

		public void handleMessage(Message msg) {

			flashB.removeMessages(msg.what);
			b++;
			flipSMCT.sendEmptyMessageDelayed(2, 250);
			flipOperation.sendEmptyMessageDelayed(7, 350);

			float xlow = 1f;
			float xhigh = 1f;
			float ylow = 1f;
			float yhigh = 1f;
			int smat = myat;
			if (smat > smct) {
				smat = 1;
			}

			{
				for (; smat < smct; smat++) {
					for (ki = 0; ki < smd[smat]; ki++) {

						if (sm9[smat][ki] < xlow || xlow == 1f) {
							xlow = sm9[smat][ki];
						}
						if (sm9[smat][ki] > xhigh
								&& (xlow != 1f || xhigh == 1f)) {
							xhigh = sm9[smat][ki];
						}
						if (sm8[smat][ki] < ylow || ylow == 1f) {
							ylow = sm8[smat][ki];
						}
						if (sm8[smat][ki] > yhigh
								&& (ylow != 1f || yhigh == 1f)) {
							yhigh = sm8[smat][ki];
						}
					}
				}
			}

			if (productiondash != null) {
				// productiondash.postInvalidateDelayed((int) xhigh - (dw / 2),
				// (int) yhigh - (dh / 2), (int) xlow + (dw / 2),
				// (int) ylow + (dh / 2), 75);

				if (yhigh - ylow > mheight / 2 || (xhigh - xlow > mwidth / 2)) {
					productiondash.postInvalidate();
				} else {
					// Log.i("ok", "Flash " + msg.what + "(" + smat + ") / " +
					// smct
					// + ": refresh drawing area (" + xlow + "," + ylow
					// + ") to (" + xhigh + "," + yhigh + ")");

					productiondash.postInvalidate((int) xlow - (dw), (int) ylow
							- (dh), (int) xhigh + (dw), (int) yhigh + (dh));
				} // sparkBoard
					// productiondash.postInvalidateDelayed((int) xlow - (dw),
					// (int) yhigh - (dh), (int) xhigh + (dw), (int) ylow
					// + (dh), 675);

			}
			// fildash.postInvalidate((int) (dw/4 + xlow / 6) - (dw / 4),
			// (int) (ylow / 6) - (dh / 4) , (int) (xhigh / 6) + (dw / 4),
			// (int) (yhigh / 6) + (dh / 4));

			// }
			if (fildash != null) {
				fildash.postInvalidate((int) (xlow / 4) - (dw),
						(int) (ylow / 4) - dh, (int) (xhigh / 4) + (dw),
						(int) (yhigh / 4) + (dh));
			}

			if (b == 2) {// ||
				flipOperation.sendEmptyMessageDelayed(2, 75);
				b = 1;
			}

		}
	};

	float scalem = 0.25f;
	Handler flipSMCT = new Handler() {
		public void handleMessage(Message msg) {
			flipSMCT.removeMessages(2);

			if (smct > 890 || (smct == smat && flashbon == smat)) {
				Log.i("ok", "rotate smct ");
				smat = 1;
				smct = 1;
				flashbon = 1;
				// } else {
				// flashbon = smat;
			}

		}
	};

	Handler flipOperation = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			flipOperation.removeMessages(msg.what);
			flipSMCT.sendEmptyMessageDelayed(2, 250);
			if (cs > SystemClock.uptimeMillis()) {
				return;
			}

			cs = SystemClock.uptimeMillis() + ADURATION / 16;
			Log.i("ok", "Flip Operation " + msg.what);
			operationsPunctuation.removeMessages(2);

			if (xuri == null) {
				scheduleOperation.removeMessages(ADURATION);
				scheduleOperation.sendEmptyMessageDelayed(ADURATION,
						ADURATION * 2);
				// if (fildash != null) {
				// fildash.postInvalidate();
				// }
			} else {

				scheduleOperation.removeMessages(ADURATION);
				scheduleOperation.sendEmptyMessageDelayed(ADURATION, ADURATION
						* tapcn);
			}
			// tapClear
		}
	};

	private Handler sparkAction = new Handler() {

		public void handleMessage(Message msg) {
			int action = msg.what;

			if (action == MotionEvent.ACTION_DOWN) {
				// hideLocation.removeMessages(2);
				// operationsPunctuation.removeMessages(2);
				sparkBoardOn.sendEmptyMessageDelayed(3, 10);
			} else if (action == MotionEvent.ACTION_UP) {
				// hideLocation.removeMessages(2);
				// operationsPunctuation.removeMessages(2);
				sparkBoardUp.sendEmptyMessageDelayed(4, 10);
				// } else if (action == MotionEvent.ACTION_POINTER_2_DOWN) {
				// } else if (action == MotionEvent.ACTION_POINTER_2_UP) {
				// } else if (action == MotionEvent.ACTION_POINTER_1_DOWN) {
				// } else if (action == MotionEvent.ACTION_POINTER_1_UP) {
				// } else if (action == MotionEvent.ACTION_POINTER_3_DOWN) {
				// } else if (action == MotionEvent.ACTION_POINTER_3_UP) {
			}

		}
	};
	boolean indr = false;

	private Handler sparkBoardOn = new Handler() {
		long cb = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                            SMART ON "
					+ msg.what);
			smww = smct > 0 ? smct - 1 : 0;
			// pww = smat;
			// pwt = smat;

			if (smat == 0) {

				// indr = false;
				Log.i("ok",
						"99.9999                          first down _________vvvvvvv******===== "
								+ tapcn + " ");

				// smartservicecs2 = System.currentTimeMillis();
				// recordService.sendEmptyMessageDelayed(2, 70);
				// smartSparkService.sendEmptyMessageDelayed(5, 2);
				// operationsPunctuation.removeMessages(2);
				// smartSparkService.sendEmptyMessageDelayed(5, 75);
				// sparkAction.sendEmptyMessageDelayed(mb.getAction(), 75);

				// if (fildash != null) {
				// fildash.postInvalidate();
				// }
			}

			{
				// if (!indr) {
				// if (choiceScan(smat)) {
				// indr = false;
				// } else {
				// indr = true;
				// markService.sendEmptyMessageDelayed(2, 75);
				// }

				// } else {

				flipOperation.sendEmptyMessageDelayed(2, 275);
				// operationsPunctuation.removeMessages(2);

				// if (xuri == null) {
				// }
				// scheduleOperation.removeMessages(ADURATION);
				// scheduleOperation.sendEmptyMessageDelayed(ADURATION,
				// xuri != null ? 275 : 1875);
				markService.sendEmptyMessageDelayed(2, 75);

			}
			// if (smx < 15) {
			// scanChoice.sendEmptyMessageDelayed(smat, 25);
			// markService.sendEmptyMessageDelayed(2, 25);

			// if (viewapp_map) {
			// hideLocation.removeMessages(2);
			// hideLocation.sendEmptyMessageDelayed(2, 1880 * 2);
			// }

			// dingoSparkInactive.sendEmptyMessageDelayed(2, 1880);

		}

	};

	boolean pick = false;
	int ones = -2;
	int twos = -1;
	int bqq = 2;

	void choiceLit(int ones) {
		Message ml = new Message();
		Bundle bl = new Bundle();
		bl.putInt("tabfy_pc", ones);
		ml.setData(bl);
		choiceLit.sendMessageDelayed(ml, 75 + 300 * bqq++);

		// bl.putInt("left", (int) left);
		// bl.putInt("top", (int) top);
	}

	ImageView chos = null;
	Canvas cb8 = null;
	int rones = -1;

	Handler choiceLit = new Handler() {
		RelativeLayout.LayoutParams rhos = null;
		// Bundle hx = null;
		Random ps = new Random();
		android.graphics.Paint pa8 = null;
		long cs = 1;

		public void handleMessage(Message msg) {
			// removeMesages(msg.what);
			Bundle hx = msg.getData();
			bqq = 2;

			if (pb[hx.getInt("tabfy_pc")] == null) {
				return;
			}
			if (cs > SystemClock.uptimeMillis()) {
				return;
			}
			cs = SystemClock.uptimeMillis() + 680;

			if (chos == null) {

				chos = new ImageView(ctx);
				while (findViewById(++hid) != null) {
				}
				chos.setId(hid);

				Bitmap hb8 = Bitmap.createBitmap(160, 160,
						Bitmap.Config.ARGB_8888);
				cb8 = new Canvas(hb8);
				chos.setScaleType(ScaleType.FIT_XY);
				chos.setAdjustViewBounds(true);
				chos.setImageBitmap(hb8);
				pa8 = new android.graphics.Paint();

				// hb8.recycle();

				pbn.addView(chos);
			} else {
				//
				// drawslice
				cb8.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);

			}
			chos.setVisibility(View.VISIBLE);

			pa8.setColor(my9a[ps.nextInt(9)]);
			pa8.setStrokeWidth(13f + (reg.getFloat("pressure_standard", 43f) * sm11[smat][0]));

			if (scanBumpee(ones)) {
				Log.i("ok", "########>>>>>>>>>>  POST MOVE BUMP HAPPENED with "
						+ ones);
				pa8.setStyle(Style.FILL_AND_STROKE);
			} else {
				pa8.setStyle(Style.STROKE);
			}
			// skew
			// cb8.skew(0f, 0f);

			// if (hx.getBoolean("lay", false)) {
			// cb8.skew(1f, -0.4f);
			// } else if (hx.containsKey("left")) {
			// } else {
			// cb8.skew(0.0f, -0.4f);
			// }

			cb8.drawCircle(80, 80, 65, pa8);
			// sm8[smct]
			if (rones == ones) {
				rhos = new RelativeLayout.LayoutParams(160, 160);
			} else {
				rones = ones;
				rhos = (RelativeLayout.LayoutParams) chos.getLayoutParams();
			}

			if (pb[hx.getInt("tabfy_pc")].getBoolean("lay", false)) {

				rhos.setMargins((int) (pb[hx.getInt("tabfy_pc")].getInt(
						"touchx", 48) + pb[hx.getInt("tabfy_pc")].getInt(
						"bwidth", 90) / 2) - 80, (int) (pb[hx
						.getInt("tabfy_pc")].getInt("touchy", 48) + pb[hx
						.getInt("tabfy_pc")].getInt("bheight", 90) / 2) - 80,
						0, 0);
			} else if (pb[hx.getInt("tabfy_pc")].containsKey("left")
					&& !pb[hx.getInt("tabfy_pc")].getBoolean("lay", false)) {

				rhos.setMargins((int) (pb[hx.getInt("tabfy_pc")].getInt(
						"touchx", 48) + pb[hx.getInt("tabfy_pc")].getInt(
						"bwidth", 90) / 2) + 80, (int) (pb[hx
						.getInt("tabfy_pc")].getInt("touchy", 48) + pb[hx
						.getInt("tabfy_pc")].getInt("bheight", 90) / 2) - 80,
						0, 0);

			} else {

				rhos.setMargins((int) (pb[hx.getInt("tabfy_pc")].getInt(
						"touchx", 48) + pb[hx.getInt("tabfy_pc")].getInt(
						"bwidth", 90) / 2) + 80, (int) (pb[hx
						.getInt("tabfy_pc")].getInt("touchy", 48) + pb[hx
						.getInt("tabfy_pc")].getInt("bheight", 90) / 2) - 80,
						0, 0);
			}
			chos.setLayoutParams(rhos);
			// chos.setBackgroundColor(my9a[ps.nextInt(9)]);

			lones = -2;
			choiceClear.removeMessages(2);
			choiceClear.sendEmptyMessageDelayed(2, 280);

		}
	};

	int lones = -1;

	Handler choiceClear = new Handler() {

		public void handleMessage(Message msg) {
			if (msg.what == 3) {

				chos.setVisibility(View.INVISIBLE);
				// chos.clearAnimation();
				return;
			}
			if (ones < 0 || pb[ones] == null) {
				return;
			}

			if (lones == ones) {
				{
					Message m0 = new Message();
					Bundle h6 = new Bundle(pb[ones]);
					m0.setData(h6);
					m0.what = h6.getInt("tabfy");
					tabfy.sendMessageDelayed(m0, 175);

					// tabfy.send
				}
				// smat = 0
				// tapClear

				smartSpark.sendEmptyMessageDelayed(2, 75);

				// markService.removeMessages(2);
				// timber = "";
				// timber2 = "";
				// smx = 0;
				// smct = 0;
				// smat = 0;
				// flashbon = 0;

				rones = -2;
				lones = -2;
				pb[ones].putBoolean("lay", true);
				pb[ones].putFloat("scale", 1f);
				pb[ones].remove("selected");

				ones = -1;
				twos = -1;
				indr = true;

				AnimationSet oh = new AnimationSet(false);
				{
					Animation a8 = new AlphaAnimation(1f, 0f);
					a8.setFillAfter(true);
					a8.setStartOffset(800);
					a8.setDuration(680);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.decelerate_interpolator));
					oh.addAnimation(a8);
				}

				{
					Animation a8 = new ScaleAnimation(1f, 2f, 1f, 2f, 0.5f,
							0.5f);
					a8.setFillAfter(true);
					a8.setDuration(880);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.decelerate_interpolator));
					oh.addAnimation(a8);
				}
				oh.setDuration(880);
				chos.startAnimation(oh);

				choiceClear.sendEmptyMessageDelayed(3, 860);

			} else {
				if (smat <= 2) {
					lones = ones;
					choiceClear.sendEmptyMessageDelayed(2, 280);
				}
			}

		}
	};

	boolean choiceScan(int sscan) {
		// for (int smat = msg.what; smat < smct; smat++) {
		// Computer Patterns
		Log.i("ok",
				"#####################\n########################\n####################\n#######################\ncomputer patters decode choice scan "
						+ sscan
						+ " / "
						+ smct
						+ " #########################################");

		int i = 2;
		while (sscan < smct) {// Thank you Shawn from UI Evolutions

			for (i = pc; i >= 0; i--) {
				if (pb[i] == null) {
					continue;
				}
				// if (pb[i] != null) {
				Log.i("ok",
						"computer patters decode choice scan " + sscan
								+ " scan #" + i + " "
								+ pb[i].getInt("touchx", 0) + ","
								+ pb[i].getInt("touchy", 0) + " "
								+ pb[i].getInt("bwidth", 90) + " "
								+ pb[i].getInt("bheight", 90) + " ("
								+ sm8[sscan][0] + ")");

				// }
				// choiceLit(i);

				if ((pb[i].getInt("touchy", 0) + pb[i].getInt("bheight", 90) / 2) - 15 < sm8[sscan][0]
						// -
						&& (pb[i].getInt("touchy", 0) + pb[i].getInt("bheight",
								90) / 2) + 95 > sm8[sscan][0]

						&& (pb[i].getInt("touchx", 0) + pb[i].getInt("bwidth",
								90) / 2) - 45 < sm9[sscan][0]
						// -
						&& (pb[i].getInt("touchx", 0) + pb[i].getInt("bwidth",
								90) / 2) + 45 > sm9[sscan][0]) {

					// if (pb[i].getLong("selected", 2) > 2) {
					// pb[i].putFloat("scale", 0.8f);
					// pb[i].remove("selected");
					// ones = -1;
					// } else {

					if (ones > -1 && ones == i) {
						Log.i("ok", "########### SCAN LOOKING FOR TWOS");
						continue;
					}

					if (ones > -1) {
						twos = i;
					} else {
						ones = i;
					}

					choiceLit(i);
					// pb[i].putFloat("scale", 1.2f);
					pb[i].putLong("selected", System.currentTimeMillis());
					// tabfy.send
					{
						Message m0 = new Message();
						Bundle h6 = new Bundle(pb[i]);
						m0.setData(h6);
						m0.what = h6.getInt("tabfy");
						tabfy.sendMessageDelayed(m0, 75);
					}

					// }
					Log.i("ok", "computer patters decode choice scan " + sscan
							+ " found " + i);

					return true;
				}

			}

			sscan++;
		}
		// Log.i("ok", "computer patters decode choice scan " + sscan +
		// " false");

		return false;
	}

	Handler xxxscanChoice = new Handler() {
		public void handleMessage(Message msg) {
			ImageView p9;
			String plj = "";

			for (int smat = msg.what; smat < smct; smat++) {

				for (int i = pc; i >= 0; i--) {

					// Twin two year old monolog twister.
					if (pb[i] == null || pb[i].getInt("tabfy", -1) == -1) {
						continue;
					}

					p9 = (ImageView) findViewById(pb[i].getInt("tabfy", -1));
					if (p9 == null) {
						continue;
					}

					// p9.getLocalVisibleRect(bb);

					// 8888, 240x300
					if ((p9.getBottom() - 20 > sm8[smat][0])
							&& p9.getTop() + 20 < sm8[smat][0]) {
						if (p9.getLeft() + 20 < sm9[smat][0]
								&& p9.getRight() - 20 > sm9[smat][0]) {

							if (pb[i].getLong("selected", 2) > 2) {
								pb[i].putFloat("scale", 1.0f);
								pb[i].remove("selected");
							} else {
								pb[i].putFloat("scale", 1.2f);
								pb[i].putLong("selected",
										System.currentTimeMillis());
							}

							Log.i("ok",
									" #####    ########  ######          ###         SELECTED   ##### "
											+ i);

							// pb[i].putFloat("scale", 1.5f);
							// i==hx.getInt("tabfy_pc")

							Message m0 = new Message();
							Bundle h6 = new Bundle(pb[i]);
							m0.setData(h6);
							m0.what = h6.getInt("tabfy");
							tabfy.sendMessageDelayed(m0, 80);

							// tabfy.send

							if (pb[i].getLong("cs", 1) > SystemClock
									.uptimeMillis()) {
								break;
							}
							plj += (i - 2) + "," + (i - 1) + "," + i + ","
									+ (i + 1) + "," + (i + 2);

							// animation = new TranslateAnimation(
							// Animation.RELATIVE_TO_SELF,
							// 0.0f,Animation.RELATIVE_TO_SELF, 0.0f,
							// Animation.RELATIVE_TO_SELF,
							// -1.0f,Animation.RELATIVE_TO_SELF, 0.0f
							// );

							// Animation o0 = AnimationUtils.loadAnimation(
							// ctx, R.anim.taptabonfocus);

							// Transformation k9 = new Transformation();
							// o0.getTransformation(0, k9);
							// Matrix g9 = k9.getMatrix();
							// g9.setTranslate(-100f, (float) (mheight / 2)
							// * -1f);

							// g9.preSkew(0, 0, -5, -40);
							// g9.postTranslate(100, (float) (mheight / 2)
							// * -1);

							// k9.set(k9);
							// o0.getTransformation(0, k9);
							// a8.setInterpolator(new
							// Interpolator(Animation.));

							return;
						}
					}

				}
			}

			String[] pljb = plj.split(",");
			Log.i("ok", "highlighting " + pljb.length + " entries and friends");
			int i = 1;
			float cn = 1;
			float ch = 1;
			int nn = 1;

			int winleft = 1;
			int wintop = 1;
			for (int in = 0; in < pljb.length; in++) {
				try {
					i = Integer.parseInt(pljb[in]);
				} catch (NumberFormatException he8) {
					continue;
				}

				if (i < 0 || i >= pb.length) {
					Log.w("ok", "pb size bounds " + i);
					continue;
				}
				if (pb[i] == null
						|| pb[i].getLong("cs", 1) > SystemClock.uptimeMillis()) {
					continue;
				}

				p9 = (ImageView) findViewById(pb[i] == null ? -1 : pb[i]
						.getInt("tabfy"));
				if (p9 == null) {
					continue;
				}

				if (wintop == 1) {
					wintop = p9.getTop();
				}
				if (winleft == 1) {
					winleft = p9.getLeft();
				}

				nn++;
				cn++;

				if (120 * (cn) > mwidth) {
					cn = 2;
					ch++;
				} else {

				}

				float xyx = -1 * winleft + (cn - 1) * 110;
				float xyy = -1 * (110 * ch);
				if (xyy < -1 * wintop) {
					continue;
				}

				AnimationSet a9 = new AnimationSet(true);
				{

					// Animation a8 = new TranslateAnimation(
					// Animation.RELATIVE_TO_SELF, 0,
					// Animation.RELATIVE_TO_PARENT,
					// (float) ((p9.getWidth() / 2 + 30) * cn - 2),
					// Animation.RELATIVE_TO_SELF, 0,
					// Animation.RELATIVE_TO_PARENT,
					// (float) ((p9.getHeight() / 2 + 30) * ch));

					Animation a8 = new TranslateAnimation(0, (float) (xyx), 0,
							(float) (xyy));
					a8.setZAdjustment(a8.ZORDER_TOP);
					a8.setFillAfter(true);
					a8.setDuration(1568);
					a8.setRepeatMode(a8.REVERSE);
					a8.setRepeatCount(1);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.cycle_interpolator));
					a9.addAnimation(a8);
				}

				{
					Animation a8 = new ScaleAnimation(1f, 2f, 1f, 2f, 0.5f, 1f);

					a8.setFillAfter(true);
					a8.setDuration(268);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.bounce_interpolator));
					a9.addAnimation(a8);

				}

				{
					Animation a8 = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, 0.5f,
							1f);
					a8.setFillAfter(true);
					a8.setDuration(568);
					a8.setStartOffset(669);
					// a8.setRepeatMode(Animation.RESTART);
					// a8.setRepeatCount(Animation.INFINITE);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.overshoot_interpolator));
					a9.addAnimation(a8);
				}

				{
					Animation a8 = new ScaleAnimation(1f, 1f, 1f, 1f, 0.5f, 1);
					a8.setFillAfter(true);
					a8.setDuration(300);
					a8.setStartOffset(1069);
					a8.setRepeatMode(Animation.REVERSE);
					a8.setRepeatCount(1);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.cycle_interpolator));
					a9.addAnimation(a8);
				}

				a9.setFillAfter(true);
				// Random c = new Random();
				a9.setStartOffset(25 + (275 * nn - 2));
				// p9.startAnimation(a9);

				Log.i("ok", "starting animation flow with " + a9.getDuration()
						+ " length or " + a9.computeDurationHint());

				pb[i].putLong("cs",
						SystemClock.uptimeMillis() + a9.getDuration());

				// if (pick) {
				// pc_choice = pb[i].getInt("tabfy_pc");

				// {
				// Bundle nx = new Bundle(pb[pc_choice]);
				// nx.putString("uri_data",
				// xu.toString());
				// nx.putString("data",
				// Uri.fromFile(box).toString());
				// nx.putString("recycle", "tool");
				// nx.putInt("drawable",
				// R.drawable.midres9g);
				// pb[pc_choice].putInt("drawable", R.drawable.midres9g);
				// Message m9 = new Message();
				// m9.setData(nx);
				// m9.what = -1;
				// tabfy.sendMessageDelayed(m9, 75);
				// }

				// return;
				// }

				// scanChoice.sendEmptyMessageDelayed(msg.what, 125);

			}

		}
	};

	RelativeLayout phh;
	boolean phhMobilized = false;
	Handler phhLiz = new Handler() {
		public void handleMessage(Message msg) {
			if (phh != null) {
				phh.setVisibility(View.INVISIBLE);
				phhMobilized = false;
			}
		}
	};

	RelativeLayout pbb;
	boolean pbbMobilized = false;
	Handler pbbLiz = new Handler() {
		public void handleMessage(Message msg) {
			if (pbb != null) {
				pbb.setVisibility(View.INVISIBLE);
				pbbMobilized = false;
			}
		}
	};
	int pc_choice = -1;
	private Handler sparkBoardUp = new Handler() {
		Animation a9;
		long tapcs4 = 1;
		ImageView jh;
		long smview = 1;
		long srview = 1;

		// MapView xmm;
		// MapController xui;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                 SMART UP " + msg.what + " ");

			// productiondash.postInvalidate();

			// operationsPunctuation.removeMessages(2);
			// scheduleOperation.removeMessages(ADURATION);
			// scheduleOperation.sendEmptyMessageDelayed(ADURATION,
			// xuri != null ? 75 : 1875);

			// Boom Boom
			if (smct > smww && smct - smww < 8) {
				Log.i("ok", "tapflat up _______---------- " + (smct) + " "
						+ tapcn);

				tapClear.removeMessages(2);
				tapClear.sendEmptyMessageDelayed(2, 1880 / 2);

				tapcn++;

				// if (tapcn == 1) {
				// if (sm8[smat][0] < (mheight / 2) + (mheight / 4)
				// && sm8[smat][0] > (mheight / 2) - (mheight / 4)) {
				// if (sm9[smat][0] < (mwidth / 2) + (mheight / 4)
				// && sm9[smat][0] > (mwidth / 2) - (mheight / 4)) {
				// sendone.sendEmptyMessageDelayed(2, 10);

				// return;
				// }
				// }
				// }
				ImageView p9;
				// Rect bb = new Rect();
				// Rect bb6 = new Rect();
				// bb6.set((int) sm9[smat][0], (int) sm8[smat][0],
				// (int) sm9[smat][0] + 10, (int) sm8[smat][0] + 10);

				if (sm8[smat][0] < 120 && sm9[smat][0] > mwidth - 120) {
					// Unique Distinct Early
					// viewapp_map = true;
					// if (boxerhugaware) {
					// superhider.sendEmptyMessageDelayed(2, 75);
					// }

					// viewLocation.sendEmptyMessageDelayed(2, 10);

					// return;
				}
				// && sm9[smat][0] < 120

				if (sm8[smat][0] > mheight - (mheight * 0.2)) {

					for (int i = pc; i >= 0; i--) {

						p9 = (ImageView) findViewById(pb[i] == null ? -1
								: pb[i].getInt("tabfy"));

						if (p9 != null
								&& pb[i].getLong("cs", 1) < SystemClock
										.uptimeMillis()) {

							// p9.getLocalVisibleRect(bb);
							if ((p9.getBottom() > sm8[smat][0])
									&& p9.getTop() + 80 < sm8[smat][0]) {
								if (p9.getLeft() + 10 < sm9[smat][0]
										&& p9.getRight() > sm9[smat][0]) {
									// Log.i("ok",
									// "formerly scan choice             ==          ==         ==");

									// scanChoice
									// .sendEmptyMessageDelayed(smat, 75);
									return;
								}
							}
						}
					}
				}

				if (sm8[smat][0] < mheight / 2 + (mheight * 0.2)
						&& sm8[smat][0] > mheight / 2 - (mheight * 0.2)
						&& sm9[smat][0] > mwidth / 2 - (mwidth * 0.2)
						&& sm9[smat][0] < mwidth / 2 + (mwidth * 0.2)) {

					if (phh == null) {

						phh = new RelativeLayout(ctx);
						RelativeLayout.LayoutParams uh = new RelativeLayout.LayoutParams(
								-1, -1);
						uh.setMargins((int) (mwidth / 2 - (mwidth * 0.2)),
								(int) (mheight / 2 - (mheight * 0.2)),
								(int) (mwidth / 2 - (mwidth * 0.2)),
								(int) (mheight / 2 - (mheight * 0.2)));

						// kal tao
						phh.setLayoutParams(uh);
						phh.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);
						while (findViewById(++hid) != null) {
						}
						phh.setId(hid);
						pbn.addView(phh, 0);

						phh.setVisibility(View.INVISIBLE);
					}

					if (phhMobilized || smx < 7) {
						phhLiz.sendEmptyMessageDelayed(2, 75);
						// Intent h6 = new Intent();
						// h6.setAction(android.content.Intent.ACTION_VIEW);
						// hj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						// | Intent.FLAG_ACTIVITY_NO_HISTORY);
						// startActivity(h6);

						// sendone.sendEmptyMessageDelayed(
						// 2,
						// actwin > System.currentTimeMillis() ? (actwin -
						// SystemClock
						// .uptimeMillis()) + ADURATION
						// : 10);
						// = xuri = null
						// ADURATION =

						if (smview < SystemClock.uptimeMillis()) {
							smview = SystemClock.uptimeMillis() + 880;
							Intent hj = new Intent();
							hj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
									| Intent.FLAG_ACTIVITY_NO_HISTORY);
							// hj.setType(type);
							hj.setAction(Intent.ACTION_VIEW);
							// hj.putExtra(SearchManager.QUERY,
							// lxuri.getLastPathSegment());
							if (xuri != null) {
								hj.setData(xuri);
							} else if (lxuri != null) {
								hj.setData(lxuri);
							} else {
								hj.setData(Uri.parse("content://"
										+ ctx.getPackageName() + "/moment"));
							}

							startActivity(hj);
							uberpause.sendEmptyMessageDelayed(2, 75);
							phhLiz.sendEmptyMessageDelayed(2, 75);

							// file5
						}

						// if (smx < 50) {
						// uberpause.sendEmptyMessageDelayed(2, 10);
						// }
					} else {

						if (phh != null) {
							phhMobilized = true;
							phh.setVisibility(View.VISIBLE);
							phhLiz.sendEmptyMessageDelayed(2, 3875);
						}

					}
				}
				if (sm8[smat][0] > mheight - (mheight * 0.2)) {

					// phhLiz.sendEmptyMessageDelayed(2, 3850);

					if (pbb == null) {

						pbb = new RelativeLayout(ctx);
						RelativeLayout.LayoutParams uh = new RelativeLayout.LayoutParams(
								-1, (int) (mheight * 0.2));
						uh.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

						uh.setMargins(0, 0, 0, 0);
						pbb.setLayoutParams(uh);
						pbb.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);
						while (findViewById(++hid) != null) {
						}
						pbb.setId(hid);
						pbn.addView(pbb, 0);
						pbb.setVisibility(View.INVISIBLE);
						pbbMobilized = false;
					}

					if (pbbMobilized || smx < 7) {
						pbbLiz.sendEmptyMessageDelayed(2, 75);
						if (srview < SystemClock.uptimeMillis()) {
							srview = SystemClock.uptimeMillis() + 880;
							onSearchRequested();
							// smx = 0;
							// smat = 0;
							// smct = 0;
							// work on interrputing draw/store process with
							// this
						}
						uberpause.sendEmptyMessageDelayed(2, 10);
						pbbLiz.sendEmptyMessageDelayed(2, 75);
					} else {
						if (pbb != null) {
							pbbMobilized = true;
							pbb.setVisibility(View.VISIBLE);

							pbbLiz.sendEmptyMessageDelayed(2, 3850);
							// searchSmart.sendEmptyMessageDelayed(13850, 150);
						}
					}
				}

				// scheduleOperation.sendEmptyMessageDelayed(75, ADURATION);

			} else {
				Log.i("ok", "draw up ~~~~~------- " + smct + " " + tapcn + " ("
						+ smww + " " + smct + " " + smx + ")");
				tapcn = 1;

				flashB.sendEmptyMessageDelayed(flashbon, 350);
				flashbon = smat;

				markService.sendEmptyMessageDelayed(2, 375);
				// productiondash.postInvalidateDelayed(75);
				// bear.bringChild
				// scheduleOperation.sendEmptyMessageDelayed(75, ADURATION * 2);
				return;
			}

			if (tapcn == 3) {
				Log.i("ok", "99.9999              activeate nano ("
						+ sm9[smww][0] + "," + sm8[smww][0] + ")");
				// nanoactive = true;
				// dingoSparkActive.sendEmptyMessageDelayed(2, 10);
			}

			// scheduleOperation.sendEmptyMessageDelayed(75, 10);

			/*
			 * if (smx >10) { scheduleOperation.sendEmptyMessageDelayed(75, 10);
			 * } else {
			 * 
			 * if (productiondash != null) { Animation oh =
			 * AnimationUtils.loadAnimation(ctx, R.anim.oomx5);// oomx8
			 * productiondash.startAnimation(oh);
			 * hiscave.sendEmptyMessageDelayed(productiondash.getId(),
			 * oh.getDuration()); oh = null; }
			 * 
			 * if (surfacedash != null) { Animation oh5 =
			 * AnimationUtils.loadAnimation(ctx, R.anim.oomx5);
			 * surfacedash.startAnimation(oh5);
			 * hiscave.sendEmptyMessageDelayed(surfacedash.getId(),
			 * oh5.getDuration()); oh5 = null; }
			 * 
			 * smartSparkService.removeMessages(5);
			 * 
			 * smartSpark.removeMessages(2);
			 * smartSpark.sendEmptyMessageDelayed(2, 10); }//
			 */

		}
	};
	Handler uberpause = new Handler() {
		public void handleMessage(Message msg) {

			operationsPunctuation.removeMessages(2);
			// markService.removeMessages(2);
			scheduleOperation.removeMessages(ADURATION);

			// scheduleOperation.removeMessages(2);
			// operationsPunctuation.removeMessages(2);

			if (smx > 20) {
				Log.i("ok",
						"uberpause super schedule =======+++++++++++++++++++++++++++++++\n+++++++++++++++++++++++\n++++++++++++++++++++");
				// } else if (xuri != null) {
				// Message m88 = new Message();
				if (b88 == null) {
					b88 = new Bundle();
				}
				b88.putInt("duration", 120);
				scheduleOperation.sendEmptyMessageDelayed(120, 75);

				// m88.setData(b88);
				// m88.what = 3;
				// operationsPunctuation.sendMessage(m88);
				// Log.i("ok", "requesting closing of " + xuri.toString());
			} else {
				smartSpark.removeMessages(2);
				smartSpark.sendEmptyMessageDelayed(2, 75);
			}

			if (pss != null && pss.getVisibility() == View.VISIBLE) {
				// if (psscs > System.currentTimeMillis()) {
				// {
				// pssoff.sendEmptyMessageDelayed(2, 25);
				// }
				// }
			}

			// if(xuri.)//should these be deleted?
			//
		}
	};
	// if (ipb != null && ipbcs < System.currentTimeMillis()) {
	// Animation o9 = AnimationUtils.loadAnimation(ctx,
	// R.anim.oobs);
	// ipb.startAnimation(o9);
	// ipbcs = System.currentTimeMillis() + o9.getDuration();
	// o9 = null;
	// }

	// ballson++;
	// if (ballson >= falls.length) {
	// ballson = 0;
	// }
	// ballsdeep.sendEmptyMessageDelayed(2, 10);
	// ballsService.sendEmptyMessageDelayed(2, 100);

	public Handler hiscaveOn = new Handler() {
		public void handleMessage(Message msg) {

			ImageView sr = (ImageView) findViewById(msg.what);
			if (sr != null) {
				Animation oh = AnimationUtils.loadAnimation(ctx, R.anim.oomx5);// oomx8
				oh.setDuration(17000);
				sr.startAnimation(oh);
				hiscave.sendEmptyMessageDelayed(sr.getId(), oh.getDuration());
				oh = null;
			} else {
				Log.e("ok", "Frak b " + msg.what);
			}

		}
	};

	private Handler hiscave = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999            REMOVE CAVE " + msg.what);
			ImageView hu = (ImageView) findViewById(msg.what);
			if (hu != null) {
				sparkEasel.removeView(hu);
				hu = null;
			} else {
				Log.e("ok", "Frak " + msg.what);
			}

		}
	};

	int tapcn = 1;
	long tapcs = 1;
	public Handler tapClear = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			tapClear.removeMessages(msg.what);

			if (cs > SystemClock.uptimeMillis()) {
				Log.i("ok", "tap rest");
				return;
			}
			cs = SystemClock.uptimeMillis() + 1200;

			tapcn = 1;
			tapcs = 1;
			Log.i("ok", "tap clear " + smx + " " + smat + " /" + smct + " ("
					+ ")");
			// markService

			if (smx < 15) {
				// cloud
				{
					Random c = new Random();

					// Bitmap b0g = productiondash.getDrawingCache();
					if (gpd != null) {
						ImageView u0 = null;
						{
							u0 = new ImageView(ctx);

							while (findViewById(++hid) != null) {
							}
							u0.setId(hid);
							{
								RelativeLayout.LayoutParams i0 = new RelativeLayout.LayoutParams(
										-1, -1);
								u0.setLayoutParams(i0);
							}
							u0.setScaleType(ScaleType.MATRIX);

							pbn.addView(u0);
							// pbn.bringChildToFront(sparkEasel);

							pbn.bringChildToFront(tips);
						}

						try {
							if (u0 != null) {
								ByteArrayOutputStream st;
								st = new ByteArrayOutputStream();
								if (st != null) {
									gpd.compress(CompressFormat.PNG, 0, st);
									Bitmap b6g = BitmapFactory.decodeByteArray(
											st.toByteArray(), 0, st.size());
									if (b6g != null) {
										u0.setImageBitmap(b6g);

										// Animation oh = AnimationUtils
										// .loadAnimation(ctx,
										// R.anim.progoff);// oomx8

										// u0.startAnimation(oh);
										// pbnImageRemove.sendEmptyMessageDelayed(
										// u0.getId(), oh.getDuration());

										{
											Bundle bx9 = new Bundle();
											bx9.putInt("id", u0.getId());
											// bx9.putInt("anim",
											// R.anim.progoff);
											// bx9.putLong("gofor", 5200);
											Message m9 = new Message();
											m9.setData(bx9);
											pbnImageRemove.sendMessageDelayed(
													m9, 529);
										}

										b6g = null;
										st = null;
									}
								}
								u0.postInvalidate();
							}
						} catch (OutOfMemoryError hs9) {
							Log.i("ok", "SUPER ALPHA decode");
						}

					}
				}

				smartSpark.removeMessages(2);
				smartSpark.sendEmptyMessageDelayed(2, 25);

				// recordService.sendEmptyMessageDelayed(1, 325);

				if (g4f != null) {
					g4f.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
					fildash.postInvalidate();
				}

			}

		}
	};
	Random bs = new Random();
	MediaRecorder u8;
	long actwin = 1;

	public Handler recordService = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              record service "
					+ msg.what
					+ " "
					+ (cs > 1 ? (System.currentTimeMillis() - cs)
							+ "ms last slice" : "first recording"));

			// if (smct > 1) {
			// Log.i("ok", "sound clear rest " + msg.what);
			// recordService.removeMessages(msg.what);
			// recordService.sendEmptyMessageDelayed(msg.what, 2000);
			// return;
			// }

			recordService.removeMessages(msg.what);
			if (upause && msg.what > 1) {
				return;
			}

			if (msg.what > 1 && actwin > System.currentTimeMillis()
					&& cs > System.currentTimeMillis() - 60000) {
				Log.i("ok", "-sound clear rest " + msg.what);
				if (msg.what < 20) {
					Random c = new Random();
					recordService.sendEmptyMessageDelayed(msg.what++,
							(int) (9880 * (c.nextFloat())));
				}
				return;
			}

			// if (msg.what > 1 && cs > System.currentTimeMillis() - 17000) {
			// Log.i("ok", "-excuse sound " + msg.what);
			// return;
			// }

			if (cs > System.currentTimeMillis() - 3000) {
				Log.i("ok", "-excuse sound " + msg.what);
				return;
			}

			// if (msg.what == 3) {
			// recordService.removeMessages(msg.what);
			// }

			cs = System.currentTimeMillis();
			if (++vsv >= vsvfiles.length) {
				vsv = 0;
			}

			// Log.i("ok", "99.9999999999999          recordService "
			// + datetime(System.currentTimeMillis()));
			// if (ipb != null) {
			// ipb.setImageResource(R.drawable.pbo);
			// }
			// u4 = Camera.open();

			// android.media.CamcorderProfile c7 = CamcorderProfile
			// .get(CamcorderProfile.QUALITY_HIGH);
			if (u8 != null) {

				// u8.reset();
				// u8.stop();
				try {
					u8.stop();
				} catch (RuntimeException e2) {
					Log.i("ok", "stop b" + e2.getMessage());
				}

				// u8 = null;
				// recordService.sendEmptyMessageDelayed(2, 2000);
				// return;

				// e2.printStackTrace();
				// } catch (IllegalStateException e1) {
				// e1.printStackTrace();
				u8.reset();
				u8.release();
				// pu0 = null;
				// listeningcs = 1;

				if (mvix != null) {
					mvix.lock();
					mvix.release();
				}

				u8 = null;
			} else {

			} // u8.setCamera();
				// mvix = null;

			if (pmc.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
				if (mvix == null) {
					// getCameraInstance.sendEmptyMessageDelayed(2, 275);
				} else {
					// try {
					// mvix.reconnect();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
				}
			}

			// if (mvix != null) {
			// mvix.unlock();
			// }
			recordServiceb.sendEmptyMessageDelayed(2, 75);

		}
	};
	Bitmap[] bmxb = new Bitmap[299];
	Bitmap[] smxb = new Bitmap[299];
	Canvas[] cmxb = new Canvas[299];

	Handler tabfy = new Handler() {
		ContentValues bmx = new ContentValues();
		// background R.drawable. "drawable" files up to 99 please
		int bmnn = 0;

		NinePatch[] nmxb = new NinePatch[299];

		Typeface ho = null;
		android.graphics.Paint pa = null;
		android.graphics.Paint pa5 = null;
		// Bitmap j0;

		ContentValues cx = new ContentValues();

		public void handleMessage(Message msg) {
			// if (msg.what > -1) {
			// tabfy.removeMessages(msg.what);
			// }

			Bundle hx = msg.getData();
			String hk = hx.getString("data");
			if (hk == null) {
				hk = "";
			}
			if (hk.length() > 0 && cx.containsKey(hk)) {
				hx.putInt("tabfy_pc", cx.getAsInteger(hk));
			}

			if (hx.containsKey("tabfy_pc") && pb[hx.getInt("tabfy_pc")] != null) {
				// Set<String> k9 = hx.keySet();
				// Object[] b = k9.toArray();
				// for (int n = 0; n < b.length; n++) {
				// Object j9;// byte[] j9;
				// }
				// for(int i = 0; i < )

				if (hx != null) {
					pb[hx.getInt("tabfy_pc")].putAll(hx);
				}
				hx = pb[hx.getInt("tabfy_pc")];
			}

			// Runs repeatedly when changing or preparing
			// Log.i("ok",
			// "TABFY                      =======            ======      ====== "
			// + msg.what + " @" + hx.getInt("ic", -1));

			if (hx.containsKey("scale")) {
				// Log.i("ok",
				// "TABFY SCALE =======            ======      ====== "
				// + msg.what + ", " + hx.getFloat("scale"));

			}

			if (hx.containsKey("extend")) {
				// Log.i("ok",
				// "TABFY EXTEND =======            ======      ====== "
				// + msg.what + ", " + hx.getFloat("extend"));
			}

			// if (pb[hx.getInt("tabfy_pc", 0)].getLong("selected", 1) > System
			// .currentTimeMillis() - 13 * 999) {
			// pb[hx.getInt("tabfy_pc", 0)].putFloat("scale", 1.3f);
			// } else if (pb[hx.getInt("tabfy_pc", 0)].getLong("selected", 1) >
			// 1) {
			// pb[hx.getInt("tabfy_pc", 0)].putFloat("scale", 1.0f);
			// pb[hx.getInt("tabfy_pc", 0)].remove("selected");
			// }

			ImageView pu0 = null;
			if (hx.containsKey("tabfy")) {
				pu0 = (ImageView) findViewById(hx.getInt("tabfy"));

			} else {
				hx.putLong("pending", SystemClock.uptimeMillis());
			}

			try {
				// Drawable j0 =
				// getResources().getDrawable(R.drawable.taptab);
				// if (j0 == null) {

				int midres = hx.getInt("drawable", R.drawable.midres7);

				int mk9 = -1;

				if (bmx.containsKey("b" + midres)
						&& bmx.getAsInteger("b" + midres) >= 0) {
					mk9 = bmx.getAsInteger("b" + midres);
				}

				if (mk9 == -1 || bmxb[mk9] == null) {
					mk9 = bmnn++;
				}

				if (hx.getLong("selected", 1) > System.currentTimeMillis() - 23 * 999
						|| hx.getBoolean("lay", false) != hx.getBoolean(
								"setlay", false)
						|| hx.getFloat("spin", 1f) != hx
								.getFloat("setspin", 1f)
						|| hx.getFloat("scale", 1f) != hx.getFloat("setscale",
								1f)) {
					// hx.putFloat("scale", 1.3f);
					hx.putFloat("setscale", hx.getFloat("scale", 1f));
					hx.putFloat("setspin", hx.getFloat("spin", 0f));
					hx.putBoolean("setlay", hx.getBoolean("lay", false));

					if (bmxb[mk9] != null) {
						bmxb[mk9] = null;
						nmxb[mk9] = null;
						cmxb[hx.getInt("tabfy_pc", 0)] = null;
						smxb[hx.getInt("tabfy_pc", 0)] = null;
					}

				}

				if (bmxb[mk9] == null) {

					bmxb[mk9] = BitmapFactory.decodeResource(getResources(),
							midres);
					bmx.put("b" + midres, mk9);

					// }// Intrinsic
					// if () {
					if (bmxb[mk9].getNinePatchChunk() == null) {

						Bitmap j0b = Bitmap.createScaledBitmap(bmxb[mk9],
								(int) (120 * hx.getFloat("scale", 1f)),
								(int) (120 * hx.getFloat("scale", 1f)), true);
						if (j0b == null) {
							Log.w("ok",
									"decode d " + ", " + hx.getInt("tabfy_pc"));
							return;
						} else {
							bmxb[mk9] = null;
							// Continually
							// Log.w("ok",
							// "##                ## RESCALED IMAGE       ###################### "
							// + ", " + hx.getInt("tabfy_pc") + " @"
							// + hx.getInt("ic", -1));

							bmxb[mk9] = j0b;
							j0b = null;

						}
					} else if (NinePatch.isNinePatchChunk(bmxb[mk9]
							.getNinePatchChunk())) {

						Log.i("ok",
								"NINE PATCH "
										+ bmxb[mk9].getNinePatchChunk()[0]
										+ " "
										+ bmxb[mk9].getNinePatchChunk()[1]);
						nmxb[mk9] = new NinePatch(bmxb[mk9],
								bmxb[mk9].getNinePatchChunk(), null);
					}
				}

				if (bmxb[mk9] == null) {
					bmx.remove("b" + midres);
					Log.w("ok", "decode b " + ", " + hx.getInt("tabfy_pc"));
					return;
				}

				if (pu0 == null) {
					ImageView u0 = new ImageView(ctx);
					while (findViewById(++hid) != null) {
					}
					u0.setId(hid);
					u0.setVisibility(View.INVISIBLE);

					// pb[hx.getInt("tabfy_pc")]
					hx.putInt("touchx",
							hx.getInt("left", (int) ((mwidth / 2) - 60)));
					// pb[hx.getInt("tabfy_pc")]
					hx.putInt("touchy", hx.getInt("top",
							(int) (mheight - (80 + 120 * hx.getFloat("scale",
									1f) * 2))));

					{
						RelativeLayout.LayoutParams i0 = new RelativeLayout.LayoutParams(
								-2, -2);
						i0.setMargins(hx.getInt("touchx", 0),
								hx.getInt("touchy", 0), 0, 0);
						u0.setLayoutParams(i0);
					}

					u0.setScaleType(ScaleType.MATRIX);
					u0.setAdjustViewBounds(true);
					pbn.addView(u0);

					cx.put(hk, pc);
					// pp[pc + AUG] = u0.getId();
					Log.i("ok", "Created tabfy " + u0.getId() + " [" + pc + "]");
					hx.putInt("tabfy", u0.getId());
					hx.putInt("tabfy_pc", pc);// source of empty pc places
					pb[pc] = new Bundle(hx);

					{

						// pb[i].putInt("ic", (pb[i].getInt("ic") + 1));

						Message jm9 = new Message();
						Bundle b8 = new Bundle();
						b8.putInt("pbi", pc);
						// b8.putInt("left", fleft);
						// b8.putInt("top", ftop);
						// b8.putLong("prebump", prebump);
						// b8.putInt("direction", direction);

						jm9.setData(b8);
						setPut.sendMessageDelayed(jm9, 75);
						// dance = true;
					}

					pc++;
					if (pc >= pb.length) {
						pc = 1;
					}

					pu0 = u0;
					moveService.sendEmptyMessageDelayed(2, 635);
				}

				int km9 = 140;// 240 120
				int ku9 = 200;// 300

				if (cmxb[hx.getInt("tabfy_pc", 0)] == null) {
					float skwa = 0f;
					float skwb = 0f;

					if (hx.getBoolean("lay", false)) {
						skwb = 1.0f;
						skwa = 0.4f;
					} else if (hx.containsKey("left")) {
					} else {
						skwa = 0.4f;
					}
					pb[hx.getInt("tabfy_pc")].putInt(
							"bwidth",
							(int) (km9 * hx.getFloat("scale", 1f) + km9
									* hx.getFloat("scale", 1f) * skwb));
					pb[hx.getInt("tabfy_pc")].putInt(
							"bheight",
							(int) (ku9
									* hx.getFloat("scale", 1f)
									+ (hx.getFloat("extend", 0f) * ku9 * hx
											.getFloat("scale", 1f)) + ku9
									* hx.getFloat("scale", 1f) * skwa));
					// pb[i] = null;
					try {
						smxb[hx.getInt("tabfy_pc", 0)] = Bitmap.createBitmap(
								pb[hx.getInt("tabfy_pc")].getInt("bwidth"),
								pb[hx.getInt("tabfy_pc")].getInt("bheight"),
								Bitmap.Config.ARGB_8888);
						cmxb[hx.getInt("tabfy_pc", 0)] = new Canvas(
								smxb[hx.getInt("tabfy_pc", 0)]);

						if (hx.getBoolean("lay", false)) {
							cmxb[hx.getInt("tabfy_pc", 0)].skew(1f, -0.4f);
						} else if (hx.containsKey("left")) {
						} else {
							cmxb[hx.getInt("tabfy_pc", 0)].skew(0.0f, -0.4f);
						}
						// scanChoi
						if (hx.containsKey("spin")) {
							cmxb[hx.getInt("tabfy_pc", 0)].rotate(hx.getFloat(
									"spin", 0f), (int) (bmxb[hx
									.getInt("tabfy_pc")].getWidth() / 2),
									(int) (bmxb[hx.getInt("tabfy_pc")]
											.getHeight() / 2));

						}

					} catch (OutOfMemoryError ji8) {
						Log.i("ok", "smxb OOM decode");
					}
					// Bitmap b5g = Bitmap.createScaledBitmap(j0, 120, 120,
					// true);
					// Canvas k0 = new Canvas(b0g);

				}

				if (cmxb[hx.getInt("tabfy_pc", 0)] == null) {

					Log.w("ok", "SUPER decode");
					return;
				}

				cmxb[hx.getInt("tabfy_pc", 0)].drawColor(
						Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);

				cmxb[hx.getInt("tabfy_pc", 0)].scale(hx.getFloat("scale", 1f),
						hx.getFloat("scale", 1f), 0, 0f);

				if (pa == null) {
					pa = new android.graphics.Paint();
					if (ho == null) {
						ho = Typeface.createFromAsset(getAssets(),
								"Roboto-Regular.ttf");
					}

					pa.setTypeface(ho);
					pa.setTextSize(18f);
					pa.setColor(Color.argb(255, 0, 0, 0));
					pa.setStrokeWidth(1f);
				}

				if (pa5 == null) {
					pa5 = new android.graphics.Paint();
					pa5.setTextSize(10f);
					// Typeface ho = Typeface.createFromAsset(getAssets(),
					// "Roboto-Regular.ttf");
					pa5.setTypeface(ho);

					pa5.setColor(Color.argb(255, 250, 250, 250));
					pa5.setStrokeWidth(1f);
				}

				if (hx.getBoolean("lay", false)) {// "extend

					pa.setAlpha(210);
					if (nmxb[mk9] != null) {
						Rect cc9 = new Rect();

						// cc9.set(0, 0, 120, 120);
						cc9.set((int) (-0.4f * km9),
								(int) (80 * hx.getFloat("scale", 1f)),
								(int) (-0.4f * km9 + km9
										* hx.getFloat("scale", 1f)),
								(int) (ku9 * hx.getFloat("scale", 1f) + (int) (hx
										.getFloat("extend", 0f) * ku9 * hx
										.getFloat("scale", 1f))));
						nmxb[mk9].draw(cmxb[hx.getInt("tabfy_pc", 0)], cc9, pa);
					} else {
						cmxb[hx.getInt("tabfy_pc", 0)].drawBitmap(bmxb[mk9],
								(int) (-0.4f * km9),
								(int) (80 * hx.getFloat("scale", 1f)), pa);
					}
				} else if (hx.containsKey("left")) {
					if (nmxb[mk9] != null) {
						Rect cc9 = new Rect();

						// cc9.set(0, 0, 120, 120);
						cc9.set((int) (0),
								(int) (80 * hx.getFloat("scale", 1f)),
								(int) (km9 * hx.getFloat("scale", 1f)),
								(int) (ku9 * hx.getFloat("scale", 1f))
										+ (int) (hx.getFloat("extend", 0f)
												* ku9 * hx
													.getFloat("scale", 1f)));
						nmxb[mk9].draw(cmxb[hx.getInt("tabfy_pc", 0)], cc9, pa);

					} else {
						cmxb[hx.getInt("tabfy_pc", 0)].drawBitmap(bmxb[mk9], 0,
								(int) (80 * hx.getFloat("scale", 1f)), pa);
					}

				} else {

					if (nmxb[mk9] != null) {
						Rect cc9 = new Rect();

						// cc9.set(0, 0, 120, 120);
						cc9.set((int) (0),
								(int) (80 * hx.getFloat("scale", 1f)),
								(int) (km9 * hx.getFloat("scale", 1f)),
								(int) (ku9 * hx.getFloat("scale", 1f))
										+ (int) (hx.getFloat("extend", 0f)
												* ku9 * hx
													.getFloat("scale", 1f)));
						nmxb[mk9].draw(cmxb[hx.getInt("tabfy_pc", 0)], cc9, pa);

					} else {
						cmxb[hx.getInt("tabfy_pc", 0)].drawBitmap(bmxb[mk9], 0,
								(int) (80 * hx.getFloat("scale", 1f)), pa);
					}
				}

				// Log.i("ok",
				// "TABFY =======            ======      ====== "
				// + msg.what + ", " + hx.getInt("tabfy_pc") + " NEW");

				// (int) (140 * hx.getFloat("scale", 1f)),
				// (int) (200 * hx.getFloat("scale", 1f))
				// + (int) (hx.getFloat("extend", 0) * 200 * hx
				// .getFloat("scale", 1f)));
				// "extend

				// pbn.bringChildToFront(sparkEasel);
				// pbn.bringChildToFront(tips);

				// int AUG = hx.containsKey("left") || hx.containsKey("lay")
				// ? 100
				// : 0;

				// moveService.removeMessages(2);

				// {

				// if (!hx.containsKey("left") &&
				// !hx.containsKey("lay")) {
				// }

				// pb[hx.getInt("tabfy_pc")].putLong(
				// "cs",
				// SystemClock.uptimeMillis()
				// + a9.getDuration() - 115);

				// pb[hx.getInt("tabfy_pc")] = new Bundle(hx);

				// Message m0 = new Message();
				// pb[hx.getInt("tabfy_pc")].putInt("pic", 0);//
				// pb[hx
				// .getInt("tabfy_pc")].getInt("ic", -1));
				// pb[hx.getInt("tabfy_pc")].putInt("ic", 1);

				// m0.setData(pb[hx.getInt("tabfy_pc")]);
				// m0.what = hx.getInt("tabfy_pc");
				// reviewMove.sendMessageDelayed(m0,
				// a9.getDuration() + 650);// i

				// } else {
				// moveAlong.sendEmptyMessageDelayed(2, 35);
				// }

				if (hx.getInt("tabfy", -1) == -1) {
					Log.w("ok",
							"SOMEHOW        ##########   IMAGEVIEW TABFY FAILED ############## "
									+ hx.getInt("tabfy_pc"));
					return;
				}

				// if (pb[hx.getInt("tabfy_pc")].containsKey("uri_data")) {
				if (hx.containsKey("uri_data")) {

					String hmk = // pb[hx.getInt("tabfy_pc")]
					hx.getString("uri_data");

					if (hmk.contains("content:")) {

						{
							Rect bb6 = new Rect();
							pa5.getTextBounds(hmk, 0, hmk.length(), bb6);
							while (bb6.width() > 80) {
								pa5.setTextSize(pa5.getTextSize() - 1f);
								pa5.getTextBounds(hmk, 0, hmk.length(), bb6);
							}
							cmxb[hx.getInt("tabfy_pc", 0)].drawText(hmk, 23,
									190, pa5);
						}

						int c9 = 0;// pb[hx.getInt("tabfy_pc")].getInt("count",
									// -1);
						// if (c9 <= 0 && hk.contains("content:")) {
						Cursor k9 = SqliteWrapper.query(ctx,
								getContentResolver(), Uri.parse(hmk),
								new String[] { "count(*)" }, null, null, null);

						if (k9 != null && k9.moveToFirst()) {
							c9 = k9.getInt(0);
						}
						if (k9 != null) {
							k9.close();
						}
						// }
						pb[hx.getInt("tabfy_pc")].putInt("count", c9);
						// "selected"scanChoice
						if (c9 > 0) {
							android.graphics.Paint pa7 = new android.graphics.Paint();
							pa7.setTextSize(26f);
							pa7.setTypeface(ho);
							pa7.setColor(Color.argb(245, 0, 0, 25));
							pa7.setStrokeWidth(1f);

							android.graphics.Paint p8 = new android.graphics.Paint();
							// p8.setTextSize(16f);
							// my9
							// p8.setColor(Color.argb(145, 0, 160, 125));
							// Random

							p8.setColor(my9[bs.nextInt(9)]);
							// "count"
							p8.setStrokeWidth(5f);
							p8.setStyle(Paint.Style.FILL);
							p8.setAlpha(140);
							int wwx = pb[hx.getInt("tabfy_pc")]
									.getInt("bwidth") - 23 - 36;
							int wwy = pb[hx.getInt("tabfy_pc")]
									.getInt("bheight") - 29;
							Path j8 = new Path();

							if (c9 == 1) {

								j8.addCircle(wwx - 29, wwy - 89, 39,
										Path.Direction.CCW);
								j8.setFillType(Path.FillType.EVEN_ODD);
								cmxb[hx.getInt("tabfy_pc", 0)].drawPath(j8, p8);

							} else {
								String h9s = "" + c9;
								float[] k9i = new float[h9s.length()];
								pa7.getTextWidths(h9s, k9i);
								float ib9 = 1f;
								for (int i56 = 0; i56 < k9i.length; i56++) {
									ib9 += k9i[i56];
								}

								j8.addCircle(wwx, wwy, ib9 - 19,
										Path.Direction.CCW);
								j8.setFillType(Path.FillType.EVEN_ODD);
								cmxb[hx.getInt("tabfy_pc", 0)].drawPath(j8, p8);

								Rect bb6 = new Rect();
								pa7.getTextBounds(h9s, 0, h9s.length(), bb6);
								pa7.setTextAlign(Paint.Align.CENTER);
								cmxb[hx.getInt("tabfy_pc", 0)].drawText(h9s,
										wwx, wwy + 9, pa7);

							}

							// cmxb[hx.getInt("tabfy_pc", 0)].drawText(
							// "" + c9+ "", wwx - 22, wwy + 7, pa7);

							pb[hx.getInt("tabfy_pc")].putLong("pending", 1);
						}
					}
				}

				if (hx.containsKey("tool")) {
					pb[hx.getInt("tabfy_pc")].putLong("pending", 1);

				} else if (hk.contains("file:") || hk.startsWith("/")) {
					// Log.i("ok",
					// "TABFY =======            ======      ====== "
					// + msg.what + ", " + hx.getInt("tabfy_pc")
					// + " TYPE: FILE");
					File h9 = new File(Uri.parse(hk).toString()
							.replaceFirst("file:..", ""));

					// if (vsvfiles[vsv] != null && vsvfiles[vsv].length() > 0)
					// {
					// File h9 = new File(vsvfiles[vsv]);

					if (h9.exists() && h9.getAbsolutePath().contains(".png")) {

						// Log.i("ok",
						// "displaying record with image "
						// + h9.getAbsolutePath() + ", "
						// + hx.getInt("tabfy_pc"));

						try {
							Bitmap j9 = BitmapFactory.decodeFile(h9
									.getAbsolutePath());

							if (j9 != null) {
								Bitmap j9b = null;

								// if (j9.getWidth() > j9.getHeight()) {
								j9b = Bitmap.createScaledBitmap(j9, 72, 72,
										true);
								// (int) (j9.getWidth()
								// * (j9.getWidth() - 72) / 72),
								// (int) (j9.getHeight()
								// * (j9.getWidth() - 72) / 72),
								// true);
								// } else {
								// j9b = Bitmap
								// .createScaledBitmap(
								// j9,
								// (int) (j9.getWidth()
								// * (j9.getHeight() - 72) / 72),
								// (int) (j9.getHeight()
								// * (j9.getHeight() - 72) / 72),
								// true);
								// }

								if (j9b != null) {
									// Log.i("ok",
									// "displaying record with image "
									// + h9.getAbsolutePath()
									// + ", "
									// + hx.getInt("tabfy_pc")
									// + " DRAWING");

									android.graphics.Paint pa7 = new android.graphics.Paint();
									// Typeface ho =
									// Typeface.createFromAsset(getAssets(),
									// "Roboto-Regular.ttf");
									pa7.setTypeface(ho);
									pa7.setTextSize(16f);
									pa7.setColor(Color.argb(255, 0, 0, 20));
									pa7.setStrokeWidth(1f);

									// if (j9b != null) {
									cmxb[hx.getInt("tabfy_pc", 0)].drawBitmap(
											j9b, 23 + (80 / 2) - (72 / 2), 116,
											pa7);
									// } else {
									// k0.drawBitmap(BitmapFactory
									// .decodeResource(getResources(),
									// R.drawable.pokeeb),
									// 23 + (80 / 2 - 60 / 2), 116,
									// pa7);
									// } // msg.what = 1;
									j9 = null;
									j9b = null;

									pb[hx.getInt("tabfy_pc")].putLong(
											"pending", 1);
								}
							}

						} catch (RuntimeException e9) {
							Log.w("ok",
									"##                            ## decode eu");
							e9.printStackTrace();
						}

					} else

					// Robust Seconds
					if (pb[hx.getInt("tabfy_pc")] != null
							&& h9.exists()
							&& ((System.currentTimeMillis() - h9.lastModified()) < 1880)) {

						long listeningcs = pb[hx.getInt("tabfy_pc", 0)]
								.getLong("listening", 1);

						// hx.putString("data", Uri.fromFile(h9).toString());
						if (listeningcs == 1
								|| (System.currentTimeMillis() - listeningcs) > 998 * 999) {
							listeningcs = System.currentTimeMillis() - 75;
							pb[hx.getInt("tabfy_pc")].putLong("listening",
									listeningcs);
						}

						if (System.currentTimeMillis() - listeningcs > 1000) {
							// removing
							// Log.i("ok",
							// "TABFY =======            ======      ====== "
							// + msg.what + ", "
							// + hx.getInt("tabfy_pc")
							// + " TYPE: FILE ACTIVE "
							// + h9.getAbsolutePath());

							// Log.i("ok",
							// "record active "
							// + vsvfiles[vsv]
							// + " "
							// + (System.currentTimeMillis() - h9
							// .lastModified())
							// + " "
							// + (System.currentTimeMillis() - listeningcs)
							// + ", " + hx.getInt("tabfy_pc"));
							// have been me
							//
							// Waiting for a surprise that will change u? Having
							// been dociled by self appreciating success.
							// Microsoft acquiring what I had built and lived
							// daily felt awesome. When I was in fifth grade I
							// wished I could someday be employed at Microsoft
							// in a super way and maybe follow Bill Gates when
							// he does something else. It was perhaps the first
							// time I had heard of Microsoft. I dreamed
							// Microsoft was in the land of Oz where I would
							// maybe someday see. I continually accounted for
							// being bigger than Microsoft and that makes
							// wishing difficult. So I was speechless in awe.
							// And loving it.
							//
							// It is not that my life has been difficult it has
							// been unusual and packed with independent
							// perspective. Serveral people, namely female,
							// distinctly recall seeking vision of kinship.
							// While I felt that for people around me it was
							// dulled and kelpered. My closest family were
							// openly not blood tied but family bound by heart
							// however it is true that blood is deeper and
							// thicker than anything. The distinct differences
							// repel me for protection into the weeds between
							// extremes ungranulated and welcoming and
							// comforting. My family tree has been missing my
							// Father's piece next to Mine but not for any lack
							// of trying. My Dad spanked me once when I was
							// about five and it straightened me up
							// indefinately. I recall thinking how to ask him to
							// teach my parents that method. He remembers that
							// as the one time he hit me. His eyes are mine, our
							// hair color and texture, earlobes, height, index
							// fingers, birth astigmatism, single sneeze
							// response, cleft chin, likes racing events, likes
							// drag racing, likes monster trucks, hosts parties,
							// community oriented, tidy, non-smoker, responsible
							// drinker, high IQ, great taste in women, already
							// knows how I feel, and solutions oriented natural
							// talent.
							//
							pb[hx.getInt("tabfy_pc")].putLong("pending", 1);
							{
								// E Listers
								// That's D List pensive

								// Typeface ho = Typeface.createFromAsset(
								// getAssets(), "Roboto-Regular.ttf");
								// pa.setTypeface(ho);

								String hh4 = reg.getString(
										"tab_en_im_listening", "i am");

								Rect bb = new Rect();
								pa.getTextBounds(hh4, 0, hh4.length(), bb);
								while (bb.width() > 80) {
									pa.setTextSize(pa.getTextSize() - 1f);
									pa.getTextBounds(hh4, 0, hh4.length(), bb);
								}

								cmxb[hx.getInt("tabfy_pc", 0)].drawText(hh4,
										23, 136, pa);
							}

							{
								android.graphics.Paint pa7 = new android.graphics.Paint();
								pa7.setTextSize(16f);
								pa7.setColor(Color.argb(255, 0, 0, 20));
								pa7.setStrokeWidth(1f);

								cmxb[hx.getInt("tabfy_pc", 0)]
										.drawText(
												""
														+ (int) ((System
																.currentTimeMillis() - listeningcs) / 1000)
														+ " seconds", 16,
												(int) (96 + 31 - pa7
														.getTextSize()), pa7);
								// } else {
								// k0.drawText("is not", 23, 136, pa);
								cmxb[hx.getInt("tabfy_pc", 0)].drawText(reg
										.getString("tab_en_listening",
												"listening"), 23, 154, pa);
							}
							// msg.what = 1;
							{
								Message m0 = new Message();
								Bundle h6 = new Bundle(
										pb[hx.getInt("tabfy_pc")]);
								m0.setData(h6);
								m0.what = h6.getInt("tabfy");
								tabfy.sendMessageDelayed(m0, 5880);
							}

							// } else if
							// (pb[hx.getInt("tabfy_pc")].getLong("pending",
							// 1) == 1) {
							// pb[hx.getInt("tabfy_pc")].putLong("pending",
							// SystemClock.uptimeMillis() - 75);
							// pb[hx.getInt("tabfy_pc")].putLong("listening",
							// System.currentTimeMillis() - 75);
							// k0.drawText("to listen", 23, 154, pa);
						}
						String hb8 = reg.getString("tab_en_listeningfoot",
								"2share w/om cares");
						Rect bb6 = new Rect();
						pa5.getTextBounds(hb8, 0, hb8.length(), bb6);
						while (bb6.width() > 80) {
							pa5.setTextSize(pa5.getTextSize() - 1f);
							pa5.getTextBounds(hb8, 0, hb8.length(), bb6);
						}

						cmxb[hx.getInt("tabfy_pc", 0)].drawText(hb8, 23, 190,
								pa5);
					} else {
						// file is not new and may or may not exist

						if (hx.getInt("tabfy_pc", -1) != -1
								&& pb[hx.getInt("tabfy_pc")] != null
								&& pb[hx.getInt("tabfy_pc")].getLong("pending",
										1) == 1) {

							Log.i("ok",
									"TABFY =======            ======      ====== "
											+ msg.what + ", "
											+ hx.getInt("tabfy_pc")
											+ " COMPLETE");

							tabfy.removeMessages(msg.what);
							// pb[hx.getInt("tabfy_pc")].putInt("tabfy", -1);
							cx.remove(hk);
							return;
						} else {
							// Log.i("ok",
							// "TABFY =======            ======      ====== "
							// + msg.what + ", "
							// + hx.getInt("tabfy_pc")
							// + " TYPE: PREPARE");
						}
					}

				} else {
					Log.w("ok",
							"##                           ## unknown tabfy requested "
									+ msg.what + ", " + hx.getInt("tabfy_pc"));
				}

				if (pb[hx.getInt("tabfy_pc")] != null) {

					if (pb[hx.getInt("tabfy_pc")].getLong("pending", 1) > 1) {

						// tabfy.sendEmptyMessageDelayed(3, 880);
						// k0.drawText("preparing", 16, 136, pa);
						// msg.what = 1;
						if ((SystemClock.uptimeMillis()
								- pb[hx.getInt("tabfy_pc")].getLong("pending",
										1) < 32000)) {

							// Log.i("ok",
							// "prepare TABFY        ==  "
							// + (pb[hx.getInt("tabfy_pc")].getLong(
							// "pending", 1)) + ", "
							// + hx.getInt("tabfy_pc"));
							cmxb[hx.getInt("tabfy_pc", 0)].drawText("prepare",
									23, 136, pa);

							android.graphics.Paint pa7 = new android.graphics.Paint();
							pa7.setTextSize(16f);
							pa7.setColor(Color.argb(245, 0, 0, 25));
							pa7.setStrokeWidth(1f);

							cmxb[hx.getInt("tabfy_pc", 0)]
									.drawText(
											""
													+ (int) ((SystemClock
															.uptimeMillis() - pb[hx
															.getInt("tabfy_pc")]
															.getLong("pending",
																	1)) / 1000)
													+ " seconds",
											16,
											(int) (96 + 31 - pa7.getTextSize()),
											pa7);
							// msg.what = 1;

							Message m0 = new Message();
							Bundle h8 = new Bundle(hx);
							m0.setData(h8);
							m0.what = hx.getInt("tabfy");
							tabfy.removeMessages(m0.what);
							tabfy.sendMessageDelayed(m0, 7880);

						} else {
							cmxb[hx.getInt("tabfy_pc", 0)].drawText("delayed",
									23, 136, pa);
							// Log.i("ok",
							// "delayed TABFY        ==  "
							// + (pb[hx.getInt("tabfy_pc")].getLong(
							// "pending", 1)));
						}
					}
				}

			} catch (OutOfMemoryError om) {
				Log.w("ok", "oom during new silver");
				om.printStackTrace();
			}

			try {
				// pb[
				if (pu0 != null) {
					ByteArrayOutputStream st;
					st = new ByteArrayOutputStream();

					if (st != null && smxb[hx.getInt("tabfy_pc", 0)] != null) {
						smxb[hx.getInt("tabfy_pc", 0)].compress(
								CompressFormat.PNG, 0, st);
						Bitmap b6g = BitmapFactory.decodeByteArray(
								st.toByteArray(), 0, st.size());
						if (b6g != null) {
							pu0.setImageBitmap(b6g);
							b6g = null;
							st = null;
						}
					}
					// pu0.postInvalidate();
				}

			} catch (OutOfMemoryError om) {
				Log.w("ok", "oom during new n silver");
				om.printStackTrace();
			}

			// cmxb[mk9] = null;
			// b0g = null;

		}
	};

	int pptrack = 99;
	// int[] pp = new int[299];// pp.len
	Bundle[] pb = new Bundle[299];// pb.len
	int pc = 1;
	private Handler recordServiceb = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service b " + msg.what);
			if (upause) {
				return;
			}
			try {

				recordService.sendEmptyMessageDelayed(2, 17000);

				u8 = new MediaRecorder();

				if (mvix != null) {
					// u8 = new MediaRecorder();
					mvix.unlock();
					u8.setCamera(mvix);

					u8.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
					u8.setVideoSource(MediaRecorder.VideoSource.CAMERA);

					u8.setProfile(CamcorderProfile
							.get(CamcorderProfile.QUALITY_HIGH));
					// u8.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

				} else {
					if (u8 != null) {
						u8.setAudioSource(MediaRecorder.AudioSource.MIC);
						u8.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					}// PICTURE
				}

			} catch (RuntimeException e2) {
				Log.w("ok", "wha n b " + e2.getMessage());
				e2.printStackTrace();
				// listeningcs = 1;
			}

			recordServicec.sendEmptyMessageDelayed(2, 75);
		}
	};

	int vsv = 1;
	String[] vsvfiles = new String[8];
	Camera mvix;

	Handler getCameraInstance = new Handler() {
		public void handleMessage(Message msg) {
			try {
				mvix = Camera.open(); // attempt to get a Camera instance
			} catch (Exception e) {
				Log.w("ok", "call it " + e.getMessage());
				e.printStackTrace();
				// Camera is not available (in use or does not exist)
			}
		}
	};

	Handler reviewMove = new Handler() {
		// int lastic = 1;

		public void handleMessage(Message msg) {
			Bundle hx = msg.getData();
			ImageView u4 = (ImageView) findViewById(pb[msg.what] == null ? -1
					: pb[msg.what].getInt("tabfy"));
			if (upause) {
				reviewMove.removeMessages(msg.what);
				return;
			}
			if (u4 != null) {
				int ic = hx.getInt("ic", -1);

				if (pb[ic] == null) {
					return;
				}

				// int pic = hx.getInt("pic", -1);
				if (ic <= 0) {
					Log.i("ok", "flow entry " + ic);
					return;
				}

				// if (pb[ic].getLong("cs", 1) > SystemClock.uptimeMillis() * 2)
				// {
				// Log.i("ok",
				// "flow busy "
				// + ic
				// + " "
				// + (pb[ic].getLong("cs", 0) - SystemClock
				// .uptimeMillis()));
				//
				// return;
				// }

				Log.i("ok", ">                             transfer flow on "
						+ ic);

				// int ic = pc - 1 - msg.what;

				// || ic == pic

				RelativeLayout.LayoutParams i0 = new RelativeLayout.LayoutParams(
						-2, -2);
				AnimationSet o0 = null;
				int lastic = (int) ((mwidth / 2 - 60 - (1 * 20)) / 20);
				int lasty = (int) ((mheight - 60 - (4 * 40)) / 40);
				// Log.i("ok","reviewMove " + ic);

				if (ic == 1) {
					Log.i("ok", "TRANSFERFLOW IC                        ====="
							+ ic);
					// ic =
					// o0 = AnimationUtils.loadAnimation(ctx, R.anim.taptabhop);
					// o0.setDuration(725);

					i0.setMargins((int) (mwidth / 2 - 60) - (20 * ic),
							mheight - 260, 0, 0);

					o0 = new AnimationSet(true);
					o0.setFillAfter(true);

					{
						Animation a8 = new TranslateAnimation(20, 20, -40, -40);
						a8.setFillAfter(true);
						a8.setDuration(1600);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.linear_interpolator));
						// o0.addAnimation(a8);
					}
					{
						Animation a8 = new TranslateAnimation(20, 0, -40, 0);
						a8.setFillAfter(true);
						a8.setDuration(1600);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						o0.addAnimation(a8);
					}
					o0.setDuration(800);

				} else if (ic < 2 * lasty + 3 * lastic
						&& ic > lasty + 3 * lastic) {

					// o0 = AnimationUtils.loadAnimation(ctx,
					// R.anim.taptabhop6);
					// o0.setZAdjustment(Animation.ZORDER_TOP);
					// o0.setDuration(525);
					i0.setMargins((int) (mwidth / 2 - 60) - (20 * (lastic))
							+ (20 * (ic - lasty - lastic * 3)), mheight - 260
							- (40 * (lasty)) + (40 * ic - lasty - lastic * 3),
							0, 0);

				} else if (ic > lasty + lastic && ic < lasty + 3 * lastic) {

					// o0 = AnimationUtils.loadAnimation(ctx,
					// R.anim.taptabhop6);
					// o0.setZAdjustment(Animation.ZORDER_TOP);
					// o0.setDuration(525);
					i0.setMargins((int) (mwidth / 2 - 60) - (20 * (lastic))
							+ (20 * (ic - lasty - lastic)), mheight - 260
							- (40 * (lasty)), 0, 0);
					// if (ic - lasty - lastic == 1) {
					// pbn.bringChildToFront(u4);
					// pbn.bringChildToFront(tips);
					// }

				} else if (ic < lasty + lastic && ic > lastic) {
					Log.i("ok", "TRANSFERFLOW IC                        ====="
							+ ic + " c");

					// u4.startAnimation(o0);

					// o0 = AnimationUtils.loadAnimation(ctx,
					// R.anim.taptabhop7);
					// o0.setDuration(525);
					i0.setMargins((int) (mwidth / 2 - 60) - (20 * (lastic)),
							mheight - 260 - (40 * (ic - lastic)), 0, 0);

					o0 = new AnimationSet(true);
					o0.setFillAfter(true);

					// if (pic + 1 != ic) {
					// Animation a8 = new AlphaAnimation(0f, 1f);
					// a8.setFillAfter(true);
					// a8.setDuration(1600);
					// a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
					// android.R.anim.decelerate_interpolator));
					// o0.addAnimation(a8);
					// }

					{
						Animation a8 = new TranslateAnimation(0, 0, 40, 0);
						a8.setFillAfter(true);
						a8.setDuration(1600);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						o0.addAnimation(a8);
					}
					o0.setDuration(200 + (ic * 275));

				} else if (ic <= lastic) {

					Log.i("ok", "TRANSFERFLOW IC                        ====="
							+ ic + " b");

					i0.setMargins((int) (mwidth / 2 - 60) - (20 * ic),
							mheight - 260, 0, 0);

					// o0 = AnimationUtils.loadAnimation(ctx,
					// R.anim.taptabhop5);
					o0 = new AnimationSet(true);
					o0.setFillAfter(true);

					// if (pic + 1 != ic) {
					// Animation a8 = new AlphaAnimation(0f, 1f);
					// a8.setFillAfter(true);
					// a8.setDuration(1600);
					// a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
					// android.R.anim.decelerate_interpolator));
					// o0.addAnimation(a8);
					// }

					{
						Animation a8 = new TranslateAnimation(20, 0, 0, 0);
						a8.setFillAfter(true);
						a8.setDuration(1600);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.overshoot_interpolator));
						o0.addAnimation(a8);
					}

					{
						Animation a8 = new TranslateAnimation(0, 0, 0, -10);
						a8.setFillAfter(true);// Adjust
						a8.setDuration(400);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.overshoot_interpolator));
						// o0.addAnimation(a8);
					}

					{
						Animation a8 = new TranslateAnimation(0, 0, 0, 10);
						a8.setFillAfter(true);
						a8.setDuration(800);
						a8.setStartOffset(400);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.bounce_interpolator));
						// o0.addAnimation(a8);
					}
					o0.setDuration(225 + (ic * 175));

					// o0.setStartOffset(2370 + ic * o0.getDuration());
					// u4.startAnimation(o0);

				}
				u4.setLayoutParams(i0);

				// u4.setAlpha((int) (255 - (ic < 10 ? ic : 10) * 15));

			}

		}
	};

	// long[] pspotcs;// = new long[pptrack];
	int[] pspot;// = new int[pptrack];
	int[] pbtrack = new int[pptrack];

	void globalCounts() {

		// pspotcs = new long[pptrack];
		pspot = new int[pptrack];
		ImageView u0 = null;
		for (int i = pc; i >= 0; i--) {

			if (pb[i] == null) {
				// Log.i("ok",
				// "##                         ## count empty occured "
				// + i + "     ########################### ");
				continue;
			}

			if (pb[i].containsKey("left") || pb[i].getBoolean("lay", false)) {
				// Log.i("ok", "##                         ## count left/lay " +
				// i
				// + "     ########################### ");
				continue;
			}

			u0 = (ImageView) findViewById(pb[i].getInt("tabfy"));
			if (u0 == null) {
				// Log.w("ok",
				// "##                         ## tabfy image decode m "
				// + i + "  ###############################  "
				// + " thought it was at " + pb[i].getInt("tabfy")
				// + " @" + pb[i].getInt("tabfy_pc"));
				continue;
			}

			if (pspot[pb[i].getInt("ic")] > 0) {
				pspot[pb[i].getInt("ic")]++;
			} else {
				// pspotcs[pb[i].getInt("ic")] = SystemClock.uptimeMillis();
				pspot[pb[i].getInt("ic")] = 1;
			}

		}
	}

	Handler moveService = new Handler() {
		Random c = new Random();

		long cs = 1;
		int ARATE = 1000 / 4;

		public void handleMessage(Message msg) {
			if (upause) {
				Log.i("ok", "MOVE Service shut down");
				return;
			}
			moveService.removeMessages(2);
			if (cs > SystemClock.uptimeMillis()) {
				return;
			}

			cs = SystemClock.uptimeMillis() + ARATE;
			Log.i("ok",
					"##                         ## move Service                       move FIRST       "
							+ msg.what);

			globalCounts();

			ImageView u0 = null;
			boolean dance = false;

			// STAR TRACK POSITIONING
			for (int i = pc; i >= 0; i--) {// i == tabfy_pc
				if (pb[i] == null || pb[i].getInt("ic", -1) != -1) {// already
																	// excised
					continue;
				}
				// if (pb[i].getLong("iccs") > SystemClock.uptimeMillis()) {
				// dance = true;
				// continue;
				// }

				u0 = (ImageView) findViewById(pb[i].getInt("tabfy"));
				if (u0 == null) {
					Log.w("ok",
							"#############################\n##########\n##                 ##\n##                          ##\n##                         ## move tabfy image decode n "
									+ i);
					continue;
				}

				if (!pb[i].getBoolean("lay", false)
						&& !pb[i].containsKey("left")) {
					continue;
				}
				if (u0.getVisibility() == View.INVISIBLE) {
					u0.setVisibility(View.VISIBLE);
					pbn.bringChildToFront(u0);
				}

				{
					AnimationSet a9 = null;
					a9 = new AnimationSet(true);

					if (pb[i].containsKey("left")
							&& !pb[i].getBoolean("lay", false)) {
						Log.i("ok",
								"##                         ## move set not lay "
										+ i + " " + pb[i].getInt("ic"));
						// if (pb[i].getInt("ic") == 0) {// "Light
						// pb[i].putInt("ic", 100);
						Animation a8 = new TranslateAnimation(0f, 0f, mheight,
								0f);
						a8.setFillAfter(true);
						a8.setDuration(1568);

						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						a9.addAnimation(a8);

						a9.setDuration(2200);
						// }

					} else {
						Log.i("ok",
								"##                         ## move not track "
										+ i + " " + pb[i].getInt("ic"));

						// if (pb[i].getInt("ic") == 0) {// "Light
						// pb[i].putInt("ic", 100);

						Animation a8 = new TranslateAnimation(mwidth, 0f, 0f,
								0f);
						a8.setFillAfter(true);
						a8.setDuration(1568);

						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.decelerate_interpolator));
						a9.addAnimation(a8);

						a9.setDuration(2200);
						// }

					}
				}
			}

			// TRACK
			for (int i = pc; i >= 0; i--) {// i == tabfy_pc
				if (pb[i] == null || pb[i].getInt("ic", -1) != -1) {// already
																	// excised
					continue;
				}
				// if (pb[i].getLong("iccs") > SystemClock.uptimeMillis()) {
				// dance = true;
				// continue;
				// }

				u0 = (ImageView) findViewById(pb[i].getInt("tabfy"));
				if (u0 == null) {
					Log.w("ok",
							"#############################\n##########\n##                 ##\n##                          ##\n##                         ## move tabfy image decode j "
									+ i);
					continue;
				}

				if (pb[i].getBoolean("lay", false) || pb[i].containsKey("left")) {
					continue;
				}

				// TRACK
				// if (!pb[i].containsKey("lay") && !pb[i].containsKey("left"))
				// {

				// TWO ON ONE SPACE
				if (pspot[pb[i].getInt("ic")] > 1) {// multiples here
					dance = true;
					Log.w("ok",
							"##                         ## Detected Dancing "
									+ i + " @" + pb[i].getInt("ic") + " #"
									+ pspot[pb[i].getInt("ic")]);
					// continue;
				}

				{
					//
					Log.i("ok",
							"##  ENTER NEW CONTENDER ############################################################## "
									+ i
									+ " @"
									+ pb[i].getInt("ic")
									+ " #"
									+ pspot[pb[i].getInt("ic")] + " of " + pc);

					u0.setVisibility(View.VISIBLE);
					pb[i].putInt("ic", 1);
				}
				// if (pb[i].getInt("ic", -1) == -1) {
				// }

				// o0 = AnimationUtils.loadAnimation(ctx,
				// R.anim.taptabon);
				// o0.setDuration(2568);

				AnimationSet a9 = null;
				a9 = new AnimationSet(true);

				Log.i("ok", "##                         ## move track " + i
						+ " " + pb[i].getInt("ic"));

				// if (pb[i].getInt("ic",0) == 0) {// "Light
				{
					// pb[i].putInt("ic", 1);

					Animation a8 = new ScaleAnimation(0.1f, 1f, 0.1f, 1f,
							u0.getWidth() / 2, u0.getHeight() / 2);

					a8.setFillAfter(true);
					a8.setDuration(1568);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.bounce_interpolator));
					a9.addAnimation(a8);

				}

				{
					Animation a8 = new TranslateAnimation(-1
							* ((mwidth / 2) - 60) + (mwidth / 3), 150f, 0f,
							-240f);
					a8.setFillAfter(true);
					a8.setDuration(1568);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.anticipate_overshoot_interpolator));
					a9.addAnimation(a8);
				}

				{

					Animation a8 = new TranslateAnimation(0f, -150f, 0f, 240f);
					a8.setFillAfter(true);
					a8.setDuration(1068);
					a8.setStartOffset(568);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.overshoot_interpolator));
					a9.addAnimation(a8);
				}
				a9.setDuration(2200);
				// }

				a9.setFillAfter(true);
				// "ic"
				pb[i].putLong("iccs", SystemClock.uptimeMillis() + 2200);
				Log.i("ok", "##                         ## start  " + i + " @"
						+ pb[i].getInt("ic") + " #" + pspot[pb[i].getInt("ic")]);

				u0.startAnimation(a9);

				if (pb[i].getBoolean("lay", false) || pb[i].containsKey("left")) {
					a9 = null;
					// moveService.removeMessages(2);
					// moveService.sendEmptyMessageDelayed(2, 80);
					continue;
				}

				dance = true;
				// Log.i("ok",
				// "##                         ## REQUEST MOTION         (1)    ########################### "
				// + i + " / " + (pc - 1) + " " + a9.getDuration());

				a9 = null;
				if (i < pc - 1) {
					Log.i("ok",
							"##                         ## AUTO FEED NEW RECORD   (2)    ########################### "
									+ i + "/" + (pc - 1));
					moveService.removeMessages(2);
					moveService.sendEmptyMessageDelayed(2, 3880);
				}

				break;
			}

			if (dance) {
				moveAlongService.removeMessages(2);
				moveAlongService.sendEmptyMessageDelayed(2, ARATE);
			}

		}
	};

	Handler moveAlongService = new Handler() {
		Random c = new Random();
		long cs = 1;
		int ARATE = 1000 / 4;

		public void handleMessage(Message msg) {
			if (upause) {
				Log.i("ok",
						"##                         ## MOVE Service shut down");
				return;
			}

			if (msg.what != -5 && cs > SystemClock.uptimeMillis()) {
				return;
			}
			cs = SystemClock.uptimeMillis() + ARATE;

			final int mst = msg.what;
			moveAlongService.removeMessages(2);

			// ].put
			// Thread mu = new Thread() {
			// public void run() {
			// Log.i("ok",
			// "##                         ## MOVE ALONG         (3)    ########################### "
			// + msg.what + " ############################");

			globalCounts();
			boolean dance = false;
			long prebump = 0;
			long prebumpM = 0;

			int[] hitpb = new int[pc + 9];
			ImageView u0 = null;

			for (int i = pc; i >= 0; i--) {

				if (pb[i] == null) {
					continue;
				}
				if (pb[i].containsKey("left") || pb[i].getBoolean("lay", false)) {
					continue;
				}

				if (pb[i].getInt("ic", -1) == -1
						|| pb[i].getInt("tabfy", -1) == -1) {
					continue;
				}

				u0 = (ImageView) findViewById(pb[i].getInt("tabfy"));
				if (u0 == null) {
					// Log.w("ok",
					// "##                         ## tabfy image decode b "
					// + i + "  ############################### "
					// + mst + " thought it was at "
					// + pb[i].getInt("tabfy") + " @"
					// + pb[i].getInt("tabfy_pc"));
					continue;
				}

				if (pb[i].getLong("iccs") > SystemClock.uptimeMillis() + 100) {
					dance = true;
					continue;
				}

				// AnimationSet o0 = null;

				// RelativeLayout.LayoutParams i0 =
				// (RelativeLayout.LayoutParams) u0
				// .getLayoutParams();
				// if (hitpbcs[pb[i].getInt("ic")] > 0) {
				prebump = 0;

				if (hitpb[pb[i].getInt("ic", -1)] != 0) {
					// if (hitpb[pb[i].getInt("ic")] > 0) {
					// hitpb[pb[i].getInt("ic")]++;
					// if (hitpbcs[pb[i].getInt("ic")] >
					// pb[i].getLong("iccs"))
					dance = true;
					// limit

					prebump = ((pb[hitpb[pb[i].getInt("ic", -1)]]
							.getLong("iccs") > SystemClock.uptimeMillis()) ? pb[hitpb[pb[i]
							.getInt("ic", -1)]].getLong("iccs")
							- SystemClock.uptimeMillis() : 0);

					if (prebump < prebumpM || prebumpM == 0) {
						prebumpM = prebump;
					}

					Log.i("ok",
							"##                         ## BUMPEE   (5a)    ########################### "
									+ i + " " + " @" + pb[i].getInt("ic")
									+ " #" + pspot[pb[i].getInt("ic")]
									+ " being BUMPED BY "
									+ hitpb[pb[i].getInt("ic", -1)] + " in "
									+ prebump + " ms" + " "
									+ SystemClock.uptimeMillis() + " "
									+ (prebump > 0 ? "FREE WILL" : "GET IT"));

					// if (prebump > 0) {
					// pb[i].putFloat("scale",
					// 1.2f + (prebump / 1000));
					// continue;
					// } else {
					// pb[i].putFloat("scale", 1f);
					// }

					if (prebump == 0) {

						pb[i].putInt("ic", (pb[i].getInt("ic") + 1));

						Message jm9 = new Message();
						Bundle b8 = new Bundle();
						b8.putInt("pbi", i);
						// b8.putInt("left", fleft);
						// b8.putInt("top", ftop);
						b8.putLong("prebump", prebump);
						// b8.putInt("direction", direction);

						jm9.setData(b8);
						setPut.sendMessageDelayed(jm9, (ARATE / 5)
								+ (i * (ARATE / 15)));
						dance = true;
					}

					// if (direction > 0 && u0 != null && pb[i] != null) {

					// u0.setLayoutParams(i0);

					// Log.i("ok",
					// "##                         ## MOTION DETECTED   (6)    ########################### "
					// + i
					// + " @"
					// + pb[i].getInt("ic")
					// + " #"
					// + (pspot[pb[i].getInt("ic")]));

					// dance = true;
					// }

				} else {

					hitpb[pb[i].getInt("ic")] = i;
					// Log.i("ok",
					// "##                         ## initial record  (4)    ###################### ###################  "
					// + i
					// + " @ "
					// + pb[i].getInt("ic")
					// + " >>>> "
					// + pspot[pb[i].getInt("ic")]);
				}
			}

			for (int i = pc; i >= 0; i--) {

				if (pb[i] == null) {
					continue;
				}
				if (pb[i].containsKey("left") || pb[i].getBoolean("lay", false)) {
					// continue;
				}

				if (pb[i].getInt("ic", -1) == -1) {
					continue;
				}

				u0 = (ImageView) findViewById(pb[i].getInt("tabfy"));
				if (u0 == null) {
					continue;
				}

				if (pb[i].containsKey("uri_data")
						&& pb[i].getLong("uricount", 2) < System
								.currentTimeMillis() - 32 * 999) {
					pb[i].putLong("uricount", System.currentTimeMillis());
					// "count"
					String hk = pb[i].getString("uri_data");
					if (hk.contains("content:")) {
						Cursor k9 = SqliteWrapper.query(ctx,
								getContentResolver(), Uri.parse(hk),
								new String[] { "count(*)" }, null, null, null);
						int c0 = 0;
						if (k9 != null && k9.moveToFirst()) {
							c0 = k9.getCount();
						}
						if (k9 != null) {
							k9.close();
						}

						if (c0 > 0) {

							// if (pb[i].getInt("count", -1) != c0) {
							pb[i].putInt("count", c0);

							Message m0 = new Message();
							Bundle h6 = new Bundle(pb[i]);// i==hx.getInt("tabfy_pc")
							m0.setData(h6);
							m0.what = h6.getInt("tabfy");
							tabfy.sendMessageDelayed(m0, 80 + i * 75);
							// }

						} else if (c0 == 0) {
							Bundle bx9 = new Bundle();
							bx9.putInt("id", u0.getId());
							bx9.putLong("gofor", 5100);

							cmxb[i] = null;
							smxb[i] = null;
							// nmxb[i] = null;
							pb[i] = null;
							Message m9 = new Message();
							m9.setData(bx9);
							pbnImageRemove.sendMessageDelayed(m9, 525);
							continue;
						}
					}

				}

				// if (pb[i].getLong("iccs") >
				// SystemClock.uptimeMillis() + 100)
				// {
				// dance = true;
				// continue;
				// }

				// AnimationSet o0 = null;

				// RelativeLayout.LayoutParams i0 =
				// (RelativeLayout.LayoutParams) u0
				// .getLayoutParams();

				if (pb[i].containsKey("data")) {
					String hk = pb[i].getString("data");
					// I love HK products.
					if (hk.contains("file:")) {
						File u9 = new File(Uri.parse(hk).toString()
								.replaceFirst("file:..", ""));
						if (u9.exists()) {
						} else {

							// file removed
							// o0 = AnimationUtils.loadAnimation(ctx,
							// R.anim.taptabhop8);
							// o0.setDuration(5200);

							// pbnImageRemove.sendEmptyMessageDelayed(
							// u0.getId(), 5100);

							Bundle bx9 = new Bundle();
							bx9.putInt("id", u0.getId());
							// bx9.putInt("anim", R.anim.searchhot);

							pb[i] = null;
							bx9.putLong("gofor", 5100);
							Message m9 = new Message();
							m9.setData(bx9);
							pbnImageRemove.sendMessageDelayed(m9, 539);
							dance = true;
							continue;
						}
					}
				}

				// if (o0 != null) {
				// Log.i("ok",
				// "start u4 animation ========================================== "
				// + i);

				// if (ic < pptrack && ic > 0 && pb[ic + 1] != null
				// && pb[ic] != null) {
				// && pb[ic + 1].getInt("tabfy", -1) != -1) {
				// pb[ic].putLong("cs",
				// SystemClock.uptimeMillis() + o0.getDuration());

				// u0.startAnimation(o0);
				// dance = true;
				// }
				// }

			}

			if (dance) {
				moveAlongService.removeMessages(2);
				moveAlongService.sendEmptyMessageDelayed(-5, ARATE);
				// (prebumpM > 0 && prebumpM < ARATE ? prebumpM
				// : ARATE));
			}

			// }
			// };
			// mu.start();
			// 04 =

		}
	};

	Handler setPut = new Handler() {
		public void handleMessage(Message msg) {
			Bundle hx = msg.getData();
			if (!hx.containsKey("pbi") || hx.getInt("pbi", -1) == -1) {
				return;
			}
			ImageView u9 = (ImageView) findViewById(pb[hx.getInt("pbi", 0)]
					.getInt("tabfy"));
			if (u9 == null) {
				return;
			}

			long prebump = hx.getLong("prebump", 0);
			// int direction = hx.getInt("direction", 1);
			int i = hx.getInt("pbi", 0);

			int lastic = (int) ((mwidth / 2 - 60 - (1 * 20)) / 20);
			int lasty = (int) ((mheight - 60 - (1 * 80)) / 80);

			int direction = -1;
			int ftop = 1;
			int fleft = 1;
			float fscale = pb[i].getFloat("scale", 1f);
			// "count"
			if (pb[i].getInt("ic") == 1) {
				fleft = (int) ((mwidth / 2 - 60) - 20);
				ftop = (int) (mheight - 260);
				// i0.setMargins((int) (mwidth / 2 - 60) -
				// 20,
				// mheight - 260, 0, 0);

				direction = 1;

			} else if (pb[i].getInt("ic") < lastic) {// if
														// (pb[i].getInt("ic")
														// >
														// 1)

				// i0.setMargins((int) (mwidth / 2 - 60)
				// - (20 * (pb[i].getInt("ic"))),
				// mheight - 260, 0, 0);
				fleft = (int) ((mwidth / 2 - 60) - 20 * (pb[i].getInt("ic")));
				ftop = (int) (mheight - 260);

				direction = 2;
			} else if (pb[i].getInt("ic") == lastic) {
				// i0.setMargins(
				// (int) ((mwidth / 2 - 60) - (20 *
				// (lastic))),
				// mheight - 260 - (80), 0, 0);
				fleft = (int) ((mwidth / 2 - 60) - 20 * lastic);
				ftop = (int) (mheight - 260 - 80);

				direction = 3;

			} else if (pb[i].getInt("ic") > lastic
					&& pb[i].getInt("ic") < lasty + lastic) {
				// i0.setMargins(
				// (int) ((mwidth / 2 - 60)
				// - (20 * (lastic)) + ((pb[i]
				// .getInt("ic") - lastic) * 0)),
				// mheight
				// - 260
				// - (80)
				// - ((pb[i].getInt("ic") - lastic) * 10),
				// 0, 0);
				fleft = (int) (((mwidth / 2 - 60) - 20 * lastic) + ((pb[i]
						.getInt("ic") - lastic) * 0));
				ftop = (int) (mheight - 260 - 80 - ((pb[i].getInt("ic") - lastic) * 80));

				// fscale = (float) ((pb[i].getInt("ic")-lastic)* 0.05f);

				direction = 4;

			} else if (pb[i].getInt("ic") >= lasty + lastic
					&& pb[i].getInt("ic") < lasty + lastic * 2) {

				fleft = (int) (((mwidth / 2 - 60) - (20 * lastic) + ((pb[i]
						.getInt("ic") - lastic - lasty + 1) * 80)));
				ftop = (int) (mheight - 260 - 80 - (lasty + lastic) * 80);
				direction = 5;
			}

			// Path n9 = new Path();
			// RectF oval = new RectF();
			// oval.set(90, 90, mwidth - 90, mheight - 90);// CCW
			// n9.addOval(oval, Path.Direction.CCW);

			// n9.addArc(oval, 10f, 296f);

			// n9.cubicTo((int) (mwidth / 2 - 60), (int) (mheight / 2),
			// (int) (mwidth / 2 - 60), (int) (mheight - 260), 60,
			// mheight - 120);

			// Path nb9 = new Path();
			// n9.offset((65 * pb[i].getInt("ic")), 1, nb9);
			// n9.
			// RectF sdf = new RectF();
			// nb9.computeBounds(sdf, true);
			// fleft = (int) sdf.left;
			// ftop = (int) sdf.top;

			// 29
			AnimationSet o0 = null;
			o0 = new AnimationSet(true);
			o0.setFillAfter(true);

			if (direction == 1) {

				{
					Animation a8 = new TranslateAnimation(20, 0, -40, 0);
					a8.setFillAfter(true);
					a8.setDuration(1600);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.overshoot_interpolator));
					o0.addAnimation(a8);
				}
				o0.setDuration(600);
			} else if (direction == 2) {

				{
					Animation a8 = new TranslateAnimation(20, 0, 0, 0);
					a8.setFillAfter(true);
					a8.setDuration(1600);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.overshoot_interpolator));
					o0.addAnimation(a8);
				}

				{

					{
						Animation a8 = new TranslateAnimation(0, 0, 0, -10);
						a8.setFillAfter(true);
						a8.setDuration(600);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.overshoot_interpolator));
						o0.addAnimation(a8);
					}

					{
						Animation a8 = new TranslateAnimation(0, 0, 0, 10);
						a8.setFillAfter(true);
						a8.setDuration(600);
						a8.setStartOffset(900);
						a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
								android.R.anim.bounce_interpolator));
						o0.addAnimation(a8);
					}

				}

				o0.setDuration(600);
			} else if (direction == 3) {
				{
					Animation a8 = new TranslateAnimation(0, 0, 80, 0);
					a8.setFillAfter(true);
					a8.setDuration(1600);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.overshoot_interpolator));
					o0.addAnimation(a8);
				}

				o0.setDuration(600);

			} else if (direction == 4) {
				{
					Animation a8 = new TranslateAnimation(0, 0, 80, 0);
					a8.setFillAfter(true);
					a8.setDuration(1600);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.bounce_interpolator));
					o0.addAnimation(a8);
				}

				o0.setDuration(600);
			} else if (direction == 5) {
				{
					Animation a8 = new TranslateAnimation(80, 0, 0, 0);
					a8.setFillAfter(true);
					a8.setDuration(1600);
					a8.setInterpolator(AnimationUtils.loadInterpolator(ctx,
							android.R.anim.bounce_interpolator));
					o0.addAnimation(a8);
				}

				o0.setDuration(600);

			}

			if (prebump > 0) {
				o0.setStartTime(System.currentTimeMillis() + prebump);

				u9.setAnimation(o0);
				pb[hx.getInt("pbi", 0)].putLong("iccs",
						SystemClock.uptimeMillis() + 600 + prebump);

				Log.i("ok",
						"##                         ## PRE RUN BUMP "
								+ hx.getInt("pbi", -1) + " " + prebump + " "
								+ SystemClock.uptimeMillis());

			} else if (o0 != null) {
				u9.setVisibility(View.VISIBLE);

				o0.setDuration(380);
				u9.startAnimation(o0);
				pb[hx.getInt("pbi", 0)].putLong("iccs",
						SystemClock.uptimeMillis() + 380);
			}

			if (fscale != pb[i].getFloat("scale", -1)) {
				pb[i].putFloat("scale", fscale);

				Message m0 = new Message();
				Bundle h6 = new Bundle(pb[i]);// i==hx.getInt("tabfy_pc")
				m0.setData(h6);
				m0.what = h6.getInt("tabfy");
				tabfy.sendMessageDelayed(m0, 80);
			}
			RelativeLayout.LayoutParams i0 = (RelativeLayout.LayoutParams) u9
					.getLayoutParams();
			i0.setMargins(fleft, ftop, 0, 0);
			u9.setLayoutParams(i0);

			pb[i].putInt("touchx", fleft);
			pb[i].putInt("touchy", ftop);

			if (scanBumpee(i)) {
				Log.i("ok", "########>>>>>>>>>>  POST MOVE BUMP HAPPENED with "
						+ i);
			}

		}
	};

	boolean scanBumpee(int ving) {
		int bb = 0;
		int i = 2;
		if (ving < 0 || ving >= pb.length || pb[ving] == null) {
			return false;
		}

		for (i = pc; i >= 0; i--) {

			if (i == ving || pb[i] == null) {
				continue;
			}

			if ((pb[i].getInt("touchy", 0) + pb[i].getInt("bheight", 90) / 2) - 15 > (pb[ving]
					.getInt("touchy", 0) + pb[ving].getInt("bheight", 90) / 2) - 35
					// -
					&& (pb[i].getInt("touchy", 0) + pb[i].getInt("bheight", 90) / 2) + 95 < (pb[ving]
							.getInt("touchy", 0) + pb[ving].getInt("bheight",
							90) / 2) + 125

					&& (pb[i].getInt("touchx", 0) + pb[i].getInt("bwidth", 90) / 2) - 65 > (pb[ving]
							.getInt("touchx", 0) + pb[ving]
							.getInt("bwidth", 90) / 2) - 85
					// -
					&& (pb[i].getInt("touchx", 0) + pb[i].getInt("bwidth", 90) / 2) + 65 < (pb[ving]
							.getInt("touchx", 0) + pb[ving]
							.getInt("bwidth", 90) / 2) + 85) {

				Log.i("ok", "####### BUMP AWARE " + ving + " is bumping " + i);
				if (ving == ones) {
					twos = i;
				}
				bb++;
			}
		}

		return bb > 0 ? true : false;

	}

	// if (pb[i].getInt("ic", -1) != i) {
	// Log.i("ok",
	// "mismatch occured " + i + " != "
	// + pb[i].getInt("ic", -1));
	// continue;
	// }
	// if (pb[i].getLong("iccs") > SystemClock.uptimeMillis())
	// if (u0.getAnimation() != null) {

	// Log.i("ok",
	// "##                         ## RECORD IN MOTION    (7)   ########################### "
	// + i
	// + " / "
	// + (pc - 1)
	// + " @ "
	// + pb[i].getInt("ic"));
	// moveAlongService.sendEmptyMessageDelayed(2, 880);
	// moveAlongService
	// .sendEmptyMessageDelayed(2,
	// (pb[i].getLong("iccs") - SystemClock
	// .uptimeMillis()));

	// continue;
	// }

	// + (hitpbcs[pb[i].getInt("ic")] -
	// pb[i]
	// .getLong("iccs")) + " @"

	// moveAlongService.removeMessages(2);
	// moveAlongService.sendEmptyMessageDelayed(2,
	// 1880);

	// Bump

	// {
	// Message m0 = new Message();
	// m0.setData(pb[i]);
	// m0.what = i;
	// reviewMove.sendMessageDelayed(m0,
	// 675 + 875 * ic);
	// }

	// pb[i].putLong("iccs", SystemClock.uptimeMillis() +
	// 120);

	// RelativeLayout.LayoutParams i0 = new
	// RelativeLayout.LayoutParams(
	// -2, -2);

	// u0 =

	// pb[i].putLong("iccs",
	// SystemClock.uptimeMillis() + o0.getDuration()
	// + 300);
	// hitpbcs[pb[i].getInt("ic")] = pb[i].getLong("iccs");

	// i0

	// hitpbcs[pb[i].getInt("ic")] = pb[i].getLong("iccs");

	// + " "
	// + (SystemClock.uptimeMillis() - pb[i]
	// .getLong("iccs"))

	// for (int i = msg.what; i >= 0; i--) {

	// u4 = (ImageView) findViewById(pb[i].getInt("tabfy", -1));
	// if (u4 != null) {
	// } else {
	// pb[i] = null;
	// }

	// if (pb[i] == null) {
	// Log.i("ok",
	// "move ALONG                       empty flow       "
	// + msg.what + " " + i + "/");

	// continue;
	// } else if (i > 0 && pb[i - 1] == null) {
	// pp[i + 1] = pp[i];
	// pp[i] = -1;

	// Log.i("ok",
	// "move ALONG                       clean flow       "
	// + msg.what + " " + i + "/" + " <<  "
	// + pb[i].getInt("pic", -1));

	// pb[i - 1] = pb[i];
	// pb[i - 1].putInt("tabfy_pc", i - 1);
	// pb[i - 1].putInt("ic", i - 1);
	// pb[i - 1].putInt("pic", i);
	// pb[i] = null;

	// } else {

	// Log.i("ok",
	// "move ALONG                       move flow       "
	// + msg.what + " " + i + "/" + " <<  "
	// + pb[i].getInt("pic", -1) + " :" + pc);

	// mic = i;
	// pb[i].putInt("pic", pb[i].getInt("ic", ic));
	// pb[i].putInt("ic", ic);

	// Message m0 = new Message();

	// m0.setData(pb[i]);
	// m0.what = i;

	// reviewMove.sendMessageDelayed(m0, 675 + 875 * ic);
	// }
	// ic++;

	// }

	private Handler recordServicec = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service c " + msg.what);
			if (upause) {
				return;
			}
			// File filea = new File(Environment.getExternalStorageDirectory()
			// .getAbsolutePath(), "ok/opt");
			// filea.mkdirs();

			// if (filea.exists()) {

			Date b = new Date();
			String d1 = ""
					+ (b.getYear() + 1900)
					+ ""
					+ (b.getMonth() < 9 ? "0" + (b.getMonth() + 1) : b
							.getMonth() + 1) + ""
					+ (b.getDate() < 10 ? "0" + (b.getDate()) : b.getDate());

			String d2 = ""
					+ (b.getHours() < 10 ? "0" + (b.getHours()) : b.getHours())
					+ "_"
					+ (b.getMinutes() < 10 ? "0" + (b.getMinutes()) : b
							.getMinutes())
					+ "_"
					+ (b.getSeconds() < 10 ? "0" + (b.getSeconds()) : b
							.getSeconds());

			File dir = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath(), "data/" + ctx.getPackageName() + "/"
					+ d1);
			dir.mkdirs();

			String fxh = "wav";
			if (mvix != null) {
				fxh = ".mp4";
			}

			File file4 = new File(
					Environment
							.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),
					"" + getApplication().getString(R.string.app_name));

			File file = null;
			file4.mkdirs();
			if (file4.exists()) {
				file = new File(file4.getAbsolutePath(), d1 + "-" + d2 + "."
						+ fxh);
			} else {
				file = new File(Environment.getExternalStorageDirectory()
						.getAbsolutePath(), "data/" + ctx.getPackageName()
						+ "/" + d1 + "/" + d2 + "." + fxh);
			}

			vsvfiles[vsv] = file.getAbsolutePath();
			{
				Bundle hx = new Bundle();
				hx.putString("data", "file://" + vsvfiles[vsv]);
				Message m9 = new Message();
				m9.setData(hx);
				m9.what = -1;
				tabfy.sendMessageDelayed(m9, 175);
			}

			file = null;
			dir = null;
			d2 = null;
			d1 = null;
			b = null;

			if (u8 != null) {
				u8.setOutputFile(vsvfiles[vsv]);
			}

			recordServiced.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServiced = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service d " + msg.what);
			if (upause) {
				return;
			}
			// ffd = new FileDescriptor();
			// if (u8 == null) {
			// Log.w("ok", "wha sound reset mid process");

			// recordService.sendEmptyMessageDelayed(2, 1880);// u8 = null;
			// return;
			// }

			try {
				if (u8 != null) {

					if (mvix != null) {
						// u8.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
						// u8.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

						Log.i("ok", "record tov " + vsvfiles[vsv]);

					} else {
						Log.i("ok", "record to " + vsvfiles[vsv]);

						u8.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

					}
					recordServicee.sendEmptyMessageDelayed(2, 20);

					return;

				}

			} catch (IllegalStateException eb) {
				if (msg.what != 420) {
					recordServiced.sendEmptyMessageDelayed(420, 75);
				}
				Log.i("ok", "AUDIO " + eb.getMessage());
				eb.printStackTrace();
			}

			// u8.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
			// recordService.sendEmptyMessageDelayed(2, 17880);// u8 = null;

		}
	};

	Handler recordOn = new Handler() {
		public void handleMessage(Message msg) {
			// new ImageView
			Random c = new Random();
			// aheardlist

			File fileg;
			int n9 = 1;
			for (n9 = 0; n9 < vsvfiles.length; n9++) {
				if (vsvfiles[n9] == null) {
					continue;
				}

				fileg = new File(vsvfiles[n9]);
				if (!fileg.exists()) {
					continue;
				}

				ImageView i8 = new ImageView(ctx);
				{
					RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
							-2, -2);
					// t2r.weight = 1;
					// t2r.setMargins((int) (mwidth * 0.9f),
					// (int) (mheight * 0.9f), 0, 0);
					t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
					// t2r.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
					t2r.setMargins((int) (mwidth * (c.nextFloat())), 0, 0, 0);
					i8.setLayoutParams(t2r);
				}

				while (findViewById(++hid) != null) {
				}
				i8.setId(hid);
				i8.setScaleType(ScaleType.FIT_CENTER);
				i8.setImageResource(R.drawable.cloud);
				// i8.setImageURI(Uri.fromFile(bu));
				// fildash =
				// OnClickL
				sparkEasel.addView(i8);

				// "aheardlist"

				// animportlist += Uri.fromFile(bu) + ",";
				Animation oh = AnimationUtils.loadAnimation(ctx,
						R.anim.recordingon);// oomx8
				if (mwidth > mheight) {
					oh.setDuration((int) (17000 + (3880 * 8) * (c.nextFloat())));
				} else {
					oh.setDuration((int) (17000 + (3880 * 4) * (c.nextFloat())));
				}
				// oh.setStartOffset(1880);

				i8.startAnimation(oh);
				recordOnb.sendEmptyMessageDelayed(i8.getId(),
						oh.getDuration() - 10);

				{// solid
					Bundle hx = new Bundle();
					hx.putString("data", "file://" + vsvfiles[vsv]);
					Message m9 = new Message();
					m9.setData(hx);
					m9.what = -1;
					tabfy.sendMessageDelayed(m9, 1775);
				}

			}

		}
	};

	Handler recordOnb = new Handler() {
		public void handleMessage(Message msg) {
			ImageView i9 = (ImageView) findViewById(msg.what);
			if (i9 != null) {
				i9.setVisibility(View.INVISIBLE);
				sparkEasel.removeView(i9);
			}
		}
	};

	private Handler recordServicee = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service e " + msg.what);
			if (upause) {
				return;
			}

			if (u8 != null) {
				try {
					u8.stop();
				} catch (RuntimeException e2) {
					// ignore
					Log.w("ok", "wha n ok " + e2.getMessage());
					// } catch (IllegalStateException e5) {
					// Log.w("ok", "wha c" + e5.getMessage());
				}
			}
			try {
				u8.prepare();
				u8.start();

				// if (ipb != null) {
				// ipb.setImageResource(R.drawable.pbl);
				// }

				{
					recordOn.sendEmptyMessageDelayed(2, 75);
				}

			} catch (IllegalStateException e) {
				Log.w("ok", "wha " + e.getMessage());
				// listeningcs = 1;
				// recordService.sendEmptyMessageDelayed(2, 4880);// u8 = null;
				return;
			} catch (RuntimeException e) {
				Log.w("ok", "wha " + e.getMessage());
				// if (u8 != null) {
				// u8.release();
				// }
				// u8 = null;

				// recordService.sendEmptyMessageDelayed(2, 4880);

				// listeningcs = 1;
				return;
			} catch (IOException e) {
				// listeningcs = 1;
				e.printStackTrace();

				File fileg = new File(vsvfiles[vsv]);
				Log.w("ok",
						"IO Exception: " + e.getMessage() + " "
								+ fileg.getAbsolutePath() + " "
								+ fileg.exists());
				// Toast.makeText(ctx, "Error\n" + e.getMessage(),
				// 1880)
				// .show();

				// recordService.sendEmptyMessageDelayed(2, 1880);// u8 = null;
				return;
			}

			recordServicef.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServicef = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service f " + msg.what);
			if (upause) {
				return;
			}

			Cursor bi = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://" + ctx.getPackageName() + "/moment"),
					new String[] { "rowid", "aheardlist" }, "created > '"
							+ datetime(System.currentTimeMillis() - 300000)
							+ "'", null, null);
			ContentValues a6 = new ContentValues();

			if (bi != null && bi.moveToFirst()) {

				String al = "";
				for (int c2 = 0; c2 < bi.getCount(); c2++) {
					bi.moveToPosition(c2);
					al += bi.getString(1) + ",";
				}

				String[] a5 = al.split(",");
				for (int c4 = 0; c4 < a5.length; c4++) {
					if (a5[c4].length() == 0) {
						continue;
					}
					File iu = new File(Uri.parse(a5[c4]).toString()
							.replaceFirst("file:..", ""));

					if (iu.exists()) {
						a6.put(iu.getAbsolutePath(), true);
						Log.i("ok", "exception " + iu.getAbsolutePath() + " "
								+ a6.containsKey(iu.getAbsolutePath()));

					} else {
						Log.e("ok",
								"MISSING !exception " + iu.getAbsolutePath());
					}
				}

				Log.i("ok", "99.9999             found " + bi.getCount()
						+ " moments w/ " + a6.size() + "exception ," + vsv);

			} else {
				Log.w("ok", "decode 6 b "
						+ (bi == null ? "no cursor" : "no records"));
			}

			if (bi != null) {
				bi.close();
			}
			bi = null;

			// if (cc != 0)
			{

				for (int u9 = 0; u9 < vsvfiles.length && vsvfiles[u9] != null; u9++) {

					File file = new File(vsvfiles[u9]);
					if (file.exists() && u9 != vsv
							&& !a6.containsKey(file.getAbsolutePath())) {
						int dgg = (int) (System.currentTimeMillis() - file
								.lastModified());

						// markService =
						if (System.currentTimeMillis() - file.lastModified() > reg
								.getInt("minhistory", 45000)) {

							Log.i("ok", "99.9999                 removing "
									+ file.getAbsolutePath() + "  (" + dgg
									+ ")");
							file.delete();
							vsvfiles[u9] = "";
						}

					}
					file = null;
				}
			}

		}
	};

	public String datetime(long xe) {

		String g = "";
		Date d = new Date(xe);
		g = (d.getYear() + 1900) + "-" + ((d.getMonth() < 9) ? "0" : "")
				+ ((d.getMonth() + 1)) + "-" + ((d.getDate() < 10) ? "0" : "")
				+ d.getDate() + " " + ((d.getHours() < 10) ? "0" : "")
				+ d.getHours() + ":" + ((d.getMinutes() < 10) ? "0" : "")
				+ d.getMinutes() + ":" + ((d.getSeconds() < 10) ? "0" : "")
				+ d.getSeconds();

		// Log.i(G, "generated date " + g);
		return g;
	}

	private Handler aplace = new Handler() {
		public void handleMessage(Message msg) {

			Log.i("ok", "99.9999                 Location Recording "
					+ msg.what);
			aplace.removeMessages(msg.what);
			Bundle hx = msg.getData();

			// if (smx > 0) {
			// Log.i("ok", "aplace rest");
			// Bundle bl = new Bundle(hx);
			// Message ml = new Message();
			// ml.setData(bl);
			// aplace.sendMessageDelayed(ml, 280);

			// return;
			// }

			Uri xu = Uri.parse(hx.getString("row"));
			if (hx == null || hx.getString("row") == null) {
				Log.i("ok", "no known row m");
				return;
			}
			ContentValues e = new ContentValues();

			try {
				// Log.i("ok", "goto gpslink b");

				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);
				if (labb != 1f || lobb != 1f || ldbb != 1f) {
					Log.i("ok", "aplace using saved location ");
					e.put("lat", labb);
					e.put("lon", lobb);
					e.put("adeep", ldbb);
					e.put("acontent", labb + "," + lobb);
				}

				// if (st4map != null) {
				// Log.i("ok", "aplace including amap " + st4map.size());
				// e.put("amap", st4map.toByteArray());
				// }
			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha c " + sf.getMessage());
			} finally {
				storeContent(xu, e);
				// SqliteWrapper.update(
				// ctx,
				// ctx.getContentResolver(),
				// Uri.parse("content://" + ctx.getPackageName()
				// + "/moment"), e,
				// ROWID + "=" + xu.getLastPathSegment(), null);

				e = null;
				xu = null;
			}

		}
	};

	Handler animport = new Handler() {
		public void handleMessage(Message msg) {

			Bundle hx = msg.getData();
			Uri xu = Uri.parse(hx.getString("row"));
			if (hx == null || hx.getString("row") == null) {
				Log.i("ok", "no known row n");
				return;
			}
			Log.i("ok", "99.9999                    Content Import " + msg.what
					+ " " + xu.toString());

			if (animportlist.length() > 0) {

				storeContent(xu, "animportlist", animportlist);

				xu = null;
			}
			hx = null;

		}
	};

	final static String ROWID = "rowid";// _id
	boolean packau = false;

	private Handler aheard = new Handler() {
		public void handleMessage(Message msg) {

			Bundle hx = msg.getData();
			if (hx == null || hx.getString("row") == null) {
				Log.i("ok", "no known row b");
				return;
			}
			Uri xu = Uri.parse(hx.getString("row"));
			Log.i("ok", "99.9999                    Media Recording "
					+ msg.what + " " + xu.toString());

			String ax = "";
			File fileg;
			int c = 1;
			for (c = 0; c < vsvfiles.length; c++) {
				if (vsvfiles[c] == null) {
					continue;
				}

				fileg = new File(vsvfiles[c]);
				// Log.i("ok",
				// "heard xxx " + c + ": " + vsvfiles[c] + " "
				// + fileg.exists());

				if (fileg.exists()) {
					if ((int) (System.currentTimeMillis() - fileg
							.lastModified()) < 5 * 60000) {
						Log.i("ok", "heard xxx " + c + ": INCLUDING "
								+ vsvfiles[c]);

						ax += vsvfiles[c] + ",";
					}
				}
			}// 1:11 PM veggie fried rice w/ side shrimp and lobster sauce or
				// sweet and sour pork
				// Log.i("ok", "heard " + ax);
			// monkey("heard " + c);
			// "aheardlist", ax
			storeContent(xu, "aheardlist", ax);
			countTrack(xu);

			ax = null;

			// recordService.sendEmptyMessageDelayed(2, 7000);
			// edt.putString("aheardlist", ax);
			// edt.commit();

		}
	};

	void storeContent(Uri xu, ContentValues e8) {

		int cc = SqliteWrapper.update(ctx, ctx.getContentResolver(), xu, e8,
				ROWID + "=" + xu.getLastPathSegment(), null);

		Log.i("ok", "+++++++++++++++++++++++++ Store Content updated " + cc
				+ " (" + e8.size() + ") " + xu.toString());

		e8 = null;
		xu = null;
	}

	void storeContent(Uri xu, String col, String vl) {

		Message ml = new Message();
		Bundle bl = new Bundle();
		bl.putString("coll", col);
		bl.putString("colv", vl);
		bl.putString("row", xu.toString());
		ml.setData(bl);
		storeContent.sendMessageDelayed(ml, 75);
	}

	Handler storeContent = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bx = msg.getData();
			ContentValues e = new ContentValues();

			try {
				Uri xu = Uri.parse(bx.getString("row"));
				e.put(bx.getString("coll"), bx.getString("colv"));
				Log.i("ok",
						"++++++++++++++++++++++++++++ Store Content "
								+ bx.getString("coll") + "("
								+ bx.getString("colv") + ") " + xu.toString());
				SqliteWrapper.update(
						ctx,
						ctx.getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/moment"), e,
						ROWID + "=" + xu.getLastPathSegment(), null);

				e = null;
			} catch (OutOfMemoryError ji) {
				Log.i("ok", "OOM ji");
				ji.printStackTrace();
			}

			// xu = null;
			// vl = null;

		}
	};

	void countTrack(Uri xu) {
		Message u9 = new Message();
		Bundle b9 = new Bundle();
		b9.putString("data", xu.toString());
		u9.setData(b9);
		countTrack.sendMessageDelayed(u9, 75);
	}

	Handler countTrack = new Handler() {
		public void handleMessage(Message msg) {
			Bundle i9 = msg.getData();

			Uri xu = Uri.parse(i9.getString("data"));

			Cursor bn;
			bn = SqliteWrapper.query(ctx, ctx.getContentResolver(), xu,
					new String[] { "aheardlist", "rowid" }, null, null, null);

			String aheardlist = "";
			if (bn != null && bn.moveToFirst()) {
				aheardlist = bn.getString(0);
			}
			if (bn != null) {
				bn.close();
				bn = null;
			}
			Log.i("ok", "count Track image canvas " + xu.toString() + " ("
					+ aheardlist + ")");

			android.graphics.Paint u8 = new android.graphics.Paint();
			android.graphics.Paint u9 = new android.graphics.Paint();
			u9.setColor(Color.argb(230, 170, 102, 204));
			u9.setStrokeWidth(3f);
			// ic.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
			// Log.i("ok", "aheard " + aheardlist);
			if (aheardlist.length() > 0) {
				File apng;

				try {
					Bitmap ia = BitmapFactory.decodeResource(getResources(),
							R.drawable.ic_menu_play_clip);

					Bitmap ib = Bitmap.createBitmap(ia.getWidth(),
							ia.getHeight(), Bitmap.Config.ARGB_8888);
					Canvas ic = new Canvas(ib);

					u8.setAlpha(150);
					ic.drawBitmap(ia, 0, 0, u8);

					String[] hx6 = aheardlist.split(",");
					int c9 = 0;
					for (int c6 = 0; c6 < hx6.length; c6++) {
						apng = new File(hx6[c6]);
						Log.i("ok",
								"draw aheard " + hx6[c6] + " " + apng.exists());

						if (apng.exists()) {
							u9.setColor(my9[c6]);
							ic.drawLine(14 + 4 * c9, 11 + (int) (c9 * 2.5f),
									14 + 4 * c9, ia.getHeight() - 11
											- (int) (c9 * 2.5f), u9);
							c9++;

						}

					}

					u8.setAlpha(50);
					ic.drawBitmap(ia, 0, 0, u8);

					// postInvalidate

					// ic.drawText("" + ax.split(",").length, 3, 3, u9);//
					// ia.getHeight()
					// - u9.getTextSize() - 2, u9);

					File filev = new File(Environment
							.getExternalStorageDirectory().getAbsolutePath(),
							"data/" + ctx.getPackageName() + "/" + myDay());
					filev.mkdirs();

					File filea = new File(filev.getAbsolutePath(), "play_"
							+ xu.getLastPathSegment() + ".png");

					FileOutputStream o9;
					o9 = new FileOutputStream(filea);
					ByteArrayOutputStream st;
					st = new ByteArrayOutputStream();
					if (st != null) {
						ib.compress(CompressFormat.PNG, 0, st);
						o9.write(st.toByteArray());
					}
					o9.close();
					// ContentValues e9 = new ContentValues();
					if (filea.exists()) {
						// e9.put("pres", Uri.fromFile(filea).toString());
						storeContent(xu, "pres", Uri.fromFile(filea).toString());
					}
					// mxx =
					// SqliteWrapper.update(
					// ctx,
					// ctx.getContentResolver(),
					// Uri.parse("content://" + ctx.getPackageName()
					// + "/moment"), e9,
					// ROWID + "=" + xu.getLastPathSegment(), null);

					// e9 = null;
					xu = null;
					filea = null;
				} catch (FileNotFoundException eg3) {
					Log.i("ok", "wha io e 14b ");// e.printStackTrace();
				} catch (IOException eg5) {
					Log.i("ok", "wha io e 15b ");// e.printStackTrace();
				} catch (OutOfMemoryError ji4) {

					Log.i("ok", "OOM decode u " + ji4.getMessage());
				}

			}
			// e.put("pres", value)//put("mres
		}
	};

	SensorManager som = null;
	private Handler sensorSurvey = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                       sensor survey ");
			if (upause) {
				return;
			}

			try {
				som = (SensorManager) ctx.getSystemService(SENSOR_SERVICE);
			} finally {
			}

			List<Sensor> hs = som.getSensorList(Sensor.TYPE_ALL);
			for (int h = 0; h < hs.size(); h++) {
				Sensor uk = hs.get(h);
				som.registerListener(sor, uk, SensorManager.SENSOR_DELAY_GAME);
				Log.i("ok", "survey " + uk.getName() + " " + uk.getType());
				uk = null;
			}
			hs = null;

			// som = null;
			// final Bundle bdl = msg.getData();
			// Log.i("ok", "sensorService good xxxx");

			// if (running) {
			// return;
			// }

			// running = true;
			// Thread tx = new Thread() {
			// boolean mStable = true;
			// int position = 0;
			// float[] lastvalues;
			// long smooth = 34;// long smoothtext = 32;//String cn = "";

			// public void run() {

			// som.registerListener(sor,
			// som.getDefaultSensor(SensorManager.SENSOR_TEMPERATURE),
			// SensorManager.SENSOR_DELAY_GAME);

			// som.registerListener(sor,
			// som.getDefaultSensor(SensorManager.SENSOR_ORIENTATION),
			// SensorManager.SENSOR_DELAY_GAME);

			// }
			// };
			// tx.start();

		}
	};

	private SensorEventListener sor = new SensorEventListener() {

		public void onAccuracyChanged(Sensor arg0, int arg1) {

		}

		public void onSensorChanged(SensorEvent event) {
			if (upause) {
				som.unregisterListener(sor, event.sensor);
				return;
			}

			{
				Bundle bx = new Bundle();
				bx.putString("provider", event.sensor.getName());
				bx.putInt("accuracy", event.accuracy);
				bx.putFloatArray("values", event.values);
				bx.putInt("hw", event.sensor.getType());
				Message ml = new Message();
				ml.setData(bx);
				sori.sendMessageDelayed(ml, 2);
				bx = null;
				ml = null;
			}

		}

	};
	long atrot = 1;
	boolean rota = false;

	public Handler sori = new Handler() {
		// float[] ju = { 1f, 1f, 1f };
		float[][] jx = new float[50][];
		long[] jxc = new long[50];
		int[] jxr = new int[50];
		long cu = 1;
		long holdcu = 1;
		// ImageView jh;
		long laycu = 1;
		// int rans = 1;
		int ori = 3;
		int oris = 1;
		float ntrot = 0;
		long bigcs = 1;
		long vtwrote = 1;
		android.graphics.Paint paint6, paint5, paint7, paint8;
		float vtmin = 1f;

		// Animation oh90
		// MapView xmm;

		// MapController xui;

		public void handleMessage(Message msg) {
			// if (xmm == null) {
			// xmm = (MapView) findViewById(R.id.cmapb);
			// xui = xmm.getController();
			// }
			Bundle hx = msg.getData();

			String provider = hx.getString("provider");
			int accuracy = hx.getInt("accuracy");
			float[] bu = hx.getFloatArray("values");
			int hardwaretype = hx.getInt("hw");

			hx = null;

			if (bu != null && bu.length != 3 && bu.length > 0) {
				bu = new float[] { bu[0], 0f, 0f };
			}

			if (upause) {
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					som.unregisterListener(sor, h);
				}
				h = null;
				Log.i("ok", provider + " pause");
				return;
			}

			if (bu != null && bu.length == 3) {

			} else {
				Log.w("ok", provider + "(" + accuracy + "," + hardwaretype
						+ ")" + " " + (bu != null ? bu.length : ""));
				return;
			}

			if (jx[hardwaretype] == null || jx[hardwaretype].length == 0) {
				jx[hardwaretype] = new float[] { 0f, 0f, 0f };
			}

			float d2x = jx[hardwaretype][2] - bu[2];
			float d1x = jx[hardwaretype][1] - bu[1];
			float d0x = jx[hardwaretype][0] - bu[0];

			float r2 = bu[2] < 0 ? bu[2] * -1 : bu[2];
			float r1 = bu[1] < 0 ? bu[1] * -1 : bu[1];
			float r0 = bu[0] < 0 ? bu[0] * -1 : bu[0];

			float d2 = jx[hardwaretype][2] > bu[2] ? jx[hardwaretype][2]
					- bu[2] : bu[2] - jx[hardwaretype][2];
			float d1 = jx[hardwaretype][1] > bu[1] ? jx[hardwaretype][1]
					- bu[1] : bu[1] - jx[hardwaretype][1];
			float d0 = jx[hardwaretype][0] > bu[0] ? jx[hardwaretype][0]
					- bu[0] : bu[0] - jx[hardwaretype][0];

			jx[hardwaretype] = bu;
			jxr[hardwaretype]++;

			if (jxc[hardwaretype] > System.currentTimeMillis() + 21320) {

				relist.sendEmptyMessageDelayed(hardwaretype, 3000);
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					som.unregisterListener(sor, h);
				}
				h = null;
				return;
			}

			if (jxc[hardwaretype] > System.currentTimeMillis()) {
				return;
			}

			if (jxc[hardwaretype] < System.currentTimeMillis() - 30000
					&& jxc[hardwaretype] > 0) {

				relist.sendEmptyMessageDelayed(hardwaretype, 3000);
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					Log.w("ok", provider + "(    " + hardwaretype + "    "
							+ ori + "," + oris + ") " + (h.getPower())
							+ "             " + bu[0] + "(" + d0x + ") "
							+ bu[1] + "(" + d1x + ") " + bu[2] + "(" + d2x
							+ ")");
					som.unregisterListener(sor, h);
				}
				h = null;
				jxc[hardwaretype] = System.currentTimeMillis() + 30000;
				return;
				// relist.sendEmptyMessageDelayed(hardwaretype,
				// jxc[hardwaretype]
				// - System.currentTimeMillis());

			}

			// if (smx > 0 || !viewapp_map || actwin >
			// System.currentTimeMillis()) {
			// Log.i("ok", " super off");
			// jxc[hardwaretype] = System.currentTimeMillis()
			// + ((actwin - System.currentTimeMillis()) / 2);
			// Log.i("ok", provider + " rest for action " + smx);
			//
			// relist.sendEmptyMessageDelayed(hardwaretype, 1880);
			// Sensor h = som.getDefaultSensor(hardwaretype);
			// if (h != null) {
			// som.unregisterListener(sor, h);
			// }
			// h = null;
			//
			// return;
			// }
			//
			//
			//
			//
			//
			//
			//
			//

			if (rota
					&& hardwaretype == android.hardware.Sensor.TYPE_ACCELEROMETER) {
				//
				//
				// sets ori 2, oris 1
				//
				jxc[hardwaretype] = System.currentTimeMillis() + 1000 / 64;
				// vr =

				// vr.restore();
				// vt =

				// nalls

				if (mwidth > mheight) {
					// status: rarely
					ntrot = ((bu[1]) * 10f);
				} else {
					if (r0 > r2) {
						if (bu[0] > 0) {
							ntrot = ((bu[0] + bu[1] * -1 + bu[2]) * -10f);
						} else {
							ntrot = ((bu[0] + bu[1] + bu[2] * -1) * -10f);
						}
					} else {
						ntrot = ((bu[0]) * -10f);
					}
				}

				if (vtwrote < System.currentTimeMillis()) {
					vtwrote = System.currentTimeMillis() + 3000;
					Log.i("ok", "rotate alls and smart sparks " + (d0x * 10f)
							+ ", " + (bu[0] * 10f) + " " + bu[0] + "(" + d0x
							+ ") " + bu[1] + "(" + d1x + ") " + bu[2] + "("
							+ d2x + ") " + atrot + "->" + ntrot + ":" + vtmin);
				}

				//
				if (r0 > 1 && (int) atrot != (int) ntrot) {

					if (atrot - ntrot > vtmin || atrot - ntrot < -1 * vtmin) {

						// for (int x = 0; x < nalls.length; x++) {
						// if (nalls[x] == null) {
						// continue;
						// }

						// balls[x].drawColor(Color.argb(100, 0, 0, 20),
						// PorterDuff.Mode.CLEAR);

						// balls[x].rotate(atrot - ntrot,
						// (int) (balls[x].getWidth() / 2) - 1,
						// (int) (balls[x].getHeight() / 2) - 3);
						// balls[x].drawBitmap(nalls[x], 0, 0, ph8);
						// balls[x].save();
						// jh = (ImageView) findViewById(halls[x]);
						// jh.postInvalidate();
						// }
						// atrot = ntrot;
						// ew
						jxc[hardwaretype] = System.currentTimeMillis() + 1000 / 16;
						if (d0 > 15f) {
							vtmin = 0.001f;
						} else if (d0 < 15) {
							vtmin += 0.05f;
						}

					} else {
						jxc[hardwaretype] = System.currentTimeMillis() + 1000 / 8;
					}
				}

				// if (vt == null) {
				// b4update = System.currentTimeMillis();
				// return;
				// }
				// vt =
				// turntop = Bitmap.createBitmap(mwidth,
				// mheight,
				// Bitmap.Config.ARGB_8888);
				// vt.restoreToCount(vtstart);
				// vt.rotate(0, vt.getWidth() / 2,
				// vt.getHeight() / 2);

				// vt.drawPath(hbpathL, paint6);
				// xmmd.setImageBitmap(turndetail);
				// xmmi.postInvalidate();

				// vr
				// xmme.setImage

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_PROXIMITY) {

				if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f) {
					Log.w("ok", provider + " " + bu[0] + "(" + d0x + ") "
							+ bu[1] + "(" + d1x + ") " + bu[2] + "(" + d2x
							+ ")");
					// xmmishow.sendEmptyMessageDelayed(2, 10);//
					// xmmi.setVisibility(View.VISIBLE);
					// refreshLocation.sendEmptyMessageDelayed(2, 20);

					// sparkMachine.sendEmptyMessageDelayed(2, 10);
					jxc[hardwaretype] = System.currentTimeMillis() + 30000;
					// History
				}

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_GYROSCOPE) {
				jxc[hardwaretype] = System.currentTimeMillis() + 3000;

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < System.currentTimeMillis()) {

				Log.w("ok", provider + " " + bu[0] + "(" + d0x + ") " + bu[1]
						+ "(" + d1x + ") " + bu[2] + "(" + d2x + ")");
				// xmmishow.sendEmptyMessageDelayed(2, 10);//
				// xmmi.setVisibility(View.VISIBLE);
				// }

				// sparkMachine
			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_ORIENTATION) {
				jxc[hardwaretype] = System.currentTimeMillis() + 3000;

				// if (d2 > 40f || d1 > 40f || d0 > 40f) {
				// xmmishow.sendEmptyMessageDelayed(2, 10);//
				// xmmi.setVisibility(View.VISIBLE);
				// jxc[hardwaretype] = System.currentTimeMillis() + 1000;
				// }

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_LIGHT) {

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < System.currentTimeMillis()) {
				// }
				jxc[hardwaretype] = System.currentTimeMillis() + 30000;

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_PRESSURE) {

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < System.currentTimeMillis()) {

				// }
				jxc[hardwaretype] = System.currentTimeMillis() + 30000;

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_TEMPERATURE) {
				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < System.currentTimeMillis()) {

				// }
				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }
				jxc[hardwaretype] = System.currentTimeMillis() + 30000;

			} else if (bu != null
					&& bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_MAGNETIC_FIELD) {
				jxc[hardwaretype] = System.currentTimeMillis() + 30000;

				// if (d2 > 70f || d1 > 70f || d0 > 70f) {
				// }

				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }
			} else {
				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }

				if (jxc[hardwaretype] < System.currentTimeMillis()) {
					jxc[hardwaretype] = System.currentTimeMillis() + 30000;
					Log.w("ok", provider + "            (" + accuracy + ","
							+ hardwaretype + ")" + " "
							+ (bu != null ? bu.length : "") + ": " + bu[0]
							+ "(" + d0x + ") " + bu[1] + "(" + d1x + ") "
							+ bu[2] + "(" + d2x + ")");
				}
			}

		}
	};

	private Handler relist = new Handler() {
		public void handleMessage(Message msg) {
			// Log.i("ok", "99.9999                         relist " +
			// msg.what);
			relist.removeMessages(msg.what);
			if (upause) {
				return;
			}
			if (smx != 0) {

				relist.sendEmptyMessageDelayed(msg.what, 3500);
				return;
			}

			Sensor uk = som.getDefaultSensor(msg.what);
			som.registerListener(sor, uk, SensorManager.SENSOR_DELAY_GAME);
		}
	};
	LocationManager mLocator;
	private Handler gpslink = new Handler() {
		double labb = 1;
		double lobb = 1;

		// double ldbb = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              global positioning service "
					+ msg.what);
			if (upause) {
				return;
			}
			try {

				labb = (double) reg.getFloat("lat", 1f);
				lobb = (double) reg.getFloat("lon", 1f);
				// ldbb = (double) reg.getFloat("adeep", 1f);

				mLocator = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				if (mLocator != null) {
					Criteria criteria = new Criteria();
					criteria.setAccuracy(Criteria.ACCURACY_COARSE);
					mLocator.requestLocationUpdates(
							mLocator.getBestProvider(criteria, true), 5 * 1000,
							1, mLocationListener, getMainLooper());
					criteria = null;
				}

				if (mLocator != null) {
					Criteria criteria = new Criteria();
					criteria.setAccuracy(Criteria.ACCURACY_FINE);
					mLocator.requestLocationUpdates(
							mLocator.getBestProvider(criteria, true), 5 * 1000,
							1, mFineLocation, getMainLooper());
					criteria = null;
				}

				if (labb == 1f && lobb == 1f && labb == 1f) {
					// LocationManager mkk = (LocationManager)
					// getSystemService(Context.LOCATION_SERVICE);
					Location l = mLocator
							.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					if (l == null) {
						l = mLocator
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
					}
					if (l != null) {
						edt.putFloat("lat", (float) l.getLatitude());
						edt.putFloat("lon", (float) l.getLongitude());
						edt.putFloat("adeep", (float) l.getAccuracy());
						edt.putLong("adeepset", System.currentTimeMillis());
						try {
							edt.commit();
						} catch (OutOfMemoryError sf) {
							Log.w("ok", "wha xxx " + sf.getMessage());
						}

					}
					l = null;
					// labb = (double) reg.getFloat("lat", 1f);
					// lobb = (double) reg.getFloat("lon", 1f);
					// ldbb = (double) reg.getFloat("adeep", 1f);
					// refreshed = true;
				}//
			} catch (IllegalArgumentException nj) {
				Log.w("ok", "wah " + nj.getMessage());
			}
		}
	};

	private LocationListener mFineLocation = new LocationListener() {
		public void onLocationChanged(Location location) {
			if (location != null) {
				SharedPreferences reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				Editor edt = reg.edit();
				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);

				if ((labb != location.getLatitude() && lobb != location
						.getLongitude()) || ldbb < location.getAccuracy()) {
					edt.putFloat("lat", (float) location.getLatitude());
					edt.putFloat("lon", (float) location.getLongitude());
					edt.putFloat("adeep", (float) location.getAccuracy());
					edt.putLong("adeepset", System.currentTimeMillis());
					edt.commit();
				}
				reg = null;
				edt = null;
			}
		}

		public void onProviderDisabled(String provider) {
			Log.w("ok", "GPS FPROVIDER GONE " + provider);
		}

		public void onProviderEnabled(String provider) {
			Log.w("ok", "GPS FPROVIDER HERE " + provider);
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);

			mLocator.requestLocationUpdates(
					mLocator.getBestProvider(criteria, true), 5 * 1000, 1,
					mLocationListener, getMainLooper());
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.w("ok", "GPS PROVIDER STATUS " + provider + " " + status);

		}
	};

	private LocationListener mLocationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			if (location != null) {
				Log.w("ok",
						"GPS Listener " + location.getAltitude() + ","
								+ location.getLatitude() + ","
								+ location.getLongitude() + ","
								+ location.getTime() + ","
								+ location.getAccuracy() + ","
								+ location.getSpeed() + ","
								+ location.getProvider() + "");
				// if (reg == null) {
				SharedPreferences reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				Editor edt = reg.edit();
				// }

				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);

				if ((labb != location.getLatitude() && lobb != location
						.getLongitude()) || ldbb < location.getAccuracy()) {
					edt.putFloat("lat", (float) location.getLatitude());
					edt.putFloat("lon", (float) location.getLongitude());
					edt.putFloat("adeep", (float) location.getAccuracy());
					edt.putLong("adeepset", System.currentTimeMillis());

					try {
						edt.commit();
					} catch (OutOfMemoryError hm) {
						Log.w("ok", "mem bh " + hm.getMessage());
					}
				}
				edt = null;
				reg = null;
				// refreshLocation.sendEmptyMessageDelayed(2, 20);
			}
		}

		public void onProviderDisabled(String provider) {
			Log.w("ok", "GPS PROVIDER GONE " + provider);
		}

		public void onProviderEnabled(String provider) {
			Log.w("ok", "GPS PROVIDER HERE " + provider);
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_COARSE); // Faster,
															// no
															// GPS
															// fix.
			// criteria.setAccuracy(Criteria.ACCURACY_FINE); // More
			// accurate, GPS fix.
			// You can specify the time and distance between
			// location updates.
			// Both are useful for reducing power requirements.
			mLocator.requestLocationUpdates(
					mLocator.getBestProvider(criteria, true), 5 * 1000, 1,
					mLocationListener, getMainLooper());
			criteria = null;
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.w("ok", "GPS PROVIDER STATUS " + provider + " " + status);

		}
	};
	Handler pssoff = new Handler() {
		public void handleMessage(Message msg) {

			if (psscs < System.currentTimeMillis() - 200
					&& pss.getVisibility() == View.VISIBLE) {
				Animation oh = AnimationUtils
						.loadAnimation(ctx, R.anim.progoff);// oomx8
				pss.startAnimation(oh);
				psscs = System.currentTimeMillis() + oh.getDuration() - 40;
				pssoffb.sendEmptyMessageDelayed(2, oh.getDuration() - 20);
				oh = null;
			}

		}
	};

	Handler pssoffb = new Handler() {
		public void handleMessage(Message msg) {

			pssProg.removeMessages(2);
			if (psscs < System.currentTimeMillis()) {
				pss.setVisibility(View.INVISIBLE);
				pss.setBackgroundColor(my9[(new Random().nextInt(9))]);
			}

		}
	};
	Uri lxuri;
	public Handler operationsPunctuation = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			Log.i("ok",
					"=                              =\n=                              =\n=                              =\n=                              =\n=                              =\n99.9999                   Operations Punctionion, Define Spark "
							+ msg.what
							+ " ("
							+ (actwin > System.currentTimeMillis() ? "pending "
									+ (actwin - System.currentTimeMillis())
									: "ready since "
											+ (System.currentTimeMillis() - actwin))
							+ ")");

			Bundle hx = msg.getData();
			operationsPunctuation.removeMessages(msg.what);
			// actwin =
			if (hx == null || xuri == null) {
				Log.w("ok", "99.9999                  WHA punc      super");
				return;
			}
			if (cs > SystemClock.uptimeMillis()) {
				return;
			}

			if (actwin > System.currentTimeMillis()) {
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.what = 2;
				ml.setData(bx);
				operationsPunctuation.sendMessageDelayed(ml, 820);
				hx = null;
				return;
			}

			if (smx == 0) {
				Log.w("ok",
						"smx empty ==================== 0000000000000000000000");
				return;
			}
			cs = SystemClock.uptimeMillis() + ADURATION;
			actwin = System.currentTimeMillis() + ADURATION;
			lxuri = xuri;
			xuri = null;
			int duration = hx.getInt("duration", 880);

			Log.i("ok",
					"================================================\n"
							+ "Operations Punctuation "
							+ msg.what
							+ " "
							+ lxuri.toString()
							+ " ============================\n"
							+ "================================================\n");
			{

				// atitle SqliteWrapper.query
				// SqliteWrapper.update(ctx, ctx.getContentResolver(),
				// Uri.parse("content://com.docchomps.ok/moment"), gi,
				// "_id=" + xuri.getLastPathSegment(), null);
				Cursor k = SqliteWrapper.query(
						ctx,
						getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/moment"), new String[] { ROWID, "atitle" },
						ROWID + "=" + lxuri.getLastPathSegment(), null, null);

				int aid = -1;
				if (k != null && k.moveToFirst()) {
					aid = k.getInt(0);
				}

				if (k != null) {
					k.close();
				}

				if (!lxuri.toString().contentEquals(
						Uri.parse(
								"content://" + ctx.getPackageName()
										+ "/moment/" + aid).toString())) {
					Log.w("ok",
							"Proposed content URI failed to be foremd from "
									+ aid);
				}

				if (hx != null && hx.getString("row") != null
						&& !lxuri.toString().contentEquals(hx.getString("row"))) {
					Log.w("ok", "slice between early v          999");
					return;
				}

				if (gpd == null) {
					Log.w("ok", "slice between early b          999");
					return;
				}

			}

			// Uri xu = Uri.parse(hx.getString("row"));

			// Keep
			Log.i("ok", "operationsPunctuation " + System.currentTimeMillis());
			// b88 = null;
			// dingoSparkInactive.removeMessages(2);
			// dingoSparkInactive.sendEmptyMessageDelayed(2, anoob.getDuration()
			// + 3500
			// - anhib.getDuration());

			// displayLocation.removeMessages(2);
			// displayLocation.sendEmptyMessageDelayed(2, 20);

			// Bundle hu4 = new Bundle(hx);
			// Message mi = new Message();
			// mi.setData(hu4);
			// mi.what = 2;
			// ob.setStartOffset(220);
			// oopla.removeMessages(2);
			// oopla.sendMessageDelayed(mi, ob.getDuration());
			// Animation ob = AnimationUtils.loadAnimation(ctx, R.anim.oob);
			// if (ipb != null) {
			// ipb.startAnimation(ob);
			// ipbcs = System.currentTimeMillis() + ob.getDuration();
			// }
			int gvsv = vsv;
			// indrawing = false;
			// gxf.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
			// gxfx.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
			// gxfx = null;
			// gxf = null;

			// FINE

			{
				// smartSparkService.removeMessages(5);

				// smartSpark.removeMessages(2);
				// smartSpark.sendEmptyMessageDelayed(2, 10);
			}

			// ballson++;
			// if (ballson >= falls.length) {
			// ballson = 0;
			// }
			// ballsdeep.sendEmptyMessageDelayed(2, 10);

			// ballsService.sendEmptyMessageDelayed(2, 100);

			{
				pssoff.removeMessages(2);
				pssoff.sendEmptyMessageDelayed(2, 75);
			}

			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
				drawslice.sendMessageDelayed(ml, (duration / 8) * 3);
				ml = null;
				bx = null;
			}

			// {
			recordService.sendEmptyMessageDelayed(1, (duration / 8) * 1);
			// }

			// sm01.send
			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
				aplace.sendMessageDelayed(ml, (duration / 8) * 5);
				ml = null;
				bx = null;
			}

			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				bx.putInt("f", gvsv);
				ml.setData(bx);
				aheard.sendMessageDelayed(ml, (duration / 8) * 7);
				ml = null;
				bx = null;
			}

			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				bx.putInt("f", gvsv);
				ml.setData(bx);
				animport.sendMessageDelayed(ml, (duration / 8) * 6);
				ml = null;
				bx = null;
			}

			hx = null;

		}
	};

	public Handler ddpuk = new Handler() {

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999               DD PUK " + msg.what);

			Bundle hx = msg.getData();
			int du = hx.getInt("duration", ADURATION);
			String[] gs = hx.getStringArray("contentlist");
			String gg = hx.getString("content");
			if (gs == null) {
				gs = new String[] { "", (gg != null ? gg : "") };
			}
			if (gs.length == 1) {
				gs = new String[] { gs[0], "" };
			}
			if (gg == null) {
				gg = "";
			}
			// if (gs[0].length() == 0 && gs[1].length() == 0) {
			// pukdate.sendEmptyMessageDelayed(2, 2);
			// return;
			// }

			try {
				LinearLayout ru = null;
				pbn.bringChildToFront(pbrus);

				hid = (int) (System.currentTimeMillis() / 999);
				ru = new LinearLayout(ctx);

				while (findViewById(++hid) != null) {
				}
				ru.setId(hid);
				int ch = hid;
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
						-1, -2);
				lp.setMargins((mwidth / 8), 20, (mwidth / 8), (mheight / 8));
				lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
				ru.setOrientation(LinearLayout.VERTICAL);
				ru.setBackgroundResource(R.drawable.ewdate);
				ru.setGravity(Gravity.CENTER);
				ru.setScrollContainer(true);

				ru.setLayoutParams(lp);

				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				cspuk = System.currentTimeMillis() + ruu.getDuration();

				ruuoff.sendEmptyMessageDelayed(ch, 1880 + ruu.getDuration());
				pbrus.addView(ru);
				ru.startAnimation(ruu);

				ruu = null;

				if (gs[0].length() > 0) {
					TextView hdday = new TextView(ctx);
					hdday.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					hdday.setText(gs[0]);
					gg = gs[0];
					hdday.setGravity(Gravity.CENTER);
					hdday.setTextSize(36);
					ru.addView(hdday);
				}

				if (gs[1].length() > 0) {
					TextView hdd = new TextView(ctx);
					hdd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					hdd.setGravity(Gravity.CENTER);
					gg += (gs[0].length() > 0 ? "\n" : "") + gs[1];
					hdd.setText(gs[1]);
					hdd.setTextSize(21);
					ru.addView(hdd);
				}

				for (int ik = 2; ik < (gs.length < 500 ? gs.length : 500); ik++) {
					TextView hdd = new TextView(ctx);
					hdd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					// hdd.setGravity(Gravity.LEFT);
					hdd.setText(gs[ik]);
					hdd.setTextSize(18);
					ru.addView(hdd);
					gg += "\n" + gs[ik];
				}
				if (gs.length > 500) {
					Toast.makeText(ctx, "remarkable", ADURATION).show();
					gg += "\n\nremarkable list is larger than 500\n";
				}
				boolean hasButtons = false;
				if (hasButtons) {
					int[] bh = new int[10];
					{
						Button hdd = timebutton("5 m", 0, 5);
						bh[0] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("15 m", 0, 15);
						bh[1] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("1 h", 1, 0);
						bh[2] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("1 m", 0, 1);
						bh[3] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = emailbutton("email");
						bh[4] = hdd.getId();
						ru.addView(hdd);
					}
					final int[] fbh = bh;

					ru.setOnTouchListener(new OnTouchListener() {
						int ta = 1;

						public boolean onTouch(View v, MotionEvent n) {
							// Log.i("ok", "touch " + n.getAction());
							// if (n.getAction() == MotionEvent.ACTION_UP) {
							// return true;
							// }

							if (n.getAction() == MotionEvent.ACTION_DOWN) {
								ta++;
								if (ta == 2) {
									// String hk = "";
									for (int i = 0; i < fbh.length; i++) {
										if (fbh[i] != 0) {
											bvis.sendEmptyMessageDelayed(
													fbh[i], 10 + 80 * i);
										}
									}

									ruuoff.removeMessages(v.getId());
									return true;
								}
								if (ta == 3) {
									ruuoff.sendEmptyMessageDelayed(v.getId(),
											10);
									return true;
								}
								ta = 1;
							}
							return false;
						}
					});
				}

			} catch (OutOfMemoryError eg) {
				Log.w("ok", "wha v " + eg.getMessage());
			}

		}

		Button emailbutton(String content) {
			Button hdd = new Button(ctx);
			LinearLayout.LayoutParams hn = new LinearLayout.LayoutParams(-1, -2);
			hdd.setLayoutParams(hn);
			hdd.setPadding(20, 2, 2, 20);
			hdd.setGravity(Gravity.CENTER);
			hdd.setText(content);
			hdd.setTextSize(14);

			while (findViewById(++hid) != null) {
			}
			hdd.setId(hid);
			// final int fhours = hours;
			// final int fmins = mins;

			final String fcontent = content;
			hdd.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Bundle b4 = new Bundle();
					b4.putString("message", fcontent);
					// b4.putInt("hours", fhours);
					// b4.putInt("mins", fmins);
					Message m4 = new Message();
					m4.setData(b4);
					// bclick.sendMessageDelayed(m4, 10);

				}
			});
			hdd.setVisibility(View.GONE);
			return hdd;
		}

		Button timebutton(String content, int hours, int mins) {
			Button hdd = new Button(ctx);
			LinearLayout.LayoutParams hn = new LinearLayout.LayoutParams(-1, -2);
			hdd.setLayoutParams(hn);
			hdd.setPadding(20, 2, 2, 20);
			hdd.setGravity(Gravity.CENTER);
			hdd.setText(content);
			hdd.setTextSize(14);

			while (findViewById(++hid) != null) {
			}
			hdd.setId(hid);
			final int fhours = hours;
			final int fmins = mins;
			final String fcontent = content;
			hdd.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Date v5d = new Date();
					Bundle b4 = new Bundle();
					b4.putString("message", fcontent);
					b4.putInt("hours", v5d.getHours() + fhours);
					b4.putInt("mins", v5d.getMinutes() + fmins);
					Message m4 = new Message();
					m4.setData(b4);
					bclick.sendMessageDelayed(m4, 10);

				}
			});
			hdd.setVisibility(View.GONE);
			return hdd;
		}

	};
	private Handler bvis = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "Button active " + msg.what);
			Button ru = null;
			ru = (Button) findViewById(msg.what);
			if (ru != null) {
				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				ru.setVisibility(View.VISIBLE);
				ru.startAnimation(ruu);
				ru = null;
				ruu = null;
			}

		}
	};
	private Handler bclick = new Handler() {
		public void handleMessage(Message msg) {

			Bundle hx = msg.getData();
			String message = hx.getString("message");
			if (message == null) {
				message = "U";
			}
			Date v = new Date();
			int hours = hx.getInt("hours", v.getHours());
			int mins = hx.getInt("mins", v.getMinutes());

			Intent sx = new Intent();
			sx.setAction("android.intent.action.SET_ALARM");
			sx.putExtra("android.intent.extra.alarm.MESSAGE", message);
			sx.putExtra("android.intent.extra.alarm.HOUR", hours);
			sx.putExtra("android.intent.extra.alarm.MINUTES", mins);
			startActivity(sx);

		}
	};
	private Handler drawslice = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     Operation/Drawslice  "
					+ msg.what);

			if (gpd == null) {
				Log.i("ok", "slice between second b         999");
				return;
			}

			Bundle hx = msg.getData();
			if (hx == null || hx.getString("row") == null) {
				Log.i("ok", "no known row");
				return;
			}
			Uri xu = Uri.parse(hx.getString("row"));

			// ContentValues e = new ContentValues();
			ByteArrayOutputStream st;

			try {
				storeContent(xu, "avec", timber2 + timber);

				// if (dhd4 != null) {
				// sparkEasel.removeView(dhd4);
				// }

				if (gpd != null) {
					st = new ByteArrayOutputStream();
					if (st != null) {
						gpd.compress(CompressFormat.PNG, 0, st);
						// e.put("aslide", st.toByteArray());
						Log.i("ok", "e slide " + st.size());

						gppd5 = BitmapFactory.decodeByteArray(st.toByteArray(),
								0, st.size());
					}
					st = null;

					{
						File filea = new File(Environment
								.getExternalStorageDirectory()
								.getAbsolutePath(), "data/"
								+ ctx.getPackageName() + "/" + myDay());
						filea.mkdirs();
						if (filea.exists()) {
							// Bitmap xt = null;
							Bitmap xh = null;
							xh = Bitmap.createScaledBitmap(gpd, 144, 144, true);// 72//!68//48//

							File apng5 = new File(filea.getAbsolutePath(),
									"mres_" + xu.getLastPathSegment() + ".png");

							File file4 = new File(
									Environment
											.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
									""
											+ getApplication().getString(
													R.string.app_name));
							// .nomedia file in directory excludes it from
							// scaning in like apps like Gallery
							// came goes for starting folder with '.'

							File file5 = new File(ctx.getFilesDir(),
									"drawable-hdpi");
							if (file5.exists()) {
								Log.i("ok", "res file available");
							} else {
								Log.i("ok", "res file !available b");
							}

							File file7 = new File(ctx.getFilesDir(), "");
							if (file7.exists()) {
								Log.i("ok",
										"res file available "
												+ file7.getAbsolutePath());

								String[] j9 = file7.list();
								for (int i = 0; i < j9.length; i++) {
									Log.i("ok", "res file available file: "
											+ j9[i]);
								}
							} else {
								Log.i("ok", "res file !available b");
							}

							File apng6 = null;
							file4.mkdirs();
							if (file5.exists()) {
								apng6 = new File(file5.getAbsolutePath(), ""
										+ xu.getLastPathSegment() + ".png");
							} else if (file4.exists()) {
								apng6 = new File(file4.getAbsolutePath(), ""
										+ xu.getLastPathSegment() + ".png");
							} else {
								apng6 = new File(filea.getAbsolutePath(),
										"hres_" + xu.getLastPathSegment()
												+ ".png");
							}
							// file:///Android/data/{package name}
							//
							// file:///data/{package name}
							//
							//
							// PICTURE
							try {
								// ByteArrayOutputStream st5;

								// st = null;
								{
									FileOutputStream o9;
									o9 = new FileOutputStream(apng5);
									st = new ByteArrayOutputStream();
									if (st != null) {
										xh.compress(CompressFormat.PNG, 0, st);
										o9.write(st.toByteArray());
									}
									o9.close();
									if (apng5.exists()) {
										storeContent(xu, "mres",
												Uri.fromFile(apng5).toString());

										{
											Bundle nx = new Bundle(hx);
											nx.putString("uri_data",
													xu.toString());
											nx.putString("data",
													Uri.fromFile(apng5)
															.toString());
											nx.putInt("drawable",
													R.drawable.dot);// midres9o);
											Message m9 = new Message();
											m9.setData(nx);
											m9.what = -1;
											tabfy.sendMessageDelayed(m9, 75);
										}

									}
									st = null;
								}

								{
									FileOutputStream o10;
									o10 = new FileOutputStream(apng6);
									st = new ByteArrayOutputStream();
									if (st != null) {
										gpd.compress(CompressFormat.PNG, 0, st);
										o10.write(st.toByteArray());
									}
									o10.close();
									if (apng6.exists()) {
										storeContent(xu, "hres",
												Uri.fromFile(apng6).toString());

									}
								}

							} catch (FileNotFoundException e6) {
								Log.i("ok", "wha io e 14");// e.printStackTrace();
							} catch (IOException e6) {
								Log.i("ok", "wha io e 15");// e.printStackTrace();
							} finally {
							}

						}
					}

				}
				// gpdd = null;

				if (gpdx != null) {
					// gppd5x = Bitmap.createBitmap(gpddx);
					st = new ByteArrayOutputStream();
					if (st != null) {
						gpdx.compress(CompressFormat.PNG, 0, st);
						// e.put("aslope", st.toByteArray());
						gppd5x = BitmapFactory.decodeByteArray(
								st.toByteArray(), 0, st.size());
					}

					st = null;
				}
				// gpddx = null;
				// dhdin.sendEmptyMessageDelayed(2, 20);

				// gpd = null;
				// gpdx = null;
				// productiondash = null;
				// surfacedash = null;

			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha c " + sf.getMessage());
			} finally {

				// if (e != null) {
				// SqliteWrapper.update(
				// ctx,
				// ctx.getContentResolver(),
				// Uri.parse("content://" + ctx.getPackageName()
				// + "/moment"), e,
				// ROWID + "=" + xu.getLastPathSegment(), null);
				// }
				// e = null;
			}

			smartSpark.removeMessages(2);
			smartSpark.sendEmptyMessageDelayed(2, 25);

			{
				Bundle hu = new Bundle(hx);
				// hu.putInt("grr", productiondash.getId());
				Message mu = new Message();
				mu.setData(hu);
				drawsliceb.sendMessageDelayed(mu, 75);
			}

		}
	};

	private Handler drawsliceb = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     Operation/Drawslice b "
					+ msg.what + " " + upause);
			if (upause) {
				return;
			}

			Bundle hx = msg.getData();

			if (productiondash != null) {
				// Log.i("ok", "sending prod dash id " +
				// productiondash.getId());
				// smx =
				RelativeLayout p4 = (RelativeLayout) productiondash.getParent();

				Log.i("ok", "creating new copy of Image with " + smx + " parts");
				{

					ImageView i8 = new ImageView(ctx);
					{
						// RelativeLayout.LayoutParams t2r = new
						// RelativeLayout.LayoutParams(
						// -2, -2);
						RelativeLayout.LayoutParams t2r = (RelativeLayout.LayoutParams) productiondash
								.getLayoutParams();
						// t2r.weight = 1;
						// t2r.setMargins((int) (mwidth * 0.9f),
						// (int) (mheight * 0.9f), 0, 0);
						// t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
						// t2r.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
						// t2r.setMargins(0, 0, 0, 0);
						i8.setLayoutParams(t2r);
					}
					while (findViewById(++hid) != null) {
					}
					i8.setId(hid);
					i8.setScaleType(productiondash.getScaleType());
					i8.setImageBitmap(gppd5);
					p4.addView(i8);
					hiscaveOn.sendEmptyMessageDelayed(i8.getId(), 75);
				}
				productiondash = null;

			}

			if (surfacedash != null) {
				hiscaveOn.sendEmptyMessageDelayed(surfacedash.getId(), 75);
			}

			// tapClear.removeMessages(2);
			// tapClear.sendEmptyMessageDelayed(2, 1000);
			{

				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
				drawslicec.sendMessageDelayed(ml, 10);
				ml = null;
				bx = null;
			}
			hx = null;

		}
	};

	int mngxu = 1;
	int mngx8 = 1;
	int dhd4w = 120;
	int dhd4h = 80;
	int aspark = 1;
	private Handler drawslicec = new Handler() {

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     Operation/Drawslice c "
					+ msg.what + " " + upause);
			if (upause) {
				return;
			}

			final Bundle hx = msg.getData();
			Uri xu = Uri.parse(hx.getString("row"));

			// triDraw.sendEmptyMessageDelayed(2, 2175);

			try {
				mngxu = Integer.parseInt(xu.getLastPathSegment());
				mngx8 = mngxu;
			} catch (NumberFormatException en) {
				Log.i("ok", "id mng");
				return;
			}
			// boomBoard.setVisibility(View.VISIBLE);
			// sparkEasel.setVisibility(View.VISIBLE);
			// pbn.bringChildToFront(sparkEasel);
			// pbn.bringChildToFront(boomBoard);

			dhd4w = (int) (mwidth * 0.18f);// uimvr.getWidth();
			dhd4h = (int) (mheight * 0.18f);// uimvr.getHeight();

			// hiscave
			// Brain Blood to UI to the Cloud conceptualization.
			{
				// if (reg == null) {
				// reg = ctx.getSharedPreferences("Preferences",
				// Context.MODE_WORLD_WRITEABLE);
				// edt = reg.edit();
				// }
				aspark = reg.getInt("aspark", 0);

				ContentValues uq = new ContentValues();
				uq.put("aspark", aspark);
				uq.put("atref", mngxu);
				uq.put("attable", "content://" + ctx.getPackageName()
						+ "/moment");
				uq.put("atcolumn", "aslide");
				uq.put("atwidth", dhd4w);
				uq.put("atheight", dhd4h);
				uq.put("atx", (dhd4w / 2) + 22);
				uq.put("aty", mheight - (dhd4h / 2) - 30);

				Uri uj = SqliteWrapper.insert(
						ctx,
						getContentResolver(),
						Uri.parse("content://" + ctx.getPackageName()
								+ "/refplay"), uq);
				uq = null;
				if (uj == null) {
					Log.w("ok", "sparkMark entry a");
				} else {
					Log.i("ok", "sparkMark entry " + uj.toString());
				}
			}
			// drawslice

			// dingoSparkToggle.sendEmptyMessageDelayed(3, 10);

		}
	};

	long cspuk = 1;
	public Handler ruuoff = new Handler() {
		public void handleMessage(Message msg) {
			// if (cspuk > System.currentTimeMillis()) {
			Log.i("ok", "99.9999                  ruu off " + msg.what);
			if (upause) {
				return;
			}
			// return;
			// }

			// LinearLayout ru = null;
			LinearLayout ru = (LinearLayout) findViewById(msg.what);
			if (ru != null) {

				Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				ru.startAnimation(ruu);
				ruuoffb.sendEmptyMessageDelayed(msg.what, ruu.getDuration());
				cspuk = System.currentTimeMillis() + (1370) + ruu.getDuration();
				ruu = null;
				ru = null;
				// pbn.bringChildToFront(pba);

			} else {
				Log.e("ok", "wha mg");
				pbrus.removeAllViews();
			}

		}
	};

	private Handler ruuoffb = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			LinearLayout ru = null;
			ru = (LinearLayout) findViewById(msg.what);
			if (ru != null) {
				ru.setVisibility(View.GONE);
				ru = null;
				// pbn.removeView(ru);
			}
		}
	};

}
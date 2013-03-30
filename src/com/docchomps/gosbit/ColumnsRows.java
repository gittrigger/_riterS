package com.docchomps.gosbit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ColumnsRows extends ListActivity {

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		try {
			Bundle fb = new Bundle();
			fb.putInt("v", position);
			fb.putInt("id", (int) id);
			Message hfb = new Message();
			hfb.setData(fb);
			columnv.sendMessageDelayed(hfb, 20);

			RelativeLayout rv = (RelativeLayout) v;

			if (rv != null) {
				rv.setBackgroundResource(R.drawable.list_selector_activated_holo_dark);
			}

			// where =
			recordid = (int) (getListView().getItemIdAtPosition(position));
			Log.i("ok", "selected " + position + "," + recordid);

			if (getreturn) {
				setResult(RESULT_OK, new Intent().setData(Uri
						.parse("content://" + ctx.getPackageName() + "/moment/"
								+ recordid)));
				finish();
			} else {

				sbarOn.sendEmptyMessageDelayed(2, 25);
				nbarOn.sendEmptyMessageDelayed(2, 1225);
			} // nbarOff.sendEmptyMessageDelayed(4, 25);
				// reshow.sendEmptyMessageDelayed(2, 1220);

		} catch (RuntimeException e2) {
			Log.i("ok", "error k9 " + e2.getMessage());
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle state) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(state);
	}

	Context ctx;
	int hid = -1;
	Uri um;
	Bundle ck;
	String[][] v;
	String col;
	String atitle = "";
	String acontent = "";
	String hres = "";
	String mres = "";
	String pres = "";
	String aheardlist = "";
	String animportlist = "";
	String areflist = "";
	float lat = 1f;
	float lon = 1f;
	String mhe = "";;
	RelativeLayout bear;

	@Override
	protected void onCreate(Bundle sib2) {
		// TODO Auto-generated method stub
		super.onCreate(sib2);
		setContentView(R.layout.main);

		ctx = getApplicationContext();

		s01.sendEmptyMessageDelayed(2, 75);
	}

	int mxw = 75;
	int mxh = 88;
	int mwidth = 320;
	int mpad = 160;
	boolean getreturn = false;
	int mheight = 320;
	Handler s01 = new Handler() {
		public void handleMessage(Message msg) {

			// Log.i("s01", "w/" + um.toString());
			try {

				reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				edt = reg.edit();

				bear = (RelativeLayout) findViewById(R.id.baser);
				bear.setBackgroundResource(R.drawable.background_holo_dark);

				hid = (int) (System.currentTimeMillis() / 999);
				v = new String[100][0];

				Intent xi = getIntent();
				Log.i("ok", "ACTION IN " + xi.getAction() + " "
						+ (xi.getData() != null ? xi.getData().toString() : ""));

				if (Intent.ACTION_SEARCH.equals(xi.getAction())
						|| Intent.ACTION_GET_CONTENT.equals(xi.getAction())
						|| Intent.ACTION_VIEW.equals(xi.getAction())) {
					// SearchRecentSuggestions suggestions = new
					// SearchRecentSuggestions(
					// this, SearchSuggestion.AUTHORITY, SearchSuggestion.MODE);
					// suggestions.saveRecentQuery(he, null);
					// doMySearch(query);

					Log.i("ok", "ACTION SEARCH/VIEW/GET for moment");
					xi.putExtra("cu", "content://" + ctx.getPackageName()
							+ "/moment");
					xi.putExtra("c1", "content://" + ctx.getPackageName()
							+ "/moment\naheardlist\nfieldid\n" + ROWID
							+ "\naudio\npres");
					xi.putExtra("c2", "content://" + ctx.getPackageName()
							+ "/moment\nmres\nfieldid\n" + ROWID + "\nimagea");
					xi.putExtra("cl", "atitle,created,lat,lon");

					if (Intent.ACTION_GET_CONTENT.equals(xi.getAction())) {
						getreturn = true;
					}

				}

				if (xi != null) {

					if (Intent.ACTION_VIEW.equals(xi.getAction())) {

						try {
							recordid = Integer
									.parseInt(xi.getData() != null ? xi
											.getData().getLastPathSegment()
											: xi.getStringExtra(SearchManager.QUERY));
							Log.i("ok",
									"received recordid "
											+ (xi.getData() != null ? xi
													.getData() : ""));
							sbarOn.sendEmptyMessageDelayed(2, 25);
							nbarOn.sendEmptyMessageDelayed(2, 225);
						} catch (NumberFormatException nu) {
							// nbarOff.sendEmptyMessageDelayed(2, 150);
							recordid = -1;
						} catch (RuntimeException e2) {
							Log.i("ok", "error b8 " + e2.getMessage());
							recordid = -1;
						} finally {
						}
					}

					if (Intent.ACTION_SEARCH.equals(xi.getAction())) {
						String he = xi.getStringExtra(SearchManager.QUERY);
						Log.i("ok", "SEARCH       he " + he);
						mhe = he;
					}

					Bundle sib = xi.getExtras();

					if (sib != null) {
						if (sib.containsKey("title")) {
							atitle = sib.getString("title");
						}
						if (sib.containsKey("cu")) {
							um = Uri.parse(sib.getString("cu"));
						}

						if (sib.containsKey("cl")) {
							col = sib.getString("cl");
						}

						ck = new Bundle(sib);
						for (int i = 1; i < 19; i++) {
							if (ck.containsKey("c" + i)) {
								v[i] = ck.getString("c" + i).split("\n");
								// } else if (ck.containsKey("i" + i)) {
								// v[i] = ck.getString("i" + i).split("\n");
							} else {
								break;
							}
						}

						Set<String> k = sib.keySet();
						Log.i("ok", "Colu got " + sib.size());
						Object[] b = k.toArray();

						for (int n = 0; n < b.length; n += 2) {
							Log.i("ok", "Colu row " + b[n]);
						}
					}
				}

				// if (um == null) {
				// um = ContactsContract.Data.CONTENT_URI;
				// ck = new Bundle();
				// }

				Display sd = getWindowManager().getDefaultDisplay();
				mwidth = sd.getWidth();
				mheight = sd.getHeight();
				if (mwidth > 720) {
					mpad = (int) (mheight < mwidth * .3f ? mheight
							: (mwidth * .3f > 320 ? 320 : 160));
				} else {
					mpad = 0;
				}
				// if (mwidth > mheight) {
				// mxw = 120;
				// } else {
				mxw = 68;
				// }

				// if (mheight / 88 > 5) {
				// mxh = mheight / ((mheight / 88) - 1);
				// }
				mxh = 68;

				if (mwidth > 720) {
					// FrameLayout.LayoutParams hn = (FrameLayout.LayoutParams)
					// getListView()
					// .getLayoutParams();
					RelativeLayout.LayoutParams hn = new RelativeLayout.LayoutParams(
							-1, -1);// (RelativeLayout.LayoutParams)
									// getListView()
					// .getLayoutParams();

					hn.setMargins(0, 0, mwidth - mpad, 0);

					getListView().setLayoutParams(hn);

				} else {
					RelativeLayout.LayoutParams hn = new RelativeLayout.LayoutParams(
							-1, -1);// (RelativeLayout.LayoutParams)
									// getListView()
					// .getLayoutParams();
					hn.setMargins(0, 0, 0, 0);
					getListView().setLayoutParams(hn);
				}

				nbarAdd.sendEmptyMessageDelayed(2, 25);
				// nbarOn.sendEmptyMessageDelayed(2, 175);
			} catch (RuntimeException e2) {
				Log.i("ok", "audio onpause stop error " + e2.getMessage());
			}
			// column.sendEmptyMessageDelayed(3, 100);

			// column.removeMessages(2);
			// column.sendEmptyMessageDelayed(2, 1820);

		}
	};
	SharedPreferences reg;
	Editor edt;

	Handler sbarOn = new Handler() {
		public void handleMessage(Message msg) {

			if (upause) {
				return;
			}

			nbarOff.removeMessages(2);
			try {

				if (sbar == null) {
					// if (nbar.getHeight() < 20 && msg.what < 30) {
					// nbar =
					// still loading
					// nbarOn.sendEmptyMessageDelayed((msg.what + 1),
					// 75 + (msg.what * 25));
					// return;
					// }

					RelativeLayout n8 = new RelativeLayout(ctx);
					RelativeLayout.LayoutParams t1r = new RelativeLayout.LayoutParams(
							-1, -1);
					// bear.addView
					if (mwidth > 720) {
						t1r.setMargins(mpad, 0, 0, 0);
					} else {
						t1r.setMargins(0, 0, 0, 0);
					}

					n8.setLayoutParams(t1r);
					while (findViewById(++hid) != null) {
					}
					n8.setId(hid);
					n8.setVisibility(View.INVISIBLE);
					// n8.setOrientation(LinearLayout.HORIZONTAL);
					// n8.setBackgroundColor(Color.argb(192, 30, 30, 30));
					n8.setBackgroundResource(R.drawable.panel_bg_holo_dark);// .text_anchor_bar_top);

					// if (mwidth > 800) {
					// bear.addView(n8, 0);
					// } else {
					bear.addView(n8);
					// }
					sbar = (RelativeLayout) findViewById(n8.getId());
				} else {
					sbar.removeAllViews();
				}

				{
					if (recordid > 0) {
						Cursor b9;
						b9 = SqliteWrapper.query(ctx, getContentResolver(), um,
								new String[] { ROWID, "atitle", "mres",
										"acontent", "aheardlist", "pres",
										"hres", "animportlist", "areflist",
										"lat", "lon" }, ROWID + " = "
										+ recordid, null, null);

						if (b9 != null && b9.moveToFirst()) {
							atitle = b9.getString(1);
							mres = b9.getString(2);
							pres = b9.getString(5);
							hres = b9.getString(6);
							acontent = b9.getString(3);
							aheardlist = b9.getString(4);
							animportlist = b9.getString(7);
							areflist = b9.getString(8);
							lat = b9.getFloat(9);
							lon = b9.getFloat(10);

							edt.putInt("active_choice", b9.getInt(0));
							edt.putString("active_title", atitle);
							edt.commit();

						}

						final float lonf = lon;
						final float latf = lat;
						if (b9 != null) {
							b9.close();
						}

						TextView u7 = new TextView(ctx);
						{
							RelativeLayout.LayoutParams t4r = new RelativeLayout.LayoutParams(
									-1, -2);

							// t4r.setMargins(8, 8, 8, 8);
							// t4r.weight = 1;
							u7.setLayoutParams(t4r);
							while (findViewById(++hid) != null) {
							}
							u7.setId(hid);
							// u7.setTextSize((float) 26);
							// u7.setGravity(Gravity.CENTER_VERTICAL);
							u7.setPadding(8, 8, 8, 8);

							u7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
							u7.setTextColor(Color.argb(255, 51, 181, 229));
							u7.setText("" + atitle);
							// u7.setBackgroundColor(Color.argb(55, 180, 180,
							// 180));

							u7.setBackgroundResource(R.drawable.textfield_default_holo_dark);
							sbar.addView(u7);
						}

						{
							File m9 = new File(hres != null ? hres.replaceAll(
									"file:..", "") : "");

							if (m9.exists()) {

								ImageView t1 = new ImageView(ctx);
								RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
										-1, -1);
								// t2r.weight = 1;
								t2r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,
										-1);
								t2r.setMargins(8, nbar.getHeight() / 2, 8, 8);
								t1.setLayoutParams(t2r);
								while (findViewById(++hid) != null) {
								}
								t1.setId(hid);
								t1.setScaleType(ScaleType.FIT_CENTER);

								try {
									t1.setImageURI(Uri.fromFile(m9));
									Log.i("ok", "using mres " + mres);
								} catch (OutOfMemoryError sf) {
									Log.w("OOM",
											"xxx b9 "
													+ sf.getLocalizedMessage());
									t1.setImageResource(R.drawable.hires512);
								}
								// t1.setImageDrawable(Drawable
								// .createFromPath(mres));
								sbar.addView(t1);
							} else {
								Log.w("ok", "file hres doesn't exists: " + hres);
							}

							// sbarOn.sendEmptyMessageDelayed(2, 25);
						}

						{
							// _detail
							{
								ImageView k5 = new ImageView(ctx);
								// LinearLayout.LayoutParams t2r = new
								// LinearLayout.LayoutParams(
								// -1, -2);
								// t2r.weight = 1;
								// t2r.setMargins(3, 3, 0, 0);
								{
									RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
											-2, -2);
									t2r.setMargins(8, 8, 8, 8);
									t2r.addRule(RelativeLayout.BELOW,
											u7.getId());
									k5.setLayoutParams(t2r);
								}

								while (findViewById(++hid) != null) {
								}
								k5.setId(hid);
								k5.setScaleType(ScaleType.MATRIX);
								// k5.setBackgroundResource(R.drawable.btn_group_normal_holo_dark);
								k5.setImageResource(R.drawable.ic_menu_info_details);
								sbar.addView(k5);

								// LinearLayout.LayoutParams t2r = new
								// LinearLayout.LayoutParams(
								// -1, -2);
								// t2r.weight = 1;
								{
									ImageView t5 = new ImageView(ctx);
									{
										RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
												-2, -2);
										t2r.addRule(RelativeLayout.BELOW,
												k5.getId());
										t2r.setMargins(8, 8, 8, 8);
										t5.setLayoutParams(t2r);
									}

									while (findViewById(++hid) != null) {
									}
									t5.setId(hid);
									// t5.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);
									t5.setScaleType(ScaleType.MATRIX);
									t5.setImageResource(R.drawable.ic_menu_mapmode);
									// geo:latitude,longitude
									t5.setOnClickListener(new OnClickListener() {
										public void onClick(View v) {
											Intent u9 = new Intent();
											u9.setAction(Intent.ACTION_VIEW);
											u9.setData(Uri.parse("geo:" + latf
													+ "," + lonf));
											startActivity(Intent.createChooser(
													u9, "Choose Map"));

											Toast.makeText(
													ctx,
													"Location\n" + latf + ","
															+ lonf, 1880)
													.show();
										}
									});

									sbar.addView(t5);
									if ((lonf == 1f || latf == 1f)
											|| (lonf == 0f || latf == 0f)) {
										t5.setVisibility(View.GONE);
									}

									{
										ImageView t1 = new ImageView(ctx);
										{
											RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
													-2, -2);
											t2r.setMargins(8, 8, 8, 8);
											if ((lonf == 1f || latf == 1f)
													|| (lonf == 0f || latf == 0f)) {
												t2r.addRule(
														RelativeLayout.BELOW,
														k5.getId());
											} else {
												t2r.addRule(
														RelativeLayout.BELOW,
														t5.getId());
											}

											t1.setLayoutParams(t2r);
										}
										while (findViewById(++hid) != null) {
										}
										t1.setId(hid);
										t1.setScaleType(ScaleType.FIT_CENTER);
										// t1.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);

										File m9 = new File(
												pres != null ? pres.replaceAll(
														"file:..", "") : "");
										if (m9.exists()) {
											// Log.i("ok", "using mres " +
											// mres);
											try {
												t1.setImageURI(Uri.parse(pres));
											} catch (OutOfMemoryError sf) {
												Log.w("OOM",
														"xxx j5 "
																+ sf.getLocalizedMessage());
											}
											// t1.setImageDrawable(Drawable
											// .createFromPath(mres));

											t1.setOnClickListener(new OnClickListener() {
												public void onClick(View v) {
													Bundle hu = new Bundle();
													hu.putInt("id", v.getId());
													hu.putString("path",
															aheardlist);
													Message m8 = new Message();
													m8.setData(hu);
													m8.what = 2;
													if (xuut != null) {
														xuut.stop();
														xuut.release();
													}
													playaudio2
															.removeMessages(2);
													playaudio2
															.sendMessageDelayed(
																	m8, 20);

												}
											});
											sbar.addView(t1);

										} else {
											// Click
											// t1.setImageResource(R.drawable.ic_menu_archive);
											t1.setOnClickListener(new OnClickListener() {
												public void onClick(View v) {
													// finish();
													sbarOff.sendEmptyMessageDelayed(
															3, 25);
												}
											});
										}

										{
											ImageView i00 = new ImageView(ctx);
											{
												RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
														-2, -2);
												t2r.addRule(
														RelativeLayout.BELOW,
														t1.getId());
												t2r.setMargins(8, 8, 8, 8);
												i00.setLayoutParams(t2r);
											}
											while (findViewById(++hid) != null) {
											}
											i00.setId(hid);
											i00.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);

											i00.setScaleType(ScaleType.MATRIX);
											i00.setImageResource(R.drawable.ic_menu_gallery);
											// geo:latitude,longitude
											final String hresf = hres;

											i00.setOnClickListener(new OnClickListener() {
												public void onClick(View v) {

													Intent u9 = new Intent();
													u9.setAction(Intent.ACTION_VIEW);
													Log.i("ok",
															"requesting view of "
																	+ getContentResolver()
																			.getType(
																					Uri.parse(hresf))
																	+ " "
																	+ hresf);
													u9.setType("image/png");// chooser
													u9.setData(Uri.parse(hresf));
													startActivity(Intent
															.createChooser(u9,
																	"Image Viewer"));

												}
											});

											// sbar.addView(i00);
										}
									}
								}

							}
						}

						{// bottom bar
							{// back
								ImageView i8 = new ImageView(ctx);
								{
									RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
											48, 48);
									// t2r.weight = 1;
									// t2r.setMargins((int) (mwidth * 0.9f),
									// (int) (mheight * 0.9f), 0, 0);
									t2r.addRule(
											RelativeLayout.ALIGN_PARENT_BOTTOM,
											-1);
									// t2r.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
									// -1);
									t2r.setMargins(8, 8, 8, 8);
									i8.setLayoutParams(t2r);
								}
								while (findViewById(++hid) != null) {
								}
								i8.setId(hid);
								i8.setScaleType(ScaleType.FIT_CENTER);
								// i8.setImageResource(R.drawable.ic_menu_info_details);
								i8.setImageResource(R.drawable.expander_open_holo_dark);
								// i8.setBackgroundResource(R.drawable.btn_group_normal_holo_dark);

								i8.setOnClickListener(new OnClickListener() {
									public void onClick(View v) {
										finish();
										// nbarOff.sendEmptyMessageDelayed(3,
										// 25);
									}
								});
								sbar.addView(i8);
							}

							{// share
								{
									{
										ImageView i9 = new ImageView(ctx);
										{
											RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
													48, 48);
											// t2r.weight = 1;
											// t2r.setMargins((int) (mwidth *
											// 0.9f),
											// (int) (mheight * 0.9f), 0, 0);
											t2r.addRule(
													RelativeLayout.ALIGN_PARENT_BOTTOM,
													-1);
											t2r.addRule(
													RelativeLayout.CENTER_IN_PARENT,
													-1);

											t2r.setMargins(8, 8, 8, 8);
											i9.setLayoutParams(t2r);
										}
										while (findViewById(++hid) != null) {
										}
										i9.setId(hid);
										i9.setScaleType(ScaleType.FIT_CENTER);
										// i9.setImageResource(R.drawable.ic_menu_info_details);
										i9.setImageResource(R.drawable.ic_menu_share_holo_dark);
										i9.setOnClickListener(new OnClickListener() {
											public void onClick(View v) {
												shareMe.sendEmptyMessageDelayed(
														3, 25);
											}
										});
										sbar.addView(i9);
									}
								}
							}

							{// list
								ImageView t1 = new ImageView(ctx);
								{
									RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
											48, 48);
									t2r.addRule(
											RelativeLayout.ALIGN_PARENT_RIGHT,
											-1);
									t2r.addRule(
											RelativeLayout.ALIGN_PARENT_BOTTOM,
											-1);
									t2r.setMargins(8, 8, 8, 8);
									t1.setLayoutParams(t2r);
								}

								while (findViewById(++hid) != null) {
								}
								t1.setId(hid);
								t1.setScaleType(ScaleType.FIT_CENTER);
								// t1.setBackgroundResource(R.drawable.btn_group_normal_holo_dark);
								t1.setImageResource(R.drawable.ic_menu_moreoverflow_normal_holo_dark);
								sbar.addView(t1);
								t1.setOnClickListener(new OnClickListener() {
									public void onClick(View v) {
										sbarOff.sendEmptyMessageDelayed(3, 25);
										// finish();
									}
								});
							}
						}

						{// tag bar
							{
								ImageView t5 = new ImageView(ctx);
								// LinearLayout.LayoutParams t2r = new
								// LinearLayout.LayoutParams(
								// -1, -2);
								// t2r.weight = 1;
								{
									RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
											-2, -2);
									t2r.addRule(
											RelativeLayout.ALIGN_PARENT_RIGHT,
											-1);

									t2r.setMargins(8, 8, 8, 8);
									t2r.addRule(RelativeLayout.BELOW,
											u7.getId());
									t5.setLayoutParams(t2r);
								}
								while (findViewById(++hid) != null) {
								}
								t5.setId(hid);
								t5.setScaleType(ScaleType.MATRIX);
								t5.setImageResource(R.drawable.btn_star_off_normal_holo_dark);
								// t5.setBackgroundResource(R.drawable.btn_default_normal_holo_dark);

								t5.setOnClickListener(new OnClickListener() {
									boolean sel = false;

									public void onClick(View v) {
										ImageView i9 = (ImageView) v;
										if (sel) {
											sel = false;
											i9.setImageResource(R.drawable.btn_star_off_normal_holo_dark);
										} else {
											sel = true;
											i9.setImageResource(R.drawable.btn_star_on_normal_holo_dark);
										}
									}
								});

								sbar.addView(t5);
								{
									ImageView t1 = new ImageView(ctx);
									// LinearLayout.LayoutParams t2r = new
									// LinearLayout.LayoutParams(
									// -1, -2);
									// t2r.weight = 1;
									// t2r.setMargins(3, 3, 0, 0);

									// t1.setLayoutParams(t2r);
									{
										RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
												-2, -2);
										t2r.addRule(
												RelativeLayout.ALIGN_PARENT_RIGHT,
												-1);
										t2r.addRule(RelativeLayout.BELOW,
												t5.getId());
										t2r.setMargins(8, 8, 8, 8);
										t1.setLayoutParams(t2r);
									}

									while (findViewById(++hid) != null) {
									}
									t1.setId(hid);
									t1.setScaleType(ScaleType.MATRIX);
									t1.setImageResource(R.drawable.btn_check_off_holo_dark);
									t1.setBackgroundResource(R.drawable.btn_check_off_normal_holo_dark);
									t1.setOnClickListener(new OnClickListener() {
										boolean sel = false;

										public void onClick(View v) {
											ImageView i9 = (ImageView) v;
											if (sel) {
												sel = false;
												i9.setImageResource(R.drawable.btn_check_off_holo_dark);
											} else {
												sel = true;
												i9.setImageResource(R.drawable.btn_check_on_holo_dark);
											}
										}
									});
									sbar.addView(t1);

									{
										ImageView i0 = new ImageView(ctx);
										// LinearLayout.LayoutParams t2r = new
										// LinearLayout.LayoutParams(
										// -1, -2);
										// t2r.weight = 1;
										// t2r.setMargins(3, 3, 0, 0);

										// i0.setLayoutParams(t2r);
										{
											RelativeLayout.LayoutParams t2r = new RelativeLayout.LayoutParams(
													-2, -2);
											t2r.addRule(
													RelativeLayout.ALIGN_PARENT_RIGHT,
													-1);
											t2r.addRule(RelativeLayout.BELOW,
													t1.getId());
											t2r.setMargins(8, 8, 8, 8);
											i0.setLayoutParams(t2r);
										}

										while (findViewById(++hid) != null) {
										}
										i0.setId(hid);
										i0.setScaleType(ScaleType.MATRIX);
										i0.setImageResource(R.drawable.btn_radio_off_holo_dark);
										i0.setBackgroundResource(R.drawable.btn_radio_off_disabled_holo_dark);
										i0.setOnClickListener(new OnClickListener() {
											boolean sel = false;

											public void onClick(View v) {
												ImageView i9 = (ImageView) v;
												if (sel) {
													sel = false;
													i9.setImageResource(R.drawable.btn_radio_off_holo_dark);
												} else {
													sel = true;
													i9.setImageResource(R.drawable.btn_radio_on_holo_dark);
												}
											}
										});
										sbar.addView(i0);
									}
								}

							}

						}
					}
				}

				if (sbarcs > System.currentTimeMillis()) {
					sbarOffb.removeMessages(2);
				}
				if (sbarcs > System.currentTimeMillis()
						|| sbar.getVisibility() == View.INVISIBLE) {

					sbar.setVisibility(View.VISIBLE);
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.sbaron);
					sbar.startAnimation(a4);
					sbarcs = System.currentTimeMillis() + a4.getDuration();
				}
			} catch (RuntimeException e2) {
				Log.i("ok", "error c9 " + e2.getMessage());
			}

		}
	};

	Handler nbarOff = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {
				if (nbar == null) {
					// if (msg.what == 4 && recordid > 0) {
					// nbarOn.sendEmptyMessageDelayed(2, 2);
					// }
					Log.w("ok", "nbar");
					return;
				}

				if (nbar.getVisibility() == View.VISIBLE) {
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.nbaroff);
					nbar.startAnimation(a4);
					Animation a6 = AnimationUtils.loadAnimation(ctx,
							R.anim.mbaroff);
					mbar.startAnimation(a6);
					nbarcs = System.currentTimeMillis() + a4.getDuration();
					nbarOffb.sendEmptyMessageDelayed(2, a4.getDuration() - 25);
					// if (msg.what == 4 && recordid > 0) {
					// nbarOn.sendEmptyMessageDelayed(2, 2);
					// nbarOn.sendEmptyMessageDelayed(2, a4.getDuration());
					// return;
					// }
				}

				// if (msg.what == 4 && recordid > 0) {
				// nbarOn.sendEmptyMessageDelayed(2, 2);
				// nbarOn.sendEmptyMessageDelayed(2, 25);
				// }
			} catch (RuntimeException e2) {
				Log.i("ok", "audio onpause stop error " + e2.getMessage());
			}
		}
	};

	Handler sbarOff = new Handler() {
		public void handleMessage(Message msg) {

			// int ls = getListView().getChildCount()
			// - getListView().getHeaderViewsCount()
			// - getListView().getFooterViewsCount();

			// if (msg.what == 3 && ls <= 1) {
			// }

			if (sbar != null && sbar.getVisibility() == View.VISIBLE) {
				recordid = -1;

				reshow.sendEmptyMessageDelayed(2, 225);

				Animation a4 = AnimationUtils
						.loadAnimation(ctx, R.anim.sbaroff);
				// a4.setStartOffset(1880);
				sbar.startAnimation(a4);
				sbarcs = System.currentTimeMillis() + a4.getDuration();
				sbarOffb.sendEmptyMessageDelayed(2, a4.getDuration() - 25);

				nbarOff.removeMessages(2);
				nbarOff.sendEmptyMessageDelayed(2, 15832);
			}

		}
	};

	long sbarcs = 1;
	Handler nbarOffb = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {
				nbar.setVisibility(View.INVISIBLE);
				mbar.setVisibility(View.INVISIBLE);
			} catch (RuntimeException e2) {
				Log.i("ok", "error c9 " + e2.getMessage());
			}

		}
	};
	Handler sbarOffb = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {
				sbar.setVisibility(View.INVISIBLE);
			} catch (RuntimeException e2) {
				Log.i("ok", "error c9 " + e2.getMessage());
			}

		}
	};

	RelativeLayout sbar;
	Handler nbarOn = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			// .send
			if (nbar == null) {
				// Log.w("ok", "nbar");
				// nbarAdd.sendEmptyMessageDelayed(2, 75);
				return;
			}// bringChild

			if (mwidth > 720) {
				bear.bringChildToFront(getListView());
			} else {
				bear.bringChildToFront(nbar);
				bear.bringChildToFront(mbar);
				bear.bringChildToFront(sbar);
			}

			// if (nbarcs > System.currentTimeMillis()
			// && nbar.getVisibility() == View.VISIBLE) {

			// }
			// if (nbarcs > System.currentTimeMillis()) {
			// nbarOffb.removeMessages(2);
			// }
			if (nbarcs > System.currentTimeMillis()
					|| nbar.getVisibility() == View.INVISIBLE) {

				// if (msg.what == 4) {
				// nbarOn.sendEmptyMessageAtTime(2, nbarcs + 10);
				// } else {
				nbar.setVisibility(View.VISIBLE);
				Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.nbaron);
				nbar.clearAnimation();
				nbar.startAnimation(a4);
				nbarcs = System.currentTimeMillis() + a4.getDuration() + 10;

				mbar.clearAnimation();
				mbar.setVisibility(View.VISIBLE);
				Animation a6 = AnimationUtils.loadAnimation(ctx, R.anim.mbaron);
				mbar.startAnimation(a6);
				// }
			}

		}
	};
	LinearLayout nbar, mbar;
	long nbarcs = 1;
	int recordid = -1;
	String where = "1=1";
	Handler reshow = new Handler() {
		Cursor lCursor;

		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			Log.i("ok", "vstart good xxx " + recordid);

			try {
				Bundle bdl = msg.getData();
				// "strftime('%Y/%m/%d %H:%M',published) as published",
				String[] columns;
				String[] from;
				// int sdkVersion = Integer.parseInt(Build.VERSION.SDK);
				where = "1=1";

				if (mhe.length() > 0) {
					where = "atitle like '%" + mhe + "%'";
				} else if (recordid > 0) {
					where = ROWID + " = " + recordid;
				}
				String by = "updated desc";

				int[] to = new int[] { R.id.fieldid, R.id.fielda, R.id.fieldb,
						R.id.fieldc };

				columns = new String(
						ROWID
								+ ""
								+ (ROWID.contains("_id") ? "" : "," + ROWID
										+ " AS _id")
								+ ",atitle,status,date(created) as cdate,time(created) as tdate,created,updated,"
								+ col).split(",");
				Log.i("ok", "using col " + col + " (" + where + ")");
				from = new String(ROWID + "," + col).split(",");

				if (lCursor != null) {
					Log.i("ok", "cursor not gone working to close it");
					if (recordid < 0 && lCursor.getCount() == 1) {
						lCursor.close();
						lCursor = null;
					}
				} else if (!listr) {
					getListView().setDivider(
							getResources().getDrawable(
									R.drawable.list_divider_holo_dark));
					getListView().setSelector(
							R.drawable.list_selected_holo_dark);
					{
						RelativeLayout vh = new RelativeLayout(ctx);
						while (findViewById(++hid) != null) {
						}
						vh.setId(hid);
						vh.setLayoutParams(new ListView.LayoutParams(-1,
								mheight));
						vh.setBackgroundColor(Color.argb(0, 50, 50, 50));
						getListView().addFooterView(vh, null, false);
					}

					{
						RelativeLayout vh = new RelativeLayout(ctx);
						while (findViewById(++hid) != null) {
						}
						vh.setId(hid);
						vh.setLayoutParams(new ListView.LayoutParams(-1,
								mheight));
						vh.setBackgroundColor(Color.argb(0, 50, 50, 50));
						getListView().addHeaderView(vh, null, false);
					}

					try {
						getListView().setOverScrollMode(
								getListView().OVER_SCROLL_IF_CONTENT_SCROLLS);

						getListView().setOverscrollHeader(
								getResources().getDrawable(
										R.drawable.background_holo_dark));

						getListView().setOverscrollFooter(
								getResources().getDrawable(
										R.drawable.background_holo_dark));

					} catch (NoSuchMethodError i8e) {
						Log.w("ok", "over scroll feature unavailable");
					}
					listr = true;

				}

				if (lCursor == null && getListView() != null && um != null) {
					lCursor = SqliteWrapper.query(ctx, getContentResolver(),
							um, columns, where, null, by);
					startManagingCursor(lCursor);
					// mHu.setVisibility(View.INVISIBLE);

					SimpleCursorAdapter entries = new SimpleCursorAdapter(ctx,
							R.layout.listrow, lCursor, from, to);

					getListView().setOnScrollListener(cssc);
					getListView().setOnHierarchyChangeListener(cssh);
					setListAdapter(entries);

					getListView().setSelectionFromTop(
							getListView().getHeaderViewsCount(),
							mbar.getHeight());

				}

				if (lCursor != null) {
					if (lCursor.moveToFirst() && lCursor.getCount() == 1
							&& recordid < 0) {
						recordid = lCursor.getInt(0);
					}
				}

				if (recordid > 0
						|| 0 == getListView().getChildCount()
								- getListView().getHeaderViewsCount()
								- getListView().getFooterViewsCount()) {

				}
				if (recordid > 0) {
					sbarOn.sendEmptyMessageDelayed(2, 25);
					nbarOn.sendEmptyMessageDelayed(2, 225);
				} else {
					nbarOn.sendEmptyMessageDelayed(2, 25);
				}

				// nbarOff
			} catch (RuntimeException e2) {
				Log.i("ok", "error n " + e2.getMessage());
			}
		}
	};

	/*
	 * if (sdkVersion < 5) { columns = new String[] { People._ID, People.NAME,
	 * People.LAST_TIME_CONTACTED, People.PRIMARY_EMAIL_ID,
	 * People.CONTENT_ITEM_TYPE }; from = new String[] {
	 * People.CONTENT_ITEM_TYPE, People.DISPLAY_NAME, People.NAME,
	 * People.LAST_TIME_CONTACTED, People.PRIMARY_EMAIL_ID, People._ID };
	 * 
	 * } else if (um.equals(ContactsContract.Data.CONTENT_URI)) { to = new int[]
	 * { R.id.fielda, R.id.fieldc };
	 * 
	 * columns = new String[] { "_id", "display_name",//
	 * ContactsContract.Data.DISPLAY_NAME, "data1" };
	 * 
	 * from = new String[] { "display_name", //
	 * ContactsContract.Data.DISPLAY_NAME, //
	 * ContactsContract.Data.DISPLAY_NAME, "data1"//
	 * ContactsContract.Data.DATA1, //
	 * "is_primary",//ContactsContract.Data.IS_PRIMARY, };
	 * 
	 * where = ContactsContract.Data.MIMETYPE + " = '" +
	 * ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE +
	 * "') GROUP BY (data1"; // (distinct('data1')"; by =
	 * "display_name ASC, is_primary DESC, data1 ASC"; } else if
	 * (um.equals(Uri.parse("content://" + ctx.getPackageName() + "/checkin")))
	 * { to = new int[] { R.id.fielda, R.id.fieldb, R.id.fieldc, R.id.fieldid };
	 * 
	 * columns = new String[] { "_id", "atitle", "anext", "atill", "rotation",
	 * "created", "updated" }; from = new String[] { "atitle", "anext", "atill",
	 * "_id" };
	 * 
	 * } else {
	 * 
	 * // columns = new String[] { "_id", "atitle", "status", //
	 * "date(created) as cdate", "time(created) as tdate", // "created",
	 * "updated" };
	 * 
	 * }//
	 */

	// android.provider.Contacts.CONTENT_URI
	// Uri.parse("content://com.android.contacts")
	// int[] to = new int[] { R.id.fielda, R.id.fieldb, R.id.fieldc,
	// R.id.switcha, R.id.switchb, R.id.fieldid };

	// Divider list_divider_holo_dark.9.png
	// list_divider_horizontal_holo_dark.9.png

	// getListView().setOverScrollMode(mode)
	// getListView().setOnFocusChangeListener(cssf);
	// getListView().set

	// getListView().setDividerHeight(2);
	// getListView().setD

	//

	// if (atitle.length() > 0)

	// RelativeLayout vh = null;

	// if (getListView().getHeaderViewsCount() > 0) {
	// vh = (RelativeLayout) getListView().getChildAt(1);
	// if (vh != null) {
	// vh.removeAllViews();
	// }
	// }

	// if (getListView().getHeaderViewsCount() == 0) {
	// vh = new RelativeLayout(ctx);
	// while (findViewById(++hid) != null) {
	// }
	// vh.setId(hid);
	// vh.setLayoutParams(new ListView.LayoutParams(-1, -2));
	// vh.setBackgroundColor(Color.argb(145, 50, 50, 50));
	// vh.setBackgroundResource(R.drawable.cab_background_top_holo_dark);//
	// .dark_header);//
	// }

	// if (vh != null) {

	// FilterQueryProvider hb;
	// hb = entries.getFilterQueryProvider();
	// if (hb != null) {
	// hb.runQuery("atitle MATCH ?");
	// entries.setFilterQueryProvider(hb);
	// }
	// getListView().setTextFilterEnabled(true);

	// column.removeMessages(2);
	// column.sendEmptyMessageDelayed(2, 10);

	// getListView().setSelector(R.drawable.c3);
	// getListView().setBackgroundColor(Color.argb(120, 0, 102, 255));
	// getListView().requestFocusFromTouch();
	// getListView().setBackgroundColor(Color.argb(0, 0, 64, 171));
	// mHu.setBackgroundColor(Color.argb(0, 0, 64, 171));

	// registerForContextMenu(getListView());

	Handler nbarAdd = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {
				// getListView().setHeaderDividersEnabled(true);

				if (nbar == null) {
					LinearLayout n8 = new LinearLayout(ctx);
					RelativeLayout.LayoutParams t1r = new RelativeLayout.LayoutParams(
							-1, -2);
					t1r.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
					// nbarOn.sendEmptyMessageDelayed(n8.getId(), 150);
					if (mwidth > 720) {
						t1r.setMargins(mpad, 0, 0, 0);
					}
					n8.setLayoutParams(t1r);
					while (findViewById(++hid) != null) {
					}
					n8.setId(hid);
					n8.setOrientation(LinearLayout.HORIZONTAL);
					if (mwidth > 720) {
						n8.setBackgroundResource(R.drawable.cab_background_bottom_holo_dark);// .holotb6);
					} else {
						n8.setBackgroundResource(R.drawable.cab_background_bottom_holo_dark);// .holotb5);
					}

					n8.setVisibility(View.INVISIBLE);
					bear.addView(n8, 0);
					nbar = (LinearLayout) findViewById(n8.getId());
					{
						LinearLayout n8b = new LinearLayout(ctx);
						RelativeLayout.LayoutParams t5r = new RelativeLayout.LayoutParams(
								-1, -2);
						t5r.setMargins(8, 8, 8, 8);
						n8b.setLayoutParams(t5r);
						while (findViewById(++hid) != null) {
						}
						n8b.setId(hid);
						// n8b.setBackgroundResource(R.drawable.nano6);
						n8b.setOrientation(LinearLayout.HORIZONTAL);
						n8.addView(n8b);

						// && lCursor != null
						// && lCursor.getCount() == 1
						{

							ImageView t1 = new ImageView(ctx);
							LinearLayout.LayoutParams t2r = new LinearLayout.LayoutParams(
									-1, -2);
							t2r.weight = 1;
							t2r.setMargins(8, 8, 8, 8);
							t1.setLayoutParams(t2r);
							while (findViewById(++hid) != null) {
							}
							t1.setId(hid);
							t1.setScaleType(ScaleType.FIT_CENTER);
							t1.setImageResource(R.drawable.expander_open_holo_dark);
							n8b.addView(t1);// _close

							t1.setOnClickListener(new OnClickListener() {
								public void onClick(View v) {
									finish();
									// nbarOff.sendEmptyMessageDelayed(3, 25);

								}
							});
						}

						{
							ImageView t1 = new ImageView(ctx);
							LinearLayout.LayoutParams t2r = new LinearLayout.LayoutParams(
									-1, -2);
							t2r.weight = 1;
							t2r.setMargins(3, 3, 0, 0);
							t1.setLayoutParams(t2r);
							while (findViewById(++hid) != null) {
							}
							t1.setId(hid);
							t1.setScaleType(ScaleType.MATRIX);
							t1.setImageResource(R.drawable.ic_menu_gallery);
							// n8b.addView(t1);
						}

						{
							ImageView t1 = new ImageView(ctx);
							LinearLayout.LayoutParams t2r = new LinearLayout.LayoutParams(
									-1, -2);
							t2r.weight = 1;
							t2r.setMargins(8, 8, 8, 8);
							t1.setLayoutParams(t2r);
							while (findViewById(++hid) != null) {
							}
							t1.setId(hid);
							t1.setScaleType(ScaleType.FIT_CENTER);
							t1.setImageResource(R.drawable.ic_menu_search_holo_dark);
							n8b.addView(t1);
							t1.setOnClickListener(new OnClickListener() {
								public void onClick(View v) {
									onSearchRequested();
									// shareMe.sendEmptyMessageDelayed(2, 25);
								}
							});
						}

					}

				}

				if (getListView().getFooterViewsCount() == 0) {
					RelativeLayout fh = new RelativeLayout(ctx);
					while (findViewById(++hid) != null) {
					}
					fh.setId(hid);
					fh.setLayoutParams(new ListView.LayoutParams(-1,
							(int) (mheight / 3)));
					// getListView().addFooterView(fh, null, false);
				}

				if (mbar == null) {
					LinearLayout n8 = new LinearLayout(ctx);
					RelativeLayout.LayoutParams t1r = new RelativeLayout.LayoutParams(
							-1, -2);
					if (mwidth > 720) {
						t1r.setMargins(mpad, 0, 0, 0);
					}
					n8.setLayoutParams(t1r);
					while (findViewById(++hid) != null) {
					}
					n8.setId(hid);
					n8.setOrientation(LinearLayout.HORIZONTAL);
					n8.setBackgroundResource(R.drawable.cab_background_top_holo_dark);
					// n8.setBackgroundResource(R.drawable.btn_group_normal_holo_dark);
					n8.setVisibility(View.INVISIBLE);
					bear.addView(n8, 0);
					mbar = (LinearLayout) findViewById(n8.getId());

					TextView t1 = new TextView(ctx);
					{
						LinearLayout.LayoutParams t4r = new LinearLayout.LayoutParams(
								-1, -2);
						t4r.setMargins(8, 8, 8, 8);
						t4r.weight = 1;
						t1.setLayoutParams(t4r);
					}
					while (findViewById(++hid) != null) {
					}
					t1.setId(hid);
					t1.setPadding(8, 8, 8, 8);
					t1.setGravity(Gravity.CENTER);
					t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

					int ls = getListView().getChildCount()
							- getListView().getHeaderViewsCount()
							- getListView().getFooterViewsCount();
					t1.setText("" + ls);
					t1.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {

							sbarOff.sendEmptyMessageDelayed(3, 25);
						}
					});

					n8.addView(t1);

					Cursor b9;
					b9 = SqliteWrapper.query(ctx, getContentResolver(), um,
							new String[] {
									"distinct(date(created)) as createdd",
									"count(*)" }, where + " GROUP BY createdd",
							null, "created desc");
					// if (b9 != null && b9.moveToFirst()) {
					// if (b9.getCount() == 1) {
					// b9 = SqliteWrapper
					// .query(ctx,
					// getContentResolver(),
					// um,
					// new String[] {
					// "distinct(strftime('%H',created)) as createdd",
					// "count(*)" }, where
					// + " GROUP BY createdd",
					// null, by);
					// }
					// }

					if (b9 != null && b9.moveToFirst()) {
						for (int i = 0; i < b9.getCount(); i++) {
							b9.moveToPosition(i);
							TextView u9 = new TextView(ctx);
							LinearLayout.LayoutParams t2r = new LinearLayout.LayoutParams(
									-1, -2);
							t2r.weight = 1;
							t2r.setMargins(3, 3, 0, 0);
							u9.setLayoutParams(t2r);
							while (findViewById(++hid) != null) {
							}
							u9.setId(hid);
							// u9.setTextSize((float) 26);
							u9.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
							// u9.setBackgroundResource(R.drawable.dropdown_normal_holo_dark);
							u9.setBackgroundResource(R.drawable.btn_toggle_off_normal_holo_dark);

							// u9.setBackgroundColor(Color.argb(155, 18, 24,
							// 37));
							// u9.setGravity(Gravity.CENTER_VERTICAL);
							u9.setTextColor(Color.argb(255, 118, 204, 237));
							u9.setGravity(Gravity.CENTER);
							u9.setPadding(8, 8, 8, 8);
							u9.setText(b9.getString(0));// + "\n(" +
														// b9.getInt(1)
							// + ")");
							n8.addView(u9);

						}
					}
					if (b9 != null) {
						b9.close();
					}

				}
				// } catch (NullPointerException e8) {

			} catch (RuntimeException e2) {
				Log.i("ok", "error n " + e2.getMessage());
			} finally {
				reshow.sendEmptyMessageDelayed(2, 25);
			}
		}
	};

	OnHierarchyChangeListener cssh = new OnHierarchyChangeListener() {

		public void onChildViewAdded(View a, View b) {
			if (upause) {
				return;
			}
			// RelativeLayout ra = (RelativeLayout) b;
			// LinearLayout labb = (LinearLayout)
			// ra.getChildAt(0);
			// TextView fc = (TextView) labb.getChildAt(2);
			// if (fc != null) {
			// while (findViewById(++hid) != null) {
			// }
			// fc.setId(hid);
			// }
			// while (findViewById(++hid) != null) {
			// }
			// ra.setId(hid);
			// while (findViewById(++hid) != null) {
			// }
			// labb.setId(hid);

			column.removeMessages(2);
			column.sendEmptyMessageDelayed(2, 80);
			// columnx.removeMessages(2);
			// columnx.sendEmptyMessageDelayed(2, 20);

		}

		public void onChildViewRemoved(View a, View b) {
			// column.removeMessages(2);
			// column.sendEmptyMessageDelayed(2, 80);

			// RelativeLayout ra = (RelativeLayout) b;
			// LinearLayout labb = (LinearLayout)
			// ra.getChildAt(0);
			// TextView fc = (TextView) labb.getChildAt(2);
			// if (fc != null) {
			// fc.setBackgroundColor(Color.argb(0, 20, 0, 240));
			// }

		}
	};
	String ROWID = "rowid";// _id

	Handler openMe = new Handler() {
		public void handleMessage(Message msg) {
			if (recordid < 0) {
				return;
			}

			Intent nx = new Intent();

			// nx.setClass(ctx, Anumeric.class);
			nx.setAction(Intent.ACTION_VIEW);
			// nx.setAction(Intent.ACTION_GET_CONTENT);

			// nx.setData(Uri.parse("content://" + ctx.getPackageName() +
			// "/moment/"+recordid));

			Cursor ge = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://" + ctx.getPackageName() + "/moment"),
					new String[] { ROWID, "mres", "avec", "created",
							"acontent", "atitle", "date(created)", "lat",
							"lon", "adeep", "aheardlist", "hres",
							"animportlist" }, ROWID + " = " + recordid, null,
					null);
			if (ge != null && ge.moveToFirst()) {
				nx.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| Intent.FLAG_ACTIVITY_NO_HISTORY);
				String hres = ge.getString(11);

				File m9 = new File(
						hres != null ? hres.replaceAll("file:..", "") : "");

				if (m9.exists()) {
					// nx.putExtra(android.provider.MediaStore.EXTRA_FULL_SCREEN,
					// "true");

					nx.setType("image/png");
					nx.setData(Uri.fromFile(m9));
					// nx.putExtras(hx);
					startActivity(Intent.createChooser(nx,
							"Complete action using"));
				} else {
					// Toast error ?
				}
			}
			// Intent
			if (ge != null) {
				ge.close();
			}
		}
	};

	Handler shareMe = new Handler() {
		public void handleMessage(Message msg) {
			if (recordid < 0) {
				return;
			}

			Cursor ge = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://" + ctx.getPackageName() + "/moment"),
					new String[] { ROWID, "mres", "avec", "created",
							"acontent", "atitle", "date(created)", "lat",
							"lon", "adeep", "aheardlist", "hres",
							"animportlist" }, ROWID + " = " + recordid, null,
					null);
			// aheard
			if (ge != null && ge.moveToFirst()) {

				String indate = ge.getString(3);
				String cct = ge.getString(4);
				float lat = ge.getFloat(7);
				float lon = ge.getFloat(8);
				float adeep = ge.getInt(9);
				String cca = ge.getString(5);
				String cad = ge.getString(6);
				String aheardlist = ge.getString(10);
				String hres = ge.getString(11);
				String animportlist = ge.getString(12);
				if (aheardlist == null) {
					aheardlist = "";
				}// bet never happens :) database default ''

				String ccf = cca + " " + cad;
				Log.i("ok", ccf + " found " + aheardlist.replaceAll(",", ", ")
						+ "\n" + animportlist.replaceAll(",", ", "));

				String mss = "";
				if (cct != null && cct.length() > 2) {
					mss += cct + "\n";
				}

				if (lat != 0.0 || lon != 0.0) {
					// mss += "\n\n\n" + lat + "," + lon + " " + adeep + "\n";
					mss += "\n\n\n@here: http://maps.google.com/?ll=" + lat
							+ "," + lon + "";
					if (adeep > 25f) {
						mss += "\n(inside radius of " + adeep + "m)";
					}
				}
				mss += "\n@hen " + indate + "\n\n";

				File filea = new File(Environment.getExternalStorageDirectory()
						.getAbsolutePath(), "data/" + ctx.getPackageName()
						+ "/" + myDay());
				filea.mkdirs();
				ArrayList<Uri> uris = new ArrayList<Uri>();

				if (filea.exists()) {

					FileOutputStream o9;
					if (hres != null) {
						Log.i("ok", "sending file " + hres);
						File apng = new File(hres.replaceFirst("file:..", ""));
						if (apng.exists()) {
							uris.add(Uri.fromFile(apng));
						}
					}
					/*
					 * File apng = new File(filea.getAbsolutePath(), ccf +
					 * ".png"); if (ge.getBlob(2) != null) { try { o9 = new
					 * FileOutputStream(apng); o9.write(ge.getBlob(2));
					 * o9.close(); if (apng.exists()) {
					 * uris.add(Uri.fromFile(apng)); } } catch
					 * (FileNotFoundException e) { Log.i("ok", "wha io e 14");//
					 * e.printStackTrace(); } catch (IOException e) {
					 * Log.i("ok", "wha io e 15");// e.printStackTrace(); } }//
					 */
					/*
					 * apng = new File(filea.getAbsolutePath(), ccf + "_.png");
					 * if (ge.getBlob(1) != null) { try { o9 = new
					 * FileOutputStream(apng); o9.write(ge.getBlob(1));
					 * o9.close(); if (apng.exists()) {
					 * uris.add(Uri.fromFile(apng)); } } catch
					 * (FileNotFoundException e) { Log.i("ok", "wha io e 14");//
					 * e.printStackTrace(); } catch (IOException e) {
					 * Log.i("ok", "wha io e 15");// e.printStackTrace(); } }//
					 */
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
				}

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

					hj.putExtra(android.content.Intent.EXTRA_CC,
							new String[] { "havenskys@gmail.com" });

					hj.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
					hj.putExtra(Intent.EXTRA_SUBJECT, cca);
					startActivity(hj);

				}
			}

			if (ge != null) {
				ge.close();
			}
		}
	};

	public String myDay() {
		Date b = new Date();
		String d1 = "."// Explained in GosBitActivity
				+ (b.getYear() + 1900)
				+ ""
				+ (b.getMonth() < 9 ? "0" + (b.getMonth() + 1)
						: b.getMonth() + 1)
				+ ""
				+ (b.getDate() < 10 ? "0" + (b.getDate()) : b.getDate());
		return d1;
	}

	OnFocusChangeListener cssf = new OnFocusChangeListener() {

		public void onFocusChange(View a, boolean b) {
			if (b) {
				findFocusOn.sendEmptyMessageDelayed(a.getId(), 25);
			} else {
				findFocusOff.sendEmptyMessageDelayed(a.getId(), 25);
			}
		}
	};

	Handler findPressOn = new Handler() {
		public void handleMessage(Message msg) {
			RelativeLayout iu = (RelativeLayout) findViewById(msg.what);
			if (iu != null) {
				iu.setBackgroundResource(R.drawable.list_selector_pressed_holo_dark);
			}

		}
	};
	Handler findFocusOn = new Handler() {
		public void handleMessage(Message msg) {
			RelativeLayout iu = (RelativeLayout) findViewById(msg.what);
			if (iu != null) {
				iu.setBackgroundResource(R.drawable.list_selector_focused_holo_dark);
			}
		}
	};
	Handler findFocusOff = new Handler() {
		public void handleMessage(Message msg) {

			RelativeLayout iu = (RelativeLayout) findViewById(msg.what);
			if (iu != null) {
				iu.setBackgroundResource(R.drawable.list_selector_disabled_holo_dark);
			}
		}
	};

	OnScrollListener cssc = new OnScrollListener() {
		long cm = 1;

		public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			if (cm < SystemClock.uptimeMillis()) {
				cm = SystemClock.uptimeMillis() + 1880;
				// column.removeMessages(2);
				// columnb.removeMessages(2);
				// column.sendEmptyMessageDelayed(2, 220);

			}

		}

		public void onScrollStateChanged(AbsListView arg0, int arg1) {
			// TODO Auto-generated method stub
			if (arg1 == SCROLL_STATE_IDLE
					|| arg1 == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
				cm = 1;
				// columnx.removeMessages(2);
				// columnb.removeMessages(2);
				column.removeMessages(2);
				column.sendEmptyMessageDelayed(2, 120);
				nbarOff.removeMessages(2);
				nbarOff.sendEmptyMessageDelayed(2, 15880);

			} else if (arg1 == SCROLL_STATE_FLING) {
				// RelativeLayout ra = (RelativeLayout) b;
				// LinearLayout labb = (LinearLayout) ra.getChildAt(1);
				// TextView fc;
				// for (int ix = 0; ix < labb.getChildCount(); ix++) {
				// fc = (TextView) labb.getChildAt(ix);
				// if (fc != null) {
				// fc.setBackgroundColor(Color.argb(0, 20, 0, 240));
				// }
				// }
				// columnx.removeMessages(2);
				// columnx.sendEmptyMessageDelayed(2, 20);

				column.removeMessages(2);
				nbarOff.removeMessages(2);
				nbarOn.removeMessages(2);
				nbarOn.sendEmptyMessageDelayed(2, 175);
			}
		}

	};

	Handler columnx = new Handler() {
		public void handleMessage(Message msg) {
			columnx.removeMessages(2);

			for (int i = getListView().getHeaderViewsCount(); i < getListView()
					.getChildCount() - getListView().getFooterViewsCount(); i++) {
				RelativeLayout ra = (RelativeLayout) getListView()
						.getChildAt(i);

				if (ra != null) {

					// ra.setBackgroundColor(Color.argb(255, 99, 99, 99));
					// LinearLayout labb = (LinearLayout) ra.getChildAt(0);
					LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

					LinearLayout la2a = (LinearLayout) ra.getChildAt(0);
					LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);

					// for (int fx = 0; fx < la2.getChildCount(); fx++) {
					// ImageView fc1 = (ImageView) la2.getChildAt(fx);
					// if (fc1 != null && fc1.getVisibility() == View.VISIBLE) {
					// fc1.setText("");
					// fc1.setVisibility(View.INVISIBLE);
					// fc1.setBackgroundColor(Color.argb(150, 190, 190,
					// 190));
					// }
					// }

					{
						ImageView fc1 = (ImageView) la2.getChildAt(0);
						if (fc1 != null) {
							fc1.setVisibility(View.INVISIBLE);
						}
					}
					{
						ImageView fc1 = (ImageView) la1.getChildAt(1);
						if (fc1 != null) {
							fc1.setVisibility(View.INVISIBLE);
						}
					}
					// for (int fx = 0; fx < la1.getChildCount(); fx++) {
					// ImageView fc1 = (ImageView) la1.getChildAt(0);
					// if (fc1 != null && fc1.getVisibility() == View.VISIBLE) {
					// fc1.setText("");
					// fc1.setVisibility(View.INVISIBLE);
					// fc1.setBackgroundColor(Color.argb(150, 190, 190,
					// 190));
					// }
					// }
				}

			}

		}
	};

	Handler columna = new Handler() {
		public void handleMessage(Message msg) {

			// columnb.removeMessages(2);
			// columnb.sendEmptyMessageDelayed(2, 100);
		}
	};
	boolean listr = false;
	Handler column = new Handler() {
		long xh = 0;

		public void handleMessage(Message msg) {

			if (upause) {
				return;
			}

			try {

				// for (int i = getListView().getFirstVisiblePosition(); i <=
				// getListView()
				// .getLastVisiblePosition(); i++) {
				int ls = 0;
				if (getListView() != null) {
					ls = getListView().getChildCount()
							- getListView().getHeaderViewsCount()
							- getListView().getFooterViewsCount();
				}

				if (ls > 0) {

					if (!listr) {
						Log.i("ok", "column rest " + msg.what);
						column.sendEmptyMessageDelayed(msg.what, 1000 / 4);
						return;
					}

					column.removeMessages(msg.what);
					if (xh < SystemClock.uptimeMillis()) {
						xh = SystemClock.uptimeMillis() + 1880;
						// } else if (getListView() != null) {
						// Log.i("ok", "column rest b " + msg.what);
						// column.sendEmptyMessageAtTime(msg.what, 480);
						// return;
					} else {
						Log.i("ok", "column rest e " + msg.what);
						return;
					}
					Log.i("ok", "column "
							+ getListView().getFirstVisiblePosition() + " to "
							+ getListView().getLastVisiblePosition());

					for (int i = getListView().getHeaderViewsCount(); i < getListView()
							.getChildCount()
							- getListView().getFooterViewsCount(); i++) {

						RelativeLayout ra = (RelativeLayout) getListView()
								.getChildAt(i);

						if (ra != null) {
							// if (ra.getChildCount() < 2) {// header entry
							// probably
							// continue;
							// }

							while (findViewById(++hid) != null) {
							}
							ra.setId(hid);
							// ra.setBackgroundColor(Color.argb(255, 50, 50,
							// 50));
							ra.setBackgroundResource(R.drawable.list_selector_disabled_holo_dark);

							Bundle br = new Bundle();
							br.putInt("id", hid);
							br.putInt("v", i);
							Message hm = new Message();
							hm.setData(br);

							ra.setOnFocusChangeListener(cssf);
							final Bundle fb = new Bundle(br);
							OnTouchListener n89 = new OnTouchListener() {
								long ca = 1;
								float dif = 0f;
								float dx = 0f;

								public boolean onTouch(View a, MotionEvent ji) {
									// TODO Auto-generated method stub

									if (ji.getAction() == MotionEvent.ACTION_DOWN) {
										dif = ji.getX();
										ca = SystemClock.uptimeMillis() + 20;

										Message hfb = new Message();
										hfb.setData(fb);
										columnv.sendMessageDelayed(hfb, 20);
										nbarOn.sendEmptyMessageDelayed(2, 150);
										findPressOn.sendEmptyMessageDelayed(
												a.getId(), 25);
										// Log.i("wa", "" + (dif));
										// a.requestFocusFromTouch();
										return true;
									}
									if (ji.getAction() == MotionEvent.ACTION_UP) {
										findFocusOff.sendEmptyMessageDelayed(
												a.getId(), 25);

										return true;
									}

									if (ji.getAction() == MotionEvent.ACTION_MOVE) {

										if (ca < SystemClock.uptimeMillis()) {

											ca = SystemClock.uptimeMillis() + 20;
											dx = ji.getX();
											// Log.i("wash", "" + (dif - dx));

											if (dx > dif) {
												if (dx - dif > 88) {
													tg.sendEmptyMessageDelayed(
															2, 200);
													// return true;
												}
											}
											return true;
										}
									}

									return true;

								}
							};
							// ra.setOnTouchListener(n89);
							// <!-- :0 -->
							LinearLayout la2a = (LinearLayout) ra.getChildAt(0);
							// while (findViewById(++hid) != null) {
							// }
							// la2a.setId(hid);

							// LinearLayout la2 = (LinearLayout)
							// la2a.getChildAt(0);

							{// <!-- :0:1 -->
								LinearLayout la = (LinearLayout) la2a
										.getChildAt(1);
								while (findViewById(++hid) != null) {
								}
								// la.setId(hid);//HAVEN

								// <!-- :0:1:0 -->
								TextView fc3 = (TextView) la.getChildAt(0);
								if (fc3 != null
										&& getListView().getWidth() > 220) {
									// while (findViewById(++hid) != null) {
									// }
									// fc3.setId(hid);
									fc3.setVisibility(View.VISIBLE);
								}

								// <!-- :0:1:1 -->
								TextView fc5 = (TextView) la.getChildAt(1);
								if (fc5 != null
										&& getListView().getWidth() > 220) {
									// while (findViewById(++hid) != null) {
									// }
									// fc5.setId(hid);
									fc5.setVisibility(View.VISIBLE);
								}

								// <!-- :0:1:2 -->
								TextView fc6 = (TextView) la.getChildAt(2);
								if (fc6 != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fc6.setId(hid);
								}

								// <!-- :0:1:3 -->
								TextView fc7 = (TextView) la.getChildAt(3);
								if (fc7 != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fc7.setId(hid);
								}
							}

							{// <!-- :2 -->
								TextView fc = (TextView) ra.getChildAt(2);
								if (fc != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fc.setId(hid);
									fc.setVisibility(View.INVISIBLE);
								}

							}

							// <!-- :1 -->
							LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
							while (findViewById(++hid) != null) {
							}
							// la1a.setId(hid);//HAVEN
							{ // <!-- :1:0 -->
								LinearLayout la1 = (LinearLayout) la1a
										.getChildAt(0);
								// while (findViewById(++hid) != null) {
								// }
								// la1.setId(hid);

								// <!-- :1:0:0 -->
								ImageView fc4 = (ImageView) la1.getChildAt(0);
								if (fc4 != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fc4.setBackgroundColor(Color.argb(0, 0,
									// 0,
									// 0));
									// fc4.setId(hid);
									fc4.setScaleType(ScaleType.MATRIX);
									// fc4.setText("");
									fc4.setVisibility(View.GONE);
								}

								// <!-- :1:0:0 -->
								ImageView fc1 = (ImageView) la1.getChildAt(1);
								if (fc1 != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fc1.setBackgroundColor(Color.argb(0, 0,
									// 0,
									// 0));
									fc1.setScaleType(ScaleType.MATRIX);
									// fc1.setId(hid);
									// fc1.setText("");
									fc1.setVisibility(View.GONE);
								}
							}

							{// <!-- :0:0 -->
								LinearLayout la2 = (LinearLayout) la2a
										.getChildAt(0);
								// while (findViewById(++hid) != null) {
								// }
								// la2.setId(hid);

								// <!-- :0:0:0 -->
								ImageView fi4 = (ImageView) la2.getChildAt(0);
								if (fi4 != null) {
									// while (findViewById(++hid) != null) {
									// }
									// fi4.setId(hid);
									fi4.setVisibility(View.GONE);
								}

								// <!-- :0:0:1 -->
								ImageView fi41 = (ImageView) la2.getChildAt(1);
								if (fi41 != null
										&& getListView().getWidth() > 220) {
									// while (findViewById(++hid) != null) {
									// }
									// fi41.setId(hid);
									fi41.setVisibility(View.VISIBLE);
								}

							}
							hm.what = 2;
							columnv.sendMessageDelayed(hm, 20 + 75 * i);

						}

					}
				}

				// column.removeMessages(2);
				// column.sendEmptyMessageDelayed(2, 20000);

			} catch (RuntimeException e2) {
				Log.i("ok", "error c9 " + e2.getMessage());
			}

		}
	};

	Handler tg = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			Log.i("ok", "exit");
			finish();

		}
	};

	Handler columnv = new Handler() {
		public void handleMessage(Message msg) {

			if (upause) {
				return;
			}
			try {
				Bundle bd = msg.getData();
				int id = bd.getInt("id");
				int i = bd.getInt("v");
				RelativeLayout ra = (RelativeLayout) getListView()
						.getChildAt(i);

				if (ra != null && ra.getChildCount() > 2) {
					// ra.setId(id);
					// ra.setBackgroundColor(Color.argb(155, 83, 186, 219));
					if (recordid == getListView().getItemIdAtPosition(i)) {
						ra.setBackgroundResource(R.drawable.list_selector_activated_holo_dark);
					} else {
						ra.setBackgroundResource(R.drawable.list_selector_disabled_holo_dark);
					}

					Bundle br = new Bundle();
					br.putInt("id", id);
					br.putInt("v", i);
					Message hm = new Message();
					hm.what = 2;
					hm.setData(br);
					columnr.sendMessageDelayed(hm, 20);

				}
			} catch (RuntimeException e2) {
				Log.i("ok", "error n6 " + e2.getMessage());
			}

		}
	};

	Handler columnr = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {

				Bundle bd = msg.getData();
				int id = bd.getInt("id");
				int i = bd.getInt("v");

				RelativeLayout ra = (RelativeLayout) getListView()
						.getChildAt(i);

				// RelativeLayout ra = (RelativeLayout) findViewById(id);
				if (ra != null
						&& i >= getListView().getHeaderViewsCount()
						&& i < getListView().getChildCount()
								- getListView().getFooterViewsCount()) {

					// ra.setBackgroundColor(Color.argb(170, 196, 149, 221));
					ra.setBackgroundResource(R.drawable.list_selector_disabled_holo_dark);

					LinearLayout la2a = (LinearLayout) ra.getChildAt(0);
					// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);

					LinearLayout la = (LinearLayout) la2a.getChildAt(1);
					// TextView fc3 = (TextView) la.getChildAt(0);
					TextView fc = (TextView) la.getChildAt(2);
					// LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
					// LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

					// LinearLayout la1 = (LinearLayout) ra.getChildAt(1);
					// TextView fc1 = (TextView) la1.getChildAt(1);

					if (fc != null) {
						// fc.setBackgroundColor(Color.argb(120, 120, 0, 140));
						// Log.i("row",
						// "" + i + ": " + ra.getId() + " : " + labb.getId()
						// + " : " + fc.getId() + " : " + la1.getId()
						// + " : " + fc1.getId() + " : " + fc3.getId());

						Bundle ba = new Bundle();
						ba.putInt("id", id);
						ba.putInt("v", i);
						Message ma = new Message();
						ma.what = 2;
						ma.setData(ba);
						cktest.sendMessageDelayed(ma, 25);

					} else {
						Log.i("ok", "x " + i);
					}

				} else {
					Log.i("ok", "" + i + ". " + id);
				}
			} catch (RuntimeException e2) {
				Log.i("ok", "error n7 " + e2.getMessage());
			}

		}
	};

	Handler cktest = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}

			try {
				Bundle ba = msg.getData();

				int id = ba.getInt("id");
				int i = ba.getInt("v");
				RelativeLayout ta = (RelativeLayout) getListView()
						.getChildAt(i);
				if (ta == null) {
					return;
				}
				LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
				if (la2a == null) {
					Log.i("ok", "cktest " + i);
					return;
				}

				// ta.setBackgroundColor(Color.argb(255, 5, 5, 5));

				// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
				LinearLayout la = (LinearLayout) la2a.getChildAt(1);
				TextView fc = (TextView) la.getChildAt(2);
				// fc.setBackgroundColor(Color.argb(155, 123, 206, 238));

				Bundle bx = new Bundle(ba);
				Message mx = new Message();
				mx.what = 2;
				mx.setData(bx);
				cktest2.sendMessageDelayed(mx, 880);

			} catch (RuntimeException e2) {
				Log.i("ok", "error n8 " + e2.getMessage());
			}

		}
	};

	Handler cku = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}

			try {
				Bundle ba = msg.getData();

				int id = ba.getInt("id");
				int i = ba.getInt("v");
				RelativeLayout ta = (RelativeLayout) getListView()
						.getChildAt(i);
				if (ta == null) {
					ta = (RelativeLayout) findViewById(id);
				}

				if (ta != null) {
					LinearLayout la1a = (LinearLayout) ta.getChildAt(1);
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
					// LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
					// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
					// LinearLayout la = (LinearLayout) la2a.getChildAt(1);

					// LinearLayout labb = (LinearLayout) ta.getChildAt(1);
					ImageView fc = (ImageView) la1.getChildAt(1);

					// fc.setText("");
					// fc.setBackgroundColor(Color.argb(155, 88, 192, 221));

					for (int ic = 1; ic < 100; ic++) {
						if (ck.containsKey("c" + ic)) {
							// v[i] = ck.getString("c" + i).split("\n");
							Bundle bh = new Bundle(ba);
							bh.putInt("pvid", ic);
							Message mx = new Message();
							mx.what = 2;
							mx.setData(bh);
							cku1.sendMessageDelayed(mx, 200);
						} else {
							break;
						}
					}
				}
			} catch (RuntimeException e2) {
				Log.i("ok", "error n9 " + e2.getMessage());
			}

		}
	};

	boolean fts3 = true;

	Handler cku1 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();
			if (upause) {
				return;
			}

			try {

				int id = ba.getInt("id");
				int i = ba.getInt("v");
				final int vi = ba.getInt("pvid");
				RelativeLayout ta = (RelativeLayout) getListView()
						.getChildAt(i);
				if (ta == null) {
					ta = (RelativeLayout) findViewById(id);
				}

				if (ta != null && ta.getChildCount() > 2) {
					LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
					// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
					LinearLayout la = (LinearLayout) la2a.getChildAt(1);

					// LinearLayout la = (LinearLayout) ta.getChildAt(0);

					TextView fa = (TextView) la.getChildAt(0);

					final String ffa = fa.getText().toString();
					TextView fc;
					if (v[vi][2].contains("fieldid")) {
						fc = (TextView) ta.getChildAt(2);
					} else if (v[vi][2].contains("fieldc")) {
						fc = (TextView) la.getChildAt(2);
						// fc.setVisibility(View.VISIBLE);
					} else {
						fc = (TextView) ta.getChildAt(2);
					}

					final String ffc = fc.getText().toString();
					// fc.setVisibility(View.VISIBLE);
					String where = "";

					if (ffc.length() == 0) {
						fc.setVisibility(View.VISIBLE);
						fc.setText("blerg");
						where = "atitle = '" + ffa + "'";
					} else {
						where = v[vi][3] + " = \"" + ffc + "\"";
					}

					Cursor e = SqliteWrapper.query(ctx, getContentResolver(),
							Uri.parse(v[vi][0]),
							new String[] { v[vi][1], ROWID,
									(v[vi].length < 6 ? "1" : v[vi][5]) },
							where, null, null);

					// Log.i("ok", "see using where(" + v[vi][3] + " = " + ffc
					// + ") (" + ffa + ") " + vi + ": " + v[vi][4] + " ");

					LinearLayout la1a = (LinearLayout) ta.getChildAt(1);

					if (v[vi][4].contains("audio")) {
						LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
						ImageView fa1 = (ImageView) la1.getChildAt(0);
						fa1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));
						// fa1.setBackgroundColor(Color.argb(155, 102, 153, 0));

						if (e != null && e.moveToFirst()) {

							if (fts3) {
								final String aheardlist = e.getString(0);
								String pr8 = e.getString(2);
								File pe5 = null;
								if (pr8 != null) {
									// Log.i("ok", " aheard " + pr8);

									pe5 = new File(pr8.replaceFirst("file:..",
											""));

									if (pe5.exists()) {
										fa1.setImageURI(Uri.fromFile(pe5));
										// fa1.setBackgroundDrawable(Drawable
										// .createFromPath());
										final String fp = aheardlist;
										fa1.setOnClickListener(new OnClickListener() {

											public void onClick(View a) {

												// TextView ab = (TextView)
												// a;
												Bundle hu = new Bundle();
												hu.putInt("id", a.getId());
												hu.putString("path", aheardlist);
												Message m8 = new Message();
												m8.setData(hu);
												m8.what = 2;
												if (xuut != null) {
													xuut.stop();
													xuut.release();
												}
												playaudio2.removeMessages(2);
												playaudio2.sendMessageDelayed(
														m8, 20);

											}
										});
									}
								}

								if (pe5 == null || !pe5.exists()) {
									fa1.setImageResource(R.drawable.ic_menu_close_clear_cancel);
								}
								fa1.setScaleType(ScaleType.MATRIX);
								// int pr9 = 1;
								// try {
								// pr9 = Integer.parseInt(pr8);
								// } catch (NumberFormatException nu) {
								// Log.i("ok", "error parsing " + pr8);
								// pr9 = R.drawable.ic_menu_close_clear_cancel;
								// } finally {
								// fa1.setBackgroundResource(pr9);
								// }

								if (aheardlist != null) {
									String[] hx = aheardlist.split(",");
									File apng;
									for (int c = 0; c < hx.length; c++) {
										apng = new File(hx[c]);
										if (apng.exists()) {
											// fa1.setText("");
											// fa1.setGravity(Gravity.CENTER);
											// fa1.setTextSize(14);
											// fa1.setBackgroundColor(Color.argb(155,
											// 153, 204, 0));
											// fa1.setBackgroundResource(R.drawable.ic_menu_play_clip);
										}
									}
								}

							} else {
								byte[] g3;
								g3 = e.getBlob(0);
								if (g3 == null) {
									e.close();
									return;
								}
								Log.i("ok",
										i + " " + v[vi][1] + " " + v[vi][3]
												+ " = \"" + ffc + "\" " + ":"
												+ e.getString(1) + ": "
												+ g3.length);

								// fa1.setText("" + g3.length);

								// fa1.setGravity(Gravity.CENTER);
								// fa1.setTextSize(14);
								// fa1.setBackgroundColor(Color.argb(55, 0, 240,
								// 0));

								final byte[] fg = g3;
								fa1.setBackgroundResource(R.drawable.ic_menu_play_clip);

								fa1.setOnClickListener(new OnClickListener() {

									public void onClick(View a) {

										TextView ab = (TextView) a;
										Bundle hu = new Bundle();
										hu.putByteArray("audio", fg);
										hu.putInt("id", ab.getId());
										Message mu = new Message();
										mu.what = 2;
										mu.setData(hu);
										playaudio.sendMessageDelayed(mu, 20);

									}
								});
							}

						}

						fa1.setVisibility(View.VISIBLE);
					} else if (v[vi][4].contains("imagea")) {
						LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);

						// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
						ImageView fi1 = (ImageView) la2.getChildAt(1);

						// fi1.setBackgroundColor(Color.argb(55, 0, 0, 240));

						if (e != null && e.moveToFirst()) {
							// File
							fi1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));

							if (fts3) {
								String mres = e.getString(0);
								// Log.i("ok", "using mres " + mres);

								File m9 = new File(
										mres != null ? mres.replaceAll(
												"file:..", "") : "");

								if (m9.exists()) {
									// try {

									fi1.setImageURI(Uri.parse(mres));

									// t1.setImageDrawable(Drawable
									// .createFromPath(mres));
								} else {
									fi1.setImageResource(getApplicationInfo().icon);
								}

							} else {
								byte[] g3;
								g3 = e.getBlob(0);
								if (g3 == null) {
									e.close();
									return;
								}

								Bitmap xt = null;
								Bitmap xh = null;

								try {
									xt = BitmapFactory.decodeByteArray(g3, 0,
											g3.length);
									xh = Bitmap.createScaledBitmap(xt,
											xt.getWidth() / 5,
											xt.getHeight() / 5, true);
								} catch (OutOfMemoryError sf) {
									Log.w("OOM",
											"xxx " + sf.getLocalizedMessage());
								}
								fi1.setImageBitmap(xh);
							}

							// fi1.setPadding(8, 8, 8, 8);
							fi1.setScaleType(ScaleType.FIT_CENTER);

							fi1.setVisibility(View.VISIBLE);
						}

					} else if (v[vi][4].contains("imageb")) {
						// LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
						// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
						// LinearLayout la = (LinearLayout) la2a.getChildAt(1);

						LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);

						// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
						ImageView fi1 = (ImageView) la2.getChildAt(0);

						// fi1.setBackgroundColor(Color.argb(55, 0, 0, 240));

						if (e != null && e.moveToFirst()) {
							byte[] g3;
							g3 = e.getBlob(0);
							if (g3 == null) {
								e.close();
								return;
							}

							fi1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));

							Bitmap xt = null;
							Bitmap xh = null;

							try {
								xt = BitmapFactory.decodeByteArray(g3, 0,
										g3.length);
								xh = Bitmap.createScaledBitmap(xt,
										xt.getWidth() / 5, xt.getHeight() / 5,
										true);

							} catch (OutOfMemoryError sf) {
								Log.w("OOM", "xxx");
							}
							// fi1.setPadding(8, 8, 8, 8);
							fi1.setScaleType(ScaleType.FIT_CENTER);
							// fi1.setImageDrawable(hi);
							fi1.setImageBitmap(xh);
							fi1.setVisibility(View.VISIBLE);
						} else {

							fi1.setVisibility(View.VISIBLE);
							fi1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));
						}

					} else if (v[vi][4].contains("string")) {
						// LinearLayout la1 = (LinearLayout) ta.getChildAt(1);
						LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
						ImageView fc1 = (ImageView) la1.getChildAt(1);

						// fc1.setBackgroundColor(Color.argb(55, 0, 0, 240));
						if (e != null && e.moveToFirst()) {
							Log.i("ok", i + " " + v[vi][1] + " " + " "
									+ v[vi][3] + " = \"" + ffc + "\" " + ":"
									+ e.getString(1) + ": " + e.getString(0));

							fc1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));

							// fc1.setGravity(Gravity.CENTER);
							// fc1.setLines(5);
							// fc1.setText("" + e.getString(0));
							// fc1.setTextSize(19);
							fc1.setClickable(false);
							// fc1.setPadding(8, 8, 8, 8);

							// Log.i("row"," ")
							// fc1.setLayoutParams(new
							// LinearLayout.LayoutParams(-2,
							// -2));

							fc1.setOnTouchListener(new OnTouchListener() {
								long ca = 1;
								float dif = 0f;
								float dx = 0f;
								int vl = 1;

								public boolean onTouch(View a, MotionEvent ji) {
									// TODO Auto-generated method stub
									if (ji.getAction() == MotionEvent.ACTION_UP
											|| ji.getAction() == MotionEvent.ACTION_CANCEL) {
										amover2.sendEmptyMessageDelayed(2, 2);
										// getListView().setClickable(true);
									}
									if (ji.getAction() == MotionEvent.ACTION_DOWN) {
										dif = ji.getX();
										ca = SystemClock.uptimeMillis() + 20;
										amover.sendEmptyMessageDelayed(2, 75);
										TextView ab = (TextView) a;
										if (ab.length() > 0) {
											if (ab.length() == 1) {
												try {
													vl = Integer.parseInt(ab
															.getText()
															.toString());
												} catch (NumberFormatException em) {
													vl = 1;
												}
											} else {
												vl = Integer.parseInt(ab
														.getText().toString());
											}
										}
										// Log.i("wa", "" + (dif));
										return true;
									}

									if (ji.getAction() == MotionEvent.ACTION_MOVE) {

										if (ca < SystemClock.uptimeMillis()) {

											ca = SystemClock.uptimeMillis() + 20;
											dx = ji.getX();
											// Log.i("wash", "" + (dif - dx));
											TextView ab = (TextView) a;
											if (dx < dif) {
												ab.setText(""
														+ (vl + (1 * (int) (dif - dx))));
											} else {
												ab.setText(""
														+ (vl + (10 * (int) (dif - dx))));
											}

											ab.setTextSize(12);

											// if (dx > dif) {
											// if (dx - dif > 88) {
											// tg.sendEmptyMessageDelayed(2,
											// 200);
											// return true;
											// }
											// }
											return true;
										}
									}

									return false;

								}
							});

						} else {

							fc1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));
							// fc1.setGravity(Gravity.CENTER);
							// fc1.setText(">");
							// fc1.setPadding(8, 8, 8, 8);
							// fc1.setTextSize(50);
							fc1.setClickable(true);
							fc1.setOnTouchListener(new OnTouchListener() {

								public boolean onTouch(View arg0,
										MotionEvent arg1) {
									// TODO Auto-generated method stub
									return false;
								}
							});

							final Bundle fb = new Bundle(ba);
							fc1.setOnClickListener(new OnClickListener() {

								public void onClick(View arg0) {
									Cursor e = SqliteWrapper.query(ctx,
											getContentResolver(),
											Uri.parse(v[vi][0]),
											new String[] { v[vi][1] }, v[vi][3]
													+ " = \"" + ffc + "\""
													+ " ", null, null);

									if (e != null && e.moveToFirst()) {

									} else {
										ContentValues cx = new ContentValues();
										cx.put("email", ffc);
										cx.put("display", ffa);
										cx.put("rotation", 14);

										Uri xuri = SqliteWrapper.insert(
												ctx,
												ctx.getContentResolver(),
												Uri.parse("content://"
														+ ctx.getPackageName()
														+ "/contact"), cx);
									}
									if (e != null) {
										e.close();
									}
									Message hfb = new Message();
									hfb.what = 2;
									hfb.setData(fb);
									columnv.sendMessageDelayed(hfb, 200);
									// column.sendEmptyMessageDelayed(2, 200);

								}
							});

						}

					} else if (v[vi][4].contains("numeric")) {
						// LinearLayout la1 = (LinearLayout) ta.getChildAt(1);
						// LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
						// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
						// LinearLayout la = (LinearLayout) la2a.getChildAt(1);

						LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

						ImageView fc1 = (ImageView) la1.getChildAt(1);

						// fc1.setBackgroundColor(Color.argb(55, 0, 0, 240));
						if (e != null && e.moveToFirst()) {
							Log.i("ok", i + " " + v[vi][1] + " " + " "
									+ v[vi][3] + " = \"" + ffc + "\" " + ":"
									+ e.getString(1) + ": " + e.getString(0));

							fc1.setLayoutParams(new LinearLayout.LayoutParams(
									mxw, mxh));
							// fc1.setMinHeight(88);

							// fc1.setGravity(Gravity.CENTER);
							// fc1.setLines(5);
							// fc1.setText("" + e.getString(0));
							// fc1.setTextSize(19);
							// fc1.setClickable(false);
							final String tab = e.getString(0);
							final Bundle fb = new Bundle(ba);
							fc1.setOnTouchListener(new OnTouchListener() {
								long ca = 1;
								float dif = 0f;
								float dx = 0f;
								int vl = 1;

								public boolean onTouch(View a, MotionEvent ji) {
									// TODO Auto-generated method stub
									if (ji.getAction() == MotionEvent.ACTION_DOWN) {
										Message mh = new Message();
										Bundle fx = new Bundle(fb);
										fx.putInt("x", (int) ji.getRawX());
										fx.putInt("y", (int) ji.getRawY());
										fx.putInt("n", Integer.parseInt(tab));
										fx.putInt("max", 24 * 60);
										fx.putInt("min", 0);

										mh.setData(fx);
										numeric.sendMessageDelayed(mh, 20);
										return true;
									}
									return false;
								}
							});
						}

					}

					if (e != null) {
						e.close();
					}

					// fc.setText("" + fc.getId());
					// Bundle bh = new Bundle(ba);
					// Message mx3 = new Message();
					// mx3.what = 2;
					// mx3.setData(bh);
					// cku2.sendMessageDelayed(mx3, 200);
				}

			} catch (OutOfMemoryError sf) {
				Log.w("OOM", "xxx 6b " + sf.getLocalizedMessage());
			} catch (RuntimeException e2) {
				Log.i("ok", "error n9 " + e2.getMessage());

			}
		}
	};

	Handler numeric = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bl = msg.getData();
			Bundle hx = new Bundle(bl);
			Intent nx = new Intent();

			// nx.setClass(ctx, Anumeric.class);
			nx.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_NO_HISTORY);
			nx.putExtras(hx);
			startActivity(nx);

		}
	};
	Handler amover = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			if (getListView() != null) {
				getListView().setClickable(false);
			}
		}
	};

	Handler amover2 = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			if (getListView() != null) {
				getListView().setClickable(true);
			}
		}
	};
	int vin = 1;
	Handler playaudio = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			try {
				if (xuut != null) {
					xuut.stop();
					xuut.release();
				}
				playaudio2.removeMessages(2);

				Bundle ba = msg.getData();
				byte[] s = ba.getByteArray("audio");
				int id = ba.getInt("id");
				TextView ho4 = (TextView) findViewById(id);
				if (ho4 != null) {
					// ho4.setBackgroundResource(R.drawable.ic_menu_refresh);

					// ho4.setBackgroundColor(Color.argb(55, 0, 240, 0));
				}
				/*
				 * { File filea = new
				 * File(Environment.getExternalStorageDirectory()
				 * .getAbsolutePath(), "ok/opt"); filea.mkdirs();
				 * 
				 * File file = new File(filea.getAbsolutePath(), "vh" + (vsv) +
				 * ".3gp");
				 * 
				 * FileInputStream fs = null;
				 * 
				 * try { fs = new FileInputStream(file); byte[] bf = new
				 * byte[(int) file.length()]; fs.read(bf, 0, (int)
				 * file.length()); e.put("aback", bf); // Toast.makeText( //
				 * ctx, // file.getAbsolutePath() + "\n" // + file.length() +
				 * "\n" // + e.getAsByteArray("aback").length, // 2300).show();
				 * 
				 * } catch (FileNotFoundException e2) {
				 * 
				 * e2.printStackTrace(); } catch (IOException e2) { // TODO
				 * Auto-generated catch block e2.printStackTrace(); } }//
				 */
				File filea = new File(Environment.getExternalStorageDirectory()
						.getAbsolutePath(), "ok/opt");
				filea.mkdirs();

				File file = new File(filea.getAbsolutePath(), "bh" + (++vin)
						+ ".3gp");

				FileOutputStream fs = null;

				fs = new FileOutputStream(file);
				// byte[] bf = new byte[(int) file.length()];
				fs.write(s);// , 0, (int) s.length);
				// e.put("aback", bf);
				// Toast.makeText(
				// ctx,
				// file.getAbsolutePath() + "\n"
				// + file.length() + "\n"
				// + e.getAsByteArray("aback").length,
				// 2300).show();
				fs.flush();
				fs.close();

				Bundle b8 = new Bundle();
				b8.putString("path", file.getAbsolutePath());
				Message m8 = new Message();
				m8.setData(b8);
				m8.what = 2;
				playaudio2.sendMessageDelayed(m8, 200);

			} catch (FileNotFoundException e2) {
				Log.e("whoo", e2.getLocalizedMessage());
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				Log.e("IO WH", e2.getLocalizedMessage());
			} catch (RuntimeException e2) {
				Log.i("ok", "audio stop error n5 " + e2.getMessage());
			}

			// try {
			// } catch (IOException k5) {
			// setr("Drat " + k5.getLocalizedMessage());
			// }

		}
	};
	int lastplay = 0;
	Handler playaudio2 = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			Bundle ba = msg.getData();
			String path = ba.getString("path");
			int id = ba.getInt("id");
			Log.i("ok", "playaudio " + id + " "
					+ (path != null ? path : "-no path-") + " ");

			ImageView ho4 = (ImageView) findViewById(id);
			if (ho4 == null) {
				return;
				// ho4.setBackgroundColor(Color.argb(55, 0, 0, 240));
			}

			xuut = new MediaPlayer();
			xuut.setWakeMode(getApplicationContext(),
					PowerManager.PARTIAL_WAKE_LOCK);
			try {
				if (path.length() == 0 && aheardlist.length() > 0) {
					path = aheardlist;
				}
				if (path.contains(",")) {
					String[] hx = path.split(",");
					File apng;
					int ddc = 1;
					for (int c = 0; c < hx.length; c++) {
						if (hx[c].length() > 0) {
							apng = new File(hx[c]);
							if (apng.exists()) {

								Bundle b8 = new Bundle(ba);
								b8.putString("path", hx[c]);
								Message m8 = new Message();
								m8.setData(b8);
								// xuut.setDataSource(hx[c]);
								// xuut.prepare();
								Log.i("ok", "Expecting audio " + hx[c] + " in "
										+ ddc + " + "
										+ ((apng.length() / 1024) * 4));
								m8.what = 2;

								playaudio2.sendMessageDelayed(m8, ddc);
								ddc += 850 + (int) (apng.length() / 1.3);
								// new MediaPla
							}

						}
					}
				} else if (path.length() > 0) {

					File ap = new File(path);
					if (ap.exists()) {
						AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
						int result = audioManager.requestAudioFocus(newb,
								AudioManager.STREAM_MUSIC,
								AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

						if (result != AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
							Log.i("ok", "no audio grant");
							// could not get audio focus.

						} else {
							Log.i("ok",
									"playing audio file "
											+ ap.getAbsolutePath() + " "
											+ ap.length());

							// if (ap.length() > 1000) {
							Animation a6 = AnimationUtils.loadAnimation(ctx,
									R.anim.playon);

							a6.setStartOffset(75);
							a6.setDuration((int) ((ap.length())));
							ho4.clearAnimation();
							xuut.setDataSource(ctx, Uri.fromFile(ap));

							// xuut.setVolume(1f, 1f);
							xuut.prepare();
							xuut.start();

							ho4.startAnimation(a6);
							// }

							// ho4.setImageResource(R.drawable.ic_media_pause);
						}
					}
				}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				Log.i("ok", "playing audio b " + e.getMessage());
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				Log.i("ok", "playing audio c " + e.getMessage());

				e.printStackTrace();
			} catch (IOException e) {
				Log.i("ok", "playing audio d " + e.getMessage());
				// if (e.getLocalizedMessage().contains("Prepare")) {
				// } else {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// }
			} catch (RuntimeException e2) {
				Log.i("ok", "runerror n " + e2.getMessage());

			}// .setDataSource(file.getAbsolutePath());

		}
	};

	OnAudioFocusChangeListener newb = new OnAudioFocusChangeListener() {
		public void onAudioFocusChange(int fc) {
			Log.i("ok", "Focus change audio " + fc);

			try {
				switch (fc) {
				case AudioManager.AUDIOFOCUS_GAIN:
					// resume playback
					if (xuut == null) {
						Log.i("ok", "HUH, GAIN AUDIO nothing to play.");
						// initMediaPlayer();
					} else if (!xuut.isPlaying()) {
						xuut.start();
						xuut.setVolume(1.0f, 1.0f);
					}
					break;

				case AudioManager.AUDIOFOCUS_LOSS:
					// Lost focus for an unbounded amount of time: stop playback
					// and
					// release media player
					if (xuut != null && xuut.isPlaying()) {
						xuut.stop();
					}

					xuut.release();
					xuut = null;
					break;

				case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
					// Lost focus for a short time, but we have to stop
					// playback. We don't release the media player because
					// playback
					// is likely to resume
					if (xuut != null && xuut.isPlaying()) {
						xuut.pause();
					}

					break;
				case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
					// Lost focus for a short time, but it's ok to keep playing
					// at an attenuated level
					if (xuut != null && xuut.isPlaying()) {
						xuut.setVolume(0.1f, 0.1f);
					}
					break;
				// case default:
				// Log.i("ok","AUDIO FOCUS INSTRUCTION " + fc);
				// break;
				}
			} catch (RuntimeException e2) {
				Log.w("ok", "audio running " + e2.getMessage());
			}

		}
	};
	MediaPlayer xuut;
	Handler cku2 = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			final int vi = ba.getInt("pvid");

			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);
			if (ta == null) {
				ta = (RelativeLayout) findViewById(id);
			}

			if (ta != null && ta.getChildCount() > 2) {
				LinearLayout la1a = (LinearLayout) ta.getChildAt(1);
				LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

				LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
				LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
				// LinearLayout la = (LinearLayout) la2a.getChildAt(1);
				// LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);

				if (v[vi][4].contains("audio")) {
					ImageView fc = (ImageView) la1.getChildAt(0);
					// fc.setText("");
					// fc.setBackgroundColor(Color.argb(120, 0, 240, 0));

				} else if (v[vi][4].contains("imagea")) {
					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(1);
					// fi1.setBackgroundColor(Color.argb(0, 0, 0, 240));

				} else if (v[vi][4].contains("imageb")) {
					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(0);
					// fi1.setBackgroundColor(Color.argb(0, 0, 0, 240));

				} else if (v[vi][4].contains("string")) {
					ImageView fc = (ImageView) la1.getChildAt(1);
					// fc.setBackgroundColor(Color.argb(120, 130, 0, 240));

				} else if (v[vi][4].contains("numeric")) {
					// LinearLayout labb = (LinearLayout) ta.getChildAt(1);
					ImageView fc = (ImageView) la1.getChildAt(1);
					// fc.setBackgroundColor(Color.argb(120, 0, 210, 240));
					// fc.setText("");
				} // Bundle bh = new Bundle(ba);
					// Message mx3 = new Message();
					// mx3.setData(bh);cku2.sendMessageDelayed(mx3,200);
			}
		}
	};

	Handler cktest2 = new Handler() {
		public void handleMessage(Message msg) {
			if (upause) {
				return;
			}
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);

			if (ta != null
					&& i >= getListView().getHeaderViewsCount()
					&& i < getListView().getChildCount()
							- getListView().getFooterViewsCount()) {

				// ta.setBackgroundColor(Color.argb(56, 20, 0, 240));
				LinearLayout la2a = (LinearLayout) ta.getChildAt(0);
				// LinearLayout la2 = (LinearLayout) la2a.getChildAt(0);
				LinearLayout la = (LinearLayout) la2a.getChildAt(1);
				TextView fc = (TextView) la.getChildAt(2);
				// fc.setBackgroundColor(Color.argb(55, 0, 0, 240));

				if (ba.getInt("cc", 0) == 0) {
					Bundle bh = new Bundle(ba);
					bh.putInt("cc", 1);
					Message mx = new Message();
					mx.what = 2;
					mx.setData(bh);

					cku.sendMessageDelayed(mx, 200 + 10 * i);
				} else if (ba.getInt("cc") == 1) {
					return;
				}
				ba.putInt("cc", ba.getInt("cc", 0) + 1);

				Bundle bx = new Bundle(ba);
				Message mx = new Message();
				mx.what = 2;
				mx.setData(bx);
				cktest.sendMessageDelayed(mx, 880);
			} else {
			}

		}
	};

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		{
			MenuItem o3 = menu.add(1, 13, 2, "Search");
			o3.setTitle("Search");
			o3.setIcon(R.drawable.ic_menu_search);
		}

		{

			MenuItem o3 = menu.add(1, 3, 5, "Settings");
			o3.setTitle("Settings");
			o3.setIcon(R.drawable.ic_menu_preferences);
		}

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {

		case 13:
			onSearchRequested();
			break;

		case 3: {
			Intent r42 = new Intent();
			r42.setAction(Intent.ACTION_VIEW);
			r42.putExtra("title", "Settings");
			// r42.setData("cu", "content://" + ctx.getPackageName() +
			// "/checkin");
			// r42.putExtra("c1", "content://" + ctx.getPackageName()
			// + "/checkin\nrotation\nfieldid\n_id\nnumeric");

			startActivity(r42);
		}
			break;

		}

		return super.onMenuItemSelected(featureId, item);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (event.getUnicodeChar() > 0
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			onSearchRequested();
			return true;
		}

		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		column.removeMessages(2);
		columnx.removeMessages(2);
		upause = true;
		Log.i("ok", "pause");
		// newb

		AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		audioManager.abandonAudioFocus(newb);
		// Listener
		// Focus
		// playon
		try {
			if (xuut != null) {
				xuut.stop();
				xuut.release();
			}

			// Audio
			playaudio2.removeMessages(2);
			nbarOn.removeMessages(2);
			nbarOff.removeMessages(2);
			nbarOffb.removeMessages(2);
			sbarOffb.removeMessages(2);
			cku1.removeMessages(2);
			cktest2.removeMessages(2);
			cktest.removeMessages(2);
			cku.removeMessages(2);
			cku2.removeMessages(2);
			columnv.removeMessages(2);
			columnr.removeMessages(2);
			tg.removeMessages(2);
			reshow.removeMessages(2);
		} catch (RuntimeException e2) {
			Log.i("ok", "audio onpause stop error " + e2.getMessage());
		}
		// .send
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("ok", "restart");

	}

	boolean upause = false;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("ok", "resume           ======================== ");

		upause = false;
		// s01.sendEmptyMessageDelayed(2, 75);
		column.sendEmptyMessageDelayed(2, 280);
		// columnx.sendEmptyMessageDelayed(2, 20);
		// finish();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		// Log.i("ok", "search");
		return super.onSearchRequested();
	}

}

package com.docchomps.gosbit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;

public class IntentReceiver extends BroadcastReceiver {

	// private Custom mLog;

	// private static Object mStartingServiceSync = new Object();
	private WakeLock m5;
	private Context ctx;
	boolean priv = false;

	protected void onReceiveWithPrivilege(Context context, Intent intent,
			boolean privileged) {
		priv = privileged;
		ctx = context;
		action = intent.getAction();
		if (action == null) {
			action = "";
		}

		serviceStart.sendEmptyMessageDelayed(2, 10);
	}

	public void onReceive(Context context, Intent intent) {
		onReceiveWithPrivilege(context, intent, false);
		return;
	}

	// ctx = context;
	// action = intent.getAction();
	// serviceStart.sendEmptyMessageDelayed(2, 20);

	// Log.i("ok",
	// "99.9999        Internals Interconnections: "
	// + intent.getAction() + "");

	// MapView mx;
	Editor edt;
	SharedPreferences reg;

	Handler rub = new Handler() {
		public void handleMessage(Message msg) {
			pm = (PowerManager) ctx.getSystemService(Context.POWER_SERVICE);
			if (pm != null) {
				Log.i("ok", "Activating CPU");
				pm.userActivity(SystemClock.uptimeMillis() + 10, false);
				m5 = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
						"Activate CPU");
				m5.acquire();
				m5.release();
				m5 = null;
				pm = null;
			}
		}
	};

	Handler serviceStart = new Handler() {
		// long cs = 1;

		public void handleMessage(Message msg) {

			reg = ctx.getSharedPreferences("Preferences",
					Context.MODE_WORLD_WRITEABLE);
			edt = reg.edit();

			if (action.contains("SERVICE_STATE")
					&& reg.getLong("cs7", 1) < System.currentTimeMillis() - 23 * 60 * 1000) {

				Log.i("ok",
						"99.9999           Internals Interconnections "
								+ action
								+ " "
								+ priv
								+ " "
								+ (System.currentTimeMillis() - reg.getLong(
										"cs7", 1)) + "ms since last");
				// cs = SystemClock.uptimeMillis();
				edt.putLong("cs7", System.currentTimeMillis());
				edt.commit();
				// rub.sendEmptyMessageDelayed(2, 75);
				// gpsupdate.sendEmptyMessageDelayed(2, 200);
				networkstate.sendEmptyMessageDelayed(2, 200);
				// / try {
				// edt.commit();
				// } catch (OutOfMemoryError eh) {
				// Log.i("ok",
				// "no saving occured reasonable to ignore at once per scooch rate.");
				// }
			}

			if (reg.getLong("cs8", 1) < System.currentTimeMillis()
					- reg.getInt("gpsminutes", 8) * 60 * 1000) {
				edt.putLong("cs8", System.currentTimeMillis());
				edt.commit();
				// rub.sendEmptyMessageDelayed(2, 75);
				gpsupdate.sendEmptyMessageDelayed(2, 200);
				// networkstate.sendEmptyMessageDelayed(2, 400);
			}
		}
	};

	Handler networkstate = new Handler() {
		public void handleMessage(Message msg) {
			ConnectivityManager cnnm = (ConnectivityManager) ctx
					.getSystemService(Context.CONNECTIVITY_SERVICE);

			if (cnnm == null) {
				Log.w("ok", "Network Off");
				edt.putLong("anetwork", 3);
				edt.commit();
				return;
			}

			NetworkInfo ninfo = cnnm.getActiveNetworkInfo();
			if (ninfo == null) {
				Log.w("ok", "Network Off");
				edt.putLong("anetwork", 2);
				edt.commit();
			} else {
				if (ninfo.isAvailable()) {
					if (ninfo.isConnectedOrConnecting() || ninfo.isConnected()) {
						edt.putLong("anetwork", System.currentTimeMillis());
						edt.commit();
					}
					ninfo = null;
				} else {
					ninfo = null;
					edt.putLong("anetwork", 1);
					edt.commit();
				}

			}

		}
	};

	Handler gpsupdate = new Handler() {
		public void handleMessage(Message msg) {
			gpsupdate.removeMessages(2);

			if (reg.getLong("adeepset", 1) < System.currentTimeMillis() - 20000) {
				Log.i("ok",
						"99.9999                  Internals Interconnections: gps "
								+ msg.what);

				LocationManager mLocator = (LocationManager) ctx
						.getSystemService(Context.LOCATION_SERVICE);

				Location l = mLocator
						.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				if (l == null) {
					l = mLocator
							.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				}

				if (l != null) {
					if (reg.getFloat("lon", 1f) != (float) l.getLongitude()
							|| reg.getFloat("lat", 1f) != (float) l
									.getLatitude()
							|| reg.getFloat("adeep", 1f) != (float) l
									.getAccuracy()
							|| reg.getFloat("altitude", 1f) != (float) l
									.getAltitude()) {

						if (reg.getLong("adeepset", 1) > System
								.currentTimeMillis() - 5 * 60000
								&& reg.getFloat("adeep", 99999f) < l
										.getAccuracy()) {
							Log.i("ok",
									"99.9999       Internals Interconnections:          BONUS B");

						} else {
							Log.i("ok",
									"99.9999                  Internals Interconnections: gps "
											+ l.getLatitude() + ","
											+ l.getLongitude() + ","
											+ l.getAccuracy() + ","
											+ l.getAltitude());

							edt.putFloat("lon", (float) l.getLongitude());
							edt.putFloat("lat", (float) l.getLatitude());
							edt.putFloat("adeep", (float) l.getAccuracy());
							edt.putLong("adeepset", System.currentTimeMillis());
							edt.putFloat("altitude", (float) l.getAltitude());
							try {
								edt.commit();
							} catch (OutOfMemoryError eh) {
								Log.i("ok",
										"b no saving occured reasonable to ignore at once per scooch rate.");
							}
						}
					}
				}

				l = null;
				mLocator = null;

			}
		}
	};

	PowerManager pm;
	String action = "";

	// mLog = new Custom(context, TAG + " onReceiveWithPrivilege() 27");
	// SharedPreferences mReg = mCtx.getSharedPreferences("Preferences",
	// mCtx.MODE_WORLD_WRITEABLE);
	// Editor mEdt = mReg.edit();
	// mEdt.putInt("count_intent", mReg.getInt("count_intent", 0) + 1);
	// mEdt.commit();

	// Log.w(TAG, "onReceiveWithPrivilege(Action Received:" + action + ")");

	/*
	 * public static void beginHostingService(Context context, Intent intent) {
	 * //Custom mLog = new Custom(context, TAG + " beginHostingService() 42");
	 * //android.intent.action.BOOT_COMPLETED
	 * 
	 * Log.i(TAG,
	 * "beginHostingService() ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * );
	 * 
	 * mCtx = context; //synchronized (mStartingServiceSync){ Log.i(TAG,
	 * "beginHostingService() synchronized() ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); if(mWakeService == null){ Log.i(TAG,
	 * "beginHostingService() PowerManager ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); PowerManager pm =
	 * (PowerManager)context.getSystemService(Context.POWER_SERVICE);
	 * mWakeService = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
	 * "StartingSyncService"); mWakeService.setReferenceCounted(false); }
	 * Log.i(TAG,
	 * "beginHostingService() WakeService.acquire() ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); mWakeService.acquire();
	 * 
	 * Log.i(TAG,
	 * "beginHostingService() startService() ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * ); mCtx.startService(intent); //} } /* public static void
	 * finishHostingService(AutomaticService service, int serviceId) {
	 * 
	 * //Custom mLog = new Custom(service.getApplicationContext(), TAG +
	 * " finishHostingService() 66"); Log.i(TAG,
	 * "finishHostingService() ++++++++++++++++++++++++++++++++++++++++++++++++"
	 * );
	 * 
	 * synchronized (mStartingServiceSync){ if(mStartingServiceSync != null){
	 * Log.i(TAG,"finishHostingService() stop Self Result"); if(
	 * service.stopSelfResult(serviceId) ){
	 * Log.i(TAG,"finishHostingService() release Wake Service");
	 * mWakeService.release(); } } }
	 * 
	 * }//
	 */

}

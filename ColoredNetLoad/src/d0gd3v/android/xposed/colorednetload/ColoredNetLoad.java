package d0gd3v.android.xposed.colorednetload;

import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class ColoredNetLoad implements IXposedHookZygoteInit, IXposedHookInitPackageResources {
    private static final String PKG_NAME_SYSTEM_UI = "com.android.systemui";
    private static String MODULE_PATH = null;
    private XSharedPreferences mPrefs;

    public enum PREFS {
	WIFI_COLOR, MOBILE_COLOR
    }

    public enum COLORS {
	STOCK, BLACK, BLUE, GREEN, ORANGE, RED, WHITE, YELLOW
    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
	MODULE_PATH = startupParam.modulePath;
	mPrefs = new XSharedPreferences(this.getClass().getPackage().getName());
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
	if (!resparam.packageName.equals(PKG_NAME_SYSTEM_UI))
	    return;
	XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);
	replaceWifiSignalization(resparam, modRes);
	replaceMobileSignalization(resparam, modRes);
    }

    private void replaceWifiSignalization(InitPackageResourcesParam resparam, XModuleResources modRes) {
	switch (COLORS.valueOf(mPrefs.getString(PREFS.WIFI_COLOR.name(), COLORS.STOCK.name()))) {
	case BLACK:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_black_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_black_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_black_t64));
	    break;
	case BLUE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_blue_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_blue_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_blue_t64));
	    break;
	case GREEN:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_green_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_green_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_green_t64));
	    break;
	case ORANGE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_orange_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_orange_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_orange_t64));
	    break;
	case RED:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_red_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_red_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_red_t64));
	    break;
	case WHITE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_white_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI,  "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_white_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_white_t64));
	    break;
	case YELLOW:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_inout",
		    modRes.fwd(R.drawable.stat_sys_wifi_inout_yellow_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_in",
		    modRes.fwd(R.drawable.stat_sys_wifi_in_yellow_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_wifi_out",
		    modRes.fwd(R.drawable.stat_sys_wifi_out_yellow_t64));
	    break;	
	default:
	    break;
	}
    }

    private void replaceMobileSignalization(InitPackageResourcesParam resparam, XModuleResources modRes) {
	switch (COLORS.valueOf(mPrefs.getString(PREFS.MOBILE_COLOR.name(), COLORS.STOCK.name()))) {
	case STOCK:
	    break;
	case BLACK:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_black_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_black_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_black_t64));
	    break;
	case BLUE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_blue_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_blue_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_blue_t64));
	    break;
	case GREEN:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_green_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_green_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_green_t64));
	    break;
	case ORANGE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_orange_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_orange_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_orange_t64));
	    break;
	case RED:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_red_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_red_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_red_t64));
	    break;
	case WHITE:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_white_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_white_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_white_t64));
	    break;
	case YELLOW:
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_inout",
		    modRes.fwd(R.drawable.stat_sys_signal_inout_yellow_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_in",
		    modRes.fwd(R.drawable.stat_sys_signal_in_yellow_t64));
	    resparam.res.setReplacement(PKG_NAME_SYSTEM_UI, "drawable", "stat_sys_signal_out",
		    modRes.fwd(R.drawable.stat_sys_signal_out_yellow_t64));
	    break;
	default:
	    break;
	}
    }
}

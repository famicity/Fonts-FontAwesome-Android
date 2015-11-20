package fr.cobaltians.fonts.fontAwesome;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.font.CobaltAbstractFontDrawable;

/**
 * Created by sebastienfamel on 16/10/2015.
 */
public class FontAwesomeDrawable extends CobaltAbstractFontDrawable {
    private static final String TAG = FontAwesomeDrawable.class.getSimpleName();

    private static final String FONT_FILE = "FontAwesome.ttf";
    public static final int TEXT_COLOR_LIGHT = Color.argb(153, 51, 51, 51);
    public static final int TEXT_COLOR_DARK = Color.argb(204, 255, 255, 255);

    public FontAwesomeDrawable(Context context, String text, int color) {
        super(context, text, color, context.getResources().getDimensionPixelSize(R.dimen.textSize), context.getResources().getDimensionPixelSize(R.dimen.padding));
    }

    @Override
    protected String getStringResource(String identifier) {
        if (identifier.contains("-")) {
            identifier = identifier.replace("-", "_");
        }
        try {
            String packageName = mContext.getPackageName();
            int resourceId = mContext.getResources().getIdentifier(identifier, "string", packageName);
            if (resourceId != 0) {
                String iconId = mContext.getResources().getString(resourceId);
                return iconId;
            }
            else if (Cobalt.DEBUG) Log.e(TAG, "- getStringResource : no found resource");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected String getFontFilePath() {
        return FONT_FILE;
    }
}

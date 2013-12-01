package vob.lib;

import junit.framework.Assert;
import android.content.Context;

public class ResourceR {
	
	public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }
	
	public static int getRaw(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "raw", context.getPackageName());
    }
}

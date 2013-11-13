package vob.lib;

import junit.framework.Assert;
import android.content.Context;

public class GetImage {
	
	public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }
}

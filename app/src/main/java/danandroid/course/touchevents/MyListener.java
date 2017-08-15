package danandroid.course.touchevents;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Jakars on 15/08/2017.
 */

public class MyListener extends GestureDetector.SimpleOnGestureListener {
    private static final String TAG = "Ness";

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float x1 = e1.getX();
        float x2 = e2.getX();

        float y1 = e1.getY();
        float y2 = e2.getY();

        float dx = x2 - x1;
        float dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)){
            //Horizontal swipe
            if (x2 > x1){
                Log.d(TAG, "Swiped Right");
            }else {
                Log.d(TAG, "Swiped Left");
            }
        }else {
            //Vertical swipe
            if (y2 > y1){
                Log.d(TAG, "Swiped Down");
            }else {
                Log.d(TAG, "Swiped Up");
            }
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}

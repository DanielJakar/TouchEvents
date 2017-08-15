package danandroid.course.touchevents;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Ness";
    private GestureDetectorCompat detector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new HatView(this));

        detector = new GestureDetectorCompat(this,
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                        if (e1 == null || e2 == null) return true;//?
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
        );
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        /*
        int action = e.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "OntouchEvent: Action_Down");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "OntouchEvent: Action_Up");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "OntouchEvent: Action_Move");
                break;
        }

        float x = e.getX();
        float y = e.getY();

        PointF p = new PointF(x, y);
        Log.d(TAG, "onTouchEvent: " + p);
        */
        return super.onTouchEvent(e);

        //return detector.onTouchEvent(e);
    }
}

class A{

}

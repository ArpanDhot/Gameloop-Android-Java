package com.example.leaningandroidgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * SurfaceHolder.Callback
 * A client may implement this interface to receive information about changes to the surface.
 * When used with a SurfaceView, the Surface being held is only available between calls to
 * surfaceCreated(android.view.SurfaceHolder) and surfaceDestroyed(android.view.SurfaceHolder).
 * The Callback is set with SurfaceHolder.addCallback method.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    public GamePanel(Context context){
        super(context);

        //Access to the underlying surface is provided via the SurfaceHolder interface,
        // which can be retrieved by calling getHolder()
        getHolder().addCallback(this);

        //Instantiating MainThread class that we made
        thread = new MainThread(getHolder(),this);

        setFocusable(true);

    }




    //These methods are same to the default activity run cycle that saad explained

    /**
     * This is called immediately after any structural changes (format or size) have been made to the surface
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }


    /**
     * This is called immediately after the surface is first created.
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder){
          thread = new MainThread(getHolder(),this);


          thread.setRunning(true);
          thread.start();
    }


    /**
     * This is called immediately before a surface is being destroyed.
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean  retry = true;
        while(true){
            try {
                thread.setRunning(false);
            thread.join();
            } catch(Exception e ){
                e.printStackTrace();
            }
            retry=false;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return  super.onTouchEvent(event);
    }


    public void update(){

    }

    @Override
    public  void  draw(Canvas canvas) {

        super.draw(canvas);
    }

}

package me.jfenn.hmosutils.touch;

import ohos.agp.components.Component;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.multimodalinput.event.TouchEvent;

/**
 * WhileHeldListener method implements onTouchEvent.
 */
public abstract class WhileHeldListener implements Component.TouchEventListener, Runnable {

    private static final HiLogLabel HI_LOG_LABEL = new HiLogLabel(0, 0, "WhileHeldListener");
    private EventHandler handler;
    private int interval;

    protected WhileHeldListener() {
        interval = 100;
    }

    protected WhileHeldListener(int interval) {
        this.interval = interval;
    }

    public abstract void onHeld();

    @Override
    public boolean onTouchEvent(Component v, TouchEvent event) {
        switch (event.getAction()) {
            case TouchEvent.PRIMARY_POINT_DOWN:
                if (handler != null) {
                    return true;
                }
                handler = new EventHandler(EventRunner.getMainEventRunner());
                handler.postTask(this);
                break;
            case TouchEvent.PRIMARY_POINT_UP:
                if (handler == null) {
                    return true;
                }
                handler.removeTask(this);
                handler = null;
                break;
            default:
                HiLog.debug(HI_LOG_LABEL, "onTouchEvent default switch case");
        }
        return false;
    }

    @Override
    public void run() {
        onHeld();
        if (handler != null) {
            handler.postTask(this, interval);
        }
    }
}
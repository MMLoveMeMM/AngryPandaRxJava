package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: CompletableTimer
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:02
 * @Description: Completable定时器
 */
public class CompletableTimer {

    private static final String TAG = CompletableTimer.class.getName();
    private Disposable mDisposable;

    public void cbCreateByTimer() {
        mDisposable = Completable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Completable3  timer");
                    }
                });
    }

    public void cancelTimer() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

}

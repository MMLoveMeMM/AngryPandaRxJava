package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObCreateTimer
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 17:46
 * @Description: java类作用描述
 */
public class ObCreateTimer {

    private static final String TAG = ObCreateTimer.class.getName();
    private Disposable mDisposable;

    public void ObCreateByTimer() {
        Log.e(TAG, "start time at " + System.currentTimeMillis() + "\n");
        mDisposable = Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "execute time at " + System.currentTimeMillis() + "\n");
                    }
                });
    }

    public void cancelTimer() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

}

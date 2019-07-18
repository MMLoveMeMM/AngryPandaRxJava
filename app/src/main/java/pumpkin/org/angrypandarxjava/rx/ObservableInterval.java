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
 * @ClassName: ObservableInterval
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 17:26
 * @Description: java类作用描述
 */
public class ObservableInterval {
    private static final String TAG = ObservableInterval.class.getName();
    private Disposable mDisposable;

    public void ObCreateByInterval() {
        /**
         * 3s 后开始执行事务处理
         * 每隔2s发射一次事务
         * 需要主动调用结束
         */
        mDisposable = Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "interval :" + aLong + " at " + System.currentTimeMillis() + "\n");
                    }
                });
    }

    public void ObCreateByIntervalRange() {
        /**
         * 从0开始,一共发射10次
         * 3s 后开始执行事务处理
         * 每隔2s发射一次事务
         * 达到次数自动结束或者需要主动调用结束
         */
        mDisposable = Observable.intervalRange(0,10, 3,2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "interval :" + aLong + " at " + System.currentTimeMillis() + "\n");
                    }
                });
    }

    /**
     * 取消订阅
     */
    public void cancelSubscribe() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}

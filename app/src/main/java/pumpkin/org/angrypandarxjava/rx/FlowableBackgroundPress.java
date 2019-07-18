package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: FlowableBackgroundPress
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 10:18
 * @Description: Flowable背压策略
 */
public class FlowableBackgroundPress {

    private static final String TAG = FlowableBackgroundPress.class.getName();

    public void ObservableDeal() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                int i = 0;
                while (true) {
                    /**
                     * 发送速度非常快
                     */
                    e.onNext("data : " + (i++));
                }
            }
        }).subscribeOn(Schedulers.io()) // 发送者处理事务线程
                .observeOn(AndroidSchedulers.mainThread()) // 观察者处理事务线程
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        /**
                         * 接受/观察者处理速度相对较慢
                         */
                        Thread.sleep(2000);
                        Log.d(TAG, s);
                    }
                });
    }

    /**
     * 背压策略
     */
    public void FlowableDeal() {

        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {
                int i = 0;
                while (true) {
                    e.onNext("data:" + (i++));
                }
            }
        }, BackpressureStrategy.DROP)//超出缓冲池的数据丢弃
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                        subscription.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, s);
                        subscription.request(1); //处理完了，在请求数据
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

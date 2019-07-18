package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableSubscribe
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 20:17
 * @Description: java类作用描述
 */
public class ObservableSubscribe {
    private static final String TAG = ObservableSubscribe.class.getName();
    private Disposable mDisposable;

    Observer<Object> observer= new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            // 回调返回Disposable 对象，让观察者管理订阅状态， 例如取消订阅
            mDisposable = d;
            Log.d(TAG,"  onSubscribe ");
        }
        @Override
        public void onNext(@NonNull Object o) {
            //数据接收处理
            Log.d(TAG," onNext "+o.toString());
        }
        @Override
        public void onError(@NonNull Throwable e) {
            //发生异常，终止事件流
            Log.d(TAG," onError "+e.getMessage());
        }
        @Override
        public void onComplete() {
            //事件流结束
            Log.d(TAG," onComplete ");
        }
    };

    public void ObCreateSubscribe(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello world!");
                emitter.onComplete();
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);
    }

    public void cancelSubscribe(){
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

}
/*
    subscribe(Observer o)
    subscribe()//参数为空，即使观察者为null,Observeable也会在subscribe()的时候创建，处理，发射数据。
    subscribe( Consumer<? super T> onNext)
    subscribe(Consumer<? super T> onNext, Consumer<? super Throwable> onError)
    subscribe( Consumer<? super T> onNext) subscribe(Consumer<? super T>
        onNext, Consumer<? super Throwable> onError)
        subscribe( Consumer<? super T> onNext) subscribe(Consumer<? super T>
        onNext, Consumer<? super Throwable> onError) subscribe(Consumer<?
super T> onNext, Consumer<? super Throwable> onError,Action
        onComplete)

*/
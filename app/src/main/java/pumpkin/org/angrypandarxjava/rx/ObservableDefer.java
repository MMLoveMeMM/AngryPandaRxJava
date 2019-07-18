package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableDefer
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 10:36
 * @Description: 直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable，
 * 该操作符能保证订阅执行时数据源是最新的数据
 */
public class ObservableDefer {
    private static final String TAG = ObservableJust.class.getName();

    private Consumer<String> consumers;
    private Observer<String> observer;
    public void ObCreateByDefer(){

        consumers = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG,"consumer : "+s);
            }
        };

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG,"onNext : "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        String test="old data";
        final Observable observable=Observable.just(test);
        Observable observableDefer =  Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return observable;
            }
        });
        test="new data";
        observable.subscribe(consumers);// 打印  old data
        observableDefer.subscribe(consumers);// 打印  new data
    }
}

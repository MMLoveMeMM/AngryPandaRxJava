package pumpkin.org.angrypandarxjava.rx.transformer;

import android.util.Log;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: TransformerToMain
 * @Author: 刘志保
 * @CreateDate: 2019/9/26 17:24
 * @Description: java类作用描述
 */
public class TransformerToMain {

    private static final String TAG = TransformerToMain.class.getName();

    public void TransformerToMainTest(){
        /*---------无背压---------*/
        Observable.
                create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        if (!emitter.isDisposed()) {
                            Log.d(TAG, "无背压 currentThread:" + Thread.currentThread());
                            emitter.onNext("test");
                            emitter.onComplete();
                        }
                    }
                }).
                compose(new ObservableTransformer<String, String>() {
                    @Override
                    public ObservableSource<String> apply(Observable<String> upstream) {
                        return upstream.
                                subscribeOn(Schedulers.newThread()).
                                observeOn(AndroidSchedulers.mainThread());
                    }
                }).
                subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String o) {
                        Log.d(TAG, "无背压 onNext:" + o);
                        Log.d(TAG, "无背压 currentThread:" + Thread.currentThread());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        /*---------有背压---------*/
        Flowable.create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                        if (!emitter.isCancelled()) {
                            Log.d(TAG, "有背压 currentThread:" + Thread.currentThread());
                            emitter.onNext("test");
                            emitter.onComplete();
                        }
                    }
                }, BackpressureStrategy.DROP).
                compose(new FlowableTransformer<String, String>() {
                    @Override
                    public Publisher<String> apply(Flowable<String> upstream) {
                        // 切换到主线程
                        return upstream.
                                subscribeOn(Schedulers.newThread()).
                                observeOn(AndroidSchedulers.mainThread());
                    }
                }).subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "有背压 onNext:" + s);
                        Log.d(TAG, "有背压 currentThread:" + Thread.currentThread());
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

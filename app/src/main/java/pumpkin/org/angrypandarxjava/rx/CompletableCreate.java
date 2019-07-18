package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: CompletableCreate
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 8:50
 * @Description: java类作用描述
 */
public class CompletableCreate {
    private static final String TAG = CompletableCreate.class.getName();

    public void cbCreate(){
        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                Log.d(TAG,"Completable0  subscribe");
                // e.onNext(); 相比其他的没有这个
                e.onComplete();
            }
        }).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG,"Completable0  onSubscribe");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completable0  onComplete");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Completable0  onError");
            }
        });
    }
}

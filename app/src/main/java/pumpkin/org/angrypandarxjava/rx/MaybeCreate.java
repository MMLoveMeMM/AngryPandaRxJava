package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: MaybeCreate
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:55
 * @Description: Maybe&MaybeObserver模式跟Single/SingleObserver模式，
 * Completable&CompletableObserver模式的不同，也同样是在CompletableObserver的回调方法中，
 * MaybeObserver需要实现的方法没有onNext(Object o), 有onComplete(), onSuccess（Object o)方法，
 * onComplete(), onSuccess（Object o)两个分支只会走一个
 */
public class MaybeCreate {

    private static final String TAG = MaybeCreate.class.getName();

    public void obCreate() {
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> e) throws Exception {
                Log.d(TAG, "Maybe0    subscribe");
                e.onComplete();
                e.onSuccess("maybe one");
                e.onSuccess("maybe two");
                e.onSuccess("maybe three");

            }
        }).subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "Maybe0    onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Log.d(TAG, "Maybe0    onSuccess " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Maybe0    onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Maybe0    onComplete");
            }
        });

    }

    public void obCreate2() {
        Maybe.just(true).
                subscribe(new MaybeObserver<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "Maybe1  just onSubscribe");
                    }

                    @Override
                    public void onSuccess(@NonNull Boolean aBoolean) {
                        Log.d(TAG, "Maybe1  just onSuccess " + aBoolean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "Maybe1  just onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "Maybe1  just onComplete");
                    }
                });
    }

}

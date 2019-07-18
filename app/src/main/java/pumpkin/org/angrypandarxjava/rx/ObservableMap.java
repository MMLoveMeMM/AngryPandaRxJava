package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableMap
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:12
 * @Description: 发射的对象和map中的形成对应的k-v map键值组成map
 */
public class ObservableMap {
    private static final String TAG = ObservableMap.class.getName();

    public void obCreateByMap(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "This is result " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Log.d(TAG, "accept : " + s +"\n" );
            }
        });
    }
}

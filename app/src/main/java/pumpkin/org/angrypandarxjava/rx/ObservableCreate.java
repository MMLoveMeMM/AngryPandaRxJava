package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableCreate
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 10:13
 * @Description: 创建事务处理
 */
public class ObservableCreate {

    private static final String TAG = ObservableCreate.class.getName();

    private ObservableEmitter<String> observableEmitter;
    private ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
            Log.d(TAG, "subscribe");
            observableEmitter = e;
            observableEmitter.onNext("Observable  数据data");
            emitData();
        }
    };
    private void emitData(){
        if (observableEmitter != null) {
            for (int i = 0; i < 10; i++) {
                //数据发射源对象发射数据
                observableEmitter.onNext("Observable  数据data " + i);
            }
            observableEmitter.onComplete();
        }
    }

    public void ObCreate() {
        //数据发射源对象
        Observable observable = (Observable) Observable.create(observableOnSubscribe)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG,"onNext : "+s);
                    }
                });
    }

}

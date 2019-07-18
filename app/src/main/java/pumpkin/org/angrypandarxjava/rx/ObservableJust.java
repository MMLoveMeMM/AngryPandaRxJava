package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableJust
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 10:22
 * @Description: java类作用描述
 */
public class ObservableJust {

    private static final String TAG = ObservableJust.class.getName();

    public void ObCreateByJust(){
        Observable.just("1", "2", "3")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.e(TAG,"accept : onNext : " + s + "\n" );
                    }
                });
    }

}

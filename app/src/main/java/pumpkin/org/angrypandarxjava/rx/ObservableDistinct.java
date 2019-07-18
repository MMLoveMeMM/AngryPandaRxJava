package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableDistinct
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:35
 * @Description: 去重操作符，简单的作用就是去重
 */
public class ObservableDistinct {

    private static final String TAG = ObservableDistinct.class.getName();

    public void obCreateByDistinct(){
        Observable.just(1, 1, 1, 2, 2, 3, 4, 5)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "distinct : " + integer + "\n");
                    }
                });
    }

}

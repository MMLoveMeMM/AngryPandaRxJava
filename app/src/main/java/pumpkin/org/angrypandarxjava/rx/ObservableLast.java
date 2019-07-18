package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableLast
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:18
 * @Description: 操作符仅取出可观察到的最后一个值，或者是满足某些条件的最后一项
 */
public class ObservableLast {

    private static final String TAG = ObservableLast.class.getName();

    public void obCreateByLast(){
        Observable.just(1, 2, 3)
                .last(2) // 都会是最后一个事务执行
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.d(TAG, "last : " + integer + "\n");
                    }
                });
    }
}

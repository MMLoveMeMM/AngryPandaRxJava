package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableMerge
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:08
 * @Description: 两个事务合并处理
 */
public class ObservableMerge {

    private static final String TAG = ObservableMerge.class.getName();

    public void obCreateByMerge(){
        Observable.merge(Observable.just(1, 2), Observable.just(3, 4, 5))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.d(TAG, "accept: merge :" + integer + "\n" );
                    }
                });
    }
}

package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableScan
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:42
 * @Description: scan 操作符作用和上面的 reduce 一致，唯一区别是 reduce 是个只追求结果的坏人，而 scan 会始终如一地把每一个步骤都输出
 */
public class ObservableScan {

    private static final String TAG = ObservableScan.class.getName();

    public void obCreateByScan(){
        Observable.just(1, 2, 3)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "accept: scan " + integer + "\n");
            }
        });
    }

}

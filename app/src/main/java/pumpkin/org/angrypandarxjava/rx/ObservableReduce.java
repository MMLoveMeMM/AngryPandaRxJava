package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableReduce
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:26
 * @Description: 操作符每次用一个方法处理一个值，可以有一个 seed 作为初始值
 * 几个关联的事务共同处理完成后得出一个结论
 */
public class ObservableReduce {

    private static final String TAG = ObservableReduce.class.getName();

    public void obCreateByReduce() {
        Observable.just(1, 2, 3)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d(TAG, "accept: reduce : " + integer + "\n");
            }
        });
    }

}

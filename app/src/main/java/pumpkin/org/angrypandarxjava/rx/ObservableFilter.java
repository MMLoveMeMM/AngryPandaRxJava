package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableFilter
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 11:52
 * @Description: 过滤操作符用于过滤和选择Observable发射的数据序列。让Observable只返回满足我们条件的数据。
 * 过滤操作符有buffer，filter，skip，take，skipLast，takeLast等等，这边我会介绍到filter，buffer，skip，take，distinct

 */
public class ObservableFilter {
    private static final String TAG = ObservableFilter.class.getName();

    public void obCreateAddFilter(){

        Observable.just(1,2,3).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 3;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) throws Exception {
                Log.d(TAG, "accept: " + s);
            }
        });
    }

}

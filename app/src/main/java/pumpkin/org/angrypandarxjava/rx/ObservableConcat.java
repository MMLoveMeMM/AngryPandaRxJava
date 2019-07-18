package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableConcat
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:45
 * @Description: 将多个Observable发射的数据进行合并并且发射，和merge不同的是，merge是无序的，
 * 而concat是有序的。（串行有序）没有发射完前一个它一定不会发送后一个
 */
public class ObservableConcat {

    private static final String TAG = ObservableConcat.class.getName();

    public void obCreateAddConcat(){
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<Integer> observable2=Observable.just(4,5,6);
        Observable.concat(observable1,observable2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "accept: "+integer);
            }
        });
    }

}

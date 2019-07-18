package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableZip
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:46
 * @Description: 此操作符和合并多个Observable发送的数据项，根据他们的类型就行重新变换，并发射一个新的值
 */
public class ObservableZip {
    private static final String TAG = ObservableZip.class.getName();

    public void obCreateAddZip(){
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<String> observable2=Observable.just("a","b","c");
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer+s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i(TAG, "apply: "+s);
            }
        });
    }

}

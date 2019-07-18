package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableConcatEager
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:51
 * @Description: java类作用描述
 */
public class ObservableConcatEager {

    private static final String TAG = ObservableConcatEager.class.getName();

    public void obCreateAddConcatEager(){
        Observable<Integer> observable1=Observable.just(1,2,3);
        Observable<String> observable2=Observable.just("a","b","c");
        Observable.concatEager(Observable.fromArray(observable1,observable2)).subscribe(new Consumer<Serializable>() {
            @Override
            public void accept(Serializable serializable) throws Exception {
                Log.i(TAG, "accept: "+serializable);
            }
        });
    }

}

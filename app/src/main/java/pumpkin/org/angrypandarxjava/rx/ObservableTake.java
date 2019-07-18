package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableTake
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:43
 * @Description: 而take操作则只取前n项
 */
public class ObservableTake {

    private static final String TAG = ObservableTake.class.getName();

    public void obCreateAddTake(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .take(3).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer strings) throws Exception {
                Log.i(TAG, "accept: " + strings);
            }
        });
    }

}

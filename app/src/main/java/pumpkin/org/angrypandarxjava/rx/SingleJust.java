package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: SingleJust
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 20:43
 * @Description: java类作用描述
 */
public class SingleJust {

    private static final String TAG = SingleJust.class.getName();

    public void SingleByJust(){
        Single.just(10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.d(TAG,"Single2  just onSuccess"+integer);
                    }
                });
    }

}

package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableSkip
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:41
 * @Description: skip操作符将源Observable发射过的数据过滤掉前n项
 */
public class ObservableSkip {

    private static final String TAG = ObservableSkip.class.getName();

    public void obCreateAddSkip(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .skip(2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer strings) throws Exception {
                Log.i(TAG, "accept: " + strings);
            }
        });
    }

}

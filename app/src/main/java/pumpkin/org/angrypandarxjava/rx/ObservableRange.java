package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableRange
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 10:33
 * @Description: Range() 它接受两个参数，一个是范围的起始值，一个是范围的数据的数目。
 * 如果你将第二个参数设为0，将导致Observable不发射任何数据（如果设置为负数，会抛异常）
 */
public class ObservableRange {
    private static final String TAG = ObservableRange.class.getName();

    public void ObCreateByJust(){
        Observable.range(0,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer s) throws Exception {
                        Log.e(TAG,"range : onNext : " + s + "\n" );
                    }
                });
    }
}

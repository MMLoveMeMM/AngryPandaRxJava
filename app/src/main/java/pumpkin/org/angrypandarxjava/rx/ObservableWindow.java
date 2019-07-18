package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableWindow
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 10:47
 * @Description: 按照实际划分窗口，将数据发送给不同的 Observable---这个东西不怎么好用.
 */
public class ObservableWindow {

    private static final String TAG = ObservableWindow.class.getName();

    public void obCreateWindow(){
        Observable.interval(1, TimeUnit.SECONDS) // 间隔一秒发一次
                .take(15) // 最多接收15个
                .window(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Observable<Long>>() {
                    @Override
                    public void accept(@NonNull Observable<Long> longObservable) throws Exception {
                        Log.d(TAG, "Sub Divide begin...\n");
                        longObservable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(@NonNull Long aLong) throws Exception {
                                        Log.d(TAG, "Next:" + aLong + "\n");
                                    }
                                });
                    }
                });
    }
}

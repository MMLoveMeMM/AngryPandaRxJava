package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableEmpty
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 20:12
 * @Description: 创建一个不发射任何数据但是正常终止的Observable
 */
public class ObservableEmpty {
    private static final String TAG = ObservableEmpty.class.getName();
    public ObservableEmpty(){

    }

    public void ObCreateByEmpty(){
        Observable.empty()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void ObCreateByNever(){
        Observable.never()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void ObCreateByError(){
        Observable.error(new Throwable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}

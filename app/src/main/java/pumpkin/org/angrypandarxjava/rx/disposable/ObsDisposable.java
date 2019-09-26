package pumpkin.org.angrypandarxjava.rx.disposable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObsDisposable
 * @Author: 刘志保
 * @CreateDate: 2019/9/26 17:12
 * @Description: 当Observable发送数据，Observer订阅数据时，就形成一个Disposable，可用于在退出时取消订阅
 * CompositeDisposable 一个复合订阅容器，用于管理所有的Disposable，方便在退出时取消订阅，避免内存溢出。
通常写在BaseActivity中
 */
public class ObsDisposable {

    public ObsDisposable(){
        CompositeDisposable compositeDisposable = new CompositeDisposable();



    }

    public void ObsDisposableTest1(){
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable = Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer + 1;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });
        //添加Disposable到容器统一管理
        compositeDisposable.add(disposable);
        //当退出时，如onDestory中调用，取消所有订阅
        compositeDisposable.clear();
    }

    public void ObsDisposableTest(){
        Disposable disposable = Observable.just(1,2,3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer + 1;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 取消订阅
        disposable.dispose();

    }

}

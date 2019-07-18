package pumpkin.org.angrypandarxjava.rx;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: SingleCreate
 * @Author: 刘志保
 * @CreateDate: 2019/7/17 20:36
 * @Description: Single/SingleObserver观察者模式可以当做Observable&Observer的扩展版本。
Single的创建，SingleObserver的创建，以及订阅方法都雷同。区别只在于SingleObserver的创建。SingleObserver需要实现的方法没有onNext(Object o)
onComplete(),只有了onSuccess（Object o）,onSuccess（Object o)像是两者的结合体
 */
public class SingleCreate {
    private static final String TAG = SingleCreate.class.getName();

    public void singleCreate(){
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception {
                // e.onNext(); 没有这两种回调了,以onSuccess替代了
                // e.onComplete();
                e.onSuccess("----Single 1");//发送数据，并结束事件流
                e.onSuccess("----Single 2");// 已经结束,无效发射
                e.onSuccess("----Single 3");// 同上
            }
        }).subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG,"Single1    onSubscribe"  );
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Log.d(TAG,"Single1    onSuccess" +s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }
}

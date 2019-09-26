package pumpkin.org.angrypandarxjava.rx.transformer;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: FlowableTransformerA
 * @Author: 刘志保
 * @CreateDate: 2019/9/26 17:02
 * @Description: 可通过一个Transformer转换器将Observable/Flowable/Completable/Maybe/Single转换为另一个Observable/Flowable/Completable/Maybe/Single。
转换器：ObservableTransformer，FlowableTransformer，CompletableTransformer，MaybeTransformer，SingleTransformer
 */
public class FlowableTransformerA {

    //切换线程
    public static <T> FlowableTransformer<T,T> transToMain(){

        return new FlowableTransformer<T, T>() {
            //返回一个在io线程发送数据，在main线程处理数据的Publisher
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public void FlowableTransformerATest(){
        Flowable.interval(1000, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .compose(transToMain())
                .subscribe();
    }



}

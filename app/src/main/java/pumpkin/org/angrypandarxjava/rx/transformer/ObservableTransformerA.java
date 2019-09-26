package pumpkin.org.angrypandarxjava.rx.transformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableTransformerA
 * @Author: 刘志保
 * @CreateDate: 2019/9/26 16:56
 * @Description: 可通过一个Transformer转换器将Observable/Flowable/Completable/Maybe/Single转换为另一个Observable/Flowable/Completable/Maybe/Single。
转换器：ObservableTransformer，FlowableTransformer，CompletableTransformer，MaybeTransformer，SingleTransformer
 */
public class ObservableTransformerA {
    //数据转换
    public static ObservableTransformer<Integer,String> intToStrTransformer(){
        //Integer转String的转换器
        return new ObservableTransformer<Integer, String>() {
            //返回一个发射String数据的Observable
            @Override
            public ObservableSource<String> apply(Observable<Integer> upstream) {
                return upstream.map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer.toString();
                    }
                });
            }
        };
    }

    public void ObservableTransformerATest(){
        Observable.just(1,2,3)
                .compose(intToStrTransformer())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
    }

}

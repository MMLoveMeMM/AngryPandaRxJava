package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: ObservableBuffer
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 19:37
 * @Description: 这个其实也不难，主要是缓存，把源Observable转换成一个新的Observable。
 * 这个新的Observable每次发射的是一组List，而不是单独的一个个的发送数据源---不好用
 */
public class ObservableBuffer {
    private static final String TAG = ObservableBuffer.class.getName();

    public void obCreateAddBuffer(){
        Observable.just(1,2,3,4,5,6)
                .buffer(2).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> strings) throws Exception {
                for (Integer integer : strings) {
                    Log.i(TAG, "accept: "+integer);
                }
                Log.i(TAG, "accept: ----------------------->");
            }
        });
    }

}

package pumpkin.org.angrypandarxjava.rx;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * @ProjectName: AngryPandaRxJava
 * @ClassName: SubjectCreate
 * @Author: 刘志保
 * @CreateDate: 2019/7/18 11:09
 * @Description:
 *Subject/Observer模式，Subject翻译为主题 , Subject可以支持一个事件流发送过程中，
 * 多个的观察者一起订阅。Subject有四个实现类：AsyncSubject，BehaviorSubject，PublishSubject，ReplaySubject。
值得注意的是一定要用Subcect.create()的方式创建并使用，不要用just(T)、from(T)、create(T)创建，
否则会导致失效,因为just(T)、from(T)、create(T)会把Subject转换为Obserable

 * 简单的说使用AsyncSubject无论输入多少参数，永远只输出最后一个参数
 */
public class SubjectCreate {
    private static final String TAG = SubjectCreate.class.getName();

    public void obCreate(){
        AsyncSubject<Integer> source = AsyncSubject.create();

        source.subscribe(getObserver("First","AsyncSubject"));
        // it will emit only 4 and onComplete
        source.onNext(1);
        source.onNext(2);
        source.onNext(3);
        /*
         * it will emit 4 and onComplete for second observer also.
         */
        source.subscribe(getObserver("Second","AsyncSubject"));
        source.onNext(4);
        source.onComplete();
        /*
         * it will emit nothing.
         */
        source.subscribe(getObserver("Third","AsyncSubject"));
    }

    // BehaviorSubject会发送离订阅最近的上一个值，没有上一个值的时候会发送默认值
    public void bhSubjectCreate(){
        BehaviorSubject<Integer> source = BehaviorSubject.create();

        source.subscribe(getObserver("First","BehaviorSubject"));
        // it will get 1, 2, 3, 4 and onComplete

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        /*
         * it will emit 3(last emitted), 4 and onComplete for second observer also.
         */
        source.subscribe(getObserver("Second","BehaviorSubject"));

        source.onNext(4);
        source.onComplete(); // 后面的将不再执行
        /*
         * it will emit nothing .
         */
        source.subscribe(getObserver("Third","BehaviorSubject"));
    }

    // 可以说是最正常的Subject，从那里订阅就从那里开始发送数据
    public void phSubjectCreate(){
        PublishSubject<Integer> source = PublishSubject.create();

        source.subscribe(getObserver("First","PublishSubject"));
        // it will get 1, 2, 3, 4 and onComplete

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);
        /*
         * it will emit 4 and onComplete for second observer also.
         */
        source.subscribe(getObserver("Second","PublishSubject"));

        source.onNext(4);
        source.onComplete();
        /*
         * it will emit nothing.
         */
        source.subscribe(getObserver("Third","PublishSubject"));
    }

    public void rySubjectCreate(){
        ReplaySubject<Integer> source = ReplaySubject.create();

        source.subscribe(getObserver("First","ReplaySubject")); // it will get 1, 2, 3, 4

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);
        /*
         * it will emit 1, 2, 3, 4 for second observer also as we have used replay
         */
        source.subscribe(getObserver("Second","ReplaySubject"));
        source.onNext(4);
        source.onComplete();

        /*
         * it will emit 1, 2, 3, 4 for second observer also as we have used replay
         */
        source.subscribe(getObserver("Third","ReplaySubject"));
    }

    private Observer<Integer> getObserver(final String id, final String tag) {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"-->"+id+"  onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG,"-->"+id+" onNext : value :"+value);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"-->"+id+"  onError :  "  + e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d(TAG,"-->"+id+"  onComplete  "  );
            }
        };
    }
    
}

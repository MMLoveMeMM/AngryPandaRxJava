package pumpkin.org.angrypandarxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import pumpkin.org.angrypandarxjava.rx.CompletableCreate;
import pumpkin.org.angrypandarxjava.rx.MaybeCreate;
import pumpkin.org.angrypandarxjava.rx.ObCreateTimer;
import pumpkin.org.angrypandarxjava.rx.ObservableBuffer;
import pumpkin.org.angrypandarxjava.rx.ObservableCreate;
import pumpkin.org.angrypandarxjava.rx.ObservableDebounce;
import pumpkin.org.angrypandarxjava.rx.ObservableDefer;
import pumpkin.org.angrypandarxjava.rx.ObservableDistinct;
import pumpkin.org.angrypandarxjava.rx.ObservableFilter;
import pumpkin.org.angrypandarxjava.rx.ObservableInterval;
import pumpkin.org.angrypandarxjava.rx.ObservableJust;
import pumpkin.org.angrypandarxjava.rx.ObservableLast;
import pumpkin.org.angrypandarxjava.rx.ObservableMap;
import pumpkin.org.angrypandarxjava.rx.ObservableMerge;
import pumpkin.org.angrypandarxjava.rx.ObservableReduce;
import pumpkin.org.angrypandarxjava.rx.ObservableScan;
import pumpkin.org.angrypandarxjava.rx.ObservableSubscribe;
import pumpkin.org.angrypandarxjava.rx.ObservableWindow;
import pumpkin.org.angrypandarxjava.rx.ObservableZip;
import pumpkin.org.angrypandarxjava.rx.SingleCreate;
import pumpkin.org.angrypandarxjava.rx.SingleJust;
import pumpkin.org.angrypandarxjava.rx.SubjectCreate;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName();

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button)findViewById(R.id.btn) ;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new ObservableDefer().ObCreateByDefer();
                // new ObservableCreate().ObCreate();
                // new ObservableJust().ObCreateByJust();
                // new ObservableInterval().ObCreateByInterval();
                // new ObservableInterval().ObCreateByIntervalRange();
                // new ObCreateTimer().ObCreateByTimer();
                // new ObservableSubscribe().ObCreateSubscribe();
                // new SingleCreate().singleCreate();
                // new SingleJust().SingleByJust();
                // new CompletableCreate().cbCreate();
                // new ObservableMerge().obCreateByMerge();
                // new ObservableMap().obCreateByMap();
                // new ObservableLast().obCreateByLast();
                // new ObservableReduce().obCreateByReduce();
                // new ObservableDebounce().obCreateByDebounce();
                // new ObservableDistinct().obCreateByDistinct();
                // new ObservableScan().obCreateByScan();
                // new ObservableWindow().obCreateWindow();
                // new MaybeCreate().obCreate();
                // new SubjectCreate().obCreate();
                new ObservableFilter().obCreateAddFilter();
                new ObservableBuffer().obCreateAddBuffer();
                new ObservableZip().obCreateAddZip();
            }
        });

    }

}



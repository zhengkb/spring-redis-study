package com.zkb.springredisstudy.event.annotation;

import com.zkb.springredisstudy.event.scan.SimpleClassScan;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
@Service
public class EventBus {

    private static Map<String, List<Method>> eventAndMethodsMap = new HashMap<>();
    private static ExecutorService executorService = new ThreadPoolExecutor(4,
            8,
            60,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(512),
            new DefaultThreadFactory("EventBus"),
            new ThreadPoolExecutor.AbortPolicy()
    );


    @PostConstruct
    public void initAllEvent() {
        SimpleClassScan scan = new SimpleClassScan();
        Set<Class<?>> classes = scan.scan("com.zkb");
        for (Class<?> aClass : classes) {
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                Subscribe annotation = method.getAnnotation(Subscribe.class);
                if (annotation == null) {
                    continue;
                }
                Parameter[] parameters = method.getParameters();
                if (parameters == null || parameters.length <= 0) {
                    log.info("参数为空：" + method.getName());
                    continue;
                }
                Parameter parameter = parameters[0];
                List<Method> methodList = eventAndMethodsMap.get(parameter.getType().getName());
                if (methodList == null) {
                    methodList = new ArrayList<>();
                    eventAndMethodsMap.put(parameter.getType().getName(), methodList);
                }
                methodList.add(method);
            }
        }
    }

    public static void postEvent(BaseEvent event) {
        List<Method> methods = eventAndMethodsMap.get(event.getClass().getName());
        if (CollectionUtils.isEmpty(methods)) {
            log.info("methods is null ::" + event.getClass().getName());
            return;
        }
        //use thread to resolve event
        executorService.submit(() -> {
            for (Method method : methods) {
                try {
                    Class<?> declaringClass = method.getDeclaringClass();
                    method.invoke(declaringClass.newInstance(), event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

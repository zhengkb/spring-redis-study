package com.zkb.springredisstudy.event.annotation;

import com.zkb.springredisstudy.event.scan.SimpleClassScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

@Slf4j
@Service
public class EventBus {

    private static Map<String, List<Method>> eventAndMethodsMap = new HashMap<>();


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
                List<Method> methodList = eventAndMethodsMap.get(parameter.getName());
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
        for (Method method : methods) {
            try {
                method.invoke(null, event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

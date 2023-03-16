package com.zkb.springredisstudy.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AutoConfiguredTeacherRegistrar.class)
public @interface EnableTeacherBean  {
}

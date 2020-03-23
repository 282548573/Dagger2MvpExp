package com.example.common_base.di.annotation;

/**
 * Created by sky 2020-03-22.
 */
//public class ActivityScope {
//}
/**
 * Created by key on 2019-05-07.
 * @author key
 */

import javax.inject.Scope;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
public @interface ActivityScope {}
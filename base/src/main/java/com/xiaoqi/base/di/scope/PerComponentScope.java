package com.xiaoqi.base.di.scope;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 * 单个组件的作用域
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerComponentScope {
}

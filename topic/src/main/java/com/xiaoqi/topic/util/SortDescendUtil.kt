package com.xiaoqi.topic.util

import com.xiaoqi.topic.model.bean.Topic

object SortDescendUtil {

    fun sortTopic(topic1: Topic, topic2: Topic): Int {
        return if (TimeUtil.getTimeStamp(topic1.publishDate) > TimeUtil.getTimeStamp(topic2.publishDate)) -1 else 1
    }

}
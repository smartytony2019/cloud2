package com.xinbo.cloud.common.Util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class MapperUtil {

    /**
     * domain转换dto
     * @param source domain类
     * @param target dto类
     * @param <Source>
     * @param <Target>
     * @return
     */
    public static <Source, Target> Target to(Source source, Class<Target> target) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper.map(source,target);
    }

}

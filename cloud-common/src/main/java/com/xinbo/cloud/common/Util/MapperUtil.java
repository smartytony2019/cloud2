package com.xinbo.cloud.common.Util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

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

    /**
     * domain转换dto
     * @param source domain类
     * @param target dto类
     * @param <Source>
     * @param <Target>
     * @return
     */
    public static <Source, Target> List<Target> many(List<Source> source, Class<Target> target) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();

        List<Target> list =  Lists.transform(source, new Function<Source, Target>() {
            @Nullable
            @Override
            public Target apply(@Nullable Source source) {
                return mapper.map(source, target);
            }
        });

        return list;
    }
}

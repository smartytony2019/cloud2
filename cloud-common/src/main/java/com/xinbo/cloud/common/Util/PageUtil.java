package com.xinbo.cloud.common.Util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.xinbo.cloud.common.dto.PageDto;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;

public class PageUtil {


    /**
     * 分页转换
     * @param pageInfo
     * @param target
     * @param <Source>
     * @param <Target>
     * @return
     */
    public static <Source, Target> PageDto<Target> to(PageInfo<Source> pageInfo, Class<Target> target) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();

        //Step 1: 将domain 转成 dto
        List<Source> sourceList = pageInfo.getList();
        List<Target> list =  Lists.transform(sourceList, new Function<Source, Target>() {
            @Nullable
            @Override
            public Target apply(@Nullable Source source) {
                return mapper.map(source, target);
            }
        });
        long total = pageInfo.getTotal();

        //Step 2: 构建结果
        PageDto<Target> pageDto = PageDto.<Target>builder().list(list).total(total).build();
        return pageDto;
    }
}

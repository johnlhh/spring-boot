package com.smartzhe.core.datasource.dynic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by luohuahua on 17/8/4.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

}
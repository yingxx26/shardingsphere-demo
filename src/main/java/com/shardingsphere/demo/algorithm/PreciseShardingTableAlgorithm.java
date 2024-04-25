/*
 * Copyright © 2016 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.shardingsphere.demo.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;


/**
 * 自定义实现 精准分片算法（PreciseShardingAlgorithm）接口.
 * 数据表table的精准分片.
 *
 * @author Peng zhizhong.
 * @version 1.0
 * fileName PreciseShardingTableAlgorithm
 * createTime 2020/5/11  19:21
 */
public class PreciseShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 注释键 PreciseShardingDBAlgorithm
     *
     * @param tableNames
     * @param shardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> tableNames,
                             PreciseShardingValue<Long> shardingValue) {
        for (String key : tableNames) {
            if (key.endsWith(String.valueOf(shardingValue.getValue() % tableNames.size()))) {
                System.out.println("key" + key);
                return key;
            }
        }
        throw new UnsupportedOperationException();
    }

}

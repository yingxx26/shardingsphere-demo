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

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 自定义实现 范围分片算法（RangeShardingAlgorithm）接口
 * 数据表 table 的范围分片
 *
 * @author Peng zhizhong
 * @version 1.0
 * fileName RangeShardingTableAlgorithm
 * createTime 2020/5/11  19:21
 */
public class RangeShardingTableAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(final Collection<String> tableNames,
                                         final RangeShardingValue<Integer> shardingValue) {
        Set<String> result = new LinkedHashSet<>();
        // 如果between  2000000 and 7000000
        //if (Range.closed(2000000, 7000000).encloses(shardingValue.getValueRange())) {
        for (String each : tableNames) {
            // if (each.endsWith("0")) {
            result.add(each);
            //  }
        }
        /*} else {
            throw new UnsupportedOperationException();
        }*/
        return result;
    }

}
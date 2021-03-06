/*
 *       Copyright© (2020) blockmap Co., Ltd.
 *
 *       This file is part of did-core.
 *
 *       did-core is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       did-core is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with did-core.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.blockmap.did.core.suite.encode;

import com.blockmap.did.core.exception.EncodeSuiteException;
import com.blockmap.did.core.suite.api.transportation.params.EncodeType;

import java.util.HashMap;
import java.util.Map;

/**
 * 编解码工厂,用于获取编解码处理器.
 * @author admin@xuzhijun.com.cn
 *
 */
public class EncodeProcessorFactory {
    
    /**
     * 编解码处理器配置Map,目前支持原文和密文.
     */
    private static final Map<String, EncodeProcessor> encode_processor_map =
        new HashMap<String, EncodeProcessor>();
    
    static { 
        encode_processor_map.put(EncodeType.ORIGINAL.name(), new OriginalEncodeProcessor());
        encode_processor_map.put(EncodeType.CIPHER.name(), new CipherEncodeProcessor());
    }

    /**
     * 根据编解码枚举获取编解码处理器.
     * @param encodeType 编解码枚举
     * @return 编解码处理器
     */
    public static EncodeProcessor getEncodeProcessor(EncodeType encodeType) {
        EncodeProcessor encodeProcessor = encode_processor_map.get(encodeType.name());
        if (encodeProcessor == null) {
            throw new EncodeSuiteException();
        }
        return encodeProcessor;
    }
}

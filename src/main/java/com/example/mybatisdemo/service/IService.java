package com.example.mybatisdemo.service;/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IService<T> {
    /**
     *通用查询接口
     * @param key 查询关键字
     * @return 任意类型
     */
    T selectByKey(Object key);

    /**
     *通用保存接口
     * @param entity 任意类型
     * @return 整型
     */
    int save(T entity);

    /**
     * 通用保存查询接口
     * @param entity 任意类型
     * @return 整型
     */
    int saveSelective(T entity);

    /**
     * 通用删除接口
     * @param key 删除关键字
     * @return 整型
     */
    int delete(Object key);

    /**
     * 通用更新全部接口
     * @param entity 任意类型
     * @return 整型
     */
    int updateAll(T entity);

    /**
     * 通用更新部分接口
     * @param entity 任意类型
     * @return 整型
     */
    int updateNotNull(T entity);

    /**
     *通用查询接口
     * @param example 查询关键字
     * @return 任意类型列表
     */
    List<T> selectByExample(Object example);

    //TODO 其他...
}

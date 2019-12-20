package com.guosiyang.interfaces;

/**
 * Created by admin on 2019/12/20.
 */

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: ��˼��
 * @date: 2019-12-15
 * @sign: ��������, ��������
 * @description: �����ݲ����ṩ��ؽӿ�
 */
public interface OperateMapDataAble<K,V> extends OperatorAble {
    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ��ѯ�����ؽӿ�(���ӳ���ѯ)
     */
    public abstract V query(K key);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ��ѯ�Ƿ���ڽӿ� TRUE Ϊ���� FLASEΪ������
     */
    public abstract TrueFlagEnum exist(K key);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ���½ӿڲ����з����Ƿ���ȷ����
     */
    public abstract TrueFlagEnum update(K key,V value);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ�����ӿ�
     */
    public abstract TrueFlagEnum add(K key,V value);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ�����ӿ�
     */
    public abstract TrueFlagEnum delete(K key,V value);

//    /**
//     * @author ��˼��
//     * @date 2019-12-08
//     * @description �ṩĬ�Ϸ������п��Զ�ʵ�ָýӿڵĴ����Ӧ�Ĳ��������в���
//     */
//    public  static <K,V> Object  operateData(OperateMapDataAble<K,V> operateMapDataAble,String operate,Object...mehtodParams){
//        if (operateMapDataAble ==null || operate==null || "".equals(operate))
//            throw new NullPointerException("�������Ϊ��");
//        Class<OperateMapDataAble<K,V>> operateMapDataAbleClass= (Class<OperateMapDataAble<K, V>>) operateMapDataAble.getClass();
//        operateMapDataAbleClass
//
//    }
}

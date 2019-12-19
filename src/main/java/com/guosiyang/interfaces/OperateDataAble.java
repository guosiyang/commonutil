package com.guosiyang.interfaces;

import com.guosiyang.constant.codeEnum.CodeList.TrueFlagEnum;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: ��˼��
 * @date: 2019-12-15
 * @sign: ��������, ��������
 * @description: �����ݲ����ṩ��ؽӿ�
 * @think : ��������ر�����Ƹýӿ� ��Ϊ�Ҹо������ʼ����һ�ֹ����Ż���ʵ��
 * ��Ϊ���ǿ���ֱ�Ӷ����ݽṹ���иĽӿڵĲ���, ��������
 * ���ڴ󲿷ִ洢�����ݽṹ���ǲ���ϣ���û���ֱ���õ������������
 * ���Ǳ�¶���û�һ�������ڷ��������в�ѯ�Լ���������ع��� �ʶ��ڲ������û�ֱ�Ӳ�����ش洢�����ݽṹ
 * �ṩһ�ֲ������� ����ɾ�Ĳ�
 */
public interface OperateMapDataAble<K,V> extends OperatorAble {
    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ��ѯ�����ؽӿ�(���ӳ���ѯ)
     */
    abstract V query(K key);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ��ѯ�Ƿ���ڽӿ� TRUE Ϊ���� FLASEΪ������
     */
    abstract TrueFlagEnum exist(K key);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ���½ӿڲ����з����Ƿ���ȷ����
     */
    abstract TrueFlagEnum update(K key,V value);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ�����ӿ�
     */
    abstract TrueFlagEnum add(K key,V value);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩ�����ӿ�
     */
    abstract TrueFlagEnum delete(K key,V value);

    /**
     * @author ��˼��
     * @date 2019-12-08
     * @description �ṩĬ�Ϸ������п��Զ�ʵ�ָýӿڵĴ����Ӧ�Ĳ��������в���
     */
    public  static <T> Object  operateData(OperateMapDataAble<K,V> operateDataAble,String operate){
        if (operateDataAble ==null || operate==null || "".equals(operate))
            throw new NullPointerException("�������Ϊ��");
    }
}

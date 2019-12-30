package com.guosiyang.util;

import java.io.*;

/**
 * @program: commonutil
 * @className: OperateDataAble
 * @version: 1.0
 * @author: ��˼��
 * @date: 2019-12-15
 * @sign: ��������, ��������
 * @description: Ϊ�����ṩ��clone
 */
public class SerializedClone {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            //д���ֽ���
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            //�����ڴ棬д��ԭʼ���������¶���
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //�������ɵ��¶���
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}

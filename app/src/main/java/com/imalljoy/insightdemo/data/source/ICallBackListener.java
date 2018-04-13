package com.imalljoy.insightdemo.data.source;

/**
 * Created by lijilong on 03/06.
 */

public interface ICallBackListener {

    /**
     * 成功时的返回数据
     *
     * @param data 根据传入类去解析后返回的实体
     * @param r  所有数据，包括msg，status
     * @param url  通过返回url做标识，在一个页面判断多个接口的返回处理逻辑
     */
    public void onSuccess(Object data,String message);
    public void onFaild(String message);
    public void onCompleted(String url);
    public void onError(String url);
}

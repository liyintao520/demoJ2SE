package com.lyt.async;

import com.lyt.async.CakeBaker;
import com.lyt.async.Cake;
/**
 * @Description: 提货单
 * @author liyintao
 * @date 2016年10月25日 下午16:25:06
 * @version 1.0
 */
public class DeliveryOrder implements Cake {
	private CakeBaker cakeBaker = null;

	private boolean ready = false;

	public synchronized void setCakeBaker(CakeBaker cakeBaker) {
		if (ready) {
			return; // 防止setCakeBaker被调用两次以上。
		}
		this.cakeBaker = cakeBaker;
		this.ready = true;
		notifyAll();
	}

	public synchronized String getCake() {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return cakeBaker.getCake();
	}

}

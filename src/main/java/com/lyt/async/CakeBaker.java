package com.lyt.async;

import com.lyt.async.CakeBaker;

/**
 * @Description: 蛋糕师傅
 * @author liyintao
 * @date 2016年10月25日 下午16:25:06
 * @version 1.0
 */
public class CakeBaker implements Cake {
	private final String cake;

	public CakeBaker(int count, char c) {
		System.out.println("making cake(" + count + ", " + c + ") BEGIN");
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("making cake(" + count + ", " + c + ") END");
		this.cake = new String(buffer);
	}

	public String getCake() {
		return cake;
	}

}

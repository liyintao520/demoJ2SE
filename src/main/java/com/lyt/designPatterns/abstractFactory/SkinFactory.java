package com.lyt.designPatterns.abstractFactory;
/**
 * @Title: SkinFactory.java
 * @Package com.lyt.designPatterns.abstractFactory
 * @Description: TODO
 * @author liyintao
 * @date 2016年10月31日 下午16:59:25
 * @version V1.0
 */
//界面皮肤工厂接口：抽象工厂
public interface SkinFactory {
	public Button createButton();
	public TextField createTextField();
	public ComboBox createComboBox();
}
//Spring皮肤工厂：具体工厂
class SpringSkinFactory implements SkinFactory{
	@Override
	public Button createButton() {
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}

	@Override
	public ComboBox createComboBox() {
		return new SpringComboBox();
	}
	
}

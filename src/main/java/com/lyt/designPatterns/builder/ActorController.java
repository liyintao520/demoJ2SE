package com.lyt.designPatterns.builder;

/**
 * @Title: ActorController.java
 * @Package com.lyt.designPatterns.builder
 * @Description: TODO
 * @author liyintao
 * @date 2016年11月01日 下午4:40:21
 * @version V1.0
 */
/**游戏角色创建控制器：指挥者*/ 
public class ActorController {
	//逐步构建复杂产品对象
	public Actor construct(ActorBuilder ab) {
		ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        Actor actor = ab.createActor();
        return actor;
	}
}
